<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
	<div id="title">
		<h1>Book Entering System</h1>
		<h2>Department of Computer Science</h2>
	</div>
</div>
<div id="form">
	<div id="padding">

		<!-- <form method=POST action=login> -->
		<form:form action="checkLogin" method="post" commandName="loginForm">

			<div class="controls">
				<form:input id="net_id" class="half" placeholder="Net-ID" path="netId"/>
				<div class="tagline">@iastate.edu</div>
			</div>

			<div class="controls">
				<form:password id="password" class="full" placeholder="Password" path="password"/>
			</div>
			
			<c:if test="${!empty errorMessage}">
					<div class="form-alert">${errorMessage}</div>
			</c:if>

			<div class="controls">
				<input class="primary" style="width: 220px;" type=submit value="Login" />
			</div>
	</form:form>
		
	</div>
</div>