<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
Hi, This page will show book info for all courses
<p>Logged User Name :${sessionScope.bookUserName} </p>
<p><a href="${pageContext.request.contextPath}/exportToExcel">Export to Excel</a></p>
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
					<th><p>Edit Info</p></th>
				</tr>
				<c:forEach items="${courseBooks}" var="courseBook">
					<tr>
						<td><p align="center">${courseBook.courseNumber}</p></td>
						<td><p>${courseBook.year}</p></td>
						<td><p>${courseBook.session}</p></td>
						<td><p>${courseBook.instructorName}</p></td>
						<td><p>${courseBook.bookName}</p></td>
						<td><p>${courseBook.author}</p></td>
						<td><p>${courseBook.ISBN}</p></td>
						<td><p style="width: 100px">${courseBook.comments}</p></td>
						<c:set var="loggedUserName"  value="${sessionScope.bookUserName}"/>
						<c:choose>
						<c:when test="${(not empty loggedUserName) && (loggedUserName eq courseBook.instructorName)}">
							<td><p><a href="${pageContext.request.contextPath}/editCourseBookInfo?courseNumber=${courseBook.courseNumber}"><em>Edit Info</em></a></p></td>
						</c:when>
						<c:otherwise>
							<td><p>Not Allowed</p></td>
						</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<td colspan="9" style="background-color: orange; height: 10px"></td>
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