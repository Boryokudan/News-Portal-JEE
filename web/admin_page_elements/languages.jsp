<%@ page import="main.Publication" %>
<%@ page import="java.util.ArrayList" %>

<div class="col-12">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Code</th>
            <th scope="col">Icon</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Language lang : languages) {
        %>
        <tr>
            <th scope="row"><%= lang.getId() %></th>
            <td><%= lang.getName() %></td>
            <td><%= lang.getCode().toUpperCase() %></td>
            <td><img src="<%= lang.getIconURL() %>" alt="lang_icon"></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>