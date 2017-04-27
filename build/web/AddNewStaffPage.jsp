<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new staff</title>
</head>
<body>
<div>Add new staff</div>
<form action="AddStaffServlet">
    <div>Station:</div>
    <input type="text" name="station_id">
    <div>Surname:</div>
    <input type="text" name="surname">
    <div>Name:</div>
    <input type="text" name="name">
    <div>Gender:</div>
    <input type="text" name="gender">
    <div>Function:</div>
    <input type="text" name="function">
    <div>Salary:</div>
    <input type="text" name="salary">
    <div><input type="submit" value="Add"></div>
</form>
</body>
</html>
