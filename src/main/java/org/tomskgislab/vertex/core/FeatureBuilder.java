package org.tomskgislab.vertex.core;

import com.vividsolutions.jts.geom.MultiPolygon;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

/**
 * Cоздатель кадастровых объектов. Содержит описание пространственных объектов.
 * Пока нужны объекты типа Полигон - ЗУ и чЗУ.
 * 
 * @author Филиппов Владислав
 */
public class FeatureBuilder {

	private static Logger logger = LogManager.getLogger(FeatureBuilder.class);

	public enum CadastreFeatureTypes {
		// CharacterPoint, // Характерная точка
		// BorderPart, // Часть границы
		Polygon, Parcel // Участок
		// ParcelPart; // Часть участка
	}

	/**
	 * Создатель типов пространственных объектов.
	 * 
	 * @param crs
	 *            Система координат
	 * @param FeatureType
	 *            тип создаваемого объекта (enum)
	 * @return Созданая фича
	 */
	public static SimpleFeatureType createFeatureType(
			CoordinateReferenceSystem crs, CadastreFeatureTypes FeatureType) {

		SimpleFeatureTypeBuilder builder = new SimpleFeatureTypeBuilder();
		builder.setCRS(crs);
		// У всех объектов есть наименование
		switch (FeatureType) {
		// По просьбам трудящихся точки
		// case CharacterPoint :
		// builder.setName("CharacterPoint");
		// builder.add("Geometry", Point.class);
		// builder.length(150).add("Name", String.class);
		// builder.length(20).add("SuNumb", String.class);
		// builder.length(20).add("OrdNumb", String.class);
		// builder.length(20).add("NumGeoPt", String.class);
		// builder.length(5).add("Delta", String.class);
		// builder.length(150).add("PointHold", String.class);
		// break;
		case Polygon:
			builder.setName("Lot");
			builder.add("Geometry", Polygon.class);
			builder.length(150).add("Name", String.class);
			break;
		case Parcel:
			builder.setName("Lot");
			builder.add("Geometry", MultiPolygon.class);
			builder.length(25).add("Cadnumber", String.class);
			builder.length(150).add("Name", String.class);
			// TODO ещё полей...
			break;
		default:
			logger.warn("Нет обработчика для данного типа: "
					+ FeatureType.toString());
			return null;
		}

		// build the type
		try {
			return builder.buildFeatureType();
		} catch (Exception ex) {
			logger.error("Не удалость создать пространственный объект. ", ex);
			return null;
		}

	}
}
