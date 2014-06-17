<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<templ:top_head title_page="exception" />
    </head>
    <body>
    	<templ:top_body />

	<c:if test="${not empty exception.errCode}">
		<h1>${exception.errCode} : System Errors</h1>
	</c:if>
    <br/><br/><br/>
 
	<c:if test="${empty exception.errCode}">
		<h1>System Errors</h1>
	</c:if>
	
	<c:if test="${not empty exception.errMsg}">
		<h4>${exception.errMsg}</h4>
	</c:if>
	
		<templ:footer_body />
<templ:footer_html />
