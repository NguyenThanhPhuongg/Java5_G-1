
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="/views/images/gau.png" width="35px" height="40px" style="margin-bottom: 5px"/>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/trang-chu">Trang Chu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Ban hang</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Quan ly
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="/khach-hang/index">Quan ly khach hang</a></li>
                            <li><a class="dropdown-item" href="/mau-sac/index">Quan ly mau sac</a></li>
                            <li><a class="dropdown-item" href="/san-pham/index">Quan ly san pham</a></li>
                            <li><a class="dropdown-item" href="/san-pham-chi-tiet/index">Quan ly san pham chi tiet</a>
                            </li>
                            <li><a class="dropdown-item" href="/kich-thuoc/index">Quan ly kich thuoc</a></li>
                            <li><a class="dropdown-item" href="/nhan-vien/index">Quan ly nhan vien</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

<%--            <div class="col-4 justify-content-end">--%>
<%--                <div class="collapse navbar-collapse ">--%>
<%--                    <form class="d-flex" role="search">--%>
<%--                        <input class="form-control me-2" type="search" aria-label="Search">--%>
<%--                        <button class="btn" style="border-color: pink" type="submit">Search</button>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>

            <div class="col-4 d-flex justify-content-end align-items-center" style="margin-right: 100px">

                <div class="row">
                    <div class="col-8 mt-2"  style="font-size: 17px" id="userNameContainer" ><span>${userName}</span></div>
                    <div  class=" col-4 text-center">
                        <a href="/logout"  id="signupLink">
                            <button class="btn" style="background-color: pink" onclick="if(!(confirm('Ban co muon dang xuat khong?'))) return false">LogOut</button>
                        </a>
                    </div>

                </div>
            </div>
        </div>
    </nav>