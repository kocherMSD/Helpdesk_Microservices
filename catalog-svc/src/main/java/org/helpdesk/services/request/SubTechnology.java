package org.helpdesk.services.request;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.helpdesk.utils.ParentEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name="subTechnology")
@Table(name="CTG_SUB_TECH")
public class SubTechnology implements ParentEntity{

	@Id
	@Column(name="SUB_TECH_SEQ_I",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	@JsonIgnore
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="subTechnology",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<ProblemArea> problemAreas;
	
	@ManyToOne
	@JoinColumn(name="TECH_SEQ_I", nullable=false)
	@XmlTransient
	@JsonIgnore
	private Technology technology;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public Set<ProblemArea> getProblemAreas() {
		return problemAreas;
	}

	public void setProblemAreas(Set<ProblemArea> problemAreas) {
		this.problemAreas = problemAreas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlTransient
	@JsonIgnore
	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

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
		SubTechnology other = (SubTechnology) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "subTechnology [name=" + name + ", problemAreas="
				+ problemAreas + "]";
	}

	@Override
	public void mapToParent() {
		if (problemAreas != null) {
			for (ProblemArea problemArea : problemAreas) {
				problemArea.setSubTechnology(this);
				problemArea.mapToParent();
			}
		}
	}
	
	
	
}
