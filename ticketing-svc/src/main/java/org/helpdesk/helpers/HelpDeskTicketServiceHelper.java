package org.helpdesk.helpers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.helpdesk.db.dao.DataService;
import org.helpdesk.db.dao.Updater;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.ContractEntity;
import org.helpdesk.db.model.DeviceEntity;
import org.helpdesk.db.model.IssueTypeEntity;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.db.model.UsersEntity;
import org.helpdesk.services.request.TicketRequest;
import org.helpdesk.services.response.TicketResponse;
import org.helpdesk.utils.Constants;
import org.helpdesk.utils.Util;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;




 /**
  * This is the helper file following Functionality Done  
  * Saves the Helpdesk Request in the Database.
  * Create the Read Sr.
  * Creates the template for the Email.
  *
  */

public class HelpDeskTicketServiceHelper {
	
	
	
 /**************************************************************************************************/
	private static Logger logger = Logger.getLogger(HelpDeskTicketServiceHelper.class);
	private Util util;
	private HashMap<String, String> DefaultValueMap;
	private Updater updater;
	private DataService dataService ;
	private String serialnumber;
	private String contractNumber;
/**************************************************************************************************/


	
	

	
	
	
	
	public String getCompanyName(TicketRequest ticketRequest,String ccoid) {
		String customerName="";
		try
		{
		logger.debug("getProduct::Finding the product with respect to the "+ticketRequest.getProduct());
			DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
			if(ticketRequest != null && !ticketRequest.getCustomer_name().isEmpty() ){
				criteria.add(Restrictions.eq("ccoid", ccoid));
			
			//criteria.setProjection(Projections.distinct(Projections.property("customerName")));
			
			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
			
			for(BaseBusinessObject bo:retObj)
				{
				customerName=bo!=null?((UsersEntity)bo).getCompanyname():"0";
				}
			}
			logger.debug("getCustomerName::Found the customerName "+customerName);
		}
		catch(Exception e)
		{
			logger.debug("getProduct:Exception in creating getCustomerName");	
	    }
		
		customerName=	!customerName.equals("")?customerName:"Not Available";
		
	 	return customerName;
		
	
	}

	


	/**
	 * To Do
	 * @param ticketRequest
	 * @return
	 */
	public String isPartner(TicketRequest ticketRequest) {
		String isPartner=ticketRequest.getIsPartner()!=null?ticketRequest.getIsPartner():"False";
		return isPartner;
	}


	
	
	/**
	 * To Do
	 * @param ticketRequest
	 * @return
	 */
	public String getDescriptiveSummary(TicketRequest ticketRequest) {
		String summary=ticketRequest.getDescriptiveSummary()!=null?ticketRequest.getDescriptiveSummary():"Not Available";
		 summary=summary!=""?summary:"Not Available";

		return summary;
	}




	/**
	 * To Do
	 * @param ticketRequest
	 * @return
	 *//*
	public NoteEntity getNotes(TicketRequestEntity ticketRequest,String Type,String ccoId,String companyName) {
		
		org.helpdesk.common.model.Note noteOne = new org.helpdesk.common.model.Note();

		if(Type.equalsIgnoreCase(DefaultValueMap.get("NoteType")))
		{
			String partnerMessage="";
			if(ticketRequest.getIsPartner()!=null&&ticketRequest.getIsPartner().equalsIgnoreCase("True"))
				partnerMessage=getPartnerMessage(ticketRequest, ccoId);	
		

		}
		else
		{
			noteOne.setNote(getDescriptiveSummary(ticketRequest));
			
		}
		
		noteOne.setNoteType(Type);
		
		NoteEntity notec3=new NoteEntity();
		notec3.setNote(noteOne.getNote());
		notec3.setNoteType(noteOne.getNoteType());
		notec3.setNoteStatus(efaultValueMap.get("NoteStatus"));
		
		return notec3;
	}
	*/
	
	


	private String setRouterName(TicketRequest ticketRequest) {
		// TODO Auto-generated method stub
		return DefaultValueMap.get("routerName");
	}


