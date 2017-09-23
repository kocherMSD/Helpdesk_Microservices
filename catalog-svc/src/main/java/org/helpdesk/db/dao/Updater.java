package org.helpdesk.db.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import java.sql.Connection;

import org.helpdesk.db.model.BaseBusinessObject;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionFactoryImpl;
import org.hibernate.cfg.Settings;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;


public class Updater
{

    private static Logger logger = Logger.getLogger("Updater");

    private HibernateTemplate hibernateTemplate;
    
    

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

    public void deleteAll(List<? extends BaseBusinessObject> entities)
    {
        hibernateTemplate.deleteAll(entities);
    }

    public void delete(BaseBusinessObject bbo)
    {
        hibernateTemplate.delete(bbo);
    }

    public void save(BaseBusinessObject bbo)
    {
        hibernateTemplate.save(bbo);
    }
    
    public void evict(BaseBusinessObject bbo)
    {
        hibernateTemplate.evict(bbo);
    }

    public void update(BaseBusinessObject bbo)
    {
        this.update(bbo, true);
    }
    
    public void merge(BaseBusinessObject bbo)
    {
        this.merge(bbo,true);
    }
    
    public void merge(BaseBusinessObject bbo,boolean evictAfter)
    {
        hibernateTemplate.merge(bbo);
        if (evictAfter)
            hibernateTemplate.evict(bbo);
    }

    public void update(BaseBusinessObject bbo, boolean evictAfter)
    {
        hibernateTemplate.update(bbo);
        if (evictAfter)
            hibernateTemplate.evict(bbo);
    }

    public void saveOrupdate(BaseBusinessObject bbo)
    {
        // logger.debug("bbo.getId()="+bbo.getId()+";bbo.getVersion()="+bbo.getVersion());
        hibernateTemplate.saveOrUpdate(bbo);
    }

    public void saveOrUpdateAll(Collection<? extends BaseBusinessObject> bbo)
    {
        hibernateTemplate.saveOrUpdateAll(bbo);
    }

    public BaseBusinessObject findByPrimaryKey(Class<? extends BaseBusinessObject> classInstance,
                                               long pk)
    {
        BaseBusinessObject result = null;

        DetachedCriteria criteria = DetachedCriteria.forClass(classInstance);
        criteria.add(Restrictions.idEq(pk));

        @SuppressWarnings("unchecked")
		List<BaseBusinessObject> results = hibernateTemplate.findByCriteria(criteria);

        if (results.size() == 1)
            return (BaseBusinessObject) results.get(0);
        else if (results.size() > 1)
        {
            // throw an exception
        }

        return result;
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
	public List<Object[]> find(String queryString, Object[] value)
    {
        return hibernateTemplate.find(queryString, value);
    }
    
	
}
