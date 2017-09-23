package org.helpdesk.db.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.ProductEntity;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProductDetailsDAO {

	private DataService dataService;
	private Map<String,String> DefaultValueMap;
	private static Logger logger = Logger.getLogger(ProductDetailsDAO.class);

	/**
	 * To fetch the number of technical solution for product Id
	 * 
	 * @param ccoId
	 * @return
	 */

	public String getProductID(String productFamily) {
		List<String> products = new ArrayList<String>();

		DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
		criteria.add(Restrictions.eq("productfamily", productFamily));
		criteria.addOrder(Order.asc("pid"));
		List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			products.add("" + ((ProductEntity) bo).getId());
		}
		return products.get(0);
	}

	public List<ProductEntity> getProductsList(String productFamily) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
		criteria.add(Restrictions.like("productfamily", productFamily,
				MatchMode.ANYWHERE));
		criteria.addOrder(Order.asc("pid"));
		return dataService.findEntityByCriteria(criteria);		
	}

	/**
	 * 
	 * @return
	 */
	public List<String> getExistingProductFamily() {
		List<String> pfList = new ArrayList<String>();

		DetachedCriteria criteria = DetachedCriteria.forClass(ProductEntity.class);
		criteria.addOrder(Order.asc("pid"));
		List<BaseBusinessObject> retObj = dataService.findByCriteria(criteria);
		for (BaseBusinessObject bo : retObj) {
			pfList.add("" + ((ProductEntity) bo).getProductfamily());
		}

		return pfList;
	}
	


	

	
	

	public DataService getDataService() {
		return dataService;
	}

	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public Map<String, String> getDefaultValueMap() {
		return DefaultValueMap;
	}

	public void setDefaultValueMap(
			Map<String, String> DefaultValueMap) {
		this.DefaultValueMap = DefaultValueMap;
	}

}
