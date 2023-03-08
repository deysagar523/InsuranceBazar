<%-- 
    Document   : models
    Created on : 08-Mar-2023, 12:01:59 am
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-row">
            <div class="name">Bike Model</div>
            <div class="value">
                <div class="input-group">
                    <div class="rs-select2 js-select-simple select--no-search">
                        <select id="bikeModelCode" name="bikeModel" required>
                            <option selected="selected" value="">Choose option</option>
                            <c:forEach items="${models}" var="m">

                            

                            <option value="${m.getBikeModel()}">${m.getBikeModel()}</option>


                        </c:forEach>
                           
                        </select>
                        <div class="select-dropdown"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
