package org.openmrs.module.expandedcohort.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExpandedCohortController{

	protected final Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/module/expandedcohort/view.list", method = RequestMethod.GET)
	public void view() {

	}
}
