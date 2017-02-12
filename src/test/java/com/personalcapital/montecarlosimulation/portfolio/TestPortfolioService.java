/**
 * 
 **/
package test.java.com.personalcapital.montecarlosimulation.portfolio;

import static org.junit.Assert.*;
import main.java.com.personalcapital.montecarlosimulation.lookup.PortfolioService;
import main.java.com.personalcapital.montecarlosimulation.portfolio.Portfolio;
import main.java.com.personalcapital.montecarlosimulation.portfolio.PortfolioType;

import org.apache.commons.math.MathException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author penugni
 *
 */
public class TestPortfolioService {
	
	private static Portfolio aggressivePortfolio;
	private static Portfolio conservativePortfolio;
	//Test variables for aggressive portfolio, Below are approximate ranges which can fluctuate
	private double aggressiveMedian = 239000.00;
	private double aggressiveTop10 = 545000.00;
	private double aggressiveBottom10 = 101000.00;
	//Test variables for conservative portfolio
	private double conservativeMedian = 155000.00;
	private double conservativeTop10 = 218000.00;
	private double conservativeBottom10 = 109000.00;
	
	@BeforeClass
	public static void setUp() throws MathException, Exception {
		aggressivePortfolio = new PortfolioService(PortfolioType.AGRESSIVE).getPortfolioAfterSimulation();
		conservativePortfolio = new PortfolioService(PortfolioType.VERY_CONSERVATIVE).getPortfolioAfterSimulation();
		
	}
	
	@Test
	public void testAggressivePortfolio() {
		assertTrue(aggressivePortfolio.getSimulationMedian() > aggressiveMedian);
	    assertTrue(aggressivePortfolio.getSimulationTop10() > aggressiveTop10);
	    assertTrue(aggressivePortfolio.getSimulationBottom10() > aggressiveBottom10);
	}
	
	@Test
	public void testConservativePortfolio() {
		assertTrue(conservativePortfolio.getSimulationMedian() > conservativeMedian);
	    assertTrue(conservativePortfolio.getSimulationTop10() > conservativeTop10);
	    assertTrue(conservativePortfolio.getSimulationBottom10() > conservativeBottom10);
	}
	
	@AfterClass
	public static void tearDown() {
		//Test to see all the values of the portfolio
		System.out.println("Portfolio Details");
		System.out.println(aggressivePortfolio.toString());
		System.out.println(conservativePortfolio.toString());
		aggressivePortfolio = null;
		conservativePortfolio = null;
	}
	
}
