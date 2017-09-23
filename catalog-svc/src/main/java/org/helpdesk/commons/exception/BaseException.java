package org.helpdesk.commons.exception;

public abstract class BaseException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BaseException()
	{
		super();
	}
	
	BaseException(String message)
	{
		super(message);
	}


	protected String errorCode;
	protected String errorMessage;
	
	/**
	 * @param errorCode
	 * @param errorMessage
	 */
	public BaseException(String errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		
	}
	

	/**
	 * 
	 * @param errorCode
	 * @param errorMessage
	 * @param throwable
	 */
	public BaseException(String errorCode, String errorMessage,Throwable throwable) {
		super(errorMessage,throwable);
		this.errorCode = errorCode;
		
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

    /**
     * @return the errorMessage
     */
    public String getErrorMessage()
    {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

	
	
}
