<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<head></head>
<body>
<jsp:include page="../../views/hello.jsp"></jsp:include>
<h1 class="text-center">Quản Lý Nhan Vien</h1>
<div class="container">
    <div class="d-flex justify-content-between align-items-center">
        <a href="/nhan-vien/create">
            <button class="btn btn-success">Them</button>
        </a>
        <form action="/nhan-vien/tim-kiem" method="post">
            <div class="mt-5 d-flex">
                <input value="${valueSearch}" class="form-control mx-2" type="text" name="valueSearch" placeholder="Nhập từ khóa">
                <select name="searchStatus" class="form-select">
                    <option
                            <c:if test="${searchStatus eq 1}">selected</c:if> value="1">Dang hoat dong
                    </option>
                    <option
                            <c:if test="${searchStatus eq 0}">selected</c:if> value="0">Ngưng hoat dong
                    </option>
                </select>
                <button type="submit" class="btn btn-primary mx-2 d-flex align-items-center">Search</button>
            </div>

        </form>
    </div>
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
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${totalPages > 0}">
                <c:if test="${currentPage > 0}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${currentPage - 1}"><<</a>
                    </li>
                </c:if>
                <c:if test="${currentPage <= 0}">
                    <li class="page-item disabled">
                        <span class="page-link"><<</span>
                    </li>
                </c:if>
                <c:forEach var="i" begin="0" end="${totalPages - 1}">
                    <li class="page-item <c:if test="${currentPage == i}">active</c:if>">
                        <a class="page-link" href="?page=${i}">${i + 1}</a>
                    </li>
                </c:forEach>
                <c:if test="${currentPage < totalPages - 1}">
                    <li class="page-item">
                        <a class="page-link"  href="?page=${currentPage + 1}">>></a>
                    </li>
                </c:if>
                <c:if test="${currentPage == totalPages - 1}">
                    <li class="page-item">
                        <a class="page-link"  href="?page=0">>></a>
                    </li>
                </c:if>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>