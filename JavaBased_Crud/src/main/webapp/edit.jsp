<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
<c:set value="${data}" var="e"></c:set>
<form action="up">
Id: <input type="hidden" name="id" value="${e.id}"><br><br>
First Name: <input type="text" name="fname" value="${e.name}"><br><br>
User Name: <input type="text" name="uname" value="${e.uname}"><br><br>
Password: <input type="text" name="pass" value="${e.pass}"><br><br>
<input type="submit"  value="Update"><br><br>
</form>
</body>
</html>