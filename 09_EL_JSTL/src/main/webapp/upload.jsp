<%--
  Created by IntelliJ IDEA.
  User: Whitehat
  Date: 2022/9/23
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传页面测试</title>
</head>
<body>

        <form action="http://localhost:8080/09_EL_JSTL/uploadServlet"
              method="post"  enctype="multipart/form-data" >
            用户名 : <input type="text" name="username"> <br>
            上传头像 ：<input type="file" name="photo"> <br>
            提交 : <input type="submit" value="上传">
        </form>

    

</body>
</html>
