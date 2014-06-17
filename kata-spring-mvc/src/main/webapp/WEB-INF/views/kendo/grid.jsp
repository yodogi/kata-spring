<%@ page session="false"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
		<templ:top_head title_page="GRID" />
    </head>
    <body>
    	<templ:top_body />

			<div id="grid"></div> 

		<templ:footer_body />

<script>
  	 var dataSource = new kendo.data.DataSource({
  		 transport : {
   				read : {
   					url : '<c:url value="/resources/json/pendingTask.JSON" />',
   					dataType : 'json'
   				}
   			},
   			schema : {
   				data : function(response) {
   			  		console.log("Entrando en datasource / schema / data");
   					return response.data.items;
   				}				
   			},
 	        requestStart: function() {
 	        	console.log("requestStart: Entrando en datasource");
 	        	kendo.ui.progress($("#grid"), true);
 	        },
 	        requestEnd: function() {
 	        	console.log("requestEnd: Entrando en datasource");
 	        	kendo.ui.progress($("#grid"), false);
 	        },
 	        change: function() {
 	        	console.log("change: Entrando en datasource");
 	        }
   	 });
  	 
  	dataSource.fetch(function() {
		console.log("Entrando en datasource / fetch");
		var view = dataSource.view();
		console.log(view.length); // displays "2"
		console.log(view[0].name); // displays "Tea"
		console.log(view[1].name); // displays "Ham"
  	});

  	$("#grid").kendoGrid({
			dataSource : dataSource,       			
        sortable: true,
			filterable: true,
			reorderable: true,
			columnMenu: true,
			scrollable: false,
			columns: [
			          	{field: "idOferta", title: "idOffer"},
			          	{field: "solicitadoPor", title: "askedFor"},
			          	{field: "productosGrid", title: "product"},
			         	{field: "assignees_names[0]", title: "assignedTo"},
			         	{field: "groupassignee_displayName", title: "assignedTO"},
			         	{field: "cliente", title: "client"},
			   			{field: "fechaSolicitada", title: "date"},
						{field: "tipoTarea", title: "taskType"},
						{field: "estado", title: "taskStatus"},
						{field: "prioridad", title: "priority"}
					]
 	});     
	
</script>

<templ:footer_html />
