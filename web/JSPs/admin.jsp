<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="../main_elements/head.jsp"%>
    <body class="grad">
        <%@include file="/main_elements/navbar.jsp"%>
        <div class="container mt-5 d-flex justify-content-center">
            <div class="row col-10 rounded align-self-center" style="background-color: #EDF2F4;">
                <div class="col-12 p-5 pb-4">
                    <form action="/authentication" method="post">
                        <%
                            String status = request.getParameter("invalid");
                            if (status != null) {
                        %>
                                    <div class="alert alert-danger" role="alert">
                                        <%= currentLocale.get("login_error") %>
                                    </div>
                        <%
                            }
                        %>
                        <div class="mb-3 ">
                            <label for="exampleInputEmail" class="form-label"><%= currentLocale.get("email") %></label>
                            <input type="email" class="form-control" id="exampleInputEmail" name="email" aria-describedby="emailHelp">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword" class="form-label"><%= currentLocale.get("password") %></label>
                            <input type="password" class="form-control" id="exampleInputPassword" name="password">
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn b-group w-50 mt-4"><%= currentLocale.get("login") %></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
