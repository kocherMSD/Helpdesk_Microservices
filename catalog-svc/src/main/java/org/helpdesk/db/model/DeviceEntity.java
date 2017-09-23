package org.helpdesk.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="devices")
public class DeviceEntity  extends BaseBusinessObject implements Serializable {
	
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable=false)
	private Long id;	
	  
    @Column(name="PID")
	private String PID;	
	  
    @Column(name="contractnumber")
	private String contractnumber;	
	  
    @Column(name="serialnumber")
	private String serialnumber;	
	  
    @Column(name="product_id")
	private String product_id;	
	  
    @Column(name="created_date")
	private String created_date;	
	  
    @Column(name="updated_date")
	private String updated_date;	
	  
    @Column(name="version")
	private String version;
    
    @Column(name="supported")
    private String supported;
    
    @Column(name="servicelineID")
    private String servicelineID;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the pID
	 */
	public String getPID() {
		return PID;
	}
	/**
	 * @param pID the pID to set
	 */
	public void setPID(String pID) {
		PID = pID;
	}
	/**
	 * @return the contractnumber
	 */
	public String getContractnumber() {
		return contractnumber;
	}
	/**
	 * @param contractnumber the contractnumber to set
	 */
	public void setContractnumber(String contractnumber) {
		this.contractnumber = contractnumber;
	}
	/**
	 * @return the serialnumber
	 */
	public String getSerialnumber() {
		return serialnumber;
	}
	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
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
	/**
	 * @return the supportedType
	 */
	public String getSupported() {
		return supported;
	}
	/**
	 * @param supportedType the supportedType to set
	 */
	public void setSupported(String supported) {
		this.supported = supported;
	}
	/**
	 * @return the servicelineID
	 */
	public String getServicelineID() {
		return servicelineID;
	}
	/**
	 * @param servicelineID the servicelineID to set
	 */
	public void setServicelineID(String servicelineID) {
		this.servicelineID = servicelineID;
	}
	
	

}
