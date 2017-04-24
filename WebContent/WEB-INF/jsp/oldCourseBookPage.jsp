<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="padding: 30px 0 0 0">
<p>User : ${sessionScope.bookUserNetId}</p>
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
				<c:forEach items="${oldBooksList}" var="courseBook">
					<tr>
						<td><p align="center">${courseBook.courseNumber}</p></td>
						<td><p>${courseBook.year}</p></td>
						<td><p>${courseBook.session}</p></td>
						<td><p>${courseBook.instructorName}</p></td>
						<td><p>${courseBook.bookName}</p></td>
						<td><p>${courseBook.author}</p></td>
						<td><p>${courseBook.ISBN}</p></td>
						<td><p style="width: 100px">${courseBook.comments}</p></td>
					</tr>
					<tr>
						<td colspan="9" style="background-color: orange; height: 10px"></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p>No Information Present . Check current course details or contact admin</p>
		</c:otherwise>
	</c:choose>

</div>