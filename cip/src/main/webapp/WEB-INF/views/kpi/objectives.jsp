<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<script type="text/javascript" src="${webctx}/resources/js/jquery-2.1.0.js"></script>
<script type="text/javascript">
function addReview(){
	$('form#kpiHeader').setAttribute('action', '${webctx}/kpi/addReview'); 
	$('form#kpiHeader').submit();
}
</script>
<h1> ${user.fname}'s Objectives</h1>

<form:form  servletRelativeAction ="/kpi/kpiReview" method="post"  commandName="kpiHeader" >
	<form:button value="Submit" style="padding: 5px;" onClick="addReview()">Add Objectives</form:button>
	<form:button value="Submit" style="padding: 5px;" >Review Objectives</form:button>
	<form:hidden path="user.userName"/>
		<table class="data-table">
		<tr>
			<th>Category</th>
			<th>Weight</th>
			<th>Status</th>
			<th>Key Performance Indicator</th>
			<th>Parameter</th>
		</tr>
		<c:forEach items="${kpiHeader.kpiItems}" var="item">
	    <tr>      
	        <td>${item.kpiCatWeight.kpiCategory.catDesc}</td>
	        <td>${item.kpiCatWeight.weightPercent} %</td>
	      	<td>${item.status}</td>             
	        <td>${item.kpiItemDesc}</td> 
	        <td>${item.kpiParameterDesc}</td>    
	        </tr>
	</c:forEach>
	</table>
</form:form>