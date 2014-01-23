<%@ page session="false"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<templ:header title_page="DatePicker" />

<!-- http://docs.kendoui.com/api/web/datepicker -->
<%
String footerDatePicker = "Today - #=kendo.toString(data, 'd') #";
%>

<div class="configuration k-widget k-header" style="width: 320px">

<span class="configHead">DatePicker - API Functions</span>

<div class="demo-section">
    <kendo:datePicker name="datepicker" value="${now}" format="dd MMMM yyyy"  change="change" />
</div>

<ul class="options">
	<li>
	    <button id="get" class="k-button">Get value</button>
	</li>
	<li>
       <input id="value" value="10/10/2000" style="float:none" />
       <button id="set" class="k-button">Set value</button>
	</li>
	<li>
	    <button id="enable" class="k-button">Enable</button> or 
	    <button id="disable" class="k-button">Disable</button> or 
	    <button id="readonly" class="k-button">Readonly</button>
	</li>
	<li>
	    <button id="open" class="k-button">Open</button> or 
	    <button id="close" class="k-button">Close</button> the calendar
	</li>
</ul>

<hr />
<span class="configHead">DatePicker by Month</span>
<div class="demo-section">
	<kendo:datePicker name="monthpicker" value="${now}" start="year" depth="year" format="MMMM yyyy">
	</kendo:datePicker>
</div>

<hr />
<span class="configHead">DatePicker with specifics dates</span>
<script>
 function isInArray(date, dates) {
 	for(var idx = 0, length = dates.length; idx < length; idx++) {
 		if (+date === +dates[idx]) {
 			return true;
 		}
 	}
 	
 	return false;
 }
</script>
<%
String template = "# if (isInArray(+data.date, data.dates)) { #" +
        "<div class=\"birthday\"></div>" +
    "# } #" +
    "#= data.value #";

%>
<div class="demo-section">   
	<kendo:datePicker name="templpicker" value="${now}" dates="${dates}" footer="<%=footerDatePicker%>">
	    <kendo:datePicker-month content="<%=template%>"/>
	</kendo:datePicker>
</div>

</div>

<script>
$(document).ready(function() {

    var datepicker = $("#datepicker").data("kendoDatePicker");

    var setValue = function () {
        datepicker.value($("#value").val());
    };

    $("#enable").click(function() {
        datepicker.enable();
    });

    $("#disable").click(function() {
        datepicker.enable(false);
    });

    $("#readonly").click(function() {
        datepicker.readonly();
    });

    $("#open").click(function() {
        datepicker.open();
    });

    $("#close").click(function() {
        datepicker.close();
    });

    $("#set").click(setValue);

});
</script>
<script>
    function open() {
        kendoConsole.log("Open");
    }

    function close() {
        kendoConsole.log("Close");
    }

    function change() {
        kendoConsole.log("Change :: " + kendo.toString(this.value(), 'd'));
    }
</script>

<templ:footer />
