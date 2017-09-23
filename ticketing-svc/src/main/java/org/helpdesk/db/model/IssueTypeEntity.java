package org.helpdesk.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issueType")
public class IssueTypeEntity  extends BaseBusinessObject{
	
	  
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	 private int  id;	
	  
    @Column(name="issuetype")
	 private String  issuetype;	
	  
    @Column(name="issuetypedesc")
	 private String  issuetypedesc;	
	  
    @Column(name="product_id")
	 private String  product_id;	
	  
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
	 * @return the issuetype
	 */
	public String getIssuetype() {
		return issuetype;
	}
	/**
	 * @param issuetype the issuetype to set
	 */
	public void setIssuetype(String issuetype) {
		this.issuetype = issuetype;
	}
	/**
	 * @return the issuetypedesc
	 */
	public String getIssuetypedesc() {
		return issuetypedesc;
	}
	/**
	 * @param issuetypedesc the issuetypedesc to set
	 */
	public void setIssuetypedesc(String issuetypedesc) {
		this.issuetypedesc = issuetypedesc;
	}
	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
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
	 
	 
}
