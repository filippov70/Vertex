package org.tomskgislab.vertex;

import java.io.IOException;
import java.util.Formatter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.tomskgislab.vertex.core.Parcel;

import com.vividsolutions.jts.io.ParseException;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Method {
	private static Logger logger = LogManager.getLogger(Method.class);
	@FXML
	private TextArea text;
	@FXML
	private TextField textF;
	@FXML
	private MenuItem saveShpPolygon;
	@FXML
	private MenuItem saveShpMultiPolygon;
	@FXML
	private MenuItem saveWKTPolygon;
	@FXML
	private MenuItem saveWKTMultiPolygon;
	@FXML
	private MenuItem saveODS;
	@FXML
	private MenuItem saveTXT;

	@FXML
	public void getText() {
		this.text.getText();
	}

	@FXML
	protected void doConvertWKT() {
		try {
			ACadParser acp = new ACadParser(text.getText());

			text.setText(acp.getResult().toText());
		} catch (ParseException ex) {
			logger.error(ex.getLocalizedMessage());
		}

	}

	@FXML
	protected void doConvertWKTPolygons() {
		try {
			ACadParser acp = new ACadParser(text.getText());

			String s = "";
			for (int i = 0; i < acp.getPolys().size(); i++) {
				s = s + acp.getPolys().get(i).toText() + "\n";
			}
			text.setText(s);
		} catch (ParseException ex) {
			logger.error(ex.getLocalizedMessage());
		}

	}

	@FXML
	protected void doReport() throws NoSuchAuthorityCodeException,
			FactoryException, ParseException {
		ACadParser acp = new ACadParser(text.getText());

		Parcel odf = new Parcel(acp.getResult(), textF.getText());
		odf.saveToOdf(acp);

	}

	@FXML
	protected void doSaveShape() throws NoSuchAuthorityCodeException,
			FactoryException, IOException, ParseException {
		ACadParser acp = new ACadParser(text.getText());

		Parcel par = new Parcel(acp.getResult(), textF.getText());
		par.saveToShape();
	}

	@FXML
	protected void doShapes() throws ParseException {
		ACadParser acp = new ACadParser(text.getText());

		Parcel par1 = new Parcel(acp.getPolys());
		try {
			par1.saveToShape();
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@FXML
	protected void saveTXT() throws ParseException {
		ACadParser acp = new ACadParser(text.getText());
		Parcel p = new Parcel(acp.getPolys());
		p.saveTXT();
	}


}
