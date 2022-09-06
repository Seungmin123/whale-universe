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
                        <h1 class="mt-4">My Order List</h1>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                My Order List
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <colgroup>
                                        <col style="width:200px">
                                        <col style="width:200px">
                                        <col style="width:200px">
                                    </colgroup>
                                     <thead>
                                        <tr>
                                            <th>Order Number</th>
                                            <th>Item Name</th>
                                            <th>Created Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
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
        <script>getOrderList(${myInfo.id});</script>
    </body>
</html>
