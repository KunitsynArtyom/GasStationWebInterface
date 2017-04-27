<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error List</title>
</head>
<body>
<c:forEach items="${errors}" var="string">
    <br>
    <td><c:out value="${string}"/></td>
    </br>
</c:forEach>
</body>
</html>
