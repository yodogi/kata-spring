<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<templ:header title_page="Spring Security" />

	<h1>Message : ${message}</h1>
	
	<sec:authorize access="isAuthenticated()">
		<h3>Username : ${username}</h3>
	</sec:authorize>
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
 	
<templ:footer />
