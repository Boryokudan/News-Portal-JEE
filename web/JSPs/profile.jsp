<%@ page import="main.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../main_elements/head.jsp"%>
<body class="grad">
<%@include file="/main_elements/navbar.jsp"%>
<div class="container d-flex justify-content-center mt-5">
    <div class="row col-6 rounded align-self-center" style="background-color: #f7f7ff;">
        <div class="col-12 p-5 pb-4">
            <%
                int userRole = activeUser.getRole();
                String userRoleStr = userRole == 1
                        ? (currentLangCode.equals("en") ? "superman" : "Вершитель судеб")
                        : (currentLangCode.equals("en") ? "user" : "Пользователь");
            %>
            <form>
                <div class="mb-3 text-center">
                    <h5><%= currentLocale.get("greeting") %><%= activeUser.getFullName() %>!</h5>
                </div>
                <div class="mb-3">
                    <label for="user_role" class="form-label"><%= currentLocale.get("user_role") %></label>
                    <input type="text" class="form-control" id="user_role" name="user_role" value="<%= userRoleStr %>" disabled>
                </div>
                <div class="mb-3 mt-3">
                    <label for="name" class="form-label"><%= currentLocale.get("name") %></label>
                    <input type="text" class="form-control" id="name" name="name" value="<%= activeUser.getFullName() %>" disabled>
                </div>
                <div class="mb-3 ">
                    <label for="exampleInputEmail" class="form-label"><%= currentLocale.get("email") %></label>
                    <input type="email" class="form-control" id="exampleInputEmail" name="email" value="<%= activeUser.getEmail() %>" disabled>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword" class="form-label"><%= currentLocale.get("password") %></label>
                    <input type="password" class="form-control" id="exampleInputPassword" name="password" value="<%= activeUser.getPassword() %>" disabled>
                </div>
                <div class="d-flex justify-content-center">
                    <button type="button" class="btn b-group w-50 mt-4" data-bs-toggle="modal" data-bs-target="#editUserModal">
                        Edit
                    </button>
                </div>
            </form>
<%--            <%@include file="edit-user-modal.jsp"%>--%>
        </div>
    </div>
</div>
</body>
</html>
