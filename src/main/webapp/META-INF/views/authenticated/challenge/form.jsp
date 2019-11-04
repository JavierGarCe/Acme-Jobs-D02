<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-textbox code="authenticated.Challenge.form.label.title" path="title"/>
	<acme:form-moment code="authenticated.Challenge.form.label.deadline" path="deadline"/>
	<acme:form-textbox code="authenticated.Challenge.form.label.description" path="description"/>
	<acme:form-textbox code="authenticated.Challenge.form.label.goldGoal" path="goldGoal"/>
	<acme:form-textbox code="authenticated.Challenge.form.label.goldReward" path="goldReward"/>
		<acme:form-textbox code="authenticated.Challenge.form.label.silverGoal" path="silverGoal"/>
	<acme:form-textbox code="authenticated.Challenge.form.label.silverReward" path="silverReward"/>
		<acme:form-textbox code="authenticated.Challenge.form.label.bronzeGoal" path="bronzeGoal"/>
	<acme:form-textbox code="authenticated.Challenge.form.label.bronzeReward" path="bronzeReward"/>
	<acme:form-return code="authenticated.Challenge.form.button.return"/>
	

</acme:form>
