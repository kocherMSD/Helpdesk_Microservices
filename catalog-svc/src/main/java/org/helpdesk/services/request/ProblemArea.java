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
@Entity(name="problemArea")
@Table(name="CTG_PROB_AREA")
public class ProblemArea implements ParentEntity{
	
	@Id
	@Column(name="PROB_AREA_SEQ_I",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	@JsonIgnore
	private long id;

	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="problemArea", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private Set<ProblemCode> problemCodes;
	
	@ManyToOne
	@JoinColumn(name="SUB_TECH_SEQ_I", nullable=false)
	@XmlTransient
	@JsonIgnore
	private SubTechnology subTechnology;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ProblemCode> getProblemCodes() {
		return problemCodes;
	}

	public void setProblemCodes(Set<ProblemCode> problemCodes) {
		this.problemCodes = problemCodes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@XmlTransient
	@JsonIgnore
	public SubTechnology getSubTechnology() {
		return subTechnology;
	}

	public void setSubTechnology(SubTechnology subTechnology) {
		this.subTechnology = subTechnology;
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
		ProblemArea other = (ProblemArea) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProblemArea [name=" + name + ", problemCodes=" + problemCodes
				+ "]";
	}

	@Override
	public void mapToParent() {
		if (problemCodes != null) {
			for (ProblemCode problemCode : problemCodes) {
				problemCode.setProblemArea(this);
				problemCode.mapToParent();
			}
		}
	}
	
	
}
