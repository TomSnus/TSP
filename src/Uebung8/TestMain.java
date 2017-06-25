package Uebung8;

import java.util.ArrayList;
import org.jfree.ui.RefineryUtilities;

public class TestMain {

	public static void main(String[] args) {
		//Logging logging = new Logging("C:\\Users\\hat31871\\Workspace\\Uebung8\\src\\Uebung8\\log.log");
		Logging logging = new Logging("Uebung8/log.log");
		TourTools tools = new TourTools(logging);
		TSPModel model = new ImportTSPFile().importFile("bier127.tsp");
		//TSPModel model = new ImportTSPFile().importFile("C:\\Users\\hat31871\\Workspace\\Uebung8\\src\\Uebung8\\bier127.tsp");
		double[][] distanceMatrix = tools.generateStartMatrix(model);
		ArrayList<Coordinate> startTour = tools.generateStartTour(model);
		double tourLength = tools.calculateLengthOfTour(startTour);
		logging.clearLog();
		SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(logging);
		ArrayList<Coordinate> tourOpt = simulatedAnnealing
				.simulate(startTour, 0, 5, 1000);
		logging.logFirst();
		logging.log("Länge der Starttour: " + tourLength);
		logging.log("Gesamttourunterschied: " + tools.getTourDifference(startTour, tourOpt));
		logging.log("Länge der optimierten Tour: " + tools.calculateLengthOfTour(tourOpt));
		logging.log("-------------------------------------------------------------");
		System.out.println("Finished");
		showGraph(simulatedAnnealing);
	}

	public static void showGraph(SimulatedAnnealing simulatedAnnealing){
		LineChart lineChart= new LineChart("Tourlängenauswertung", "Tourlängen vs. Zeit",
				"Zeit", "Tourlängen", simulatedAnnealing.getDataset());
		lineChart.pack();
	    RefineryUtilities.centerFrameOnScreen(lineChart);
	    lineChart.setVisible(true);
	}
}
