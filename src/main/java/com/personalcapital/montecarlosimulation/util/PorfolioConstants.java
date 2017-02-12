/**
 * Used to set some default values related to portfolio
 */
package main.java.com.personalcapital.montecarlosimulation.util;

/**
 * @author penugni
 *
 */
public class PorfolioConstants {
	
	//common portfolio constants
	public static final double INFLATION_RATE = 0.035;
	public static final int INVESTMENT_PERIOD_YRS = 20;
	public static final long SIMULATIONS = 10000;
	public static final double INITIAL_INVESTMENT_AMOUNT = 100000;
	
	//Agressive portfolio mean and standard deviation
	public static final double AGGRESSIVE_MEAN_RATE = 0.094324;
	public static final double AGGRESSIVE_STANDARD_DEVIATION_RATE = 0.15675;
	
	//Conservative portfolio mean and standard deviation
	public static final double CONSERVATIVE_MEAN_RATE = 0.06189;
	public static final double CONSERVATIVE_STANDARD_DEVIATION_RATE = 0.063438;
	
}
