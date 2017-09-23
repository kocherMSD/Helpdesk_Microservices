/**
 * 
 */
package org.helpdesk.services.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rpapiset
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "ProductDetailsResponse")
public class ProductDetailsResponse  extends StatusResponse implements RestServiceResponse{
	
	private List<ProductFamilyDetails> productFamilyListList;
	

	/**
	 * @return the productFamilyList
	 */
	@XmlElement(name="ProductFamilyList")
	public List<ProductFamilyDetails> getProductFamilyListList() {
		return productFamilyListList;
	}

	/**
	 * @param productFamilyListList the productFamilyListList to set
	 */
	public void setProductFamilyListList(
			List<ProductFamilyDetails> productFamilyListList) {
		this.productFamilyListList = productFamilyListList;
	}

	/**
	 * @return the id
	 */
	

	
}
