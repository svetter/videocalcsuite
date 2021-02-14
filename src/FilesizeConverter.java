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
public class FilesizeConverter extends JFrame {
	private static final long serialVersionUID = 6486945827165495064L;
	
	
	public static final int		WIDTH			= 400;
	
	
	public static final int		UNIT_WIDTH		= 60;
	public static final int		K_WIDTH			= 80;
	
	public static final int		TITLE_HEIGHT	= 55;
	public static final int		LINE_HEIGHT		= 35;
	public static final int		K_HEIGHT		= 20;
	
	public static final int		TITLE_GAP		= 5;
	public static final int		EDGE			= 15;
	public static final int		GAP				= 15;
	public static final int		FIELD_UNIT_GAP	= 10;
	public static final int		UNIT_K_GAP		= 10;
	
	public static final int		K1_Y_OFFSET		= LINE_HEIGHT*1/4 - K_HEIGHT/2 - 2;
	public static final int		K2_Y_OFFSET		= LINE_HEIGHT*3/4 - K_HEIGHT/2 + 2;
	
	
	public static final int		FIELD_X			= EDGE;
	public static final int		K_X				= WIDTH - EDGE - K_WIDTH + 10;
	public static final int		UNIT_X			= K_X - UNIT_K_GAP - UNIT_WIDTH;
	public static final int		FIELD_WIDTH		= UNIT_X - FIELD_UNIT_GAP - FIELD_X;
	
	public static final int		SEP_WIDTH		= WIDTH - EDGE*2;
	
	public static final int		LINE1_Y			= TITLE_HEIGHT + TITLE_GAP;
	public static final int		SEP_Y			= LINE1_Y + LINE_HEIGHT + GAP;
	public static final int		LINE2_Y			= SEP_Y + GAP;

	public static final int		LINE1_K1_Y		= LINE1_Y + K1_Y_OFFSET;
	public static final int		LINE1_K2_Y		= LINE1_Y + K2_Y_OFFSET;
	public static final int		LINE2_K1_Y		= LINE2_Y + K1_Y_OFFSET;
	public static final int		LINE2_K2_Y		= LINE2_Y + K2_Y_OFFSET;
	
	
	public static final int		HEIGHT			= LINE2_Y + LINE_HEIGHT + EDGE;
	
	
	
	private JLabel				Text_Title		= new JLabel();
	private JTextField			Size_given		= new JTextField();
	private JComboBox<String>	Unit_given		= new JComboBox<String>();
	private JRadioButton		K_given_1024	= new JRadioButton();
	private JRadioButton		K_given_1000	= new JRadioButton();
	private ButtonGroup			K_given			= new ButtonGroup();
	private JSeparator			horizontalLine	= new JSeparator();
	private JTextField			Size_wanted		= new JTextField();
	private JComboBox<String>	Unit_wanted		= new JComboBox<String>();
	private JRadioButton		K_wanted_1024	= new JRadioButton();
	private JRadioButton		K_wanted_1000	= new JRadioButton();
	private ButtonGroup			K_wanted		= new ButtonGroup();
	
	
	public FilesizeConverter(JFrame parent) {
		super("Filesize Converter");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		Text_Title.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		Text_Title.setText("Filesize Converter");
		Text_Title.setToolTipText("v1.1 © Simon Vetter 2021");
		Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
		Text_Title.setEnabled(true);
		container.add(Text_Title);
		
		Size_given.setBounds(EDGE, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		Size_given.setText("");
		Size_given.setFont(new Font("Dialog", Font.PLAIN, 18));
		Size_given.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Size_given, false);
				calculate();
			}
		});
		container.add(Size_given);
		
		Unit_given.setBounds(UNIT_X, LINE1_Y, UNIT_WIDTH, LINE_HEIGHT);
		Unit_given.setModel(
				new DefaultComboBoxModel<String>(new String[] { "B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb" }));
		Unit_given.setSelectedIndex(2);
		Unit_given.setMaximumRowCount(10);
		Unit_given.setFont(new Font("Dialog", Font.PLAIN, 16));
		Unit_given.setEditable(false);
		Unit_given.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Unit_given);
		
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
		
		horizontalLine.setBounds(FIELD_X, SEP_Y, SEP_WIDTH, 1);
		container.add(horizontalLine);
		
		Size_wanted.setBounds(EDGE, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		Size_wanted.setText("0");
		Size_wanted.setEditable(false);
		Size_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
		Size_wanted.setSelectionEnd(0);
		Size_wanted.setSelectionStart(0);
		container.add(Size_wanted);
		
		Unit_wanted.setBounds(UNIT_X, LINE2_Y, UNIT_WIDTH, LINE_HEIGHT);
		Unit_wanted.setEditable(false);
		Unit_wanted.setFont(new Font("Dialog", Font.PLAIN, 16));
		Unit_wanted.setMaximumRowCount(10);
		Unit_wanted.setModel(
				new DefaultComboBoxModel<String>(new String[] { "B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb" }));
		Unit_wanted.setSelectedIndex(2);
		Unit_wanted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Unit_wanted);
		
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
		double check;
		try {
			check = Double.parseDouble(Size_given.getText());
		} catch (java.lang.NumberFormatException e) {
			Size_wanted.setText("0");
			return;
		}
		if (!(check > 0.)) {
			Size_wanted.setText("0");
			return;
		}

		BigDecimal value = new BigDecimal(8);
		value = BigDecimal.valueOf(Double.parseDouble(Size_given.getText()));

		long[] toBits = new long[10], toUnit = new long[10];
		if (getSelectedRadioButton(K_given).equals("K = 1000")) {
			long[] temp = { 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L,
					1000000000L };
			toBits = temp;
		} else {
			long[] temp = { 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L,
					1073741824L };
			toBits = temp;
		}
		if (getSelectedRadioButton(K_wanted).equals("K = 1000")) {
			long[] temp = { 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L,
					1000000000L };
			toUnit = temp;
		} else {
			long[] temp = { 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L,
					1073741824L };
			toUnit = temp;
		}

		value = value.multiply(BigDecimal.valueOf(toBits[Unit_given.getSelectedIndex()]));
		value = value.divide(BigDecimal.valueOf(toUnit[Unit_wanted.getSelectedIndex()]), 4, RoundingMode.HALF_UP);

		String valueString = value.toString();
		if (valueString.endsWith(".0000")) {
			valueString = valueString.split("\\.", 0)[0];
		}
		Size_wanted.setText(valueString);
	}
	
	private void setTooltips() {
		Size_given.setToolTipText("Enter the filesize you want to convert here");
		Unit_given.setToolTipText("Select the unit for the given filesize");
		K_given_1024.setToolTipText("1 MB = 1024 B");
		K_given_1000.setToolTipText("1 MB = 1000 B");
		Unit_wanted.setToolTipText("Select the unit for your result");
		K_wanted_1024.setToolTipText("1 MB = 1024 B");
		K_wanted_1000.setToolTipText("1 MB = 1000 B");
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		new FilesizeConverter(null);
		
	}
}