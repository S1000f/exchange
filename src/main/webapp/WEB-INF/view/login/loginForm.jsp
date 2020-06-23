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

    <link rel="stylesheet" type="text/css" href="/resources/style/common.css">

    <link href="<c:url value="/resources/style/common.css" />" rel="stylesheet">

    <spring:url value="/resources/style/common.css" var="mainCss" />
    <link href="${mainCss}" rel="stylesheet" />

<style>

    .login-box {
        margin: 0 auto;
        background-color: #f7f8fa;
        padding-top: 20px;
        padding-bottom: 20px;
        border: 0.5px solid lightgray;
        border-radius: 5px;
    }

    .more-links {
        display: flex;
        justify-content: flex-end;
    }

</style>
</head>
<body>
    <jsp:include page="../navbar/navbar.jsp" flush="false" />

    <div class="container">
        <div class="row">
            <div class="col-md-4 login-box shadow">
                <div class="title text-center" style="padding-bottom: 30px;">
                    <h2><spring:message code="login.title" /></h2>
                </div>
                <form:form modelAttribute="loginCommand">
                <div class="errors"><form:errors /></div>
                <div class="form-group">
                    <label for="id"><spring:message code="id" />:</label>
                    <form:input path="id" class="form-control" />
                    <div class="errors">
                        <form:errors path="id"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password"><spring:message code="password" />:</label>
                    <form:password path="password" class="form-control" />
                    <div class="errors">
                        <form:errors path="password" />
                    </div>
                </div>
                <div class="form-group form-check">
                    <label class="form-check-label"><spring:message code="rememberId" />:
                    <form:checkbox path="rememberId"/>
                    </label>
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="<spring:message code="login.btn" />">
                </form:form>
                <div class="more-links">
                    <button type="button" class="btn" disabled>
                        <spring:message code="register.reminder" />
                    </button>
                    <button type="button" class="btn btn-link">
                        <a href="<c:url value='/register/step1'/>"><spring:message code="member.register" /></a>
                    </button>
                </div>
            </div>  
        </div>
    </div>
</body>
</html>