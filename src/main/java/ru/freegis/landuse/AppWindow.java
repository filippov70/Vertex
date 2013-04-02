package ru.freegis.landuse;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import ru.freegis.mif.Contour;
import ru.freegis.mif.Pline;
import ru.freegis.mif.Point;
import ru.freegis.mif.Region;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.freegis.landuse.TextAreaHandler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Филиппов Владислав 2012
 * 
 */
public class AppWindow {

	private static Logger LOGGER = LogManager.getLogger(AppWindow.class);

	private JFrame frame;
	private JTextArea textAreaInput;
	private JTextArea textAreaLog;
	private JSeparator jSeparator1;
	private JMenuItem mntmMif;

	private Region ZU;
	private JMenu menu_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					LOGGER.error(e);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppWindow() {
		initialize();
		ZU = new Region();
		TextAreaHandler.setTextArea(this.textAreaLog);
		LOGGER.addAppender(new TextAreaHandler());
		LOGGER.info("Старт приложения...");
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 641, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("MIF \u0438\u0437 AutoCAD \u0424\u0438\u043b\u0438\u043f\u043f\u043e\u0432 \u0412\u043b\u0430\u0434\u0438\u0441\u043b\u0430\u0432 2012");

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u0420\u0430\u0441\u0447\u0435\u0442");
		menuBar.add(menu);
		menu.setText("\u041a\u043e\u043e\u0440\u0434\u0438\u043d\u0430\u0442\u044b");

		JMenuItem menuItem = new JMenuItem("\u041E\u0413\u0417");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCopy();
			}

		});
		menu.add(menuItem);
		menuItem.setText("Конвертировать");
		{
			jSeparator1 = new JSeparator();
			menu.add(jSeparator1);
		}

		mntmMif = new JMenuItem("Сохранить MIF");
		mntmMif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mntmMifPerformed(evt);
			}

		});
		mntmMif.setEnabled(false);
		menu.add(mntmMif);

		menu_1 = new JMenu("Помощь");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				Desktop desktop;
				if (Desktop.isDesktopSupported()) {
					desktop = Desktop.getDesktop();
					if (desktop.isSupported(Desktop.Action.BROWSE)) {
						// launch browser
						URI uri;
						try {
							uri = new URI(
									"https://sites.google.com/site/landprocessorproject/");
							desktop.browse(uri);
						} catch (IOException ioex) {
							LOGGER.error("", ioex);
						} catch (URISyntaxException usex) {
							LOGGER.error("", usex);
						}
					}
				}
			}
		});
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(menu_1);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.2);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		textAreaInput = new JTextArea();
		textAreaInput.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textAreaInput.setWrapStyleWord(true);
		JScrollPane inputScrollPane = new JScrollPane(textAreaInput);
		textAreaInput
				.setText("          at point  X=1099.2547  Y= 274.1185  Z=   0.0000\r\n          at point  X=1134.6896  Y= 381.7459  Z=   0.0000\r\n          at point  X=1134.6896  Y= 469.5471  Z=   0.0000\r\n          at point  X=1113.4287  Y= 585.6714  Z=   0.0000\r\n          at point  X=1076.5765  Y= 669.2242  Z=   0.0000\r\n          at point  X=1076.5765  Y= 724.4541  Z=   0.0000\r\n          at point  X=1138.9418  Y= 742.8640  Z=   0.0000\r\n\r\n         at point  X=1155.9505  Y= 703.2118  Z=   0.0000\r\n          at point  X=1175.7940  Y= 655.0627  Z=   0.0000\r\n          at point  X=1182.8810  Y= 601.2491  Z=   0.0000\r\n          at point  X=1202.7245  Y= 550.2677  Z=   0.0000\r\n          at point  X=1204.1419  Y= 487.9571  Z=   0.0000\r\n          at point  X=1204.1419  Y= 419.9819  Z=   0.0000\r\n          at point  X=1204.1419  Y= 378.9136  Z=   0.0000\r\n          at point  X=1199.8897  Y= 327.9322  Z=   0.0000\r\n          at point  X=1178.6288  Y= 281.1993  Z=   0.0000\r\n          at point  X=1161.6201  Y= 257.1247  Z=   0.0000");
		splitPane.setLeftComponent(inputScrollPane);

		textAreaLog = new JTextArea();
		textAreaLog.setFont(new Font("SansSerif", Font.PLAIN, 10));
		textAreaLog.setWrapStyleWord(true);
		JScrollPane logScrollPane = new JScrollPane(textAreaLog);
		splitPane.setRightComponent(logScrollPane);
	}

	protected void textCopy() {
		try {
			textAreaLog.setText("");
			ZU = new Region();
			String NL = System.getProperty("line.separator");
			DecimalFormat format = new DecimalFormat("0.00");
			String inputData = textAreaInput.getText();
			StringBuilder outStr = new StringBuilder();
			List<Point> pts = new ArrayList<Point>();
			// inputData = inputData.replace("\\t", "");
			String[] cntrs = inputData.split("\\r?\\n\\r?\\n");
			LOGGER.info("Контуров " + cntrs.length);
			for (int k = 0; k < cntrs.length; k++) {
				Contour contour = new Contour();
				String[] strArr = cntrs[k].split("\\r?\\n");
				LOGGER.info("В контуре" + (k + 1) + " точек " + (strArr.length));
				boolean Ascon = cntrs[k].startsWith("Координаты точки");
				for (int i = 0; i < strArr.length; i++) {
					String string = strArr[i];
					Point pt = null;

					if (Ascon) {
						if ((!string.isEmpty())
								&& (string.substring(0, 1)
										.equalsIgnoreCase("x"))) {
							pt = new Point(string, Ascon);
						}
					} else {
						pt = new Point(string);
					}
					if (pt != null) {
						pts.add(pt);
						outStr.append(pt.getYString(format) + " "
								+ pt.getXString(format) + NL);
					}

					if (pts.size() == 2) {
						contour.addContour(new Pline(pts.get(0), pts.get(1)));
						if (i != strArr.length - 1) {
							pts.remove(0);
						}
					}
					if (i == strArr.length - 1) {
						contour.addContour(new Pline(pts.get(1), contour
								.getContour(0).getFirstPoint()));
					}
				}

				ZU.addContours(contour);
				pts.clear();
			}
			// textAreaOutput.setText(outStr.toString().replaceAll(",", "."));
			mntmMif.setEnabled(true);
		} catch (Exception ex) {
			LOGGER.error(ex);
		}
	}

	private void mntmMifPerformed(ActionEvent evt) {
		if ((ZU != null) && (ZU.getContours().size() > 0)) {
			LOGGER.info("Сохранение в MIF...");
			ZU.saveToMIF();
			textAreaInput.setText("");
		}
	}
}
