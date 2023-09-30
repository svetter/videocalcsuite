package vcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static vcs.Helper.AUTHOR_STRING;



/**
 * @version 1.2, 2023-09-30
 * @author Simon Vetter
 */
public class BitrateConverter extends JFrame {
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
	
	public static final int		K1_Y_OFFSET		= LINE_HEIGHT * 1/4 - K_HEIGHT / 2 - 2;
	public static final int		K2_Y_OFFSET		= LINE_HEIGHT * 3/4 - K_HEIGHT / 2 + 2;
	public static final int		SLASH_Y_OFFSET	= LINE_HEIGHT / 2 - 24;
	
	
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
	
	
	
	private final JLabel			titleLabel				= new JLabel();
	private final JTextField		inputRateTextfield		= new JTextField();
	private final JComboBox<String>	inputSizeUnitCombobox	= new JComboBox<>();
	private final JRadioButton		inputK1024Radiobutton	= new JRadioButton();
	private final JRadioButton		inputK1000Radiobutton	= new JRadioButton();
	private final ButtonGroup		inputKButtongroup		= new ButtonGroup();
	private final JSeparator		hSeparator				= new JSeparator();
	private final JTextField		resultRateTextfield		= new JTextField();
	private final JComboBox<String>	resultSizeUnitCombobox	= new JComboBox<>();
	private final JRadioButton		resultK1024Radiobutton	= new JRadioButton();
	private final JRadioButton		resultK1000Radiobutton	= new JRadioButton();
	private final ButtonGroup		resultKButtongroup		= new ButtonGroup();
	private final JComboBox<String>	inputTimeUnitCombobox	= new JComboBox<>();
	private final JComboBox<String>	resultTimeUnitCombobo	= new JComboBox<>();
	private final JLabel			inputSlashLabel			= new JLabel();
	private final JLabel			resultSlashLabel		= new JLabel();
	
	
	public BitrateConverter(JFrame parent) {
		super("Bitrate Converter");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		
		titleLabel.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		titleLabel.setText("Bitrate Converter");
		titleLabel.setToolTipText(AUTHOR_STRING);
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		titleLabel.setEnabled(true);
		container.add(titleLabel);
		
		inputRateTextfield.setBounds(FIELD_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		inputRateTextfield.setText("");
		inputRateTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		inputRateTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(inputRateTextfield, false);
				calculate();
			}
		});
		container.add(inputRateTextfield);
		
		inputSizeUnitCombobox.setBounds(SIZE_UNIT_X, LINE1_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		inputSizeUnitCombobox
				.setModel(new DefaultComboBoxModel<>(new String[]{"b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB"}));
		inputSizeUnitCombobox.setSelectedIndex(1);
		inputSizeUnitCombobox.setMaximumRowCount(8);
		inputSizeUnitCombobox.setFont(new Font("Dialog", Font.PLAIN, 16));
		inputSizeUnitCombobox.setEditable(false);
		inputSizeUnitCombobox.addActionListener(evt -> calculate());
		container.add(inputSizeUnitCombobox);
		
		inputK1024Radiobutton.setBounds(K_X, LINE1_K1_Y, K_WIDTH, K_HEIGHT);
		inputK1024Radiobutton.setText("K = 1024");
		inputK1024Radiobutton.setSelected(true);
		inputK1024Radiobutton.addActionListener(evt -> calculate());
		container.add(inputK1024Radiobutton);
		
		inputK1000Radiobutton.setBounds(K_X, LINE1_K2_Y, K_WIDTH, K_HEIGHT);
		inputK1000Radiobutton.setText("K = 1000");
		inputK1000Radiobutton.addActionListener(evt -> calculate());
		container.add(inputK1000Radiobutton);
		
		inputKButtongroup.add(inputK1024Radiobutton);
		inputKButtongroup.add(inputK1000Radiobutton);
		
		hSeparator.setBounds(EDGE, SEP_Y, SEP_WIDTH, 1);
		container.add(hSeparator);
		
		resultRateTextfield.setBounds(EDGE, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		resultRateTextfield.setText("0");
		resultRateTextfield.setEditable(false);
		resultRateTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultRateTextfield.setSelectionEnd(0);
		resultRateTextfield.setSelectionStart(0);
		container.add(resultRateTextfield);
		
		resultSizeUnitCombobox.setBounds(SIZE_UNIT_X, LINE2_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		resultSizeUnitCombobox.setEditable(false);
		resultSizeUnitCombobox.setFont(new Font("Dialog", Font.PLAIN, 16));
		resultSizeUnitCombobox.setMaximumRowCount(8);
		resultSizeUnitCombobox
				.setModel(new DefaultComboBoxModel<>(new String[]{"b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB"}));
		resultSizeUnitCombobox.setSelectedIndex(1);
		resultSizeUnitCombobox.addActionListener(evt -> calculate());
		container.add(resultSizeUnitCombobox);
		
		resultK1024Radiobutton.setBounds(K_X, LINE2_K1_Y, K_WIDTH, K_HEIGHT);
		resultK1024Radiobutton.setText("K = 1024");
		resultK1024Radiobutton.setSelected(true);
		resultK1024Radiobutton.addActionListener(evt -> calculate());
		container.add(resultK1024Radiobutton);
		
		resultK1000Radiobutton.setBounds(K_X, LINE2_K2_Y, K_WIDTH, K_HEIGHT);
		resultK1000Radiobutton.setText("K = 1000");
		resultK1000Radiobutton.addActionListener(evt -> calculate());
		container.add(resultK1000Radiobutton);
		
		resultKButtongroup.add(resultK1024Radiobutton);
		resultKButtongroup.add(resultK1000Radiobutton);
		inputTimeUnitCombobox.setBounds(TIME_UNIT_X, LINE1_Y, TIME_UNIT_WIDTH, LINE_HEIGHT);
		inputTimeUnitCombobox.setModel(new DefaultComboBoxModel<>(new String[]{"s", "min", "h", "d"}));
		inputTimeUnitCombobox.setSelectedIndex(0);
		inputTimeUnitCombobox.setEditable(false);
		inputTimeUnitCombobox.setFont(new Font("Dialog", Font.PLAIN, 16));
		inputTimeUnitCombobox.setMaximumRowCount(4);
		inputTimeUnitCombobox.addActionListener(evt -> calculate());
		container.add(inputTimeUnitCombobox);
		
		resultTimeUnitCombobo.setBounds(TIME_UNIT_X, LINE2_Y, TIME_UNIT_WIDTH, LINE_HEIGHT);
		resultTimeUnitCombobo.setModel(new DefaultComboBoxModel<>(new String[]{"s", "min", "h", "d"}));
		resultTimeUnitCombobo.setEditable(false);
		resultTimeUnitCombobo.setFont(new Font("Dialog", Font.PLAIN, 16));
		resultTimeUnitCombobo.setMaximumRowCount(4);
		resultTimeUnitCombobo.addActionListener(evt -> calculate());
		container.add(resultTimeUnitCombobo);
		
		inputSlashLabel.setBounds(SLASH_X, LINE1_SLASH_Y, SLASH_WIDTH, SLASH_HEIGHT);
		inputSlashLabel.setText("/");
		inputSlashLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
		inputSlashLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inputSlashLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(inputSlashLabel);
		
		resultSlashLabel.setBounds(SLASH_X, LINE2_SLASH_Y, SLASH_WIDTH, SLASH_HEIGHT);
		resultSlashLabel.setText("/");
		resultSlashLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
		resultSlashLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultSlashLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(resultSlashLabel);
		
		
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
		double check = Double.parseDouble(inputRateTextfield.getText());
		if (!(check > 0.)) {
			resultRateTextfield.setText("0");
			return;
		}
		
		BigDecimal value;
		value = BigDecimal.valueOf(Double.parseDouble(inputRateTextfield.getText()));
		
		long[] sizeToBits;
		long[] sizeToUnit;
		if (Objects.equals(getSelectedRadioButton(inputKButtongroup), "K = 1000")) {
			sizeToBits = new long[] { 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
		} else {
			sizeToBits = new long[] { 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
		}
		if (Objects.equals(getSelectedRadioButton(resultKButtongroup), "K = 1000")) {
			sizeToUnit = new long[] { 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
		} else {
			sizeToUnit = new long[] { 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
		}
		int[] timeConversion = { 1, 60, 3600, 86400 };
		
		value = value.multiply(BigDecimal.valueOf(sizeToBits[inputSizeUnitCombobox.getSelectedIndex()]
				* (long) timeConversion[resultTimeUnitCombobo.getSelectedIndex()]));
		value = value.divide(BigDecimal.valueOf(sizeToUnit[resultSizeUnitCombobox.getSelectedIndex()]
				* (long) timeConversion[inputTimeUnitCombobox.getSelectedIndex()]), 4, RoundingMode.HALF_UP);
		
		String valueString = value.toString();
		if (valueString.endsWith(".0000")) {
			valueString = valueString.split("\\.", 0)[0];
		}
		resultRateTextfield.setText(valueString);
	}
	
	public void setTooltips() {
		inputRateTextfield.setToolTipText("Enter the bitrate you want to convert here");
		inputSizeUnitCombobox.setToolTipText("Select the unit for the given bitrate");
		inputTimeUnitCombobox.setToolTipText("Select the unit for the given bitrate");
		inputK1024Radiobutton.setToolTipText("1 MB = 1024 B");
		inputK1000Radiobutton.setToolTipText("1 MB = 1000 B");
		resultSizeUnitCombobox.setToolTipText("Select the unit for the result");
		resultTimeUnitCombobo.setToolTipText("Select the unit for the result");
		resultK1024Radiobutton.setToolTipText("1 MB = 1024 B");
		resultK1000Radiobutton.setToolTipText("1 MB = 1000 B");
	}
	
	
	
	public static void main(String[] args) {
		new BitrateConverter(null);
	}
}