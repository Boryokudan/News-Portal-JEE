<%@ page import="main.Publication" %>
<%@ page import="java.util.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../main_elements/head.jsp"%>
<html>
    <%@include file="../main_elements/navbar.jsp"%>
    <body class="grad">

            <%
                ArrayList<Publication> allPublications = (ArrayList<Publication>) request.getAttribute("publications");
                String source = (String) request.getAttribute("source");

                ArrayList<Publication> relevantPublications = (ArrayList<Publication>) allPublications.stream()
                        .filter(
                                pub -> pub.getNews().getLanguage().getCode().equals(finalCurrentLang.getCode()) &&
                                       pub.getNews().getSource().getSourceName().equals(source)
                        )
                        .collect(Collectors.toList());

                if (relevantPublications != null) {
            %>
        <%--    Main container--%>
        <div class="container-fluid col-10 p-2">
            <div class="row">
                <%
                    }
                    for (Publication publication : relevantPublications) {
                %>
                <div class="col-sm-12 col-md-6 col-xxl-4 my-2">
                    <div class="card h-100">
                        <img class="card-img-top" src="<%= publication.getNews().getImageURL() %>" alt="img">
                        <div class="card-body description-text">
                            <a class="ms-3 my-2 text-decoration-none" href="<%= publication.getNews().getSource().getSourceURL() %>">
                                <%= publication.getNews().getSource().getSourceName()%>
                            </a>
                            <h4 class="card-title fw-bold ms-3 my-2"><%= publication.getNews().getTitle() %></h4>
                            <p class="card-text ms-3 my-2"><%= publication.getNews().getDate() %></p><hr>
                            <p class="card-text scrollable"><%= publication.getNews().getDescription() %></p>
                        </div>
                        <div class="card-footer p-3">
                            <a href="/details?id=<%= publication.getId() %>" class="btn b-group btn-md">
                                <%= currentLocale.get("read_more") %> <img src="/resources/icons/details.png" alt="read_more">
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