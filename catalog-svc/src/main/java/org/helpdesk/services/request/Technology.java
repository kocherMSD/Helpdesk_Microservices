package org.helpdesk.services.request;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.helpdesk.utils.ParentEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name="technology")
@Table(name="CTG_TECH")
public class Technology implements ParentEntity{
	
	@Id
	@Column(name="TECH_SEQ_I",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	@JsonIgnore
	private long id;

	@Column(name="NAME")
	private String name;
	
	/*@ManyToOne
	@JoinColumn(name="CTG_PRD_SEQ_I", nullable=false)
	@XmlTransient
	@JsonIgnore
	private CategorizerProductDetails productDetails;
	*/
	@OneToMany(mappedBy="technology",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<SubTechnology> subTechnologies;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SubTechnology> getSubTechnologies() {
		return subTechnologies;
	}

	public void setSubTechnologies(Set<SubTechnology> subTechnologies) {
		this.subTechnologies = subTechnologies;
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*@XmlTransient
	@JsonIgnore
	public CategorizerProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(CategorizerProductDetails productDetails) {
		this.productDetails = productDetails;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Technology other = (Technology) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Technology [name=" + name + ", subTechnologies="
				+ subTechnologies + "]";
	}

	@Override
	public void mapToParent() {
		if (subTechnologies != null) {
			for (SubTechnology subTechnology : subTechnologies) {
				subTechnology.setTechnology(this);
				subTechnology.mapToParent();
			}
		}
	}
	
	

}
