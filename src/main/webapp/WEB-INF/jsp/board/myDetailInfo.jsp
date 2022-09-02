<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Login - SB Admin</title>
        <link href="../css/styles.css" rel="stylesheet" />

    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <p class="navbar-brand ps-3">HTBeyond</p>
            <form action="/api/user/logout" method="post" class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input type="submit" class="btn btn-primary" id="logOutBtn" value="LogOut" />
                </div>
            </form>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <a class="nav-link" href="/user/mypage">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                My Detail Info
                            </a>
                            <a id="myOrderListBtn" class="nav-link" href="/board/myOrder">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                My Order List
                            </a>
                            <a id="otehrOrderListBtn" class="nav-link" href="/board/otherOrder">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Other Order List
                            </a>
                        </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">My Detail Info</h1></br>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Name</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body" >
                                <p id ="myName"></p>
                            </div>
                        </div>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">NickName</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <p id ="myNickName"></p>
                            </div>
                        </div>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Password</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <p id ="myPassword"></p>
                            </div>
                        </div>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item" >Tell</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <p id ="myTell"></p>
                            </div>
                        </div>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Email</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <p id ="myEmail"></p>
                            </div>
                        </div>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Gender</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
                                <p id ="myGender"></p>
                            </div>
                        </div>

                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2022</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="../js/managingUser.js"></script>
        <script>
            getMyInfo();
        </script>
    </body>
</html>
