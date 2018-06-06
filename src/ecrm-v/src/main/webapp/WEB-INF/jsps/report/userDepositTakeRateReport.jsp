<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/bui-header.jsp"%>
<body style="padding: 10px;">
    <div class="demo-content" >
<!-- 搜索页 ================================================== style=" margin:0 auto;  width:950px;"-->
<form id="searchForm" class="form-horizontal" style="outline: none;" method="post">
 <input name="end_hidden" type="hidden" />
    <div class="row well" style="margin-left: 0px;position: relative;">
      <div style="position: relative;display: inline-block;">
          <div style="float: left;margin-right: 96px;">
             <div class="control-group span13">
                <label class="control-label">时间范围：</label>
                <div class="bui-form-group" data-rules="{dateRange : true}">
                  <input name="startDate"  type="text"   class="calendar calendar-time" placeholder="起始时间"/>
                  <span>&nbsp;-&nbsp;</span>
                  <input  name="endDate" type="text"    class="calendar calendar-time" placeholder="结束时间"/>
                </div>
                <div style="margin-right: auto;margin: -30px 425px;">
							 <select onchange="changeFormatDate(this,'startDate','endDate')"  style="width:85px;">
                                <option value="">请选择</option>
                                <option value="1" selected="selected">今天</option>
                                <option value="2">昨天</option>
                                <option value="3">三天</option>
                                <option value="4">本周</option>
                                <option value="5">上周</option>
                                <option value="6">半月</option>
                                <option value="7">本月</option>
                                <option value="8">上月</option>
                                <option value="9">半年</option>
                                <option value="10">本年</option>
                              </select>
                </div>
            </div>
            
            <div class="control-group span7">
              <label class="control-label">登录账号：</label>
                <input name="loginaccount" type="text" data-tip='{"text":"登录账号"}' class="control-text"   placeholder="登录账号"/>
            </div>
            
          </div>
      	<div style="position: absolute;right: 15px;top: 3px;">
         	 <button id="btnSearch" type="submit"  class="button button-primary"> 搜 索 </button>
        </div>
      </div>
    </div> 
</form>


<div class="search-grid-container well">
  <div id="grid"></div>
</div>
</div>


</body>
</html>
   <script type="text/javascript">
   $(function(){
	   $("input[name='startDate']").val(getDate("begintime"));
	   $("input[name='endDate']").val(getDate("endtime"));	
   		var ranking = 0; 
        var Grid = BUI.Grid,
          Store = BUI.Data.Store,
          columns = [
			{ title: '用户账号',  sortable: false,  dataIndex: 'loginaccount'},
			
			{ title: '存款总额',    sortable: false,dataIndex:'savemoney',renderer:function(value,obj){
          		return parseFloat(value).toFixed(2);
            }},
            { title: '取款总额',     sortable: false,dataIndex:'takemoney',renderer:function(value,obj){
				return parseFloat(value).toFixed(2);
			}},
			{ title: '提存比（金额）',     sortable: false,dataIndex:'takemoney',renderer:function(value,obj){
				var savemoney = obj.savemoney;
            	var takemoney = Math.abs(obj.takemoney);
            	if(savemoney <= 0) {
            		savemoney = savemoney + 1.00;
            	}
            	
            	var rate = (takemoney / savemoney).toFixed(2);
            	if(rate <= 1) {
            		return "<span style='color:blue;font-size: 18px;'>"+(rate * 100).toFixed(2)+"%</span>";
            	} else if(rate >= 10 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （超高风险）</span>";
            	} else if(rate >= 9 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （8级风险）</span>";
            	} else if(rate >= 8 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （7级风险）</span>";
            	} else if(rate >= 7 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （6级风险）</span>";
            	} else if(rate >= 6 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （5级风险）</span>";
            	} else if(rate >= 5 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （4级风险）</span>";
            	} else if(rate >= 4 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （3级风险）</span>";
            	} else if(rate >= 3 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （2级风险）</span>";
            	} else if(rate >= 2 ) {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （1级风险）</span>";
            	} else {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （风险）</span>";
            	}
            	
			}},
			
			
            { title: '存款次数',   sortable: false,  dataIndex: 'savecount'},
            { title: '取款次数',   sortable: false,  dataIndex: 'takecount'},
            { title: '提存比（次数）',    sortable: false,dataIndex:'takemoney',renderer:function(value,obj){
            	var savecount = obj.savecount;
            	var takecount = obj.takecount;
            	if(savecount == 0) {
            		savecount = savecount + 1.00;
            	}
            	
            	var rate = (takecount / savecount).toFixed(2);
            	if(rate <= 1) {
            		return "<span style='color:blue;font-size: 18px;'>"+(rate * 100).toFixed(2)+"%</span>";
            	} else {
            		return "<span style='color:red;font-size: 18px;'>"+(rate * 100).toFixed(2)+"% （风险）</span>";
            	}
			}}
			
          ];
        
        var store = new Store({
            url : '${ctx}/report/queryUserDepositTakeRate',
            autoLoad : false,
            pageSize:15
          }),grid = new Grid.Grid({
            render:'#grid',
            autoRender:true,
            loadMask: true,//加载数据时显示屏蔽层
            forceFit:true,
            columns : columns,
            store: store,
            plugins : [Grid.Plugins.CheckSelection],
            emptyDataTpl:'<div class="centered"><img alt="Crying" src="${statics }/img/dataisnull.png"/><font style="color:red;font-size:20px;"><h2>没有找到匹配的数据!</h2></font></div>',
            bbar : {
              pagingBar:true
            }
          }),datepicker = new BUI.Calendar.DatePicker({
              trigger:'.calendar-time',
              showTime:true,
              autoRender:true
           });
 		
        $("#searchForm").submit(function(){
      	  var obj = BUI.FormHelper.serializeToObject(this);
            obj.start = 0;
            store.load(obj);
      	  return false;
        }).submit();
        
   })
    </script>