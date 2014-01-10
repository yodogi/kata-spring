<%@ page session="false"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<templ:header title_page="DashBoard" />

<!-- http://docs.kendoui.com/api/web/datepicker -->
<%
String footerDatePicker = "Today - #=kendo.toString(data, 'd') #";
%>

<div class="configuration k-widget k-header" style="width: 320px">

<span class="configHead">DatePicker - API Functions</span>

<div class="demo-section">
    <kendo:datePicker name="datepicker" value="${now}" format="dd MMMM yyyy" />
</div>

</div>

<templ:footer />
