<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>
        <spring:message code="login.title"/>
    </title>

    <link href="css/style.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <spring:message code="username" var="username"/>
    <spring:message code="password" var="password"/>
    <spring:message code="password.confirm" var="passwordConfirm"/>
    <spring:message code="login.submit" var="loginSubmit"/>
    <spring:message code="registration.submit" var="registrationSubmit"/>
    <spring:message code="login.form.name" var="loginFormName"/>
    <spring:message code="registration.form.name" var="registrationFormName"/>
</head>

<body>

    <div class="login-wrap">
        <div class="login-html">
            <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">${loginFormName}</label>
            <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">${registrationFormName}</label>
            <div class="login-form">
                <form action="${contextPath}/login" method="post" class="sign-in-htm">
                    <div class="group ${error != null ? 'has-error' : ''}">
                        <label for="username" class="label">${username}</label>
                        <input id="username" name="username" type="text" class="input" autofocus="true">
                    </div>
                    <div class="group ${error != null ? 'has-error' : ''}">
                        <label for="password" class="label">${password}</label>
                        <input id="password" name="password" type="password" class="input">
                        <span>${error}</span>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="group">
                        <input type="submit" class="button" value="${loginSubmit}">
                    </div>
                    <div class="hr"></div>
                </form>
                <form:form method="post" action="${contextPath}/registration" modelAttribute="userForm" class="sign-up-htm">
                    <div class="group ${status.error ? 'has-error' : ''}">
                        <label for="username" class="label">${username}</label>
                        <form:input id="username" type="text" path="username" class="input" autofocus="true"/>
                        <form:errors path="username" cssClass="has-error"/>
                    </div>
                    <div class="group ${status.error ? 'has-error' : ''}">
                        <label for="password" class="label">${password}</label>
                        <form:input id="password" type="password" path="password" class="input"/>
                        <form:errors path="password" cssClass="has-error"/>
                    </div>
                    <div class="group ${status.error ? 'has-error' : ''}">
                        <label for="confirmPassword" class="label">${passwordConfirm}</label>
                        <form:input id="confirmPassword" type="password" path="confirmPassword" class="input"/>
                        <form:errors path="confirmPassword" cssClass="has-error"/>
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="${registrationSubmit}">
                    </div>
                    <div class="hr"></div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>
