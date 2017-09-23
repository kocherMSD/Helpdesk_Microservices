package org.helpdesk.commons.exception;

public class SystemException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException() {
		super();
	}

	public SystemException(String message)
	{
		super(message);
	}
	
	public SystemException(String errorCode, String message)
	{
		super(errorCode, message);
	}
	
	
	
}
