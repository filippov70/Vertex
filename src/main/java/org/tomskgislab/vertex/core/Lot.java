package org.tomskgislab.vertex.core;

import java.util.List;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class Lot {

	MultiPolygon geometry;
	List<Polygon> plist;

	public Lot(MultiPolygon Geometry) {
		this.geometry = Geometry;
	}

	public Lot(List<Polygon> Plist) {
		this.plist = Plist;
	}

	public List<Polygon> getPlist() {
		return plist;
	}

	public MultiPolygon getGeometry() {
		return geometry;
	}

}
