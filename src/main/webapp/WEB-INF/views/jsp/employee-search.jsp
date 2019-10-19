<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Danh sách khách hàng</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


</head>
<body>
<%-- 	<c:url value="/nhanvien/" var="urllist" /> --%>
		<br />
	<table border="1" style="border-collapse: collapse;">
	<tr> 
	<td>id</td>
	</tr>


			<c:forEach var="employee" items="${search}">
				<tr class="text-center">
					<td>${employee.employeeid}</td>
					<td>${employee.name}</td>
					<td>${employee.birthday}</td>
				    <td>${employee.government }</td>  
					<td>${employee.phone}</td>
					<td>${employee.email}</td>
					<td>${employee.address}</td>
					<td><img src="/resources/image/${employee.image}" width="100px"></td>
					<td>${employee.salary}</td>
					<td><button>
							
				</tr>
			</c:forEach>

	</table>
	<form:button  type="submit" >
		<a href="<c:url value="/employee-list" />"> Trở Về danh sách nhân viên</a>
	</form:button>

</body>
</html>