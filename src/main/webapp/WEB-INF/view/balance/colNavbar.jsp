<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>

</style>

<div class="col-sm-2">
    <ul class="nav flex-column">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value='/balance/profit'/>">
            <h5><spring:message code="balance.profit.title"/></h5></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value='/balance/profit'/>">
            <h5><spring:message code="balance.transfer.title"/></h5></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value='/balance/transactionHistory'/>">
            <h5><spring:message code="balance.transactionHistory.title"/></h5></a>
        </li>
    </ul>
</div>