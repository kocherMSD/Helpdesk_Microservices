/**
 * 
 */
package org.helpdesk.helpers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.helpdesk.db.dao.DataService;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.ContractEntity;
import org.helpdesk.db.model.DeviceEntity;
import org.helpdesk.db.model.IssueMappingEntity;
import org.helpdesk.db.model.IssueTypeEntity;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.services.request.IssueTypeDetails;
import org.helpdesk.services.request.IssueTypeDetailsResponse;
import org.helpdesk.services.response.ProductDetailsResponse;
import org.helpdesk.services.response.ProductFamilyDetails;
import org.helpdesk.utils.Constants;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



public class CaseCreateInputsServiceHelper {

	private static Logger logger = Logger.getLogger(CaseCreateInputsServiceHelper.class);
	private DataService dataService ;
	/**
	 * This is the creation dummy product details and dummy product family
	 * @param ccoId
	 * @return
	 */
	
public ProductDetailsResponse getAssociatedProductDetailsDummy(String ccoId){
		ProductDetailsResponse pdResponse = new ProductDetailsResponse();
		ProductFamilyDetails pdDetails = new ProductFamilyDetails();
		//TODO implement method to get data from back-end
		pdDetails.setProductFamily("Catalyst 6500 Series");
		pdDetails.setProductId("Catalyst 6500 Series");
		pdDetails.setTechnologySolution("LAN Switching");
		ProductFamilyDetails pdDetails1 = new ProductFamilyDetails();
		pdDetails1.setProductFamily("Catalyst 6500 Series");
		pdDetails1.setProductId("Catalyst 6500 Series");
		pdDetails1.setTechnologySolution("LAN Switching");
		ArrayList<String> productTypes = new ArrayList<String>();
		productTypes.add("Catalyst 6501");
		productTypes.add("Catalyst 6504");
		productTypes.add("Catalyst 6508");
		ArrayList<ProductFamilyDetails> pfdetailsList = new ArrayList<ProductFamilyDetails>();
		pfdetailsList.add(pdDetails);
		pfdetailsList.add(pdDetails1);
		pdResponse.setProductFamilyListList(pfdetailsList);
		
		return pdResponse;
	}

/**
 * This is the creation dummy product details and issue scope and issue Type
 * @param ccoId
 * @return
 */
	public IssueTypeDetailsResponse getAssociatedIssueTypesAndScopesDummy(
			String productId) {
		// TODO Auto-generated method stub
		IssueTypeDetailsResponse itResponse = new IssueTypeDetailsResponse();
		IssueTypeDetails issueType1 = new IssueTypeDetails();
		issueType1.setIssueType("Operational");
		ArrayList<String> issueScopes = new ArrayList<String>();
		issueScopes.add("I don't know");
		issueScopes.add("Layer 2 Connectivity");
		issueScopes.add("Layer 3 Switching (MLS and CEF)");
		issueScopes.add("IGMP Multicast");
		issueScopes.add("Error Messages");
		issueScopes.add("Module and ports");
		issueType1.setIssueScopeList(issueScopes);
		IssueTypeDetails issueType2 = new IssueTypeDetails();
		issueType2.setIssueType("Performance");
		issueType2.setIssueScopeList(issueScopes);
		IssueTypeDetails issueType3 = new IssueTypeDetails();
		issueType3.setIssueType("Maintenance");
		issueType3.setIssueScopeList(issueScopes);
		ArrayList<IssueTypeDetails> issueTypeList = new ArrayList<IssueTypeDetails>();
		issueTypeList.add(issueType1);
		issueTypeList.add(issueType2);
		issueTypeList.add(issueType3);
		itResponse.setIssueTypeList(issueTypeList);
		
		return itResponse;
	}
	
	
	 /**
	    * This is fetching the product and product details
	    * @param productId
	    * @return
	    */
		public ProductDetailsResponse getAssociatedProductDetails(String ccoId){
			
			List<ProductFamilyDetails> pfdetailsList = new ArrayList<ProductFamilyDetails>();
			ProductDetailsResponse pdResponse = new ProductDetailsResponse();
			try
			{
		        List<String> contracts=getContractNumbers(ccoId);
				List<String> products=getProducts(contracts);			
			
			/*
			// implement method to get data from back-end services instead of database
				
				//Fetching the contact information of the user
				GetContractsResponse contactInfo=EFClient.GetContractsForCcoId(ccoId);
				List<Record> contractrecords=contactInfo.getSEARCHRESULTS().getRecord();
				
				
				//Fetching the serial numbers information of the User
				   EFClient.GetSerialNumbersForContract(contracts);
				
				//Fetching the product details information from the list of contracts
				   EFClient.GetSerialNumbersForContract(contracts);
				
			*/
				
		
			for(String product :products)
				{
				    ProductFamilyDetails pdDetails=new ProductFamilyDetails();
					pdDetails.setProductFamily(getProductFamily(product));//"Catalyst 6500 Series");
					pdDetails.setProductId(getPID(product));
					pdDetails.setTechnologySolution(getTechnologySolution(product));
					if(!pfdetailsList.contains(pdDetails))
					pfdetailsList.add(pdDetails);
				}
			
			 if (pfdetailsList.size() > 0) {
				    Collections.sort(pfdetailsList, new Comparator<ProductFamilyDetails>() {
				        @Override
				        public int compare(final ProductFamilyDetails object1, final ProductFamilyDetails object2) {
				            return object1.getProductFamily().compareTo(object2.getProductFamily());
				        }
				       } );
				   }
			     pdResponse.setProductFamilyListList(pfdetailsList);
			}
			catch(Exception e)
			{
			   logger.debug("There is an Exception in fetching the Product");	
				
			}
		
		
		return pdResponse;
	}
		
