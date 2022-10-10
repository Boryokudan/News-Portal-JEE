<%@ page import="main.Publication" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
%>
<div class="col-12">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Source</th>
            <th scope="col">Language</th>
            <th scope="col">Rating</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Publication publication : publications) {
        %>
        <tr>
            <th scope="row"><%= publication.getId() %></th>
            <td><%= publication.getNews().getSource().getSourceName() %></td>
            <td><%= publication.getNews().getLanguage().getName() %></td>
            <td><%= publication.getRating() %></td>
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