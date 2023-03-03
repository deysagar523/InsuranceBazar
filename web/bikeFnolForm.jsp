<%-- 
    Document   : bikeFnolForm
    Created on : 02-Mar-2023, 10:28:03 pm
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${Claim.getClaimId()}</h1>
        <p>${Claim.getBikeNumber()}</p>
    </body>
</html>
