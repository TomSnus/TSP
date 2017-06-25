package Uebung8;

public class Coordinate {
	private double x;
	private double y;
	private int index;

	public Coordinate(double x, double y, int index) {
		super();
		this.x = x;
		this.y = y;
		this.index = index;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int position) {
		this.index = position;
	}
	
	public String getIndexAsString() {
		return String.valueOf(index);
	}
}
