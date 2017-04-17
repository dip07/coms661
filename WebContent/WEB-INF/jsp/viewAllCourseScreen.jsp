<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="centered">
<p><a href="${pageContext.request.contextPath}/welcome">Back to Home</a></p>
	<c:choose>
		<c:when test="${empty noData}">
			<table border="1"
				style="background-color: #85c1e9; color: #34495e; font: Arial; border-radius: 6px; font-size: 12px; width: 90%;">
				<tr>
					<th><p>Course Name</p></th>
					<th><p>Course Number</p></th>
					<th><p>Is Archived</p></th>
					<th><p>Edit Course</p></th>

				</tr>
				<c:forEach items="${courseList}" var="course">
					<tr>
						<td><p>${course.courseName}</p></td>
						<td><p>${course.courseNumber}</p></td>
						<td><p>${course.isArchived}</p></td>
						<td><a
							href="${pageContext.request.contextPath}/editCourse?course_number=${course.courseNumber}">Edit
								this Course</a></td>
					</tr>
					<tr>
						<td colspan="4" style="background-color: orange; height: 10px"></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p><a href="${pageContext.request.contextPath}/enterUpdateCourse" class="mainPageButton">No Information Present. Enter Course Details</a></p>
		</c:otherwise>
	</c:choose>
	<br>
			<p><a href="${pageContext.request.contextPath}/enterUpdateCourse" class="mainPageButton">Enter new Course Information</a></p>
	
</div>