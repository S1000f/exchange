<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="member.register" /></title>
</head>
<body>
    <h2><spring:message code="member.info" /></h2>
    <form:form action="step2" modelAttribute="registerCommand">
        <p>
            <label><spring:message code="id" />:<br />
            <form:input path="id" />
            <form:errors path="id" />
            </label>
        </p>
        <p>
            <label><spring:message code="name" />:<br />
            <form:input path="name" />
            <form:errors path="name" />
            </label>
        </p>
        <p>
            <label><spring:message code="password" />:<br />
            <form:password path="password" />
            <form:errors path="password" />
            </label>
        </p>
        <p>
            <label><spring:message code="password.confirm" />:<br />
            <form:password path="confirmPassword" />
            <form:errors path="confirmPassword" />
            </label>
        </p>
        <input type="submit" value="<spring:message code="register.btn" />" >
    </form:form>
</body>
</html>