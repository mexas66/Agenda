package fr.greta.java.generic.exception;

public class ServiceException extends Throwable {

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException() {
	}
}