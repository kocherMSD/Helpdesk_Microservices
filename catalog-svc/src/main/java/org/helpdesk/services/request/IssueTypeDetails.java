/**
 * 
 */
package org.helpdesk.services.request;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author rpapiset
 *
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "IssueTypeDetails")
@Entity(name="categorizerIssueType")
@Table(name="CTG_ISS_TYPE")
public class IssueTypeDetails{
	
	@Id
	@Column(name="ISS_TYPE_SEQ_I",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlTransient
	@JsonIgnore
	private long id;
	
	@Column(name="NAME")
	private String issueType;
	
	@ElementCollection
	@CollectionTable(name="CTG_ISS_SCOPE", joinColumns=@JoinColumn(name="ISS_TYPE_SEQ_I"))
	@Column(name="ISS_SCOPE_NAME")
	private List<String> issueScopeList;
	
	@ManyToOne
	@JoinColumn(name="PROB_CDE_SEQ_I", nullable=false)
	@XmlTransient
	@JsonIgnore
	private ProblemCode problemCode;
	/**
	 * @return the issueType
	 */
	@XmlElement
	public String getIssueType() {
		return issueType;
	}
	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	/**
	 * @return the issueScopeList
	 */
	@XmlElement(name="issueScopeList")
	public List<String> getIssueScopeList() {
		return issueScopeList;
	}
	/**
	 * @param issueScopeList the issueScopeList to set
	 */
	public void setIssueScopeList(List<String> issueScopeList) {
		this.issueScopeList = issueScopeList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProblemCode getProblemCode() {
		return problemCode;
	}
	public void setProblemCode(ProblemCode problemCode) {
		this.problemCode = problemCode;
	}
	@Override
	public String toString() {
		return "IssueTypeDetails [issueType=" + issueType + ", issueScopeList="
				+ issueScopeList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((issueType == null) ? 0 : issueType.hashCode());
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
		IssueTypeDetails other = (IssueTypeDetails) obj;
		if (issueType == null) {
			if (other.issueType != null)
				return false;
		} else if (!issueType.equals(other.issueType))
			return false;
		return true;
	}
	
	

}