	private String getVerifyCPFlag(TicketRequest ticketRequest) {
		// TODO Auto-generated method stub
		return DefaultValueMap.get("verifyCPFlag");
	}


	private String getRequestContext(TicketRequest ticketRequest) {
		// TODO Auto-generated method stub
		return DefaultValueMap.get("requestContext");
	}


	private String getOutage(TicketRequest ticketRequest) {
		// TODO Auto-generated method stub
		return DefaultValueMap.get("outage");
	}


	private String getSeverityID(TicketRequest ticketRequest) {
        String severity="";
        severity=ticketRequest.getSeverityId()!=null&&!ticketRequest.getSeverityId().equals("")?ticketRequest.getSeverityId():"1";
		return severity;
	}



	public String validateRequest(TicketRequest ticketRequest)
	{
		String errorMessage="";
		logger.debug("validateRequest::Started validating the request");
	
		if(ticketRequest.getIssueType()==null||ticketRequest.getIssueType().equals(""))
			errorMessage=errorMessage.equals("")?"Empty Issue Type"	: errorMessage+",Issue Type";
		if(ticketRequest.getIssueScope()==null||ticketRequest.getIssueScope().equals(""))
			errorMessage=errorMessage.equals("")?"Empty Issue Scope"	:errorMessage+ ",Issue Scope";
		if(ticketRequest.getSummary()==null||ticketRequest.getSummary().equals(""))
			errorMessage=errorMessage.equals("")?"Case Title"	: errorMessage+",Title";
		if(ticketRequest.getProductFamily()==null||ticketRequest.getProductFamily().equals(""))
			errorMessage=errorMessage.equals("")?"Empty Product Family"	: errorMessage+",Product Family";
		if(!"".equals(errorMessage))
		errorMessage=errorMessage+".Please Provide Details.";
		else
		errorMessage=null;	
		logger.debug("validateRequest::completed the validation. the validation result"+errorMessage!=null?"Success":"Failure");
		logger.debug("validateRequest::The error message is "+errorMessage);
	   return errorMessage;	
	}
	
	/**
 	 * To fetch the number of issue types for products
 	 * @param ccoId
 	 * @return
 	 */
     private String getIssueTypesId(String issuetype,String productId) {
  		
  		List<String> products=new ArrayList<String>();
  		try
		{
  		
  			DetachedCriteria criteria = DetachedCriteria.forClass(IssueTypeEntity.class);
  			criteria.add(Restrictions.eq("product_id", Integer.parseInt(productId)));
  			criteria.add(Restrictions.eq("issuetype", issuetype));
  			criteria.addOrder(Order.asc("issuetype"));
  			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
  			for(BaseBusinessObject bo :retObj)
  			{
  				products.add(""+((IssueTypeEntity)bo).getId());
  			}
		}
  			catch(Exception e)
  			{
  				logger.debug("getIssueTypesId:Exception in creating sub technology from product family and Issue Type");	
  		    }
  			
  		return products.size()!=0?products.get(0):"";
  	}
     
