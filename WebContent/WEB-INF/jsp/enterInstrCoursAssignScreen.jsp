<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <p>Message : ${status}</p> --%>
<div>
	<c:choose>
	<c:when test="${empty status}">
	<form:form action="saveEditInstructor" method="post" commandName="instructorForm">
		<table class="rwd-table">
			<tr>
				<td colspan="2"><h2>Enter the required details</h2></td>
			</tr>
			<tr>
				<td>Select Course Number</td>
				<c:choose>
					<c:when test="${not empty param.course_id}">
						<td><form:input path="instructorForCourse" value="${param.course_id}" readonly="true" /></td>
					</c:when>
					<c:otherwise>

						<td><form:select path="instructorForCourse">
								<form:option value="NONE" label="--- Select ---" />
								<form:options items="${courseNameList}" />
							</form:select></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>Select Instructor Name</td>
				<td>
					<form:select path="name">
						<form:option value="NONE" label="--- Select ---"/>
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
					value="Submit" class="submitBtn" /></td>
			</tr>
		</table>
	</form:form>
	</c:when>
	<c:otherwise>
		<p>All courses already assigned.</p>
	</c:otherwise>
	</c:choose>
</div>