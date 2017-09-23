package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.ProductEntity;
import org.helpdesk.services.request.CatalogueRequest;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CatalogueDao extends DataService{
	
	
	public boolean saveUpdate(CatalogueRequest request)
	{
		ProductEntity prd=new ProductEntity();
		
		if(getProduct(request.getPid()).getPid()!=null)
			prd.setId(getProduct(request.getPid()).getId());
			
		prd.setPid(request.getPid());
		prd.setProductdesc(request.getProductdesc());
		prd.setProductfamily(request.getProductfamily());
		prd.setSolution_products_flag(request.getSolution_products_flag());
		prd.setSolutiontechnology(request.getSolutiontechnology());
		prd.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setVersion(""+0);
		saveOrUpdate(prd);
		evict(prd);
		return true;
	}
	
	
	
	
	 private ProductEntity getProduct(String productId)
     {
    	 List<ProductEntity> products=new ArrayList<ProductEntity>();
   		
   		
			DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
			criteria.add(Restrictions.eq("pid",productId));
			criteria.addOrder(Order.asc("pid"));
			List<BaseBusinessObject> retObj = findByCriteria(criteria);
			for(BaseBusinessObject bo :retObj)
			{
				products.add(((ProductEntity)bo));
			}
		
		
		return products.size()==0?new ProductEntity():products.get(0); 
     }
     



	public boolean delete(CatalogueRequest request)
	{
		ProductEntity prd=new ProductEntity();
		if(getProduct(request.getPid()).getPid()!=null)
			prd.setId(getProduct(request.getPid()).getId());
			
		prd.setPid(request.getPid());
		prd.setProductdesc(request.getProductdesc());
		prd.setProductfamily(request.getProductfamily());
		prd.setSolution_products_flag(request.getSolution_products_flag());
		prd.setSolutiontechnology(request.getSolutiontechnology());
		prd.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		prd.setVersion(""+0);
		
		delete(prd);
		evict(prd);
		return true;	
	}
	
	
	

}
