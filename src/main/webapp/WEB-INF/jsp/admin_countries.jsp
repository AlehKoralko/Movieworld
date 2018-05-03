<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ui" %>
<%@ page session="false" %>

<ui:admin_html>
    <section>
        <div class="container">
            <div class="row centered">
                <br><br><br><br>
                <div class="col-lg-8 col-lg-offset-2">
                    <h1>Countries list</h1>
                </div>
            </div>
            <c:if test="${!empty countries}">
                <table class="table">
                    <tr>
                        <th width="80px">ID</th>
                        <th width="300px">Name</th>
                        <th width="60px">Edit</th>
                        <th width="60px">Delete</th>
                    </tr>
                    <c:forEach items="${countries}" var="country">
                        <tr>
                            <td>${country.id}</td>
                            <td>${country.name}</td>
                            <td><a href="<c:url value='/edit_country?countryId=${country.id}'/>" title="edit"><i
                                    class="fa fa-pencil" aria-hidden="true"></i></a></td>
                            <td><a href="<c:url value='/remove_country?countryId=${country.id}'/>" title="delete"><i
                                    class="fa fa-trash-o" aria-hidden="true"></i></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <h2>Add country</h2>

            <c:url var="search" value="/admin_countries/edit"/>
            <form:form action="${search}" commandName="country">
                <table>
                    <c:if test="${!empty country.name}">
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="id" readonly="true" size="8" disabled="true"/>
                                <form:hidden path="id"/>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>
                            <form:label path="name">
                                <spring:message text="Full name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <c:if test="${!empty country.name}">
                                <input type="submit"
                                       value="<spring:message text="Edit Country"/>"/>
                            </c:if>
                            <c:if test="${empty country.name}">
                                <input type="submit"
                                       value="<spring:message text="Add Country"/>"/>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </section>
</ui:admin_html>
