<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>nurse add page</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function toMain() {
		window.location.assign("http://localhost:8080/workstation/Main");
	}
	function addNurse() {
		var id = $("#id").val();
		var name = $("#name").val();
		if (id.trim().length == 0) {
			alert("請輸入編號");
			return false;
		}
		if (name.trim().length == 0) {
			alert("請輸入姓名");
			return false;
		}

		var url = "http://localhost:8080/workstation/Nurse/add";
		$.ajax({
			url : url,
			data : {
				id : id,
				name : name
			},
			type : "POST",
			dataType : 'text',
			success : function(historys) {
				alert("新增成功");
			},
			beforeSend : function() {
			},
			complete : function() {
			},
			error : function(xhr, ajaxOptions, thrownError) {
				alert('新增失敗');
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
	width: 50px;
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
		<input type="button" value="返回" onclick="toMain()"> <input type="button" value="新增" onclick="addNurse()">
	</div>
	<div>
		員工編號:<input type="text" id="id">
	</div>
	<div>
		員工姓名:<input type="text" id="name">
	</div>
	
</body>
</html>