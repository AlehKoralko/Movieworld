<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ui:html>
    <section>
        <div class="container w">
            <h1>Фильмы</h1>
            <div class="row centered">
                <c:if test="${!empty filmsList}">
                    <c:forEach items="${filmsList}" var="film">
                        <div class="col-lg-3">
                            <a href="film_info?id=${film.id}">
                                <img src="img/${film.name}.jpeg" alt="" class="img-responsive poster">
                            </a>
                            <div class="film-name">
                                <p>${film.name}</p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <br><br>
            </div>
        </div>
    </section>
</ui:html>
