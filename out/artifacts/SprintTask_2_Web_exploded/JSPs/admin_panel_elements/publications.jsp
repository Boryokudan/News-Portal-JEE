<%@ page import="main.Publication" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<Publication> publications = (ArrayList<Publication>) request.getAttribute("publications");
    ArrayList<Source> sources = (ArrayList<Source>) request.getAttribute("sources");
    String searchValue = request.getParameter("search-value");
%>

<div class="container">
    <div class="row d-flex">
        <%--        Search bar--%>
        <div class="col-10">
            <form action="/search" method="get" class="row">
                <input type="hidden" class="form-control" name="type" value="publications">
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
        <div class="col-2">
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-success btn-md w-100 h-75" data-bs-toggle="modal" data-bs-target="#addPublicationBackdrop">
                <%= currentLocale.get("add") %>
            </button>
        </div>
    </div>
    <div class="row">
        <!-- Add Publication Modal -->
        <div class="modal fade" id="addPublicationBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel"><%= currentLocale.get("add_publication") %></h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/add?add=publication" method="post">
                            <div class="mb-3">
                                <label for="source" class="form-label"><%= currentLocale.get("source") %>:</label>
                                <select class="form-select" id="source" name="source">
                                    <%
                                        if (sources != null) {
                                            for (Source src : sources) {
                                    %>
                                    <option value="<%= src.getId() %>"><%= src.getSourceName() %></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="title" class="form-label"><%= currentLocale.get("title") %>:</label>
                                <input type="text" class="form-control" id="title" name="title">
                            </div>
                            <div class="mb-3">
                                <label for="description" class="form-label"><%= currentLocale.get("description") %>:</label>
                                <input type="text" class="form-control" id="description" name="description">
                            </div>
                            <div class="mb-3">
                                <label for="content" class="form-label"><%= currentLocale.get("content") %>:</label>
                                <textarea class="form-control" rows="5" id="content" name="content"></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="language" class="form-label"><%= currentLocale.get("language") %>:</label>
                                <select class="form-select" id="language" name="language">
                                    <%
                                        if (languages != null) {
                                            for (Language lang : languages) {
                                    %>
                                        <option value="<%= lang.getId() %>"><%= lang.getName() %></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label for="image-url" class="form-label"><%= currentLocale.get("image_url") %>:</label>
                                <input type="url" class="form-control" id="image-url" name="image-url">
                            </div>
                            <div class="mb-3">
                                <label for="rating" class="form-label"><%= currentLocale.get("rating") %>:</label>
                                <input type="number" min="0" max="10" step="0.1" value="5.0" class="form-control" id="rating" name="rating">
                            </div>
                            <div class="d-flex justify-content-center mt-4">
                                <button type="submit" class="btn b-group w-50 me-3"><%= currentLocale.get("add") %></button>
                                <button type="button" class="btn btn-secondary w-50" data-bs-dismiss="modal"><%= currentLocale.get("close") %>></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
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
                    <th scope="col"><%= currentLocale.get("language") %></th>
                    <th scope="col"><%= currentLocale.get("rating") %></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Publication publication : publications) {
                %>
                <tr>
                    <th scope="row"><%= publication.getId() %></th>
                    <td><%= publication.getNews().getSource().getSourceName() %></td>
                    <td class="col-6"><%= publication.getNews().getTitle() %></td>
                    <td><%= publication.getNews().getLanguage().getCode().toUpperCase() %></td>
                    <td><%= String.format("%.1f", publication.getRating()) %></td>
                    <td>
                        <a href="/delete?object=publication&id=<%= publication.getId() %>" class="btn btn-danger btn-sm mt-2">
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