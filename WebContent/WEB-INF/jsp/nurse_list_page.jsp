<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nurse list page</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function toMain() {
		window.location.assign("http://localhost:8080/workstation/Main");
	}
	function deleteNurse(id) {
			alert(id);
			window.location.assign("http://localhost:8080/workstation/Nurse/delete?id="+id);
	}
</script>
<body>
	<div>
		<input type="button" value="返回" onclick="toMain()">
	</div>
	<div>
		<table id="list" border="1">
			<tr>
				<td>姓名</td>
				<td>修改時間</td>
				<td>動作</td>
			</tr>
			<c:forEach var="nurse" items="${list}">
				<tr>
					<td>${nurse.name}</td>
					<td>${nurse.updateTime}</td>
					<td><a href="http://localhost:8080/workstation/Nurse/view?id=${nurse.id}">view</a> <a href="#" onclick="deleteNurse(${nurse.id})">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>