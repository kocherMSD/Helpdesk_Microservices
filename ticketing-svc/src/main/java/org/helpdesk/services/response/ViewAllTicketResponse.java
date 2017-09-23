package org.helpdesk.services.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ViewAllTicketResponse")
public class ViewAllTicketResponse {
	
	List <ViewTicketResponse> ViewAllTicketResponses;

	/**
	 * @return the viewAllTicketResponses
	 */
	@XmlElement(name="ViewAllTicketResponses")
	public List<ViewTicketResponse> getViewAllTicketResponses() {
		return ViewAllTicketResponses;
	}

	/**
	 * @param viewAllTicketResponses the viewAllTicketResponses to set
	 */
	public void setViewTicketResponses(
			List<ViewTicketResponse> viewAllTicketResponses) {
		ViewAllTicketResponses = viewAllTicketResponses;
	}
	
		
}
