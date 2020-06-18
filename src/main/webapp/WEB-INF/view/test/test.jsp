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
            <div class="col-md-4 register-box">
                <div class="title text-center" style="padding-bottom: 30px;">
                    <h2><spring:message code="member.register" /></h2>
                </div>
                <div class="title text-center" style="padding-bottom: 30px;">
                    <c:if test="${! empty registerCommand}" >
                    <h3>
                        <spring:message code="register.done" arguments="${registerCommand.name}, ${registerCommand.id}" />
                    </h3>
                    </c:if>
                </div>
                <div class="alert alert-success alert-dismissible fade show">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <strong><spring:message code="success" /></strong> <spring:message code="register.done2" />
                </div>
                <a class="btn btn-primary btn-block" href="<c:url value='/login'/>">
                    <spring:message code="login.title" />
                </a>
                <a class="btn btn-secondary btn-block" href="<c:url value='/main'/>">
                    <spring:message code="go.main" />
                </a>
            </div>
        </div>
    </div>
</body>
</html>