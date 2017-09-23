package org.helpdesk.services.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "NoteRequest")
public class NoteRequest implements RestServiceRequest {

	
	
	private String notetext;
	private String userId;
	private String ticketId;
	private String NoteType;

	/**
	 * @return the notetext
	 */
	public String getNotetext() {
		return notetext;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the ticketId
	 */
	public String getTicketId() {
		return ticketId;
	}

	/**
	 * @param notetext the notetext to set
	 */
	@XmlElement
	public void setNotetext(String notetext) {
		this.notetext = notetext;
	}

	/**
	 * @param userId the userId to set
	 */
	@XmlElement
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	@XmlElement
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the noteType
	 */
	public String getNoteType() {
		return NoteType;
	}

	/**
	 * @param noteType the noteType to set
	 */
	@XmlElement
	public void setNoteType(String noteType) {
		NoteType = noteType;
	}

	/**
	 * @return the srNote
	 */


}
