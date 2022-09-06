<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="/WEB-INF/jsp/board/header.jsp" %>
    <body class="sb-nav-fixed">
        <%@ include file="/WEB-INF/jsp/board/topBar.jsp" %>
        <div id="layoutSidenav">
            <%@ include file="/WEB-INF/jsp/board/sideBar.jsp" %>
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
                <%@ include file="/WEB-INF/jsp/board/footer.jsp" %>
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
