<%-- 
    Document   : addFnol
    Created on : 17-Feb-2023, 3:45:32 pm
    Author     : Nairwita Chakraborty
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <script src="https://code.jquery.com/jquery-3.6.3.js" 
                            integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                            crossorigin="anonymous">
    </script>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">    
        <link href="css/bootstrap.min.css" rel="stylesheet" >
        <title>Add FNOL Details</title>
    </head>
    
    

    <body class="text-center" >
        
<%--        <div class="container">
            <c:if test="${not empty SuccessMsg}">
                <h1 style="color: darkgreen"><c:out value="${SuccessMsg}"/></h1>
                <c:remove var="SuccessMsg" scope="session"/>
                <% response.setHeader("Refresh", "3;url=showall.jsp");%>
            </c:if>
            <c:if test="${not empty ErrorMsg}">
                <h1 style="color: red"><c:out value="${ErrorMsg}"/></h1>
            </c:if>
        </div>--%>

        <main class="form-control w-25 m-auto">
            <div class="mt-3">
                <div class="card-header">
                    <!--<img class="mb-5" src="images/Exavalu_Logo.png" alt="" width="300" height="100">-->
                    <h1 class="h3 mb-3 fw-normal text-center" style="color: #301934"><b>File A Home Claim</b></h1>
                </div>
                <form action="AddFnol" method="Post">
                    
                    <div class="form-floating">
                        <input type="text" value="${user.getUserId()}" class="form-control" id="floatingInput" placeholder="Driver Name" name="userId" required>
                        <label for="floatingInput">User Id</label>
                    </div>
                        
                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingInput" placeholder="Desired Place" name="place" required>
                        <label for="floatingInput">Desired Place</label>
                    </div>
                    
                    
                    <div class="form-floating">
                        <input type="date" class="form-control" id="floatingInput" placeholder="YYYY-MM-DD" name="claimDate" required>
                        <label for="floatingInput">Claim Date</label>
                    </div>
                    
                    
                    <br>
                    <button class="w-50 btn btn-lg btn-info" type="submit">Save</button>
                </form>
            </div>              
        </main>
    </body>
</html>
