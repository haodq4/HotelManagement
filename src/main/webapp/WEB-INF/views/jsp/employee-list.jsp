<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<body>
	<c:url value="/employee-save" var="urlSave" />
	<c:url value="/employee-view/" var="urlView" />
	<c:url value="/employee-update/" var="urlUpdate" />
	<c:url value="/employee-delete/" var="urlDelete" />

	<div>DANH SÁCH THÔNG TIN KHÁCH HÀNG</div>
		<a href="${urlSave}">Thêm mới khách hàng</a>
	<br />
	<form class="form-inline" action="employee-search" method="get">
		<input class="form-control mr-sm-2" type="search" name="name"
			placeholder="Search by name ..." />
		<button class="btn btn-primary" type="submit">
			<i class="fa fa-search"></i> Search
		</button>
	</form>

	<br />
	<table border="1" style="border-collapse: collapse;">
	<tr> 
	<td>Mã Nhân Viên</td>
	<td>Họ Tên</td>
	<td>Ngày Sinh</td>
	<td>Số CMND</td>
	<td>Số ĐT</td>
	<td>Email</td>
	<td>Địa Chỉ</td>
	<td>Hình</td>
	<td>Lương</td>
	<td></td>
	<td></td>
	</tr>

		<c:if test="${not empty listEmployee}">
			<c:forEach var="employee" items="${listEmployee}">
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
								<a href="${urlUpdate}/${employee.employeeid}">Update</a>
							</button></td>
					    <td><button>
						<a href="${urlDelete}/${employee.employeeid}"> Xóa</a>
						</button></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>