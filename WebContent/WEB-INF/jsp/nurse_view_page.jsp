<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nurse view page</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function toMain() {
		window.location.assign("http://localhost:8080/workstation/Nurse/listPage");
	}
	function updateNurse(id) {
		var newId = $("#id").val();
		var name = $("#name").val();
		if (name.trim().length == 0) {
			alert("請輸入名稱");
			return false;
		}
		var url = "http://localhost:8080/workstation/Nurse/update";
		$.ajax({
			url : url,
			//data : "name=" + name,
			data:{
				id:id,
				newId:newId,
				name:name
			},
			type : "POST",
			dataType : 'text',
			success : function(historys) {
				alert("更新成功");
				window.location.assign("http://localhost:8080/workstation/Nurse/view?id="+newId);
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
	function addMapped(nurseId) {
		var stationId = $("input[name='unmapped']:checked").val();
		if (stationId == null) {
			return false;
		}
		var url = "http://localhost:8080/workstation/Mapper/add";
		$.ajax({
			url : url,
			data:{
				nurseId:nurseId,
				stationId:stationId,
			},
			type : "POST",
			dataType : 'text',
			success : function(historys) {
				window.location.assign("http://localhost:8080/workstation/Nurse/view?id="+nurseId);
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
	function delMapped(nurseId) {
		var stationId = $("input[name='mapped']:checked").val();
		if (stationId == null) {
			return false;
		}
		var url = "http://localhost:8080/workstation/Mapper/delete";
		$.ajax({
			url : url,
			data:{
				nurseId:nurseId,
				stationId:stationId,
			},
			type : "POST",
			dataType : 'text',
			success : function(historys) {
				window.location.assign("http://localhost:8080/workstation/Nurse/view?id="+nurseId);
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
<style type="text/css">
#DIV1 {
	width: 200px;
	line-height: 50px;
	height: 100px;
	padding: 20px;
	border: 2px green solid;
	float: left;
}

#DIV2 {
	width: 100px;
	line-height: 50px;
	height: 100px;
	padding: 20px;
	border: 2px green solid;
	float: left;
}

#DIV3 {
	width: 200px;
	line-height: 50px;
	height: 100px;
	padding: 20px;
	border: 2px green solid;
	float: left;
}
</style>
<body>
	<div>
		<input type="button" value="返回" onclick="toMain()"> <input type="button" value="儲存" onclick="updateNurse(${nurse.id})">
	</div>
	<div>
		員工編號:<input type="text" id="id" value="${nurse.id}" disabled>
	</div>
	<div>
		員工名稱:<input type="text" id="name" value="${nurse.name}">
	</div>
	<div>
		<div>分配站點</div>
		<div id="DIV1">
			<ul>
				<c:forEach var="station" items="${mappedlist}">
					<div style="margin-top: 0px; height: 20px">
						<input type="radio" name="mapped" id="${station.id}" value="${station.id}"> <label for="${station.id}">${station.name}</label>
					</div>
				</c:forEach>
			</ul>



		</div>
		<div id="DIV2">
			<button onclick="addMapped(${nurse.id})">&lt;&lt;加入站點</button>
			<br>
			<button onclick="delMapped(${nurse.id})">&gt;&gt;移除站點</button>
		</div>
		<div id="DIV3">
			<c:forEach var="station" items="${unmappedlist}">
				<div style="margin-top: 0px; height: 20px">
					<input type="radio" name="unmapped" id="${station.id}" value="${station.id}"> <label for="${station.id}">${station.name}</label>
				</div>
			</c:forEach>
		</div>
		<div style="clear: both;"></div>
	</div>
</body>
</html>