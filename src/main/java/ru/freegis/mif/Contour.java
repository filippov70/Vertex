package ru.freegis.mif;

import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Филиппов Владислав 2012
 *
 */
public class Contour {
	private List<Pline> plines;

	public Contour () {
		plines = new ArrayList<Pline>();
	}
	
	public Pline getContour(int Index) {
		if((this.plines != null) && (this.plines.size() > Index)) {
			return this.plines.get(Index);
		}
		else {
			return null;
		}
	}
	
	public List<Pline> getContours() {
		return this.plines;
	}
	
	public void addContour(Pline Polyline) {
		if (this.plines != null) {
			this.plines.add(Polyline);
		}
	}
	
	public void saveToMIF(BufferedWriter Writer) throws IOException {
		DecimalFormat format = new DecimalFormat("#.00");
		Writer.write("  " + (plines.size()+1) + "\r\n");
		for (int i = 0; i < plines.size(); i++) {
			if (i < plines.size()-1) {
				Writer.write(plines.get(i).getFirstPoint().getXString(format) +
					" " + plines.get(i).getFirstPoint().getYString(format) + "\r\n");
			}
			else {
				Writer.write(plines.get(i).getFirstPoint().getXString(format) +
						" " + plines.get(i).getFirstPoint().getYString(format) + "\r\n");
				Writer.write(plines.get(0).getFirstPoint().getXString(format) +
						" " + plines.get(0).getFirstPoint().getYString(format));
			}
		}
	}
	
	public void saveToMIFBorders(BufferedWriter Writer) throws IOException {

	}

}
