package org.helpdesk.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issue_sr_mappings")
public class IssueMappingEntity  extends BaseBusinessObject {

	
	  
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	 private int  id;	
	  
    @Column(name="issuetype_id")
	 private int  issuetype_id;	
	  
    @Column(name="issuescope")
	 private String  issuescope;	
	  
    @Column(name="technology")
	 private String  technology;	
	  
    @Column(name="subtechnology")
	 private String  subtechnology;	
	  
    @Column(name="problemcode")
	 private String  problemcode;	
	  
    @Column(name="created_date")
	 private String  created_date;	
	  
    @Column(name="updated_date")
	 private String  updated_date;	
	  
    @Column(name="version")
	 private String  version;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the issuetype_id
	 */
	public int getIssuetype_id() {
		return issuetype_id;
	}
	/**
	 * @param issuetype_id the issuetype_id to set
	 */
	public void setIssuetype_id(int issuetype_id) {
		this.issuetype_id = issuetype_id;
	}
	/**
	 * @return the issuescope
	 */
	public String getIssuescope() {
		return issuescope;
	}
	/**
	 * @param issuescope the issuescope to set
	 */
	public void setIssuescope(String issuescope) {
		this.issuescope = issuescope;
	}
	
	/**
	 * @return the created_date
	 */
	public String getCreated_date() {
		return created_date;
	}
	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	/**
	 * @return the updated_date
	 */
	public String getUpdated_date() {
		return updated_date;
	}
	/**
	 * @param updated_date the updated_date to set
	 */
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}
	/**
	 * @return the subtechnology
	 */
	public String getSubtechnology() {
		return subtechnology;
	}
	/**
	 * @return the problemcode
	 */
	public String getProblemcode() {
		return problemcode;
	}
	/**
	 * @param technology the technology to set
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	/**
	 * @param subtechnology the subtechnology to set
	 */
	public void setSubtechnology(String subtechnology) {
		this.subtechnology = subtechnology;
	}
	/**
	 * @param problemcode the problemcode to set
	 */
	public void setProblemcode(String problemcode) {
		this.problemcode = problemcode;
	}
}
