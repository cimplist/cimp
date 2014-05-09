<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<security:authentication property="principal" var="principal"
	scope="page" />
<h1> ${user.fname}'s Team</h1>
<table class="data-table">
	<tr>
		<th>User Name</th>
		<th>Name</th>
		<th>Email</th>
		<th>&nbsp;</th>
	</tr>
	<c:forEach items="${team}" var="user">
    <tr>      
        <td><a href="${webctx}/userprofile/myteam?userName=${user.userName}">${user.userName}</a></td>
        <td>${user.fname} &nbsp; ${user.lname}</td>
        <td>${user.email}</td>    
         <td><a href="${webctx}/kpi/get?userName=${user.userName}">KPI</a></td> 
        </tr>
</c:forEach>
</table>
