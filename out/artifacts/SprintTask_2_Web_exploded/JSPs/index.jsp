<%@ page import="main.Publication" %>
<%@ page import="main.Source" %>
<%@ page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../main_elements/head.jsp"%>
<html>
    <%@include file="../main_elements/navbar.jsp"%>
    <body class="grad">
<%--    Main container--%>
        <div class="container-fluid col-10 p-2">
            <%
                ArrayList<Publication> allPublications = (ArrayList<Publication>) request.getAttribute("publications");

                // Extraction of publications relevant to the current language;
                ArrayList<Publication> relevantPublications = (ArrayList<Publication>) allPublications.stream()
                        .filter(pub -> pub.getNews().getLanguage().getCode().equals(finalCurrentLang.getCode()))
                        .collect(Collectors.toList());

                if (relevantPublications != null) {
            %>
                <div class="row">
                    <div class="col-12 col-md-12 col-xxl-8 my-2">
                        <div class="card h-100">
                            <img class="card-img-top" src="<%= relevantPublications.get(0).getNews().getImageURL() %>" alt="img">
                            <div class="card-body description-text">
                                <a class="ms-3 my-2 text-decoration-none" href="<%= relevantPublications.get(0).getNews().getSource().getSourceURL() %>">
                                    <%= relevantPublications.get(0).getNews().getSource().getSourceName()%>
                                </a>
                                <h4 class="card-title fw-bold ms-3 my-2"><%= relevantPublications.get(0).getNews().getTitle() %></h4>
                                <p class="card-text ms-3 my-2"><%= relevantPublications.get(0).getNews().getDate() %></p><hr>
                                <p class="card-text"><%= relevantPublications.get(0).getNews().getDescription() %></p>
                            </div>
                            <div class="card-footer p-3">
                                <a href="/details?id=<%= relevantPublications.get(0).getId() %>" class="btn b-group btn-lg">
                                    Read more <img src="/resources/icons/details.png" alt="read_more"></a>
                            </div>
                        </div>
                    </div>

                    <div class="col-12 col-md-12 col-xxl-4">
                        <div class="row">
                            <div class="col-12 my-2">
                                <div class="card h-100">
                                    <img class="card-img-top" src="<%= relevantPublications.get(1).getNews().getImageURL() %>" alt="img">
                                    <div class="card-body description-text">
                                        <a class="ms-3 my-2 text-decoration-none" href="<%= relevantPublications.get(1).getNews().getSource().getSourceURL() %>">
                                            <%= relevantPublications.get(1).getNews().getSource().getSourceName()%>
                                        </a>
                                        <h4 class="card-title fw-bold ms-3 my-2"><%= relevantPublications.get(1).getNews().getTitle() %></h4>
                                        <p class="card-text ms-3 my-2"><%= relevantPublications.get(1).getNews().getDate() %></p><hr>
                                        <p class="card-text scrollable"><%= relevantPublications.get(1).getNews().getDescription() %></p>
                                    </div>
                                    <div class="card-footer p-3">
                                        <a href="/details?id=<%= relevantPublications.get(1).getId() %>" class="btn b-group btn-lg">
                                            Read more <img src="/resources/icons/details.png" alt="read_more"></a></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 my-2">
                                <div class="card h-100">
                                    <img class="card-img-top" src="<%= relevantPublications.get(2).getNews().getImageURL() %>" alt="img">
                                    <div class="card-body description-text">
                                        <a class="ms-3 my-2 text-decoration-none" href="<%= relevantPublications.get(2).getNews().getSource().getSourceURL() %>">
                                            <%= relevantPublications.get(2).getNews().getSource().getSourceName()%>
                                        </a>
                                        <h4 class="card-title fw-bold ms-3 my-2"><%= relevantPublications.get(2).getNews().getTitle() %></h4>
                                        <p class="card-text ms-3 my-2"><%= relevantPublications.get(2).getNews().getDate() %></p><hr>
                                        <p class="card-text scrollable"><%= relevantPublications.get(2).getNews().getDescription() %></p>
                                    </div>
                                    <div class="card-footer p-3">
                                        <a href="/details?id=<%= relevantPublications.get(2).getId() %>" class="btn b-group btn-lg">
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
                    for (int i = 3; i < relevantPublications.size(); i++) {
                %>
                <div class="col-sm-12 col-md-6 col-xxl-4 my-2">
                    <div class="card h-100">
                        <img class="card-img-top" src="<%= relevantPublications.get(i).getNews().getImageURL() %>" alt="img">
                        <div class="card-body description-text">
                            <a class="ms-3 my-2 text-decoration-none" href="<%= relevantPublications.get(0).getNews().getSource().getSourceURL() %>">
                                <%= relevantPublications.get(i).getNews().getSource().getSourceName()%>
                            </a>
                            <h4 class="card-title fw-bold ms-3 my-2"><%= relevantPublications.get(i).getNews().getTitle() %></h4>
                            <p class="card-text ms-3 my-2"><%= relevantPublications.get(i).getNews().getDate() %></p><hr>
                            <p class="card-text scrollable"><%= relevantPublications.get(i).getNews().getDescription() %></p>
                        </div>
                        <div class="card-footer p-3">
                            <a href="/details?id=<%= relevantPublications.get(i).getId() %>" class="btn b-group btn-lg">
                                Read more <img src="/resources/icons/details.png" alt="read_more">
                            </a>
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