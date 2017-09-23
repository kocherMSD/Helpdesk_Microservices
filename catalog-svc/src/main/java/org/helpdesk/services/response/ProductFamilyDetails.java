/**
 * 
 */
package org.helpdesk.services.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author rpapiset
 *
 */
public class ProductFamilyDetails  {
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((productFamily == null) ? 0 : productFamily.hashCode());
		result = prime
				* result
				+ ((technologySolution == null) ? 0 : technologySolution
						.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductFamilyDetails other = (ProductFamilyDetails) obj;
		if (productFamily == null) {
			if (other.productFamily != null)
				return false;
		} else if (!productFamily.equals(other.productFamily))
			return false;
		if (technologySolution == null) {
			if (other.technologySolution != null)
				return false;
		} else if (!technologySolution.equals(other.technologySolution))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}
	private String productId;
	private String productFamily;
	//private List<String> productTypeList;
	private String technologySolution;
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
	/**
	 * @return the productFamily
	 */
	@XmlElement
	public String getProductFamily() {
		return productFamily;
	}
	/**
	 * @param productFamily the productFamily to set
	 */
	
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	/*
	/**
	 * @return the productTypeList
	 
	@XmlElement(name = "ProductTypeList")
	public List<String> getProductTypeList() {
		return productTypeList;
	}
	*//**
	 * @param productTypeList the productTypeList to set
	 *//*
	public void setProductTypeList(List<String> productTypeList) {
		this.productTypeList = productTypeList;
	}*/
	/**
	 * @return the technologySolution
	 */
	@XmlElement
	public String getTechnologySolution() {
		return technologySolution;
	}
	/**
	 * @param technologySolution the technologySolution to set
	 */
	public void setTechnologySolution(String technologySolution) {
		this.technologySolution = technologySolution;
	}

}