     /**
  	 * To fetch the number of issue types for products
  	 * @param ccoId
  	 * @return
  	 */
      private String getProductId(String prodId) {
  		logger.debug("getProductId::Finding the product Id  with respect to the "+prodId);

   		List<String> products=new ArrayList<String>();
   		try
		{
   		
   			DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
   			criteria.add(Restrictions.eq("id",Integer.parseInt( prodId)));
   			criteria.addOrder(Order.asc("pid"));
   			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
   			for(BaseBusinessObject bo :retObj)
   			{
   				products.add(""+((ProductEntity)bo).getProductfamily());
   			}
   			
		}
			catch(Exception e)
			{
				logger.debug("getProductId:Exception in creating product from product family ");	
		    }
   		return products.size()!=0?products.get(0):null;
   	}
      
      
      /**
   	 * To fetch the number of issue types for products
   	 * @param ccoId
   	 * @return
   	 */
       public String getServiceLineID(String contractNumber,TicketRequest ticketRequest) {
    	  
    	   logger.debug("getSerialNo:Started");
    	   
    		if(!getSerialnumber().equalsIgnoreCase(Constants.NONE))
    		{
    			logger.info("Serial number : " + getSerialnumber());
    			return getSerialnumber();
    		}
    		List<String> products=new ArrayList<String>();
    		
    		try
    		{
    			DetachedCriteria criteria = DetachedCriteria.forClass(DeviceEntity.class);
    			criteria.add(Restrictions.eq("contractnumber", contractNumber));
    			criteria.addOrder(Order.asc("serialnumber"));
    			criteria.add(Restrictions.eq("supported", Constants.Yes));
    			criteria.add(Restrictions.eq("product_id", ticketRequest.getProductFamily()));
    			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
    			logger.info("No of ServiceLineIds fetched : " + retObj.size());
    			for(BaseBusinessObject bo :retObj)
    			{
    				products.add(""+((DeviceEntity)bo).getServicelineID());
    			}
            }
			catch(Exception e)
			{
				logger.debug("getSerialNo:Exception in creating serial number using contract number");	
		    }
    		if(products.size()!=0)
    		return products.get(0);
    		else
    		return	"";
    	}
       
       /**
      	 * To fetch the number of issue types for products
      	 * @param ccoId
      	 * @return
      	 */
          public String getSerialNo(String contractNumber,TicketRequest ticketRequest) {
       	  
       	   logger.debug("getSerialNo:Started");
       	   
       		if(!getSerialnumber().equalsIgnoreCase(Constants.NONE))
       		{
       			return getSerialnumber();
       		}
       		List<String> products=new ArrayList<String>();
       		
       		try
       		{
       			DetachedCriteria criteria = DetachedCriteria.forClass(DeviceEntity.class);
       			criteria.add(Restrictions.eq("contractnumber", contractNumber));
       			criteria.addOrder(Order.asc("serialnumber"));
       			criteria.add(Restrictions.eq("supported", Constants.Yes));
       			criteria.add(Restrictions.eq("product_id", ticketRequest.getProductFamily()));
       			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
       			for(BaseBusinessObject bo :retObj)
       			{
       				String serialNumber=((DeviceEntity)bo).getSerialnumber();
       				if( !serialNumber.equals("-1"))
       				{
       					products.add(serialNumber);
       				}
       				
       				
       			}
               }
   			catch(Exception e)
   			{
   				logger.debug("getSerialNo:Exception in creating serial number using contract number");	
   		    }
       		if(products.size()!=0)
       		return products.get(0);
       		else
       		return	"";
       	}
          
          /**
         	 * To fetch the number of issue types for products
         	 * @param ccoId
         	 * @return
         	 */
             public String getCollabrativePID(String contractNumber,TicketRequest ticketRequest) {
          	  
          	   logger.debug("getSerialNo:Started");
          	   
          		if(!getSerialnumber().equalsIgnoreCase(Constants.NONE))
          		{
          			return getSerialnumber();
          		}
          		List<String> products=new ArrayList<String>();
          		
          		try
          		{
          			DetachedCriteria criteria = DetachedCriteria.forClass(DeviceEntity.class);
          			criteria.add(Restrictions.eq("contractnumber", contractNumber));
          			criteria.addOrder(Order.asc("serialnumber"));
          			criteria.add(Restrictions.eq("supported", Constants.Yes));
          			criteria.add(Restrictions.eq("product_id", ticketRequest.getProductFamily()));
          			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
          			for(BaseBusinessObject bo :retObj)
          			{
          				products.add(""+((DeviceEntity)bo).getPID());
          			}
                  }
      			catch(Exception e)
      			{
      				logger.debug("getSerialNo:Exception in creating serial number using contract number");	
      		    }
          		if(products.size()!=0)
          		return products.get(0);
          		else
          		return	"";
          	}
       
