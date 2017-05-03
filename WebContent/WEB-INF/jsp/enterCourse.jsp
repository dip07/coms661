<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <p>Status : ${status}</p> --%>

<div style="padding-top: 30px;">

<c:if test="${ (not empty status) && (status == 'COURSE_INFO_ALREADY_FILLED')}">
	<p>Course info for this Course Number has been filled. Please edit the course details</p>
</c:if>
<c:choose>
	<c:when test="${(not empty param.course_number)}">
		<c:set var="formAction" scope="session" value="saveEditedCourse"/>
	</c:when>
	<c:otherwise>
		<c:set var="formAction" scope="session" value="saveCourse"/>
	</c:otherwise>
</c:choose>

<p><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>

	<form:form action="${formAction}" method="post" commandName="courseForm">
		<table align="center">
			<tr>
				<td colspan="2"><h2>Enter the Course Details :</h2></td>
			</tr>
			<tr>
				<td>Enter Course Number:</td>
				<c:choose>
					<c:when test="${(not empty param.course_number)}">
						<td><form:input path="courseNumber" required='true'  value="${param.course_number}" readonly="true"/></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="courseNumber" required='true'/></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>Enter Course Name:</td>
				<td><form:input path="courseName" required='true' /></td>
			</tr>
			<tr>
				<td>Is Archived:</td>
				<td><form:select path="isArchived" id="statusArchive">
						<form:option selected="true" value="false" label="NO" />
						<form:option value="true" label="YES" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="Submit" class="submitBtn" /></td>
			</tr>
		</table>
	</form:form>
</div>