<%@ page import="main.Publication" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
    String searchValue = request.getParameter("search-value");
%>
<div class="container">
    <div class="row d-flex">
        <%--        Search bar--%>
        <div class="col-12">
            <form action="/search" method="get" name="type" class="row">
                <input type="hidden" class="form-control" name="type" value="news">
                <div class="col-10 align-self-center">
                    <input type="search" class="form-control h-auto" name="search-value"
                           placeholder="<%= currentLocale.get("search") %>"
                           value="<%= searchValue != null ? searchValue : "" %>">
                </div>
                <div class="col-2 align-self-center">
                    <button class="btn b-group btn-md w-100 h-50"><%= currentLocale.get("search") %></button>
                </div>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col"><%= currentLocale.get("id") %></th>
                    <th scope="col"><%= currentLocale.get("source") %></th>
                    <th scope="col"><%= currentLocale.get("title") %></th>
                    <th scope="col"><%= currentLocale.get("description") %></th>
                    <th scope="col"><%= currentLocale.get("date") %></th>
                    <th scope="col"><%= currentLocale.get("language") %></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Publication publication : publications) {
                %>
                <tr>
                    <th scope="row"><%= publication.getNews().getId() %></th>
                    <td><%= publication.getNews().getSource().getSourceName() %></td>
                    <td><%= publication.getNews().getTitle() %></td>
                    <td><%= publication.getNews().getDescription() %></td>
                    <td><%= publication.getNews().getDate() %></td>
                    <td><%= publication.getNews().getLanguage().getCode().toUpperCase() %></td>
                    <td>
                        <a href="/details?id=<%= publication.getId() %>" class="btn b-group btn-sm mt-3 me-1 h-50">
                            <%= currentLocale.get("details") %>
                        </a>
                    </td>
                    <td>
                        <a href="/delete?object=news&id=<%= publication.getId() %>" class="btn btn-danger btn-sm mt-3 me-1">
                            <%= currentLocale.get("delete") %>
                        </a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>