<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link href="../css/styles.css" rel="stylesheet" />
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-5">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                                    <div class="card-body">
                                        <form:form action="/api/user/register" method="post" modelAttribute="memberFormDto">
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" path="name" id="name" name="name" type="text" placeholder="Name" />
                                                <label for="name">Name</label>
                                                <p style="color:red"><form:errors path="name"/></p>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" path="nickName" id="nickName" name="nickName" type="text" placeholder="NickName" />
                                                <label for="nickName">NickName</label>
                                                <p style="color:red"><form:errors path="nickName"/></p>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" path="password" id="password" name="password" type="password" placeholder="Password" />
                                                <label for="password">password</label>
                                                <p style="color:red"><form:errors path="password"/></p>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" path="tell" id="tell" name="tell" type="text" placeholder="Tell" />
                                                <label for="tell">tell</label>
                                                <p style="color:red"><form:errors path="tell"/></p>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:input class="form-control" path="email" id="email" name="email" type="text" placeholder="Email" />
                                                <label for="email">email</label>
                                                <p style="color:red"><form:errors path="email"/></p>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <form:radiobutton path="gender" value="male"/> Male
                                                <form:radiobutton path="gender" value="female"/> Female
                                            </div>
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><input type="submit" id="registerBtn" class="btn btn-primary btn-block" value="Create Account" /></div>
                                            </div>
                                        </form:form>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small"><a href="/">Go to login</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
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
    </body>
</html>
