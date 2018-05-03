<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ page session="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ui:html>
    <section class="ordering">
        <div class="container">
            <div class="title centered">
                <p>Схема кинозала <font color="#f85c37">${session.cinemaHall.name}</font> кинотеатра
                    <font color="#f85c37">${session.cinemaHall.cinema.name}</font> в городе
                    <font color="#f85c37">${city.name}</font></p>
            </div>

            <div class="hall centered col-lg-10 col-lg-offset-1">
                <c:forEach items="${rows}" var="row">
                    <div>
                        <c:forEach items="${row.places}" var="p">
                            <c:if test="${p.sessionStatus == 0 && p.id != place.id}">
                                <a href="confirmation_order?sessionId=${session.id}&cinemaHallId=${session.cinemaHall.id}&cityId=${city.id}&rowId=${row.id}&placeId=${p.id}&username=${pageContext.request.userPrincipal.name}"><i
                                        class="fa fa-square" aria-hidden="true"></i></a>
                            </c:if>
                            <c:if test="${p.sessionStatus == 1}">
                                <a href="" class="booked"><i class="fa fa-square" aria-hidden="true"></i></a>
                            </c:if>
                            <c:if test="${p.sessionStatus == 2}">
                                <a href="" class="booked-by-user"><i class="fa fa-square" aria-hidden="true"></i></a>
                            </c:if>
                            <c:if test="${p.id == place.id}">
                                <a href="" class="selected-by-user"><i class="fa fa-square" aria-hidden="true"></i></a>
                            </c:if>
                        </c:forEach>
                    </div>
                </c:forEach>
            </div>
            <hr width="100%" size="2" color="#2d2d2d">
        </div>
    </section>

    <section class="ordering">
        <div class="container">
            <div class="guide centered">
                <div class="col-lg-3">
                    <p><a href="" class="free"><i class="fa fa-square" aria-hidden="true"></i></a> - свободные места</p>
                </div>
                <div class="col-lg-3">
                    <p><a href="" class="booked"><i class="fa fa-square" aria-hidden="true"></i></a> - забронированные
                        места</p>
                </div>
                <div class="col-lg-3">
                    <p><a href="" class="booked-by-user"><i class="fa fa-square" aria-hidden="true"></i></a> - ваши
                        места</p>
                </div>
                <div class="col-lg-3">
                    <p><a href="" class="selected-by-user"><i class="fa fa-square" aria-hidden="true"></i></a> -
                        выбранное место</p>
                </div>
            </div>
            <hr width="100%" size="2" color="#2d2d2d">
        </div>
    </section>

    <section class="ordering">
        <div class="container">
            <div class="title centered">
                <p>Оформление билета</p>
            </div>
            <div class="session-block col-lg-10 col-lg-offset-1">
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
                    <p class="info" align="right">Ряд:</p>
                </div>
                <div class="col-lg-3">
                    <p align="right">${row.number}</p>
                </div>
                <div class="col-lg-2">
                    <p class="info">Время:</p>
                </div>
                <div class="col-lg-3">
                    <p>${session.formatTime}</p>
                </div>
                <div class="col-lg-2 col-lg-offset-2">
                    <p class="info" align="right">Место:</p>
                </div>
                <div class="col-lg-3">
                    <p align="right">${place.number}</p>
                </div>
                <div class="col-lg-2">
                    <p class="info">Фильм:</p>
                </div>
                <div class="col-lg-5">
                    <p>${session.film.name}</p>
                </div>
                <div class="col-lg-2">
                    <p class="info" align="right">Стоимость:</p>
                </div>
                <div class="col-lg-3">
                    <p align="right">${session.film.price} p</p>
                </div>
                <div class="col-lg-4 col-lg-offset-4">
                    <a href="order/add?username=${pageContext.request.userPrincipal.name}&placeId=${place.id}&sessionId=${session.id}">
                        <button type="button" class="btn btn-primary btn-lg">Купить</button>
                    </a>
                </div>
            </div>
        </div>
    </section>
</ui:html>
