

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
<ul class="list-group list-group-flush">

<li class="list-group-item">
<strong><acme:message code="Announcement"/></strong><br>

<acme:message code="numberOfAnnouncement"/>
<jstl:out value="      ${numberOfAnnoucements}"/><br><br>
</li>

<li class="list-group-item">
<strong><acme:message code="CompanyRecords"/></strong><br>

<acme:message code="numberOfCompanyRecords"/>
<jstl:out value="      ${numberOfCompanyRecords}"/><br><br>
</li>

<li class="list-group-item">
<strong><acme:message code="InvestorRecords"/></strong><br>

<acme:message code="numberOfInvestorRecords"/>
<jstl:out value="      ${numberOfInvestorRecords}"/><br><br>
</li>

<li class="list-group-item">
<strong><acme:message code="ActiveRequests"/></strong><br>

<acme:message code="minActiveRequests"/>
<jstl:out value="      ${minActiveRequests}"/><br>
<acme:message code="maxActiveRequests"/>
<jstl:out value="      ${maxActiveRequests}"/><br>
<acme:message code="avgActiveRequests"/>
<jstl:out value="      ${avgActiveRequests}"/><br>
<acme:message code="stDevRActiveRequests"/>
<jstl:out value="      ${stDevRActiveRequests}"/><br><br>
</li>

<li class="list-group-item">
<strong><acme:message code="ActiveOffers"/></strong><br>

<acme:message code="minActiveOffers"/>
<jstl:out value="      ${minActiveOffers}"/><br>
<acme:message code="maxActiveOffers"/>
<jstl:out value="      ${maxActiveOffers}"/><br>
<acme:message code="avgActiveOffers"/>
<jstl:out value="      ${avgActiveOffers}"/><br>
<acme:message code="stDevMinActiveOffers"/>
<jstl:out value="      ${stDevMinActiveOffers}"/><br>
<acme:message code="stDevMaxActiveOffers"/>
<jstl:out value="      ${stDevMaxActiveOffers}"/><br><br>
</li>
</ul>

</security:authorize>

<security:authorize access="!hasRole('Administrator')" >

<% 
throw new IllegalStateException("Access is not authorised");
 %>

</security:authorize>