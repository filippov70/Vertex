/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.freegis.mif;

import java.text.DecimalFormat;

/**
 * 
 * @author Филиппов Владислав 2012
 */

public class Point {
	
	private double x;
	private double y;
	
	public Point() {
		x = 5.5;
		y = 4.4;
	}
	
	public Point(double X, double Y) {
		this.x = X;
		this.y = Y;
	}
	
	public Point(String AcadStr) {
		String tempString = AcadStr.substring(AcadStr.indexOf("=")+1, 
				AcadStr.lastIndexOf("=")-1).trim();
        String x = tempString.substring(0, tempString.indexOf(" ")).trim();
        String y = tempString.substring(tempString.indexOf("=")+1).trim();
        this.x = Double.valueOf(x);
        this.y = Double.valueOf(y);
	}
	
	public Point(String AsconStr, boolean Change) {
		String tempString = AsconStr.substring(AsconStr.indexOf("= ")+2, 
				AsconStr.lastIndexOf(" мм")).trim();
        String x = tempString.substring(0, tempString.indexOf(" ")).trim();
        String y = tempString.substring(tempString.indexOf("=")+1).trim();
        this.x = Double.valueOf(x);
        this.y = Double.valueOf(y);
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		if (x > 0) {
			this.x = x;
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		if (y > 0) {
			this.y = y;
		}
	}
	
	public double lengthTo(Point pt) {
		double length;
		double deltaX = pt.getX() - this.getX();
		double deltaY = pt.getY() - this.getY();
		length = Math.sqrt((Math.pow(deltaX, 2) + (Math.pow(deltaY, 2))));
		return length;
		
//		return Math.sqrt(Math.pow((pt.getX() - this.getX()), 2) + 
//						 Math.pow((pt.getY() - this.getY()), 2));
	}
	
	public String lengthToString(Point pt, DecimalFormat format) {
		return  format.format(lengthTo(pt)); //String.valueOf(lengthTo(pt));
	}
	
	public String getXString(DecimalFormat format) {
		return format.format(this.x).replace(",", ".");
	}
	
	public String getYString(DecimalFormat format) {
		return format.format(this.y).replace(",", ".");
	}
}
