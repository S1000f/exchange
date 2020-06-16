<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="member.register" /></title>
</head>
<body>
    <p>
        <spring:message code="register.done" arguments="${registerCommand.name}, ${registerCommand.id}" />
    </p>
    <p><a href="<c:url value='/main'/>">[<spring:message code="go.main" />]</a></p>
</body>
</html>