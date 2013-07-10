package org.tomskgislab.vertex;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import org.apache.log4j.WriterAppender;
import org.apache.log4j.spi.LoggingEvent;

//import javax.swing.JTextArea;
//import javax.swing.SwingUtilities;
//import org.apache.log4j.Category;
//import org.apache.log4j.Logger;
//import org.tomskgislab.logging.*;

public class TextAreaHandler extends WriterAppender {

	static private TextArea jTextArea = null;

//	static public void setTextArea(JConsole JTextAreaLog) {
//		TextAreaHandler.jTextArea = JTextAreaLog;
//	}
	
	static public void setTextArea(TextArea JTextAreaLog) {
		TextAreaHandler.jTextArea = JTextAreaLog;
	}
	
	public void doAppend(LoggingEvent arg0) {
		final String message = arg0.getMessage().toString() + "\n";
//		final Color color;
//		if (arg0.getLevel() == Level.ERROR) {
//			color = Color.RED;
//		} else {
//			color = Color.BLUE;
//		}

		Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // jTextArea.append(message + "\n");
                if (jTextArea != null) {
                    jTextArea.insertText(jTextArea.getCaretPosition(), message);
                    jTextArea.end();
                }
            }
        });
	}

}
