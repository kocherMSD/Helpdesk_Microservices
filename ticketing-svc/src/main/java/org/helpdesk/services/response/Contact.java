package org.helpdesk.services.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.NONE)
public class Contact {

	
	private String ccoid;
	private String contactPointType;
	private String contactPointValue;
	
	/**
	 * @return the ccoid
	 */
	public String getCcoid() {
		return ccoid;
	}
	/**
	 * @param ccoid the ccoid to set
	 */
	@XmlElement
	public void setCcoid(String ccoid) {
		this.ccoid = ccoid;
	}
	/**
	 * @return the contactPointType
	 */
	public String getContactPointType() {
		return contactPointType;
	}
	/**
	 * @param contactPointType the contactPointType to set
	 */
	@XmlElement
	public void setContactPointType(String contactPointType) {
		this.contactPointType = contactPointType;
	}
	/**
	 * @return the contactType
	 */
	/**
	 * @return the contactPointValue
	 */
	public String getContactPointValue() {
		return contactPointValue;
	}
	/**
	 * @param contactPointValue the contactPointValue to set
	 */
	@XmlElement
	public void setContactPointValue(String contactPointValue) {
		this.contactPointValue = contactPointValue;
	}
	
}
	


