<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#dataTableExp').DataTable();
	});
</script>
<title>Student Data</title>
</head>
<body>
	<div>
		<p>Here is the text : ${message}</p>
	</div>
	<div align="center">
		<form:form action="getBookData" method="post" commandName="bookForm">
			<table border="1" style="background-color:  #85c1e9">
				<tr>
					<td colspan="2" align="center"><h2>Enter these fields to
							fetch data</h2></td>
				</tr>
				<tr>
					<td>Course Name:</td>
					<td><form:input path="courseName" /></td>
				</tr>
				<tr>
					<td>Session:</td>
					<td><form:input path="session" /></td>
				</tr>
				<tr>
					<td>Year:</td>
					<td><form:input path="year" /></td>
				</tr>
				<tr>
					<td>Instructor :</td>
					<td><form:input path="instructor" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<%-- <p>${isDataPresent}</p> --%>
	<div class="dataTables_wrapper" id="example_wrapper" align="center" >
	<div align="center" style="width:50%">
		<c:if test="${ not empty isDataPresent}">
			<p>
			<table id="dataTableExp" width="50%" class="display" 
				style="background-color: #aed6f1 ; color:  #34495e ; font: Arial; border-radius:6px; font-size: 12px">
				<thead>
					<tr>
						<th>Course Name</th>
						<th>Session</th>
						<th>Year</th>
						<th>Instructor Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bookObj}" var="current">
						<tr>
							<td><c:out value="${current.courseName}" />
							<td><c:out value="${current.session}" />
							<td><c:out value="${current.year}" />
							<td><c:out value="${current.instructor}" />
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
	</div>
</body>
</html>