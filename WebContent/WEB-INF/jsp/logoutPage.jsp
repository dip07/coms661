<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <p>bookUserNetId : ${bookUserNetId}</p> --%>
<c:if test="${not empty bookUserNetId}">
	<p align="right" style="color: #ddd;"><a href="${pageContext.request.contextPath}/logout" style="font-size: 20px ; font-weight:bold">Logout</a></p>
</c:if>

