package org.tomskgislab.vertex;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JTextArea;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.tomskgislab.vertex.core.Lot;
import org.tomskgislab.vertex.core.Parcel;

import com.vividsolutions.jts.io.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class MainForm {

	private JFrame frame;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JFormattedTextField formattedTextField;
	private static Logger logger = LogManager.getLogger(MainForm.class);

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AppWindow window = new AppWindow();
//					window.frame.setVisible(true);
//
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the application.
//	 */
	public MainForm() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 535);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("Vertex 2.0.0-SNAPSHOT");
//
//		JMenuBar menuBar = new JMenuBar();
//		frame.setJMenuBar(menuBar);
//
//		JMenu mnFile = new JMenu("Файл");
//		menuBar.add(mnFile);
//
//		JMenuItem menuItem = new JMenuItem("Сохранить ведомость");
//		menuItem.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					doReport();
//				} catch (NoSuchAuthorityCodeException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (FactoryException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//
//		JMenu mnShape = new JMenu("Сохранить в shape");
//		mnFile.add(mnShape);
//
//		JMenuItem mntmShapes = new JMenuItem("полигоны");
//		mnShape.add(mntmShapes);
//		mntmShapes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					doShapes();
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//
//		JMenuItem mntmShape = new JMenuItem("мультиполигон");
//		mnShape.add(mntmShape);
//		mntmShape.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					doSaveShape();
//				} catch (NoSuchAuthorityCodeException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (FactoryException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
//
//		JMenu mnWkt = new JMenu("Конвертировать в WKT");
//		mnFile.add(mnWkt);
//
//		JMenuItem menuItem_2 = new JMenuItem("полигоны");
//		menuItem_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				doConvertWKTPolygons();
//			}
//		});
//		mnWkt.add(menuItem_2);
//
//		JMenuItem mntmWkt = new JMenuItem("мультиполигон");
//		mnWkt.add(mntmWkt);
//		mntmWkt.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				doConvertWKT();
//			}
//		});
//		mnFile.add(menuItem);
//
//		scrollPane = new JScrollPane();
//		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//		textArea = new JTextArea();
//		textArea.setTabSize(4);
//		textArea.setWrapStyleWord(true);
//		textArea.setLineWrap(true);
//		scrollPane.setViewportView(textArea);
//		textArea.setText("Команда: список\r\nнайдено: 4\r\n\r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 201\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   665317.6774\r\n         периметр   3193.6532\r\n\r\n          в точке  X=5713.7068  Y=2020.0594  Z=   0.0000\r\n          в точке  X=6021.4896  Y=2436.0829  Z=   0.0000\r\n          в точке  X=6727.5796  Y=2119.5432  Z=   0.0000\r\n          в точке  X=6329.2724  Y=1432.2000  Z=   0.0000\r\n          в точке  X=5650.3397  Y=1622.1238  Z=   0.0000\r\n\r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 200\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   2530851.5681\r\n         периметр   6256.8644\r\n\r\nНажмите ENTER для продолжения:\r\n          в точке  X=4935.1973  Y=1920.5755  Z=   0.0000\r\n          в точке  X=5840.4409  Y=2843.0624  Z=   0.0000\r\n          в точке  X=7207.3587  Y=2508.4348  Z=   0.0000\r\n          в точке  X=6537.4784  Y=1034.2645  Z=   0.0000\r\n          в точке  X=5288.2423  Y=1386.9801  Z=   0.0000\r\n\r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 1ff\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   261329.4832\r\n         периметр   2072.9836\r\n\r\n          в точке  X=2183.2568  Y=1441.2440  Z=   0.0000\r\n          в точке  X=2454.8299  Y=1748.7397  Z=   0.0000\r\n          в точке  X=3025.1334  Y=1604.0358  Z=   0.0000\r\n          в точке  X=2816.9273  Y=1278.4522  Z=   0.0000\r\n          в точке  X=2400.5153  Y=1278.4522  Z=   0.0000\r\n\r\n                  LWPOLYLINE  Слой: \"0\"\r\n                            Пространство: Пространство модели\r\n                   Метка = 1fe\r\nНажмите ENTER для продолжения:\r\n            Замкнутая\r\n    Постоянная ширина    0.0000\r\n              площадь   2234931.9580\r\n         периметр   6279.6487\r\n\r\n          в точке  X=1540.5339  Y=1423.1560  Z=   0.0000\r\n          в точке  X=2337.1482  Y=2119.5432  Z=   0.0000\r\n          в точке  X=4211.0024  Y=1721.6077  Z=   0.0000\r\n          в точке  X=3586.3844  Y= 989.0445  Z=   0.0000\r\n          в точке  X=2156.0995  Y= 771.9887  Z=   0.0000\r\n          в точке  X=1794.0021  Y=1133.7483  Z=   0.0000\r\n");
//		MaskFormatter formatter = null;
//		try {
//			formatter = new MaskFormatter("**:**:*******:****");
//			formatter.setValidCharacters("0123456789");
//		} catch (java.text.ParseException exc) {
//			System.err.println("formatter is bad: " + exc.getMessage());
//		}
//		formattedTextField = new JFormattedTextField(formatter);
//
//		formattedTextField.setFocusLostBehavior(JFormattedTextField.COMMIT);
//
//		frame.getContentPane().add(formattedTextField, BorderLayout.NORTH);
//		// в примере два полигона каждый с одной "дыркой"
//		frame.setVisible(true);
	}
	
	protected void doConvertWKT() {
		try {
			ACadParser acp = new ACadParser(textArea.getText());
			textArea.setText(acp.getResult().toText());
		} catch (ParseException ex) {
			logger.error(ex.getLocalizedMessage());
		}

	}
	
	protected void doConvertWKTPolygons() {
		try {
			ACadParser acp = new ACadParser(textArea.getText());
			String s = "";
			for (int i = 0; i < acp.getPolys().size(); i++) {
				s = s + acp.getPolys().get(i).toText() + "\n";
			}
			textArea.setText(s);
		} catch (ParseException ex) {
			logger.error(ex.getLocalizedMessage());
		}

	}
	
	
	protected void doSaveShape() throws NoSuchAuthorityCodeException,
			FactoryException, IOException, ParseException {
		ACadParser acp = new ACadParser(textArea.getText());
		// System.out.println(acp.getResult().toString());
		Parcel par = new Parcel(acp.getResult(), formattedTextField.getText());
		par.saveToShape();
	}
	
	protected void doReport() throws NoSuchAuthorityCodeException,
			FactoryException, ParseException {
		ACadParser acp = new ACadParser(textArea.getText());
		Parcel odf = new Parcel(acp.getResult(), formattedTextField.getText());
		odf.saveToOdf(acp);

	}
	
	protected void doShapes() throws ParseException {
		ACadParser acp = new ACadParser(textArea.getText());
		Parcel par1 = new Parcel(acp.getPolys());
		try {
			par1.saveToShape();
		} catch (IOException | FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
