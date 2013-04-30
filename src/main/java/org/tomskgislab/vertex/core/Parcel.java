package org.tomskgislab.vertex.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.geotools.data.DefaultTransaction;
import org.geotools.data.Transaction;
import org.geotools.data.collection.ListFeatureCollection;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.simple.SimpleFeatureStore;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.referencing.CRS;
import org.geotools.referencing.crs.DefaultEngineeringCRS;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.odftoolkit.odfdom.incubator.doc.style.OdfStyle;
import org.odftoolkit.odfdom.type.Color;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.style.Border;
import org.odftoolkit.simple.style.StyleTypeDefinitions;
import org.odftoolkit.simple.style.StyleTypeDefinitions.CellBordersType;
import org.odftoolkit.simple.style.StyleTypeDefinitions.HorizontalAlignmentType;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.CellRange;
import org.odftoolkit.simple.table.Table;
import org.omg.CORBA.Environment;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.tomskgislab.vertex.ACadParser;
import org.tomskgislab.vertex.core.FeatureBuilder.CadastreFeatureTypes;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateList;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Polygon;

public class Parcel extends Lot {

	private SimpleFeatureType PARCEL_TYPE;
	private List<SimpleFeature> features = new ArrayList<SimpleFeature>();
	private List<Polygon> polyg = new ArrayList<Polygon>();
	private MultiPolygon result;
	private String CADNUMBER;
	private SpreadsheetDocument doc;
	private DecimalFormat coordFormat;
	private DecimalFormat areaFormat;
	private Border border;

	private static Logger logger = LogManager.getLogger(Lot.class);

	public Parcel(MultiPolygon Geometry, String CN)
			throws NoSuchAuthorityCodeException, FactoryException {
		super(Geometry);
		CADNUMBER = CN;
		coordFormat = new DecimalFormat("0.00");
		areaFormat = new DecimalFormat("0");
		result = Geometry;
		PARCEL_TYPE = FeatureBuilder.createFeatureType(
				DefaultEngineeringCRS.GENERIC_2D, CadastreFeatureTypes.Parcel);
		SimpleFeatureBuilder builder = new SimpleFeatureBuilder(PARCEL_TYPE);
		builder.add(result);
		builder.add(CADNUMBER);
		SimpleFeature feature = builder.buildFeature(null);
		features.add(feature);
	}

	public Parcel(List<Polygon> Plist) {
		super(Plist);
		coordFormat = new DecimalFormat("0.00");
		areaFormat = new DecimalFormat("0");
		polyg = Plist;
		PARCEL_TYPE = FeatureBuilder.createFeatureType(
				DefaultEngineeringCRS.GENERIC_2D, CadastreFeatureTypes.Polygon);
		SimpleFeatureBuilder builder = new SimpleFeatureBuilder(PARCEL_TYPE);
		for (int i = 0; i < polyg.size(); i++) {
			builder.add(polyg.get(i));
			builder.add("Contour" + (i + 1));
			SimpleFeature feature = builder.buildFeature(null);
			features.add(feature);
		}
	}

	public void saveToShape() throws IOException, FactoryException {

		File RenameParcelFile = getNewShapeFile();
		// FileName.renameTo(RenameParcelFile);
		if (RenameParcelFile == null) {
			logger.info("Сохранение отменено. ");
			return;
		}
		ShapefileDataStoreFactory polygonDataStoreFactory = new ShapefileDataStoreFactory();

		Map<String, Serializable> paramsPolygon = new HashMap<String, Serializable>();
		paramsPolygon.put("url", RenameParcelFile.toURI().toURL());
		paramsPolygon.put("create spatial index", Boolean.TRUE);

		ShapefileDataStore polygonDataStore = (ShapefileDataStore) polygonDataStoreFactory
				.createNewDataStore(paramsPolygon);
		SimpleFeatureType optType = PARCEL_TYPE;
		polygonDataStore.createSchema(optType);
		// polygonDataStore.setStringCharset(Charset.forName(charset));
		// polygonDataStore.forceSchemaCRS(CRS.decode("EPSG:28415"));
		String ParcelTypeName = polygonDataStore.getTypeNames()[0];
		SimpleFeatureSource parcelFeatureSource = polygonDataStore
				.getFeatureSource(ParcelTypeName);

		if (parcelFeatureSource instanceof SimpleFeatureStore) {
			saveData((SimpleFeatureStore) parcelFeatureSource);
		} else {
			logger.warn(ParcelTypeName + " не поддерживает чтение/запись");
		}

		logger.info("Завершение конвертации. ");
	}

