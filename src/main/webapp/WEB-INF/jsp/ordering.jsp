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
                            <c:if test="${p.sessionStatus == 0}">
                                <a href="confirmation_order?sessionId=${session.id}&cinemaHallId=${session.cinemaHall.id}&cityId=${city.id}&rowId=${row.id}&placeId=${p.id}&username=${pageContext.request.userPrincipal.name}"><i
                                        class="fa fa-square" aria-hidden="true"></i></a>
                            </c:if>
                            <c:if test="${p.sessionStatus == 1}">
                                <a href="" class="booked"><i class="fa fa-square" aria-hidden="true"></i></a>
                            </c:if>
                            <c:if test="${p.sessionStatus == 2}">
                                <a href="" class="booked-by-user"><i class="fa fa-square" aria-hidden="true"></i></a>
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
        </div>
    </section>
</ui:html>
