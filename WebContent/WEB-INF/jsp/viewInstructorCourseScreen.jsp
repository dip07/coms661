<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
	<%-- <p>hello ${noData}</p> --%>
	<p><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>
	<c:choose>
		<c:when test="${empty noData}">
			<table border="1" style="background-color: #85c1e9; color: #34495e; font: Arial; border-radius: 6px; font-size: 12px; width: 90%;">
				<tr>
					<th><p>Net Id</p></th>
					<th><p>Instructor Name</p></th>
					<th><p>Course Name</p></th>
					<th><p>Edit Details</p></th>

				</tr>
				<c:forEach items="${instructorAssignment}" var="instr">
				<c:set var="courseParts" value="${fn:split(instr.instructorForCourse, '-')}" />
				<c:set var="courseId" value="${courseParts[0]}"/>
					<tr>
						<td><p>${instr.netId}</p></td>
						<td><p>${instr.name}</p></td>
						<td><p>${instr.instructorForCourse}</p></td>
						<td><a href="${pageContext.request.contextPath}/editInstructorAssignment?course_id=${courseId}"><u>Edit this Details</u></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p><span style="color: red">No Information Present</span></p>
		</c:otherwise>
	</c:choose>
		<p align="center"><a href="${pageContext.request.contextPath}/editInstructorAssignment" class="mainPageButton">Enter new Instructor Details</a></p>
</div>