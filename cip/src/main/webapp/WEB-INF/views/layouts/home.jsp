<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset=utf-8>
<meta name="viewport" content="width-device-width,initial-scale=1.0" />
<c:set var="webctx" value="${pageContext.servletContext.contextPath}" />
<title><tiles:getAsString name="title" /></title>
<link href="${webctx}/resources/styles/site.css" rel="stylesheet" />
</head>
<body>

	<div id="wrapper">
		<header >
			<div id="nav-top">
				<tiles:insertAttribute name="navtop" />
			</div>
			<div id="nav-menu">
				<tiles:insertAttribute name="menu" />
			</div>
		</header>
		<div id="content" >
			<tiles:insertAttribute name="body" />
		</div>
		<aside>
			<tiles:insertAttribute name="sidemenu" />

		</aside>
		<footer>
			<tiles:insertAttribute name="footer" />
		</footer>
	</div>
</body>
</html>