<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<head></head>
<body>
<jsp:include page="../../views/hello.jsp"></jsp:include>
<h1 class="text-center">Quản Lý Khách hàng</h1>
<div class="container">
    <a href="/nhan-vien/create">
        <button class="btn btn-success">Them</button>
    </a>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Ten</th>
            <th>Ma NV</th>
            <th>Ten dang nhap</th>
            <th>Mat khau</th>
            <th>TrangThai</th>
            <th>Thao tac</th>
        </tr>
        <tbody>
        <c:forEach items="${listNhanVien}" var="nv">
            <tr>
                <td>${nv.id}</td>
                <td>${nv.ten}</td>
                <td>${nv.maNV}</td>
                <td>${nv.tenDangNhap}</td>
                <td>${nv.matKhau}</td>
                <td>${nv.trangThai == 0?"Ngung hoat dong":"Dang hoat dong"}</td>
                <td>
                    <a href="/nhan-vien/delete/${nv.id}">
                        <button class="btn btn-danger">Xoa</button>
                    </a>
                    <a href="/nhan-vien/edit/${nv.id}">
                        <button class="btn btn-warning">Sua</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>