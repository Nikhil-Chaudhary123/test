<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
function edit() {
	document.success.action="edit";
	document.success.submit();
}

function del() {
	document.success.action="delete";
	document.success.submit();
}

</script>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  name="success">
<h2>------ All Data ------</h2>
<table align="center" border="4"  bordercolor="green" cellpadding="4" cellspacing="5"  width="800">
<thead>
<tr>
<th> Select</th>
<th>Id</th>
<th>First Name</th>

<th>Username</th>
<th>Password</th>
</tr>
</thead>
<c:forEach items="${data}" var="s">
<tr>

<td><input type="radio" name="rd" value="${s.id}"></td>
<td><c:out value="${s.id}"></c:out></td>
<td><c:out value="${s.name}"></c:out></td>
<td><c:out value="${s.uname}"></c:out></td>
<td><c:out value="${s.pass}"></c:out></td>

</tr>
</c:forEach>
<tr>
<td colspan="2"><input type="button" value="Edit" onclick="edit()"></td>
<td colspan="2"><input type="button" value="Delete" onclick="del()"></td>
<!--<td colspan="2"><input type="button" action="reg.jsp" ></td>  -->
</tr>
</table>


</form>
</body>
</html>