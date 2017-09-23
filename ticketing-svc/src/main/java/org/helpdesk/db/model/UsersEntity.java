package org.helpdesk.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UsersEntity  extends BaseBusinessObject{

	
	  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable=false)
	private Integer id;	
	  
    @Column(name="ccoid")
	private String ccoid;	
	  
    @Column(name="firstname")
	private String firstname;	
	  
    @Column(name="middlename")
	private String middlename;	
	  
    @Column(name="lastname")
	private String lastname;	
	  
    @Column(name="erpparty_id")
	private String erpparty_id;	
	  
    @Column(name="companyname")
	private String companyname;	
	  
    @Column(name="accesslevel")
	private String accesslevel;	
	  
    @Column(name="emailaddress")
	private String emailaddress;	
	  
    @Column(name="crparty_id")
	private String crparty_id;	
	  
    @Column(name="phonenumber")
	private String phonenumber;	
	  
    @Column(name="gu_id")
	private String gu_id;	
	  
    @Column(name="created_date")
	private String created_date;	
	  
    @Column(name="updated_date")
	private String updated_date;	
    
    @Column(name="AppointmentCapability")
    private String  AppointmentCapability;
	  
    /**
	 * @return the weekend_restriction
	 */
	public String getWeekend_restriction() {
		return weekend_restriction;
	}
	/**
	 * @param weekend_restriction the weekend_restriction to set
	 */
	public void setWeekend_restriction(String weekend_restriction) {
		this.weekend_restriction = weekend_restriction;
	}
	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}
	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	/**
	 * @return the userworkingstarttime
	 */
	public String getUserworkingstarttime() {
		return userworkingstarttime;
	}
	/**
	 * @param userworkingstarttime the userworkingstarttime to set
	 */
	public void setUserworkingstarttime(String userworkingstarttime) {
		this.userworkingstarttime = userworkingstarttime;
	}
	@Column(name="version")
	private String version;
    
    @Column(name="privilege_level")
    private String privilegeLevel;
    
    @Column(name="smart_suggest_enabled")
    private String smart_suggest_enabled;
    
    @Column(name="case_creation_restriction_enabled")
	private String case_creation_restriction_enabled;
    
    @Column(name="weekend_restriction")
    private String  weekend_restriction; 
    
    @Column(name="timezone")
    private String  timezone;
    
    @Column(name="userworkingstarttime")
    private String userworkingstarttime;
    
	/**
	 * @return the privilegeLevel
	 */
	public String getPrivilegeLevel() {
		return privilegeLevel;
	}
	/**
	 * @param privilegeLevel the privilegeLevel to set
	 */
	public void setPrivilegeLevel(String privilegeLevel) {
		this.privilegeLevel = privilegeLevel;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the ccoid
	 */
	public String getCcoid() {
		return ccoid;
	}
	/**
	 * @param ccoid the ccoid to set
	 */
	public void setCcoid(String ccoid) {
		this.ccoid = ccoid;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}
	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the erpparty_id
	 */
	public String getErpparty_id() {
		return erpparty_id;
	}
	/**
	 * @param erpparty_id the erpparty_id to set
	 */
	public void setErpparty_id(String erpparty_id) {
		this.erpparty_id = erpparty_id;
	}
	/**
	 * @return the companyname
	 */
	public String getCompanyname() {
		return companyname;
	}
	/**
	 * @param companyname the companyname to set
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	/**
	 * @return the accesslevel
	 */
	public String getAccesslevel() {
		return accesslevel;
	}
	/**
	 * @param accesslevel the accesslevel to set
	 */
	public void setAccesslevel(String accesslevel) {
		this.accesslevel = accesslevel;
	}
	/**
	 * @return the emailaddress
	 */
	public String getEmailaddress() {
		return emailaddress;
	}
	/**
	 * @param emailaddress the emailaddress to set
	 */
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	/**
	 * @return the crparty_id
	 */
	public String getCrparty_id() {
		return crparty_id;
	}
	/**
	 * @param crparty_id the crparty_id to set
	 */
	public void setCrparty_id(String crparty_id) {
		this.crparty_id = crparty_id;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the gu_id
	 */
	public String getGu_id() {
		return gu_id;
	}
	/**
	 * @param gu_id the gu_id to set
	 */
	public void setGu_id(String gu_id) {
		this.gu_id = gu_id;
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
	 * @return the smart_suggest_enabled
	 */
	public String getSmart_suggest_enabled() {
		return smart_suggest_enabled;
	}
	/**
	 * @param smart_suggest_enabled the smart_suggest_enabled to set
	 */
	public void setSmart_suggest_enabled(String smart_suggest_enabled) {
		this.smart_suggest_enabled = smart_suggest_enabled;
	}
	/**
	 * @return the case_creation_restriction_enabled
	 */
	public String getCase_creation_restriction_enabled() {
		return case_creation_restriction_enabled;
	}
	/**
	 * @param case_creation_restriction_enabled the case_creation_restriction_enabled to set
	 */
	public void setCase_creation_restriction_enabled(
			String case_creation_restriction_enabled) {
		this.case_creation_restriction_enabled = case_creation_restriction_enabled;
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
	 * @return the appointmentCapability
	 */
	public String getAppointmentCapability() {
		return AppointmentCapability;
	}
	/**
	 * @param appointmentCapability the appointmentCapability to set
	 */
	public void setAppointmentCapability(String appointmentCapability) {
		AppointmentCapability = appointmentCapability;
	}
	
	
}
