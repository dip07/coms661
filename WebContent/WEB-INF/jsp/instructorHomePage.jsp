<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<p><a href="${pageContext.request.contextPath}/showAllBookDetails">Click here to see course book details for this sem</a></p>

	<form action="getOldCourseBookInfo" method="get">
		<table class="rwd-table">

			<tr>
				<td colspan="2"><h2>Enter the year for which you want data :</h2></td>
			</tr>
			<tr>
				<td><select name="year">
						<c:forEach var="item" items="${yearList}">
							<option>${item}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Session:</td>
			</tr>
			<tr>
				<td><select name="session">
						<option value="spring">Spring</option>
						<option value="summer">Summer</option>
						<option value="fall">Fall</option>
				</select></td>
			</tr>
			<tr>
				<td style="text-align: center"><input type="submit"
					value="Submit" class="submitBtn" /></td>
			</tr>
		</table>
	</form>
</div>