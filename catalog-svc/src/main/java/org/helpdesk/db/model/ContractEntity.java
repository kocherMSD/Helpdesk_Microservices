package org.helpdesk.db.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@Entity
@Table(name="contracts")
public class ContractEntity extends BaseBusinessObject implements Serializable{
	
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable=false)
	private Long  id;
    
    
    @Column(name="ccoid")
	private String  ccoid;  
    
    @Column(name="contractnumber")
	private String  contractnumber;
    
    @Column(name="contractexpdate")
	private String  contractexpdate;
    
    @Column(name="contractstatus")
	private String  contractstatus;
    
    @Column(name="contracttype")
	private String  contracttype;
    
    @Column(name="servicelinedesc")
	private String  servicelinedesc;
    
    @Column(name="servicelinestatus")
	private String  servicelinestatus;
    
    @Column(name="servicelinestartdate")
	private String  servicelinestartdate;
    
    @Column(name="servicelineenddate")
	private String  servicelineenddate;
    
    @Column(name="billtositeuse_id")
	private String  billtositeuse_id;
    
    @Column(name="billtoparty_id")
	private String  billtoparty_id;
    
    @Column(name="created_date")
	private String  created_date;
    
    @Column(name="updated_date")
	private String  updated_date;
    
    @Column(name="version")
	private String  version;
    
    @Column(name="entitlement_key")
    private String entitlementKey;	


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
	 * @return the ccoid
	 */
	public String getCcoid() {
		return ccoid;
	}


	/**
	 * @param ccoid the ccoid to set
	 */
	public void setCcoid(String ccoid) {
		this.ccoid = ccoid;
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
	 * @return the contractexpdate
	 */
	public String getContractexpdate() {
		return contractexpdate;
	}


	/**
	 * @param contractexpdate the contractexpdate to set
	 */
	public void setContractexpdate(String contractexpdate) {
		this.contractexpdate = contractexpdate;
	}


	/**
	 * @return the contractstatus
	 */
	public String getContractstatus() {
		return contractstatus;
	}


	/**
	 * @param contractstatus the contractstatus to set
	 */
	public void setContractstatus(String contractstatus) {
		this.contractstatus = contractstatus;
	}


	/**
	 * @return the contracttype
	 */
	public String getContracttype() {
		return contracttype;
	}


	/**
	 * @param contracttype the contracttype to set
	 */
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}


	/**
	 * @return the servicelinedesc
	 */
	public String getServicelinedesc() {
		return servicelinedesc;
	}


	/**
	 * @param servicelinedesc the servicelinedesc to set
	 */
	public void setServicelinedesc(String servicelinedesc) {
		this.servicelinedesc = servicelinedesc;
	}


	/**
	 * @return the servicelinestatus
	 */
	public String getServicelinestatus() {
		return servicelinestatus;
	}


	/**
	 * @param servicelinestatus the servicelinestatus to set
	 */
	public void setServicelinestatus(String servicelinestatus) {
		this.servicelinestatus = servicelinestatus;
	}


	/**
	 * @return the servicelinestartdate
	 */
	public String getServicelinestartdate() {
		return servicelinestartdate;
	}


	/**
	 * @param servicelinestartdate the servicelinestartdate to set
	 */
	public void setServicelinestartdate(String servicelinestartdate) {
		this.servicelinestartdate = servicelinestartdate;
	}


	/**
	 * @return the servicelineenddate
	 */
	public String getServicelineenddate() {
		return servicelineenddate;
	}


	/**
	 * @param servicelineenddate the servicelineenddate to set
	 */
	public void setServicelineenddate(String servicelineenddate) {
		this.servicelineenddate = servicelineenddate;
	}


	/**
	 * @return the billtositeuse_id
	 */
	public String getBilltositeuse_id() {
		return billtositeuse_id;
	}


	/**
	 * @param billtositeuse_id the billtositeuse_id to set
	 */
	public void setBilltositeuse_id(String billtositeuse_id) {
		this.billtositeuse_id = billtositeuse_id;
	}


	/**
	 * @return the billtoparty_id
	 */
	public String getBilltoparty_id() {
		return billtoparty_id;
	}


	/**
	 * @param billtoparty_id the billtoparty_id to set
	 */
	public void setBilltoparty_id(String billtoparty_id) {
		this.billtoparty_id = billtoparty_id;
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


	@Override
    public String toString()
    {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);

    }
	
	public String getEntitlementKey() {
		return entitlementKey;
	}


	public void setEntitlementKey(String entitlementKey) {
		this.entitlementKey = entitlementKey;
	}	
	
}
