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
import org.helpdesk.helpers.HelpDeskViewTicketHelper;
import org.helpdesk.services.HelpDeskViewTicketService;
import org.helpdesk.services.request.NoteRequest;
import org.helpdesk.services.response.NoteResponse;
import org.helpdesk.services.response.ViewAllTicketResponse;
import org.helpdesk.services.response.ViewTicketResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Path("/HelpDeskViewTicket")
public class HelpDeskViewTicketServiceImpl implements HelpDeskViewTicketService {

	HelpDeskViewTicketHelper helper=null;

	
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/addNote")
	public NoteResponse addNote(@Context HttpHeaders headers, NoteRequest request)
			throws ServiceInvocationException {
		NoteResponse response=new NoteResponse();
		response=helper.addnote(request);
		return response;
	}
	
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/viewAllTicket/")
	public ViewAllTicketResponse viewAllTicket(@Context HttpHeaders headers)
			throws ServiceInvocationException {
		ViewAllTicketResponse response=helper.getAllTicket();
		return response;
	}
	
	
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/viewTicket/{userId}/{ticketId}")
	public ViewTicketResponse viewTicket(@Context HttpHeaders headers,@PathParam("userId")String  userId, @PathParam("ticketId")String  ticketId)
			throws ServiceInvocationException {
		ViewTicketResponse response=helper.getTicket(userId,ticketId);
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
	public HelpDeskViewTicketHelper getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(HelpDeskViewTicketHelper helper) {
		this.helper = helper;
	}




}