       public ProductDetailsResponse getAssociatedProductDetails(String ccoId,String customerId){
			
			List<ProductFamilyDetails> pfdetailsList = new ArrayList<ProductFamilyDetails>();
			ProductDetailsResponse pdResponse = new ProductDetailsResponse();
			try
			{
		        List<String> contracts=getContractNumbers(ccoId);
				List<String> products=getProducts(contracts);			
				
			/*
			// implement method to get data from back-end services instead of database
				
				//Fetching the contact information of the user
				GetContractsResponse contactInfo=EFClient.GetContractsForCcoId(ccoId);
				List<Record> contractrecords=contactInfo.getSEARCHRESULTS().getRecord();
				
				
				//Fetching the serial numbers information of the User
				   EFClient.GetSerialNumbersForContract(contracts);
				
				//Fetching the product details information from the list of contracts
				   EFClient.GetSerialNumbersForContract(contracts);
				
			*/
	    
		
			for(String product :products)
				{
				    ProductFamilyDetails pdDetails=new ProductFamilyDetails();
					pdDetails.setProductFamily(getProductFamily(product));//"Catalyst 6500 Series");
					pdDetails.setProductId(product);
					pdDetails.setTechnologySolution(getTechnologySolution(product));
					if(!pfdetailsList.contains(pdDetails))
					pfdetailsList.add(pdDetails);
				}
			
			 if (pfdetailsList.size() > 0) {
				    Collections.sort(pfdetailsList, new Comparator<ProductFamilyDetails>() {
				        @Override
				        public int compare(final ProductFamilyDetails object1, final ProductFamilyDetails object2) {
				            return object1.getProductFamily().compareTo(object2.getProductFamily());
				        }
				       } );
				   }
			     pdResponse.setProductFamilyListList(pfdetailsList);
			}
			catch(Exception e)
			{
			   logger.debug("There is an Exception in fetching the Product");	
				
			}
		
		
		return pdResponse;
	}

	
   /**
    * This is fetching the Issue types and Issue Scopes
    * @param productId
    * @return
    */
	
