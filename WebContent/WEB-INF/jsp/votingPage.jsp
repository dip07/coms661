<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

 <div class="titlebox">
        <div class="left">
  	    	<h1>Please enter your response</h1>
        </div>
 </div>       
 
 
 <form:form action="myVote" method="post" commandName="myVoteForm">
 	<table>
       	<tr>
	   	<td colspan="2" style="text-align: center"><input type="submit"
		   value="Submit" class="submitBtn" /></td>
	   	</tr>
		</table>  
 </form:form>
                 
