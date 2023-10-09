/*
 * Copyright 2011, 2021, 2023 Simon Vetter
 *
 * This file is part of VideoCalcSuite.
 *
 * VideoCalcSuite is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * VideoCalcSuite is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with VideoCalcSuite.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package vcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static vcs.Helper.AUTHOR_STRING;



/**
 * @version 1.2, 2023-09-30
 * @author Simon Vetter
 */
public class BitrateGenerator extends JFrame {
	public static final int		WIDTH						= 530;
	
	
	public static final int		TARGET_TEXT_WIDTH			= 110;
	public static final int		TIME_FIELD_WIDTH			= 80;
	public static final int		HOURS_TEXT_WIDTH			= 20;
	public static final int		MINUTES_TEXT_WIDTH			= 35;
	public static final int		SECONDS_TEXT_WIDTH			= 20;
	public static final int		CALCULATE_WIDTH				= 105;
	public static final int		SIZE_UNIT_WIDTH				= 60;
	public static final int		TIME_UNIT_WIDTH				= 55;
	public static final int		K_WIDTH						= 80;
	public static final int		SLASH_WIDTH					= 20;
	public static final int		AUDIO_CHKBOX_WIDTH			= 130;
	public static final int		AUDIO_RATE_TEXT_WIDTH		= 50;
	
	public static final int		TITLE_HEIGHT				= 55;
	public static final int		LINE_HEIGHT					= 35;
	public static final int		TARGET_TEXT_HEIGHT			= 35;
	public static final int		CALCULATE_HEIGHT			= 20;
	public static final int		K_HEIGHT					= 20;
	public static final int		SLASH_HEIGHT				= 50;
	public static final int		AUDIO_LINE_HEIGHT			= 30;
	
	
	public static final int		TITLE_GAP					= 5;
	public static final int		EDGE						= 15;
	public static final int		LINE_GAP					= 10;
	public static final int		TABLE_GAP					= 15;
	public static final int		LEFT_COLUMN_GAP				= 5;
	public static final int		FIELD_UNIT_GAP				= 10;
	public static final int		UNIT_K_GAP					= 10;
	
	
	public static final int		CALCULATE_X_OFFSET			= 5;
	public static final int		FIELD_TEXT_GAP				= 5;
	public static final int		TEXT_FIELD_GAP				= 5;
	
	public static final int		TARGET_TEXT_Y_OFFSET		= TABLE_GAP - 10;
	public static final int		CALCULATE_Y_OFFSET			= 35;
	
	
	public static final int		K1_Y_OFFSET					= LINE_HEIGHT * 1/4 - K_HEIGHT / 2 - 2;
	public static final int		K2_Y_OFFSET					= LINE_HEIGHT * 3/4 - K_HEIGHT / 2 + 2;
	public static final int		SLASH_Y_OFFSET				= LINE_HEIGHT / 2 - 24;
	
	
	public static final int		TABLE_LEFT_X				= EDGE;
	public static final int		TARGET_TEXT_X				= TABLE_LEFT_X + LEFT_COLUMN_GAP;
	public static final int		CALCULATE_X					= TARGET_TEXT_X + CALCULATE_X_OFFSET;
	public static final int		TABLE_MIDDLE_X				= TARGET_TEXT_X + TARGET_TEXT_WIDTH + LEFT_COLUMN_GAP;

	public static final int		FIELD1_X					= TABLE_MIDDLE_X + TABLE_GAP;
	public static final int		HOURS_TEXT_X				= FIELD1_X + TIME_FIELD_WIDTH + FIELD_TEXT_GAP;
	public static final int		FIELD2_X					= HOURS_TEXT_X + HOURS_TEXT_WIDTH + TEXT_FIELD_GAP;
	public static final int		MINUTES_TEXT_X				= FIELD2_X + TIME_FIELD_WIDTH + FIELD_TEXT_GAP;
	public static final int		FIELD3_X					= MINUTES_TEXT_X + MINUTES_TEXT_WIDTH + TEXT_FIELD_GAP;
	public static final int		SECONDS_TEXT_X				= FIELD3_X + TIME_FIELD_WIDTH + FIELD_TEXT_GAP;