	private void saveData(SimpleFeatureStore parcelFeatureStore)
			throws IOException {
		Transaction transactionParcel = new DefaultTransaction("create");
		parcelFeatureStore.setTransaction(transactionParcel);
		FeatureCollection<SimpleFeatureType, SimpleFeature> fc = new ListFeatureCollection(
				PARCEL_TYPE, features);
		try {
			parcelFeatureStore.addFeatures(fc);
			transactionParcel.commit();
			logger.info("Успешное сохранение полигонов. ");

		} catch (Exception ex) {
			logger.error(
					"Ошибка при добавлении в shapefile. \r\nОткат изменений в shapefile, но файл возможно создан.",
					ex);
			transactionParcel.rollback();

		} finally {
			transactionParcel.close();
			logger.info("Конец обработки полигонов.");
		}
	}

	private static File getNewShapeFile() {

		String newPath = "Parcel.shp";

		JFileDataStoreChooser chooser = new JFileDataStoreChooser("shp");
		chooser.setDialogTitle("Save shapefile");
		chooser.setSelectedFile(new File(newPath));

		int returnVal = chooser.showSaveDialog(null);

		if (returnVal != JFileDataStoreChooser.APPROVE_OPTION) {
			// the user cancelled the dialog
			File bad = null;
			return bad;
		}

		File newFile = chooser.getSelectedFile();
		return newFile;
	}

	private double getLength(Coordinate pt1, Coordinate pt2) {
		try {
			double lngth = Math.sqrt(Math.pow((pt2.x - pt1.x), 2)
					+ Math.pow((pt2.y - pt1.y), 2));
			return lngth;
		} catch (Exception ex) {
			logger.info("Ошибка вычисления длины линий ");
			return -1.0;
			
			
		}
	}

	private String getStringLenght(Coordinate pt1, Coordinate pt2,
			DecimalFormat formatter) {
		if (formatter == null) {
			formatter = new DecimalFormat("0.00");
		}
		return formatter.format(getLength(pt1, pt2));
	}

	public void saveToOdf(ACadParser acad) {
		try {
			doc = SpreadsheetDocument.newSpreadsheetDocument();
			border = new Border(Color.BLACK, 0.3,
					StyleTypeDefinitions.SupportedLinearMeasure.PT);
			createCoordCatalog(acad);
			createGeodata(acad);
			JFileDataStoreChooser chooser = new JFileDataStoreChooser("ods");
			chooser.setDialogTitle("Сохранение");
			chooser.setSelectedFile(new File("Vertex.ods"));

			int returnVal = chooser.showSaveDialog(null);

			if (returnVal != JFileDataStoreChooser.APPROVE_OPTION) {
				// the user cancelled the dialog
				logger.info("Отмена сохранения таблицы. ");
				return;
			}
			// File newFile = chooser.getSelectedFile();
			doc.save(chooser.getSelectedFile());
			logger.info("Успешное сохранение таблицы. ");
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			logger.info("Ошибка созранения таблицы. ");
		}
	}

