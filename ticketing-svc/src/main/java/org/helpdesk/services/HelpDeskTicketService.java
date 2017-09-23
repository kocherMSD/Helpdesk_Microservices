package org.helpdesk.services;


import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.services.request.TicketRequest;
import org.helpdesk.services.response.RestResponse;
import org.helpdesk.services.response.TicketResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;


public interface HelpDeskTicketService extends BeanFactoryAware,ApplicationContextAware {
	
	public TicketResponse createHdTicket(@Context HttpHeaders headers,TicketRequest ticketRequest) throws ServiceInvocationException;
	

	public RestResponse getUser(@Context HttpHeaders headers, @PathParam("param") String ccoid );	
}