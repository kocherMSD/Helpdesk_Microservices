package org.helpdesk.db.dao;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class UpdaterInterceptor extends EmptyInterceptor {

	private static Logger logger = Logger.getLogger(UpdaterInterceptor.class);
	private static final long serialVersionUID = 1L;
	private static String LAST_UPDATED_FIELD = "updated";
	private static String CREATED_ON_FIELD = "created";

	 public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,  String[] propertyNames,  Type[] types) 
	 {
		 logger.debug("In OnFlushDirthy Method Call");
		 for ( int i=0; i < propertyNames.length; i++ ) 
		 {
			 if ( LAST_UPDATED_FIELD.equals( propertyNames[i] ) ) 
			 {
				 currentState[i] = new Date();
				 return true;
			 }
		 }

		 return false;
	 }

	 public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) 
	 {
		 logger.debug("In OnSave Method Call");
		 logger.debug(entity);
		 logger.debug(id);
		 logger.debug(state);
		 logger.debug(propertyNames);
		 logger.debug(types);

		 boolean changed = false;
		 boolean changed2 = false;
		 Date updateDate = new Date();
		 for ( int i=0; i<propertyNames.length; i++ ) 
		 {
			 logger.debug(" propname: " + propertyNames[i] + " ;pre set state: " +state[i]);
			 if ( CREATED_ON_FIELD.equals( propertyNames[i] ) ) 
			 {
				 logger.debug("actually setting created on field for index " + i );
				 state[i] = updateDate;
				 changed = true;
				 if (changed && changed2)
					 break;
			 }
			 
			 if ( LAST_UPDATED_FIELD.equals( propertyNames[i] ) ) 
			 {
				 state[i] = updateDate;
				 changed2 = true;
				 if (changed && changed2)
					 break;
			 }
		 }
		 
		 return (changed || changed2);
	 }



}
