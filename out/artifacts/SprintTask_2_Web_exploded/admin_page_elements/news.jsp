<%@ page import="main.Publication" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.News" %>

<%
    ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
%>
<div class="col-12 fluid">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Source</th>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Date</th>
            <th scope="col">Language</th>
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
            <td><%= publication.getNews().getLanguage().getName() %></td>
            <td>
                <a href="/details?id=<%= publication.getId() %>" class="btn b-group btn-sm tex">Details</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>