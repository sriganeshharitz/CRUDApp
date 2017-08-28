<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Register</h1>
	<s1:form action="register" modelAttribute="reg">
		Name:<s1:input path="uname"/><s1:errors path="uname"/><br>
		Email:<s1:input path="email"/><s1:errors path="email"/><br>
		Password:<s1:password path="password"/><s1:errors path="password"/><br>
		<input type="submit">
	</s1:form>
</body>
</html>