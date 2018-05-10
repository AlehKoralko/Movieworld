<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ page session="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ui:html>
    <section>
        <div class="container w wb">
            <div class="row">
                <c:if test="${!empty film}">
                    <div class="col-lg-3">
                        <a href="#"><img src="img/${film.name}.jpeg" alt="" class="img-responsive poster"></a>
                        <div class="empty-block"></div>
                    </div>
                    <div class="name">
                        <div class="col-lg-2">
                            <p class="info">Название:</p>
                        </div>
                        <div class="col-lg-7">
                            <p>${film.name}</p>
                        </div>
                    </div>
                    <div class="country">
                        <div class="col-lg-2">
                            <p class="info">Страна:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list">
                                <c:forEach items="${film.countries}" var="country" varStatus="loop">
                                    <a href="search_result?searchQuery=${country.name}">${country.name}</a><c:if
                                        test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                    <div class="year">
                        <div class="col-lg-2">
                            <p class="info">Год:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list"><a href="search_result?searchQuery=${film.year}">${film.year}</a></p>
                        </div>
                    </div>
                    <div class="actors">
                        <div class="col-lg-2">
                            <p class="info">Актёры:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list">
                                <c:forEach items="${film.actors}" var="actor" varStatus="loop">
                                    <a href="search_result?searchQuery=${actor.name}">${actor.name}</a><c:if
                                        test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                    <div class="directors">
                        <div class="col-lg-2">
                            <p class="info">Режиссёр:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list">
                                <c:forEach items="${film.directors}" var="director" varStatus="loop">
                                    <a href="search_result?searchQuery=${director.name}">${director.name}</a><c:if
                                        test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                    <div class="operator">
                        <div class="col-lg-2">
                            <p class="info">Оператор:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list">
                                <c:forEach items="${film.operators}" var="operator" varStatus="loop">
                                    <a href="search_result?searchQuery=${operator.name}">${operator.name}</a><c:if
                                        test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                    <div class="genre">
                        <div class="col-lg-2">
                            <p class="info">Жанр:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list">
                                <c:forEach items="${film.genres}" var="genre" varStatus="loop">
                                    <a href="search_result?searchQuery=${genre.name}">${genre.name}</a><c:if
                                        test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                                </c:forEach>
                            </p>
                        </div>
                    </div>
                    <div class="desc">
                        <div class="col-lg-2">
                            <p class="info">Слоган:</p>
                        </div>
                        <div class="col-lg-7">
                            <p>${film.tagline}.</p>
                        </div>
                    </div>
                </c:if>
            </div>
            <hr width="100%" size="2" color="#2d2d2d">
        </div>
    </section>

    <section>
        <div class="container">
            <div class="title col-lg-12 centered">
                <p>Сеансы фильма <font color="#f85c37">${film.name}</font> в городе <font
                        color="#f85c37">${city.name}</font></p>
            </div>
            <div class="col-lg-12 centered">
                <ul class="date-list">
                    <c:forEach items="${dates}" var="date" varStatus="loop">
                        <li>
                            <a href="film_info_by_city_and_date?filmId=${film.id}&cityId=${city.id}&date=${date.key}">${date.value}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="session-block col-lg-10 col-lg-offset-1">
                <c:forEach items="${sessionsList}" var="session" varStatus="loop">
                    <div class="col-lg-2">
                        <p class="info">Кинотеатр:</p>
                    </div>
                    <div class="col-lg-3">
                        <p>${session.cinemaHall.cinema.name}</p>
                    </div>
                    <div class="col-lg-2 col-lg-offset-2">
                        <p class="info" align="right">Адрес:</p>
                    </div>
                    <div class="col-lg-3">
                        <p align="right">${session.cinemaHall.cinema.address}</p>
                    </div>
                    <div class="col-lg-2">
                        <p class="info">Кинозал:</p>
                    </div>
                    <div class="col-lg-3">
                        <p>${session.cinemaHall.name}</p>
                    </div>
                    <div class="col-lg-2 col-lg-offset-2">
                        <p class="info" align="right">Телефон:</p>
                    </div>
                    <div class="col-lg-3">
                        <p align="right">${session.cinemaHall.cinema.phone}</p>
                    </div>
                    <div class="col-lg-2">
                        <p class="info">Дата:</p>
                    </div>
                    <div class="col-lg-3">
                        <p>${session.formatDate}</p>
                    </div>
                    <div class="col-lg-2 col-lg-offset-2">
                        <p class="info" align="right">Места:</p>
                    </div>
                    <div class="col-lg-3">
                        <p align="right">${session.cinemaHall.capacity - session.freePlaces}/${session.cinemaHall.capacity}</p>
                    </div>
                    <div class="col-lg-2">
                        <p class="info">Время:</p>
                    </div>
                    <div class="col-lg-6">
                        <p>${session.formatTime}</p>
                    </div>
                    <div class="col-lg-4">
                        <a href="ordering?sessionId=${session.id}&cinemaHallId=${session.cinemaHall.id}&cityId=${city.id}&username=${pageContext.request.userPrincipal.name}">
                            <button type="button" class="btn btn-primary btn-lg">Билеты - от ${film.price} р</button>
                        </a>
                    </div>
                    <c:if test="${!loop.last}">
                        <div class="col-lg-12">
                            <hr size="2" color="#2d2d2d">
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <br>
            <hr width="100%" size="2" color="#2d2d2d">
        </div>
    </section>

    <section>
        <div class="container">
            <div class="col-lg-10 col-lg-offset-1 trailer-section">
                <iframe src="${film.trailer}" frameborder="0" allowfullscreen class="trailer"></iframe>
            </div>

            <div class="about-block">
                <div class="col-lg-10 col-lg-offset-1">
                    <p class="about">${film.about}</p>
                </div>
            </div>
        </div>
    </section>
</ui:html>
