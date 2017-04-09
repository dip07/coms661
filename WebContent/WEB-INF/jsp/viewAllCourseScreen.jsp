<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
<table border="1" style="background-color: #85c1e9; color: #34495e; font: Arial; border-radius: 6px; font-size: 12px; width: 90%;">
	<tr>
				<th><p>Course Id</p></th>
				<th><p>Course Name</p></th>
				<th><p>Course Number</p></th>
				<th><p>Edit Course</p></th>
				
			</tr>
		<c:forEach items="${courseList}" var="course">
			<tr>
				<td><p>${course.courseId}</p></td>
				<td><p>${course.courseName}</p></td>
				<td><p>${course.courseNumber}</p></td>
				
				<td><a href="${pageContext.request.contextPath}/editCourse?course_id=${course.courseId}">Edit this Course</a></td>
			</tr>
			<tr><td colspan="4" style="background-color: orange;height:10px"></td></tr>
		</c:forEach>
	</table>
</div>