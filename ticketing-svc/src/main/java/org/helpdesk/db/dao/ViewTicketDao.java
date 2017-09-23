package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.NoteEntity;
import org.helpdesk.db.model.TicketRequestEntity;
import org.helpdesk.services.request.NoteRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class ViewTicketDao extends DataService{
	
	public TicketRequestEntity findUserTicket(String userId,String ticketId) {
		
		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
		criteria.add(Restrictions.eq("userId", userId));
		criteria.add(Restrictions.eq("id", Integer.parseInt(ticketId)));
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequestEntities.add((TicketRequestEntity) bo);
		}
		return ticketRequestEntities.get(0);
	}
       public List<TicketRequestEntity> findUserTicket() {
		
		List<TicketRequestEntity> ticketRequestEntities = new ArrayList<TicketRequestEntity>();

		DetachedCriteria criteria = DetachedCriteria.forClass(TicketRequestEntity.class);
		List<BaseBusinessObject> retObj = findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			ticketRequestEntities.add((TicketRequestEntity) bo);
		}
		return ticketRequestEntities;
	}
       
       public List<NoteEntity> getnotes(String ticketId) {
   		
   		List<NoteEntity> notes = new ArrayList<NoteEntity>();

   		DetachedCriteria criteria = DetachedCriteria.forClass(NoteEntity.class);
   		criteria.add(Restrictions.eq("ticket_id", ticketId));
   		List<BaseBusinessObject> retObj = findByCriteria(criteria);
   		for (BaseBusinessObject bo : retObj) {
   			notes.add((NoteEntity) bo);
   		}
   		return notes;
   	}
       
	public void addnote(NoteRequest request) {
		
		NoteEntity note=new NoteEntity();
		note.setNoteText(request.getNotetext());
		note.setTicket_id(request.getTicketId());
		note.setDateTime(""+new java.util.Date());
		note.setNotesType(request.getNoteType());
		getHibernateTemplate().save(note);
		
		
	}

}
