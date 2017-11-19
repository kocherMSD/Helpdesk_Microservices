/**
 * 
 */
package org.helpdesk.services.impl;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.apache.log4j.Logger;
import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.helpers.CaseCreateInputsServiceHelper;
import org.helpdesk.services.CaseCreateInputsService;
import org.helpdesk.services.request.IssueTypeDetailsResponse;
import org.helpdesk.services.response.ProductDetailsResponse;
import org.helpdesk.utils.Util;
import org.springframework.stereotype.Component;

/**
 * @author rpapiset
 * 
 */
@Component
@Path("/service/rest/caseCreateInputsService")
public class CaseCreateInputsServiceImpl implements CaseCreateInputsService {

	private CaseCreateInputsServiceHelper caseCreateInputsServiceHelper;
	private Util util;
	private static Logger logger = Logger
			.getLogger(CaseCreateInputsServiceImpl.class);

	/**
	 * @return the caseCreateInputsServiceHelper
	 */
	public CaseCreateInputsServiceHelper getCaseCreateInputsServiceHelper() {
		return caseCreateInputsServiceHelper;
	}

	/**
	 * @param caseCreateInputsServiceHelper
	 *            the caseCreateInputsServiceHelper to set
	 */
	public void setCaseCreateInputsServiceHelper(
			CaseCreateInputsServiceHelper caseCreateInputsServiceHelper) {
		this.caseCreateInputsServiceHelper = caseCreateInputsServiceHelper;
	}

	/**
	 * @return the util
	 
	public Util getUtil() {
		return util;
	}*/

	/**
	 * @param util
	 *            the util to set
	 
	public void setUtil(Util util) {
		this.util = util;
	}*/

	/**
	 * 
	 */
	public CaseCreateInputsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * (javax.ws.rs.core.HttpHeaders)
	 */
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getProductsSolutions/{customerId}")
	public ProductDetailsResponse getProductsSolutions(
			@Context HttpHeaders headers ,@PathParam("customerId") String customerId) throws ServiceInvocationException {
		ProductDetailsResponse pdResponse = null;
		try {
			String ccoId = customerId;
			
			
			{
				
			pdResponse = caseCreateInputsServiceHelper
					.getAssociatedProductDetails(ccoId);
			}
			pdResponse.setResponseStatus("SUCCESS");
		} catch (Throwable e) {
			logger.error(e.toString());
			
		}

		return pdResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * (javax.ws.rs.core.HttpHeaders, java.lang.String)
	 */
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getIssueTypesAndScopes/{productId}")
	public IssueTypeDetailsResponse getIssueTypesAndScopes(
			@Context HttpHeaders headers,
			@PathParam("productId") String productId)
			throws ServiceInvocationException {
		IssueTypeDetailsResponse itResponse = null;
		try{
			itResponse = caseCreateInputsServiceHelper.getAssociatedIssueTypesAndScopes(productId);
			itResponse.setResponseStatus("SUCCESS");
		}catch (Throwable e) {
			logger.error(e.toString());
			
		}
		return itResponse;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * (javax.ws.rs.core.HttpHeaders)
	 */
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getProductsSolutionsStub")
	public ProductDetailsResponse getProductsSolutionsStub(
			@Context HttpHeaders headers) throws ServiceInvocationException {
		ProductDetailsResponse pdResponse = null;
		try {
			String ccoId = util.getIDFromHeaders(headers);
			
			logger.debug("User id  :"+ccoId);

			pdResponse = caseCreateInputsServiceHelper
					.getAssociatedProductDetailsDummy(ccoId);
			pdResponse.setResponseStatus("SUCCESS");
		} catch (Throwable e) {
			logger.error(e.toString());
			
		}

		return pdResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * (javax.ws.rs.core.HttpHeaders, java.lang.String)
	 */
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/getIssueTypesAndScopesStub/{productId}")
	public IssueTypeDetailsResponse getIssueTypesAndScopesStub(
			@Context HttpHeaders headers,
			@PathParam("productId") String productId)
			throws ServiceInvocationException {
		IssueTypeDetailsResponse itResponse = null;
		try{
			itResponse = caseCreateInputsServiceHelper.getAssociatedIssueTypesAndScopesDummy(productId);
			itResponse.setResponseStatus("SUCCESS");
		}catch (Throwable e) {
			logger.error(e.toString());
			
		}
		return itResponse;
	}


	
}
