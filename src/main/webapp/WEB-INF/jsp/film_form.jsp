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
            <form:form method="POST" modelAttribute="film" class="form-signin">
                <h2 class="form-signin-heading">Add film form</h2>
                <spring:bind path="name">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="name" class="form-control" placeholder="name"
                                    autofocus="true"/>
                        <form:errors path="name"/>
                    </div>
                </spring:bind>

                <spring:bind path="year">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="year" class="form-control" placeholder="year"/>
                        <form:errors path="year"/>
                    </div>
                </spring:bind>
                <spring:bind path="tagline">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="tagline" class="form-control" placeholder="tagline"/>
                        <form:errors path="tagline"/>
                    </div>
                </spring:bind>
                <spring:bind path="trailer">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="url" path="trailer" class="form-control" placeholder="trailer"/>
                        <form:errors path="trailer"/>
                    </div>
                </spring:bind>
                <spring:bind path="about">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:textarea type="text" path="about" class="form-control" placeholder="about"/>
                        <form:errors path="about"/>
                    </div>
                </spring:bind>
                <spring:bind path="dateStart">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="dateStart" class="form-control" placeholder="date start"/>
                        <form:errors path="dateStart"/>
                    </div>
                </spring:bind>
                <spring:bind path="dateEnd">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="text" path="dateEnd" class="form-control" placeholder="date end"/>
                        <form:errors path="dateEnd"/>
                    </div>
                </spring:bind>
                <spring:bind path="actorsId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="actorsId">Actors</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="actorsId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="actorsId" items="${actors}" itemLabel="name" itemValue="id"
                                     class="selectpicker" data-live-search="true"/>
                        <form:errors path="actorsId"/>
                    </div>
                </spring:bind>
                <spring:bind path="directorsId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="actorsId">Directors</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="directorsId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="directorsId" items="${directors}" itemLabel="name" itemValue="id"
                                     class="selectpicker" data-live-search="true"/>
                        <form:errors path="directorsId"/>
                    </div>
                </spring:bind>
                <spring:bind path="operatorsId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="operatorsId">Operators</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="operatorsId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="operatorsId" items="${operators}" itemLabel="name" itemValue="id"
                                     class="selectpicker" data-live-search="true"/>
                        <form:errors path="operatorsId"/>
                    </div>
                </spring:bind>
                <spring:bind path="genresId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="genresId">Operator</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="genresId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="genresId" items="${genres}" itemLabel="name" itemValue="id"
                                     class="selectpicker" data-live-search="true"/>
                        <form:errors path="genresId"/>
                    </div>
                </spring:bind>
                <spring:bind path="countriesId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label path="countriesId">Country</form:label>
                    </div>
                </spring:bind>
                <spring:bind path="countriesId">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:select path="countriesId" items="${countries}" itemLabel="name" itemValue="id"
                                     class="selectpicker" data-live-search="true"/>
                        <form:errors path="countriesId"/>
                    </div>
                </spring:bind>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            </form:form>
        </div>
    </section>
</ui:admin_html>