	public static final int		TABLE_RIGHT_X				= WIDTH - EDGE;
	public static final int		K_X							= TABLE_RIGHT_X - TABLE_GAP - K_WIDTH + 10;
	public static final int		SIZE_UNIT_X					= K_X - UNIT_K_GAP - SIZE_UNIT_WIDTH;
	public static final int		SIZE_FIELD_WIDTH			= SIZE_UNIT_X - FIELD_UNIT_GAP - FIELD1_X;

	public static final int		RATE_TIME_UNIT_X			= K_X - UNIT_K_GAP - TIME_UNIT_WIDTH;
	public static final int		SLASH_X						= RATE_TIME_UNIT_X - SLASH_WIDTH;
	public static final int		RATE_SIZE_UNIT_X			= SLASH_X - SIZE_UNIT_WIDTH;
	public static final int		RATE_FIELD_WIDTH			= RATE_SIZE_UNIT_X - FIELD_UNIT_GAP - FIELD1_X;
	public static final int		AUDIO_CHKBOX_X				= FIELD1_X;
	public static final int		AUDIO_RATE_TEXT_X			= SLASH_X + 10;
	
	public static final int		TABLE_WIDTH					= TABLE_RIGHT_X - TABLE_LEFT_X;
	
	
	public static final int		TABLE_TOP_Y					= TITLE_HEIGHT + TITLE_GAP;
	public static final int		FILESIZE_TEXT_Y				= TABLE_TOP_Y + TARGET_TEXT_Y_OFFSET;
	public static final int		CALCULATE_SIZE_Y			= FILESIZE_TEXT_Y + CALCULATE_Y_OFFSET;
	public static final int		LINE1_Y						= TABLE_TOP_Y + TABLE_GAP;
	public static final int		TABLE_MID1_Y				= LINE1_Y + LINE_HEIGHT + TABLE_GAP;
	public static final int		LENGTH_TEXT_Y				= TABLE_MID1_Y + TARGET_TEXT_Y_OFFSET;
	public static final int		CALCULATE_LENGTH_Y			= LENGTH_TEXT_Y + CALCULATE_Y_OFFSET;
	public static final int		LINE2_Y						= TABLE_MID1_Y + TABLE_GAP;
	public static final int		TABLE_MID2_Y				= LINE2_Y + LINE_HEIGHT + TABLE_GAP;
	public static final int		LINE3_Y						= TABLE_MID2_Y + TABLE_GAP;
	public static final int		RATE_TEXT_Y					= LINE3_Y;
	public static final int		CALCULATE_RATE_Y			= RATE_TEXT_Y + CALCULATE_Y_OFFSET;
	public static final int		SLASH_Y						= LINE3_Y + SLASH_Y_OFFSET;
	public static final int		LINE4_Y						= LINE3_Y + LINE_HEIGHT + LINE_GAP;
	public static final int		TABLE_BOTTOM_Y				= LINE4_Y + AUDIO_LINE_HEIGHT + TABLE_GAP;
	
	public static final int		LINE1_K1_Y					= LINE1_Y + K1_Y_OFFSET;
	public static final int		LINE1_K2_Y					= LINE1_Y + K2_Y_OFFSET;
	public static final int		LINE3_K1_Y					= LINE3_Y + K1_Y_OFFSET;
	public static final int		LINE3_K2_Y					= LINE3_Y + K2_Y_OFFSET;
	
	public static final int		TABLE_HEIGHT				= TABLE_BOTTOM_Y - TABLE_TOP_Y;
	
	
	public static final int		HEIGHT						= TABLE_BOTTOM_Y + EDGE;
	
	
	
	private final JLabel			titleLabel					= new JLabel();
	
