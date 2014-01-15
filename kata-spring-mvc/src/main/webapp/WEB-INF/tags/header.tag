<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="title_page" required="true" %>
<%@ attribute name="body_completation" required="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Home</title>
		<link href="<c:url value='/resources/css/kendo.common.min.css'/>" rel="stylesheet" />
		<link href="<c:url value='/resources/css/kendo.default.min.css'/>" rel="stylesheet" />

		<link href="<c:url value='/resources/css/kata.spring.mvc.kendo.css'/>" rel="stylesheet" />

		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${title_page} :: Spring Application</title>
		
		<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
		<script src="<c:url value='/resources/js/kendo.web.min.js' />"></script>

    </head>
    <body ${body_completation}>
    	<div class="page">
    		<div id="example" class="k-content">
    		
    		

