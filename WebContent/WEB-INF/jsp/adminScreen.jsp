<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <p>Hello : ${param.archived}</p> --%>
<div>
	<p align="center"><a href="${pageContext.request.contextPath}/welcome" class="mainPageButton">Back to Home</a></p>
	<p align="center"><a href="${pageContext.request.contextPath}/viewAllCourse" class="mainPageButton">Enter/Edit Course Details</a></p>
	<p align="center"><a href="${pageContext.request.contextPath}/viewInstructorDetails" class="mainPageButton">Enter/Edit Instructor Details</a></p>
	<p align="center"><a href="${pageContext.request.contextPath}/archiveAllCourseBook" class="mainPageButton">Archive all existing course book (after end of sem)</a></p>
	<p align="center"><a href="${pageContext.request.contextPath}/sendReminderEmail" class="mainPageButton">Send reminder email to instructors</a></p>
	
	<c:if test="${(not empty param.archived) && (param.archived == 't')}">
		<div id="popupMessageDiv" style="font-weight: bold  ; text-align:center ; font-size: 16px ; color: red">Successfully archived all courses</div>
	</c:if>
</div>