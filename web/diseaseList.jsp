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


        <div class="form-row">
        <div class="name">Disease</div>
        <div class="value">
            <div class="input-group">
                <div class="rs-select2 js-select-simple select--no-search">
                    <select name="disease" style="width:auto; background-color: #e0dcdb; height:45px; border-radius: 3px; border:none; color: #555;
    font-size: 16px;font-family: inherit; cursor:pointer; padding-left: 22px; padding-right: 50px;" required>
                        <option value="">Select an option</option>

                        <c:forEach items="${diseases}" var="disease">

                            

                            <option style="color:#9ec645;" value="${disease.getDiseaseName()}">${disease.getDiseaseName()}</option>


                        </c:forEach>
                    </select>
                    <div class="select-dropdown"></div>
                </div>
            </div>
        </div>
    </div>


