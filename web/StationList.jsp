<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Station List</title>
</head>
<body>
<table style=" border-style: solid; border-width:1px; width: 600px; border-collapse: collapse;">
    <thead>
    <tr style="background-color: gray;">
        <td style="width: 30px;">Id</td>
        <td style="width: 80px;">Organisation</td>
        <td style="width: 80px;">Country</td>
        <td style="width: 80px;">City</td>
        <td style="width: 120px;">Street</td>
        <td style="width: 80px;">Storage Cap</td>
    </tr>
    </thead>
    <c:forEach items="${stationList}" var="station">
    <tr>
        <td><c:out value="${station.getStationId()}"/></td>
        <td><c:out value="${station.getOrgname()}"/></td>
        <td><c:out value="${station.getCountry()}"/></td>
        <td><c:out value="${station.getCity()}"/></td>
        <td><c:out value="${station.getStreet()}"/></td>
        <td><c:out value="${station.getStoragecap()}"/></td>
    </tr>
    </c:forEach>
</body>
</html>
