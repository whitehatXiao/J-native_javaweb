<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@ include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>



</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>

		<%@ include file="/pages/common/login_success_menu.jsp"%>


	</div>

	<div id="main">

		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>

			<c:if test="${not empty requestScope.myorderlist}">
				<c:forEach items="${requestScope.myorderlist}" var="order">
			<tr>
				<td>${order.createTime.toString()}</td>
				<td>${order.price}</td>
				<td class="showStatus">${order.status}</td>
				<td><a href="orderServlet?action=showOrderDetail">查看详情</a></td>
			</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty requestScope.myorderlist}">
				<tr>
					<td rowspan="4">赶快去购物吧，这里没有你的订单！</td>
				</tr>

			</c:if>


		</table>


	</div>

	<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>