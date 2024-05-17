<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<head></head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/khach-hang/index">Quản lý khách hàng</a></li>
                        <li><a class="dropdown-item" href="/mau-sac/index">Quản lý màu sắc</a></li>
                        <li><a class="dropdown-item" href="/san-pham/index">Quản lý sản phẩm</a></li>
                        <li><a class="dropdown-item" href="/kich-thuoc/index">Quản lý kích thước</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<h1 class="text-center">Quản Lý Kich Thuoc</h1>
<div class="container">
    <a href="/kich-thuoc/create">
        <button class="btn btn-success">Them</button>
    </a>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Ma</th>
            <th>Ten</th>
            <th>TrangThai</th>
            <th>Thao tac</th>
        </tr>
        <tbody>
        <c:forEach items="${listKichThuoc}" var="kichThuoc">
            <tr>
                <td>${kichThuoc.id}</td>
                <td>${kichThuoc.ma}</td>
                <td>${kichThuoc.ten}</td>
                <td>${kichThuoc.trangThai == 0?"Ngung hoat dong":"Dang hoat dong"}</td>
                <td>
                    <a href="/kich-thuoc/delete/${ kichThuoc.id }">
                        <button class="btn btn-danger">Xoa</button>
                    </a>
                    <a href="/kich-thuoc/edit/${ kichThuoc.id }">
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