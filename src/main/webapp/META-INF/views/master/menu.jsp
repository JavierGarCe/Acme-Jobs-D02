<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			
			<acme:menu-suboption code="master.menu.anonymous.javier-favourite-link" action="https://www.informatica.us.es/"/>
			<acme:menu-suboption code="master.menu.anonymous.franFavourite-link" action="http://www.google.com/"/>
 			<acme:menu-suboption code="master.menu.anonymous.Juanfavourite-link" action="https://es.wikipedia.org/wiki/Julen_Lopetegui"/>
      		<acme:menu-suboption code="master.menu.anonymous.fernandoFavourite-link" action="http://www.lsi.us.es/docencia/pagina_asignatura.php?id=153"/>
     		<acme:menu-suboption code="master.menu.anonymous.estefania-link" action="http://www.linkedin.com/"/>
       
		<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listShouts" action="/anonymous/shout/list"/>
			<acme:menu-suboption code="master.menu.anonymous.shout" action="/anonymous/shout/create"/>
      
		<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listPerejonBulletins" action="/anonymous/perejonBulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.PerejonBulletin" action="/anonymous/perejonBulletin/create"/>
      
		 <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listRomeroBulletins" action="/anonymous/romero-bulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.romeroBulletin" action="/anonymous/romero-bulletin/create"/>
      
	    <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listFernandezBulletins" action="/anonymous/fernandez-bulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.FernandezBulletin" action="/anonymous/fernandez-bulletin/create"/>
		
    	<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.ganfornina-bulletins" action="/anonymous/ganfornina-bulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.ganfornina-bulletin" action="/anonymous/ganfornina-bulletin/create"/>
      
  		<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listGarciaBulletins" action="/anonymous/garcia-bulletin/list"/>
			<acme:menu-suboption code="master.menu.anonymous.createGarciaBulletin" action="/anonymous/garcia-bulletin/create"/>
      
     	<acme:menu-separator/>
	  	<acme:menu-suboption code="master.menu.anonymous.listAnnouncements" action="/anonymous/announcement/list"/>
			
	  	<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listCompanyRecords" action="/anonymous/company-record/list"/>
      
      <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.listInvestorRecord" action="/anonymous/investor-record/list"/>
		
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.authenticated.offers" action="/authenticated/offer/list"/>
			<acme:menu-suboption code="master.menu.authenticated.listCompanyRecords" action="/authenticated/company-record/list"/>
      <acme:menu-suboption code="master.menu.authenticated.listAnnouncements" action="/authenticated/announcement/list"/>
			<acme:menu-suboption code="master.menu.authenticated.listInvestorRecord" action="/authenticated/investor-record/list"/>
		</acme:menu-option>
			
      
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
      <acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.listAnnouncements" action="/administrator/announcement/list"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.favourite-link" action="http://www.example.com/"/>
		</acme:menu-option>
		

	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

