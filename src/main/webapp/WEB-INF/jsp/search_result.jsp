<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ui:html>
    <section>
        <div class="container w">
            <div class="centered">
                <h1>Фильмы по запросу - "<font color="#f85c37">${searchQuery}</font>"</h1>
                <c:if test="${!empty filmsByName}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByName}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByActor}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByActor}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmByGenre}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmByGenre}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByCity}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByCity}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByDirector}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByDirector}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByOperator}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByOperator}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByYear}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByYear}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByCountries}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByCountries}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <c:if test="${!empty filmsByDate}">
                    <hr width="100%" size="2" color="#2d2d2d">
                    <c:forEach items="${filmsByDate}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}"><img src="img/${film.name}.jpeg" alt=""
                                                                   class="img-responsive poster"></a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </section>
</ui:html>
