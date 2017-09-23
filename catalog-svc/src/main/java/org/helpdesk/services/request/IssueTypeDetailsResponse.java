/**
 * 
 */
package org.helpdesk.services.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.helpdesk.services.response.RestServiceResponse;
import org.helpdesk.services.response.StatusResponse;

/**
 * @author rpapiset
 *
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "IssueTypeDetailsResponse")
public class IssueTypeDetailsResponse   extends StatusResponse implements RestServiceResponse{
	
	private String productId;
	private List<IssueTypeDetails> issueTypeList;
	/**
	 * @return the issueTypeList
	 */

	
	@XmlElement(name="IssueTypeDetails")
		public List<IssueTypeDetails> getIssueTypeList() {
		return issueTypeList;
	}
	/**
	 * @param issueTypeList the issueTypeList to set
	 */
	public void setIssueTypeList(List<IssueTypeDetails> issueTypeList) {
		this.issueTypeList = issueTypeList;
	}
	/**
	 * @return the productId
	 */
	@XmlElement
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	
}


