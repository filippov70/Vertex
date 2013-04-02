package org.tomskgislab.vertex.core;

import java.text.DecimalFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Angle {
	private static Logger logger = LogManager.getLogger(Angle.class);
	private String angle;
	private String minute;
	private String rumb;
	private double ang;
	private DecimalFormat fm = new DecimalFormat("0.00");
	private DecimalFormat fa = new DecimalFormat("0");
	
	public Angle (double ddx, double ddy) {
		if (ddx == 0)
        {
            if (ddy < 0)
            {
                rumb = "З: 0°";
                angle = "270°";
                minute = " 0'";
                
            }
            else
            {
            	rumb = "В: 0°";
                angle = "90°";
                minute = " 0'";
            }
        }
        else
        {
            double Alfa = Math.abs((Math.atan(ddy / ddx)) * (180 / Math.PI));

            if (ddx > 0 && ddy > 0)
            {
            	rumb = "CB:";
                ang = Alfa;
                calcDM();
                rumb += calcRumb(rumb);
            }
            else if (ddx < 0 && ddy > 0)
            {
            	rumb = "ЮВ:";
                ang = 180 - Alfa;
                calcDM();
                rumb += calcRumb(rumb);
            }
            else if (ddx < 0 && ddy < 0)
            {
            	rumb = "ЮЗ:";
                ang = 180 + Alfa;
                calcDM();
                rumb += calcRumb(rumb);
            }

            if (ddx > 0 && ddy < 0)
            {
            	rumb = "СЗ:";
                ang = 360 - Alfa;
                calcDM();
                rumb += calcRumb(rumb);
            }

            if (ddx > 0 && ddy == 0)
            {
            	rumb = "С: 0°";
                angle = "0°";
                minute = " 0'";
            }

            if (ddx < 0 && ddy == 0)
            {
            	rumb = "Ю: 0°";
                angle = "180°";
                minute = " 0'";
            }

        }
		rumb = "";
        ang = -1;
	}

	private String calcRumb(String RumbDirect) {
		// Румбы считаются от оси "Север-Юг"!
		switch (RumbDirect) {
		case "CB":
			return fa.format((int)ang) + "°" + minute;

        case "ЮВ":
        	return fa.format(180 - (int)ang) + "°" + minute;

        case "ЮЗ":
            return fa.format(180 + (int)ang) + "°" + minute;

        case "СЗ":
        	return fa.format(360 - (int)ang) + "°" + minute;

        default: return ""; 
		}
	}

	private void calcDM() {
		try {
			int a = (int)ang;
			double min = (ang - a) * 60;
			
			minute = " " + fm.format(min) + "'";
			
			angle = fa.format(a) + "°";
			
		}
		catch (Exception ex) {
			logger.error(ex.getLocalizedMessage());
		}
	}
	
	public String getDirectionalAngle() {
		return angle + minute;
	}
	
	public String getRumb () {
		return rumb;
	}
 }
