package org.helpdesk.db.model;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public class BaseBusinessObject implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	//@Version
	//protected Integer version;
	
	/*@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "TRANSACTION_ID", nullable=false)
	protected String id;*/
	
	
	

  //  @Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "created", nullable = false, updatable=false)
    //private Date created;

   // @Temporal(TemporalType.TIMESTAMP)
    //@Column(name = "updated", nullable = false)
    //private Date updated;

	

/*
	public Date getCreated() {
		return created;
	}

	public Date getUpdated() {
		return updated;
	}*/
    
    

    
}
