<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>station view page</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function toMain() {
		window.location.assign("http://localhost:8080/workstation/Station/listPage");
	}
	function updateStation(id) {
		var name = $("#name").val();
		if (name.trim().length == 0) {
			alert("請輸入名稱");
			return false;
		}
		var url = "http://localhost:8080/workstation/Station/update";
		$.ajax({
			url : url,
			//data : "name=" + name,
			data:{
				id:id,
				name:name
			},
			type : "POST",
			dataType : 'text',
			success : function(historys) {
				alert("更新成功");
			},
			beforeSend : function() {
			},
			complete : function() {
			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert('更新失敗');
			}
		});
	}
</script>
<body>
	<div>
		<input type="button" value="返回" onclick="toMain()"> <input type="button" value="儲存" onclick="updateStation(${station.id})">
	</div>
	<div>
		站點名稱:<input type="text" id="name" value="${station.name}">
	</div>
	<div>
		站點護士列表
		<table border="1">
			<tr>
				<td>員工編號</td>
				<td>員工姓名</td>
				<td>加入時間</td>
			</tr>
			<c:forEach var="nurse" items="${list}">
				<tr>
					<td>${nurse.id}</td>
					<td>${nurse.name}</td>
					<td>${nurse.updateTime}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>