	public IssueTypeDetailsResponse getAssociatedIssueTypesAndScopes(
			String productId) {
		String[] array_issue_type={"Bug report","task","Feature request"};
		String alwayAtLast="I don't know";
		
		
		List<IssueTypeDetails> issueTypeList = new ArrayList<IssueTypeDetails>();
		List<IssueTypeDetails> issueTypeListSortedAsUsed = new ArrayList<IssueTypeDetails>();
		IssueTypeDetailsResponse itResponse = new IssueTypeDetailsResponse();
		IssueTypeDetails issueType = new IssueTypeDetails();
	
		try
		{
			List<String> issuetypes=getIssueTypes(productId);
		
			for(String issueTypeStr  :issuetypes)
				{
				 issueType = new IssueTypeDetails();
					//itResponse.set
				    issueType.setIssueType(getIssueTypesDesc(issueTypeStr));
					List<String> issueScopes=getIssueScopes(issueTypeStr);
					if(issueScopes.indexOf(alwayAtLast)!=-1)
					{
					issueScopes.remove(issueScopes.indexOf(alwayAtLast));
					issueScopes.add(alwayAtLast);
					}
					issueType.setIssueScopeList(issueScopes);
					issueTypeList.add(issueType);
					
				}
		
				for(int i=0;i<array_issue_type.length;i++)
				{
					for(IssueTypeDetails issueType1  :issueTypeList)
					{
						if(issueType1.getIssueType().equalsIgnoreCase(array_issue_type[i]))
						{
						  issueTypeListSortedAsUsed.add(issueType1);	
						  break;
						}
					}
					
				}
					//criteria.setProjection(Projections.distinct(Projections.property("customerName")));
				itResponse.setProductId(productId);
				itResponse.setIssueTypeList(issueTypeListSortedAsUsed);
		}
		catch(Exception e)
		{
			logger.debug("There is an Exception in fetching the Issue Scope and Issue Type");	
		}
				
	
		return itResponse;
	}
	
	/**
	 * To fetch the number of contract numbers for users
	 * @param ccoId
	 * @return
	 */
	private  List<String> getContractNumbers(String ccoId)
	{
		List<String> contracts=new ArrayList<String>();
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ContractEntity.class);
		
		criteria.add(Restrictions.eq("ccoid", ccoId));
		criteria.addOrder(Order.asc("contractnumber"));
		List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
		for(BaseBusinessObject bo :retObj)
		{
			contracts.add(((ContractEntity)bo).getContractnumber());
		}
		
		
		return contracts;
		
		
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
	
