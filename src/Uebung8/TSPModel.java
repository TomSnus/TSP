package Uebung8;

import java.util.List;

public class TSPModel {
	private String name;
	private String comment;
	private String type;
	private int dimension;
	private String edgeWeightType;
	private List<Coordinate> coordinates;

	public TSPModel(){

	}

	public TSPModel(String name, String comment, String type, int dimension,
			String edgeWeightType, List<Coordinate> coordinates) {
		super();
		this.name = name;
		this.comment = comment;
		this.type = type;
		this.dimension = dimension;
		this.edgeWeightType = edgeWeightType;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public List<Coordinate> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getEdgeWeightType() {
		return edgeWeightType;
	}

	public void setEdgeWeightType(String edgeWeightType) {
		this.edgeWeightType = edgeWeightType;
	}
}
