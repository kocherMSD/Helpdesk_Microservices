package org.helpdesk.db.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class NoteEntity  extends BaseBusinessObject{

	
	  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable=false)
	private Integer id;	
	  
    @Column(name="noteText")
	private String noteText;	
	  
    @Column(name="dateTime")
	private String dateTime;	
    
    @Column(name="NotesType")
	private String NotesType;	
	  
    @Column(name="ticket_id")
	private String ticket_id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the noteText
	 */
	public String getNoteText() {
		return noteText;
	}



	/**
	 * @return the ticket_id
	 */
	public String getTicket_id() {
		return ticket_id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @param noteText the noteText to set
	 */
	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	/**
	 * @param ticket_id the ticket_id to set
	 */
	public void setTicket_id(String ticket_id) {
		this.ticket_id = ticket_id;
	}

	/**
	 * @return the dateTime
	 */
	public String getDateTime() {
		return dateTime;
	}

	/**
	 * @return the notesType
	 */
	public String getNotesType() {
		return NotesType;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @param notesType the notesType to set
	 */
	public void setNotesType(String notesType) {
		NotesType = notesType;
	}	
	
	
}
