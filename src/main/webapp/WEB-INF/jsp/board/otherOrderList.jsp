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
                            <a class="nav-link" href="/board/myOrder">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                My Order List
                            </a>
                            <a class="nav-link" href="/board/otherOrder">
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
                        <h1 class="mt-4 mb-4">Tables</h1>
                        <div class="input-group mb-4">
                            <input class="form-control" id="searchData" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="searchBtn" />
                            <button class="btn btn-primary" id="searchBtn" type="button"><i class="fas fa-search"> </i></button>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                                <table id="datatables">
                                    <colgroup>
                                        <col style="width:200px">
                                        <col style="width:200px">
                                        <col style="width:200px">
                                    </colgroup>
                                     <thead>
                                        <tr>
                                            <th>User Name</th>
                                            <th>Order Number</th>
                                            <th>Item Name</th>
                                            <th>Create Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <div class="dataTable-bottom">
                                <nav class="dataTable-pagination m-3">
                                    <ul class="dataTable-pagination-list">
                                        <li class="pager">
                                            <button id="prevPage"> &lt; </button>
                                        </li>
                                        <li class="pager">
                                            <button id="nextPage"> &gt; </button>
                                        </li>
                                    </ul>
                                </nav>
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
            getOtherOrderList(0, 10);
        </script>
    </body>
</html>
