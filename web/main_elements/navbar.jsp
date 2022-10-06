<%@ page import="java.util.*" %>
<%@ page import="main.Language" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="main.Source" %>
<%@ page import="main.User" %>

<%
    // Main params;
    ArrayList<Source> sources = (ArrayList<Source>) request.getAttribute("sources");
    ArrayList<Language> languages = (ArrayList<Language>) request.getAttribute("languages");
    HashMap<String, HashMap<String, String>> locales = (HashMap<String, HashMap<String, String>>) request.getAttribute("locales");

    // Checking if any user is logged in;
    User activeUser = (User) session.getAttribute("activeUser");
    boolean userOnline = activeUser != null;

    // Default lang value;
    String currentLangCode = "en";

    // Cookie processing;
    Cookie[] cookies = request.getCookies();
    Optional<Cookie> langOpt = Arrays.stream(cookies)
                                        .filter(cookie -> cookie.getName().equalsIgnoreCase("lang"))
                                        .findFirst();
    if (!langOpt.isEmpty()) {
        currentLangCode = langOpt.get().getValue();
    }
    // Relevant language locale identification:
    HashMap<String, String> currentLocale = locales.get(currentLangCode);
    String finalCurrentLangCode = currentLangCode;
    Language currentLang = null;
    Optional<Language> currentLangOpt = languages.stream()
                                                    .filter(lang -> lang.getCode().equalsIgnoreCase(finalCurrentLangCode))
                                                    .findFirst();
    if (!currentLangOpt.isEmpty()) {
        currentLang = currentLangOpt.get();
    }

    // Picking sources relevant to the current language;
    Language finalCurrentLang = currentLang;
    ArrayList<Source> relevantSources = null;
    if (sources != null) {
        relevantSources = (ArrayList<Source>) sources.stream().sorted()
                .filter(src -> src.getSourceLangCode().equals(finalCurrentLangCode))
                .collect(Collectors.toList());
    }
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
                    <div class="navbar-nav ms-auto mb-2 mb-lg-0 d-flex align-baseline">
                        <div class="nav-item">
                            <a class="nav-link me-0 mt-2 mx-3" href="/">
                                <%= currentLocale.get("home") %>
                            </a>
                        </div>
                        <%
                            if (userOnline) {
                                
                        %>
                        <div class="nav-item">
                            <a class="nav-link me-0 mt-2 mx-3" href="/profile">
                                <%= activeUser.getFullName() %>
                            </a>
                        </div>
                        <%
                            }
                        %>
                        <div class="nav-item dropdown me-3">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="<%= currentLang.getIconURL() %>" alt="lang_icon">
                            </a>
                            <ul class="dropdown-menu dropdown-text">
                                <%
                                    // Filling language dropdown with existing values;
                                    if (languages != null) {
                                        for (Language lang : languages) {
                                %>
                                        <li>
                                            <a class="dropdown-item" href="/language?lang=<%= lang.getCode() %>">
                                                <img class="me-2" src="<%= lang.getIconURL() %>" alt="en_icon">
                                                <%=lang.getName()%>
                                            </a>
                                        </li>
                                <%
                                        }
                                    }
                                %>
                            </ul>
                        </div>
                        <%
                            if (!userOnline) {
                        %>
                            <div class="nav-item">
                                <a class="nav-link me-0 mt-2 btn b-group btn-md" href="/authentication">
                                    <img src="/resources/icons/login.png" alt="login"> <%= currentLocale.get("login") %></a>
                            </div>
                        <%
                            } else {
                        %>
                            <div class="nav-item">
                                <a class="nav-link me-0 mt-2 btn b-group btn-md" href="/logout">
                                    <%= currentLocale.get("logout") %> <img src="/resources/icons/login.png" alt="login"></a>
                            </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>
<%--        Link Group--%>
        <div class="row mt-3">
            <div class="col-12 justify-content-between text-center">
                <div class="btn-group col-12">
                    <%
                        // Extraction of relevant sources' names:
                        if (relevantSources != null) {
                            for (Source source : relevantSources) {
                    %>
                    <a href="/source?src=<%= source.getSourceName() %>" class="btn b-group btn-lg"><%= source.getSourceName() %></a>
                    <%
                            }
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
</nav>