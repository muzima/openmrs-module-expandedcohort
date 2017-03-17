/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.expandedcohort.web.resource;

import java.util.Date;
import java.util.List;

import org.openmrs.Cohort;
import org.openmrs.CohortMembership;
import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.SubResource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource;
import org.openmrs.module.webservices.rest.web.resource.impl.NeedsPaging;
import org.openmrs.module.webservices.rest.web.response.ResourceDoesNotSupportOperationException;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.openmrs.module.webservices.rest.web.v1_0.resource.openmrs1_8.CohortResource1_8;

@SubResource(parent = CohortResource1_8.class, path = "memberships", supportedClass = CohortMembership.class,
		supportedOpenmrsVersions = { "2.1.*", "2.2.*" })
public class CohortMembershipSubResource2_1 extends DelegatingSubResource<CohortMembership, Cohort, CohortResource1_8> {

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#getParent(Object)
	 */
	@Override
	public Cohort getParent(CohortMembership cohortMembership) {
		return cohortMembership.getCohort();
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#setParent(Object, Object)
	 */
	@Override
	public void setParent(CohortMembership cohortMembership, Cohort cohort) {
		cohort.addMembership(cohortMembership);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#doGetAll(Object, RequestContext)
	 */
	@Override
	public NeedsPaging<CohortMembership> doGetAll(Cohort cohort, RequestContext requestContext) throws ResponseException {
		List<CohortMembership> memberships = cohort.getMemberships(new Date());
		return new NeedsPaging<CohortMembership>(memberships, requestContext);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#getByUniqueId(String)
	 */
	@Override
	public CohortMembership getByUniqueId(final String uniqueId) {
		return Context.getCohortService().getCohortMembershipByUuid(uniqueId);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#delete(Object, String,
	 *      RequestContext)
	 */
	@Override
	protected void delete(CohortMembership cohortMembership, String s, RequestContext requestContext)
			throws ResponseException {
		Context.getCohortService().removeMembershipFromCohort(getParent(cohortMembership), cohortMembership);
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource#newDelegate()
	 */
	public CohortMembership newDelegate() {
		return new CohortMembership();
	}

	public CohortMembership save(CohortMembership cohortMembership) {
		Context.getCohortService().addMembershipToCohort(getParent(cohortMembership), cohortMembership);
		return cohortMembership;
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.BaseDelegatingResource#purge(Object, RequestContext)
	 */
	@Override
	public void purge(CohortMembership cohortMembership, RequestContext requestContext) throws ResponseException {
		throw new ResourceDoesNotSupportOperationException();
	}

	/**
	 * @see org.openmrs.module.webservices.rest.web.resource.impl.DelegatingSubResource
	 *      #getRepresentationDescription(Representation)
	 */
	@Override
	public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
		if (rep instanceof DefaultRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("cohort");
			description.addProperty("patient", Representation.REF);
			description.addProperty("startDate");
			description.addProperty("endDate");
			description.addProperty("voided");
			description.addProperty("uuid");
			description.addSelfLink();
			description.addLink("full", ".?v=" + RestConstants.REPRESENTATION_FULL);
			return description;
		} else if (rep instanceof FullRepresentation) {
			DelegatingResourceDescription description = new DelegatingResourceDescription();
			description.addProperty("cohort");
			description.addProperty("patient");
			description.addProperty("startDate");
			description.addProperty("endDate");
			description.addProperty("voided");
			description.addProperty("uuid");
			description.addProperty("auditInfo");
			description.addSelfLink();
			return description;
		}
		return null;
	}
}
