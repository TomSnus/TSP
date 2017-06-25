package Uebung8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TourTools {
	private Logging logging;

	public TourTools(Logging logging){
		this.logging = logging;
	}

	public double calculateLengthOfTour(ArrayList<Coordinate> tour){
		double euclideanDistance = 0;
		try{
			for (int i=0; i< tour.size()-1; i++){
				euclideanDistance += calculateEuclideanDistance(tour.get(i), tour.get(i+1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return -1;
		}
		return euclideanDistance;
	}

	public ArrayList<Coordinate> generateStartTour(TSPModel model){
		List<Coordinate> coordinates = new ArrayList<>(model.getCoordinates());
		Collections.shuffle(coordinates);
		return (ArrayList<Coordinate>) coordinates;
	}

	public ArrayList<Coordinate> generateStartTourSuccessive(TSPModel model){
		return new ArrayList<>(model.getCoordinates());
	}

	public double[][] generateStartMatrix(TSPModel model){
		try{
			double[][] matrix = new double [model.getDimension()][model.getDimension()];
			for (int i=0; i<model.getDimension(); i++){
				for (int j=0; j<model.getDimension(); j++){
					if(i==j){
						matrix[i][j]=0;
					}
					else{
						matrix[i][j]=calculateEuclideanDistance(model.getCoordinates().get(i),
								model.getCoordinates().get(j));
					}
				}
			}
			return matrix;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public double getTourDifference(ArrayList<Coordinate> tour1, ArrayList<Coordinate> tour2){
		return calculateLengthOfTour(tour1)-calculateLengthOfTour(tour2);
	}

	public void printTour(String tourName, ArrayList<Coordinate> tour){
		logging.log(tourName + tour.stream().map(Coordinate::getIndexAsString)
				.collect(Collectors.joining(", ")));
	}

	private double calculateEuclideanDistance(Coordinate cord1, Coordinate cord2 ){
		return Math.sqrt(Math.pow(cord1.getX() - cord2.getX(), 2) +
				Math.pow(cord1.getY() - cord2.getY(), 2));
	}
}
