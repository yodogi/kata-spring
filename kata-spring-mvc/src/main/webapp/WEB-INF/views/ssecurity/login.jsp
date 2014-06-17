<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<templ:top_head title_page="Spring Security - LOGIN" />
		<style>
		.errorblock {
			color: #ff0000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}

        .login_style ul {
        	list-style: none;
            margin: 0;
            padding: 0;
        }

        .login_style li {
        	height: 28px;
        	vertical-align: middle;
        	color: #000;
        }

        .login_style ul label {
        	display: inline-block;
        	width: 100px;
        	text-align: right;
        	padding-right: 5px;
        	color: #000;
        }

        .login_style label {
        	color: #000;
        }

        .login_style ul input {
        	border: 1px solid #ddd;
        }

        .login_style button {
        	float: right;
        	margin-right: 85px;
        }
    </style>
    
    </head>
    <body onload='document.login_form.j_username.focus();'>
    	<templ:top_body />

	<div id="login_dialog" class="login_style">
	<sec:authorize access="isAuthenticated()">
		<h3>Username : ${username}</h3>
	</sec:authorize>
	
		<c:if test="${not empty error}">
			<div class="errorblock">
				Your login attempt was not successful, try again.<br /> Caused :
				${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
			</div>
		</c:if>
	 	
		<form name='login_form' action="<c:url value='j_spring_security_check' />" method='POST'>
            <ul>
                <li>
                	<label for="j_username"><spring:message code="label.login.username" text="Usuario" />:</label>
                	<input type="text" name="j_username" size="10" value="" />
                </li>
                <li>
                	<label for="j_password"><spring:message code="label.login.password" text="Contraseña" />:</label>
                	<input type="password" name="j_password" size="10" value="" />
                </li>
                <li>
                	<br/>
	    	        <button name="submit" type="submit" style="display: block">
	    	        	<spring:message code="label.login.button" text="Entrar" />
	    	        </button>
                </li>
            </ul>
		</form>
	</div>
<templ:footer_body />


<script>
$("#login_dialog").kendoWindow({
	modal: true,
	draggable: false,
	resizable: false,
	title: false,
  	actions: []
});
var dialog = $("#login_dialog").data("kendoWindow");
dialog.center();

</script>

<templ:footer_html />