	private final JSeparator		hTopSeparator				= new JSeparator();
	private final JSeparator		hUpperMidSeparator			= new JSeparator();
	private final JSeparator		hLowerMidSeparator			= new JSeparator();
	private final JSeparator		hBottomSeparator			= new JSeparator();
	private final JSeparator		vLeftSeparator				= new JSeparator();
	private final JSeparator		vMidSeparator				= new JSeparator();
	private final JSeparator		vRightSeparator				= new JSeparator();
	
	private final JLabel			filesizeLabel				= new JLabel();
	private final JRadioButton		calcFilesizeRadiobutton		= new JRadioButton();
	private final JTextField 		sizeTextfield				= new JTextField();
	private final JComboBox<String>	sizeFormatCombobox			= new JComboBox<>();
	private final JRadioButton		sizeK1024Radiobutton		= new JRadioButton();
	private final JRadioButton		sizeK1000Radiobutton		= new JRadioButton();
	private final ButtonGroup		sizeKButtongroup			= new ButtonGroup();
	
	private final JCheckBox			bitrateIncludeAudioCheckbox	= new JCheckBox();
	private final JComboBox<String>	bitrateAudioCombobox		= new JComboBox<>();
	private final JLabel			audioBitrateLabel			= new JLabel();
	
	private final JLabel			durationLabel				= new JLabel();
	private final JRadioButton		calcTimeRadiobutton			= new JRadioButton();
	private final JTextField		timeHoursTextfield			= new JTextField();
	private final JLabel			timeHoursLabel				= new JLabel();
	private final JTextField		timeMinutesTextfield		= new JTextField();
	private final JLabel			timeMinutesLabel			= new JLabel();
	private final JTextField		timeSecondsTextfield		= new JTextField();
	private final JLabel			timeSecondsLabel			= new JLabel();
	private final JLabel			bitrateLabel				= new JLabel();
	private final JRadioButton		calcBitrateRadiobutton		= new JRadioButton();
	private final JTextField		bitrateTextfield			= new JTextField();
	private final JComboBox<String>	bitrateFormatSizeCombobox	= new JComboBox<>();
	private final JLabel			bitrateSlashLabel			= new JLabel();
	private final JComboBox<String>	bitrateFormatTimeCombobox	= new JComboBox<>();
	private final JRadioButton		bitrateK1024Radiobutton		= new JRadioButton();
	private final JRadioButton		bitrateK1000Radiobutton		= new JRadioButton();
	
