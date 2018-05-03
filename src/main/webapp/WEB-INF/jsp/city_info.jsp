<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie world</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/${city.name}.css">
    <link rel="stylesheet" href="css/city_info.css">
</head>
<body>
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
                <a class="navbar-brand" href="films.html">Movie world</a>
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
                    <c:forEach items="${allCities}" var="city">
                        <li><a href="films_by_city?cityId=${city.id}">${city.name}</a></li>
                    </c:forEach>
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="login">Войти</a></li>
                    </c:if>
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

<section>
    <div class="city-poster">
        <div class="container">
            <div class="row centered">
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>${city.name}</h1>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="centered">
            <div class="col-lg-6 col-lg-offset-3">
                <p>Кинотеатры города <span class="title">${city.name}</span></p>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="city">
            <c:forEach items="${city.cinemas}" var="cinema" varStatus="loop">
                <div class="n">
                    <div class="col-lg-2">
                        <p class="info">Название:</p>
                    </div>
                    <div class="col-lg-10">
                        <p>${cinema.name}.</p>
                    </div>
                </div>
                <div class="n">
                    <div class="col-lg-2">
                        <p class="info">Кинозалы:</p>
                    </div>
                    <div class="col-lg-10">
                        <p>
                            <c:forEach items="${cinema.cinemaHalls}" var="hall" varStatus="loop">
                                ${hall.name}<c:if test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                            </c:forEach>
                        </p>
                    </div>
                </div>
                <div class="n">
                    <div class="col-lg-2">
                        <p class="info">Адрес:</p>
                    </div>
                    <div class="col-lg-10">
                        <p>${cinema.address}.</p>
                    </div>
                </div>
                <div class="n">
                    <div class="col-lg-2">
                        <p class="info">Описание:</p>
                    </div>
                    <div class="col-lg-10">
                        <p>${cinema.description}.</p>
                    </div>
                </div>
                <div class="n">
                    <c:if test="${!loop.last}">
                        <div class="col-lg-12">
                            <hr size="2" color="#2d2d2d">
                        </div>
                    </c:if>
                </div>
            </c:forEach>
        </div>

    </div>
</section>

<footer>
    <div class="container">
        <div class="row centered">
            <a href="https://vk.com/first_mockingbird" target="_blank"><i class="fa fa-vk"></i></a>
            <a href=""><i class="fa fa-skype"></i></a>
            <a href=""><i class="fa fa-facebook"></i></a>
            <a href=""><i class="fa fa-youtube"></i></a>
            <a href="" target="_blank"><i class="fa fa-envelope-open-o" aria-hidden="true"></i></a>
        </div>
    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
