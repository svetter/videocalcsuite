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
public class TimeCalculator extends JFrame {
	private static final long serialVersionUID = 8078398186529547364L;
	
	
	
	public static final int	TITLE_HEIGHT			= 55;
	public static final int	LINE_HEIGHT				= 35;
	public static final int	BUTTON_HEIGHT			= 30;
	public static final int	ACTIVATE_HEIGHT			= 20;

	public static final int	FIELD_WIDTH				= 80;
	public static final int	HOURS_TEXT_WIDTH		= 20;
	public static final int	MINUTES_TEXT_WIDTH		= 35;
	public static final int	SECONDS_TEXT_WIDTH		= 20;
	public static final int	ACTIVATE_WIDTH			= 70;
	
	public static final int	MOVE_WIDTH				= 85;
	public static final int	SWAP_WIDTH				= 55;
	

	public static final int	TITLE_GAP				= 5;
	public static final int	EDGE					= 15;
	public static final int	X_GAP					= 15;
	public static final int	Y_GAP					= 10;
	public static final int	BOX_GAP					= 10;
	

	public static final int	ACTIVATE_X_OFFSET		= 5;
	public static final int	FIELD_TEXT_GAP			= 5;
	public static final int	TEXT_FIELD_GAP			= 5;
	
	
	
	public static final int	BOX_LEFT_X				= EDGE;
	
	public static final int	HOURS_X					= BOX_LEFT_X + BOX_GAP;
	public static final int	HOURS_TEXT_X			= HOURS_X + FIELD_WIDTH + FIELD_TEXT_GAP;
	public static final int	MINUTES_X				= HOURS_TEXT_X + HOURS_TEXT_WIDTH + TEXT_FIELD_GAP;
	public static final int	MINUTES_TEXT_X			= MINUTES_X + FIELD_WIDTH + FIELD_TEXT_GAP;
	public static final int	SECONDS_X				= MINUTES_TEXT_X + MINUTES_TEXT_WIDTH + TEXT_FIELD_GAP;
	public static final int	SECONDS_TEXT_X			= SECONDS_X + FIELD_WIDTH + FIELD_TEXT_GAP;
	
	public static final int	BOX_RIGHT_X				= SECONDS_TEXT_X + SECONDS_TEXT_WIDTH + BOX_GAP;
	public static final int	BOX_WIDTH				= BOX_RIGHT_X - BOX_LEFT_X;
	public static final int	OPERATOR_WIDTH			= BOX_WIDTH - BOX_GAP*2;
	
	public static final int	MOVE_LEFT_X				= BOX_RIGHT_X + X_GAP;
	public static final int	MOVE_RIGHT_X			= MOVE_LEFT_X + MOVE_WIDTH;
	public static final int	SWAP_RIGHT_X			= MOVE_RIGHT_X;
	public static final int	SWAP_LEFT_X				= SWAP_RIGHT_X - SWAP_WIDTH;
	public static final int	SWAP_LINES_WIDTH		= MOVE_WIDTH - SWAP_WIDTH;
	
	
	public static final int	BOX_TOP_Y				= TITLE_HEIGHT + TITLE_GAP;
	
	public static final int	LINE1_Y					= BOX_TOP_Y + BOX_GAP;
	public static final int	OPERATOR_Y				= LINE1_Y + LINE_HEIGHT + Y_GAP;
	public static final int	LINE2_Y					= OPERATOR_Y + BUTTON_HEIGHT + Y_GAP;
	public static final int	SEP_Y					= LINE2_Y + LINE_HEIGHT + Y_GAP;
	public static final int	LINE3_Y					= SEP_Y + BUTTON_HEIGHT + Y_GAP;
	public static final int	ACTIVATE_Y				= LINE3_Y + LINE_HEIGHT;
	
	public static final int	BOX_BOTTOM_Y			= ACTIVATE_Y + ACTIVATE_HEIGHT + BOX_GAP;
	public static final int	BOX_HEIGHT				= BOX_BOTTOM_Y - BOX_TOP_Y;
	
