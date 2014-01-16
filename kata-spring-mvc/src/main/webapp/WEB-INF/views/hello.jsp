<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<templ:header title_page="hello" />

    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now <c:out value="${now}"/></p>
    <br/><br/><br/>
	Language : <a href="?lang=en">English</a> | <a href="?lang=zh_CN">Chinese</a>
	
	<h3>
	welcome.springmvc : <spring:message code="message.springmvc" text="default text" />
	</h3>
	
	Current Locale : ${pageContext.response.locale}
	
<templ:footer />