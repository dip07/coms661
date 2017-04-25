<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="padding: 30px 0 0 0">
<p>Message : ${message}</p>
	<c:choose>
		<c:when
			test="${(not empty message) && (message == 'NO_INSTRUCTOR_INFO_ASSIGNED') }">
			<p>No Instructor Info has been assigned. Please ask Admin to assign instructors to courses</p>
		</c:when>
		<c:when
			test="${(not empty message) && (message == 'NO_COURSE_ASSIGNED') }">
			<p>You have not been assigned to any course. Please contact Admin </p>
		</c:when>

		<c:when
			test="${(not empty message) && (message == 'COURSE_INFO_ALREADY_FILLED') }">
			<p>Information for this course has already been filled out. Please edit the existing information</p>
		</c:when>

		<c:when test="${not empty courseNumLis}" >

		<form:form action="saveCourseBook" method="post" commandName="bookForm">
			<table class="tableCenter">
				<tr>
					<td colspan="2"><h2>Enter the Course Book</h2></td>
				</tr>
				<tr>
					<td>Enter Course Number:</td>
					<td>
						<%-- <form:input path="courseNumber" required='true' /></td> --%>
						<form:select path="courseNumber" items="${courseNumLis}">
						</form:select>

					</td>
				</tr>
				<tr>
					<td>Enter Year :</td>
					<td><form:input path="year" required='true' /></td>
				</tr>
				<tr>
					<td>Enter Session (Fall/Spring) :</td>
					<td><form:input path="session" required='true' /></td>
				</tr>
				<tr>
					<td>Enter Instructor Name :</td>
					<td><form:input path="instructorName" disabled="true"
							value="${sessionScope.bookUserName}" /></td>
				</tr>
				<tr>
					<td>Enter Book Name :</td>
					<td><form:input path="bookName" required='true' /></td>
				</tr>
				<tr>
					<td>Enter Author of the Book :</td>
					<td><form:input path="author" required='true' /></td>
				</tr>
				<tr>
					<td>Enter ISBN of the Book :</td>
					<td><form:input path="ISBN" required='true' /></td>
				</tr>
				<tr>
					<td>Enter comments for the book (if any):</td>
					<td><form:textarea rows="3" path="comments" /></td>
				</tr>

				<tr>
					<td>Is Archived:</td>
					<td><form:select path="isArchived">
							<form:option selected="true" value="false" label="NO" />
							<form:option value="true" label="YES" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center"><input
						type="submit" value="Submit" class="submitBtn" /></td>
				</tr>
			</table>
			</form:form>
		</c:when>
	</c:choose>
</div>