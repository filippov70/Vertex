package ru.freegis.mif;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import ru.freegis.landuse.AppWindow;

/**
 * 
 * @author Филиппов Владислав 2012
 * 
 */
public class Region {

	private static Logger LOGGER = LogManager.getLogger(Region.class);

	private List<Contour> contours;

	public Region() {
		contours = new ArrayList<Contour>();
	}

	public List<Contour> getContours() {
		return contours;
	}

	public void addContours(Contour contour) {
		this.contours.add(contour);
	}

	public void saveToMIF() {
		String Header = "Version   300\r\nCharset \"WindowsCyrillic\"\r\nDelimiter \",\"\r\nCoordSys NonEarth Units \"m\" Bounds (-100000, -100000) (100000, 100000)\r\nColumns 1\r\n  ID Char(10)\r\nData\r\n";
		String filename = "";

		JFileChooser fileopen = new JFileChooser();
		int ret = fileopen.showDialog(null, "Сохранить MIF файл");
		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileopen.getSelectedFile();
			filename = file.getAbsolutePath() + ".MIF";
		} else {
			return;
		}
		LOGGER.info("выходной файл " + filename);
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(filename));
			out.write(Header);
			out.write("  REGION " + contours.size() + "\r\n");
			for (int i = 0; i < contours.size(); i++) {
				contours.get(i).saveToMIF(out);
				out.write("\r\n\r\n");
			}
		} catch (IOException ex) {
			LOGGER.error(ex);
		} finally {
			if (out != null) {
				try {
					out.close();
					LOGGER.info("Файл успешно сохранён " + filename);
				} catch (IOException ex) {
					LOGGER.error(ex);
				}
			}
		}

	}

}
