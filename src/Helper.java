package vcs;

import javax.swing.*;
import java.awt.*;



/**
 * @version 1.2, 2023-09-30
 * @author Simon Vetter
 */
public class Helper {
	public static final int		WIDTH_CORR		= 16;
	public static final int		HEIGHT_CORR		= 39;
	
	public static final int		WINDOW_GAP		= 20;
	
	
	public static final String	AUTHOR_STRING	= "v1.2 © Simon Vetter 2023";
	
	
	
	protected static void setWindowLocation(JFrame frame, JFrame parent) {
		if (parent == null) {
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int x = (screen.width - VideoCalcSuite.WIDTH) / 2;
			int y = (screen.height - VideoCalcSuite.HEIGHT) / 3;
			
			frame.setLocation(x, y);
			return;
		}
		
		int parentWidth = parent.getWidth() - 14;
		int parentHeight = parent.getHeight() - 7;
		int frameWidth = frame.getWidth() - 14;
		int frameHeight = frame.getHeight() - 7;
		
		int x = parent.getX() + (parentWidth / 2);
		int y = parent.getY() + (parentHeight / 2);
		
		if (frame.getClass() == BitrateGenerator.class) {
			y -= WINDOW_GAP + ((parentHeight + frameHeight) / 2);
		}
		else if (frame.getClass() == FilesizeConverter.class) {
			x -= WINDOW_GAP + ((parentWidth + frameWidth) / 2);
		}
		else if (frame.getClass() == BitrateConverter.class) {
			x += WINDOW_GAP + ((parentWidth + frameWidth) / 2);
		}
		else if (frame.getClass() == TimeCalculator.class) {
			y += WINDOW_GAP + ((parentHeight + frameHeight) / 2);
		}
		
		x -= frameWidth / 2;
		y -= frameHeight / 2;
		
		frame.setLocation(x, y);
	}
	
	protected static void sanitiseField(JTextField field, boolean allowMinus) {
		String text = field.getText().replaceAll("[a-zA-Z]+", "");
		if (!allowMinus) {
			text = text.replaceAll("-", "");
		}
		text = text.replace(',', '.');
		
		if (!text.equals(field.getText())) {
			field.setText(text);
		}
	}
	
	protected static double parseDouble(String text) {
		try {
			return Double.parseDouble(text);
		} catch (NumberFormatException e) {
			return 0.;
		}
	}
}