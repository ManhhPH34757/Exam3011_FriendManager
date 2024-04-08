<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/8/2024
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
	<title>Danh sách bạn bè</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
              <h1>Danh sách bạn bè</h1>
		<form action="update?id=${ban.id}" method="post">
			<div class="form-group">
				<label for="ma">Mã</label>
                            <input type="text" class="form-control" id="ma" name="ma" value="${ban.ma}">
                     </div>
			<div class="form-group">
				<label for="ten">Họ tên:</label>
				<input type="text" class="form-control" id="ten" name="ten" value="${ban.ten}">
			</div>
			<div class="form-group">
				<label for="ns">Ngày sinh</label>
				<input type="text" class="form-control" id="ns" name="ngaySinh" value="${ban.ngaySinh}">
			</div>
			<div class="form-group">
				<label for="st">Sở thích</label>
				<input type="text" class="form-control" id="st" name="soThich" value="${ban.soThich}">
			</div>
			<div class="form-group">
				<label>Giới tính</label>
                            <input type="radio" id="1" name="gioiTinh" value="1"
                            <c:if test="${ban.gioiTinh == 1}">checked</c:if>>
				<label for="1">Nam</label>
				<input type="radio" id="0" name="gioiTinh" value="0"
				       <c:if test="${ban.gioiTinh == 0}">checked</c:if>>
				<label for="0">Nữ</label>
                     </div>
			<div class="form-group">
				<label for="idMqh">Mối quan hệ</label>
                            <select class="form-control" id="idMqh" name="idMqh">
	                            <option value="" hidden>--Chọn mối quan hệ</option>
                                   <c:forEach items="${listMqh}" var="idMqh" varStatus="i">
	                                   <option   value="${idMqh.id}" <c:if test="${ban.idMqh.id == idMqh.id}">selected</c:if>>  ${idMqh.ten}</option>
                                   </c:forEach>
                            </select>
                     </div>
			<div class="form-group">
				<label>Trạng thái</label>
				<input type="radio" id="active" name="trangThai" value="1"
				       <c:if test="${ban.trangThai == 1}">checked</c:if>>
				<label for="active">Active</label>
				<input type="radio" id="inActive" name="trangThai" value="0"
				       <c:if test="${ban.trangThai == 0}">checked</c:if>>
				<label for="inActive">InActive</label>
                     </div>
                     <button type="submit" class="btn btn-primary">Sửa</button>
		</form>
              <table class="table table-striped">
                     <thead>
                            <tr>
                                   <th scope="col">#</th>
	                            <th scope="col">Mã</th>
                                   <th scope="col">Họ và tên</th>
	                            <th scope="col">Ngày sinh</th>
	                            <th scope="col">Sở thích</th>
                                   <th scope="col">Giới tính</th>
                                   <th scope="col">Mối quan hệ</th>
                                   <th scope="col">Trạng thái</th>
	                            <th scope="col">Thao tác</th>
                            </tr>
                     </thead>
                     <tbody>
                     <c:forEach items="${list}" var="friend" varStatus="i">
	                     <tr>
                                   <th scope="row">${i.index + 1}</th>
                                   <td>${friend.ma}</td>
                                   <td>${friend.ten}</td>
                                   <td>${friend.ngaySinh}</td>
                                   <td>${friend.soThich}</td>
                                   <td>${friend.gioiTinh == 1 ? 'Nam' : 'Nữ'}</td>
                                   <td>${friend.idMqh.ten}</td>
                                   <td>${friend.trangThai == 1 ? 'Active' : 'InActive'}</td>
                                   <td>
                                      <a class="btn btn-warning" href="hienThi?id=${friend.id}" onclick="return confirm('Bạn muốn sửa thông tin bạn bè?')">Sửa</a>
                                      <a class="btn btn-danger" href="remove?id=${friend.id}" onclick="return confirm('Bạn muốn xóa thông tin bạn bè?')">Xóa</a>
                                   </td>
                            </tr>
                     </c:forEach>
                     </tbody>
              </table>
	</div>
</body>
</html>
