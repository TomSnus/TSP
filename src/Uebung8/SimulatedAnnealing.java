package Uebung8;

import java.util.ArrayList;
import java.util.Collections;

import org.jfree.data.category.DefaultCategoryDataset;

public class SimulatedAnnealing {
	private LinearCongruenceGenerator random = new LinearCongruenceGenerator((long) Math.pow(2,32), 1664525, 1013904223, 0);
	private Logging logging;
	private TourTools tools;
	private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	private long counter = -5;
	private long distanceCounter = -5;
	
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}

	public SimulatedAnnealing(Logging logging){
		this.logging = logging;
		tools = new TourTools(logging);
	}

	public ArrayList<Coordinate> simulate(ArrayList<Coordinate> startTour, double temperatureStart, int maxSteps,
			int localMovesPerTemperature){
		double temperature = temperatureStart;
		ArrayList<Coordinate> tourOpt = new ArrayList<>(startTour);
		ArrayList<Coordinate> tourToModify = new ArrayList<>(startTour);
		for (int i=0; i< maxSteps; i++){
			for (int j=0; j< localMovesPerTemperature; j++){
				logging.logFirst();
				tools.printTour("Alte Tour: ", tourToModify);
				int first = random.nextInt(startTour.size());
				int second = random.nextInt(startTour.size());
				logging.log("Exchange: " + first +" <-> " + second);
				exchange(tourToModify, first, second);
				tools.printTour("Neue Tour: ", tourToModify);
				double tourDiff = tools.getTourDifference(tourOpt, tourToModify);
				logging.log("Unterschied der Tourlängen: " + tourDiff);
				dataset.addValue(distanceCounter+5, "Tour", String.valueOf(counter++));
				if(tourDiff>=0){
					tourOpt = new ArrayList<>(tourToModify);
				}
				else{
					if(isWorseSolutionAccepted(tourDiff, temperature)){
						logging.log("Schlechtere Lösung akzeptiert");
						tourOpt = new ArrayList<>(tourToModify);
					}
				}
				logging.log("-------------------------------------------------------------");
			}
			temperature = temperature * random.nextDouble();
		}
		return tourOpt;
	}

	private boolean isWorseSolutionAccepted(double tourDiff, double temperature){
		if(Math.exp(-tourDiff/temperature)> random.nextDouble()){
			return true;
		}
		else{
			return false;
		}
	}

	private ArrayList<Coordinate> exchange(ArrayList<Coordinate> tour, int first, int second){
		Collections.swap(tour, first, second);
		return tour;
	}
}
