<%@ page import="java.util.ArrayList" %>
<%@ page import="main.Publication" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../main_elements/head.jsp"%>
<html>
    <%@include file="../main_elements/navbar.jsp"%>
    <body class="grad">
<%--    Main container--%>
        <div class="container-fluid col-10 p-2">
            <%
                ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
                if (publications != null) {
            %>
                <div class="row">
                    <div class="col-12 col-md-12 col-xxl-8 my-2">
                        <div class="card h-100">
                            <img class="card-img-top" src="<%= publications.get(0).getNews().getImageURL() %>" alt="img">
                            <div class="card-body description-text">
                                <h4 class="card-title fw-bold"><%= publications.get(0).getNews().getTitle() %></h4><hr>
                                <p class="card-text"><%= publications.get(0).getNews().getDescription() %></p>
                            </div>
                            <div class="card-footer p-3">
                                <a href="/details?id=<%= publications.get(0).getId() %>" class="btn b-group btn-lg">
                                    Read more <img src="/resources/icons/details.png" alt="read_more"></a>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-12 col-xxl-4">
                        <div class="row">
                            <div class="col-12 my-2">
                                <div class="card h-100">
                                    <img class="card-img-top" src="<%= publications.get(1).getNews().getImageURL() %>" alt="img">
                                    <div class="card-body description-text">
                                        <h4 class="card-title fw-bold"><%= publications.get(1).getNews().getTitle() %></h4><hr>
                                        <p class="card-text scrollable"><%= publications.get(1).getNews().getDescription() %></p>
                                    </div>
                                    <div class="card-footer p-3">
                                        <a href="/details?id=<%= publications.get(1).getId() %>" class="btn b-group btn-lg">
                                            Read more <img src="/resources/icons/details.png" alt="read_more"></a></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 my-2">
                                <div class="card h-100">
                                    <img class="card-img-top" src="<%= publications.get(2).getNews().getImageURL() %>" alt="img">
                                    <div class="card-body description-text">
                                        <h4 class="card-title fw-bold"><%= publications.get(2).getNews().getTitle() %></h4><hr>
                                        <p class="card-text scrollable"><%= publications.get(2).getNews().getDescription() %></p>
                                    </div>
                                    <div class="card-footer p-3">
                                        <a href="/details?id=<%= publications.get(2).getId() %>" class="btn b-group btn-lg">
                                            Read more <img src="/resources/icons/details.png" alt="read_more"></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
<%--        Secondary container--%>
        <div class="container-fluid col-10 p-2">
            <div class="row">
                <%
                    }
                    for (int i = 3; i < publications.size(); i++) {
                %>
                <div class="col-sm-12 col-md-6 col-xxl-4 my-2">
                    <div class="card h-100">
                        <img class="card-img-top" src="<%= publications.get(i).getNews().getImageURL() %>" alt="img">
                        <div class="card-body description-text">
                            <h4 class="card-title"><strong><%= publications.get(i).getNews().getTitle() %></strong></h4><hr><br>
                            <p class="card-text scrollable"><%= publications.get(i).getNews().getDescription() %></p>
                        </div>
                        <div class="card-footer p-3">
                            <a href="/details?id=<%= publications.get(i).getId() %>" class="btn b-group btn-lg">
                                Read more <img src="/resources/icons/details.png" alt="read_more"></a></a>
                        </div>
                    </div>
                </div>
                <%
                    }
                %>
            </div>
        </div>
        <%@include file="../main_elements/footer.jsp"%>
    </body>
</html>