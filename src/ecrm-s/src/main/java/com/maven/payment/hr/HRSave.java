package com.maven.payment.hr;

import java.util.HashMap;
import java.util.Map;

import com.hy.pull.common.util.Encrypt;
import com.maven.util.JSONUnit;

import net.sf.json.JSONObject;

/**
 * 华仁支付
 * @author klay
 *
 */
public class HRSave {
    /**
     * 网银订单支付接口 协议包编码
     */
    private static final String PAGE_CODE = "1001";

    public HRSave() {}
    /**
     * 获取支付请求URL
     * @param merchant
     * @param order
     * @return
     * @throws Exception 
     */
    public String getUrl(HRMerchantConfig merchant, HROrderConfig order) throws Exception { 
        String sign = getRequestSign(merchant, order);
        JSONObject data = new JSONObject();
        data.put(HRAppConstants.p1_v_pagecode, HRSave.PAGE_CODE);
        data.put(HRAppConstants.p1_v_mid, merchant.getMerNo());
        data.put(HRAppConstants.p1_v_oid, order.getV_oid());
        data.put(HRAppConstants.p1_v_rcvname, "rcvname");
        data.put(HRAppConstants.p1_v_rcvaddr, "rcvaddr");
        data.put(HRAppConstants.p1_v_rcvtel, "13513512345");
        data.put(HRAppConstants.p1_v_goodsname, "Goods");
        data.put(HRAppConstants.p1_v_goodsdescription, "GoodsDescription");
        data.put(HRAppConstants.p1_v_rcvpost, "10021");
        data.put(HRAppConstants.p1_v_qq, "1254545");
        data.put(HRAppConstants.p1_v_amount, order.getV_amount());
        data.put(HRAppConstants.p1_v_ymd, order.getV_oid().split("-")[0]);
        data.put(HRAppConstants.p1_v_orderstatus, "1");
        data.put(HRAppConstants.p1_v_ordername, "OrderName");
        data.put(HRAppConstants.p1_v_bankno, order.getV_bankno());
        data.put(HRAppConstants.p1_v_moneytype, order.getV_moneytype());
        data.put(HRAppConstants.p1_v_url, merchant.getReturnUrl());
        data.put(HRAppConstants.p1_v_noticeurl, merchant.getNotiUrl());
        data.put(HRAppConstants.p1_v_md5info, sign);
        String originalData = "[" + data.toString() + "]";
        System.out.println("rsa原文：\n" + originalData);
        
        System.out.println("rsa公钥：\n" + merchant.getHRRsaPublicKey());
        String rsa = RSAClient.encode(originalData, merchant.getHRRsaPublicKey()); // 使用华仁的公匙进行RSA加密
        System.out.println("rsa密文：\n"+rsa);
        
        StringBuffer url = new StringBuffer();
        url.append(merchant.getPayUrl()).append("?state=0")
        .append("&mid=").append(merchant.getMerNo())
        .append("&data=").append(rsa);
        
        System.out.println("生成的完整URL：\n"+url);
        return url.toString();
    }
    /**
     * MD5签名
     * @param merchant
     * @param order
     * @return
     */
    public static String getRequestSign(HRMerchantConfig merchant, HROrderConfig order) {
//        v_md5info是所有列的值进行加密得到的（不包含本身），不能有空格。所有参与加密的参数加上v_MD5key进行MD5加密生成签名串v_sign，按照文档的顺序进行加密。
//        对data参数进行rsa加密：
//        1、请使用我们提供的加密密钥生成器，生成商户的公钥和私钥；
//        2、公钥提供给我们，我们将用这个公钥进行数据加密，发送给你们，你们用你们的私钥解密，
//        3、当然，我们也会提供我们的公钥给你们，你们的数据用我们的公钥加密，发送给我们。
//        4、加密是吧json串整体加密，解密也是解密整体json串，就是data的值是rsa加密的。
        StringBuffer sb = new StringBuffer();
        sb.append(HRAppConstants.p1_v_pagecode).append(HRSave.PAGE_CODE)
        .append(HRAppConstants.p1_v_mid).append(merchant.getMerNo())
        .append(HRAppConstants.p1_v_oid).append(order.getV_oid())
        .append(HRAppConstants.p1_v_rcvname).append(merchant.getMerNo())
        .append(HRAppConstants.p1_v_rcvaddr).append(merchant.getMerNo())
        .append(HRAppConstants.p1_v_rcvtel).append(merchant.getMerNo())
        .append(HRAppConstants.p1_v_goodsname).append(order.getV_goodsname())
        .append(HRAppConstants.p1_v_goodsdescription).append(order.getV_goodsdescription())
        .append(HRAppConstants.p1_v_rcvpost).append(merchant.getMerNo())
        .append(HRAppConstants.p1_v_qq).append(order.getV_qq())
        .append(HRAppConstants.p1_v_amount).append(order.getV_amount())
        .append(HRAppConstants.p1_v_ymd).append(order.getV_oid().split("-")[0])
        .append(HRAppConstants.p1_v_orderstatus).append("1")
        .append(HRAppConstants.p1_v_ordername).append(merchant.getMerNo())
        .append(HRAppConstants.p1_v_bankno).append(order.getV_bankno())
        .append(HRAppConstants.p1_v_moneytype).append(order.getV_moneytype())
        .append(HRAppConstants.p1_v_url).append(merchant.getReturnUrl())
        .append(HRAppConstants.p1_v_noticeurl).append(merchant.getNotiUrl());
        
        System.out.println("签名原文="+sb.toString());
        System.out.println("Md5Key="+merchant.getMd5Key());
        String sign = Encrypt.MD5(sb.toString().concat(merchant.getMd5Key()));
        System.out.println("签名密文="+sign);
        return sign;
    }
    /**
     * 结果通知回参做签名校验
     * @param request
     * @param md5Key 签名的md5key
     * @return
     */
    public static boolean checkResponseSign(String params) {
        if (params.startsWith("[") && params.endsWith("]"))
            params = params.substring(1, params.length() - 1);
        Map<String, String> data = new HashMap<String, String>();
        data = JSONUnit.getMapFromJsonNew(params);
        String pagecode = data.get(HRAppConstants.p2_v_pagecode);
        String mid = data.get(HRAppConstants.p2_v_mid);
        String oid = data.get(HRAppConstants.p2_v_oid);
        String orderid = data.get(HRAppConstants.p2_v_orderid);
        String bankno = data.get(HRAppConstants.p2_v_bankno);
        String result = data.get(HRAppConstants.p2_v_result);
        String value = data.get(HRAppConstants.p2_v_value);
        String realvalue = data.get(HRAppConstants.p2_v_realvalue);
        String qq = data.get(HRAppConstants.p2_v_qq);
        String telephone = data.get(HRAppConstants.p2_v_telephone);
        String goodsname = data.get(HRAppConstants.p2_v_goodsname);
        String goodsdescription = data.get(HRAppConstants.p2_v_goodsdescription);
        String extmsg = data.get(HRAppConstants.p2_v_extmsg);
        String resultmsg = data.get(HRAppConstants.p2_v_resultmsg);
        String sign = data.get(HRAppConstants.p2_v_sign);
        
        StringBuffer sb = new StringBuffer();
        sb.append(HRAppConstants.p2_v_pagecode).append(pagecode)
        .append(HRAppConstants.p2_v_mid).append(mid)
        .append(HRAppConstants.p2_v_oid).append(oid)
        .append(HRAppConstants.p2_v_orderid).append(orderid)
        .append(HRAppConstants.p2_v_bankno).append(bankno)
        .append(HRAppConstants.p2_v_result).append(result)
        .append(HRAppConstants.p2_v_value).append(value)
        .append(HRAppConstants.p2_v_realvalue).append(realvalue)
        .append(HRAppConstants.p2_v_qq).append(qq)
        .append(HRAppConstants.p2_v_telephone).append(telephone)
        .append(HRAppConstants.p2_v_goodsname).append(goodsname)
        .append(HRAppConstants.p2_v_goodsdescription).append(goodsdescription)
        .append(HRAppConstants.p2_v_extmsg).append(extmsg)
        .append(HRAppConstants.p2_v_resultmsg).append(resultmsg);
        
        String encrypt = Encrypt.MD5(sb.toString().concat(RSAClient.MD5Key));
        return encrypt.equals(sign);
    }
}