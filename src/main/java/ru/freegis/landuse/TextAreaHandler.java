package ru.freegis.landuse;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class TextAreaHandler implements Appender {

	static private JTextArea jTextArea = null;

	static public void setTextArea(JTextArea jTextArea) {
		TextAreaHandler.jTextArea = jTextArea;
	}

	public void addFilter(Filter arg0) {

	}

	public void clearFilters() {

	}

	public void close() {

	}

	public void doAppend(LoggingEvent arg0) {
		final String message = arg0.getMessage().toString();

		// Append formatted message to textareas using the Swing Thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				jTextArea.append(message + "\r\n");
			}
		});
	}

	public ErrorHandler getErrorHandler() {
		return null;
	}

	public Filter getFilter() {
		return null;
	}

	public Layout getLayout() {
		return null;
	}

	public String getName() {
		return null;
	}

	public boolean requiresLayout() {
		return false;
	}

	public void setErrorHandler(ErrorHandler arg0) {

	}

	public void setLayout(Layout arg0) {

	}

	public void setName(String arg0) {

	}

}
