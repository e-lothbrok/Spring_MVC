<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>About</title>
    </head>
    <body>
      <h1>About.jsp</h1>
      Atributos de session: <c:out value="${sessionScope.resultado}"></c:out>
    </body>
</html>
