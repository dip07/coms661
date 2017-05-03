<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    <div class="titlebox">
        <div class="left">
  	    	<h1>Vote Request</h1>
            <h2>Complete this form to create a new Vote</h2>
        </div>
        <div class="right"> 
    		<a href="voteAdmin">Home</a>
		</div>         
    </div>

	<form:form action="saveVote" method="post" commandName="voteForm">
		<table class="rwd-table">
		
			<tr>
				<td colspan="2"><h2>Enter the vote Details</h2></td>
			</tr>
			<tr>
				<td>Admin Name:</td>
				<td><form:input path="adminName" cssStyle="width:50%"/></td>
			</tr>
			<tr>
				<td>Contact No:</td>
				<td><form:input path="adminNO" cssStyle="width:50%"/></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="AdminEmail" required='true' cssStyle="width:50%" /></td>
			</tr>
			<tr>
				<td>Topic:</td>
				<td><form:textarea path="Topic" required='true' rows="3" cssStyle="width:80%"/></td>
			</tr>
			<tr>
				<td>Options:</td>
				<td><form:checkbox path="voteOption" value="yes"/>Yes
				<form:checkbox path="voteOption" value="no"/>No
				<form:checkbox path="voteOption" value="mayBe"/> May be
				<form:checkbox path="voteOption" value="interested"/>Interested
				<form:checkbox path="voteOption" value="notInterested"/>Not Interested
				<form:checkbox path="voteOption" value="notSure"/>Not sure
				<form:checkbox path="voteOption" value="good"/>good
				<form:checkbox path="voteOption" value="poor"/>poor
				<form:checkbox path="voteOption" value="excellent"/>Excellent
				</td>
			</tr>
			<tr>
				<td>Participants:</td>
				<td><form:input path="participants" required='true' cssStyle="width:80%" />
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="Submit" class="submitBtn" /></td>
			</tr>
			
		</table>
	</form:form>
