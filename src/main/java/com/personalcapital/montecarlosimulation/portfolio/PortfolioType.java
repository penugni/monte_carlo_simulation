package main.java.com.personalcapital.montecarlosimulation.portfolio;

import main.java.com.personalcapital.montecarlosimulation.util.PorfolioConstants;

/**
 * @author penugni
 *
 */
public enum PortfolioType {
	AGRESSIVE, VERY_CONSERVATIVE;
		
	//Get mean rate from portfolio type, Default is conservative mean rate
	public static double getMeanFromPortfolioType(PortfolioType type) {
		if(type == PortfolioType.AGRESSIVE) return PorfolioConstants.AGGRESSIVE_MEAN_RATE;
		else return PorfolioConstants.CONSERVATIVE_MEAN_RATE;
	}
	//Get standard deviation from portfolio type ,Default is conservative standard deviation rate
	public static double getStandardDeviationFromPortfolioType(PortfolioType type) {
		if(type == PortfolioType.AGRESSIVE) return PorfolioConstants.AGGRESSIVE_STANDARD_DEVIATION_RATE;
		else return PorfolioConstants.CONSERVATIVE_STANDARD_DEVIATION_RATE;
	}
	
}
