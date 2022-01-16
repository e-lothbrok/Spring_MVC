<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>index</title>
</head>
<body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="<c:url value="/about"/>">Acerca de</a>
    <br/>
    <a href="<c:url value="/admin"/>">Administrador</a>
    <br/>
    <c:out value="${adminForm}"></c:out>
</body>
</html>