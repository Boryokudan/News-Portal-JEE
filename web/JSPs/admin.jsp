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
        <div class="container admin-main mt-5 d-flex justify-content-center">
            <div class="row col-12">
                <div class="col-2 ps-3 pt-3">
                    <div class="row my-2">
                        <a href="/admin_publications" class="text-decoration-none">Publications</a>
                    </div>
                    <div class="row my-2">
                        <a href="/admin_news" class="text-decoration-none">News</a>
                    </div>
                    <div class="row my-2">
                        <a href="/admin_languages" class="text-decoration-none">Languages</a>
                    </div>
                </div>
                <div class="col-10 pe-3 pt-3">
                    <%
                        if (showParam.equals("publications")) {
                    %>
                            <%@include file="../admin_page_elements/publications.jsp"%>
                    <%
                        } else if (showParam.equals("news")) {
                    %>
                            <%@include file="../admin_page_elements/news.jsp"%>
                    <%
                        } else if (showParam.equals("languages")) {
                    %>
                            <%@include file="../admin_page_elements/languages.jsp"%>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
