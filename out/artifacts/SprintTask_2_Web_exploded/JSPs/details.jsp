<%@ page import="main.Publication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../main_elements/head.jsp"%>
<html>
    <%@include file="../main_elements/navbar.jsp"%>
    <body class="grad">
        <%--    Main container--%>
        <%
            Publication publication = (Publication) request.getAttribute("publication");
            String sourceDescription = (String) request.getAttribute("source_description");
        %>
        <div class="container-fluid col-10 p-2 mx-auto">
            <div class="row">
                <div class="col-8 border border-danger">
                    <div class="card text-bg-light h-100 p-3">
                        <img class="card-img-top" src="<%= publication.getNews().getImageURL() %>" alt="img">
                        <div class="card-body description-text">
                            <h4 class="card-title fw-bold"><%= publication.getNews().getTitle() %></h4><br>
                            <p class="card-text"><i><%= publication.getNews().getDescription() %></i></p><hr><br>
                            <p><%= publication.getNews().getContent() %></p>
                        </div>
                    </div>
                </div>
                <div class="col-4 border border-danger">
                    <div class="row">
                        <div class="card about-source h-50">
                            <div class="card-body description-text">
                                <h4 class="card-title fw-bold"><i>About "<%= publication.getNews().getSource()
                                        .getSourceName() %>"</i></h4><hr>
                                <p class="card-text"><%= sourceDescription %></p>
                            </div>
                            <div class="card-footer p-3">

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../main_elements/footer.jsp"%>
    </body>
</html>
