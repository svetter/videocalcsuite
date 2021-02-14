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
public class BitrateGenerator extends JFrame {
	private static final long serialVersionUID = -8220727997961750547L;
	
	
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

	
	public static final int		K1_Y_OFFSET					= LINE_HEIGHT*1/4 - K_HEIGHT/2 - 2;
	public static final int		K2_Y_OFFSET					= LINE_HEIGHT*3/4 - K_HEIGHT/2 + 2;
	public static final int		SLASH_Y_OFFSET				= LINE_HEIGHT/2 - 24;
	
	
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
	public static final int		_SLASH_Y					= LINE3_Y + SLASH_Y_OFFSET;

	public static final int		TABLE_HEIGHT				= TABLE_BOTTOM_Y - TABLE_TOP_Y;
	
	
	public static final int		HEIGHT						= TABLE_BOTTOM_Y + EDGE;
	
	
	
	
	private JLabel				Text_Title					= new JLabel();
	
	private JSeparator			Seperator_h_top				= new JSeparator();
	private JSeparator			Seperator_h_uppermid		= new JSeparator();
	private JSeparator			Seperator_h_lowermid		= new JSeparator();
	private JSeparator			Seperator_h_bottom			= new JSeparator();
	private JSeparator			Seperator_v_left			= new JSeparator();
	private JSeparator			Seperator_v_mid				= new JSeparator();
	private JSeparator			Seperator_v_right			= new JSeparator();
	
	private JLabel				Text_Filesize				= new JLabel();
	private JRadioButton		calculate_Filesize			= new JRadioButton();
	private JTextField			Filesize_Figure				= new JTextField();
	private JComboBox<String>	Filesize_Format				= new JComboBox<String>();
	private JRadioButton		Filesize_K1024				= new JRadioButton();
	private JRadioButton		Filesize_K1000				= new JRadioButton();
	private ButtonGroup			Filesize_K_Group			= new ButtonGroup();
	
	private JCheckBox			Bitrate_includeAudio		= new JCheckBox();
	private JComboBox<String>	Bitrate_Audio_Figure		= new JComboBox<String>();
	private JLabel				Text_Bitrate_Audio_Format	= new JLabel();
	
	private JLabel				Text_Length					= new JLabel();
	private JRadioButton		calculate_Length			= new JRadioButton();
	private JTextField			Length_hours				= new JTextField();
	private JLabel				Text_Length_h				= new JLabel();
	private JTextField			Length_minutes				= new JTextField();
	private JLabel				Text_Length_min				= new JLabel();
	private JTextField			Length_seconds				= new JTextField();
	private JLabel				Text_Length_s				= new JLabel();
	private JLabel				Text_Bitrate				= new JLabel();
	private JRadioButton		calculate_Bitrate			= new JRadioButton();
	private JTextField			Bitrate_Figure				= new JTextField();
	private JComboBox<String>	Bitrate_Format_Size			= new JComboBox<String>();
	private JLabel				Text_Bitrate_Slash			= new JLabel();
	private JComboBox<String>	Bitrate_Format_Length		= new JComboBox<String>();
	private JRadioButton		Bitrate_K1024				= new JRadioButton();
	private JRadioButton		Bitrate_K1000				= new JRadioButton();
	
	private ButtonGroup			Bitrate_K_Group				= new ButtonGroup();
	private ButtonGroup			calculate_Group				= new ButtonGroup();
	
	
	public BitrateGenerator(JFrame parent) {
		super("Bitrate Generator");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, parent);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		Text_Title.setBounds(EDGE, 0, WIDTH - EDGE*2, TITLE_HEIGHT);
		Text_Title.setText("Bitrate Generator");
		Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
		Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Title.setToolTipText("v1.1 © Simon Vetter 2021");
		container.add(Text_Title);
		
		Seperator_h_top.setBounds(TABLE_LEFT_X, TABLE_TOP_Y, TABLE_WIDTH + 1, 1);
		container.add(Seperator_h_top);
		Seperator_h_uppermid.setBounds(TABLE_LEFT_X + 2, TABLE_MID1_Y, TABLE_WIDTH + 1 - 4, 1);
		container.add(Seperator_h_uppermid);
		Seperator_h_lowermid.setBounds(TABLE_LEFT_X + 2, TABLE_MID2_Y, TABLE_WIDTH + 1 - 4, 1);
		container.add(Seperator_h_lowermid);
		Seperator_h_bottom.setBounds(TABLE_LEFT_X, TABLE_BOTTOM_Y, TABLE_WIDTH + 1, 1);
		container.add(Seperator_h_bottom);
		
