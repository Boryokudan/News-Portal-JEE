
<%@include file="../main_elements/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="../main_elements/navbar.jsp"%>
    <body class="grad">
        <%--    Main container--%>
        <%
            Publication publication = (Publication) request.getAttribute("publication");
        %>
        <div class="container-fluid col-10 p-2 mx-auto">
            <div class="row">
                <div class="col-8 border border-danger height" style="height: 500px;">
                </div>
                <div class="col-4 border border-danger" style="height: 500px;">
                    <div class="row">
                        <h3 class="text-center">About "<%= publication.getNews().getSource() %>"</h3>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
