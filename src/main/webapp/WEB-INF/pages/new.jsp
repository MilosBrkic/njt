<%-- 
    Document   : new
    Created on : 22.04.2020., 17.04.23
    Author     : milos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add department</title>
    </head>
    <body>
         <%@include file="header.jsp" %>
         
         <div class="container">
            <form action="/milos/app/save" method="post">
                    <div class="form-group">
                        <label for="shortname">Shortname:</label>
                        <input type="text" class="form-control" id="shortname" name="shortname" required>               
                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" name="name" id="name" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Add</button>
                </form>
            <p class="text-danger" >${message}</p>
        </div>
         
    </body>
</html>
