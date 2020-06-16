<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="login.title" /></title>
</head>
<body>
    <form:form modelAttribute="loginCommand" >
    <form:errors />
    <p>
        <label for=""><spring:message code="id" />:<br />
        <form:input path="id" />
        <form:errors path="id" />
        </label>
    </p>
    <p>
        <label for=""><spring:message code="password" />:<br />
        <form:password path="password" />
        <form:errors path="password" />
        </label>
    </p>
    <p>
        <label for=""><spring:message code="rememberId" />:
        <form:checkbox path="rememberId" />
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
    </form:form>
</body>
</html>