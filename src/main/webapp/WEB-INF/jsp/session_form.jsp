<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ page session="false" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<ui:admin_html>
    <section>
        <br><br><br><br>
        <div class="container">
            <form:form method="POST" modelAttribute="sessionForm" class="form-signin">
                <h2 class="form-signin-heading">Add session form</h2>
                <spring:bind path="date">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="date" class="form-control" placeholder="date"
                                    autofocus="true"/>
                        <form:errors path="date"/>
                    </div>
                </spring:bind>

                <spring:bind path="time">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="time" class="form-control" placeholder="time"/>
                        <form:errors path="time"/>
                    </div>
                </spring:bind>
                <spring:bind path="filmId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="filmId">Films</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="filmId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="filmId" items="${films}" itemLabel="name" itemValue="id"
                                     class="selectpicker form-control dropdown" data-live-search="true"
                                     multiple="false"/>
                        <form:errors path="filmId"/>
                    </div>
                </spring:bind>
                <spring:bind path="cinemaHallId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="cinemaHallId">Cinema halls</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="cinemaHallId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="cinemaHallId" items="${cinemaHalls}" itemLabel="name" itemValue="id"
                                     class="selectpicker form-control" data-live-search="true"
                                     multiple="false"/>
                        <form:errors path="cinemaHallId"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form:form>
        </div>
    </section>
</ui:admin_html>
