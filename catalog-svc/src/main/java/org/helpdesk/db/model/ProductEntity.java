package org.helpdesk.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductEntity  extends BaseBusinessObject{

	/**
	 * 
	 */
	
	  
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name = "id", nullable=false)
	private int id;	
	
	  
    @Column(name="pid")
	private String pid;	
	  
    @Column(name="productdesc")
	private String productdesc;	
	  
    @Column(name="productfamily")
	private String productfamily;	
	  
    @Column(name="solutiontechnology")
	private String solutiontechnology;	
	  
    @Column(name="created_date")
	private String created_date;	
	  
    @Column(name="updated_date")
	private String updated_date;	
	  
    @Column(name="version")
	private String version;
    
    
    @Column(name="solution_products_flag")
    private String solution_products_flag;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the product_id
	 */
	
	/**
	 * @return the pid
	 */
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
	 * @return the solution_products_flag
	 */
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
