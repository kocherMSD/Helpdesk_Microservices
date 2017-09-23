package org.helpdesk.helpers;

import org.helpdesk.db.dao.CatalogueDao;
import org.helpdesk.services.request.CatalogueRequest;
import org.helpdesk.services.response.CatalogueResponse;


public class CatalogueServiceHelper {
	CatalogueDao dao=null;

	public static CatalogueResponse getCatalogue(String userId) {
		
		CatalogueResponse response=new CatalogueResponse();
		return response;
	}

	public  CatalogueResponse addCatalogue(CatalogueRequest req) {
		
		dao.saveUpdate(req);
		CatalogueResponse response=new CatalogueResponse();
		
		return response;
	}

	public  CatalogueResponse updateCatalogue(CatalogueRequest req) {
		dao.saveUpdate(req);
		CatalogueResponse response=new CatalogueResponse();
		return response;
	}

	public  CatalogueResponse deleteCatalogue(CatalogueRequest req) {
		dao.delete(req);
		CatalogueResponse response=new CatalogueResponse();
		return response;
	}

	/**
	 * @return the dao
	 */
	public CatalogueDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(CatalogueDao dao) {
		this.dao = dao;
	}

}