	public static final int	SWAP_TOP_Y				= LINE1_Y + LINE_HEIGHT/2;
	public static final int	SWAP_BOTTOM_Y			= LINE2_Y + LINE_HEIGHT/2;
	public static final int	SWAP_HEIGHT				= SWAP_BOTTOM_Y - SWAP_TOP_Y;
	
	public static final int	MOVE1_TOP_Y				= LINE3_Y - 3;
	public static final int	MOVE1_BOTTOM_Y			= LINE3_Y + LINE_HEIGHT/2;
	public static final int	MOVE2_TOP_Y				= LINE3_Y + LINE_HEIGHT/2;
	public static final int	MOVE2_BOTTOM_Y			= LINE3_Y + LINE_HEIGHT + 3;
	public static final int	MOVE_HEIGHT				= MOVE1_BOTTOM_Y - MOVE1_TOP_Y;
	
	
	public static final int	WIDTH					= MOVE_RIGHT_X + EDGE;
	public static final int	HEIGHT					= BOX_BOTTOM_Y + EDGE;
	
	
	private JLabel			Text_Title				= new JLabel();
	private JTextField		Time_hours_given1		= new JTextField();
	private JLabel			Text_l1_h				= new JLabel();
	private JTextField		Time_minutes_given1		= new JTextField();
	private JLabel			Text_l1_min				= new JLabel();
	private JTextField		Time_seconds_given1		= new JTextField();
	private JLabel			Text_l1_s				= new JLabel();
	private JButton 		switchMode_Button		= new JButton();
	private JSeparator		Seperator_h_top			= new JSeparator();
	private JSeparator		Seperator_v_left		= new JSeparator();
	private JSeparator		Seperator_v_right		= new JSeparator();
	private JTextField		Time_hours_given2		= new JTextField();
	private JLabel			Text_l2_h				= new JLabel();
	private JTextField		Time_minutes_given2		= new JTextField();
	private JLabel			Text_l2_min				= new JLabel();
	private JTextField		Time_seconds_given2		= new JTextField();
	private JLabel			Text_l2_s				= new JLabel();
	private JButton			Button_equals_nf		= new JButton();
	private JButton			swapButton				= new JButton();
	private JSeparator		Seperator_swap_top		= new JSeparator();
	private JSeparator		Seperator_swap_bottom	= new JSeparator();
	private JTextField		Time_hours_wanted		= new JTextField();
	private JLabel			Text_l3_h				= new JLabel();
	private JTextField		Time_minutes_wanted		= new JTextField();
	private JLabel			Text_l3_min				= new JLabel();
	private JTextField		Time_seconds_wanted		= new JTextField();
	private JLabel			Text_l3_s				= new JLabel();
	private JCheckBox		activate_hours			= new JCheckBox();
	private JCheckBox		activate_minutes		= new JCheckBox();
	private JCheckBox		activate_seconds		= new JCheckBox();
	private JSeparator		Seperator_h_bottom		= new JSeparator();
	private JButton			moveWayUpButton			= new JButton();
	private JButton			moveUpButton			= new JButton();
	
	
	public TimeCalculator(JFrame parent) {
		super("Time Calculator");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		
		Text_Title.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		Text_Title.setText("Time Calculator");
		Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
		Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Title.setToolTipText("v1.1 © Simon Vetter 2021");
		container.add(Text_Title);
		
		Time_hours_given1.setBounds(HOURS_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_hours_given1.setText("");
		Time_hours_given1.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_hours_given1.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_hours_given1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Time_hours_given1, true);
				calculate();
			}
		});
		container.add(Time_hours_given1);
		
		Text_l1_h.setBounds(HOURS_TEXT_X, LINE1_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		Text_l1_h.setText("h");
		Text_l1_h.setFont(new Font("Dialog", Font.PLAIN, 18));
		Text_l1_h.setHorizontalAlignment(SwingConstants.LEFT);
		Text_l1_h.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_l1_h);
		
		Time_minutes_given1.setBounds(MINUTES_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_minutes_given1.setText("");
		Time_minutes_given1.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_minutes_given1.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_minutes_given1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Time_minutes_given1, true);
				calculate();
			}
		});
		container.add(Time_minutes_given1);
		
		Text_l1_min.setBounds(MINUTES_TEXT_X, LINE1_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		Text_l1_min.setText("min");
		Text_l1_min.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_l1_min.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_l1_min);
		
		Time_seconds_given1.setBounds(SECONDS_X, LINE1_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_seconds_given1.setText("");
		Time_seconds_given1.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_seconds_given1.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_seconds_given1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Time_seconds_given1, true);
				calculate();
			}
		});
		container.add(Time_seconds_given1);
		
		Text_l1_s.setBounds(SECONDS_TEXT_X, LINE1_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		Text_l1_s.setText("s");
		Text_l1_s.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_l1_s.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_l1_s);
		
		switchMode_Button.setBounds(HOURS_X, OPERATOR_Y, OPERATOR_WIDTH, BUTTON_HEIGHT);
		switchMode_Button.setText("+");
		switchMode_Button.setMargin(new Insets(2, 2, 2, 2));
		switchMode_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				switchMode();
				calculate();
			}
		});
		switchMode_Button.setSelected(false);
		switchMode_Button.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(switchMode_Button);
		
		Seperator_h_top.setBounds(BOX_LEFT_X, BOX_TOP_Y, BOX_WIDTH + 1, 1);
		container.add(Seperator_h_top);
		
		Seperator_v_left.setBounds(BOX_LEFT_X, BOX_TOP_Y, 1, BOX_HEIGHT + 1);
		Seperator_v_left.setOrientation(SwingConstants.VERTICAL);
		container.add(Seperator_v_left);
		
		Seperator_v_right.setBounds(BOX_RIGHT_X, BOX_TOP_Y + 2, 1, BOX_HEIGHT + 1 - 2);
		Seperator_v_right.setOrientation(SwingConstants.VERTICAL);
		container.add(Seperator_v_right);
		
		Seperator_h_bottom.setBounds(BOX_LEFT_X + 2, BOX_BOTTOM_Y, BOX_WIDTH + 1 - 2, 1);
		container.add(Seperator_h_bottom);
		
		Time_hours_given2.setBounds(HOURS_X, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_hours_given2.setText("");
		Time_hours_given2.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_hours_given2.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_hours_given2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Time_hours_given2, true);
				calculate();
			}
		});
		container.add(Time_hours_given2);
		
		Text_l2_h.setBounds(HOURS_TEXT_X, LINE2_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		Text_l2_h.setText("h");
		Text_l2_h.setFont(new Font("Dialog", Font.PLAIN, 18));
		Text_l2_h.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_l2_h);
		
		Time_minutes_given2.setBounds(MINUTES_X, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_minutes_given2.setText("");
		Time_minutes_given2.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_minutes_given2.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_minutes_given2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Time_minutes_given2, true);
				calculate();
			}
		});
		container.add(Time_minutes_given2);
		
		Text_l2_min.setBounds(MINUTES_TEXT_X, LINE2_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		Text_l2_min.setText("min");
		Text_l2_min.setFont(new Font("Dialog", Font.PLAIN, 18));
		Text_l2_min.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_l2_min);
		
		Time_seconds_given2.setBounds(SECONDS_X, LINE2_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_seconds_given2.setText("");
		Time_seconds_given2.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_seconds_given2.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_seconds_given2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Time_seconds_given2, true);
				calculate();
			}
		});
		container.add(Time_seconds_given2);
		
		Text_l2_s.setBounds(SECONDS_TEXT_X, LINE2_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		Text_l2_s.setText("s");
		Text_l2_s.setFont(new Font("Dialog", Font.PLAIN, 18));
		Text_l2_s.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_l2_s);
		
		Button_equals_nf.setBounds(BOX_LEFT_X, SEP_Y, BOX_WIDTH + 1, BUTTON_HEIGHT);
		Button_equals_nf.setText("=");
		Button_equals_nf.setMargin(new Insets(2, 2, 2, 2));
		Button_equals_nf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		Button_equals_nf.setFont(new Font("Dialog", Font.BOLD, 25));
		Button_equals_nf.setVerticalAlignment(SwingConstants.CENTER);
		container.add(Button_equals_nf);
		
		swapButton.setBounds(SWAP_LEFT_X, SWAP_TOP_Y, SWAP_WIDTH, SWAP_HEIGHT);
		swapButton.setText("swap");
		swapButton.setMargin(new Insets(2, 2, 2, 2));
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				swapButton();
				calculate();
			}
		});
		swapButton.setFont(new Font("Dialog", Font.BOLD, 16));
		container.add(swapButton);
		
		Seperator_swap_top.setBounds(MOVE_LEFT_X, SWAP_TOP_Y, SWAP_LINES_WIDTH, 1);
		container.add(Seperator_swap_top);
		
		Seperator_swap_bottom.setBounds(MOVE_LEFT_X, SWAP_BOTTOM_Y - 1, SWAP_LINES_WIDTH, 1);
		container.add(Seperator_swap_bottom);
		
		Time_hours_wanted.setBounds(HOURS_X, LINE3_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_hours_wanted.setText("0");
		Time_hours_wanted.setEditable(false);
		Time_hours_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_hours_wanted.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(Time_hours_wanted);
		
		Text_l3_h.setBounds(HOURS_TEXT_X, LINE3_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		Text_l3_h.setText("h");
		Text_l3_h.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_l3_h.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_l3_h);
		
		Time_minutes_wanted.setBounds(MINUTES_X, LINE3_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_minutes_wanted.setText("0");
		Time_minutes_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_minutes_wanted.setEditable(false);
		Time_minutes_wanted.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(Time_minutes_wanted);
		
		Text_l3_min.setBounds(MINUTES_TEXT_X, LINE3_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		Text_l3_min.setText("min");
		Text_l3_min.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_l3_min.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_l3_min);
		
		Time_seconds_wanted.setBounds(SECONDS_X, LINE3_Y, FIELD_WIDTH, LINE_HEIGHT);
		Time_seconds_wanted.setText("0");
		Time_seconds_wanted.setHorizontalAlignment(SwingConstants.RIGHT);
		Time_seconds_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
		Time_seconds_wanted.setEditable(false);
		container.add(Time_seconds_wanted);
		
		Text_l3_s.setBounds(SECONDS_TEXT_X, LINE3_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		Text_l3_s.setText("s");
		Text_l3_s.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_l3_s.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_l3_s);
		
		activate_hours.setBounds(HOURS_X + ACTIVATE_X_OFFSET, ACTIVATE_Y, ACTIVATE_WIDTH, ACTIVATE_HEIGHT);
		activate_hours.setText("activate");
		activate_hours.setSelected(true);
		activate_hours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manageUnitActivations(activate_hours, activate_minutes, activate_seconds, Time_hours_wanted, Text_l3_h);
			}
		});
		container.add(activate_hours);
		
		activate_minutes.setBounds(MINUTES_X + ACTIVATE_X_OFFSET, ACTIVATE_Y, ACTIVATE_WIDTH, ACTIVATE_HEIGHT);
		activate_minutes.setText("activate");
		activate_minutes.setSelected(true);
		activate_minutes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manageUnitActivations(activate_minutes, activate_seconds, activate_hours, Time_minutes_wanted, Text_l3_min);
			}
		});
		container.add(activate_minutes);
		
		activate_seconds.setBounds(SECONDS_X + ACTIVATE_X_OFFSET, ACTIVATE_Y, ACTIVATE_WIDTH, ACTIVATE_HEIGHT);
		activate_seconds.setText("activate");
		activate_seconds.setSelected(true);
		activate_seconds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				manageUnitActivations(activate_seconds, activate_hours, activate_minutes, Time_seconds_wanted, Text_l3_s);
			}
		});
		container.add(activate_seconds);
		
		moveWayUpButton.setBounds(MOVE_LEFT_X, MOVE1_TOP_Y, MOVE_WIDTH, MOVE_HEIGHT);
		moveWayUpButton.setText("move way up");
		moveWayUpButton.setMargin(new Insets(2, 2, 2, 2));
		moveWayUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				moveWayUp();
				calculate();
			}
		});
		moveWayUpButton.setHorizontalTextPosition(SwingConstants.CENTER);
		moveWayUpButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		container.add(moveWayUpButton);
		
		moveUpButton.setBounds(MOVE_LEFT_X, MOVE2_TOP_Y, MOVE_WIDTH, MOVE_HEIGHT);
		moveUpButton.setText("move up");
		moveUpButton.setMargin(new Insets(2, 2, 2, 2));
		moveUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				moveUp();
				calculate();
			}
		});
		moveUpButton.setHorizontalTextPosition(SwingConstants.CENTER);
		moveUpButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		container.add(moveUpButton);
		
		
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
		double input_h1		= Helper.parseDouble(Time_hours_given1.getText());
		double input_min1	= Helper.parseDouble(Time_minutes_given1.getText());
		double input_s1		= Helper.parseDouble(Time_seconds_given1.getText());
		
		BigDecimal hours1	= BigDecimal.valueOf(input_h1);
		BigDecimal minutes1	= BigDecimal.valueOf(input_min1);
		BigDecimal seconds1	= BigDecimal.valueOf(input_s1);
		
		if (switchMode_Button.getText().equals("")) {
			doConversion(hours1, minutes1, seconds1);
			return;
		}
		
		double input_h2		= Helper.parseDouble(Time_hours_given2.getText());
		double input_min2	= Helper.parseDouble(Time_minutes_given2.getText());
		double input_s2		= Helper.parseDouble(Time_seconds_given2.getText());
		
		BigDecimal hours2	= BigDecimal.valueOf(input_h2);
		BigDecimal minutes2	= BigDecimal.valueOf(input_min2);
		BigDecimal seconds2	= BigDecimal.valueOf(input_s2);

		if (switchMode_Button.getText().equals("+")) {
			doAddition(hours1, minutes1, seconds1, hours2, minutes2, seconds2);
			return;
		}

		if (switchMode_Button.getText().equals("–")) {
			doSubtraction(hours1, minutes1, seconds1, hours2, minutes2, seconds2);
			return;
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
		if (!activate_hours.isSelected() && !activate_minutes.isSelected()) {
			Time_hours_wanted.setText("0");
			Time_hours_wanted.setText("0");
			Time_seconds_wanted.setText(seconds.toString());
			return;
		}
		
		BigDecimal minutes = new BigDecimal(0), hours = new BigDecimal(0);
		while (seconds.doubleValue() >= 60) {
			seconds = seconds.subtract(new BigDecimal(60));
			minutes = minutes.add(new BigDecimal(1));
		}
		if (!activate_hours.isSelected() && activate_minutes.isSelected() && activate_seconds.isSelected()) {
			Time_hours_wanted.setText("0");
			Time_minutes_wanted.setText(minutes.toString());
			Time_seconds_wanted.setText(seconds.toString());
			return;
		}
		
		if (!activate_hours.isSelected() && activate_minutes.isSelected() && !activate_seconds.isSelected()) {
			Time_hours_wanted.setText("0");
			Time_minutes_wanted.setText(
					minutes.add(seconds.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).toString());
			Time_seconds_wanted.setText("0");
			return;
		}
		
		while (minutes.doubleValue() >= 60) {
			minutes = minutes.subtract(new BigDecimal(60));
			hours = hours.add(new BigDecimal(1));
		}
		if (activate_hours.isSelected() && activate_minutes.isSelected() && !activate_seconds.isSelected()) {
			Time_hours_wanted.setText(hours.toString());
			Time_minutes_wanted.setText(
					minutes.add(seconds.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).toString());
			Time_seconds_wanted.setText("0");
			return;
		}
		
		if (activate_hours.isSelected() && !activate_minutes.isSelected() && !activate_seconds.isSelected()) {
			Time_hours_wanted.setText(
					hours.add(minutes.add(seconds.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP))
							.divide(new BigDecimal(60), 2, RoundingMode.HALF_UP)).toString());
			Time_minutes_wanted.setText("0");
			Time_seconds_wanted.setText("0");
			return;
		}
		
		if (activate_hours.isSelected() && !activate_minutes.isSelected() && activate_seconds.isSelected()) {
			Time_hours_wanted.setText(hours.toString());
			Time_minutes_wanted.setText("0");
			Time_seconds_wanted.setText(seconds.add(minutes.multiply(new BigDecimal(60))).toString());
			return;
		}
		
		String hoursText = hours.toString();
		String minutesText = minutes.toString();
		String secondsText = seconds.toString();
		if (secondsText.endsWith(".0")) {
			secondsText = secondsText.split(".")[0];
		}
		Time_hours_wanted.setText(hoursText);
		Time_minutes_wanted.setText(minutesText);
		Time_seconds_wanted.setText(secondsText);
	}

	private void switchMode() {
		if (switchMode_Button.getText().equals("")) {
			switchMode_Button.setText("+");
			setLine2Active(true);
			return;
		}
		
		if (switchMode_Button.getText().equals("+")) {
			switchMode_Button.setText("–");
			setLine2Active(true);
			return;
		}
		
		else {
			switchMode_Button.setText("");
			setLine2Active(false);
			return;
		}
	}
	
	private void setLine2Active(boolean active) {
		Time_hours_given2.setEnabled(active);
		Text_l2_h.setEnabled(active);
		Time_minutes_given2.setEnabled(active);
		Text_l2_min.setEnabled(active);
		Time_seconds_given2.setEnabled(active);
		Text_l2_s.setEnabled(active);
	}
	
	private void swapButton() {
		String temp_h = Time_hours_given1.getText();
		String temp_min = Time_minutes_given1.getText();
		String temp_s = Time_seconds_given1.getText();
		Time_hours_given1.setText(Time_hours_given2.getText());
		Time_minutes_given1.setText(Time_minutes_given2.getText());
		Time_seconds_given1.setText(Time_seconds_given2.getText());
		Time_hours_given2.setText(temp_h);
		Time_minutes_given2.setText(temp_min);
		Time_seconds_given2.setText(temp_s);
	}
	
	private void moveWayUp() {
		Time_hours_given1.setText(Time_hours_wanted.getText());
		Time_minutes_given1.setText(Time_minutes_wanted.getText());
		Time_seconds_given1.setText(Time_seconds_wanted.getText());
	}
	
	private void moveUp() {
		Time_hours_given2.setText(Time_hours_wanted.getText());
		Time_minutes_given2.setText(Time_minutes_wanted.getText());
		Time_seconds_given2.setText(Time_seconds_wanted.getText());
	}
	
	public void setTooltips() {
		Time_hours_given1.setToolTipText("Enter the first time period you want to calculate with here");
		Text_l1_h.setToolTipText("Hours");
		Time_minutes_given1.setToolTipText("Enter the first time period you want to calculate with here");
		Text_l1_min.setToolTipText("Minutes");
		Time_seconds_given1.setToolTipText("Enter the first time period you want to calculate with here");
		Text_l1_s.setToolTipText("Seconds");
		switchMode_Button.setToolTipText("Switch between convert, addition and subtraction mode");
		Time_hours_given2.setToolTipText("Enter the second time period you want to calculate with here");
		Text_l2_h.setToolTipText("Hours");
		Time_minutes_given2.setToolTipText("Enter the second time period you want to calculate with here");
		Text_l2_min.setToolTipText("Minutes");
		Time_seconds_given2.setToolTipText("Enter the second time period you want to calculate with here");
		Text_l2_s.setToolTipText("Seconds");
		Text_l3_h.setToolTipText("Hours");
		Text_l3_min.setToolTipText("Minutes");
		Text_l3_s.setToolTipText("Seconds");
		activate_hours.setToolTipText("Display the amount of full hours in the result");
		activate_minutes.setToolTipText("Display the amount of full minutes in the result");
		activate_seconds.setToolTipText("Display the amount of single seconds in the result");
		swapButton.setToolTipText("Swap the set time periods between lines 1 and 2");
		moveWayUpButton.setToolTipText("Move result to the first line");
		moveUpButton.setToolTipText("Move result to the second line");
	}
	
	
	
	public static void main(String[] args) {
		
		new TimeCalculator(null);
		
	}
}