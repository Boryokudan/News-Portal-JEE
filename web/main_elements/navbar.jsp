<%@ page import="java.util.Set" %>
<%@ page import="main.Language" %>

<%
    ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
    System.out.println(languages.get(1).getName());
    Set<String> sources = (Set<String>) request.getAttribute("sources");
%>
<nav class="navbar navbar-expand-lg">
    <div class="container-fluid col-10 d-block">
        <div class="row">
            <div class="col-12 d-flex">
                <div class="mt-1">
                    <a class="navbar-brand" href="/"><img src="../resources/logo/logo.png" alt="logo" width="600px"></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>
                <%--        Navbar--%>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <div class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <div class="nav-item">
                            <a class="nav-link me-0 btn b-group btn-md" href="/authentication">
                                <img src="/resources/icons/login.png" alt="login"> Log In</a>
                        </div>
                        <div class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>
                            <%--                                    <%--%>
                            <%--                                        if (languages != null) {--%>
                            <%--                                            for (Language language : languages) {--%>
                            <%--                                    %>--%>
                            <%--                                    <a class="dropdown-item" name="<%= language.getCode() %>"><%= language.getName() %></a>--%>
                            <%--                                    <%--%>
                            <%--                                        }--%>
                            <%--                                    }--%>
                            <%--                                    %>--%>
                    </div>
                </div>
            </div>
        </div>
<%--        Link Group--%>
        <div class="row mt-3">
            <div class="col-12 justify-content-between text-center">
                <div class="btn-group col-12">
                    <%
                        if (sources != null) {
                            for (String source : sources) {
                    %>
                    <a href="#" class="btn b-group btn-lg"><%= source %></a>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</nav>