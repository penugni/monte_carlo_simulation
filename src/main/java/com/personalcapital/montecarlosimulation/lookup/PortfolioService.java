package main.java.com.personalcapital.montecarlosimulation.lookup;

import org.apache.commons.math.MathException;

import main.java.com.personalcapital.montecarlosimulation.exception.PortfolioException;
import main.java.com.personalcapital.montecarlosimulation.portfolio.Portfolio;
import main.java.com.personalcapital.montecarlosimulation.portfolio.PortfolioType;
import main.java.com.personalcapital.montecarlosimulation.simulator.Simulator;
import main.java.com.personalcapital.montecarlosimulation.util.PorfolioConstants;

/**
 * @author penugni
 *
 */
public class PortfolioService {
	
	private Portfolio portfolio;
		
	public PortfolioService(PortfolioType type) {
		this.portfolio = new Portfolio(type);
	}
	/**
	 * Get portfolio with number of simulation, investment period years and initial investment amount
	 * @return Portfolio
	 * @throws MathException
	 * @throws Exception
	 */
	public Portfolio getPortfolioAfterSimulation() throws MathException,Exception {
		if(portfolio == null) throw new PortfolioException("Failed to create Portfolio");
		Simulator simulator = portfolio.getSimulator();
		if(simulator == null) throw new PortfolioException("Failed to create Simulator");
		try {
			for (int i = 0; i < PorfolioConstants.SIMULATIONS; i++) {
				double amount = PorfolioConstants.INITIAL_INVESTMENT_AMOUNT;
				for(int j = 0; j < PorfolioConstants.INVESTMENT_PERIOD_YRS;j++){
					double ret = simulator.nextSampleReturn();
					amount = amount * (1 + ret);
					amount = amount * (1 - PorfolioConstants.INFLATION_RATE);
				}
				simulator.saveSimulationResult(amount);
			}
			portfolio.setSimulationResults(simulator);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PortfolioException exception = new PortfolioException(e.getMessage(),e.getCause());
			throw exception;
		}
		return portfolio;
	}
}
