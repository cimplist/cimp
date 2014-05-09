<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="webctx" value="${pageContext.servletContext.contextPath}"/>  
<security:authentication property="principal" var="principal" scope="page" />

<table>
<tr>
<td><a href="${webctx}"><img src="${webctx}/resources/images/company-logo.png"/></a></td>
	<security:authorize access="isAnonymous()">
		<td><a href="${webctx}/signup">Signup</a> &nbsp; <a href="${webctx}/login">Login</a></td>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<td><a href="${webctx}/j_spring_security_logout">Logout ${principal.username}</a></td>
	</security:authorize>

</tr>
</table>
