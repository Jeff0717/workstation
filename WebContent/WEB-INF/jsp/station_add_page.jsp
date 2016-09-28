<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>station add page</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	function toMain() {
		window.location.assign("http://localhost:8080/workstation/Main");
	}
	function addStation() {
		var name = $("#name").val();
		if (name.trim().length == 0){
			alert("請輸入名稱");
			return false;
		}
			
		var url = "http://localhost:8080/workstation/Station/add";
		$.ajax({
			url : url,
			data : "name=" + name,
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
<body>
	<div>
		<input type="button" value="返回" onclick="toMain()"> <input type="button" value="新增" onclick="addStation()">
	</div>
	<div>
		站點名稱:<input type="text" id="name">
	</div>
</body>
</html>