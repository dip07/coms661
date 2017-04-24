<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>

	<form:form action="saveCourse" method="post" commandName="courseForm">
		<table class="rwd-table">
			<tr>
				<td colspan="2"><h2>Enter the Course Details :</h2></td>
			</tr>
			<tr>
				<td>Enter Course Name:</td>
				<td><form:input path="courseName" required='true' /></td>
			</tr>
			<tr>
				<td>Enter Course Number:</td>
				<td><form:input path="courseNumber" required='true' /></td>
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