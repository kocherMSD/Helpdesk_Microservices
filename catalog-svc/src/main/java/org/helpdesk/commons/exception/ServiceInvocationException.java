package org.helpdesk.commons.exception;

public class ServiceInvocationException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceInvocationException()
	{
		super();
	}
	
	public ServiceInvocationException(String message)
	{
		super(message);
	}
	
	public ServiceInvocationException(String errorCode,String message)
	{
		super(errorCode, message);
	}
}
