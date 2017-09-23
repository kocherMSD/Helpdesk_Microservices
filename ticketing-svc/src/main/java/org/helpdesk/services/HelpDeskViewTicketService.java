package org.helpdesk.services;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.services.request.NoteRequest;
import org.helpdesk.services.response.NoteResponse;
import org.helpdesk.services.response.ViewAllTicketResponse;
import org.helpdesk.services.response.ViewTicketResponse;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContextAware;

public interface  HelpDeskViewTicketService extends BeanFactoryAware, ApplicationContextAware {
	
	public abstract ViewTicketResponse viewTicket(@Context HttpHeaders headers,String userId,String ticketId) throws ServiceInvocationException;
	public abstract ViewAllTicketResponse viewAllTicket(@Context HttpHeaders headers) throws ServiceInvocationException;
	public abstract NoteResponse addNote( @Context HttpHeaders headers, NoteRequest request) throws ServiceInvocationException;

	
	

}
