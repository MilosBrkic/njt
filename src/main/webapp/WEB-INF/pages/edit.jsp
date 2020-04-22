<%-- 
    Document   : edit
    Created on : 22.04.2020., 18.16.57
    Author     : milos
--%>

<%@page import="brkic.milos.fon.fisweb.domen.Department"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit department</title>
    </head>
    <body>
         <%@include file="header.jsp" %>

         <div class="container">
            <form action="/milos/app/save" method="post">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text" class="form-control" id="id" name="id" value="${department.id}" readonly>               
                    </div>
                    <div class="form-group">
                        <label for="shortname">Shortname:</label>
                        <input type="text" class="form-control" id="shortname" name="shortname" value="${department.shortname}" required>               
                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text" class="form-control" name="name" id="name" value="${department.name}" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </form>
            <p class="text-danger" >${message}</p>
        </div>
         
    </body>
</html>
