<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
	<base href="<%=basepath %>" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${pageinfo.list }" var="q" >
			<tr>
				<td>${q.id }</td>
				<td>${q.question }</td>
				<td>${q.answer }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<a href="question/getQuestionList" >首页</a>
				<c:if test="${pageinfo.hasPreviousPage }">
					<a href="question/getQuestionList?pn=${pageinfo.prePage }" >上一页</a>
				</c:if>
				
				<a href="question/getQuestionList?pn=${pageinfo.nextPage }" >下一页</a>
				<a href="question/getQuestionList?pn=${pageinfo.pages }" >尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>
