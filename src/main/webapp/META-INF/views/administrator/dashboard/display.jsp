

<%@page language="java" 
	contentType="text/html; charset=utf-8" 
	trimDirectiveWhitespaces="true"
	import="org.springframework.context.ApplicationContext, 
			org.springframework.web.servlet.support.RequestContextUtils,
			acme.framework.helpers.JspHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<security:authorize access="hasRole('Administrator')">
<jstl:forEach var ="i" items="${totalCompanies}" varStatus="status">
						<jstl:choose>
						<jstl:when test="${status.last}">
						<jstl:out value="${i[0]}"/>
						</jstl:when>
						<jstl:when test="${!status.last}">
						<jstl:out value="${i[0]},"/>
						</jstl:when>
						</jstl:choose>
						</jstl:forEach>
						
<div> 
	<canvas id ="canvas"></canvas>
</div>
<script type="text/javascript">
		$(document).ready(function(){
			var data = {
					labels : [
						<jstl:forEach var ="i" items="${totalCompanies}" varStatus="status">
						<jstl:choose>
						<jstl:when test="${status.last}">
						<jstl:out value="${i[0]}"/>
						</jstl:when>
						<jstl:when test="${!status.last}">
						<jstl:out value="${i[0]},"/>
						</jstl:when>
						</jstl:choose>
						</jstl:forEach>
					
					],
					datasets : [
						{
							data : [ 
									1, 
									1, 
									3
							]
						}
					]
				};
		var option = {
				scales : {
					yAxes : [
						{
							ticks : {
								suggestedMin : 0.0,
								suggestedMax : 1.0
							}
						
						}
					]
				},
				legend : {
					display : false
				}
		};
		var canvas, context;
		canvas = document.getElementById("canvas");
		context = canvas.getContext("2d");
		new Chart(context, {
			type : "bar",
			data : data,
			options : options
		});
		});

</script>

</security:authorize>


<security:authorize access="!hasRole('Administrator')" >

<% 
throw new IllegalStateException("Access is not authorised");
 %>

</security:authorize>