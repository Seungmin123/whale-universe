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
                <%@ include file="/WEB-INF/jsp/board/footer.jsp" %>
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
