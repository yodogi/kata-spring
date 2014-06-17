<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<templ:top_head title_page="hello" />
		<script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
		<style>
			.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
			.autocomplete-suggestion { padding: 5px 5px; white-space: nowrap; overflow: hidden; font-size:22px}
			.autocomplete-selected { background: #F0F0F0; }
			.autocomplete-suggestions strong { font-weight: bold; color: #3399FF; }		
		</style>
    </head>
    <body>
    	<templ:top_body />

    <h1>Hello - Spring Application</h1>
    <p>Greetings, it is now <c:out value="${now}"/></p>
    <br/><br/><br/>
	Language : <a href="?lang=es">Español</a> | <a href="?lang=en">English</a> | <a href="?lang=zh_CN">Chinese</a>
	
	<h3>
	welcome.springmvc : <spring:message code="message.springmvc" text="default text" />
	</h3>
	
	<hr/>
	<br/>
	<ul>
  		<li><a href="welcome.htm">Spring Security tests</a></li>
  		<li><a href="exception.htm">Customize error messages</a></li>
	</ul>
	<br/>
	<hr/>
	<h3>Test autocomplete ajax</h3>
	<form>
		<div>
			<input type="text" id="w-input-search" value="">
			<span>
				<button id="button-id" type="button">Search</button>
			</span>
		</div>
	</form>

	<hr/>
	<br/>
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>

	<templ:footer_body />

<script>
$(document).ready(function() {
	$('#w-input-search').autocomplete({
		serviceUrl: '${pageContext.request.contextPath}/gettags.htm', paramName: "tagName", delimiter: ",",
		transformResult: function(response) {
 			return {      	
				//must convert json to javascript object before process
				suggestions: $.map($.parseJSON(response), function(item) {
 					return { value: item.tagName, data: item.id };
 				})
 			};
 		}
	});
});

</script>
<templ:footer_html/>
