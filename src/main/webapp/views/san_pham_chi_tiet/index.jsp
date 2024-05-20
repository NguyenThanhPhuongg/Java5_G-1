<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<head>
    <jsp:include page="../../views/hello.jsp"></jsp:include>
</head>
<body>
<h1 class="text-center">Quản Lý Sản Phẩm Chi Tiết</h1>
<div class="container">
    <div class="d-flex justify-content-between align-items-center">
        <a href="/san-pham-chi-tiet/create">
            <button class="btn btn-success">Them</button>
        </a>
        <form action="/san-pham-chi-tiet/index" method="get">
            <div class="mt-5 d-flex">
                <select name="idSP" class="form-select" >
                    <c:forEach var="spct" items="${listSanPham}">
                        <option value="${spct.id}" ${idSP != null && idSP == spct.id ? 'selected' : ''}>
                                ${spct.ten}
                        </option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn btn-primary mx-2 d-flex align-items-center"><span>Search</span>
                </button>
            </div>
        </form>
    </div>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Ma SPCT</th>
            <th>San Pham</th>
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
                <td>${productNames[item.idSP]}</td>
                <td>${sizeNames[item.idKT]}</td>
                <td>${colorNames[item.idMS]}</td>
                <td>${item.soLuong}</td>
                <td>${item.donGia}</td>
                <td>${item.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/san-pham-chi-tiet/delete/${ item.id }">
                        <button class="btn btn-danger">Xoa</button>
                    </a>
                    <a href="/san-pham-chi-tiet/edit/${ item.id }">
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