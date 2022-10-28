<%--
  Created by IntelliJ IDEA.
  User: Whitehat
  Date: 2022/9/30
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
    + request.getServerPort() + request.getContextPath() + "/";

%>

<base href="<%=basePath%>">

<html>
<head>
</head>
<body>


    你访问的页面不存在或者被删除 <br> <a href="index.jsp">返回主页</a>

</body>
</html>
