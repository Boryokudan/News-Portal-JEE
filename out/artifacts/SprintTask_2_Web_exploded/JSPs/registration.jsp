<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="../main_elements/head.jsp"%>
    <body class="grad">
        <%@include file="/main_elements/navbar.jsp"%>
        <div class="container mt-5 d-flex justify-content-center">
            <div class="row col-8 rounded align-self-center" style="background-color: #EDF2F4;">
                <div class="col-12 p-5 pb-4">
                    <form action="/registration" method="post">
                        <%
                            String email = request.getParameter("email");
                            String password = request.getParameter("password");
                            String rePassword = request.getParameter("re_password");
                            String fullName = request.getParameter("full_name");

                            String error = request.getParameter("error");

                            if (error != null && error.equals("null-fields")) {
                        %>
                                <div class="alert alert-danger" role="alert">
                                    <%= currentLocale.get("null_fields") %>
                                </div>
                        <%
                            }
                            else if (error != null && error.equals("email-error")) {
                        %>
                                <div class="alert alert-danger" role="alert">
                                    <%= request.getParameter("email") + currentLocale.get("email_error") %>
                                </div>
                        <%
                            } else if (error != null && error.equals("passwords-error")) {
                        %>
                                <div class="alert alert-danger" role="alert">
                                    <%= currentLocale.get("passwords_error") %>
                                </div>
                        <%
                            }
                        %>
                        <div class="mb-3 ">
                            <label for="exampleInputName" class="form-label"><%= currentLocale.get("enter_name") %></label>
                            <input type="text" class="form-control" id="exampleInputName" name="full_name" value="<%= fullName != null ? fullName : "" %>">
                        </div>
                        <div class="mb-3 ">
                            <label for="exampleInputEmail" class="form-label"><%= currentLocale.get("enter_email") %></label>
                            <input type="email" class="form-control" id="exampleInputEmail" name="email" value="<%= email != null ? email : "" %>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword" class="form-label"><%= currentLocale.get("enter_password") %></label>
                            <input type="password" class="form-control" id="exampleInputPassword" name="password" value="<%= password != null ? password : "" %>">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputRePassword" class="form-label"><%= currentLocale.get("re_password") %></label>
                            <input type="password" class="form-control" id="exampleInputRePassword" name="re_password" value="<%= rePassword != null ? rePassword : "" %>">
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn b-group w-50 mt-4"><%= currentLocale.get("sign_up") %></button>
                        </div>
                    </form>
                    <div class="text-center">
                        <h6 class="mt-3">
                            <%= currentLocale.get("have_account") %>
                            <a href="/authentication" class="text-decoration-none">
                                <%= currentLocale.get("login") %>.
                            </a>
                        </h6>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
