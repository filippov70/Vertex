package org.tomskgislab.vertex;

import java.io.IOException;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.geotools.factory.GeoTools;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.tomskgislab.vertex.core.Parcel;

import com.vividsolutions.jts.io.ParseException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Method implements Initializable{
	private static Logger logger = LogManager.getLogger(Method.class);
	@FXML
	private TextArea text;
	@FXML
	private TextArea textAreaLog;
	@FXML
	private TextField textF;
	@FXML
	private Menu saveShp;
	@FXML
	private Menu saveWKT;
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
	private MenuItem start;
	@FXML
	private MenuItem help;

	ACadParser acp = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.textAreaLog = new TextArea();
        TextAreaHandler.setTextArea(this.textAreaLog);
        Logger.getRootLogger().addAppender(new TextAreaHandler());
        textAreaLog.setText("Начало работы Vertex2.0...JavaFX\nРазработка:\n");
        textAreaLog.end();
    }
    @FXML
    protected void initialize() {

    }

	@FXML
	protected void start() {
		try {
			acp = new ACadParser(text.getText());
			if (acp != null) {
				saveShp.setDisable(false);
				saveWKT.setDisable(false);
				saveWKTMultiPolygon.setDisable(false);
				saveWKTPolygon.setDisable(false);
				saveShpMultiPolygon.setDisable(false);
				saveShpPolygon.setDisable(false);
				saveODS.setDisable(false);
				saveTXT.setDisable(false);
				logger.info("Выбирете вариант сохранения.");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Ошибка обработки текстовых данных.");
		}

	}

	@FXML
	protected void doConvertWKT() {
		text.setText(acp.getResult().toText());
		logger.info("Успешная конвертация МультиПолигона в WKT.");
	}

	@FXML
	protected void doConvertWKTPolygons() {
		// ACadParser acp = new ACadParser(text.getText());
		String s = "";
		for (int i = 0; i < acp.getPolys().size(); i++) {
			s = s + acp.getPolys().get(i).toText()
					+ System.getProperty("line.separator");
		}
		text.setText(s);
		logger.info("Успешная конвертация Полигонов в WKT.");
	}

	@FXML
	protected void doReport() throws NoSuchAuthorityCodeException,
			FactoryException, ParseException {
		Parcel odf = null;
		odf = new Parcel(acp.getResult(), textF.getText());
		odf.saveToOdf(acp);

	}

	@FXML
	protected void doSaveShape() throws NoSuchAuthorityCodeException,
			FactoryException, IOException {
		Parcel par = null;
		par = new Parcel(acp.getResult(), textF.getText());
		par.saveToShape();

	}

	@FXML
	protected void doShapes() {
		Parcel par1 = new Parcel(acp.getPolys());
		try {
			par1.saveToShape();
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	protected void saveTXT() {
		Parcel p = new Parcel(acp.getPolys());
		p.saveTXT();
	}

	@FXML
	protected void getHelp() {
		Stage PS = new Stage();
		PS.setTitle("Помощь");
		try {
			FXMLLoader loader = new FXMLLoader(
					App.class.getResource("HelpWindow.fxml"));
			VBox dh = (VBox) loader.load();
			Scene s = new Scene(dh);
			PS.setScene(s);
			PS.show();
		} catch (IOException ex) {
			logger.error(ex.getMessage());
			System.exit(-1);
		}
	}

}
