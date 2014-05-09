<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<h1> ${user.fname}'s Objectives</h1>
<form:form  servletRelativeAction ="/saveKpiReview" method="post"  commandName="kpiReviewHeader" >
<form:button value="Submit" style="padding: 5px;" >Save Review Comments</form:button>
<form:hidden path="kpiHeader.user.userName"/>
<table class="data-table">
	<tr>
		<th>Category</th>
		<th>Weight</th>
		<th>Review Status</th>
		<th>Key Performance Indicator</th>
		<th>Parameter</th>
		<th>Review Comments</th>
	</tr>
	<c:forEach items="${kpiReviewHeader.kpiReviewItems}" var="item">
    <tr>      
        <td>${item.kpiItem.kpiCatWeight.kpiCategory.catDesc}</td>
        <td>${item.kpiItem.kpiCatWeight.weightPercent} %</td>
      	<td>${item.status}</td>             
        <td>${item.kpiItem.kpiItemDesc}</td> 
        <td>${item.kpiItem.kpiParameterDesc}</td>    
  		<td><form:textarea id="${item.key}" path="${item.comments}" name="comments" rows="3" cols="30" placeholder="Enter Review Comments"></form:textarea></td>
        </tr>
</c:forEach>
</table>
</form:form>