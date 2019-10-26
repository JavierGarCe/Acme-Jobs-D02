<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>	
	<acme:list-column code="authenticated.offer.list.label.title" path="title" width="20%"/>
	<acme:list-column code="authenticated.offer.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="authenticated.offer.list.label.deadline" path="deadline" width="20%"/>
	<acme:list-column code="authenticated.offer.list.label.reward" path="reward" width="20%"/>
	<acme:list-column code="authenticated.offer.list.label.ticker" path="ticker" width="20%"/>
</acme:list>