	private void createCoordCatalog(ACadParser acad) {
		try {

			Table tab = doc.getSheetByIndex(0);
			tab.setTableName("Ведомость координат");
			MultiPolygon mp = acad.getResult();
			// Текеущая позиция вставки в таблицу
			int rowsCount = 1;
			int pointNum = 1;
			int lastPointN = 1;
			tab.getCellByPosition(0, 3).setStringValue("N п/п");
			tab.getCellByPosition(1, 3).setStringValue("X");
			tab.getCellByPosition(2, 3).setStringValue("Y");
			tab.getCellByPosition(3, 3).setStringValue("Дирекционный угол");
			tab.getCellByPosition(4, 3).setStringValue("Расстояние, м");

			tab.getCellByPosition(3, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			tab.getCellByPosition(4, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			tab.getCellByPosition(0, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			tab.getCellByPosition(1, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			tab.getCellByPosition(2, 3).setBorders(CellBordersType.ALL_FOUR,
					border);

			// Мультиполигон - ЗУ
			for (int j = 0; j < mp.getNumGeometries(); j++) {
				// Простой полигон
				Polygon polygon = (Polygon) mp.getGeometryN(j);
				LineString contour;
				for (int i = 0; i < polygon.getNumInteriorRing() + 1; i++) {

					if (i == 0)
						contour = polygon.getExteriorRing();
					else
						contour = polygon.getInteriorRingN(i - 1);

					for (int k = 0; k < contour.getNumPoints(); k++) {
						if (k == 0)
							lastPointN = pointNum;
						// Последняя точка
						if (k == contour.getNumPoints() - 1) {
							Cell cellN = tab.getCellByPosition(0,
									(rowsCount * 2 + 1) + 1);
							cellN.setStringValue(String.valueOf((lastPointN)));
							Cell cellX = tab.getCellByPosition(1,
									(rowsCount * 2 + 1) + 1);
							Cell cellY = tab.getCellByPosition(2,
									(rowsCount * 2 + 1) + 1);
							cellX.setStringValue(coordFormat.format(contour
									.getPointN(k).getY()));
							cellY.setStringValue(coordFormat.format(contour
									.getPointN(k).getX()));
							cellN.setBorders(CellBordersType.ALL_FOUR, border);
							cellX.setBorders(CellBordersType.ALL_FOUR, border);
							cellY.setBorders(CellBordersType.ALL_FOUR, border);
							tab.getCellByPosition(3, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(4, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
						} else {
							Cell cellN = tab.getCellByPosition(0,
									(rowsCount * 2 + 1) + 1);
							Cell cellX = tab.getCellByPosition(1,
									(rowsCount * 2 + 1) + 1);
							Cell cellY = tab.getCellByPosition(2,
									(rowsCount * 2 + 1) + 1);
							Cell cellA = tab.getCellByPosition(3,
									(rowsCount * 2 + 1) + 2);
							Cell length = tab.getCellByPosition(4,
									(rowsCount * 2 + 1) + 2);
							cellN.setStringValue(String.valueOf((pointNum)));
							cellX.setStringValue(coordFormat.format(contour
									.getPointN(k).getY()));
							cellY.setStringValue(coordFormat.format(contour
									.getPointN(k).getX()));
							length.setStringValue((getStringLenght(contour
									.getPointN(k).getCoordinate(), contour
									.getPointN(k + 1).getCoordinate(),
									coordFormat)));
							double ddx = contour.getPointN(k + 1)
									.getCoordinate().y
									- contour.getPointN(k).getCoordinate().y;
							double ddy = contour.getPointN(k + 1)
									.getCoordinate().x
									- contour.getPointN(k).getCoordinate().x;
							cellA.setStringValue(new Angle(ddx, ddy)
									.getDirectionalAngle());

							cellN.setBorders(CellBordersType.ALL_FOUR, border);
							cellX.setBorders(CellBordersType.ALL_FOUR, border);
							cellY.setBorders(CellBordersType.ALL_FOUR, border);
							cellA.setBorders(CellBordersType.ALL_FOUR, border);
							length.setBorders(CellBordersType.ALL_FOUR, border);
							tab.getCellByPosition(3, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(4, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(0, (rowsCount * 2 + 1) + 2)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(1, (rowsCount * 2 + 1) + 2)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(2, (rowsCount * 2 + 1) + 2)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
						}

						pointNum++;
						rowsCount++;
					}

				}

				if (mp.getNumGeometries() > 1) {
					tab.getCellByPosition(0, rowsCount * 2 + 1).setStringValue(
							"Контур " + String.valueOf(j + 1) + " Площадь: "
									+ areaFormat.format(polygon.getArea())
									+ " кв.м");
				} else if (mp.getNumGeometries() == 1) {
					tab.getCellByPosition(0, rowsCount * 2 + 1).setStringValue(
							"Площадь: " + areaFormat.format(polygon.getArea())
									+ " кв.м");
				}
			}
			logger.info("Успешное создание таблицы ВЕДОМОСТЬ КООРДИНАТ");
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			logger.info("Ошибка при создании таблицы ВЕДОМОСТЬ КООРДИНАТ");
		}
	}

	private void createGeodata(ACadParser acad) {
		try {

			Table tab = doc.addTable();
			tab.setTableName("Геоданные");
			MultiPolygon mp = acad.getResult();
			// Текеущая позиция вставки в таблицу
			int rowsCount = 1;
			int pointNum = 1;
			int lastPointN = 1;
			tab.getCellByPosition(0, 3).setStringValue("N п/п");
			// tab.getCellByPosition(1, 3).setStringValue("X");
			// tab.getCellByPosition(2, 3).setStringValue("Y");
			tab.getCellByPosition(1, 3).setStringValue("Дирекционный угол");
			tab.getCellByPosition(2, 3).setStringValue("Расстояние, м");

			tab.getCellByPosition(1, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			tab.getCellByPosition(2, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			tab.getCellByPosition(0, 3).setBorders(CellBordersType.ALL_FOUR,
					border);
			// tab.getCellByPosition(1, 3).setBorders(CellBordersType.ALL_FOUR,
			// border);
			// tab.getCellByPosition(2, 3).setBorders(CellBordersType.ALL_FOUR,
			// border);

			// Мультиполигон - ЗУ
			for (int j = 0; j < mp.getNumGeometries(); j++) {
				// Простой полигон
				Polygon polygon = (Polygon) mp.getGeometryN(j);
				LineString contour;
				for (int i = 0; i < polygon.getNumInteriorRing() + 1; i++) {

					if (i == 0)
						contour = polygon.getExteriorRing();
					else
						contour = polygon.getInteriorRingN(i - 1);

					for (int k = 0; k < contour.getNumPoints(); k++) {
						if (k == 0)
							lastPointN = pointNum;
						// Последняя точка
						if (k == contour.getNumPoints() - 1) {
							Cell cellN = tab.getCellByPosition(0,
									(rowsCount * 2 + 1) + 1);
							cellN.setStringValue(String.valueOf((lastPointN)));
							// Cell cellX = tab.getCellByPosition(1,
							// (rowsCount*2+1)+1);
							// Cell cellY = tab.getCellByPosition(2,
							// (rowsCount*2+1)+1);
							// cellX.setStringValue(coordFormat.format(contour.getPointN(k).getX()));
							// cellY.setStringValue(coordFormat.format(contour.getPointN(k).getY()));
							cellN.setBorders(CellBordersType.ALL_FOUR, border);
							// cellX.setBorders(CellBordersType.ALL_FOUR,
							// border);
							// cellY.setBorders(CellBordersType.ALL_FOUR,
							// border);
							tab.getCellByPosition(1, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(2, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
						} else {
							Cell cellN = tab.getCellByPosition(0,
									(rowsCount * 2 + 1) + 1);
							// Cell cellX = tab.getCellByPosition(1,
							// (rowsCount*2+1)+1);
							// Cell cellY = tab.getCellByPosition(2,
							// (rowsCount*2+1)+1);
							Cell cellA = tab.getCellByPosition(1,
									(rowsCount * 2 + 1) + 2);
							Cell length = tab.getCellByPosition(2,
									(rowsCount * 2 + 1) + 2);
							cellN.setStringValue(String.valueOf((pointNum)));
							// cellX.setStringValue(coordFormat.format(contour.getPointN(k).getX()));
							// cellY.setStringValue(coordFormat.format(contour.getPointN(k).getY()));
							length.setStringValue((getStringLenght(contour
									.getPointN(k).getCoordinate(), contour
									.getPointN(k + 1).getCoordinate(),
									coordFormat)));
							double ddx = contour.getPointN(k + 1)
									.getCoordinate().y
									- contour.getPointN(k).getCoordinate().y;
							double ddy = contour.getPointN(k + 1)
									.getCoordinate().x
									- contour.getPointN(k).getCoordinate().x;
							cellA.setStringValue(new Angle(ddx, ddy)
									.getDirectionalAngle());

							cellN.setBorders(CellBordersType.ALL_FOUR, border);
							// cellX.setBorders(CellBordersType.ALL_FOUR,
							// border);
							// cellY.setBorders(CellBordersType.ALL_FOUR,
							// border);
							cellA.setBorders(CellBordersType.ALL_FOUR, border);
							length.setBorders(CellBordersType.ALL_FOUR, border);
							tab.getCellByPosition(1, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(2, (rowsCount * 2 + 1) + 1)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							tab.getCellByPosition(0, (rowsCount * 2 + 1) + 2)
									.setBorders(CellBordersType.ALL_FOUR,
											border);
							// tab.getCellByPosition(1,
							// (rowsCount*2+1)+2).setBorders(CellBordersType.ALL_FOUR,
							// border);
							// tab.getCellByPosition(2,
							// (rowsCount*2+1)+2).setBorders(CellBordersType.ALL_FOUR,
							// border);
						}

						pointNum++;
						rowsCount++;
					}

				}

				if (mp.getNumGeometries() > 1) {
					tab.getCellByPosition(0, rowsCount * 2 + 1).setStringValue(
							"Контур " + String.valueOf(j + 1) + " Площадь: "
									+ areaFormat.format(polygon.getArea())
									+ " кв.м");
				} else if (mp.getNumGeometries() == 1) {
					tab.getCellByPosition(0, rowsCount * 2 + 1).setStringValue(
							"Площадь: " + areaFormat.format(polygon.getArea())
									+ " кв.м");
				}
			}
			logger.info("Успешное создание таблицы ГЕОДАННЫЕ ");
		} catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
			logger.info("Ошибка при создании таблицы ГЕОДАННЫЕ");
		}
	}

	public void saveTXT() {
		String newPath = "Coordinate.txt";
		JFileDataStoreChooser chooser = new JFileDataStoreChooser("txt");
		chooser.setDialogTitle("Save text");
		chooser.setSelectedFile(new File(newPath));

		int returnVal = chooser.showSaveDialog(null);

		if (returnVal != JFileDataStoreChooser.APPROVE_OPTION) {
			// the user cancelled the dialog
			File bad = null;

		}

		File newFile = chooser.getSelectedFile();
		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(
					chooser.getSelectedFile()));
			for (int i = 0; i < polyg.size(); i++) {
				LineString cont = polyg.get(i).getExteriorRing();

				for (int t = 0; t < cont.getNumPoints(); t++) {
					if (t == cont.getNumPoints() - 1) {
						out.println(cont.getPointN(t).getX() + " "
								+ cont.getPointN(t).getY()
								+ System.getProperty("line.separator"));

					} else {
						out.println(cont.getPointN(t).getX() + " "
								+ cont.getPointN(t).getY());
					}
				}
				for (int r = 0; r < polyg.get(i).getNumInteriorRing(); r++) {
					LineString cont1 = polyg.get(i).getInteriorRingN(r);
					for (int y = 0; y < cont1.getNumPoints(); y++) {
						if (y == cont1.getNumPoints() - 1
								&& r == polyg.get(i).getNumInteriorRing() - 1) {
							out.println(cont1.getPointN(y).getX() + " "
									+ cont1.getPointN(y).getY()
									+ System.getProperty("line.separator")+ System.getProperty("line.separator"));

						} else if (y == cont1.getNumPoints() - 1) {
							out.println(cont1.getPointN(y).getX() + " "
									+ cont1.getPointN(y).getY()
									+ System.getProperty("line.separator"));

						} else {
							out.println(cont1.getPointN(y).getX() + " "
									+ cont1.getPointN(y).getY());
						}
					}

				}

			}
			out.close();
			logger.info("Успешное сохранение текстового файла. ");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getLocalizedMessage());
			logger.info("Ошибка при сохранении текстового файла");
		}
	}
}
