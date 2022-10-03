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
                            <a class="nav-link me-0 btn b-group btn-lg" href="/authentication">
                                <img src="/resources/icons/login.png" alt="login"> Log In</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%--        Link Group--%>
        <div class="row mt-3">
            <div class="col-12 justify-content-between text-center">
                <div class="btn-group col-12">
                    <%
                        ArrayList<String> sources = (ArrayList<String>) request.getAttribute("sources");
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