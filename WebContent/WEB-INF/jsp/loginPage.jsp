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


			<!-- <div class="controls">
				<select class='half' name='form_param_year'>
					<option value=2012>2012</option>
					<option value=2013>2013</option>
					<option value=2014>2014</option>
					<option value=2015>2015</option>
					<option value=2016>2016</option>
					<option value=2017 selected>2017</option>
					<option value=2018>2018</option>
					<option value=2019>2019</option>
					<option value=2020>2020</option>
					<option value=2021>2021</option>
					<option value=2022>2022</option>
					<option value=2023>2023</option>
					<option value=2024>2024</option>
					<option value=2025>2025</option>
					<option value=2026>2026</option>
					<option value=2027>2027</option>
					<option value=2028>2028</option>
					<option value=2029>2029</option>
					<option value=2030>2030</option>
				</select> <select class='half' name='form_param_term'>
					<option value=1 selected>Spring</option>
					<option value=2>Summer</option>
					<option value=3>Fall</option>
				</select>

			</div> -->

			<div class="controls">
				<input class="primary" style="width: 220px;" type=submit value="Login" />
			</div>
	</form:form>
		
	</div>
</div>