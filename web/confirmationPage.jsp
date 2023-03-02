<%-- 
    Document   : confirmationPage
    Created on : 01-Mar-2023, 11:37:26 pm
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Payment Card inserted</h1>
    </body>
    <c:forEach items="${Cards}" var="card">
        <p>Card Holder Name: ${card.cardHolderName}</p>
    </c:forEach>
</html>
