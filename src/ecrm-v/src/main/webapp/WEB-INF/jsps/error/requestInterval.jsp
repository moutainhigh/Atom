<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsps/layout/base-header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>重复提交请求</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  </head>
  
  <body> 
    <div class="errorContainer">
        <h2>${requestScope.intervaltime}秒之内请勿重复请求 </h2>
    </div>
  </body>
</html>