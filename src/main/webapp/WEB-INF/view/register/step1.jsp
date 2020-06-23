<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="member.register" /></title>
</head>
<style>
    .register-box {
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
<body>
    <jsp:include page="../navbar/navbar.jsp" flush="false" />

    <div class="container">
        <div class="row">
            <div class="col-md-4 register-box shadow">
                <div class="title text-center" style="padding-bottom: 30px;">
                    <h2><spring:message code="member.register" /></h2>
                </div>
                <form:form action="step2" modelAttribute="registerCommand">
                    <div class="form-group">
                        <label><spring:message code="id" />:
                        <form:input path="id" class="form-control" />
                        <div class="errors"><form:errors path="id" /></div>
                        </label>
                    </div>
                    <div class="form-group">
                        <label><spring:message code="name" />:
                        <form:input path="name" class="form-control"/>
                        <div class="errors"><form:errors path="name" /></div>
                        </label>
                    </div>
                    <div class="form-group">
                        <label><spring:message code="password" />:<br />
                        <form:password path="password" class="form-control"/>
                        <div class="errors"><form:errors path="password" /></div>
                        </label>
                    </div>
                    <div class="form-group">
                        <label><spring:message code="password.confirm" />:<br />
                        <form:password path="confirmPassword" class="form-control"/>
                        <div class="errors"><form:errors path="confirmPassword" /></div>
                        </label>
                    </div>
                    <input type="submit" class="btn btn-primary btn-block" value="<spring:message code="register.btn" />" >
                </form:form>
                <div class="more-links">
                    <button type="button" class="btn" disabled>
                        <spring:message code="login.reminder" />
                    </button>
                    <button type="button" class="btn btn-link">
                        <a href="<c:url value='/login'/>">
                        <spring:message code="login.title" /></a>
                    </button>
                </div>
            </div>  
        </div>
    </div>
</body>
</html>