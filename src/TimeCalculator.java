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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static vcs.Helper.AUTHOR_STRING;



/**
 * @version 1.2, 2023-09-30
 * @author Simon Vetter
 */
public class TimeCalculator extends JFrame {
	public static final int	TITLE_HEIGHT		= 55;
	public static final int	LINE_HEIGHT			= 35;
	public static final int	BUTTON_HEIGHT		= 30;
	public static final int	ACTIVATE_HEIGHT		= 20;
	
	public static final int	FIELD_WIDTH			= 80;
	public static final int	HOURS_TEXT_WIDTH	= 20;
	public static final int	MINUTES_TEXT_WIDTH	= 35;
	public static final int	SECONDS_TEXT_WIDTH	= 20;
	public static final int	ACTIVATE_WIDTH		= 70;
	
	public static final int	MOVE_WIDTH			= 85;
	public static final int	SWAP_WIDTH			= 55;
	
	
	public static final int	TITLE_GAP			= 5;
	public static final int	EDGE				= 15;
	public static final int	X_GAP				= 15;
	public static final int	Y_GAP				= 10;
	public static final int	BOX_GAP				= 10;
	
	
	public static final int	ACTIVATE_X_OFFSET	= 5;
	public static final int	FIELD_TEXT_GAP		= 5;
	public static final int	TEXT_FIELD_GAP		= 5;
	
	
	
	public static final int	BOX_LEFT_X			= EDGE;
	
	public static final int	HOURS_X				= BOX_LEFT_X + BOX_GAP;
	public static final int	HOURS_TEXT_X		= HOURS_X + FIELD_WIDTH + FIELD_TEXT_GAP;
	public static final int	MINUTES_X			= HOURS_TEXT_X + HOURS_TEXT_WIDTH + TEXT_FIELD_GAP;
	public static final int	MINUTES_TEXT_X		= MINUTES_X + FIELD_WIDTH + FIELD_TEXT_GAP;
	public static final int	SECONDS_X			= MINUTES_TEXT_X + MINUTES_TEXT_WIDTH + TEXT_FIELD_GAP;
	public static final int	SECONDS_TEXT_X		= SECONDS_X + FIELD_WIDTH + FIELD_TEXT_GAP;
	
	public static final int	BOX_RIGHT_X			= SECONDS_TEXT_X + SECONDS_TEXT_WIDTH + BOX_GAP;
	public static final int	BOX_WIDTH			= BOX_RIGHT_X - BOX_LEFT_X;
	public static final int	OPERATOR_WIDTH		= BOX_WIDTH - BOX_GAP*2;
	
	public static final int	MOVE_LEFT_X			= BOX_RIGHT_X + X_GAP;
	public static final int	MOVE_RIGHT_X		= MOVE_LEFT_X + MOVE_WIDTH;
	public static final int	SWAP_RIGHT_X		= MOVE_RIGHT_X;
	public static final int	SWAP_LEFT_X			= SWAP_RIGHT_X - SWAP_WIDTH;
	public static final int	SWAP_LINES_WIDTH	= MOVE_WIDTH - SWAP_WIDTH;
	
	
	public static final int	BOX_TOP_Y			= TITLE_HEIGHT + TITLE_GAP;
	
	public static final int	LINE1_Y				= BOX_TOP_Y + BOX_GAP;
	public static final int	OPERATOR_Y			= LINE1_Y + LINE_HEIGHT + Y_GAP;
	public static final int	LINE2_Y				= OPERATOR_Y + BUTTON_HEIGHT + Y_GAP;
	public static final int	SEP_Y				= LINE2_Y + LINE_HEIGHT + Y_GAP;
	public static final int	LINE3_Y				= SEP_Y + BUTTON_HEIGHT + Y_GAP;
	public static final int	ACTIVATE_Y			= LINE3_Y + LINE_HEIGHT;
	
	public static final int	BOX_BOTTOM_Y		= ACTIVATE_Y + ACTIVATE_HEIGHT + BOX_GAP;
	public static final int	BOX_HEIGHT			= BOX_BOTTOM_Y - BOX_TOP_Y;
	
