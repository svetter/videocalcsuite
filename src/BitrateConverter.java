package vcs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.math.RoundingMode;



/**
 * @version 1.1, 13.02.2021
 * @author Simon Vetter
 */
public class BitrateConverter extends JFrame {
	private static final long serialVersionUID = -2220702801283818182L;
	
	
	public static final int		WIDTH			= 400;
	
	
	public static final int		SIZE_UNIT_WIDTH	= 60;
	public static final int		TIME_UNIT_WIDTH	= 50;
	public static final int		SLASH_WIDTH		= 20;
	public static final int		K_WIDTH			= 80;
	
	public static final int		TITLE_HEIGHT	= 55;
	public static final int		LINE_HEIGHT		= 35;
	public static final int		SLASH_HEIGHT	= 50;
	public static final int		K_HEIGHT		= 20;
	
	public static final int		TITLE_GAP		= 5;
	public static final int		EDGE			= 15;
	public static final int		GAP				= 15;
	public static final int		FIELD_UNIT_GAP	= 10;
	public static final int		UNIT_K_GAP		= 10;
	
	public static final int		K1_Y_OFFSET		= LINE_HEIGHT*1/4 - K_HEIGHT/2 - 2;
	public static final int		K2_Y_OFFSET		= LINE_HEIGHT*3/4 - K_HEIGHT/2 + 2;
	public static final int		SLASH_Y_OFFSET	= LINE_HEIGHT/2 - 24;
	
	
	public static final int		FIELD_X			= EDGE;
	public static final int		K_X				= WIDTH - EDGE - K_WIDTH + 10;
	public static final int		TIME_UNIT_X		= K_X - UNIT_K_GAP - TIME_UNIT_WIDTH;
	public static final int		SLASH_X			= TIME_UNIT_X - SLASH_WIDTH;
	public static final int		SIZE_UNIT_X		= SLASH_X - SIZE_UNIT_WIDTH;
	public static final int		FIELD_WIDTH		= SIZE_UNIT_X - FIELD_UNIT_GAP - FIELD_X;
	
	public static final int		SEP_WIDTH		= WIDTH - EDGE*2;
	
	public static final int		LINE1_Y			= TITLE_HEIGHT + TITLE_GAP;
	public static final int		SEP_Y			= LINE1_Y + LINE_HEIGHT + GAP;
	public static final int		LINE2_Y			= SEP_Y + GAP;

	public static final int		LINE1_K1_Y		= LINE1_Y + K1_Y_OFFSET;
	public static final int		LINE1_K2_Y		= LINE1_Y + K2_Y_OFFSET;
	public static final int		LINE2_K1_Y		= LINE2_Y + K1_Y_OFFSET;
	public static final int		LINE2_K2_Y		= LINE2_Y + K2_Y_OFFSET;
	public static final int		LINE1_SLASH_Y	= LINE1_Y + SLASH_Y_OFFSET;
	public static final int		LINE2_SLASH_Y	= LINE2_Y + SLASH_Y_OFFSET;
	
	
	public static final int		HEIGHT			= LINE2_Y + LINE_HEIGHT + EDGE;
	
	
	
