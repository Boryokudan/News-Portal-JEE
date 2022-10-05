<%@ page import="main.Publication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../main_elements/head.jsp"%>
<html>
    <%@include file="../main_elements/navbar.jsp"%>
    <body class="grad">
        <%
            Publication publication = (Publication) request.getAttribute("publication");
            String sourceDescription = (String) request.getAttribute("source_description");
        %>
        <%--    Main container--%>
        <div class="container-fluid col-10 p-2 mx-auto">
            <div class="row">
                <div class="col-8 border border-danger">
                    <div class="card text-bg-light h-100 p-3">
                        <img class="card-img-top" src="<%= publication.getNews().getImageURL() %>" alt="img">
                        <div class="card-body description-text">
                            <a class="ms-3 my-2 text-decoration-none" href="<%= publication.getNews().getSource().getSourceURL() %>">
                                <%= publication.getNews().getSource().getSourceName()%>
                            </a>
                            <h4 class="card-title fw-bold ms-3 my-2"><%= publication.getNews().getTitle() %></h4>
                            <p class="card-text ms-3 my-2"><%= publication.getNews().getDate() %></p>
                            <p class="card-text mt-4 ms-3 my-2"><%= publication.getNews().getDescription() %></p><hr>
                            <p class="card-text"><%= publication.getNews().getContent() %></p>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="row">
                        <div class="card about-source h-50">
                            <div class="card-body description-text">
                                <h4 class="card-title fw-bold"><i><%= currentLocale.get("about_source") %>
                                    "<%= publication.getNews().getSource().getSourceName() %>"</i></h4><hr>
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
