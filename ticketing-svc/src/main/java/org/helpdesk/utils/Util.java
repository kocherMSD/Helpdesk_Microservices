package org.helpdesk.utils;

import static org.helpdesk.utils.Constants.CUR_VALUE_PREFIX;
import static org.helpdesk.utils.Constants.GEO_CODE_STC_UNKNOWN;
import static org.helpdesk.utils.Constants.NO_VALUE;
import static org.helpdesk.utils.Constants.P;
import static org.helpdesk.utils.Constants.PREV_VALUE_PREFIX;
import static org.helpdesk.utils.Constants.S;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.HttpHeaders;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.db.dao.Updater;
import org.helpdesk.services.response.StatusResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class Util {
	
	private String defaultCCOId;
	 private HashMap<String, String> msgCatelog;
	private static Logger logger = Logger.getLogger(Util.class);
	public static Map<String,String> JSON_JAVA_MAP_CASENOTES = new HashMap<String,String>();

	private Updater updater;

	
	
	
		/**
		 * Takes the headers of the REST service request and extracts the ccoid from them
		 * @param headers
		 * @return
		 */
		public String getIDFromHeaders(HttpHeaders headers) throws ServiceInvocationException
		{
			String ccoId = defaultCCOId;
			logger.debug("Default user is " + ccoId);
			
		if (ccoId.equalsIgnoreCase(Constants.NONE))
			{
			
			logger.debug("Taking ccoId from the mashery header");
			logger.debug("Header is " + headers);
			if (headers != null)
			{
				
				List<String> masheryHandshake = headers.getRequestHeader("X-Mashery-Handshake");
				logger.debug("Mashery header is " + masheryHandshake);
				if (masheryHandshake != null && masheryHandshake.size() > 0)
				{
					String masheryEncodedString = masheryHandshake.get(0);
					byte[] value =  Base64.decodeBase64(masheryEncodedString);
					String str = new String( value); 
					JSONObject obj =(JSONObject)JSONValue.parse(str); 
					if ( obj.get(msgCatelog.get(Constants.MASHERY_ACCESS_TOKEN_ID)) != null)
					//if ( obj.get("access_token_uid") != null)
					{
						ccoId = (String)obj.get("access_token_uid");
						logger.debug("CCO Id from mashery header is " + ccoId);
					}
				}
				
			}				
			
			}
			if (ccoId.equalsIgnoreCase(Constants.NONE))
			{
				logger.error("CCO ID not Retreived");
				throw new ServiceInvocationException(Constants.CCOID_NOT_FOUND,"CCO ID not received ");
			}
				
			logger.debug("Returning CCOID " + ccoId );
			return ccoId;
		}
		
		
		public static StatusResponse appendErrorMessage(StatusResponse res,String errMsgToAppend, String errCode, boolean setStatusFail)
	    {
		    if( res == null )
		    {
		        res = new StatusResponse();
		    }
		    
	            String errMsg = res.getResponseErrorMessage()!=null ? res.getResponseErrorMessage():null;
	            if( setStatusFail)
	            {
	                res.setResponseStatus(Constants.FAIL);
	                res.setResponseErrorCode(errCode);
	            }
	            if ( errMsg != null && errMsg.contains(errMsgToAppend))
	            {
	                logger.debug("Already exists no need to append");
	                return res;
	            }
	            StringBuffer sb = new StringBuffer();
	            if( errMsg!=null)
                {
	                sb.append(errMsg).append(Constants.ERROR_MSGS_DELIMITER);
                }
	            sb.append(errMsgToAppend);
	            res.setResponseErrorMessage(sb.toString());   
	       
		    logger.debug("Returning response = "+res);
	        return res;
	        
	    }
		
		public static String getStackTraceAsString(Throwable exception)
	    {
	        String result = null;
	        if (exception != null)
	        {
	            StringWriter sw = new StringWriter();
	            PrintWriter pw = new PrintWriter(sw);
	            exception.printStackTrace(pw);
	            result = sw.toString();
	        }
	        logger.debug("StackTrace="+result);
	        return result;
	    }
		
	    public static String getTrimmedStackTrace(Throwable exception)
	    {
	        String exceptionTrace = getStackTraceAsString(exception);
	        int maxSize = (exceptionTrace != null && !exceptionTrace.isEmpty()) ? Math.min(1024,
	                                                                                       exceptionTrace.length())
	                                                                           : -1;
	        return maxSize == -1 ? null:exceptionTrace.substring(0, maxSize);
	    }
	
    public static Object setJSONValue2JavaObject(JSONObject sJo,
                                                 String key,
                                                 Object trgtObj,
                                                 String attrName)
    {
        Object obj = null;

        if (sJo == null || key == null)
        {
            logger.error("No sufficient informaiton for JSONObject.");
            return null;
        }
        if (trgtObj == null || attrName == null)
        {
            logger.error("No sufficient informaiton for destination object.");
            return null;
        }

        Object valueO = null;
        Object valOCasted = null;
        valueO = sJo.get(key);
        if( valueO == null )
        {
        	logger.error("Value Object is null");
        	return null;
        }
        Class valueC = valueO.getClass();
        if( valueC == null )
        {
        	logger.error("Value Class is null");
        	return null;
        }
        valOCasted = valueC.cast(valueO);
        // logger.debug(src.getAttrName()+"==>valOCasted="+valOCasted);
        try
        {
            BeanUtils.setProperty(trgtObj, attrName, valOCasted);
        }
        catch (Exception e)
        {
            logger.error("Exception occured while setting bean property for " + key);
            logger.error(getStackTraceAsString(e));
        }
        return obj;
    }
    
    public static JSONArray getJSONArrayValue(JSONObject jO,String key)
    {
        logger.debug("Received Key is :"+key);
        if( jO == null )
        {
            logger.error("passed JSONObject is null.");
            return null;
        }
        JSONArray jA = null;
        try
        {
            Object value = jO.get(key);
            if( value instanceof JSONArray )
            {
                jA = (JSONArray)value;
            }            
        }
        catch(Throwable th)
        {
            logger.error("Exception occured while getting the value from JSONObject:"+key);
            logger.error("Trace:"+getStackTraceAsString(th));
            return jA;
        }
        return jA; 
    }
    public static JSONObject getJSONObject(JSONObject jO,String key)
    {
        logger.debug("Received Key is :"+key);
        if( jO == null )
        {
            logger.error("passed JSONObject is null.");
            return null;
        }
        JSONObject jOVal = null;
        try
        {
            Object value = jO.get(key);
            if( value instanceof JSONObject )
            {
                jOVal = (JSONObject)value;
            }            
        }
        catch(Throwable th)
        {
            logger.error("Exception occured while getting the value from JSONObject:"+key);
            logger.error("Trace:"+getStackTraceAsString(th));
            return jOVal;
        }
        return jOVal;
    }
    
    public static String getStringValue(JSONObject jO,String key)
    {
        logger.debug("Received Key is :"+key);
        if( jO == null )
        {
            logger.error("passed JSONObject is null.");
            return null;
        }
        String strValue = null;
        try
        {
            Object value = jO.get(key);
            if( value instanceof String )
            {
                strValue = (String)value;
            }            
        }
        catch(Throwable th)
        {
            logger.error("Exception occured while getting the value from JSONObject:"+key);
            logger.error("Trace:"+getStackTraceAsString(th));
            return strValue;
        }
        
        return strValue;
    }
    
    public static Long getLongValue(JSONObject jO,String key)
    {
        logger.debug("Received Key is :"+key);
        if( jO == null )
        {
            logger.error("passed JSONObject is null.");
            return null;
        }
        Long longValue = null;
        try
        {
            Object value = jO.get(key);
            if( value instanceof Long )
            {
                longValue = (Long)value;
            }            
        }
        catch(Throwable th)
        {
            logger.error("Exception occured while getting the value from JSONObject:"+key);
            logger.error("Trace:"+getStackTraceAsString(th));
            return longValue;
        }
        return longValue;
    }
    
    public static BigDecimal getBigDecimalValue(JSONObject jO,String key)
    {
        logger.debug("Received Key is :"+key);
        if( jO == null )
        {
            logger.error("passed JSONObject is null.");
            return null;
        }
        BigDecimal bigDValue = null;
        try
        {
            Object value = jO.get(key);
            if( value instanceof BigDecimal )
            {
                bigDValue = (BigDecimal)value;
            } 
            else
            {
                logger.error("value instance is:"+value.getClass());
            }
            
        }
        catch(Throwable th)
        {
            logger.error("Exception occured while getting the value from JSONObject:"+key);
            logger.error("Trace:"+getStackTraceAsString(th));
            return bigDValue;
        }
        return bigDValue;
    }

    public static Double getDoubleValue(JSONObject jO, String key)
    {
        logger.debug("Received Key is :" + key);
        if( jO == null )
        {
            logger.error("passed JSONObject is null.");
            return null;
        }
        Double doubleValue = null;

        Object value = jO.get(key);
        if (value instanceof Double)
        {
            doubleValue = (Double) value;
        }
        else
        {
            logger.error("value instance is:" + value.getClass());
        }

        return doubleValue;
    }
    
    public static JSONObject getJSONObject(JSONArray array, String key)
    {
        logger.debug("Received Key is :"+key);
        if( array == null )
        {
            logger.error("passed JSONArray is null.");
            return null;
        }
        JSONObject jO = null;
        try
        {
            for(Object obj: array.toArray())
            {
                if( obj instanceof JSONObject)
                {
                    JSONObject o =(JSONObject)obj;
                    Object value = o.get(key);
                    if( value instanceof JSONObject )
                    {
                        jO = (JSONObject)value;
                    }  
                }
            }
                      
        }
        catch(Throwable th)
        {
            logger.error("Exception occured while getting the value from JSONObject:"+key);
            logger.error("Trace:"+getStackTraceAsString(th));
            return jO;
        }
        return jO;
    }


    public static String getCatelogMsg(String key, Map<String, String> catelog)
    {
        logger.info("Catelog message for key=" + key);
        if (key == null)
        {
            return "Key is null";
        }

        if (catelog.containsKey(key))
        {
            return catelog.get(key);
        }
        else
        {
            logger.error(key+" not found in the catelog.");
            return GEO_CODE_STC_UNKNOWN;
        }

    }
    
    public static String getStringAfterSubstitutions(String uri,Map<String,String> uriSubstitutions)
    {
        StringBuffer finalURI = new StringBuffer(uri);    
        logger.info("uri="+uri);
        if( uri != null && uriSubstitutions != null & !uriSubstitutions.isEmpty() )
        {
            for (String key : uriSubstitutions.keySet())
            {
                logger.debug("KEY="+key+";VALUE="+uriSubstitutions.get(key));
                String toReplace = "\\"+P+key+"\\"+S;
                String intURI = finalURI.toString();
                finalURI.delete(0, finalURI.length());
                String value = uriSubstitutions.get(key)!=null ? uriSubstitutions.get(key) : NO_VALUE;
                finalURI.append(intURI.replaceAll(toReplace,value));
            }
        }
        logger.info("finalURI="+finalURI.toString());
        return finalURI.toString();
    }
        
    /*
     * For each Attribute get the attr from Object and check for not null and not Empty for string values
     */
    public static boolean isValid(Object obj, List<String> attrs)
    {
        if (attrs == null || obj == null)
            return false;
        try
        {

            for (String attr : attrs)
            {
                Object value = PropertyUtils.getProperty(obj, attr);
                if( value == null || ( value instanceof String && ((String)value).isEmpty()) )
                {
                    return false;
                }
            }
        }
        catch (Exception e)
        {
            logger.error("Exception occured while checking the validity "
                         + getStackTraceAsString(e));
            return false;
        }
        return true;
    }
    
    /**
     * For each attribute 
     *  get Property value from obj1 and obj2 and compare.  
     *      IF both r same return true
     *      ELSE return false  
     * @param obj1
     * @param obj2
     * @param attrs
     * @return
     */
    public static boolean rObjectsSame4Attrs(Object obj1,Object obj2, List<String> attrs)
    {
        if (attrs == null || obj1 == null || obj2 == null)
            return false;
        
        boolean rObjectsSame4Attrs = true;
        try
        {

            for (String attr : attrs)
            {
                
                Object value1 = getProperty(obj1,attr);
                logger.debug("value1="+value1);
                Object value2 = getProperty(obj2,attr);
                logger.debug("value2="+value2);                
                
                if( value1 == null && value2 == null )
                {
                    rObjectsSame4Attrs = true;
                }
                else if( (value1 == null && value2 != null) || (value2 == null && value1 != null) )
                {
                    rObjectsSame4Attrs = false;
                }
                else
                {
                    rObjectsSame4Attrs=rBothEqual(value1,value2);
                }
                
                if( rObjectsSame4Attrs == false )
                {
                   return false; 
                }
                
            }
        }
        catch (Exception e)
        {
            logger.error("Exception occured while checking the validity "
                         + getStackTraceAsString(e));
            return false;
        }
        return rObjectsSame4Attrs;
    }
    
    public static boolean copyAttrs(Object src,Object trgt,List<String> attrs)
    {
        boolean rAllPropsCopied = true;
        if (attrs == null || src == null || trgt == null)
            return false;
        try
        {

            for (String attr : attrs)
            {                
                if( !copyProperty(src, trgt, attr) )
                {
                    rAllPropsCopied = false;
                }
                
            }
        }
        catch (Exception e)
        {
            logger.error("Exception occured while checking the validity "
                         + getStackTraceAsString(e));
            rAllPropsCopied = false;
        }
        return rAllPropsCopied;
    }
    public static boolean rBothEqual(Object value1,Object value2)
    {
        if( value1 instanceof String && value2 instanceof String)
        {
            return !AreStringsDifferent((String)value1,(String)value2);
        }
        else
        {
            
            return false;
        }
    }
    public static Object getProperty(Object obj,String prop)
    {
        if( obj == null )
        {
            logger.error("Object is null.");
            return null;
        }
        Object value = null;
        StringBuffer sb = new StringBuffer();
        sb.append("Dealing with ").append(obj.getClass()).append(" for property:").append(prop);
        try
        {                
            value = PropertyUtils.getProperty(obj, prop);
        }
        catch(IllegalAccessException iae)
        {
            logger.error("Illegal access Exception while "+sb.toString());
        }
        catch(InvocationTargetException ite)
        {
            logger.error("InvocationTargetException while "+sb.toString());
        }
        catch(NoSuchMethodException nsme)
        {
            logger.error("NoSuchMethodException while "+sb.toString());
        }
        
        return value;
    }
    
    public static boolean copyProperty(Object src,Object trgt,String prop)
    {
        boolean isCopied = false;
        if( src == null )
        {
            logger.error("Source Object is null.");
            return isCopied;
        }
        else if( trgt == null )
        {
            logger.error("Target Object is null.");
            return isCopied;
        }
        
        Object value = null;
        StringBuffer sb = new StringBuffer();
        sb.append("Dealing with Source Object:").append(src.getClass());
        sb.append(" and Target Object:").append(trgt.getClass()).append(" for property:").append(prop);
        logger.debug(sb.toString());
        try
        {                
            value = PropertyUtils.getProperty(src, prop);
            PropertyUtils.setProperty(trgt, prop, value);
            isCopied = true;
        }
        catch(IllegalAccessException iae)
        {
            logger.error("Illegal access Exception while "+sb.toString());
        }
        catch(InvocationTargetException ite)
        {
            logger.error("InvocationTargetException while "+sb.toString());
        }
        catch(NoSuchMethodException nsme)
        {
            logger.error("NoSuchMethodException while "+sb.toString());
        }
        
        return isCopied;
    }
    
    /*
     * check if cached has expired.
     * Check if the cached has expired. Cached time configured is in hours.
     */
/*    public boolean hasCahedExpired(SerialNumberLocation serialNumberLocation)
    {
    	// from current date, subtract the time configured.
    	boolean isExpired = false;
    	
    	Date expired = new Date(new Date().getTime() - (long)cacheExpiry*3600000);
    	// check if updated date is >= expired date
    	// if updated data is > then expired data then take new location.
    	if (expired.after(serialNumberLocation.getUpdated()))
    	{
    		logger.debug("Cached has expired");
    		isExpired = true;
    	}
    	return isExpired;
    	
    }*/
    
    /*
     * Create geoCoding object and get Lat/Lng using google service
     */
    
   
    public JSONObject toJSONObj(String jsonString)
    {
        logger.debug("Received JSON String=" + jsonString);
        if( jsonString == null )
        {
            return null;
        }
        JSONParser jp = new JSONParser();
        Object obj = null;
        try
        {
            obj = jp.parse(jsonString);

        }
        catch (ParseException pe)
        {
            logger.error("Exception while parsing json Request", pe);
        }

        if (obj != null && obj instanceof JSONObject)
        {
            return (JSONObject) obj;
        }
        else
        {
            logger.error("JSON Object instance type is :" + obj.getClass());
            return null;
        }

    }
    
    public void setSRChangePrevValue(String attr,Map<String,String> srChangeDetailMap,String prev)
    {
        srChangeDetailMap.put(getPrevKeyForSRChangePropertyMap(attr),prev);
    }
    
    public void setSRChangeCurValue(String attr,Map<String,String> srChangeDetailMap,String cur)
    {
        srChangeDetailMap.put(getCurKeyForSRChangePropertyMap(attr),cur);
    }
    
    public static boolean AreStringsDifferent(String p,String c)
    {
        if( p != null && !p.equals(c))
        {
            return true;
        }else if( c != null && !c.equals(p))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /*
     * Given an attribute name it prepends the prefix key and returns.
     */
    public String getPrevKeyForSRChangePropertyMap(String attribute)
    {
        return PREV_VALUE_PREFIX+attribute;
    }
    
    /*
     * Given an attribute name it prepends the current key and returns.
     */
    public String getCurKeyForSRChangePropertyMap(String attribute)
    {
        return CUR_VALUE_PREFIX+attribute;
    }
    
    public String stripOffPreCurKey(String key)
    {
        if( key!=null )
        {
            String strippedValue = key.replaceFirst(CUR_VALUE_PREFIX, "");
            return strippedValue == null ? key.replaceFirst(PREV_VALUE_PREFIX, ""):strippedValue;
        }
        return key;
    }
    
    public String getLineSeperator()
    {
        return System.getProperty("line.separator");
    }
    
	/**
	 * @return the defaultCCOId
	 */
	public String getDefaultCCOId() {
		return defaultCCOId;
	}

	/**
	 * @param defaultCCOId the defaultCCOId to set
	 */
	public void setDefaultCCOId(String defaultCCOId) {
		this.defaultCCOId = defaultCCOId;
	}

	/**
	 * @return the msgCatelog
	 */
	public HashMap<String, String> getMsgCatelog() {
		return msgCatelog;
	}

	/**
	 * @param msgCatelog the msgCatelog to set
	 */
	public void setMsgCatelog(HashMap<String, String> msgCatelog) {
		this.msgCatelog = msgCatelog;
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

	
    
    
}

