<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <!-- Bootstrap 4 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<style class="common-style">
    .wrapper {
        margin-top: 100px;
    }

    .errors {
        color: tomato;
        font-size: 14px;
        height: 14px;
        display: inline-block;
    }

</style>

<style>
    .navbar {
        background-color: dodgerblue;
    }

</style>

<nav class="navbar navbar-expand-sm fixed-top navbar-dark shadow">
    <a class="navbar-brand" href="<c:url value='/main'/>" >Cointwo</a>
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
        <a class="nav-link" href="#">거래소</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="<c:url value='/balance/profit'/>" id="navbardrop" data-toggle="dropdown">
            자산
            </a>
            <div class="dropdown-menu shadow">
            <a class="dropdown-item" href="<c:url value='/balance/profit'/>"><spring:message code="balance.profit.title"/></a>
            <a class="dropdown-item" href="<c:url value='/balance/profit'/>"><spring:message code="balance.transfer.title"/></a>
            <a class="dropdown-item" href="<c:url value='/balance/transactionHistory'/>">
                <spring:message code="balance.transactionHistory.title"/></a>
            </div>
        </li>
    </ul>
    <ul class="navbar-nav">
        <c:if test="${empty authInfo}">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value='/login'/>"><spring:message code="login.title" /></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value='/register/step1'/>"><spring:message code="member.register" /></a>
            </li>
        </c:if>
        <c:if test="${! empty authInfo}">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value='/main'/>">[${authInfo.id}]<spring:message code="mypage.title" /></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value='/logout'/>"><spring:message code="logout.title" /></a>
            </li>
        </c:if>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
            language
            </a>
            <div class="dropdown-menu">
            <a class="dropdown-item" href="<c:url value='/changeLocale.do?locale=ko'/>">Ko</a>
            <a class="dropdown-item" href="<c:url value='/changeLocale.do?locale=en'/>">En</a>
            </div>
        </li>
    </ul>
</nav>