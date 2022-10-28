<%--
  Created by IntelliJ IDEA.
  User: Whitehat
  Date: 2022/10/5
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%--分页条的开始--%>
<div id="page_nav">
    <%--大于首页，才显示--%>
    <c:if test="${requestScope.page.noPage > 1}">
        <a href="${ requestScope.page.url }&noPage=1">首页</a>
        <a href="${ requestScope.page.url }&noPage=${requestScope.page.noPage-1}">上一页</a>
    </c:if>
    <%--页码输出的开始--%>
    <c:choose>
        <%--情况 1：如果总页码小于等于 5 的情况，页码的范围是：1-总页码--%>
        <c:when test="${ requestScope.page.totalPageCount <= 5 }">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.totalPageCount}"/>
        </c:when>
        <%--情况 2：总页码大于 5 的情况--%>
        <c:when test="${requestScope.page.totalPageCount > 5}">
            <c:choose>
                <%--小情况 1：当前页码为前面 3 个：1，2，3 的情况，页码范围是：1-5.--%>
                <c:when test="${requestScope.page.noPage <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况 2：当前页码为最后 3 个，8，9，10，页码范围是：总页码减 4 - 总页码--%>
                <c:when test="${requestScope.page.noPage > requestScope.page.totalPageCount-3}">
                    <c:set var="begin" value="${requestScope.page.totalPageCount-4}"/>
                    <c:set var="end" value="${requestScope.page.totalPageCount}"/>
                </c:when>
                <%--小情况 3：4，5，6，7，页码范围是：当前页码减 2 - 当前页码加 2--%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.noPage-2}"/>
                    <c:set var="end" value="${requestScope.page.noPage+2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.noPage}">
            【${i}】
        </c:if>
        <c:if test="${i != requestScope.page.noPage}">
            <a href="${ requestScope.page.url }&noPage=${i}">${i}</a>
        </c:if>
    </c:forEach>
    <%--页码输出的结束--%>
    <%-- 如果已经 是最后一页，则不显示下一页，末页 --%>
    <c:if test="${requestScope.page.noPage < requestScope.page.totalPageCount}">
        <a href="${ requestScope.page.url }&noPage=${requestScope.page.noPage+1}">下一页</a>
        <a href="${ requestScope.page.url }&noPage=${requestScope.page.totalPageCount}">末页</a>
    </c:if>
    共${ requestScope.page.totalPageCount }页，${ requestScope.page.totalCount }条记录
    到第<input value="${param.noPage}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
// 跳到指定的页码
            $("#searchPageBtn").click(function () {
                var noPage = $("#pn_input").val();
                <%--var totalPageCount = ${requestScope.page.totalPageCount};--%>
                <%--alert(totalPageCount);--%>
// javaScript 语言中提供了一个 location 地址栏对象
// 它有一个属性叫 href.它可以获取浏览器地址栏中的地址
// href 属性可读，可写
                location.href = "${pageScope.basePath}${ requestScope.page.url }&noPage=" + noPage;
            });
        });
    </script>
</div>
<%--分页条的结束--%>