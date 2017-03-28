<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>

	<form:form action="saveBook" method="post" commandName="bookForm">
		<table class="rwd-table">
		
			<tr>
				<td colspan="2"><h2>Enter the Course Details</h2></td>
			</tr>
			<tr>
				<td>Course Name:</td>
				<td><form:input path="courseName" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Session:</td>
				<td><form:input path="session" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Enter Book Name:</td>
				<td><form:input path="bookName" required='true' /></td>
			</tr>
			<tr>
				<td>Enter Author Name:</td>
				<td><form:input path="author" required='true' /></td>
			</tr>
			<tr>
				<td>Enter ISBN:</td>
				<td><form:input path="ISBN" required='true' /></td>
			</tr>
			<tr>
				<td>Enter Comments (if any):</td>
				<td><form:input path="comments" required='true' /></td>
			</tr>
			
			<tr>
				<td>Enter isArchived:</td>
				<td><form:input path="isArchived" required='true' /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="Submit" class="submitBtn" /></td>
			</tr>
		</table>
	</form:form>
</div>