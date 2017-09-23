package org.helpdesk.services.request;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "CatalogueRequest")
public class CatalogueRequest {
	
		private String pid;	
		  
		private String productdesc;	
		  
		private String productfamily;	
		  
		private String solutiontechnology;	
		  
		private String created_date;	
		  
		private String updated_date;	
		  
		private String version;
	    	    
	    private String solution_products_flag;

		/**
		 * @return the pid
		 */
		@XmlElement
		public String getPid() {
			return pid;
		}

		/**
		 * @param pid the pid to set
		 */
		public void setPid(String pid) {
			this.pid = pid;
		}

		/**
		 * @return the productdesc
		 */
		@XmlElement
		public String getProductdesc() {
			return productdesc;
		}

		/**
		 * @param productdesc the productdesc to set
		 */
		
		public void setProductdesc(String productdesc) {
			this.productdesc = productdesc;
		}

		/**
		 * @return the productfamily
		 */
		@XmlElement
		public String getProductfamily() {
			return productfamily;
		}

		/**
		 * @param productfamily the productfamily to set
		 */
		public void setProductfamily(String productfamily) {
			this.productfamily = productfamily;
		}

		/**
		 * @return the solutiontechnology
		 */
		@XmlElement
		public String getSolutiontechnology() {
			return solutiontechnology;
		}

		/**
		 * @param solutiontechnology the solutiontechnology to set
		 */
		public void setSolutiontechnology(String solutiontechnology) {
			this.solutiontechnology = solutiontechnology;
		}

		/**
		 * @return the created_date
		 */
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		 * @return the solution_products_flag
		 */
		@XmlElement
		public String getSolution_products_flag() {
			return solution_products_flag;
		}

		/**
		 * @param solution_products_flag the solution_products_flag to set
		 */
		public void setSolution_products_flag(String solution_products_flag) {
			this.solution_products_flag = solution_products_flag;
		}
	    
	    

}
