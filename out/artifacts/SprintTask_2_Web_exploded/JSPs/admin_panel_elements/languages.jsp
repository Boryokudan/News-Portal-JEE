<div class="col-12">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"><%= currentLocale.get("id") %></th>
            <th scope="col"><%= currentLocale.get("language_name") %></th>
            <th scope="col"><%= currentLocale.get("language_code") %></th>
            <th scope="col"><%= currentLocale.get("language_icon") %></th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Language lang : languages) {
        %>
        <tr class="my-2">
            <th scope="row"><%= lang.getId() %></th>
            <td><%= lang.getName() %></td>
            <td><%= lang.getCode().toUpperCase() %></td>
            <td><img src="<%= lang.getIconURL() %>" alt="lang_icon" height="30px"></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>