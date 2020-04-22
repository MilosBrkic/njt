<%-- 
    Document   : departments
    Created on : 22.04.2020., 16.53.20
    Author     : milos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        
        <div class ="container">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Shortname</th>
                        <th>Name</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dep" items="${applicationScope.departments}">
                        <tr>
                            <td>${dep.id}</td>
                            <td>${dep.shortname}</td>
                            <td>${dep.name}</td>
                            <td>
                                <a href="/milos/app/delete/${dep.id}">Delete</a>
                            </td>
                            <td>
                                <a href="/milos/app/edit/${dep.id}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <p class="text-danger" >${message}</p>    
        </div>
    </body>
</html>
