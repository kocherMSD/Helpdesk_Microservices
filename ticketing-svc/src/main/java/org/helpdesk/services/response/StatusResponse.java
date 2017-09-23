package org.helpdesk.services.response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author atandel
 * This would be the status response object.
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "StatusResponse")
public class StatusResponse implements RestServiceResponse{

	
	private String responseStatus;
	private String responseErrorMessage;
	private String responseErrorCode;

	
	
	
	/**
	 * @return the responseStatus
	 */
	@XmlElement
	public String getResponseStatus() {
		return responseStatus;
	}




	/**
	 * @param responseStatus the responseStatus to set
	 */
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}




	/**
	 * @return the responseErrorMessage
	 */
	@XmlElement
	public String getResponseErrorMessage() {
		return responseErrorMessage;
	}




	/**
	 * @param responseErrorMessage the responseErrorMessage to set
	 */
	public void setResponseErrorMessage(String responseErrorMessage) {
		this.responseErrorMessage = responseErrorMessage;
	}




	/**
	 * @return the responseErrorCode
	 */
	@XmlElement
	public String getResponseErrorCode() {
		return responseErrorCode;
	}




	/**
	 * @param responseErrorCode the responseErrorCode to set
	 */
	public void setResponseErrorCode(String responseErrorCode) {
		this.responseErrorCode = responseErrorCode;
	}




	@Override
	public String toString()
	{
		
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		
	}
	
}
