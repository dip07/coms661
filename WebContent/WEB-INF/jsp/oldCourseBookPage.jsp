<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="padding: 30px 0 0 0">
<%-- <p>User : ${sessionScope.bookUserNetId}</p> --%>

<p><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>
<c:choose>
		<c:when test="${empty noData}">
			<table>
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
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p align="center"><span style="color: red; font-size: 12 ; font-weight: bold;">No Information Present . Check current course details or contact admin</span></p>
		</c:otherwise>
	</c:choose>

</div>