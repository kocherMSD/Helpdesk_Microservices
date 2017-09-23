package org.helpdesk.services.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.helpdesk.commons.exception.ServiceInvocationException;
import org.helpdesk.db.dao.DataService;
import org.helpdesk.db.model.UsersEntity;
import org.helpdesk.helpers.HelpDeskTicketServiceHelper;
import org.helpdesk.services.HelpDeskTicketService;
import org.helpdesk.services.request.TicketRequest;
import org.helpdesk.services.response.RestResponse;
import org.helpdesk.services.response.TicketResponse;
import org.helpdesk.utils.Util;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
 

@Path("/TicketService")
public class HelpDeskTicketServiceImpl implements HelpDeskTicketService, ApplicationContextAware {
 
	private DataService updater;
	private HelpDeskTicketServiceHelper helper;
	private static Logger logger = Logger.getLogger(HelpDeskTicketServiceImpl.class);
	private Util util;
	private HashMap<String,String> msgCatelog;
	
	
	
	
	private ApplicationContext applicationContext;
	
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

	@Override
	@POST
	@Consumes({  MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/createTicket/")
	public TicketResponse createHdTicket(@Context HttpHeaders headers,TicketRequest ticketRequest) throws ServiceInvocationException{
		logger.debug("Create:- started");
		try{
		  return helper.createSr(ticketRequest);
		}catch(Exception e){
			logger.error("Exception occured: ", e);
			return failResponse( ticketRequest,new TicketResponse() ,"FS_REST_IO_EXCEPTION");
		}
	}
	
	
	@Override
	@GET
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/json"})
	@Path("/users/{param}")
	public RestResponse getUser(@Context HttpHeaders headers, @PathParam("param") String ccoid ){
		
		logger.debug("In getUser() ...  ccoid: " +  ccoid);
		
		UsersEntity usersEntity = (UsersEntity)updater.findByCriteria(DetachedCriteria.forEntityName("UsersEntity"));
		System.out.println(usersEntity.getFirstname());
		
		List<UsersEntity> ls = new ArrayList<UsersEntity>();
		ls.add(usersEntity);
		
		RestResponse resp= new RestResponse();
		resp.setUserList(ls);
		return resp;
	}
	

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * @return the updater
	 */
	public DataService getUpdater() {
		return updater;
	}

	/**
	 * @param updater the updater to set
	 */
	public void setUpdater(DataService updater) {
		this.updater = updater;
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


	
	private TicketResponse failResponse(TicketRequest ticketRequest,TicketResponse resp,String errorCode)
	{
		
		logger.debug("Request for the "+ticketRequest.getUserId()+ "was no successfull");
		resp= new TicketResponse();
		return resp;	
	}

	
	



	public HelpDeskTicketServiceHelper getHelper() {
		return helper;
	}

	public void setHelper(HelpDeskTicketServiceHelper helper) {
		this.helper = helper;
	}
	
	
}