	public static final int	SWAP_TOP_Y			= LINE1_Y + LINE_HEIGHT/2;
	public static final int	SWAP_BOTTOM_Y		= LINE2_Y + LINE_HEIGHT/2;
	public static final int	SWAP_HEIGHT			= SWAP_BOTTOM_Y - SWAP_TOP_Y;
	
	public static final int	MOVE1_TOP_Y			= LINE3_Y - 3;
	public static final int	MOVE1_BOTTOM_Y		= LINE3_Y + LINE_HEIGHT/2;
	public static final int	MOVE2_TOP_Y			= LINE3_Y + LINE_HEIGHT/2;
	public static final int	MOVE_HEIGHT			= MOVE1_BOTTOM_Y - MOVE1_TOP_Y;
	
	
	public static final int	WIDTH				= MOVE_RIGHT_X + EDGE;
	public static final int	HEIGHT				= BOX_BOTTOM_Y + EDGE;
	
	
	private final JLabel		titleLabel					= new JLabel();
	private final JTextField	line1HoursTextfield			= new JTextField();
	private final JLabel		line1HoursLabel				= new JLabel();
	private final JTextField	line1MinutesTextfield		= new JTextField();
	private final JLabel		line1MinutesLabel			= new JLabel();
	private final JTextField	line1SecondsTextfield		= new JTextField();
	private final JLabel		line1SecondsLabel			= new JLabel();
	private final JButton		switchModeButton			= new JButton();
	private final JSeparator	hTopSeparator				= new JSeparator();
	private final JSeparator	vLeftSeparator				= new JSeparator();
	private final JSeparator	vRightSeparator				= new JSeparator();
	private final JTextField	line2HoursTextfield			= new JTextField();
	private final JLabel		line2HoursLabel				= new JLabel();
	private final JTextField	line2MinutesTextfield		= new JTextField();
	private final JLabel		line2MinutesLabel			= new JLabel();
	private final JTextField	line2SecondsTextfield		= new JTextField();
	private final JLabel		line2SecondsLabel			= new JLabel();
	private final JButton		calcButton					= new JButton();
	private final JButton		swapButton					= new JButton();
	private final JSeparator	swapTopSeparator			= new JSeparator();
	private final JSeparator	swapBottomSeparator			= new JSeparator();
	private final JTextField	resultHoursTextfield		= new JTextField();
	private final JLabel		resultHoursLabel			= new JLabel();
	private final JTextField	resultMinutesTextfield		= new JTextField();
	private final JLabel		resultMinutesLabel			= new JLabel();
	private final JTextField	resultSecondsTextfield		= new JTextField();
	private final JLabel		resultSecondsLabel			= new JLabel();
	private final JCheckBox		activateHoursCheckbox		= new JCheckBox();
	private final JCheckBox		activateMinutesCheckbox		= new JCheckBox();
	private final JCheckBox		activateSecondsCheckbox		= new JCheckBox();
	private final JSeparator	hBottomSeparator			= new JSeparator();
	private final JButton		moveToLine1Button			= new JButton();
	private final JButton		moveToLine2Button			= new JButton();
	
	
	public TimeCalculator(JFrame parent) {
		super("Time Calculator");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		
		titleLabel.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		titleLabel.setText("Time Calculator");
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setToolTipText(AUTHOR_STRING);
		container.add(titleLabel);
		
		line1HoursTextfield.setBounds(HOURS_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		line1HoursTextfield.setText("");
		line1HoursTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		line1HoursTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		line1HoursTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(line1HoursTextfield, true);
				calculate();
			}
		});
		container.add(line1HoursTextfield);
		
		line1HoursLabel.setBounds(HOURS_TEXT_X, LINE1_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		line1HoursLabel.setText("h");
		line1HoursLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		line1HoursLabel.setHorizontalAlignment(SwingConstants.LEFT);
		line1HoursLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(line1HoursLabel);
		
		line1MinutesTextfield.setBounds(MINUTES_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		line1MinutesTextfield.setText("");
		line1MinutesTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		line1MinutesTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		line1MinutesTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(line1MinutesTextfield, true);
				calculate();
			}
		});
		container.add(line1MinutesTextfield);
		
		line1MinutesLabel.setBounds(MINUTES_TEXT_X, LINE1_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		line1MinutesLabel.setText("min");
		line1MinutesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		line1MinutesLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(line1MinutesLabel);
		
		line1SecondsTextfield.setBounds(SECONDS_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		line1SecondsTextfield.setText("");
		line1SecondsTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		line1SecondsTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		line1SecondsTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(line1SecondsTextfield, true);
				calculate();
			}
		});
		container.add(line1SecondsTextfield);
		
		line1SecondsLabel.setBounds(SECONDS_TEXT_X, LINE1_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		line1SecondsLabel.setText("s");
		line1SecondsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		line1SecondsLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(line1SecondsLabel);
		
		switchModeButton.setBounds(HOURS_X, OPERATOR_Y, OPERATOR_WIDTH, BUTTON_HEIGHT);
		switchModeButton.setText("+");
		switchModeButton.setMargin(new Insets(2, 2, 2, 2));
		switchModeButton.addActionListener(evt -> {
			switchMode();
			calculate();
		});
		switchModeButton.setSelected(false);
		switchModeButton.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(switchModeButton);
		
		hTopSeparator.setBounds(BOX_LEFT_X, BOX_TOP_Y, BOX_WIDTH + 1, 1);
		container.add(hTopSeparator);
		
		vLeftSeparator.setBounds(BOX_LEFT_X, BOX_TOP_Y, 1, BOX_HEIGHT + 1);
		vLeftSeparator.setOrientation(SwingConstants.VERTICAL);
		container.add(vLeftSeparator);
		
		vRightSeparator.setBounds(BOX_RIGHT_X, BOX_TOP_Y + 2, 1, BOX_HEIGHT + 1 - 2);
		vRightSeparator.setOrientation(SwingConstants.VERTICAL);
		container.add(vRightSeparator);
		
		hBottomSeparator.setBounds(BOX_LEFT_X + 2, BOX_BOTTOM_Y, BOX_WIDTH + 1 - 2, 1);
		container.add(hBottomSeparator);
		
		line2HoursTextfield.setBounds(HOURS_X, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		line2HoursTextfield.setText("");
		line2HoursTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		line2HoursTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		line2HoursTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(line2HoursTextfield, true);
				calculate();
			}
		});
		container.add(line2HoursTextfield);
		
		line2HoursLabel.setBounds(HOURS_TEXT_X, LINE2_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		line2HoursLabel.setText("h");
		line2HoursLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		line2HoursLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(line2HoursLabel);
		
		line2MinutesTextfield.setBounds(MINUTES_X, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		line2MinutesTextfield.setText("");
		line2MinutesTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		line2MinutesTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		line2MinutesTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(line2MinutesTextfield, true);
				calculate();
			}
		});
		container.add(line2MinutesTextfield);
		
		line2MinutesLabel.setBounds(MINUTES_TEXT_X, LINE2_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		line2MinutesLabel.setText("min");
		line2MinutesLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		line2MinutesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(line2MinutesLabel);
		
		line2SecondsTextfield.setBounds(SECONDS_X, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		line2SecondsTextfield.setText("");
		line2SecondsTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		line2SecondsTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		line2SecondsTextfield.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(line2SecondsTextfield, true);
				calculate();
			}
		});
		container.add(line2SecondsTextfield);
		
		line2SecondsLabel.setBounds(SECONDS_TEXT_X, LINE2_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		line2SecondsLabel.setText("s");
		line2SecondsLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		line2SecondsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(line2SecondsLabel);
		
		calcButton.setBounds(BOX_LEFT_X, SEP_Y, BOX_WIDTH + 1, BUTTON_HEIGHT);
		calcButton.setText("=");
		calcButton.setMargin(new Insets(2, 2, 2, 2));
		calcButton.addActionListener(evt -> calculate());
		calcButton.setFont(new Font("Dialog", Font.BOLD, 25));
		calcButton.setVerticalAlignment(SwingConstants.CENTER);
		container.add(calcButton);
		
		swapButton.setBounds(SWAP_LEFT_X, SWAP_TOP_Y, SWAP_WIDTH, SWAP_HEIGHT);
		swapButton.setText("swap");
		swapButton.setMargin(new Insets(2, 2, 2, 2));
		swapButton.addActionListener(evt -> {
			swapButton();
			calculate();
		});
		swapButton.setFont(new Font("Dialog", Font.BOLD, 16));
		container.add(swapButton);
		
		swapTopSeparator.setBounds(MOVE_LEFT_X, SWAP_TOP_Y, SWAP_LINES_WIDTH, 1);
		container.add(swapTopSeparator);
		
		swapBottomSeparator.setBounds(MOVE_LEFT_X, SWAP_BOTTOM_Y - 1, SWAP_LINES_WIDTH, 1);
		container.add(swapBottomSeparator);
		
		resultHoursTextfield.setBounds(HOURS_X, LINE3_Y, FIELD_WIDTH, LINE_HEIGHT);
		resultHoursTextfield.setText("0");
		resultHoursTextfield.setEditable(false);
		resultHoursTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultHoursTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(resultHoursTextfield);
		
		resultHoursLabel.setBounds(HOURS_TEXT_X, LINE3_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		resultHoursLabel.setText("h");
		resultHoursLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		resultHoursLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(resultHoursLabel);
		
		resultMinutesTextfield.setBounds(MINUTES_X, LINE3_Y, FIELD_WIDTH, LINE_HEIGHT);
		resultMinutesTextfield.setText("0");
		resultMinutesTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultMinutesTextfield.setEditable(false);
		resultMinutesTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(resultMinutesTextfield);
		
		resultMinutesLabel.setBounds(MINUTES_TEXT_X, LINE3_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		resultMinutesLabel.setText("min");
		resultMinutesLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		resultMinutesLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(resultMinutesLabel);
		
		resultSecondsTextfield.setBounds(SECONDS_X, LINE3_Y, FIELD_WIDTH, LINE_HEIGHT);
		resultSecondsTextfield.setText("0");
		resultSecondsTextfield.setHorizontalAlignment(SwingConstants.RIGHT);
		resultSecondsTextfield.setFont(new Font("Dialog", Font.PLAIN, 18));
		resultSecondsTextfield.setEditable(false);
		container.add(resultSecondsTextfield);
		
		resultSecondsLabel.setBounds(SECONDS_TEXT_X, LINE3_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		resultSecondsLabel.setText("s");
		resultSecondsLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		resultSecondsLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(resultSecondsLabel);
		
		activateHoursCheckbox.setBounds(HOURS_X + ACTIVATE_X_OFFSET, ACTIVATE_Y, ACTIVATE_WIDTH, ACTIVATE_HEIGHT);
		activateHoursCheckbox.setText("activate");
		activateHoursCheckbox.setSelected(true);
		activateHoursCheckbox.addActionListener(evt -> manageUnitActivations(activateHoursCheckbox, activateMinutesCheckbox, activateSecondsCheckbox, resultHoursTextfield, resultHoursLabel));
		container.add(activateHoursCheckbox);
		
		activateMinutesCheckbox.setBounds(MINUTES_X + ACTIVATE_X_OFFSET, ACTIVATE_Y, ACTIVATE_WIDTH, ACTIVATE_HEIGHT);
		activateMinutesCheckbox.setText("activate");
		activateMinutesCheckbox.setSelected(true);
		activateMinutesCheckbox.addActionListener(evt -> manageUnitActivations(activateMinutesCheckbox, activateSecondsCheckbox, activateHoursCheckbox, resultMinutesTextfield, resultMinutesLabel));
		container.add(activateMinutesCheckbox);
		
		activateSecondsCheckbox.setBounds(SECONDS_X + ACTIVATE_X_OFFSET, ACTIVATE_Y, ACTIVATE_WIDTH, ACTIVATE_HEIGHT);
		activateSecondsCheckbox.setText("activate");
		activateSecondsCheckbox.setSelected(true);
		activateSecondsCheckbox.addActionListener(evt -> manageUnitActivations(activateSecondsCheckbox, activateHoursCheckbox, activateMinutesCheckbox, resultSecondsTextfield, resultSecondsLabel));
		container.add(activateSecondsCheckbox);
		
		moveToLine1Button.setBounds(MOVE_LEFT_X, MOVE1_TOP_Y, MOVE_WIDTH, MOVE_HEIGHT);
		moveToLine1Button.setText("move way up");
		moveToLine1Button.setMargin(new Insets(2, 2, 2, 2));
		moveToLine1Button.addActionListener(evt -> {
			moveWayUp();
			calculate();
		});
		moveToLine1Button.setHorizontalTextPosition(SwingConstants.CENTER);
		moveToLine1Button.setFont(new Font("Dialog", Font.PLAIN, 12));
		container.add(moveToLine1Button);
		
		moveToLine2Button.setBounds(MOVE_LEFT_X, MOVE2_TOP_Y, MOVE_WIDTH, MOVE_HEIGHT);
		moveToLine2Button.setText("move up");
		moveToLine2Button.setMargin(new Insets(2, 2, 2, 2));
		moveToLine2Button.addActionListener(evt -> {
			moveUp();
			calculate();
		});
		moveToLine2Button.setHorizontalTextPosition(SwingConstants.CENTER);
		moveToLine2Button.setFont(new Font("Dialog", Font.PLAIN, 12));
		container.add(moveToLine2Button);
		
		
		setTooltips();
		setVisible(true);
	}
	
	
	
	private void manageUnitActivations(JCheckBox manipulated, JCheckBox other1, JCheckBox other2,
			JTextField textfield, JLabel label) {
		if (!manipulated.isSelected() && (other1.isSelected() ^ other2.isSelected())) {
			other1.setEnabled(!other1.isSelected());
			other2.setEnabled(!other2.isSelected());
		} else {
			other1.setEnabled(true);
			other2.setEnabled(true);
		}
		textfield.setEnabled(manipulated.isSelected());
		label.setEnabled(manipulated.isSelected());
		
		calculate();
	}
	
	
	
	private void calculate() {
		double input_h1		= Helper.parseDouble(line1HoursTextfield.getText());
		double input_min1	= Helper.parseDouble(line1MinutesTextfield.getText());
		double input_s1		= Helper.parseDouble(line1SecondsTextfield.getText());
		
		BigDecimal hours1	= BigDecimal.valueOf(input_h1);
		BigDecimal minutes1	= BigDecimal.valueOf(input_min1);
		BigDecimal seconds1	= BigDecimal.valueOf(input_s1);
		
		if (switchModeButton.getText().isEmpty()) {
			doConversion(hours1, minutes1, seconds1);
			return;
		}
		
		double input_h2		= Helper.parseDouble(line2HoursTextfield.getText());
		double input_min2	= Helper.parseDouble(line2MinutesTextfield.getText());
		double input_s2		= Helper.parseDouble(line2SecondsTextfield.getText());
		
		BigDecimal hours2	= BigDecimal.valueOf(input_h2);
		BigDecimal minutes2	= BigDecimal.valueOf(input_min2);
		BigDecimal seconds2	= BigDecimal.valueOf(input_s2);
		
		if (switchModeButton.getText().equals("+")) {
			doAddition(hours1, minutes1, seconds1, hours2, minutes2, seconds2);
			return;
		}
		
		if (switchModeButton.getText().equals("–")) {
			doSubtraction(hours1, minutes1, seconds1, hours2, minutes2, seconds2);
		}
	}
	
	private void doConversion(
			BigDecimal hours, BigDecimal minutes, BigDecimal seconds
	) {
		setTextFields(seconds
				.add(minutes.multiply(new BigDecimal(60)))
				.add(hours.multiply(new BigDecimal(3600))));
	}
	
	private void doAddition(
			BigDecimal hours1, BigDecimal minutes1, BigDecimal seconds1,
			BigDecimal hours2, BigDecimal minutes2, BigDecimal seconds2
	) {
		setTextFields(seconds1
				.add(minutes1.multiply(new BigDecimal(60)))
				.add(hours1.multiply(new BigDecimal(3600)))
				.add(seconds2)
				.add(minutes2.multiply(new BigDecimal(60)))
				.add(hours2.multiply(new BigDecimal(3600))));
	}
	
	private void doSubtraction(
			BigDecimal hours1, BigDecimal minutes1, BigDecimal seconds1,
			BigDecimal hours2, BigDecimal minutes2, BigDecimal seconds2
	) {
		setTextFields(seconds1
				.add(minutes1.multiply(new BigDecimal(60)))
				.add(hours1.multiply(new BigDecimal(3600)))
				.subtract(seconds2)
				.subtract(minutes2.multiply(new BigDecimal(60)))
				.subtract(hours2.multiply(new BigDecimal(3600))));
	}
	
	private void setTextFields(BigDecimal seconds) {
		if (!activateHoursCheckbox.isSelected() && !activateMinutesCheckbox.isSelected()) {
			resultHoursTextfield.setText("0");
			resultHoursTextfield.setText("0");
			resultSecondsTextfield.setText(seconds.toString());
			return;
		}
		
		BigDecimal minutes = new BigDecimal(0), hours = new BigDecimal(0);
		while (seconds.doubleValue() >= 60) {
			seconds = seconds.subtract(new BigDecimal(60));
			minutes = minutes.add(new BigDecimal(1));
		}
		if (!activateHoursCheckbox.isSelected() && activateMinutesCheckbox.isSelected() && activateSecondsCheckbox.isSelected()) {
			resultHoursTextfield.setText("0");
			resultMinutesTextfield.setText(minutes.toString());
			resultSecondsTextfield.setText(seconds.toString());
			return;
		}
		
		if (!activateHoursCheckbox.isSelected() && activateMinutesCheckbox.isSelected() && !activateSecondsCheckbox.isSelected()) {
			resultHoursTextfield.setText("0");
			resultMinutesTextfield.setText(
					minutes.add(seconds.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).toString());
			resultSecondsTextfield.setText("0");
			return;
		}
		
		while (minutes.doubleValue() >= 60) {
			minutes = minutes.subtract(new BigDecimal(60));
			hours = hours.add(new BigDecimal(1));
		}
		if (activateHoursCheckbox.isSelected() && activateMinutesCheckbox.isSelected() && !activateSecondsCheckbox.isSelected()) {
			resultHoursTextfield.setText(hours.toString());
			resultMinutesTextfield.setText(
					minutes.add(seconds.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).toString());
			resultSecondsTextfield.setText("0");
			return;
		}
		
		if (activateHoursCheckbox.isSelected() && !activateMinutesCheckbox.isSelected() && !activateSecondsCheckbox.isSelected()) {
			resultHoursTextfield.setText(
					hours.add(minutes.add(seconds.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP))
							.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).toString());
			resultMinutesTextfield.setText("0");
			resultSecondsTextfield.setText("0");
			return;
		}
		
		if (activateHoursCheckbox.isSelected() && !activateMinutesCheckbox.isSelected() && activateSecondsCheckbox.isSelected()) {
			resultHoursTextfield.setText(hours.toString());
			resultMinutesTextfield.setText("0");
			resultSecondsTextfield.setText(seconds.add(minutes.multiply(new BigDecimal(60))).toString());
			return;
		}
		
		String hoursText = hours.toString();
		String minutesText = minutes.toString();
		String secondsText = seconds.toString();
		if (secondsText.endsWith(".0")) {
			secondsText = secondsText.split("\\.")[0];
		}
		resultHoursTextfield.setText(hoursText);
		resultMinutesTextfield.setText(minutesText);
		resultSecondsTextfield.setText(secondsText);
	}
	
	private void switchMode() {
		if (switchModeButton.getText().isEmpty()) {
			switchModeButton.setText("+");
			setLine2Active(true);
			return;
		}
		
		if (switchModeButton.getText().equals("+")) {
			switchModeButton.setText("–");
			setLine2Active(true);
		}
		
		else {
			switchModeButton.setText("");
			setLine2Active(false);
		}
	}
	
	private void setLine2Active(boolean active) {
		line2HoursTextfield		.setEnabled(active);
		line2HoursLabel			.setEnabled(active);
		line2MinutesTextfield	.setEnabled(active);
		line2MinutesLabel		.setEnabled(active);
		line2SecondsTextfield	.setEnabled(active);
		line2SecondsLabel		.setEnabled(active);
	}
	
	private void swapButton() {
		String temp_h	= line1HoursTextfield.getText();
		String temp_min	= line1MinutesTextfield.getText();
		String temp_s	= line1SecondsTextfield.getText();
		line1HoursTextfield		.setText(line2HoursTextfield.getText());
		line1MinutesTextfield	.setText(line2MinutesTextfield.getText());
		line1SecondsTextfield	.setText(line2SecondsTextfield.getText());
		line2HoursTextfield		.setText(temp_h);
		line2MinutesTextfield	.setText(temp_min);
		line2SecondsTextfield	.setText(temp_s);
	}
	
	private void moveWayUp() {
		line1HoursTextfield		.setText(resultHoursTextfield.getText());
		line1MinutesTextfield	.setText(resultMinutesTextfield.getText());
		line1SecondsTextfield	.setText(resultSecondsTextfield.getText());
	}
	
	private void moveUp() {
		line2HoursTextfield		.setText(resultHoursTextfield.getText());
		line2MinutesTextfield	.setText(resultMinutesTextfield.getText());
		line2SecondsTextfield	.setText(resultSecondsTextfield.getText());
	}
	
	public void setTooltips() {
		line1HoursTextfield		.setToolTipText("Enter the first time period you want to calculate with here");
		line1HoursLabel			.setToolTipText("Hours");
		line1MinutesTextfield	.setToolTipText("Enter the first time period you want to calculate with here");
		line1MinutesLabel		.setToolTipText("Minutes");
		line1SecondsTextfield	.setToolTipText("Enter the first time period you want to calculate with here");
		line1SecondsLabel		.setToolTipText("Seconds");
		switchModeButton		.setToolTipText("Switch between convert, addition and subtraction mode");
		line2HoursTextfield		.setToolTipText("Enter the second time period you want to calculate with here");
		line2HoursLabel			.setToolTipText("Hours");
		line2MinutesTextfield	.setToolTipText("Enter the second time period you want to calculate with here");
		line2MinutesLabel		.setToolTipText("Minutes");
		line2SecondsTextfield	.setToolTipText("Enter the second time period you want to calculate with here");
		line2SecondsLabel		.setToolTipText("Seconds");
		resultHoursLabel		.setToolTipText("Hours");
		resultMinutesLabel		.setToolTipText("Minutes");
		resultSecondsLabel		.setToolTipText("Seconds");
		activateHoursCheckbox	.setToolTipText("Display the amount of full hours in the result");
		activateMinutesCheckbox	.setToolTipText("Display the amount of full minutes in the result");
		activateSecondsCheckbox	.setToolTipText("Display the amount of single seconds in the result");
		swapButton				.setToolTipText("Swap the set time periods between lines 1 and 2");
		moveToLine1Button		.setToolTipText("Move result to the first line");
		moveToLine2Button		.setToolTipText("Move result to the second line");
	}
	
	
	
	public static void main(String[] args) {
		new TimeCalculator(null);
	}
}