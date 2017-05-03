<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="centered">
<p><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>
	<c:choose>
		<c:when test="${empty noData}">
			<table border="1" style="background-color: #ddd; color: #34495e;font-size: 16px ;font-family : Trebuchet MS,Arial,Helvetica,sans-serif; border-radius: 6px; font-size: 12px; width: 90%;">
				<tr>
					<th style="background-color: #4caf50; font"><p>Course Name</p></th>
					<th><p>Course Number</p></th>
					<!-- <th><p>Is Archived</p></th> -->
					<th><p>Edit Course</p></th>

				</tr>
				<c:forEach items="${courseList}" var="course">
					<tr>
						<td><p>${course.courseName}</p></td>
						<td align="center"><p>${course.courseNumber}</p></td>
						<%-- <td><p>${course.isArchived}</p></td> --%>
						<td><a href="${pageContext.request.contextPath}/editCourse?course_number=${course.courseNumber}"><u>Edit this Course</u></a></td>
					</tr>
					<!-- <tr>
						<td colspan="4" style="background-color: orange; height: 10px"></td>
					</tr> -->
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p align="center"><span style="color: red; font-size: 16px; font-weight: bold;">No Information Present</span></p>
		</c:otherwise>
	</c:choose>
	<br>
			<p align="center"><a href="${pageContext.request.contextPath}/enterUpdateCourse" class="mainPageButton">Enter new Course Information</a></p>
	
</div>