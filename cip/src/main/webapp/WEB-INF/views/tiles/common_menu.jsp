<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="webctx" value="${pageContext.servletContext.contextPath}"/>  	
<ul>
	<security:authorize access="isAuthenticated()">
		<li><a href="${webctx}/kpi/get">My KPI</a></li>
		<li><a href="${webctx}/userprofile/myteam">My Team</a></li>
		<li><a href="${webctx}/userprofile/myaccount">My Account</a></li>
		<li><a href="#">Reports</a></li>
	</security:authorize>
	<security:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="#">Admin</a></li>
	</security:authorize>

	<li><a href="#">Help</a></li>

</ul>