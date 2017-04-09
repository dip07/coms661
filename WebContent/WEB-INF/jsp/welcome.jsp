<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<!-- <p><input type="button"  class="myButton" onclick="location.href='/adminHome'" value="Enter Admin Home" ></p>
		<p><input type="button"  class="myButton" onclick="location.href='/userHome'" value="Enter As Instructor" ></p> -->
		
		<p><a href="${pageContext.request.contextPath}/adminScreen" class="mainPageButton">Login As Admin</a></p>
		<p><a href="${pageContext.request.contextPath}/userHome" class="mainPageButton">Login As Instuctor</a></p>
	</div>
	
	