		Seperator_v_left.setBounds(TABLE_LEFT_X, TABLE_TOP_Y, 1, TABLE_HEIGHT + 1);
		Seperator_v_left.setOrientation(SwingConstants.VERTICAL);
		container.add(Seperator_v_left);
		Seperator_v_mid.setBounds(TABLE_MIDDLE_X, TABLE_TOP_Y + 2, 1, TABLE_HEIGHT + 1 - 4);
		Seperator_v_mid.setOrientation(SwingConstants.VERTICAL);
		container.add(Seperator_v_mid);
		Seperator_v_right.setBounds(TABLE_RIGHT_X, TABLE_TOP_Y, 1, TABLE_HEIGHT + 1);
		Seperator_v_right.setOrientation(SwingConstants.VERTICAL);
		container.add(Seperator_v_right);
		
		Text_Filesize.setBounds(TARGET_TEXT_X, FILESIZE_TEXT_Y, TARGET_TEXT_WIDTH, TARGET_TEXT_HEIGHT);
		Text_Filesize.setText("Filesize");
		Text_Filesize.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Filesize.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Filesize.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(Text_Filesize);
		calculate_Filesize.setBounds(CALCULATE_X, CALCULATE_SIZE_Y, CALCULATE_WIDTH, CALCULATE_HEIGHT);
		calculate_Filesize.setText("calculate this");
		calculate_Filesize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setEditable(false, true, true);
				calculate();
			}
		});
		container.add(calculate_Filesize);
		Filesize_Figure.setBounds(FIELD1_X, LINE1_Y, SIZE_FIELD_WIDTH, LINE_HEIGHT);
		Filesize_Figure.setText("");
		Filesize_Figure.setFont(new Font("Dialog", Font.PLAIN, 18));
		Filesize_Figure.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Filesize_Figure, false);
				calculate();
			}
		});
		container.add(Filesize_Figure);
		Filesize_Format.setBounds(SIZE_UNIT_X, LINE1_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		Filesize_Format.setModel(
				new DefaultComboBoxModel<String>(new String[] { "B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb" }));
		Filesize_Format.setFont(new Font("Dialog", Font.PLAIN, 18));
		Filesize_Format.setSelectedIndex(2);
		Filesize_Format.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		Filesize_Format.setMaximumRowCount(10);
		container.add(Filesize_Format);
		Filesize_K1024.setBounds(K_X, LINE1_K1_Y, K_WIDTH, K_HEIGHT);
		Filesize_K1024.setText("K = 1024");
		Filesize_K1024.setSelected(true);
		Filesize_K1024.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Filesize_K1024);
		Filesize_K1000.setBounds(K_X, LINE1_K2_Y, K_WIDTH, K_HEIGHT);
		Filesize_K1000.setText("K = 1000");
		Filesize_K1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Filesize_K1000);
		Filesize_K_Group.add(Filesize_K1024);
		Filesize_K_Group.add(Filesize_K1000);
		
		Bitrate_includeAudio.setBounds(AUDIO_CHKBOX_X, LINE4_Y, AUDIO_CHKBOX_WIDTH, AUDIO_LINE_HEIGHT);
		Bitrate_includeAudio.setText(" Audio stream:");
		Bitrate_includeAudio.setFont(new Font("Dialog", Font.PLAIN, 16));
		Bitrate_includeAudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Bitrate_includeAudio_ActionPerformed(evt);
			}
		});
		container.add(Bitrate_includeAudio);
		Bitrate_Audio_Figure.setBounds(RATE_SIZE_UNIT_X, LINE4_Y, SIZE_UNIT_WIDTH, AUDIO_LINE_HEIGHT);
		Bitrate_Audio_Figure.setEditable(false);
		Bitrate_Audio_Figure.setModel(new DefaultComboBoxModel<String>(new String[] { "20", "24", "32", "48", "56", "64", "80",
				"96", "112", "128", "160", "192", "224", "256", "320", "350", "384" }));
		Bitrate_Audio_Figure.setSelectedIndex(13);
		Bitrate_Audio_Figure.setEnabled(false);
		Bitrate_Audio_Figure.setFont(new Font("Dialog", Font.PLAIN, 16));
		Bitrate_Audio_Figure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Bitrate_Audio_Figure);
		Text_Bitrate_Audio_Format.setBounds(AUDIO_RATE_TEXT_X, LINE4_Y, AUDIO_RATE_TEXT_WIDTH, AUDIO_LINE_HEIGHT);
		Text_Bitrate_Audio_Format.setText("Kbit/s");
		Text_Bitrate_Audio_Format.setEnabled(false);
		Text_Bitrate_Audio_Format.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_Bitrate_Audio_Format);
		Text_Length.setBounds(TARGET_TEXT_X, LENGTH_TEXT_Y, TARGET_TEXT_WIDTH, TARGET_TEXT_HEIGHT);
		Text_Length.setText("Length");
		Text_Length.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Length.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Length.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(Text_Length);
		calculate_Length.setBounds(CALCULATE_X, CALCULATE_LENGTH_Y, CALCULATE_WIDTH, CALCULATE_HEIGHT);
		calculate_Length.setText("calculate this");
		calculate_Length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setEditable(true, false, true);
				calculate();
			}
		});
		container.add(calculate_Length);
		Length_hours.setBounds(FIELD1_X, LINE2_Y, TIME_FIELD_WIDTH, LINE_HEIGHT);
		Length_hours.setText("");
		Length_hours.setFont(new Font("Dialog", Font.PLAIN, 18));
		Length_hours.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Length_hours, false);
				calculate();
			}
		});
		container.add(Length_hours);
		Text_Length_h.setBounds(HOURS_TEXT_X, LINE2_Y, HOURS_TEXT_WIDTH, LINE_HEIGHT);
		Text_Length_h.setText("h");
		Text_Length_h.setFont(new Font("Dialog", Font.PLAIN, 18));
		Text_Length_h.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_Length_h);
		Length_minutes.setBounds(FIELD2_X, LINE2_Y, TIME_FIELD_WIDTH, LINE_HEIGHT);
		Length_minutes.setText("");
		Length_minutes.setFont(new Font("Dialog", Font.PLAIN, 18));
		Length_minutes.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Length_minutes, false);
				calculate();
			}
		});
		container.add(Length_minutes);
		Text_Length_min.setBounds(MINUTES_TEXT_X, LINE2_Y, MINUTES_TEXT_WIDTH, LINE_HEIGHT);
		Text_Length_min.setText("min");
		Text_Length_min.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_Length_min);
		Length_seconds.setBounds(FIELD3_X, LINE2_Y, TIME_FIELD_WIDTH, LINE_HEIGHT);
		Length_seconds.setText("");
		Length_seconds.setFont(new Font("Dialog", Font.PLAIN, 18));
		Length_seconds.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Length_seconds, false);
				calculate();
			}
		});
		container.add(Length_seconds);
		Text_Length_s.setBounds(SECONDS_TEXT_X, LINE2_Y, SECONDS_TEXT_WIDTH, LINE_HEIGHT);
		Text_Length_s.setText("s");
		Text_Length_s.setFont(new Font("Dialog", Font.PLAIN, 18));
		container.add(Text_Length_s);
		Text_Bitrate.setBounds(TARGET_TEXT_X, RATE_TEXT_Y, TARGET_TEXT_WIDTH, TARGET_TEXT_HEIGHT);
		Text_Bitrate.setText("Bitrate");
		Text_Bitrate.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Bitrate.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Bitrate.setFont(new Font("Dialog", Font.BOLD, 25));
		container.add(Text_Bitrate);
		calculate_Bitrate.setBounds(CALCULATE_X, CALCULATE_RATE_Y, CALCULATE_WIDTH, CALCULATE_HEIGHT);
		calculate_Bitrate.setText("calculate this");
		calculate_Bitrate.setSelected(true);
		calculate_Bitrate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setEditable(true, true, false);
				calculate();
			}
		});
		container.add(calculate_Bitrate);
		Bitrate_Figure.setBounds(FIELD1_X, LINE3_Y, RATE_FIELD_WIDTH, LINE_HEIGHT);
		Bitrate_Figure.setText("");
		Bitrate_Figure.setFont(new Font("Dialog", Font.PLAIN, 18));
		Bitrate_Figure.setEnabled(true);
		Bitrate_Figure.setEditable(false);
		Bitrate_Figure.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent evt) {
				Helper.sanitiseField(Bitrate_Figure, false);
				calculate();
			}
		});
		container.add(Bitrate_Figure);
		Bitrate_Format_Size.setBounds(RATE_SIZE_UNIT_X, LINE3_Y, SIZE_UNIT_WIDTH, LINE_HEIGHT);
		Bitrate_Format_Size.setFont(new Font("Dialog", Font.PLAIN, 18));
		Bitrate_Format_Size
				.setModel(new DefaultComboBoxModel<String>(new String[] { "b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB" }));
		Bitrate_Format_Size.setSelectedIndex(1);
		Bitrate_Format_Size.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Bitrate_Format_Size);
		Text_Bitrate_Slash.setBounds(SLASH_X, SLASH_Y, SLASH_WIDTH, SLASH_HEIGHT);
		Text_Bitrate_Slash.setText("/");
		Text_Bitrate_Slash.setFont(new Font("Dialog", Font.PLAIN, 40));
		Text_Bitrate_Slash.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Bitrate_Slash.setHorizontalTextPosition(SwingConstants.CENTER);
		container.add(Text_Bitrate_Slash);
		Bitrate_Format_Length.setBounds(RATE_TIME_UNIT_X, LINE3_Y, TIME_UNIT_WIDTH, LINE_HEIGHT);
		Bitrate_Format_Length.setFont(new Font("Dialog", Font.PLAIN, 18));
		Bitrate_Format_Length.setModel(new DefaultComboBoxModel<String>(new String[] { "s", "min", "h", "d" }));
		Bitrate_Format_Length.setMaximumRowCount(4);
		Bitrate_Format_Length.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Bitrate_Format_Length);
		Bitrate_K1024.setBounds(K_X, LINE3_K1_Y, K_WIDTH, K_HEIGHT);
		Bitrate_K1024.setText("K = 1024");
		Bitrate_K1024.setSelected(true);
		Bitrate_K1024.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Bitrate_K1024);
		Bitrate_K1000.setBounds(K_X, LINE3_K2_Y, K_WIDTH, K_HEIGHT);
		Bitrate_K1000.setText("K = 1000");
		Bitrate_K1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculate();
			}
		});
		container.add(Bitrate_K1000);
		
		Bitrate_K_Group.add(Bitrate_K1024);
		Bitrate_K_Group.add(Bitrate_K1000);
		calculate_Group.add(calculate_Filesize);
		calculate_Group.add(calculate_Length);
		calculate_Group.add(calculate_Bitrate);
		
		
		setTooltips();
		setVisible(true);
	}
	
	
	
	private void calculate() {
		if (calculate_Filesize.isSelected()) {
			calculateFilesize();
			return;
		} else if (calculate_Length.isSelected()) {
			calculateLength();
			return;
		} else if (calculate_Bitrate.isSelected()) {
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
			bits = BigDecimal.valueOf(Double.parseDouble(Filesize_Figure.getText()));
		} catch (NumberFormatException e) {
			bits = new BigDecimal(0);
		}
		long[] toBits;
		if (Filesize_K1000.isSelected()) {
			long[] temp = { 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L,
					1000000000L };
			toBits = temp;
		} else {
			long[] temp = { 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L,
					1073741824L };
			toBits = temp;
		}
		bits = bits.multiply(BigDecimal.valueOf(toBits[Filesize_Format.getSelectedIndex()]));
		return bits;
	}
	
	private BigDecimal getLength() {
		BigDecimal seconds, minutes, hours;
		try {
			seconds = BigDecimal.valueOf(Helper.parseDouble(Length_seconds.getText()));
		} catch (NumberFormatException e) {
			seconds = new BigDecimal(0);
		}
		try {
			minutes = BigDecimal.valueOf(Helper.parseDouble(Length_minutes.getText()));
		} catch (NumberFormatException e) {
			minutes = new BigDecimal(0);
		}
		try {
			hours = BigDecimal.valueOf(Helper.parseDouble(Length_hours.getText()));
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
			bitsPerSecond = new BigDecimal(Helper.parseDouble(Bitrate_Figure.getText()));
		} catch (NumberFormatException e) {
			bitsPerSecond = new BigDecimal(0);
		}
		long[] toBPS;
		if (Bitrate_K1000.isSelected()) {
			long[] temp = { 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
			toBPS = temp;
		} else {
			long[] temp = { 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
			toBPS = temp;
		}
		int[] TimeConversion = { 1, 60, 3600, 86400 };
		bitsPerSecond = bitsPerSecond.multiply(BigDecimal.valueOf(toBPS[Bitrate_Format_Size.getSelectedIndex()]));
		bitsPerSecond = bitsPerSecond.divide(
				BigDecimal.valueOf(TimeConversion[Bitrate_Format_Length.getSelectedIndex()]), 0,
				RoundingMode.HALF_UP);
		if (Bitrate_includeAudio.isSelected()) {
			bitsPerSecond = bitsPerSecond.add(getAudioBitrate());
		}
		return bitsPerSecond;
	}
	
	private BigDecimal getAudioBitrate() {
		long[] AudioRate;
		if (Bitrate_K1000.isSelected()) {
			long[] temp = { 20000L, 24000L, 32000L, 48000L, 56000L, 64000L, 80000L, 96000L, 112000L, 128000L, 160000L,
					192000L, 224000L, 256000L, 320000L, 350000L, 384000L };
			AudioRate = temp;
		} else {
			long[] temp = { 20480L, 24576L, 32768L, 49152L, 57344L, 65536L, 81920L, 98304L, 114688L, 131072L, 163840L,
					196608L, 229376L, 262144L, 327680L, 358400L, 393216L };
			AudioRate = temp;
		}
		return BigDecimal.valueOf(AudioRate[Bitrate_Audio_Figure.getSelectedIndex()]);
	}
	
	private void printFilesize(BigDecimal bits) {
		long[] toUnit;
		if (Filesize_K1000.isSelected()) {
			long[] temp = { 8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L,
					1000000000L };
			toUnit = temp;
		} else {
			long[] temp = { 8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L,
					1073741824L };
			toUnit = temp;
		}
		BigDecimal result = bits.divide(new BigDecimal(toUnit[Filesize_Format.getSelectedIndex()]), 4,
				RoundingMode.HALF_UP);
		Filesize_Figure.setText(result.toString());
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
		Length_hours.setText(hours.toString());
		Length_minutes.setText(minutes.toString());
		Length_seconds.setText(seconds.toString());
	}
	
	private void printBitrate(BigDecimal bitsPerSecond) {
		BigDecimal result = bitsPerSecond;
		if (Bitrate_includeAudio.isSelected()) {
			result = result.subtract(getAudioBitrate());
		}
		long[] toUnit;
		if (Bitrate_K1000.isSelected()) {
			long[] temp = { 1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L };
			toUnit = temp;
		} else {
			long[] temp = { 1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L };
			toUnit = temp;
		}
		int[] TimeConversion = { 1, 60, 3600, 86400 };
		result = result.multiply(BigDecimal.valueOf(TimeConversion[Bitrate_Format_Length.getSelectedIndex()]));
		result = result.divide(BigDecimal.valueOf(toUnit[Bitrate_Format_Size.getSelectedIndex()]), 2,
				RoundingMode.HALF_UP);
		Bitrate_Figure.setText(result.toString());
	}
	
	private void setTooltips() {
		Text_Filesize.setToolTipText("The size of the video file");
		calculate_Filesize.setToolTipText("Use the given length and bitrate to calculate the resulting filesize");
		Filesize_Figure.setToolTipText("Enter the given filesize here");
		Filesize_Format.setToolTipText("Select the format for the filesize");
		Filesize_K1024.setToolTipText("1 MB = 1024 B");
		Filesize_K1000.setToolTipText("1 MB = 1000 B");
		
		Text_Length.setToolTipText("The length of the video");
		calculate_Length.setToolTipText("Use the given filesize and bitrate to calculate the resulting video length");
		Length_hours.setToolTipText("Enter the given video length here");
		Text_Length_h.setToolTipText("Hours");
		Length_minutes.setToolTipText("Enter the given video length here");
		Text_Length_min.setToolTipText("Minutes");
		Length_seconds.setToolTipText("Enter the given video length here");
		Text_Length_s.setToolTipText("Seconds");
		
		Text_Bitrate.setToolTipText("The bitrate of the video");
		calculate_Bitrate.setToolTipText("Use the given filesize and video length to calculate the resulting bitrate");
		Bitrate_Figure.setToolTipText("Enter the given video stream bitrate here");
		Bitrate_Format_Size.setToolTipText("Select a format for the video stream bitrate");
		Bitrate_Format_Length.setToolTipText("Select a format for the video stream bitrate");
		Bitrate_K1024.setToolTipText("1 MB = 1024 B");
		Bitrate_K1000.setToolTipText("1 MB = 1000 B");
		Bitrate_includeAudio.setToolTipText("Factor in an extra audio stream with the given bitrate on the right");
		Bitrate_Audio_Figure.setToolTipText("Enter the bitrate of the audio stream here");
	}
	
	private void Bitrate_includeAudio_ActionPerformed(ActionEvent evt) {
		Bitrate_Audio_Figure.setEnabled(Bitrate_includeAudio.isSelected());
		Text_Bitrate_Audio_Format.setEnabled(Bitrate_includeAudio.isSelected());
		calculate();
	}
	
	private void setEditable(boolean size, boolean length, boolean bitrate) {
		Filesize_Figure.setEditable(size);
		Length_hours.setEditable(length);
		Length_minutes.setEditable(length);
		Length_seconds.setEditable(length);
		Bitrate_Figure.setEditable(bitrate);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new BitrateGenerator(null);
		
	}
	
}