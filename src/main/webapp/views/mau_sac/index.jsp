<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<head></head>
<body>
<jsp:include page="../../views/hello.jsp"></jsp:include>
<h1 class="text-center">Quản Lý Mau Sac</h1>
<div class="container">
    <a href="/mau-sac/create">
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
        <c:forEach items="${listMauSac}" var="mauSac">
            <tr>
                <td>${mauSac.id}</td>
                <td>${mauSac.ma}</td>
                <td>${mauSac.ten}</td>
                <td>${mauSac.trangThai == 0?"Ngung hoat dong":"Dang hoat dong"}</td>
                <td>
                    <a href="/mau-sac/delete/${ mauSac.id }">
                        <button class="btn btn-danger">Xoa</button>
                    </a>
                    <a href="/mau-sac/edit/${ mauSac.id }">
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