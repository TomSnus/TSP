package Uebung8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ImportTSPFile {

	public ImportTSPFile (){

	}

	public TSPModel importFile(String filename){
		try (BufferedReader br = new BufferedReader(new FileReader(filename)))
		{
			TSPModel model = new TSPModel();
			List<Coordinate> coordinates = new ArrayList<>();
			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				if(currentLine.contains("EOF")){
					model.setCoordinates(coordinates);
					return model;
				}
				else if(currentLine.toUpperCase().contains("NAME")){
					model.setName(currentLine.split(": ")[1]);
				}
				else if(currentLine.toUpperCase().contains("COMMENT")){
					model.setComment(currentLine.split(": ")[1]);
				}
				else if(currentLine.toUpperCase().contains("TYPE")){
					if(currentLine.toUpperCase().contains("EDGE_WEIGHT_TYPE")){
						model.setEdgeWeightType(currentLine.split(": ")[1]);
					}
					else{
						model.setType(currentLine.split(": ")[1]);
					}
				}
				else if(currentLine.toUpperCase().contains("DIMENSION")){
					model.setDimension(Integer.parseInt(currentLine.split(": ")[1]));
				}
				else if(currentLine.toUpperCase().contains("NODE_COORD_SECTION")){
					continue;
				}
				else{
					coordinates.add(getCoordinateFromLine(currentLine));
				}

			}
			return model;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private Coordinate getCoordinateFromLine(String line){
		try{
			String[] result = line.split(" ");
			int counter = 0;
			double x=0;
			double y=0;
			int position = 0;
			for(String s:result){
				if(!s.equals("")){
					if(counter == 0){
						position = Integer.parseInt(s);
						counter++;
					}
					else if(counter == 1){
						x = Double.parseDouble(s);
						counter++;
					}
					else{
						y = Double.parseDouble(s);
						counter++;
						return new Coordinate(x, y, position);
					}
				}
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
}

