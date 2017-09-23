
package org.helpdesk.db.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;

import org.apache.log4j.Logger;
import org.helpdesk.db.model.BaseBusinessObject;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Settings;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class DataService {
	
    private static Logger logger = Logger.getLogger("DataService");

    private HibernateTemplate hibernateTemplate;
    
    /**
	 * This will save the feedback Entity
	 * @return
	 */
   public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
        try
        {
            Settings settings = ((SessionFactoryImpl) sessionFactory).getSettings();
            Connection connection = settings.getConnectionProvider().getConnection();
            logger.info("connection URL=" + connection.getMetaData().getURL());
        }
        catch (Exception e)
        {
            logger.fatal("Exception occured while getting settings=" + e);
        }
    }
    
    public List<BaseBusinessObject> findByCriteria(DetachedCriteria criteria)
    {
       return findByCriteria(criteria, null);
         
    }

    @SuppressWarnings("unchecked")
	public List<BaseBusinessObject> findByCriteria(DetachedCriteria criteria, String order)
    {

        List<BaseBusinessObject> results = null;

        if (order == null)
            results = hibernateTemplate.findByCriteria(criteria);
        else
            results = hibernateTemplate.findByCriteria(criteria.addOrder(Order.desc(order)));

        return results;
    }
    
    @SuppressWarnings("unchecked")
	public <T extends BaseBusinessObject> List<T> findEntityByCriteria(DetachedCriteria criteria){    
    	return hibernateTemplate.findByCriteria(criteria);    	
    }


    @SuppressWarnings("unchecked")
	public List<Object[]> findByGroupByCriteria(DetachedCriteria criteria, String order)
    {

        List<Object[]> results = null;

        if (order == null)
            results = hibernateTemplate.findByCriteria(criteria);
        else
            results = hibernateTemplate.findByCriteria(criteria.addOrder(Order.desc(order)));

        return results;
    }


    @SuppressWarnings("unchecked")
	public List<Object[]> find(String queryString, Object[] value)
    {
        if(null == value)
        	return hibernateTemplate.find(queryString);
        else
        	return hibernateTemplate.find(queryString, value);
    }
	
	public <E> boolean persistEntity(E entity){
		hibernateTemplate.persist(entity);
		return true;
	}
	
	/**
	 * @return the hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate the hibernateTemplate to set
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public <E> E getEntity(Class<E> clazz, Serializable id){
		return hibernateTemplate.get(clazz, id);
	}
	
	public <E> boolean saveOrUpdate(E entity){
		hibernateTemplate.saveOrUpdate(entity);
		return true;
	}
	 public void delete(BaseBusinessObject bbo)
	    {
	        hibernateTemplate.delete(bbo);
	    }
	 public void evict(BaseBusinessObject bbo)
	    {
	        hibernateTemplate.evict(bbo);
	    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
