<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="../main_elements/head.jsp"%>
    <body class="grad">
        <%@include file="../main_elements/admin-navbar.jsp"%>
        <%
            String showParam = request.getParameter("show");
            if (showParam == null) {
                showParam = "publications";
            }
        %>
        <div class="container col-12 admin-main mt-5 d-flex justify-content-center">
            <div class="row col-12 ps-0">
                <div class="col-2 ps-4 pt-4 about-source rounded">
                    <div class="row my-2">
                        <h5><%= currentLocale.get("admin_pane") %></h5>
                    </div>
                    <div class="row my-2">
                        <a href="/admin-panel?display=publications" class="text-decoration-none">
                            <%= currentLocale.get("publications") %>
                        </a>
                    </div>
                    <div class="row my-2">
                        <a href="/admin-panel?display=news" class="text-decoration-none">
                            <%= currentLocale.get("news") %>
                        </a>
                    </div>
                    <div class="row my-2">
                        <a href="/admin-panel?display=languages" class="text-decoration-none">
                            <%= currentLocale.get("languages") %>
                        </a>
                    </div>
                </div>
                <div class="col-10 pe-3 pt-3">
                    <%
                        if (showParam.equals("publications")) {
                    %>
                            <%@include file="admin_panel_elements/publications.jsp"%>
                    <%
                        } else if (showParam.equals("news")) {
                    %>
                            <%@include file="admin_panel_elements/news.jsp"%>
                    <%
                        } else if (showParam.equals("languages")) {
                    %>
                            <%@include file="admin_panel_elements/languages.jsp"%>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
