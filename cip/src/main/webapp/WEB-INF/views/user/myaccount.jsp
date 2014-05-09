<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<security:authentication property="principal" var="principal"
	scope="page" />
<h1> ${user.fname}'s Account</h1>
<table class="data-table">
	<tr>
		<th>User Name</th>
		<td>${user.userName}</td>
	</tr>
	<tr>
		<th>First Name</th>
		<td>${user.fname}</td>
	</tr>	
	<tr>
		<th>Middle Name</th>
		<td>${user.mname}</td>
	</tr>	
	<tr>
		<th>Last Name</th>
		<td>${user.lname}</td>
	</tr>	
	<tr>
		<th>Email</th>
		<td>${user.email}</td>
	</tr>	
	<tr>
	<th>Manager Name</th>
		<td>${user.manager.fname} &nbsp; ${user.manager.lname}</td>
	</tr>
	<tr>	
	<th>Roles Assigned</th>
		<td>
			<c:forEach items="${user.roles}" var="role">
   				<li>${role.name}</li>
			</c:forEach>
		</td>
	</tr>			
</table>
