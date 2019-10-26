<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.offer.form.labbel.title" path="title"/>
	<acme:form-textbox code="authenticated.offer.form.labbel.moment" path="moment"/>
	<acme:form-textbox code="authenticated.offer.form.labbel.deadline" path="deadline"/>
	<acme:form-textarea code="authenticated.offer.form.labbel.reward" path="reward"/>
	<acme:form-textarea code="authenticated.offer.form.labbel.ticker" path="ticker"/>
	
	<acme:form-return code="authenticated.offer.form.button.return"/>
</acme:form>
