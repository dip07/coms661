<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <p>Message : ${status}</p> --%>
<div class="centered" style="padding-top: 30px">
<p><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>
	<c:choose>
	<c:when test="${empty status}">
	<form:form action="saveEditInstructor" method="post" commandName="instructorForm">
		<table align="center">
			<tr>
				<th colspan="2"><h2>Enter the required details :</h2></th>
			</tr>
			<tr>
				<td>Select Course Number</td>
				<c:choose>
					<c:when test="${not empty param.course_id}">
						<td><form:input path="instructorForCourse" value="${param.course_id}" readonly="true" /></td>
					</c:when>
					<c:otherwise>

						<td><form:select path="instructorForCourse">
								<form:options items="${courseNameList}" />
							</form:select></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>Select Instructor Name</td>
				<td>
					<form:select path="name">
	    				<form:options items="${userNameList}" />
					</form:select>
				</td>
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
					value="Submit" class="mainPageButton" /></td>
			</tr>
		</table>
	</form:form>
	</c:when>
	<c:otherwise>
		<p align="center"><span style="color: red; font-size: 16px ; font-weight: bold">All courses already assigned.</span></p>
	</c:otherwise>
	</c:choose>
</div>