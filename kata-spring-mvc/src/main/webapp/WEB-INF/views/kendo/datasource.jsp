<%@ page session="false"%>
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<%@taglib prefix="templ" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<templ:header title_page="DataSource" />

<script>
  	 var dataSource = new kendo.data.DataSource({
  		 transport : {
   				read : {
   					url : '<c:url value="/resources/json/test_datasource.json" />',
   					dataType : 'json'
   				}
   			},
   			schema : {
   				data : function(response) {
   			  		console.log("Entrando en datasource / schema / data");
   					return response.data;
   				}				
   			},
 	        requestStart: function() {
 	        	console.log("requestStart: Entrando en datasource");
 	        },
 	        requestEnd: function() {
 	        	console.log("requestEnd: Entrando en datasource");
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
	
</script>

<templ:footer />
