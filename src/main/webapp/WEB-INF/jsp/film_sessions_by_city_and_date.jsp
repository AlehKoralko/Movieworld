<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ page session="false" %>

<ui:html>
    <section>
        <div class="container w">
            <div class="centered">
                <div class="title col-lg-6 col-lg-offset-3">
                    <p>Сеансы фильма <font color="#f85c37">${film.name}</font> в городе <font
                            color="#f85c37">${city.name}</font></p>
                </div>
                <div class="col-lg-12">
                    <ul class="date-list">
                        <c:forEach items="${dates}" var="date" varStatus="loop">
                            <li>
                                <a href="film_sessions_by_city_and_date?filmId=${film.id}&cityId=${city.id}&date=${date.key}">${date.value}</a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="row">
                <c:if test="${!empty sessionsList}">
                    <div class="poster-block col-lg-3">
                        <img src="img/${film.name}.jpeg" alt="" class="img-responsive poster">
                        <c:forEach items="${sessionsList}" var="session" varStatus="loop">

                        </c:forEach>
                    </div>

                    <div class="session-block col-lg-9">
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
                                    <button type="button" class="btn btn-primary btn-lg">Билеты - от ${film.price} р
                                    </button>
                                </a>
                            </div>
                            <c:if test="${!loop.last}">
                                <div class="col-lg-12">
                                    <hr size="2" color="#2d2d2d">
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
        </div>
    </section>
</ui:html>
