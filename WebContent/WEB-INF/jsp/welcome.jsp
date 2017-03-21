<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Basic Spring MVC project</title>
</head>
<body>${message}
	<div>
		<p><a href="<c:url value="fetchBook"/>">Click here for fetching data from Book DB</a><p>
	</div>
</body>
</html> --%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<p>${message}</p>
	<div>
		<p><a href="<c:url value="fetchBook"/>">Click here for fetching data from Book DB</a><p>
	</div>
