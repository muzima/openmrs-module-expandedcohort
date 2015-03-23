<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ include file="/WEB-INF/template/header.jsp" %>

<openmrs:htmlInclude file="/moduleResources/cumulativecohort/styles/custom/custom.css"/>
<openmrs:htmlInclude file="/moduleResources/cumulativecohort/styles/bootstrap/css/bootstrap.css"/>

<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/jquery/jquery.js" />

<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/angular/angular.js"/>
<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/angular/angular-resource.js"/>

<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/custom/app.js"/>
<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/custom/controller.js"/>
<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/custom/truncate.js"/>

<openmrs:htmlInclude file="/moduleResources/cumulativecohort/js/ui-bootstrap/ui-bootstrap-custom-tpls-0.4.0.js"/>

<h3><spring:message code="cumulativecohort.view"/></h3>
<div class="bootstrap-scope" ng-app="cumulativecohort">
    <div ng-view ></div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>

