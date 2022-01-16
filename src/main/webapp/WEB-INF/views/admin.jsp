<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            jQuery(".confirm").on("click", function () {
                return confirm("Va a elimininar un registro. ¿Continuar?");
            });
        });
    </script>
    <title>Admin</title>
</head>
<body>
<h1>admin.jsp</h1>
<form:form action="${pageContext.request.contextPath}/admin/save" method="post" modelAttribute="admin">
    <table>
        <c:if test="${admin.id ne 0}">
            <form:input path="id" type="hidden"/>
            <form:input path="fechaCreacion" type="hidden"/>
        </c:if>
        <tr>
            <td>Nombre</td>
            <td><form:input path="nombre" type="text"/></td>
        </tr>
        <tr>
            <td>Cargo</td>
            <td><form:input path="cargo" type="text"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Guardar cambios"></td>
        </tr>
    </table>
</form:form>
<br/>
<c:out value="${resultado}"></c:out>
<br/>
<br/>
<c:forEach items="${admins}" var="admin">
    <c:out value="${admin}"></c:out>
    <a href="<c:url value="/admin/${admin.id}/update"/>">Actualizar</a>
    <a class="confirm" href="<c:url value="/admin/${admin.id}/delete"/>">Eliminar</a>
    <br/>
</c:forEach>
</body>
</html>
