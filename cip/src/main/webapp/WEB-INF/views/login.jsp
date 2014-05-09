<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<?xml version="1.0" encoding="UTF-8" ?>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/cip/resources/styles/login.css"
	type="text/css" />
<title>Login to Cimplist PMS</title>
</head>


<body>
	<div id="main_wrapper">
		<a href="${webctx}"><img
			src="${webctx}/resources/images/company-logo.png" /></a>
		<h2>Login to Employee Performance System</h2>

		<c:if test="${!empty param.login_error}">
			<div style="color: red; margin-bottom: 1em; font-size: large;">
				Incorrect User Name and/or Password</div>
		</c:if>


		<form action="<c:url value='/j_spring_security_check'/>" method="post">
			<table>
				<tr>
					<td>User Name:</td>
					<td><input type="text" name="j_username" value="${userName}"
						placeholder="Type Login name" required="required"/></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="j_password"
						placeholder="Type Password" required="required"/></td>
				</tr>
				<tr>
					<td colspan='2' align="center" style="font-size: 1em;"><input
						name="submit" type="submit" value="Login"
						style="padding: 5px; padding-right: 10px; padding-left: 10px; font-size:1em; " /></td>
				</tr>
			</table>
		</form>

	</div>
</body>

</html>
