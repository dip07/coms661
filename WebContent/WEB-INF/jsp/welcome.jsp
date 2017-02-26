<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Basic Spring MVC project</title>
</head>
<body>${message}
	<div>
		<p><a href="<c:url value="fetchStudent"/>">Click here for fetching data from Student</a><p>
	</div>
</body>
</html>