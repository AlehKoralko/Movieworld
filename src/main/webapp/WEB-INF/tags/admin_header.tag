<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<header>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="admin">adminpage</a>
                <a class="navbar-brand" href="films">userpage</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            Добавить<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="film_form">Фильмы</a></li>
                            <li class="divider"></li>
                            <li><a href="session_form">Сеансы</a></li>
                            <li class="divider"></li>
                            <li><a href="actor_form">Актеры</a></li>
                            <li class="divider"></li>
                            <li><a href="genre_form">Жанры</a></li>
                            <li class="divider"></li>
                            <li><a href="director_form">Режиссеры</a></li>
                            <li class="divider"></li>
                            <li><a href="operator_form">Операторы</a></li>
                            <li class="divider"></li>
                            <li><a href="country_form">Страны</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                            Изменить/удалить<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="">Фильмы</a></li>
                            <li class="divider"></li>
                            <li><a href="">Сеансы</a></li>
                            <li class="divider"></li>
                            <li><a href="admin_actors">Актеры</a></li>
                            <li class="divider"></li>
                            <li><a href="admin_genres">Жанры</a></li>
                            <li class="divider"></li>
                            <li><a href="admin_directors">Режиссеры</a></li>
                            <li class="divider"></li>
                            <li><a href="admin_operators">Операторы</a></li>
                            <li class="divider"></li>
                            <li><a href="admin_countries">Страны</a></li>
                        </ul>
                    </li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
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
</header>
