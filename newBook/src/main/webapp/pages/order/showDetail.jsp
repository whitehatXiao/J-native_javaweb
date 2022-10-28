<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Whitehat
  Date: 2022/10/7
  Time: 7:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<%@ include file="/pages/common/head.jsp"%>
<html>
<head>
    <title>showDetail.jsp</title>
</head>
<body>

<%@ include file="/pages/common/login_success_menu.jsp"%>


<div id="main">

    <table>

        <tr>
            <td>名字</td>
            <td>数量</td>
            <td>价格</td>
            <td>总价</td>
        </tr>

        <c:forEach items="${requestScope.orderDetail}" var="orderitem">
        <tr>
            <td>${orderitem.name}</td>
            <td>${orderitem.count}</td>
            <td>${orderitem.price}</td>
            <td>${orderitem.totalPrice}</td>
        </tr>
        </c:forEach>


    </table>


</div>


    
</body>

<%@ include file="/pages/common/footer.jsp"%>
</html>
