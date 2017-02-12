/**
 * Custom exception class for Portfolio
 */
package main.java.com.personalcapital.montecarlosimulation.exception;

/**
 * @author penugni
 *
 */
public class PortfolioException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PortfolioException(final String message) {
		super(message);
	}
	
	public PortfolioException(String message, Throwable cause) {
		super(message, cause);
	}
}