       /**
      	 * To fetch the contract which is applicaple for the User
      	 * We will be only using contract which are supported Type
      	 * @param ccoId
      	 * @return
      	 */
          private String getContractNo(String ccoid,TicketRequest ticketRequest) {
        	
        	  
    	  if(!getContractNumber().equalsIgnoreCase(Constants.NONE))
	      		{
	      			return getContractNumber();
	      		}
   	       
           	  
           String contractNo="";
       		
       		try
    		{
       		
       			DetachedCriteria criteria = DetachedCriteria.forClass(ContractEntity.class);
       			criteria.add(Restrictions.eq("ccoid", ccoid));
       			criteria.addOrder(Order.asc("contractnumber"));
       			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
       			
       			
       			for(BaseBusinessObject bo :retObj)
       			{
       				DetachedCriteria criteriaDev = DetachedCriteria.forClass(DeviceEntity.class);
       				String contractNumber=((ContractEntity)bo).getContractnumber();
       				criteriaDev.add(Restrictions.eq("contractnumber", contractNumber));
       				criteriaDev.add(Restrictions.eq("supported", Constants.Yes));
       				criteriaDev.add(Restrictions.eq("product_id", ticketRequest.getProductFamily()));
       				criteriaDev.addOrder(Order.asc("contractnumber"));
       				List<BaseBusinessObject> retObjDev = dataService.findByCriteria(criteriaDev);
       				for(BaseBusinessObject boDev :retObjDev)
           			{
       					String serialNumber=((DeviceEntity)boDev).getSerialnumber();
           				
           				if( !serialNumber.equals("-1")) 
           				{
           					contractNo=	((DeviceEntity)boDev).getContractnumber();
       					       break;
           					
           				}
       					
           			}
       				if(!contractNo.equals(""))
       					break;
       				
       			}
    		}
       			catch(Exception e)
    			{
    				logger.debug("getContractNo:Exception in creating ContractNo  from ccoid ");	
    		    }
        	logger.info("Contract no fetched: " + contractNo);
       		return contractNo;
       	}
          
	/**
	 * To fetch the contract which is applicaple for the User We will be only
	 * using contract which are supported Type
	 * 
	 * @param ccoId
	 * @return
	 */
			public String getContractNoForEndCustomer(String ccoid, TicketRequest ticketRequest) {
		
				if (!getContractNumber().equalsIgnoreCase(Constants.NONE)) {
					return getContractNumber();
				}
		
				String contractNo = "";
		
				try {
		
					DetachedCriteria criteria = DetachedCriteria
							.forClass(ContractEntity.class);
					criteria.add(Restrictions.eq("ccoid", ccoid));
					criteria.addOrder(Order.asc("contractnumber"));
					List<BaseBusinessObject> retObj = dataService
							.findByCriteria(criteria);
		
					for (BaseBusinessObject bo : retObj) {
						DetachedCriteria criteriaDev = DetachedCriteria
								.forClass(DeviceEntity.class);
						String contractNumber = ((ContractEntity) bo).getContractnumber();
						criteriaDev.add(Restrictions.eq("contractnumber",
								contractNumber));
						criteriaDev.add(Restrictions.eq("supported", Constants.Yes));
						criteriaDev.add(Restrictions.eq("product_id",
								ticketRequest.getProductFamily()));
						criteriaDev.addOrder(Order.asc("contractnumber"));
						List<BaseBusinessObject> retObjDev = dataService
								.findByCriteria(criteriaDev);
						for (BaseBusinessObject boDev : retObjDev) {
							String serialNumber = ((DeviceEntity) boDev).getSerialnumber();
							String serviceLineId = ((DeviceEntity) boDev).getServicelineID();
		
							if (!serialNumber.equals("-1") || serviceLineId != null) {
								contractNo = ((DeviceEntity) boDev).getContractnumber();
								break;
		
							}
		
						}
						if (!contractNo.equals(""))
							break;
		
					}
				} catch (Exception e) {
					logger.debug("getContractNo:Exception in creating ContractNo  from ccoid ");
				}
				logger.info("Contract no fetched: " + contractNo);
				return contractNo;
			}
          
        
	/**
	 * @return the util
	 */
	public Util getUtil() {
		return util;
	}

