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
public class FilesizeConverter extends JFrame {
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
	
	public static final int		K1_Y_OFFSET		= LINE_HEIGHT * 1/4 - K_HEIGHT / 2 - 2;
	public static final int		K2_Y_OFFSET		= LINE_HEIGHT * 3/4 - K_HEIGHT / 2 + 2;
	
	
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
	
	
	
	private final JLabel			titleLabel				= new JLabel();
	private final JTextField		inputSizeTextfield		= new JTextField();
	private final JComboBox<String>	inputUnitCombobox		= new JComboBox<>();
	private final JRadioButton		inputKRadiobutton		= new JRadioButton();
	private final JRadioButton		inputK1000				= new JRadioButton();
	private final ButtonGroup		inputKButtongroup		= new ButtonGroup();
	private final JSeparator		hSeparator				= new JSeparator();
	private final JTextField		resultSizeTextfield		= new JTextField();
	private final JComboBox<String>	resultUnitCombobox		= new JComboBox<>();
	private final JRadioButton		resultK1024Radiobutton	= new JRadioButton();
	private final JRadioButton		resultK1000Radiobutton	= new JRadioButton();
	private final ButtonGroup		resultKButtongroup		= new ButtonGroup();
	
	
	public FilesizeConverter(JFrame parent) {
		super("Filesize Converter");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		titleLabel.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		titleLabel.setText("Filesize Converter");
		titleLabel.setToolTipText(AUTHOR_STRING);
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		titleLabel.setEnabled(true);
		container.add(titleLabel);
		
		inputSizeTextfield.setBounds(EDGE, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		inputSizeTextfield.setText("");
		inputSizeTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		inputSizeTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		inputSizeTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(inputSizeTextfield, false);
				calculate();
			}
		});
		container.add(inputSizeTextfield);
		
		inputUnitCombobox.setBounds(UNIT_X, LINE1_Y, UNIT_WIDTH, LINE_HEIGHT);
		inputUnitCombobox.setModel(
				new DefaultComboBoxModel<>(new String[]{"B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb"}));
		inputUnitCombobox.setSelectedIndex(2);
		inputUnitCombobox.setMaximumRowCount(10);
		inputUnitCombobox.setFont(new Font("Dialog", Font.PLAIN, 16));
		inputUnitCombobox.setEditable(false);
		inputUnitCombobox.addActionListener(evt -> calculate());
		container.add(inputUnitCombobox);
		
		inputKRadiobutton.setBounds(K_X, LINE1_K1_Y, K_WIDTH, K_HEIGHT);
		inputKRadiobutton.setText("K = 1024");
		inputKRadiobutton.setSelected(true);
		inputKRadiobutton.addActionListener(evt -> calculate());
		container.add(inputKRadiobutton);
		
		inputK1000.setBounds(K_X, LINE1_K2_Y, K_WIDTH, K_HEIGHT);
		inputK1000.setText("K = 1000");
		inputK1000.addActionListener(evt -> calculate());
		container.add(inputK1000);
		
		inputKButtongroup.add(inputKRadiobutton);
		inputKButtongroup.add(inputK1000);
		
		hSeparator.setBounds(FIELD_X, SEP_Y, SEP_WIDTH, 1);
		container.add(hSeparator);
		
		resultSizeTextfield.setBounds(EDGE, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		resultSizeTextfield.setText("0");
		resultSizeTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		resultSizeTextfield.setEditable(false);
		resultSizeTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultSizeTextfield.setSelectionEnd(0);
		resultSizeTextfield.setSelectionStart(0);
		container.add(resultSizeTextfield);
		
		resultUnitCombobox.setBounds(UNIT_X, LINE2_Y, UNIT_WIDTH, LINE_HEIGHT);
		resultUnitCombobox.setEditable(false);
		resultUnitCombobox.setFont(new Font("Dialog", Font.PLAIN, 16));
		resultUnitCombobox.setMaximumRowCount(10);
		resultUnitCombobox.setModel(
				new DefaultComboBoxModel<>(new String[]{"B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb"}));
		resultUnitCombobox.setSelectedIndex(2);
		resultUnitCombobox.addActionListener(evt -> calculate());
		container.add(resultUnitCombobox);
		
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
			check = Double.parseDouble(inputSizeTextfield.getText());
		} catch (java.lang.NumberFormatException e) {
			resultSizeTextfield.setText("0");
			return;
		}
		if (!(check > 0.)) {
			resultSizeTextfield.setText("0");
			return;
		}
		
		BigDecimal value;
		value = BigDecimal.valueOf(Double.parseDouble(inputSizeTextfield.getText()));
		
		long[] toBits;
		long[] toUnit;
		if (Objects.equals(getSelectedRadioButton(inputKButtongroup), "K = 1000")) {
			toBits = new long[]{ 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L };
		} else {
			toBits = new long[]{ 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L };
		}
		if (Objects.equals(getSelectedRadioButton(resultKButtongroup), "K = 1000")) {
			toUnit = new long[]{ 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L };
		} else {
			toUnit = new long[]{ 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L };
		}
		
		value = value.multiply(BigDecimal.valueOf(toBits[inputUnitCombobox.getSelectedIndex()]));
		value = value.divide(BigDecimal.valueOf(toUnit[resultUnitCombobox.getSelectedIndex()]), 4, RoundingMode.HALF_UP);
		
		String valueString = value.toString();
		if (valueString.endsWith(".0000")) {
			valueString = valueString.split("\\.", 0)[0];
		}
		resultSizeTextfield.setText(valueString);
	}
	
	private void setTooltips() {
		inputSizeTextfield		.setToolTipText("Enter the filesize you want to convert here");
		inputUnitCombobox		.setToolTipText("Select the unit for the given filesize");
		inputKRadiobutton		.setToolTipText("1 MB = 1024 B");
		inputK1000				.setToolTipText("1 MB = 1000 B");
		resultUnitCombobox		.setToolTipText("Select the unit for your result");
		resultK1024Radiobutton	.setToolTipText("1 MB = 1024 B");
		resultK1000Radiobutton	.setToolTipText("1 MB = 1000 B");
	}
	
	
	
	public static void main(String[] args) {
		new FilesizeConverter(null);
	}
}