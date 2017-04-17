<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
Hi, This page will show book info for all courses

<p><a href="${pageContext.request.contextPath}/welcome">Back to Home</a></p>
	<c:choose>
		<c:when test="${empty noData}">
			<table border="1"
				style="background-color: #85c1e9; color: #34495e; font: Arial; border-radius: 6px; font-size: 12px; width: 90%;">
				<tr>
					<th><p>Course Number</p></th>
					<th><p>Year</p></th>
					<th><p>Session</p></th>
					<th><p>Instructor Name</p></th>
					<th><p>Book Name</p></th>
					<th><p>Author Name</p></th>
					<th><p>ISBN</p></th>
					<th><p>Comments</p></th>
				</tr>
				<c:forEach items="${courseBooks}" var="courseBook">
					<tr>
						<td><p>${courseBook.courseNumber}</p></td>
						<td><p>${courseBook.year}</p></td>
						<td><p>${courseBook.session}</p></td>
						<td><p>${courseBook.instructorName}</p></td>
						<td><p>${courseBook.bookName}</p></td>
						<td><p>${courseBook.author}</p></td>
						<td><p>${courseBook.ISBN}</p></td>
						<td><p>${courseBook.comments}</p></td>
					</tr>
					<tr>
						<td colspan="8" style="background-color: orange; height: 10px"></td>
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
	




<p><a href="${pageContext.request.contextPath}/addNewBookDetails">Add new Information</a></p>
</div>