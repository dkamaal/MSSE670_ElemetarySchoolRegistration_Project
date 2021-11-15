package com.elementaryschool.model.business.exceptions;

@SuppressWarnings("serial")
public class ServiceLoadException extends Exception {

	public ServiceLoadException(final String svcMessage, final Throwable svcNestedException)
    {
        super(svcMessage, svcNestedException);
    }
	
}