	private final ButtonGroup		bitrateKButtongroup			= new ButtonGroup();
	private final ButtonGroup		calcButtongroup				= new ButtonGroup();
	
	
	public BitrateGenerator(JFrame parent) {
		super("Bitrate Generator");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		titleLabel.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		titleLabel.setText("Bitrate Generator");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setToolTipText(AUTHOR_STRING);
		container.add(titleLabel);
		
		hTopSeparator.setBounds(TABLE_LEFT_X, TABLE_TOP_Y, TABLE_WIDTH + 1, 1);
		container.add(hTopSeparator);
		hUpperMidSeparator.setBounds(TABLE_LEFT_X + 2, TABLE_MID1_Y, TABLE_WIDTH + 1 - 4, 1);
		container.add(hUpperMidSeparator);
		hLowerMidSeparator.setBounds(TABLE_LEFT_X + 2, TABLE_MID2_Y, TABLE_WIDTH + 1 - 4, 1);
		container.add(hLowerMidSeparator);
		hBottomSeparator.setBounds(TABLE_LEFT_X, TABLE_BOTTOM_Y, TABLE_WIDTH + 1, 1);
		container.add(hBottomSeparator);
		
		vLeftSeparator.setBounds(TABLE_LEFT_X, TABLE_TOP_Y, 1, TABLE_HEIGHT + 1);
		vLeftSeparator.setOrientation(SwingConstants.VERTICAL);
		container.add(vLeftSeparator);
		vMidSeparator.setBounds(TABLE_MIDDLE_X, TABLE_TOP_Y + 2, 1, TABLE_HEIGHT + 1 - 4);
		vMidSeparator.setOrientation(SwingConstants.VERTICAL);
		container.add(vMidSeparator);
		vRightSeparator.setBounds(TABLE_RIGHT_X, TABLE_TOP_Y, 1, TABLE_HEIGHT + 1);
		vRightSeparator.setOrientation(SwingConstants.VERTICAL);
		container.add(vRightSeparator);
		
		filesizeLabel.setBounds(TARGET_TEXT_X, FILESIZE_TEXT_Y, TARGET_TEXT_WIDTH, TARGET_TEXT_HEIGHT);
		filesizeLabel.setText("Filesize");
		filesizeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		filesizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		filesizeLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(filesizeLabel);
		calcFilesizeRadiobutton.setBounds(CALCULATE_X, CALCULATE_SIZE_Y, CALCULATE_WIDTH, CALCULATE_HEIGHT);
		calcFilesizeRadiobutton.setText("calculate this");
		calcFilesizeRadiobutton.addActionListener(evt -> {
			setEditable(false, true, true);
			calculate();
		});
		container.add(calcFilesizeRadiobutton);
		sizeTextfield.setBounds(FIELD1_X, LINE1_Y, SIZE_FIELD_WIDTH, LINE_HEIGHT);
		sizeTextfield.setText("");
		sizeTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		sizeTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		sizeTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(sizeTextfield, false);
				calculate();
			}
		});
		container.add(sizeTextfield);
		sizeFormatCombobox.setBounds(SIZE_UNIT_X, LINE1_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		sizeFormatCombobox.setModel(
				new DefaultComboBoxModel<>(new String[]{"B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb"}));
		sizeFormatCombobox.setFont(new Font("Dialog", Font.PLAIN, 18));
		sizeFormatCombobox.setSelectedIndex(2);
		sizeFormatCombobox.addActionListener(evt -> calculate());
		sizeFormatCombobox.setMaximumRowCount(10);
		container.add(sizeFormatCombobox);
		sizeK1024Radiobutton.setBounds(K_X, LINE1_K1_Y, K_WIDTH, K_HEIGHT);
		sizeK1024Radiobutton.setText("K = 1024");
		sizeK1024Radiobutton.setSelected(true);
		sizeK1024Radiobutton.addActionListener(evt -> calculate());
		container.add(sizeK1024Radiobutton);
		sizeK1000Radiobutton.setBounds(K_X, LINE1_K2_Y, K_WIDTH, K_HEIGHT);
		sizeK1000Radiobutton.setText("K = 1000");
		sizeK1000Radiobutton.addActionListener(evt -> calculate());
		container.add(sizeK1000Radiobutton);
		sizeKButtongroup.add(sizeK1024Radiobutton);
		sizeKButtongroup.add(sizeK1000Radiobutton);
		
		bitrateIncludeAudioCheckbox.setBounds(AUDIO_CHKBOX_X, LINE4_Y, AUDIO_CHKBOX_WIDTH, AUDIO_LINE_HEIGHT);
		bitrateIncludeAudioCheckbox.setText(" Audio stream:");
		bitrateIncludeAudioCheckbox.setFont(new Font("Dialog", Font.PLAIN, 16));
		bitrateIncludeAudioCheckbox.addActionListener(this::Bitrate_includeAudio_ActionPerformed);
		container.add(bitrateIncludeAudioCheckbox);
		bitrateAudioCombobox.setBounds(RATE_SIZE_UNIT_X, LINE4_Y, SIZE_UNIT_WIDTH, AUDIO_LINE_HEIGHT);
		bitrateAudioCombobox.setEditable(false);
		bitrateAudioCombobox.setModel(new DefaultComboBoxModel<>(new String[]{"20", "24", "32", "48", "56", "64", "80",
				"96", "112", "128", "160", "192", "224", "256", "320", "350", "384"}));
		bitrateAudioCombobox.setSelectedIndex(13);
		bitrateAudioCombobox.setEnabled(false);
		bitrateAudioCombobox.setFont(new Font("Dialog", Font.PLAIN, 16));
		bitrateAudioCombobox.addActionListener(evt -> calculate());
		container.add(bitrateAudioCombobox);
		audioBitrateLabel.setBounds(AUDIO_RATE_TEXT_X, LINE4_Y, AUDIO_RATE_TEXT_WIDTH, AUDIO_LINE_HEIGHT);
		audioBitrateLabel.setText("Kbit/s");
		audioBitrateLabel.setEnabled(false);
		audioBitrateLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(audioBitrateLabel);
		durationLabel.setBounds(TARGET_TEXT_X, LENGTH_TEXT_Y, TARGET_TEXT_WIDTH, TARGET_TEXT_HEIGHT);
		durationLabel.setText("Length");
		durationLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		durationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		durationLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(durationLabel);
		calcTimeRadiobutton.setBounds(CALCULATE_X, CALCULATE_LENGTH_Y, CALCULATE_WIDTH, CALCULATE_HEIGHT);
		calcTimeRadiobutton.setText("calculate this");
		calcTimeRadiobutton.addActionListener(evt -> {
			setEditable(true, false, true);
			calculate();
		});
		container.add(calcTimeRadiobutton);
		timeHoursTextfield.setBounds(FIELD1_X, LINE2_Y, TIME_FIELD_WIDTH, LINE_HEIGHT);
		timeHoursTextfield.setText("");
		timeHoursTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		timeHoursTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		timeHoursTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(timeHoursTextfield, false);
				calculate();
			}
		});
		container.add(timeHoursTextfield);
		timeHoursLabel.setBounds(HOURS_TEXT_X, LINE2_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		timeHoursLabel.setText("h");
		timeHoursLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		timeHoursLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(timeHoursLabel);
		timeMinutesTextfield.setBounds(FIELD2_X, LINE2_Y, TIME_FIELD_WIDTH, LINE_HEIGHT);
		timeMinutesTextfield.setText("");
		timeMinutesTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		timeMinutesTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		timeMinutesTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(timeMinutesTextfield, false);
				calculate();
			}
		});
		container.add(timeMinutesTextfield);
		timeMinutesLabel.setBounds(MINUTES_TEXT_X, LINE2_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		timeMinutesLabel.setText("min");
		timeMinutesLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(timeMinutesLabel);
		timeSecondsTextfield.setBounds(FIELD3_X, LINE2_Y, TIME_FIELD_WIDTH, LINE_HEIGHT);
		timeSecondsTextfield.setText("");
		timeSecondsTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		timeSecondsTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		timeSecondsTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(timeSecondsTextfield, false);
				calculate();
			}
		});
		container.add(timeSecondsTextfield);
		timeSecondsLabel.setBounds(SECONDS_TEXT_X, LINE2_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		timeSecondsLabel.setText("s");
		timeSecondsLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(timeSecondsLabel);
		bitrateLabel.setBounds(TARGET_TEXT_X, RATE_TEXT_Y, TARGET_TEXT_WIDTH, TARGET_TEXT_HEIGHT);
		bitrateLabel.setText("Bitrate");
		bitrateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bitrateLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		bitrateLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(bitrateLabel);
		calcBitrateRadiobutton.setBounds(CALCULATE_X, CALCULATE_RATE_Y, CALCULATE_WIDTH, CALCULATE_HEIGHT);
		calcBitrateRadiobutton.setText("calculate this");
		calcBitrateRadiobutton.setSelected(true);
		calcBitrateRadiobutton.addActionListener(evt -> {
			setEditable(true, true, false);
			calculate();
		});
		container.add(calcBitrateRadiobutton);
		bitrateTextfield.setBounds(FIELD1_X, LINE3_Y, RATE_FIELD_WIDTH, LINE_HEIGHT);
		bitrateTextfield.setText("");
		bitrateTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		bitrateTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		bitrateTextfield.setEnabled(true);
		bitrateTextfield.setEditable(false);
		bitrateTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(bitrateTextfield, false);
				calculate();
			}
		});
		container.add(bitrateTextfield);
		bitrateFormatSizeCombobox.setBounds(RATE_SIZE_UNIT_X, LINE3_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		bitrateFormatSizeCombobox.setFont(new Font("Dialog", Font.PLAIN, 18));
		bitrateFormatSizeCombobox
				.setModel(new DefaultComboBoxModel<>(new String[]{"b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB"}));
		bitrateFormatSizeCombobox.setSelectedIndex(1);
		bitrateFormatSizeCombobox.addActionListener(evt -> calculate());
		container.add(bitrateFormatSizeCombobox);
		bitrateSlashLabel.setBounds(SLASH_X, SLASH_Y, SLASH_WIDTH, SLASH_HEIGHT);
		bitrateSlashLabel.setText("/");
		bitrateSlashLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
		bitrateSlashLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bitrateSlashLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(bitrateSlashLabel);
		bitrateFormatTimeCombobox.setBounds(RATE_TIME_UNIT_X, LINE3_Y, TIME_UNIT_WIDTH, LINE_HEIGHT);
		bitrateFormatTimeCombobox.setFont(new Font("Dialog", Font.PLAIN, 18));
		bitrateFormatTimeCombobox.setModel(new DefaultComboBoxModel<>(new String[]{"s", "min", "h", "d"}));
		bitrateFormatTimeCombobox.setMaximumRowCount(4);
		bitrateFormatTimeCombobox.addActionListener(evt -> calculate());
		container.add(bitrateFormatTimeCombobox);
		bitrateK1024Radiobutton.setBounds(K_X, LINE3_K1_Y, K_WIDTH, K_HEIGHT);
		bitrateK1024Radiobutton.setText("K = 1024");
		bitrateK1024Radiobutton.setSelected(true);
		bitrateK1024Radiobutton.addActionListener(evt -> calculate());
		container.add(bitrateK1024Radiobutton);
		bitrateK1000Radiobutton.setBounds(K_X, LINE3_K2_Y, K_WIDTH, K_HEIGHT);
		bitrateK1000Radiobutton.setText("K = 1000");
		bitrateK1000Radiobutton.addActionListener(evt -> calculate());
		container.add(bitrateK1000Radiobutton);
		
		bitrateKButtongroup.add(bitrateK1024Radiobutton);
		bitrateKButtongroup.add(bitrateK1000Radiobutton);
		calcButtongroup.add(calcFilesizeRadiobutton);
		calcButtongroup.add(calcTimeRadiobutton);
		calcButtongroup.add(calcBitrateRadiobutton);
		
		
		setTooltips();
		setVisible(true);
	}
	
	
	
	private void calculate() {
		if (calcFilesizeRadiobutton.isSelected()) {
			calculateFilesize();
			return;
		} else if (calcTimeRadiobutton.isSelected()) {
			calculateLength();
			return;
		} else if (calcBitrateRadiobutton.isSelected()) {
			calculateBitrate();
			return;
		}
		calculateBitrate();
	}
	
	private void calculateFilesize() {
		BigDecimal seconds = getLength();
		BigDecimal bitsPerSecond = getBitrate();
		BigDecimal result = bitsPerSecond.multiply(seconds);
		printFilesize(result);
	}
	
	private void calculateLength() {
		BigDecimal bits = getFilesize();
		BigDecimal bitsPerSecond = getBitrate();
		BigDecimal result;
		try {
			result = bits.divide(bitsPerSecond, 2, RoundingMode.HALF_UP);
		} catch (Exception e) {
			result = new BigDecimal(0);
		}
		printLength(result);
	}
	
	private void calculateBitrate() {
		BigDecimal bits = getFilesize();
		BigDecimal seconds = getLength();
		BigDecimal result;
		try {
			result = bits.divide(seconds, 0, RoundingMode.HALF_UP);
		} catch (Exception e) {
			result = new BigDecimal(0);
		}
		printBitrate(result);
	}
	
	private BigDecimal getFilesize() {
		BigDecimal bits;
		try {
			bits = BigDecimal.valueOf(Double.parseDouble(sizeTextfield.getText()));
		} catch (NumberFormatException e) {
			bits = new BigDecimal(0);
		}
		long[] toBits;
		if (sizeK1000Radiobutton.isSelected()) {
			toBits = new long[]{ 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L };
		} else {
			toBits = new long[]{ 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L };
		}
		bits = bits.multiply(BigDecimal.valueOf(toBits[sizeFormatCombobox.getSelectedIndex()]));
		return bits;
	}
	
	private BigDecimal getLength() {
		BigDecimal seconds, minutes, hours;
		try {
			seconds = BigDecimal.valueOf(Helper.parseDouble(timeSecondsTextfield.getText()));
		} catch (NumberFormatException e) {
			seconds = new BigDecimal(0);
		}
		try {
			minutes = BigDecimal.valueOf(Helper.parseDouble(timeMinutesTextfield.getText()));
		} catch (NumberFormatException e) {
			minutes = new BigDecimal(0);
		}
		try {
			hours = BigDecimal.valueOf(Helper.parseDouble(timeHoursTextfield.getText()));
		} catch (NumberFormatException e) {
			hours = new BigDecimal(0);
		}
		seconds = seconds.add(minutes.multiply(new BigDecimal(60)));
		seconds = seconds.add(hours.multiply(new BigDecimal(3600)));
		return seconds;
	}
	
	private BigDecimal getBitrate() {
		BigDecimal bitsPerSecond;
		try {
			bitsPerSecond = BigDecimal.valueOf(Helper.parseDouble(bitrateTextfield.getText()));
		} catch (NumberFormatException e) {
			bitsPerSecond = new BigDecimal(0);
		}
		long[] toBPS;
		if (bitrateK1000Radiobutton.isSelected()) {
			toBPS = new long[]{ 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
		} else {
			toBPS = new long[]{ 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
		}
		int[] TimeConversion = { 1, 60, 3600, 86400 };
		bitsPerSecond = bitsPerSecond.multiply(BigDecimal.valueOf(toBPS[bitrateFormatSizeCombobox.getSelectedIndex()]));
		bitsPerSecond = bitsPerSecond.divide(
				BigDecimal.valueOf(TimeConversion[bitrateFormatTimeCombobox.getSelectedIndex()]), 0,
				RoundingMode.HALF_UP);
		if (bitrateIncludeAudioCheckbox.isSelected()) {
			bitsPerSecond = bitsPerSecond.add(getAudioBitrate());
		}
		return bitsPerSecond;
	}
	
	private BigDecimal getAudioBitrate() {
		long[] AudioRate;
		if (bitrateK1000Radiobutton.isSelected()) {
			AudioRate = new long[]{
				20000L, 24000L, 32000L, 48000L, 56000L, 64000L, 80000L, 96000L, 112000L, 128000L, 160000L,
				192000L, 224000L, 256000L, 320000L, 350000L, 384000L
			};
		} else {
			AudioRate = new long[]{
				20480L, 24576L, 32768L, 49152L, 57344L, 65536L, 81920L, 98304L, 114688L, 131072L, 163840L,
				196608L, 229376L, 262144L, 327680L, 358400L, 393216L
			};
		}
		return BigDecimal.valueOf(AudioRate[bitrateAudioCombobox.getSelectedIndex()]);
	}
	
	private void printFilesize(BigDecimal bits) {
		long[] toUnit;
		if (sizeK1000Radiobutton.isSelected()) {
			toUnit = new long[]{ 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L };
		} else {
			toUnit = new long[]{ 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L };
		}
		BigDecimal result = bits.divide(new BigDecimal(toUnit[sizeFormatCombobox.getSelectedIndex()]), 4,
				RoundingMode.HALF_UP);
		sizeTextfield.setText(result.toString());
	}
	
	private void printLength(BigDecimal seconds) {
		BigDecimal minutes = new BigDecimal(0), hours = new BigDecimal(0);
		while (seconds.doubleValue() >= 60) {
			seconds = seconds.subtract(new BigDecimal(60));
			minutes = minutes.add(new BigDecimal(1));
		}
		while (minutes.doubleValue() >= 60) {
			minutes = minutes.subtract(new BigDecimal(60));
			hours = hours.add(new BigDecimal(1));
		}
		timeHoursTextfield.setText(hours.toString());
		timeMinutesTextfield.setText(minutes.toString());
		timeSecondsTextfield.setText(seconds.toString());
	}
	
	private void printBitrate(BigDecimal bitsPerSecond) {
		BigDecimal result = bitsPerSecond;
		if (bitrateIncludeAudioCheckbox.isSelected()) {
			result = result.subtract(getAudioBitrate());
		}
		long[] toUnit;
		if (bitrateK1000Radiobutton.isSelected()) {
			toUnit = new long[]{ 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
		} else {
			toUnit = new long[]{ 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
		}
		int[] TimeConversion = { 1, 60, 3600, 86400 };
		result = result.multiply(BigDecimal.valueOf(TimeConversion[bitrateFormatTimeCombobox.getSelectedIndex()]));
		result = result.divide(BigDecimal.valueOf(toUnit[bitrateFormatSizeCombobox.getSelectedIndex()]), 2,
				RoundingMode.HALF_UP);
		bitrateTextfield.setText(result.toString());
	}
	
	private void setTooltips() {
		filesizeLabel				.setToolTipText("The size of the video file");
		calcFilesizeRadiobutton		.setToolTipText("Use the given length and bitrate to calculate the resulting filesize");
		sizeTextfield				.setToolTipText("Enter the given filesize here");
		sizeFormatCombobox			.setToolTipText("Select the format for the filesize");
		sizeK1024Radiobutton		.setToolTipText("1 MB = 1024 B");
		sizeK1000Radiobutton		.setToolTipText("1 MB = 1000 B");
		
		durationLabel				.setToolTipText("The length of the video");
		calcTimeRadiobutton			.setToolTipText("Use the given filesize and bitrate to calculate the resulting video length");
		timeHoursTextfield			.setToolTipText("Enter the given video length here");
		timeHoursLabel				.setToolTipText("Hours");
		timeMinutesTextfield		.setToolTipText("Enter the given video length here");
		timeMinutesLabel			.setToolTipText("Minutes");
		timeSecondsTextfield		.setToolTipText("Enter the given video length here");
		timeSecondsLabel			.setToolTipText("Seconds");
		
		bitrateLabel				.setToolTipText("The bitrate of the video");
		calcBitrateRadiobutton		.setToolTipText("Use the given filesize and video length to calculate the resulting bitrate");
		bitrateTextfield			.setToolTipText("Enter the given video stream bitrate here");
		bitrateFormatSizeCombobox	.setToolTipText("Select a format for the video stream bitrate");
		bitrateFormatTimeCombobox	.setToolTipText("Select a format for the video stream bitrate");
		bitrateK1024Radiobutton		.setToolTipText("1 MB = 1024 B");
		bitrateK1000Radiobutton		.setToolTipText("1 MB = 1000 B");
		bitrateIncludeAudioCheckbox	.setToolTipText("Factor in an extra audio stream with the given bitrate on the right");
		bitrateAudioCombobox		.setToolTipText("Enter the bitrate of the audio stream here");
	}
	
	private void Bitrate_includeAudio_ActionPerformed(ActionEvent evt) {
		bitrateAudioCombobox	.setEnabled(bitrateIncludeAudioCheckbox.isSelected());
		audioBitrateLabel		.setEnabled(bitrateIncludeAudioCheckbox.isSelected());
		calculate();
	}
	
	private void setEditable(boolean size, boolean length, boolean bitrate) {
		sizeTextfield			.setEditable(size);
		timeHoursTextfield		.setEditable(length);
		timeMinutesTextfield	.setEditable(length);
		timeSecondsTextfield	.setEditable(length);
		bitrateTextfield		.setEditable(bitrate);
	}
	
	
	
	public static void main(String[] args) {
		new BitrateGenerator(null);
	}
}