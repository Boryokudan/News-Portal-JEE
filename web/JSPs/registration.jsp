<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="../main_elements/head.jsp"%>
    <body class="grad">
        <%@include file="/main_elements/navbar.jsp"%>
        <div class="container mt-5 d-flex justify-content-center">
            <div class="row col-8 rounded align-self-center" style="background-color: #EDF2F4;">
                <div class="col-12 p-5 pb-4">
                    <form action="/registration" method="post">
<%--                        <%--%>
<%--                            String status = request.getParameter("invalid");--%>
<%--                            if (status != null) {--%>
<%--                        %>--%>
<%--                                    <div class="alert alert-danger" role="alert">--%>
<%--                                        <%= currentLocale.get("login_error") %>--%>
<%--                                    </div>--%>
<%--                        <%--%>
<%--                            }--%>
<%--                        %>--%>
                        <div class="mb-3 ">
                            <label for="exampleInputEmail" class="form-label"><%= currentLocale.get("enter_name") %></label>
                            <input type="text" class="form-control" id="exampleInputName" name="full_name">
                        </div>
                        <div class="mb-3 ">
                            <label for="exampleInputEmail" class="form-label"><%= currentLocale.get("enter_email") %></label>
                            <input type="email" class="form-control" id="exampleInputEmail" name="email">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword" class="form-label"><%= currentLocale.get("enter_password") %></label>
                            <input type="password" class="form-control" id="exampleInputPassword" name="password">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword" class="form-label"><%= currentLocale.get("re_password") %></label>
                            <input type="password" class="form-control" id="exampleInputRePassword" name="re_password">
                        </div>
                        <div class="d-flex justify-content-center">
                            <button type="submit" class="btn b-group w-50 mt-4"><%= currentLocale.get("sign_up") %></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
