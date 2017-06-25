package Uebung8;

public class WrongParameterException extends Exception {
	private static final long serialVersionUID = 8078469605993671559L;
	public WrongParameterException() { super(); }
	  public WrongParameterException(String message) { super(message); }
	  public WrongParameterException(String message, Throwable cause) { super(message, cause); }
	  public WrongParameterException(Throwable cause) { super(cause); }
	}
