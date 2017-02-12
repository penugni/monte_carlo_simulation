package main.java.com.personalcapital.montecarlosimulation.simulator;

import org.apache.commons.math.MathException;
import org.apache.commons.math.distribution.NormalDistributionImpl;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
/**
 * @author penugni
 *
 */
public class Simulator {
	private NormalDistributionImpl normalDistributionImpl;
	private DescriptiveStatistics descStatistics;

	public Simulator(double mean, double standardDeviation) {
		this.normalDistributionImpl = new NormalDistributionImpl(mean, standardDeviation);
		this.descStatistics = new DescriptiveStatistics();
	}

	public void saveSimulationResult(double simResult) {
		this.descStatistics.addValue(simResult);
	}

	public double nextSampleReturn() throws MathException {			
		return this.normalDistributionImpl.sample();
	}
	
	public double getPercentile(double n){
		return this.descStatistics.getPercentile(n);
	}
}
