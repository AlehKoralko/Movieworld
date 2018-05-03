<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<header>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <c:url var="search" value="/search?${_csrf.parameterName}=${_csrf.token}"/>
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="films">Movie world</a>
            </div>
            <form action="${search}" method="POST">
                <div class="col-lg-3 col-lg-offset-1">
                    <div class="input-group">
                        <input type="text" class="form-control" name="searchQuery" id="searchQuery" placeholder="Поиск">
                        <span class="input-group-btn"><button class="btn btn-default" type="submit"><i
                                class="fa fa-search"
                                aria-hidden="true"></i>
                        </button>
                        </span>
                    </div><!-- /input-group -->
                </div>
            </form>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="films">Фильмы</a></li>
                    <li><a href="films_by_city?cityId=1">Витебск</a></li>
                    <li><a href="films_by_city?cityId=4">Новополоцк</a></li>
                    <li><a href="films_by_city?cityId=3">Полоцк</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="login">Войти</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li>
                            <a href="" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-expanded="false">
                                    ${pageContext.request.userPrincipal.name}<span class="caret"></span></a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <form id="logoutForm" method="POST" action="${contextPath}/logout">
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                    <a onclick="document.forms['logoutForm'].submit()">Выйти</a>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>

    <div id="headerwrap">
        <div class="container">
            <div class="row centered">
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>Movieworld</h1>
                    <h2>Фильмы в твоем городе!</h2>
                </div>
            </div>
        </div>
    </div>
</header>
