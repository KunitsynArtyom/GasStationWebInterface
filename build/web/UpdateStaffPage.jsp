<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update staff's info</title>
</head>
<body>
<form action="UpdateStaffServlet">
    <div>Station:</div>
    <input readonly type="text" value="${station_id}" name="station_id">
    <div>Surname:</div>
    <input type="text" value="${name}" name="surname">
    <div>Name:</div>
    <input type="text" value="${surname}" name="name">
    <div>Gender:</div>
    <input type="text" value="${gender}" name="gender">
    <div>Function:</div>
    <input type="text" value="${function}" name="function">
    <div>Salary:</div>
    <input type="text" value="${salary}" name="salary">
    <div><input type="submit" value="Update"></div>
</form>
</body>
</html>
