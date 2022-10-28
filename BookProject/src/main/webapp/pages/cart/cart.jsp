<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">

		$(function (){

			$("a.deleteClass").click(function (){

				return confirm("你确定要删除 【 " +  $(this).parent().parent().find("td:first").text()  + "】")

			});

			// 给清空购物车绑定单击事件
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗?");
			})

			// 给输入框绑定 onchange 内容发生改变事件
			// 还有个 onblur() 失去焦点事件，但是对比 onchange ，在于后者能够判断内容是否被更改过，而onblur() 需要自行判断
			$(".updateCount").change(function () {
// 获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				var id = $(this).attr('bookid');
// 获取商品数量
				var count = this.value;
				if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") ) {
//发起请求。给服务器保存修改
					location.href =
							"http://localhost:8080/BookProject/cartServlet?action=updateCount&count="+count+"&id="+id;
				} else {
// defaultValue 属性是表单项 Dom 对象的属性。它表示默认的 value 属性值。
					this.value = this.defaultValue;
				}
			});


		});



	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
					<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
					</c:if>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>


			<c:if test="${empty sessionScope.cart.items}">
				<%--如果购物车空的情况--%>
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空！快跟小伙伴们去浏览商品吧！！！</a>
					</td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<%--如果购物车非空的情况--%>
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input type="text" class="updateCount" style="width: 80px"
								   value="${entry.value.count}" bookid="${entry.value.id}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteClass" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>


		</table>


		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
		</div>
		</c:if>

	</div>

	<%@ include file="/pages/common/footer.jsp"%>


</body>
</html>