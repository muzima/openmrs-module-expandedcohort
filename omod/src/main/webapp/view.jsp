<%@ include file="/WEB-INF/template/include.jsp" %>
<%@ include file="/WEB-INF/template/header.jsp" %>

<openmrs:require privilege="Edit Cohorts" otherwise="/login.htm" redirect="/module/muzima/view.list"/>
<openmrs:htmlInclude file="/moduleResources/expandedcohort/styles/custom/custom.css"/>
<openmrs:htmlInclude file="/moduleResources/expandedcohort/styles/bootstrap/css/bootstrap.css"/>

<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/jquery/jquery.js" />

<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/angular/angular.js"/>
<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/angular/angular-resource.js"/>

<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/custom/app.js"/>
<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/custom/controller.js"/>
<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/custom/truncate.js"/>

<openmrs:htmlInclude file="/moduleResources/expandedcohort/js/ui-bootstrap/ui-bootstrap-custom-tpls-0.4.0.js"/>

<h3><spring:message code="expandedcohort.view"/></h3>
<div class="bootstrap-scope" ng-app="expandedcohort">
    <div ng-view ></div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>

