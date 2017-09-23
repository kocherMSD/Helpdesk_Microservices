package org.helpdesk.services.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author anujsin
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "TicketResponse")
public class TicketResponse extends StatusResponse {
	
	private String ticketNumber;

	@XmlElement
	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	
	


}
