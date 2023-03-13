<%-- 
    Document   : models
    Created on : 08-Mar-2023, 12:01:59 am
    Author     : user
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${User==null}">
    <c:redirect url = "login.jsp"/>
        
    
</c:if>

        <div class="form-row">
            <div class="name">Bike Model</div>
            <div class="value">
                <div class="input-group">
                    <div class="rs-select2 js-select-simple select--no-search">
                        <select id="bikeModelCode" name="bikeModel" style="width:auto; background-color: #e0dcdb; height:45px; border-radius: 3px; border:none; color: #555;
    font-size: 16px;font-family: inherit; cursor:pointer; padding-left: 22px; padding-right: 50px;" required>
                            <option selected="selected" value="">Choose option</option>
                            <c:forEach items="${models}" var="m">

                            

                            <option style="color:#9ec645;" value="${m.getBikeModel()}">${m.getBikeModel()}</option>


                        </c:forEach>
                           
                        </select>
                        <div class="select-dropdown"></div>
                    </div>
                </div>
            </div>
        </div>
    