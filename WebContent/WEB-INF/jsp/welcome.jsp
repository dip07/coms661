<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<div style="padding: 30px 0 0 0">
	<c:if test="${(not empty role) && (role == 'admin') }">
		<p align="center"><a href="${pageContext.request.contextPath}/adminScreen" class="mainPageButton">Login As Admin</a></p>
	</c:if>
		<p align="center"><a href="${pageContext.request.contextPath}/getInstructorHomePage" class="mainPageButton">Login As Instuctor</a></p>
	</div>
	
	
