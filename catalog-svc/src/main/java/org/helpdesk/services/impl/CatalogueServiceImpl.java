package org.helpdesk.services.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.helpers.CatalogueServiceHelper;
import org.helpdesk.services.CatalogueService;
import org.helpdesk.services.request.CatalogueRequest;
import org.helpdesk.services.response.CatalogueResponse;
import org.helpdesk.services.response.ProductDetailsResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("/CatalogueService")
public class CatalogueServiceImpl implements CatalogueService {

	CaseCreateInputsServiceImpl caseCreate=null;
	CatalogueServiceHelper helper=null;
	
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getCatalogue/{customerId}")
	public ProductDetailsResponse getCatalogue(@Context HttpHeaders headers, @PathParam("customerId") String customerId)
			throws ServiceInvocationException {
		ProductDetailsResponse response=new ProductDetailsResponse();
	    response=caseCreate.getProductsSolutions(headers, customerId);
		return response;	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/addCatalogue/")
	public CatalogueResponse addCatalogue(@Context HttpHeaders headers,
			CatalogueRequest req) throws ServiceInvocationException {
		CatalogueResponse response=new CatalogueResponse();
		response=helper.addCatalogue(req);
		return response;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/updateCatalogue/")
	public CatalogueResponse updateCatalogue(HttpHeaders headers,
			CatalogueRequest req) throws ServiceInvocationException {
		CatalogueResponse response=new CatalogueResponse();
		response=helper.updateCatalogue(req);
		return response;
	}

	@Override
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/deleteCatalogue/")
	public CatalogueResponse deleteCatalogue(HttpHeaders headers,
			CatalogueRequest req) throws ServiceInvocationException {
		CatalogueResponse response=new CatalogueResponse();
		response=helper.deleteCatalogue(req);
		return response;
	}
	
	
	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}



	/**
	 * @return the helper
	 */
	public CatalogueServiceHelper getHelper() {
		return helper;
	}



	/**
	 * @param helper the helper to set
	 */
	public void setHelper(CatalogueServiceHelper helper) {
		this.helper = helper;
	}

	/**
	 * @return the caseCreate
	 */
	public CaseCreateInputsServiceImpl getCaseCreate() {
		return caseCreate;
	}

	/**
	 * @param caseCreate the caseCreate to set
	 */
	public void setCaseCreate(CaseCreateInputsServiceImpl caseCreate) {
		this.caseCreate = caseCreate;
	}


}
