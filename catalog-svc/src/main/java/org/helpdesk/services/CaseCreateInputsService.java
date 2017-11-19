/**
 * 
 */
package org.helpdesk.services;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.services.request.IssueTypeDetailsResponse;
import org.helpdesk.services.response.ProductDetailsResponse;

public interface CaseCreateInputsService extends RestService {
	
	public ProductDetailsResponse getProductsSolutions(@Context HttpHeaders headers,  @PathParam("customerId") String customerId) throws ServiceInvocationException;
	
	public IssueTypeDetailsResponse getIssueTypesAndScopes(@Context HttpHeaders headers,  @PathParam("productId") String productId) throws ServiceInvocationException;

	public ProductDetailsResponse getProductsSolutionsStub(@Context HttpHeaders headers) throws ServiceInvocationException;
	
	public IssueTypeDetailsResponse getIssueTypesAndScopesStub(@Context HttpHeaders headers,  @PathParam("productId") String productId) throws ServiceInvocationException;

}
