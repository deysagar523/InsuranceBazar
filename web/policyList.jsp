<%-- 
    Document   : policyList
    Created on : 26-Feb-2023, 11:31:34 am
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <body>
        <c:forEach items="${PolicyList}" var="policy">
        <li><a href="GetPolicyDetails?policyId=${policy.policyId}" class="dropdown-item"><i class="fa fa-car" style="font-size:20px;color:greenyellow"></i> ${policy.getPolicyName()}</a></li>
                               
                            </c:forEach>
    </body>

