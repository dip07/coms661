<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="centered" style="padding-top: 30px">
<p><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>
<p><a href="${pageContext.request.contextPath}/showAllBookDetails" class="mainPageButton">Click here to see course book details for this sem</a></p>

	<form action="getOldCourseBookInfo" method="get">
		<table align="center">

			<tr>
				<th colspan="2"><h2>Enter the year for which you want data :</h2></td>
			</tr>
			<tr>
			<td>Select Year </td>
			<td><select name="year">
					<c:forEach var="item" items="${yearList}">
						<option>${item}</option>
					</c:forEach>
			</select></td>
			</tr>
			<tr>
				<td>Session:</td>
				<td><select name="session">
						<option value="spring">Spring</option>
						<option value="summer">Summer</option>
						<option value="fall">Fall</option>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"  style="text-align: center"><input type="submit" value="Submit" class="mainPageButton" /></td>
			</tr>
		</table>
	</form>
</div>