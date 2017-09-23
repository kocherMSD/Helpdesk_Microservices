package org.helpdesk.services.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.helpdesk.services.response.Contact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.NONE)
public class TicketRequest {
	
	//private String serialNumber;
	//private String contractNumber;
	private String userId;
	private String summary;
	private String statusName;
	private String typeName;
	private String severityId;
	private String outage;
	private String requestContext;
	private String verifyCpFlag;
	
	private Contact contact;
	private String product;
	private String productFamily;
	private String  issueType;
	private String  issueScope;
	
	private String customer_name;
	private String isPartner;
	private String privilege_level;
	private String access_level;
	private String descriptiveSummary;
	private String accesslevel;
	
	private String emailAddress;
		
	
	@XmlElement  public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the product
	 */
	@XmlElement  public String getProduct() {
		return product;
	}
	/**
	 * @return the issueType
	 */
	@XmlElement  public String getIssueType() {
		return issueType;
	}
	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	/**
	 * @return the issueScope
	 */
	@XmlElement  public String getIssueScope() {
		return issueScope;
	}
	/**
	 * @param issueScope the issueScope to set
	 */
	public void setIssueScope(String issueScope) {
		this.issueScope = issueScope;
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
	@XmlElement  public String getProductFamily() {
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
	@XmlElement  public String getSummary() {
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
	@XmlElement  public String getStatusName() {
		return statusName;
	}
	/**
	 * @param statusName the statusName to set
	 */
	
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * @return the typeName
	 */
	@XmlElement  public String getTypeName() {
		return typeName;
	}
	/**
	 * @param typeName the typeName to set
	 */
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * @return the severityId
	 */
	@XmlElement  public String getSeverityId() {
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
	@XmlElement 
	public String getOutage() {
		return outage;
	}
	/**
	 * @return the accesslevel
	 */
	@XmlElement  
	public String getAccesslevel() {
		return accesslevel;
	}
	/**
	 * @param accesslevel the accesslevel to set
	 */
	public void setAccesslevel(String accesslevel) {
		this.accesslevel = accesslevel;
	}
	/**
	 * @param outage the outage to set
	 */
	
	public void setOutage(String outage) {
		this.outage = outage;
	}
	/**
	 * @return the requestContext
	 */
	@XmlElement
	public String getRequestContext() {
		return requestContext;
	}
	/**
	 * @param requestContext the requestContext to set
	 */
	
	public void setRequestContext(String requestContext) {
		this.requestContext = requestContext;
	}

	
	/**
	 * @return the verifyCpFlag
	 */
	@XmlElement 
	public String getVerifyCpFlag() {
		return verifyCpFlag;
	}
	/**
	 * @param verifyCpFlag the verifyCpFlag to set
	 */
	public void setVerifyCpFlag(String verifyCpFlag) {
		this.verifyCpFlag = verifyCpFlag;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * @return the customer_name
	 */
	@XmlElement  public String getCustomer_name() {
		return customer_name;
	}
	/**
	 * @param customer_name the customer_name to set
	 */
	
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	/**
	 * @return the isPartner
	 */
	@XmlElement  public String getIsPartner() {
		return isPartner;
	}
	/**
	 * @param isPartner the isPartner to set
	 */
	public void setIsPartner(String isPartner) {
		this.isPartner = isPartner;
	}
	/**
	 * @return the privilege_level
	 */
	@XmlElement  
	public String getPrivilege_level() {
		return privilege_level;
	}
	/**
	 * @param privilege_level the privilege_level to set
	 */
	
	public void setPrivilege_level(String privilege_level) {
		this.privilege_level = privilege_level;
	}
	/**
	 * @return the access_level
	 */
	@XmlElement 
	public String getAccess_level() {
		return access_level;
	}
	/**
	 * @param access_level the access_level to set
	 */
	
	public void setAccess_level(String access_level) {
		this.access_level = access_level;
	}
	

	
	/**
	 * @return the descriptiveSummary
	 */
	@XmlElement  public String getDescriptiveSummary() {
		return descriptiveSummary;
	}
	/**
	 * @param descriptiveSummary the descriptiveSummary to set
	 */
	
	public void setDescriptiveSummary(String descriptiveSummary) {
		this.descriptiveSummary = descriptiveSummary;
	}
	
	
	@XmlElement
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	

}