	/**
	 * @param util the util to set
	 */
	public void setUtil(Util util) {
		this.util = util;
	}


	/**
	 * @return the DefaultValueMap
	 */
	public HashMap<String, String> getDefaultValueMap() {
		return DefaultValueMap;
	}


	/**
	 * @param DefaultValueMap the DefaultValueMap to set
	 */
	public void setDefaultValueMap(HashMap<String, String> DefaultValueMap) {
		this.DefaultValueMap = DefaultValueMap;
	}


	/**
	 * @return the updater
	 */
	public Updater getUpdater() {
		return updater;
	}


	/**
	 * @param updater the updater to set
	 */
	public void setUpdater(Updater updater) {
		this.updater = updater;
	}


	/**
	 * @return the dataService
	 */
	public DataService getDataService() {
		return dataService;
	}


	/**
	 * @param dataService the dataService to set
	 */
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}


	public TicketResponse createSr(TicketRequest ticketRequest) {
		TicketResponse output = new TicketResponse();
		try  {
			   saveToDatabase(ticketRequest);
			   
		    } catch (Exception e)
		    {

			  logger.debug("There is an exception in Creation of SR: Error in the ACS service");
		    }
		
		logger.debug("returning SR number");
		output.setResponseStatus("SUCCESS");
		return output;
	}
	

	/**
	 * @return the serialnumber
	 */
	public String getSerialnumber() {
		return serialnumber;
	}




	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}




	/**
	 * @return the contractNumber
	 */
	public String getContractNumber() {
		return contractNumber;
	}


	/**
	 * @param contractNumber the contractNumber to set
	 */
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	

	
	
	/**
	 * Get the User profile for the UsersEntity
	 * @param ccoId
	 * @return
	 */
	public UsersEntity getUserDetail(String ccoId)
	{
		UsersEntity user ;
		DetachedCriteria criteria = DetachedCriteria.forClass(UsersEntity.class);
			criteria.add(Restrictions.eq("ccoid", ccoId));
			criteria.addOrder(Order.asc("ccoid"));
			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
			user=(UsersEntity)retObj.get(0);
		return user;
		
		
	}
	



	
	public boolean isCollabrativeProduct(String productFamily)
	{
	boolean flag=false;
    ArrayList<String> products=new ArrayList<String>();
	try
 	{
	    DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
		criteria.add(Restrictions.eq("id",Integer.parseInt( productFamily)));
		criteria.addOrder(Order.asc("pid"));
		List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
		for(BaseBusinessObject bo :retObj)
		{
			products.add(""+((ProductEntity)bo).getSolution_products_flag());
		}
		
		if(products.get(0).equals("Y"))
			flag=true;
		
   }
	catch(Exception e)
	{
		logger.debug("getProductId:Exception in creating product from product family ");	
    }
		
	return flag;	
	}
	
	
	
	
	
	private String saveToDatabase(TicketRequest ticketRequest){
		
		org.helpdesk.db.model.TicketRequestEntity ticket = new org.helpdesk.db.model.TicketRequestEntity();
		ticket.setCustomer_name(ticketRequest.getCustomer_name());
		ticket.setDescriptiveSummary(ticketRequest.getDescriptiveSummary());
		ticket.setEmailAddress(ticketRequest.getEmailAddress());
		ticket.setIssueType(ticketRequest.getIssueType());
		ticket.setOutage(ticketRequest.getOutage());
		ticket.setProduct(ticketRequest.getProduct());
		ticket.setProductFamily(ticketRequest.getProductFamily());
		ticket.setSeverityId(ticketRequest.getSeverityId());
		ticket.setStatusName(ticketRequest.getStatusName());
		ticket.setSummary(ticketRequest.getSummary());
		ticket.setUserId(ticketRequest.getUserId());
	
		updater.save(ticket);
		
		return ticket.getTicketId()+"";
	}
	
	
	
}