	/**
	 * To fetch the number of products for contract numbers
	 * @param ccoId
	 * @return
	 */
     private List<String> getProducts(List<String> contracts) {
		
		List<String> products=new ArrayList<String>();
		
		for(String contract:contracts)
		{
			DetachedCriteria criteria = DetachedCriteria.forClass(DeviceEntity.class);
			criteria.add(Restrictions.eq("contractnumber", contract));
			criteria.add(Restrictions.eq("supported", Constants.Yes));
			criteria.addOrder(Order.asc("contractnumber"));
		    criteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);

			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				if(!products.contains(((DeviceEntity)bo).getProduct_id()))
				{
					String serialNumber=((DeviceEntity)bo).getSerialnumber();
					String pf=((DeviceEntity)bo).getProduct_id();
       				
       				
       				if(!isCollabrativeProduct(pf))
       				{
       				if(!serialNumber.equals("-1")) 
       				{
			         	products.add(((DeviceEntity)bo).getProduct_id());
       				}
       				}
       				else
       				{
       					products.add(((DeviceEntity)bo).getProduct_id());
       				}
				}
			}
			
		}
		return products;
	}
     
 	/**
 	 * To fetch the number of product for contract number
 	 * @param ccoId
 	 * @return
 	 */
     private List<String> getProducts(String contract) {
 		
 		List<String> products=new ArrayList<String>();
 		
 		
 			DetachedCriteria criteria = DetachedCriteria.forClass(DeviceEntity.class);
 			criteria.add(Restrictions.ilike("contractnumber", contract, MatchMode.ANYWHERE));
 			criteria.addOrder(Order.asc("contractnumber"));
 			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
 			for(BaseBusinessObject bo :retObj)
 			{
 				products.add(((DeviceEntity)bo).getProduct_id());
 			}
 		return products;
 	}
     
 	/**
 	 * To fetch the number of issue types for products
 	 * @param ccoId
 	 * @return
 	 */
     private List<String> getIssueTypes(String productId) {
  		
  		List<String> products=new ArrayList<String>();
  		
  		
  			DetachedCriteria criteria = DetachedCriteria.forClass(IssueTypeEntity.class);
  			criteria.add(Restrictions.eq("product_id", productId));
  			criteria.addOrder(Order.asc("issuetype"));
  			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
  			for(BaseBusinessObject bo :retObj)
  			{
  				products.add(""+((IssueTypeEntity)bo).getId());
  			}
  		return products;
  	}
     
     /**
  	 * To fetch the number of issue types for products
  	 * @param ccoId
  	 * @return
  	 */
      private String getIssueTypesDesc(String Id) {
   		
   		List<String> products=new ArrayList<String>();
   		
   		
   			DetachedCriteria criteria = DetachedCriteria.forClass(IssueTypeEntity.class);
   			criteria.add(Restrictions.eq("id", Integer.parseInt(Id)));
   			criteria.addOrder(Order.asc("issuetype"));
   			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
   			for(BaseBusinessObject bo :retObj)
   			{
   				products.add(""+((IssueTypeEntity)bo).getIssuetype());
   			}
   		return products.get(0);
   	}
     
 	/**
 	 * To fetch the number of issue scopes tech,subtec,prob code for issue type
 	 * @param ccoId
 	 * @return
 	 */
     private List<String> getIssueScopes(String issueType) {
   		
    	 List<String> issueScope=new ArrayList<String>();
   		
   		
   			DetachedCriteria criteria = DetachedCriteria.forClass(IssueMappingEntity.class);
   			criteria.add(Restrictions.eq("issuetype_id", Integer.parseInt(issueType)));
   			criteria.addOrder(Order.asc("issuescope"));
   			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
   			for(BaseBusinessObject bo :retObj)
  			{
   				issueScope.add(((IssueMappingEntity)bo).getIssuescope());
  			}
   		
   		return issueScope;
   	}
     
 	/**
 	 * To fetch the number of product family  for product Id
 	 * @param ccoId
 	 * @return
 	 */
     
     private String getProductFamily(String productId)
     {
    	 List<String> products=new ArrayList<String>();
   		
   		
			DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
			criteria.add(Restrictions.eq("id", Integer.parseInt(productId)));
			criteria.addOrder(Order.asc("pid"));
			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				products.add(((ProductEntity)bo).getProductfamily());
			}
		
		
		return products.get(0); 
     }
     
 	/**
  	 * To fetch the number of technical solution for product Id
  	 * @param ccoId
  	 * @return
  	 */
      
     private String getTechnologySolution(String productId)
     {
    	 List<String> products=new ArrayList<String>();
    		
    		
			DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
			criteria.add(Restrictions.eq("id", Integer.parseInt(productId)));
			criteria.addOrder(Order.asc("pid"));
			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				products.add(((ProductEntity)bo).getSolutiontechnology());
			}
		
		
		return products.get(0);  
     }
     
  	/**
   	 * To fetch the number of technical solution for product Id
   	 * @param ccoId
   	 * @return
   	 */
       
      private String getPID(String productId)
      {
     	 List<String> products=new ArrayList<String>();
     		
     		
 			DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
 			criteria.add(Restrictions.eq("id", Integer.parseInt(productId)));
 			criteria.addOrder(Order.asc("pid"));
 			List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
 			for(BaseBusinessObject bo :retObj)
 			{
 				products.add(((ProductEntity)bo).getPid());
 			}
 		
 		
 		return products.get(0);  
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

	

}
