<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.banner.commercial.label.picture" path="picture" width="25%"/>
	<acme:list-column code="administrator.banner.commercial.label.slogan" path="slogan" width="25%"/>	
	<acme:list-column code="administrator.banner.commercial.label.targetUrl" path="targetUrl" width="25%"/>
	<acme:list-column code="administrator.banner.commercial.label.creditCard" path="creditCard" width="25%"/>
	
</acme:list>