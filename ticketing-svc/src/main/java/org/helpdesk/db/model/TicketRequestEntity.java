package org.helpdesk.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TicketRequest")
public class TicketRequestEntity  extends BaseBusinessObject{
	
	//private String serialNumber;
	//private String contractNumber;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable=false)
	private int ticketId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="summary")
	private String summary;
	
	@Column(name="status_name")
	private String statusName;
	
	@Column(name="severity")
	private String severityId;
	
	@Column(name="outage_type")
	private String outage;
	
	@Column(name="product")
	private String product;
	
	@Column(name="family")
	private String productFamily;
	
	@Column(name="issue_type")
	private String  issueType;
	
	@Column(name="issueScope")
	private String  issueScope;
	
	@Column(name="customer_name")
	private String customer_name;
	
	@Column(name="problem_description")
	private String descriptiveSummary;
	
	@Column(name="emailAddress")
	private String emailAddress;
		
	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}
	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	
	/**
	 * @param product the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return the productFamily
	 */
	public String getProductFamily() {
		return productFamily;
	}
	/**
	 * @param productfamily the productFamily to set
	 */
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the callerType
	 */

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	/**
	 * @return the severityId
	 */
	public String getSeverityId() {
		return severityId;
	}
	/**
	 * @param severityId the severityId to set
	 */
	public void setSeverityId(String severityId) {
		this.severityId = severityId;
	}
	
	/**
	 * @return the outage
	 */
	public String getOutage() {
		return outage;
	}
	/**
	 * @param outage the outage to set
	 */
	
	public void setOutage(String outage) {
		this.outage = outage;
	}
	
	/**
	 * @return the customer_name
	 */
	public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	
	/**
	 * @return the descriptiveSummary
	 */
	public String getDescriptiveSummary() {
		return descriptiveSummary;
	}
	/**
	 * @param descriptiveSummary the descriptiveSummary to set
	 */
	public void setDescriptiveSummary(String descriptiveSummary) {
		this.descriptiveSummary = descriptiveSummary;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the issueScope
	 */
	public String getIssueScope() {
		return issueScope;
	}
	/**
	 * @param issueScope the issueScope to set
	 */
	public void setIssueScope(String issueScope) {
		this.issueScope = issueScope;
	}	

}
