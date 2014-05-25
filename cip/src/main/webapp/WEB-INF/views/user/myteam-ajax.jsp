<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript" src="/cip/resources/js/angular.js"></script>
<script type="text/javascript" src="/cip/resources/js/angular-resource.js"></script>
<script type="text/javascript" src="/cip/resources/js/angular-cookies.js"></script>

<script type="text/javascript" src="/cip/resources/js/jquery-2.1.0.js"></script>
<script type="text/javascript" 	src="/cip/resources/js/ng-grid-2.0.11.debug.js"></script>
<link rel="stylesheet" type="text/css" 	href="/cip/resources/styles/ng-grid.css" />
<style>
.gridContainer {
	padding-top: 10px;
}

.gridStyle {
	height: 300px;
	width: 99%;
	margin: 0 auto;
	border: 1px solid #ccc;
}
</style>
 
<script>
var app = angular.module('myApp', [ 'ngGrid','ngResource' ]);

app.factory('Team',['$resource', function($resource){	
	return $resource('/cip/rest/user/:userName/team',{userName: '@userName'});
}]);
	app.controller('manageDataController', [ '$scope', 'Team',function($scope,team) {
		//$scope.details = details;
		var data =  team.query({userName: '${user.userName}'});
		//alert(data);
		$scope.details =  data;

		$scope.gridOptions = {
			data : 'details',
			showFooter : true,
			showFilter : true,
			showHeader : true,
			showColumnMenu : true,
			showGroupPanel : true,
			showSelectionCheckbox : true,
			enablePaging : true,
			enableHighlighting : true,
			enableRowReordering : true,
			enableColumnResize : true,
			enableCellEdit : false,
			enableCellSelection : true

		};
	} ]);
</script> 

	
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<security:authentication property="principal" var="principal"
	scope="page" />
<h1> ${user.fname}'s Team</h1>
	  	<div ng-app='myApp' ng-controller='manageDataController'>
		
		<div class="gridContainer">
			<div class="gridStyle" ng-grid="gridOptions"></div>
		</div>
	</div>
