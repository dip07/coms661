<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- welcome header -->
<div class="gutter">
<div class="titlebox">
    <div class="left">
  		<h1>John Cena</h1>
        <h2>Admin</h2>
    </div>
    <div class="right"> 
    	<a href="logout">Logout</a>
	</div>         

</div>


<div id="content">
	<div id="title">
		<h1>ISU Voting System</h1>
		<h2>Department of Computer Science</h2>
	</div>
</div>

</div>
<div id="form">
	<div id="padding">
			<p><a href="${pageContext.request.contextPath}/newVote" class="myButton2">Start a New Vote</a></p>
			<p><a href="${pageContext.request.contextPath}/allVotes" class="myButton2">Previous Votes</a></p>	
	</div>
</div>
