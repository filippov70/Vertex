package ru.freegis.mif;

/**
 * 
 * @author Филиппов Владислав 2012
 *
 */
public class Pline {
	private Point firstPoint;
	private Point secondPoint;
	
	public Pline(Point FirstPoint, Point SecondPoint) {
		this.firstPoint = FirstPoint;
		this.secondPoint = SecondPoint;
	}

	public Point getFirstPoint() {
		return firstPoint;
	}

	public void setFirstPoint(Point firstPoint) {
		this.firstPoint = firstPoint;
	}

	public Point getSecondPoint() {
		return secondPoint;
	}

	public void setSecondPoint(Point secondPoint) {
		this.secondPoint = secondPoint;
	}
	
}
