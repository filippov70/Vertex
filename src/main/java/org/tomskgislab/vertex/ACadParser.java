package org.tomskgislab.vertex;

import java.util.ArrayList;
import java.util.List;

import org.geotools.geometry.jts.JTSFactoryFinder;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateList;
import com.vividsolutions.jts.geom.CoordinateSequence;
import com.vividsolutions.jts.geom.CoordinateSequenceFactory;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.LinearRing;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

import com.vividsolutions.jts.geom.impl.CoordinateArraySequenceFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class ACadParser {
	private static GeometryFactory geometryFactory = JTSFactoryFinder
			.getGeometryFactory();
	private List<Polygon> lines = new ArrayList<Polygon>();
	private List<CoordinateList> coord = new ArrayList<CoordinateList>();
	private List<LinearRing> rings = new ArrayList<LinearRing>();
	private List<Polygon> polys = new ArrayList<Polygon>();
	private List<MultiPolygon> mpolys = new ArrayList<MultiPolygon>();
	String dataTextACad = "Команда: список\r\nнайдено: 3\r\n\r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 117\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   43243.6023\r\n         периметр   887.9497\r\n         \r\n          в точке  X= 475.3795  Y= 700.1687  Z=   0.0000\r\n          в точке  X= 605.7254  Y= 826.3234  Z=   0.0000\r\n          в точке  X= 848.0873  Y= 795.8021  Z=   0.0000\r\n          в точке  X= 772.7310  Y= 657.4388  Z=   0.0000\r\n          в точке  X= 595.5421  Y= 657.4388  Z=   0.0000\r\n          \r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 116\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   42039.7433\r\n         периметр   955.1252\r\n         \r\nНажмите ENTER для продолжения:\r\n          в точке  X= 683.1182  Y= 515.0060  Z=   0.0000\r\n          в точке  X= 815.5008  Y= 555.7011  Z=   0.0000\r\n          в точке  X= 951.9567  Y= 403.0945  Z=   0.0000\r\n          в точке  X= 846.0506  Y= 211.8276  Z=   0.0000\r\n          в точке  X= 752.3645  Y= 335.9476  Z=   0.0000\r\n          в точке  X= 791.0609  Y= 425.4768  Z=   0.0000\r\n          в точке  X= 683.1182  Y= 515.0060  Z=   0.0000\r\n          \r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 115\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   45129.1639\r\n         периметр   940.6836\r\n         \r\n          в точке  X= 235.0542  Y= 502.7975  Z=   0.0000\r\n          в точке  X= 571.1022  Y= 502.7975  Z=   0.0000\r\n          в точке  X= 571.1022  Y= 368.5037  Z=   0.0000\r\n          в точке  X= 235.0542  Y= 368.5037  Z=   0.0000";
	// строка из AutoCad
	String dataTextDraftSight = "GETPROPERTIES\r\n2 обнаружено, 3 всего\r\nLWPOLYLINE\r\nДескриптор: 7C\r\nРежим: Модель\r\nLayer: 0\r\nЦвет линии: ByLayer\r\nСтиль линии: ByLayer\r\nТолщина линии: ByLayer\r\nФлаги полилинии: Замкнутый\r\nПлощадь: 16732.571\r\nПериметр: 557.537\r\nМесторасположение 0: X=363.586 Y=243.45 Z=0\r\nМесторасположение 1: X=362.619 Y=297.595 Z=0\r\nМесторасположение 2: X=478.643 Y=303.396 Z=0\r\nМесторасположение 3: X=513.451 Y=211.544 Z=0\r\nМесторасположение 4: X=466.074 Y=139.996 Z=0\r\nМесторасположение 5: X=386.791 Y=163.2 Z=0\r\nМесторасположение 6: X=419.664 Y=201.875 Z=0\r\nLWPOLYLINE\r\nДескриптор: 7B\r\nРежим: Модель\r\nLayer: 0\r\nЦвет линии: ByLayer\r\nСтиль линии: ByLayer\r\nТолщина линии: ByLayer\r\nФлаги полилинии: Замкнутый\r\nПлощадь: 15114.375\r\nПериметр: 529.843\r\nМесторасположение 0: X=113.167 Y=142.896 Z=0\r\nМесторасположение 1: X=113.167 Y=226.047 Z=0\r\nМесторасположение 2: X=294.939 Y=226.047 Z=0\r\nМесторасположение 3: X=294.939 Y=142.896 Z=0\r\nНажмите ENTER для продолжения»\r\nLWPOLYLINE\r\nДескриптор: 7E\r\nРежим: Модель\r\nLayer: 0\r\nЦвет линии: ByLayer\r\nСтиль линии: ByLayer\r\nТолщина линии: ByLayer\r\nФлаги полилинии: Открыть\r\nПлощадь: 0\r\nПериметр: 444.992\r\nМесторасположение 0: X=152.809 Y=304.363 Z=0\r\nМесторасположение 1: X=131.538 Y=350.773 Z=0\r\nМесторасположение 2: X=198.252 Y=381.712 Z=0\r\nМесторасположение 3: X=265.933 Y=370.11 Z=0\r\nМесторасположение 4: X=275.601 Y=325.634 Z=0\r\nМесторасположение 5: X=256.264 Y=279.225 Z=0\r\nМесторасположение 6: X=205.02 Y=261.821 Z=0\r\nМесторасположение 7: X=134.439 Y=283.092 Z=0\r\nМесторасположение 8: X=152.809 Y=304.363 Z=0";

	// строка из DraftSight

	//
	private MultiPolygon result;

	public ACadParser(String ACad) throws ParseException {

		if (ACad.contains("POLYGON") || ACad.contains("LINESTRING")) {
			WKTpars(ACad);
			if (rings!=null){
				while (rings.size() > 0) {
					FindOwner(spatialCheck());// добавлено
				}
			}
			for (int c = 0; c < mpolys.size(); c++) {
				for (int m = 0; m < mpolys.get(c).getNumGeometries(); m++) {
					polys.add((Polygon) mpolys.get(c).getGeometryN(m));
				}
			}

			result = new MultiPolygon(polys.toArray(new Polygon[polys.size()]),
					geometryFactory);

		} else
			coord = doCoordinate(ACad);
		if (coord != null) {
			for (int i = 0; i < coord.size(); i++) {
				rings.add(createLinearRing(coord.get(i)));
			}
		}
		while (rings.size() > 0) {
			FindOwner(spatialCheck());// добавлено
		}

		result = new MultiPolygon(polys.toArray(new Polygon[polys.size()]),
				geometryFactory);

	}

	public List<CoordinateList> getCoord() {
		return coord;
	}

	private List<CoordinateList> doCoordinate(String ACad) {

		String dataText = ACad.substring(ACad.indexOf("X"),
				ACad.lastIndexOf("Z") + 1);
		String[] cont = dataText.split("\\r?\\n");
		List<String> txt = new ArrayList<String>();
		for (int i = 0; i < cont.length; i++) {
			if (cont[i].contains("ENTER")) {
				continue;
			} else {
				txt.add(cont[i]);
			}
		}
		List<List<String>> container = new ArrayList<List<String>>();
		List<String> inside = new ArrayList<String>();
		for (int i = 0; i < txt.size(); i++) {
			if (txt.get(i).contains("X")) {
				inside.add(txt.get(i));
				if (i == txt.size() - 1) {
					container.add(inside);
					inside = new ArrayList<String>();
				} else if (txt.get(i + 1).contains("X") == false) {
					container.add(inside);
					inside = new ArrayList<String>();

				}
			}
		}

		for (int i = 0; i < container.size(); i++) {
			List<Coordinate> XY = new ArrayList<Coordinate>();
			for (int r = 0; r < container.get(i).size(); r++) {
				XY.add(new Coordinate(
						Double.valueOf(container
								.get(i)
								.get(r)
								.substring(
										container.get(i).get(r).indexOf("X") + 2,
										container.get(i).get(r).indexOf("Y") - 2)),
						Double.valueOf(container
								.get(i)
								.get(r)
								.substring(
										container.get(i).get(r).indexOf("Y") + 2,
										container.get(i).get(r).indexOf("Z") - 2))));
			}
			coord.add(new CoordinateList(XY.toArray(new Coordinate[XY.size()])));
		}

		return coord;

	}

	private LinearRing createLinearRing(CoordinateList coords) {
		coords.add(coords.get(0));
		Coordinate[] arr = coords.toCoordinateArray();
		// coords.clear();
		try {
			CoordinateSequenceFactory fact = CoordinateArraySequenceFactory
					.instance();
			CoordinateSequence cseq = fact.create(arr);
			LinearRing ring = new LinearRing(cseq, geometryFactory);
			// innerRingsCount++;
			return ring;
		} catch (Exception ex) {
			// logger.error("Ошибка создания LinearRing. ", ex);
			return null;
		}
	}

	/*
	 * 
	 */
	private int spatialCheck() {
		int maxAreaIndex = 0;

		for (int i = 1; i < rings.size(); i++) {
			Polygon pol = new Polygon(rings.get(maxAreaIndex), null,
					geometryFactory);
			Double maxArea = pol.getArea();
			LinearRing lr = rings.get(i);
			Polygon poli = new Polygon(lr, null, geometryFactory);
			if (pol.getArea() < poli.getArea()) {
				maxAreaIndex = i;
				maxArea = poli.getArea();
			}
		}

		return maxAreaIndex;
	}

	private void FindOwner(int MaxIndex) {

		LinearRing main = rings.get(MaxIndex);
		rings.remove(MaxIndex);
		List<LinearRing> holes = new ArrayList<LinearRing>();
		Polygon fir = geometryFactory.createPolygon(main, null);
		for (int k = 0; k < rings.size(); k++) {

			Polygon sec = geometryFactory.createPolygon(rings.get(k), null);
			if (fir.contains(sec)) {
				holes.add(rings.get(k));
				rings.remove(k);
			}
		}

		polys.add(createPolygon(main,
				holes.toArray(new LinearRing[holes.size()])));

	}

	private Polygon createPolygon(LinearRing ring, LinearRing[] holes) {
		Polygon p = new Polygon(ring, holes, geometryFactory);
		return p;
	}

	public MultiPolygon getResult() {
		return result;
	}

	public List<LinearRing> getRings() {
		return rings;
	}

	public List<Polygon> getPolys() {
		return polys;
	}

	public List<Polygon> getLines() {
		return lines;
	}

	public void WKTpars(String wkt) throws ParseException {
		String[] obr = wkt.split("\n");
		WKTReader reader = new WKTReader(geometryFactory);

		for (int r = 0; r < obr.length; r++) {

			if (obr[r].contains("MULTIPOLYGON")) {
				MultiPolygon mpolygon = (MultiPolygon) reader.read(obr[r]);
				mpolys.add(mpolygon);

				continue;

			} else if (obr[r].contains("POLYGON")) {

				Polygon polygon = (Polygon) reader.read(obr[r]);
				polys.add(polygon);

			} else if (obr[r].contains("LINESTRING")) {
				LineString ls = (LineString) reader.read(obr[r]);
				if (ls.getStartPoint().getX() == ls.getEndPoint().getX()
						& ls.getStartPoint().getY() == ls.getEndPoint().getY()) {
					LinearRing ring = geometryFactory.createLinearRing(ls
							.getCoordinates());
					rings.add(ring);
//					Polygon polygon = geometryFactory.createPolygon(ring, null);
//					polys.add(polygon);
				}
			}

		}

	}

}
