<c:choose>
<c:when test="${empty sessionScope.USER_CONNECTED_SESSION }">
	<%@ include file="menuGuest.jsp" %>
</c:when>
<c:otherwise>
	<%@ include file="menuUser.jsp" %>
</c:otherwise>
</c:choose>

