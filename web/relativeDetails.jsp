<%-- 
    Document   : diseaseList
    Created on : 07-Mar-2023, 12:33:51 am
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>
        
    
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>



        <c:forEach items="${relatives}" var="r">

        <div class="form-row">
            <div class="name">${r.getRelativeType()}'s Age</div>
            <div class="value">
                <div class="input-group">

                    <c:if test="${r.getRelativeType().equalsIgnoreCase('Father') or r.getRelativeType().equalsIgnoreCase('Mother')}">

                        <input class="input--style-5" type="number" min="40" max="70" name="relativeAge" required>
                    </c:if>
                    <c:if test="${r.getRelativeType().equalsIgnoreCase('Son') or r.getRelativeType().equalsIgnoreCase('Daughter')}">
                        <input class="input--style-5" type="number" min="1" max="25" name="relativeAge" required>
                    </c:if>
                    <c:if test="${r.getRelativeType().equalsIgnoreCase('Spouse')}">
                        <input class="input--style-5" type="number" min="18" max="70" name="relativeAge" required>
                    </c:if>


                </div>
            </div>
        </div>

        <div class="form-row">
            <div class="name">${r.getRelativeType()}'s Name</div>
            <div class="value">
                <div class="input-group">
                    <input class="input--style-5" type="text" name="relativeName" required>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="name">${r.getRelativeType()}'s Adhar Card</div>
            <div class="value">
                <div class="input-group">
                    <input class="input--style-5" type="text" name="relationAdhar" minlength="12" maxlength="12" required>
                </div>
            </div>
        </div>








    </c:forEach>
</select>
<div class="select-dropdown"></div>
</div>
</div>
</div>
</div>

</body>
</html>
