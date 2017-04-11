<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<p>hello ${noData}</p>
	<c:choose>
		<c:when test="${empty noData}">
			<table border="1"
				style="background-color: #85c1e9; color: #34495e; font: Arial; border-radius: 6px; font-size: 12px; width: 90%;">
				<tr>
					<th><p>Net Id</p></th>
					<th><p>Instructor Name</p></th>
					<th><p>Course Name</p></th>
					<th><p>Edit Details</p></th>

				</tr>
				<c:forEach items="${instructorAssignment}" var="instr">
					<tr>
						<td><p>${instr.netId}</p></td>
						<td><p>${instr.name}</p></td>
						<td><p>${instr.instructorForCourse}</p></td>
						<td><a href="${pageContext.request.contextPath}/editInstructorAssignment?net_id=${instr.netId}">Edit this Details</a></td>
					</tr>
					<tr>
						<td colspan="4" style="background-color: orange; height: 10px"></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<p><a href="${pageContext.request.contextPath}/editInstructorAssignment" class="mainPageButton">No Information Present. Enter Instructor Details</a></p>
		</c:otherwise>
	</c:choose>
</div>