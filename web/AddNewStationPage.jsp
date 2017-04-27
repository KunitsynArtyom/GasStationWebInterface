<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add new station</title>
</head>
<body>
<div>Add new station</div>
<form action="AddStationServlet">
    <div>Organisation:</div>
    <input type="text" name="orgname">
    <div>Country:</div>
    <input type="text" name="country">
    <div>City:</div>
    <input type="text" name="city">
    <div>Street:</div>
    <input type="text" name="street">
    <div>Storage Cap:</div>
    <input type="text" name="capacity">
    <div><input type="submit" value="Add"></div>
</form>
</body>
</html>
