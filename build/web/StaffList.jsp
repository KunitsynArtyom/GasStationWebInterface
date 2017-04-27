<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Staff List</title>
</head>
<body>
<table style=" border-style: solid; border-width:1px; width: 600px; border-collapse: collapse;">
    <thead>
    <tr style="background-color: gray;">
        <td style="width: 30px;">StationId</td>
        <td style="width: 30px;">StaffId</td>
        <td style="width: 80px;">Surname</td>
        <td style="width: 80px;">Name</td>
        <td style="width: 80px;">Gender</td>
        <td style="width: 120px;">Function</td>
        <td style="width: 80px;">Salary</td>
    </tr>
    </thead>
    <c:forEach items="${staffList}" var="staff">
    <tr>
        <td><c:out value="${staff.getStationId()}"/></td>
        <td><c:out value="${staff.getStaffId()}"/></td>
        <td><c:out value="${staff.getSurname()}"/></td>
        <td><c:out value="${staff.getName()}"/></td>
        <td><c:out value="${staff.getGender()}"/></td>
        <td><c:out value="${staff.getFunction()}"/></td>
        <td><c:out value="${staff.getSalary()}"/></td>
    </tr>
    </c:forEach>
</body>
<body>
<form action="SelectStaffByIdServlet">
    <div>Enter staff's id to update:</div>
    <input type="text" name="id">
    <input type="submit" value="Update staff's info">
</form>
</body>
</html>
