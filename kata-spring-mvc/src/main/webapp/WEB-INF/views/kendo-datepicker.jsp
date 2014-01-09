<%@ page session="false"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<templ:header />

    <h1>Kendo integration with Spring Application</h1>
    <h3>DatePicker object</h3>
    <p>Date time it is now <c:out value="${now}"/></p>

	<br />
	<kendo:datePicker name="datePicker" value="${now}"></kendo:datePicker>

<script>

$(function() {
    var datepicker = $("#datepicker").data("kendoDatePicker");
//    alert(datepicker);
/*     
    $("#datepicker").change(function() {
    	alert( "Handler for .change() called." );
    });
 */
});

</script>
	
<templ:footer />