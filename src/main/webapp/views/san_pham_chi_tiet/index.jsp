<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<head></head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="./hello.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/khach-hang/index">Quản lý khách hàng</a></li>
                        <li><a class="dropdown-item" href="/mau-sac/index">Quản lý màu sắc</a></li>
                        <li><a class="dropdown-item" href="/san-pham/index">Quản lý sản phẩm</a></li>
                        <li><a class="dropdown-item" href="/kich-thuoc/index">Quản lý kích thước</a></li>
                        <li><a class="dropdown-item" href="#">San Pham Chi Tiet</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<h1 class="text-center">Quản Lý Sản Phẩm Chi Tiết</h1>
<div class="container">
    <a href="/san-pham/create">
        <button class="btn btn-success">Them</button>
    </a>
    <form action="/san-pham-chi-tiet/index" method="get">
        <div class="col-md-3 mt-5">
            <select name="idSP" class="form-select">
                <c:forEach var="spct" items="${listSanPham}">
                    <option value="${spct.id}">${spct.ten}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-primary">Tim kiem</button>
        </div>
    </form>

    <table class="table">
        <tr>
            <th>ID</th>
            <th>Ma SPCT</th>
            <th>Kich Thuoc</th>
            <th>Mau Sac</th>
            <th>So Luong</th>
            <th>Don gia</th>
            <th>Trang thai</th>
            <th>Thao tac</th>
        </tr>
        <tbody>
        <c:forEach items="${listSanPhamChiTiet}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.maSPCT}</td>
                <td>${item.idKT}</td>
                <td>${item.idMS}</td>
                <td>${item.soLuong}</td>
                <td>${item.donGia}</td>
                <td>${item.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/san-pham/delete/${ sanPham.id }">
                        <button class="btn btn-danger">Xoa</button>
                    </a>
                    <a href="/san-pham/edit/${ sanPham.id }">
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