
<%@page language="java" 
	contentType="text/html; charset=utf-8" 
	trimDirectiveWhitespaces="true"
	import="org.springframework.context.ApplicationContext, 
			org.springframework.web.servlet.support.RequestContextUtils,
			acme.framework.helpers.JspHelper"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<ul class="list-group list-group-flush">

<li class="list-group-item">
<acme:message code="numberOfAnnouncement"/>
<jstl:out value="      ${numberOfAnnoucements}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="numberOfCompanyRecords"/>
<jstl:out value="      ${numberOfCompanyRecords}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="numberOfInvestorRecords"/>
<jstl:out value="      ${numberOfInvestorRecords}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="minActiveRequests"/>
<jstl:out value="      ${minActiveRequests}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="maxActiveRequests"/>
<jstl:out value="      ${maxActiveRequests}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="avgActiveRequests"/>
<jstl:out value="      ${avgActiveRequests}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="stDevRActiveRequests"/>
<jstl:out value="      ${stDevRActiveRequests}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="minActiveOffers"/>
<jstl:out value="      ${minActiveOffers}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="maxActiveOffers"/>
<jstl:out value="      ${maxActiveOffers}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="avgActiveOffers"/>
<jstl:out value="      ${avgActiveOffers}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="stDevMinActiveOffers"/>
<jstl:out value="      ${stDevMinActiveOffers}"/><br/>
</li>
<li class="list-group-item">
<acme:message code="stDevMaxActiveOffers"/>
<jstl:out value="      ${stDevMaxActiveOffers}"/><br/>
</li>
</ul>