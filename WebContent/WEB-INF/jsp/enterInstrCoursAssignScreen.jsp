

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div>
	<form:form action="saveEditInstructor" method="post" commandName="instructorForm">
		<table class="rwd-table">
			<tr>
				<td colspan="2"><h2>Enter the required details</h2></td>
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
				<td>Select Course for this Instructor</td>
				<td>
					<form:select path="instructorForCourse">
					<form:option value="NONE" label="--- Select ---"/>
	    				<form:options items="${courseNameList}" />
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="Submit" class="submitBtn" /></td>
			</tr>
		</table>
	</form:form>
</div>