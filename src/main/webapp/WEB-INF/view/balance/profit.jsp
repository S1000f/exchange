<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Balance-Profit</title>
</head>
<style>
</style>
<body>
    <jsp:include page="../navbar/navbar.jsp" flush="false" />
    <div class="container wrapper">
        <div class="row">
            <jsp:include page="colNavbar.jsp" flush="false" />
            <div class="col-md-10">
                <div class="top-box">
                    <h2><spring:message code="balance.profit.title"/></h2>
                    <c:if test="${empty authInfo}">
                        <h3>Welcome</h3>
                    </c:if>
                    <c:if test="${! empty authInfo}">
                        <h3>${authInfo.name}님 환영합니다.</h3><br />
                        <h4>tender: ${accountDto.strTender} 원<br />
                            BTC: ${accountDto.btc}<br />
                            ETH: ${accountDto.eth}<br />
                        </h4>
                    </c:if>
                </div>
                <div class="bottom-box">
                    <h4>another box<br />
                    ${accountDto.status}</h4>
                </div>
            </div>
        </div>
    </div>
</body>
</html>