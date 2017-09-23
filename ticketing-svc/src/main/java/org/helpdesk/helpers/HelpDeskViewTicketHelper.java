package org.helpdesk.helpers;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.dao.ViewTicketDao;
import org.helpdesk.db.model.TicketRequestEntity;
import org.helpdesk.services.request.NoteRequest;
import org.helpdesk.services.response.NoteResponse;
import org.helpdesk.services.response.ViewAllTicketResponse;
import org.helpdesk.services.response.ViewTicketResponse;

public class HelpDeskViewTicketHelper {
	
	ViewTicketDao dao=null;

	public  ViewTicketResponse getTicket(String userId, String ticketId) {
		// TODO Auto-generated method stub
		TicketRequestEntity ticketRequestEntity=	dao.findUserTicket(userId,ticketId);
			ViewTicketResponse trw=new ViewTicketResponse();
			trw.setCustomer_name(ticketRequestEntity.getCustomer_name());
			trw.setDescriptiveSummary(ticketRequestEntity.getDescriptiveSummary());
			trw.setEmailAddress(ticketRequestEntity.getEmailAddress());
			trw.setIssueScope(ticketRequestEntity.getIssueScope());
			trw.setIssueType(ticketRequestEntity.getIssueType());
			trw.setOutage(ticketRequestEntity.getOutage());
			trw.setProduct(ticketRequestEntity.getProduct());
			trw.setProductFamily(ticketRequestEntity.getProductFamily());
			trw.setSeverityId(ticketRequestEntity.getSeverityId());
			trw.setStatusName(ticketRequestEntity.getStatusName());
			trw.setSummary(ticketRequestEntity.getSummary());
			trw.setUserId(ticketRequestEntity.getUserId());
			
			
	
		
		return trw;
	}

	public ViewAllTicketResponse getAllTicket() {
		ViewAllTicketResponse res=new ViewAllTicketResponse();
		// TODO Auto-generated method stub
		List<TicketRequestEntity> ticketRequestEntities=	dao.findUserTicket();
		List<ViewTicketResponse> ticketRequestsWS=	new ArrayList<ViewTicketResponse>();
		for(TicketRequestEntity ticketRequestEntity:ticketRequestEntities)
		{
			ViewTicketResponse trw=new ViewTicketResponse();
			trw.setCustomer_name(ticketRequestEntity.getCustomer_name());
			trw.setDescriptiveSummary(ticketRequestEntity.getDescriptiveSummary());
			trw.setEmailAddress(ticketRequestEntity.getEmailAddress());
			trw.setIssueScope(ticketRequestEntity.getIssueScope());
			trw.setIssueType(ticketRequestEntity.getIssueType());
			trw.setOutage(ticketRequestEntity.getOutage());
			trw.setProduct(ticketRequestEntity.getProduct());
			trw.setProductFamily(ticketRequestEntity.getProductFamily());
			trw.setSeverityId(ticketRequestEntity.getSeverityId());
			trw.setStatusName(ticketRequestEntity.getStatusName());
			trw.setSummary(ticketRequestEntity.getSummary());
			trw.setUserId(ticketRequestEntity.getUserId());
			ticketRequestsWS.add(trw);
			
			
		}
		res.setViewTicketResponses(ticketRequestsWS);
		
		return res;
	}
	
	
	public  NoteResponse addnote(NoteRequest request)
	{
		NoteResponse res=new NoteResponse();
		try
		{
		dao.addnote(request);	
		}
		catch(Exception e)
		{
			
			
		}
		return res;
	}

	/**
	 * @return the dao
	 */
	public ViewTicketDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(ViewTicketDao dao) {
		this.dao = dao;
	}
	
	
	
	

}
