<%@ page session="false"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<templ:header title_page="DashBoard" />
<!-- 
pending, in progress, queries, reports, statistics
 -->
<c:url value="/web/panelbar/content/1" var="contentUrl" />

<div class="demo-section">
	<h3>Ofertas</h3>

	<kendo:panelBar name="dealsPanelbar" expandMode="single" select="select" expand="expand" collapse="collapse" 
	activate="activate" contentLoad="contentLoad" error="error" style="width:250px;">
	<kendo:panelBar-items>			
		<kendo:panelBar-item  text="Metallica - Master of Puppets 1986" expanded="true">
			<kendo:panelBar-items>
				<kendo:panelBar-item text="Battery"/>
				<kendo:panelBar-item text="Master of Puppets"/>
				<kendo:panelBar-item text="The Thing That Should Not Be"/>
				<kendo:panelBar-item text="Welcome Home (Sanitarium)"/>
				<kendo:panelBar-item text="Disposable Heroes"/>
				<kendo:panelBar-item text="Leper Messiah"/>
				<kendo:panelBar-item text="Orion (Instrumental)"/>
				<kendo:panelBar-item text="Damage, Inc."/>					
			</kendo:panelBar-items>
		</kendo:panelBar-item>
		<kendo:panelBar-item  text="Iron Maiden - Brave New World 2000">
			<kendo:panelBar-items>
				<kendo:panelBar-item text="The Wicker Man"/>
				<kendo:panelBar-item text="Ghost Of The Navigator"/>
				<kendo:panelBar-item text="Brave New World"/>
				<kendo:panelBar-item text="Blood Brothers"/>
				<kendo:panelBar-item text="The Mercenary"/>
				<kendo:panelBar-item text="Dream Of Mirrors"/>
				<kendo:panelBar-item text="The Fallen Angel"/>
				<kendo:panelBar-item text="The Nomad"/>
				<kendo:panelBar-item text="Out Of The Silent Planet"/>
				<kendo:panelBar-item text="The Thin Line Between Love And Hate"/>					
			</kendo:panelBar-items>
		</kendo:panelBar-item>
		<kendo:panelBar-item  text="Empty Item" />
		<kendo:panelBar-item  text="Ajax Item" contentUrl="${ contentUrl }" />
		<kendo:panelBar-item  text="Error Item" contentUrl="error.html" />					
	</kendo:panelBar-items>
</kendo:panelBar>
<!-- 
	<div class="k-block k-info-colored">
		<div class="k-header k-shadow">Ofertas</div>
		Block with shadowed header
		<br/>
		<span class="configHead">DatePicker - API Functions</span>
		<div class="demo-section">
		    <kendo:datePicker name="datepicker" value="${now}" format="dd MMMM yyyy" />
		</div>
 -->		
	</div>
</div>
<!--
 -->
 	
<style scoped>

#panels
{
    margin-left: 20px;
    text-align: center;
}

#panels li
{
    margin-right: 10px;
    margin-bottom: 10px;
    width: 48%;
    list-style: none;
    float: left;
}

</style>
<templ:footer />
