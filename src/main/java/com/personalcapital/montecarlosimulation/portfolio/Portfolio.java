package main.java.com.personalcapital.montecarlosimulation.portfolio;

import main.java.com.personalcapital.montecarlosimulation.simulator.Simulator;
/**
 * @author penugni
 *
 */
public class Portfolio {
	
	private PortfolioType type;
	private Simulator simulator;
	private double mean;
	private double standardDeviation;
	private double simulationMedian;
	private double simulationTop10;
	private double simulationBottom10;
		
	public Portfolio(PortfolioType type) {
		this.type = type;
		this.mean = PortfolioType.getMeanFromPortfolioType(type);
		this.standardDeviation = PortfolioType.getStandardDeviationFromPortfolioType(type);
		this.simulator = new Simulator(this.mean, this.standardDeviation);
	}

	public double getSimulationMedian() {
		return simulationMedian;
	}

	public void setSimulationMedian(double simulationMedian) {
		this.simulationMedian = simulationMedian;
	}

	public double getSimulationTop10() {
		return simulationTop10;
	}

	public void setSimulationTop10(double simulationTop10) {
		this.simulationTop10 = simulationTop10;
	}

	public double getSimulationBottom10() {
		return simulationBottom10;
	}

	public void setSimulationBottom10(double simulationBottom10) {
		this.simulationBottom10 = simulationBottom10;
	}

	public void setType(PortfolioType type) {
		this.type = type;
	}

	public PortfolioType getType() {
		return type;
	}

	public void setMean(double mean) {
		this.mean = mean;
	}

	public double getMean() {
		return mean;
	}

	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}
	
	public void setSimulator(Simulator simulator) {
		this.simulator = simulator;
	}

	public Simulator getSimulator() {
		return simulator;
	}
	/**
	 * Save simulation results for median, top10 and bottom10
	 * @param simulator
	 */
	public void setSimulationResults(Simulator simulator) {
		this.setSimulationMedian(simulator.getPercentile(50));
		this.setSimulationTop10(simulator.getPercentile(90));
		this.setSimulationBottom10(simulator.getPercentile(10));
	}
	
	@Override
	public String toString() {
		return "Portfolio Type=" + type
				+ ", Median=" + String.format("%.2f", simulationMedian)
				+ ", Top 10=" + String.format("%.2f", simulationTop10)
				+ ", Bottom 10=" + String.format("%.2f", simulationBottom10);
	}

}