	private JLabel				Text_Title			= new JLabel();
	private JTextField			Rate_given			= new JTextField();
	private JComboBox<String>	Unit_Size_given		= new JComboBox<String>();
	private JRadioButton		K_given_1024		= new JRadioButton();
	private JRadioButton		K_given_1000		= new JRadioButton();
	private ButtonGroup			K_given				= new ButtonGroup();
	private JSeparator			horizontalLine		= new JSeparator();
	private JTextField			Rate_wanted			= new JTextField();
	private JComboBox<String>	Unit_Size_wanted	= new JComboBox<String>();
	private JRadioButton		K_wanted_1024		= new JRadioButton();
	private JRadioButton		K_wanted_1000		= new JRadioButton();
	private ButtonGroup			K_wanted			= new ButtonGroup();
	private JComboBox<String>	Unit_Time_given		= new JComboBox<String>();
	private JComboBox<String>	Unit_Time_wanted	= new JComboBox<String>();
	private JLabel				Text_Slash1			= new JLabel();
	private JLabel				Text_Slash2			= new JLabel();
	
	
	public BitrateConverter(JFrame parent) {
		super("Bitrate Converter");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		
		Text_Title.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		Text_Title.setText("Bitrate Converter");
		Text_Title.setToolTipText("v1.1 © Simon Vetter 2021");
		Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
		Text_Title.setEnabled(true);
		container.add(Text_Title);
		
		Rate_given.setBounds(FIELD_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		Rate_given.setText("");
		Rate_given.setFont(new Font("Dialog", Font.PLAIN, 18));
		Rate_given.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Rate_given, false);
				calculate();
			}
		});
		container.add(Rate_given);
		
		Unit_Size_given.setBounds(SIZE_UNIT_X, LINE1_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		Unit_Size_given
				.setModel(new DefaultComboBoxModel<String>(new String[] { "b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB" }));
		Unit_Size_given.setSelectedIndex(1);
		Unit_Size_given.setMaximumRowCount(8);
		Unit_Size_given.setFont(new Font("Dialog", Font.PLAIN, 16));
		Unit_Size_given.setEditable(false);
		Unit_Size_given.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Unit_Size_given);
		
		K_given_1024.setBounds(K_X, LINE1_K1_Y, K_WIDTH, K_HEIGHT);
		K_given_1024.setText("K = 1024");
		K_given_1024.setSelected(true);
		K_given_1024.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(K_given_1024);
		
		K_given_1000.setBounds(K_X, LINE1_K2_Y, K_WIDTH, K_HEIGHT);
		K_given_1000.setText("K = 1000");
		K_given_1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(K_given_1000);
		
		K_given.add(K_given_1024);
		K_given.add(K_given_1000);
		
		horizontalLine.setBounds(EDGE, SEP_Y, SEP_WIDTH, 1);
		container.add(horizontalLine);
		
		Rate_wanted.setBounds(EDGE, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		Rate_wanted.setText("0");
		Rate_wanted.setEditable(false);
		Rate_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
		Rate_wanted.setSelectionEnd(0);
		Rate_wanted.setSelectionStart(0);
		container.add(Rate_wanted);
		
		Unit_Size_wanted.setBounds(SIZE_UNIT_X, LINE2_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		Unit_Size_wanted.setEditable(false);
		Unit_Size_wanted.setFont(new Font("Dialog", Font.PLAIN, 16));
		Unit_Size_wanted.setMaximumRowCount(8);
		Unit_Size_wanted
				.setModel(new DefaultComboBoxModel<String>(new String[] { "b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB" }));
		Unit_Size_wanted.setSelectedIndex(1);
		Unit_Size_wanted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Unit_Size_wanted);
		
		K_wanted_1024.setBounds(K_X, LINE2_K1_Y, K_WIDTH, K_HEIGHT);
		K_wanted_1024.setText("K = 1024");
		K_wanted_1024.setSelected(true);
		K_wanted_1024.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(K_wanted_1024);
		
		K_wanted_1000.setBounds(K_X, LINE2_K2_Y, K_WIDTH, K_HEIGHT);
		K_wanted_1000.setText("K = 1000");
		K_wanted_1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(K_wanted_1000);
		
		K_wanted.add(K_wanted_1024);
		K_wanted.add(K_wanted_1000);
		Unit_Time_given.setBounds(TIME_UNIT_X, LINE1_Y, TIME_UNIT_WIDTH, LINE_HEIGHT);
		Unit_Time_given.setModel(new DefaultComboBoxModel<String>(new String[] { "s", "min", "h", "d" }));
		Unit_Time_given.setSelectedIndex(0);
		Unit_Time_given.setEditable(false);
		Unit_Time_given.setFont(new Font("Dialog", Font.PLAIN, 16));
		Unit_Time_given.setMaximumRowCount(4);
		Unit_Time_given.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Unit_Time_given);
		
		Unit_Time_wanted.setBounds(TIME_UNIT_X, LINE2_Y, TIME_UNIT_WIDTH, LINE_HEIGHT);
		Unit_Time_wanted.setModel(new DefaultComboBoxModel<String>(new String[] { "s", "min", "h", "d" }));
		Unit_Time_wanted.setEditable(false);
		Unit_Time_wanted.setFont(new Font("Dialog", Font.PLAIN, 16));
		Unit_Time_wanted.setMaximumRowCount(4);
		Unit_Time_wanted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Unit_Time_wanted);
		
		Text_Slash1.setBounds(SLASH_X, LINE1_SLASH_Y, SLASH_WIDTH, SLASH_HEIGHT);
		Text_Slash1.setText("/");
		Text_Slash1.setFont(new Font("Dialog", Font.PLAIN, 40));
		Text_Slash1.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Slash1.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_Slash1);
		
		Text_Slash2.setBounds(SLASH_X, LINE2_SLASH_Y, SLASH_WIDTH, SLASH_HEIGHT);
		Text_Slash2.setText("/");
		Text_Slash2.setFont(new Font("Dialog", Font.PLAIN, 40));
		Text_Slash2.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Slash2.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_Slash2);
		
		
		setTooltips();
		setVisible(true);
	}
	
	
	private String getSelectedRadioButton(ButtonGroup bg) {
		for (java.util.Enumeration<AbstractButton> e = bg.getElements(); e.hasMoreElements();) {
			AbstractButton b = e.nextElement();
			if (b.isSelected())
				return b.getText();
		}
		return null;
	}
	

	private void calculate() {
		double check = Double.parseDouble(Rate_given.getText());
		if (!(check > 0.)) {
			Rate_wanted.setText("0");
			return;
		}
		
		BigDecimal value = new BigDecimal(0);
		value = BigDecimal.valueOf(Double.parseDouble(Rate_given.getText()));

		long[] sizeToBits = new long[10], SizeToUnit = new long[10];
		if (getSelectedRadioButton(K_given).equals("K = 1000")) {
			sizeToBits = new long[] { 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
		} else {
			sizeToBits = new long[] { 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
		}
		if (getSelectedRadioButton(K_wanted).equals("K = 1000")) {
			SizeToUnit = new long[] { 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
		} else {
			SizeToUnit = new long[] { 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
		}
		int[] timeConversion = { 1, 60, 3600, 86400 };
		
		value = value.multiply(BigDecimal.valueOf(sizeToBits[Unit_Size_given.getSelectedIndex()]
				* (long) timeConversion[Unit_Time_wanted.getSelectedIndex()]));
		value = value.divide(BigDecimal.valueOf(SizeToUnit[Unit_Size_wanted.getSelectedIndex()]
				* (long) timeConversion[Unit_Time_given.getSelectedIndex()]), 4, RoundingMode.HALF_UP);
		
		String valueString = value.toString();
		if (valueString.endsWith(".0000")) {
			valueString = valueString.split("\\.", 0)[0];
		}
		Rate_wanted.setText(valueString);
	}
	
	public void setTooltips() {
		Rate_given.setToolTipText("Enter the bitrate you want to convert here");
		Unit_Size_given.setToolTipText("Select the unit for the given bitrate");
		Unit_Time_given.setToolTipText("Select the unit for the given bitrate");
		K_given_1024.setToolTipText("1 MB = 1024 B");
		K_given_1000.setToolTipText("1 MB = 1000 B");
		Unit_Size_wanted.setToolTipText("Select the unit for the result");
		Unit_Time_wanted.setToolTipText("Select the unit for the result");
		K_wanted_1024.setToolTipText("1 MB = 1024 B");
		K_wanted_1000.setToolTipText("1 MB = 1000 B");
	}
	
	
	
	public static void main(String[] args) {
		
		new BitrateConverter(null);
		
	}
	
}