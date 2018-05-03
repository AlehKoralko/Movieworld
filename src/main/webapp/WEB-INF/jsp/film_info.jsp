<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>

<ui:html>
    <section>
        <div class="container w wb">
            <div class="row">
                <c:if test="${!empty film}">
                    <div class="col-lg-3">
                        <a href="#"><img src="img/${film.name}.jpeg" alt="" class="img-responsive poster"></a>
                        <div class="empty-block"><p><br><br><br><br><br></p></div>
                    </div>
                    <div>
                        <div class="col-lg-2">
                            <p class="info">Название:</p>
                        </div>
                        <div class="col-lg-7">
                            <p>${film.name}</p>
                        </div>
                    </div>
                    <div>
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
                    <div>
                        <div class="col-lg-2">
                            <p class="info">Год:</p>
                        </div>
                        <div class="col-lg-7">
                            <p class="data-list"><a href="search_result?searchQuery=${film.year}">${film.year}</a></p>
                        </div>
                    </div>
                    <div>
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
                    <div>
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
                    <div>
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
                    <div>
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
                    <div>
                        <div class="col-lg-2">
                            <p class="info">Слоган:</p>
                        </div>
                        <div class="col-lg-7">
                            <p>${film.tagline}.</p>
                        </div>
                    </div>
                    <c:if test="${!empty citiesList}">
                        <div class="genre">
                            <div class="col-lg-2">
                                <p class="info">Можно сходить:</p>
                            </div>
                            <div class="col-lg-7">
                                <p class="data-list">
                                    <c:forEach items="${citiesList}" var="city" varStatus="loop">
                                        <a href="film_sessions_by_city?filmId=${film.id}&cityId=${city.id}">${city.name}</a><c:if
                                            test="${!loop.last}">, </c:if><c:if test="${loop.last}">.</c:if>
                                    </c:forEach>
                                </p>
                            </div>
                        </div>
                    </c:if>
                </c:if>
            </div>
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
