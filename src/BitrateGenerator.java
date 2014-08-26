import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
  * @version 1.0.1, 24.11.2011
  * @author Simon Vetter
  */

public class BitrateGenerator extends JFrame {
  private JLabel Text_Title = new JLabel();
  private JSeparator Seperator_h_top = new JSeparator();
  private JSeparator Seperator_h_uppermid = new JSeparator();
  private JSeparator Seperator_h_lowermid = new JSeparator();
  private JSeparator Seperator_h_bottom = new JSeparator();
  private JSeparator Seperator_v_left = new JSeparator();
  private JSeparator Seperator_v_mid = new JSeparator();
  private JSeparator Seperator_v_right = new JSeparator();
  private JLabel Text_Filesize = new JLabel();
  private JRadioButton calculate_Filesize = new JRadioButton();
  private JNumberField Filesize_Figure = new JNumberField();
  private JComboBox Filesize_Format = new JComboBox();
  private JRadioButton Filesize_K1024 = new JRadioButton();
  private JRadioButton Filesize_K1000 = new JRadioButton();
  private ButtonGroup Filesize_K_Group = new ButtonGroup();
  private JCheckBox Bitrate_includeAudio = new JCheckBox();
  private JComboBox Bitrate_Audio_Figure = new JComboBox();
  private JLabel Text_Bitrate_Audio_Format = new JLabel();
  private JLabel Text_Length = new JLabel();
  private JRadioButton calculate_Length = new JRadioButton();
  private JNumberField Length_hours = new JNumberField();
  private JLabel Text_Length_h = new JLabel();
  private JNumberField Length_minutes = new JNumberField();
  private JLabel Text_Length_min = new JLabel();
  private JNumberField Length_seconds = new JNumberField();
  private JLabel Text_Length_s = new JLabel();
  private JLabel Text_Bitrate = new JLabel();
  private JRadioButton calculate_Bitrate = new JRadioButton();
  private JNumberField Bitrate_Figure = new JNumberField();
  private JComboBox Bitrate_Format_Size = new JComboBox();
  private JLabel Text_Bitrate_Slash = new JLabel();
  private JComboBox Bitrate_Format_Length = new JComboBox();
  private JRadioButton Bitrate_K1024 = new JRadioButton();
  private JRadioButton Bitrate_K1000 = new JRadioButton();
  private ButtonGroup Bitrate_K_Group = new ButtonGroup();
  private ButtonGroup calculate_Group = new ButtonGroup();
  private JButton About_Button = new JButton();
  private JToggleButton Help_Button = new JToggleButton();

  public BitrateGenerator(String title) {
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 547; 
    int frameHeight = 332;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2 - 329;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);

    Text_Title.setBounds(90, 0, 360, 55);
    Text_Title.setText("Bitrate Generator");
    Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
    Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Title.setToolTipText("v1.0.1 © Simon Vetter 2011");
    cp.add(Text_Title);
    Seperator_h_top.setBounds(10, 65, 521, 1);
    cp.add(Seperator_h_top);
    Seperator_h_uppermid.setBounds(12, 130, 517, 1);
    cp.add(Seperator_h_uppermid);
    Seperator_h_lowermid.setBounds(12, 195, 517, 1);
    cp.add(Seperator_h_lowermid);
    Seperator_h_bottom.setBounds(12, 295, 519, 1);
    cp.add(Seperator_h_bottom);
    Seperator_v_left.setBounds(10, 65, 1, 231);
    Seperator_v_left.setOrientation(SwingConstants.VERTICAL);
    cp.add(Seperator_v_left);
    Seperator_v_mid.setBounds(130, 67, 1, 227);
    Seperator_v_mid.setOrientation(SwingConstants.VERTICAL);
    cp.add(Seperator_v_mid);
    Seperator_v_right.setBounds(530, 67, 1, 229);
    Seperator_v_right.setOrientation(SwingConstants.VERTICAL);
    cp.add(Seperator_v_right);
    Text_Filesize.setBounds(15, 70, 110, 35);
    Text_Filesize.setText("Filesize");
    Text_Filesize.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Filesize.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Filesize.setFont(new Font("Dialog", Font.BOLD, 25));
    cp.add(Text_Filesize);
    calculate_Filesize.setBounds(20, 105, 105, 20);
    calculate_Filesize.setText("calculate this");
    calculate_Filesize.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        calculate_Filesize_ActionPerformed(evt);
      }
    });
    cp.add(calculate_Filesize);
    Filesize_Figure.setBounds(145, 80, 220, 35);
    Filesize_Figure.setText("");
    Filesize_Figure.setFont(new Font("Dialog", Font.PLAIN, 18));
    Filesize_Figure.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Filesize_Figure_KeyReleased(evt);
      }
    });
    cp.add(Filesize_Figure);
    Filesize_Format.setBounds(375, 80, 60, 35);
    Filesize_Format.setModel(new DefaultComboBoxModel(new String[] {"B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb"}));
    Filesize_Format.setFont(new Font("Dialog", Font.PLAIN, 18));
    Filesize_Format.setSelectedIndex(2);
    Filesize_Format.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Filesize_Format_ActionPerformed(evt);
      }
    });
    Filesize_Format.setMaximumRowCount(10);
    cp.add(Filesize_Format);
    Filesize_K1024.setBounds(445, 77, 80, 20);
    Filesize_K1024.setText("K = 1024");
    Filesize_K1024.setSelected(true);
    Filesize_K1024.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Filesize_K1024_ActionPerformed(evt);
      }
    });
    cp.add(Filesize_K1024);
    Filesize_K1000.setBounds(445, 98, 80, 20);
    Filesize_K1000.setText("K = 1000");
    Filesize_K1000.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Filesize_K1000_ActionPerformed(evt);
      }
    });
    cp.add(Filesize_K1000);
    Filesize_K_Group.add(Filesize_K1024);
    Filesize_K_Group.add(Filesize_K1000);
    Bitrate_includeAudio.setBounds(145, 255, 150, 30);
    Bitrate_includeAudio.setText(" Audio stream:");
    Bitrate_includeAudio.setFont(new Font("Dialog", Font.PLAIN, 16));
    Bitrate_includeAudio.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Bitrate_includeAudio_ActionPerformed(evt);
      }
    });
    cp.add(Bitrate_includeAudio);
    Bitrate_Audio_Figure.setBounds(300, 255, 60, 30);
    Bitrate_Audio_Figure.setEditable(false);
    Bitrate_Audio_Figure.setModel(new DefaultComboBoxModel(new String[] {"20", "24", "32", "48", "56", "64", "80", "96", "112", "128", "160", "192", "224", "256", "320", "350", "384"}));
    Bitrate_Audio_Figure.setSelectedIndex(13);
    Bitrate_Audio_Figure.setEnabled(false);
    Bitrate_Audio_Figure.setFont(new Font("Dialog", Font.PLAIN, 16));
    Bitrate_Audio_Figure.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Bitrate_Audio_Figure_ActionPerformed(evt);
      }
    });
    cp.add(Bitrate_Audio_Figure);
    Text_Bitrate_Audio_Format.setBounds(370, 255, 50, 30);
    Text_Bitrate_Audio_Format.setText("Kbit/s");
    Text_Bitrate_Audio_Format.setEnabled(false);
    Text_Bitrate_Audio_Format.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_Bitrate_Audio_Format);
    Text_Length.setBounds(15, 135, 110, 35);
    Text_Length.setText("Length");
    Text_Length.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Length.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Length.setFont(new Font("Dialog", Font.BOLD, 25));
    cp.add(Text_Length);
    calculate_Length.setBounds(20, 170, 105, 20);
    calculate_Length.setText("calculate this");
    calculate_Length.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        calculate_Length_ActionPerformed(evt);
      }
    });
    cp.add(calculate_Length);
    Length_hours.setBounds(145, 145, 80, 35);
    Length_hours.setText("");
    Length_hours.setFont(new Font("Dialog", Font.PLAIN, 18));
    Length_hours.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Length_hours_KeyReleased(evt);
      }
    });
    cp.add(Length_hours);
    Text_Length_h.setBounds(230, 145, 20, 35);
    Text_Length_h.setText("h");
    Text_Length_h.setFont(new Font("Dialog", Font.PLAIN, 18));
    Text_Length_h.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(Text_Length_h);
    Length_minutes.setBounds(255, 145, 80, 35);
    Length_minutes.setText("");
    Length_minutes.setFont(new Font("Dialog", Font.PLAIN, 18));
    Length_minutes.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Length_minutes_KeyReleased(evt);
      }
    });
    cp.add(Length_minutes);
    Text_Length_min.setBounds(340, 145, 35, 35);
    Text_Length_min.setText("min");
    Text_Length_min.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_Length_min);
    Length_seconds.setBounds(380, 145, 80, 35);
    Length_seconds.setText("");
    Length_seconds.setFont(new Font("Dialog", Font.PLAIN, 18));
    Length_seconds.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Length_seconds_KeyReleased(evt);
      }
    });
    cp.add(Length_seconds);
    Text_Length_s.setBounds(465, 145, 20, 35);
    Text_Length_s.setText("s");
    Text_Length_s.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_Length_s);
    Text_Bitrate.setBounds(15, 210, 110, 35);
    Text_Bitrate.setText("Bitrate");
    Text_Bitrate.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Bitrate.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Bitrate.setFont(new Font("Dialog", Font.BOLD, 25));
    cp.add(Text_Bitrate);
    calculate_Bitrate.setBounds(20, 245, 105, 20);
    calculate_Bitrate.setText("calculate this");
    calculate_Bitrate.setSelected(true);
    calculate_Bitrate.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        calculate_Bitrate_ActionPerformed(evt);
      }
    });
    cp.add(calculate_Bitrate);
    Bitrate_Figure.setBounds(145, 210, 145, 35);
    Bitrate_Figure.setText("");
    Bitrate_Figure.setFont(new Font("Dialog", Font.PLAIN, 18));
    Bitrate_Figure.setEnabled(true);
    Bitrate_Figure.setEditable(false);
    Bitrate_Figure.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Bitrate_Figure_KeyReleased(evt);
      }
    });
    cp.add(Bitrate_Figure);
    Bitrate_Format_Size.setBounds(300, 210, 60, 35);
    Bitrate_Format_Size.setFont(new Font("Dialog", Font.PLAIN, 18));
    Bitrate_Format_Size.setModel(new DefaultComboBoxModel(new String[] {"b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB"}));
    Bitrate_Format_Size.setSelectedIndex(1);
    Bitrate_Format_Size.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Bitrate_Format_Size_ActionPerformed(evt);
      }
    });
    cp.add(Bitrate_Format_Size);
    Text_Bitrate_Slash.setBounds(360, 203, 20, 50);
    Text_Bitrate_Slash.setText("/");
    Text_Bitrate_Slash.setFont(new Font("Dialog", Font.PLAIN, 40));
    Text_Bitrate_Slash.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Bitrate_Slash.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(Text_Bitrate_Slash);
    Bitrate_Format_Length.setBounds(380, 210, 55, 35);
    Bitrate_Format_Length.setFont(new Font("Dialog", Font.PLAIN, 18));
    Bitrate_Format_Length.setModel(new DefaultComboBoxModel(new String[] {"s", "min", "h", "d"}));
    Bitrate_Format_Length.setMaximumRowCount(4);
    Bitrate_Format_Length.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Bitrate_Format_Length_ActionPerformed(evt);
      }
    });
    cp.add(Bitrate_Format_Length);
    Bitrate_K1024.setBounds(445, 207, 80, 20);
    Bitrate_K1024.setText("K = 1024");
    Bitrate_K1024.setSelected(true);
    Bitrate_K1024.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Bitrate_K1024_ActionPerformed(evt);
      }
    });
    cp.add(Bitrate_K1024);
    Bitrate_K1000.setBounds(445, 229, 80, 20);
    Bitrate_K1000.setText("K = 1000");
    Bitrate_K1000.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Bitrate_K1000_ActionPerformed(evt);
      }
    });
    cp.add(Bitrate_K1000);
    Bitrate_K_Group.add(Bitrate_K1024);
    Bitrate_K_Group.add(Bitrate_K1000);
    calculate_Group.add(calculate_Filesize);
    calculate_Group.add(calculate_Length);
    calculate_Group.add(calculate_Bitrate);
    About_Button.setBounds(20, 15, 70, 30);
    About_Button.setText("About");
    About_Button.setMargin(new Insets(2, 2, 2, 2));
    About_Button.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        About_Button_ActionPerformed(evt);
      }
    });
    cp.add(About_Button);
    Help_Button.setBounds(450, 15, 70, 30);
    Help_Button.setText("Help");
    Help_Button.setMargin(new Insets(2, 2, 2, 2));
    Help_Button.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Help_Button_ActionPerformed(evt);
      }
    });
    Help_Button.setToolTipText("switches tooltips on/off");
    cp.add(Help_Button);

    setVisible(true);
  }






  private void calculate() {
    if (calculate_Filesize.isSelected()) {
      calculateFilesize();
      return;
    }
    else if (calculate_Length.isSelected()) {
      calculateLength();
      return;
    }
    else if (calculate_Bitrate.isSelected()) {
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
      result = bits.divide(bitsPerSecond, 2, BigDecimal.ROUND_HALF_UP);
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
      result = bits.divide(seconds, 0, BigDecimal.ROUND_HALF_UP);
    } catch (Exception e) {
      result = new BigDecimal(0);
    }
    printBitrate(result);
  }
  
  private BigDecimal getFilesize() {
    BigDecimal bits;
    try {
      bits = BigDecimal.valueOf(Filesize_Figure.getDouble());
    } catch (NumberFormatException e) {
      bits = new BigDecimal(0);
    }
    long[] toBits;
    if (Filesize_K1000.isSelected()) {
      long[] temp = {8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L};
      toBits = temp;
    }
    else {
      long[] temp = {8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L};
      toBits = temp;
    }
    bits = bits.multiply(BigDecimal.valueOf(toBits[Filesize_Format.getSelectedIndex()]));
    return bits;
  }
  private BigDecimal getLength() {
    BigDecimal seconds, minutes, hours;
    try {
      seconds = BigDecimal.valueOf(Length_seconds.getDouble());
    } catch (NumberFormatException e) {
      seconds = new BigDecimal(0);
    }
    try {
      minutes = BigDecimal.valueOf(Length_minutes.getDouble());
    } catch (NumberFormatException e) {
      minutes = new BigDecimal(0);
    }
    try {
      hours = BigDecimal.valueOf(Length_hours.getDouble());
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
      bitsPerSecond = new BigDecimal(Bitrate_Figure.getDouble());
    } catch (NumberFormatException e) {
      bitsPerSecond = new BigDecimal(0);
    }
    long[] toBPS;
    if (Bitrate_K1000.isSelected()) {
      long[] temp = {1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L};
      toBPS = temp;
    }
    else {
      long[] temp = {1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L};
      toBPS = temp;
    }
    int[] TimeConversion = {1, 60, 3600, 86400};
    bitsPerSecond = bitsPerSecond.multiply(BigDecimal.valueOf(toBPS[Bitrate_Format_Size.getSelectedIndex()]));
    bitsPerSecond = bitsPerSecond.divide(BigDecimal.valueOf(TimeConversion[Bitrate_Format_Length.getSelectedIndex()]), 0, BigDecimal.ROUND_HALF_UP);
    if (Bitrate_includeAudio.isSelected()) {
      bitsPerSecond = bitsPerSecond.add(getAudioBitrate());
    }
    return bitsPerSecond;
  }
  private BigDecimal getAudioBitrate() {
    long[] AudioRate;
    if (Bitrate_K1000.isSelected()) {
      long[] temp = {20000L, 24000L, 32000L, 48000L, 56000L, 64000L, 80000L, 96000L, 112000L, 128000L, 160000L, 192000L, 224000L, 256000L, 320000L, 350000L, 384000L};
      AudioRate = temp;
    }
    else {
      long[] temp = {20480L, 24576L, 32768L, 49152L, 57344L, 65536L, 81920L, 98304L, 114688L, 131072L, 163840L, 196608L, 229376L, 262144L, 327680L, 358400L, 393216L};
       AudioRate = temp;
    }
    return BigDecimal.valueOf(AudioRate[Bitrate_Audio_Figure.getSelectedIndex()]);
  }
  
  private void printFilesize(BigDecimal bits) {
    long[] toUnit;
    if (Filesize_K1000.isSelected()) {
      long[] temp = {8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L};
      toUnit = temp;
    }
    else {
      long[] temp = {8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L};
      toUnit = temp;
    }
    BigDecimal result = bits.divide(new BigDecimal(toUnit[Filesize_Format.getSelectedIndex()]), 4, BigDecimal.ROUND_HALF_UP);
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
      long[] temp = {1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L};
      toUnit = temp;
    }
    else {
      long[] temp = {1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L};
      toUnit = temp;
    }
    int[] TimeConversion = {1, 60, 3600, 86400};
    result = result.multiply(BigDecimal.valueOf(TimeConversion[Bitrate_Format_Length.getSelectedIndex()]));
    result = result.divide(BigDecimal.valueOf(toUnit[Bitrate_Format_Size.getSelectedIndex()]), 2, BigDecimal.ROUND_HALF_UP);
    Bitrate_Figure.setText(result.toString());
  }
  

  private String getSelectedRadioButton(ButtonGroup bg) {
    for (java.util.Enumeration<AbstractButton> e = bg.getElements(); e.hasMoreElements();) {
      AbstractButton b = e.nextElement();
      if (b.isSelected()) return b.getText();
    }
    return null;
  }

  private void About_Button_ActionPerformed(ActionEvent evt) {
    new About(this, "About Bitrate Generator", true);
  }

  private void Help_Button_ActionPerformed(ActionEvent evt) {
    if (Help_Button.isSelected()) {
      Seperator_h_top.setToolTipText("found me!");
      Seperator_h_uppermid.setToolTipText("found me!");
      Seperator_h_lowermid.setToolTipText("found me!");
      Seperator_h_bottom.setToolTipText("found me!");
      Seperator_v_left.setToolTipText("found me!");
      Seperator_v_mid.setToolTipText("found me!");
      Seperator_v_right.setToolTipText("found me!");

      Text_Filesize.setToolTipText("the size of your video file");
      calculate_Filesize.setToolTipText("use the given length and bitrate to calculate the resulting filesize");
      Filesize_Figure.setToolTipText("enter the given filesize here");
      Filesize_Format.setToolTipText("select the format for the filesize");
      Filesize_K1024.setToolTipText("1 MB = 1024 B");
      Filesize_K1000.setToolTipText("1 MB = 1000 B");

      Text_Length.setToolTipText("the length of your video");
      calculate_Length.setToolTipText("use the given filesize and bitrate to calculate the resulting video length");
      Length_hours.setToolTipText("enter the given video length here");
      Text_Length_h.setToolTipText("hours");
      Length_minutes.setToolTipText("enter the given video length here");
      Text_Length_min.setToolTipText("minutes");
      Length_seconds.setToolTipText("enter the given video length here");
      Text_Length_s.setToolTipText("seconds");

      Text_Bitrate.setToolTipText("the bitrate of your video stream");
      calculate_Bitrate.setToolTipText("use the given filesize and video length to calculate the resulting bitrate");
      Bitrate_Figure.setToolTipText("enter the given video stream bitrate here");
      Bitrate_Format_Size.setToolTipText("select a format for the video stream bitrate");
      Bitrate_Format_Length.setToolTipText("select a format for the video stream bitrate");
      Bitrate_K1024.setToolTipText("1 MB = 1024 B");
      Bitrate_K1000.setToolTipText("1 MB = 1000 B");
      Bitrate_includeAudio.setToolTipText("factor in an audio stream with the given bitrate on the right");
      Bitrate_Audio_Figure.setToolTipText("enter the bitrate of the audio stream here");
    }
    else {
      Seperator_h_top.setToolTipText(null);
      Seperator_h_uppermid.setToolTipText(null);
      Seperator_h_lowermid.setToolTipText(null);
      Seperator_h_bottom.setToolTipText(null);
      Seperator_v_left.setToolTipText(null);
      Seperator_v_mid.setToolTipText(null);
      Seperator_v_right.setToolTipText(null);
      Text_Filesize.setToolTipText(null);
      calculate_Filesize.setToolTipText(null);
      Filesize_Figure.setToolTipText(null);
      Filesize_Format.setToolTipText(null);
      Filesize_K1024.setToolTipText(null);
      Filesize_K1000.setToolTipText(null);
      Text_Length.setToolTipText(null);
      calculate_Length.setToolTipText(null);
      Length_hours.setToolTipText(null);
      Text_Length_h.setToolTipText(null);
      Length_minutes.setToolTipText(null);
      Text_Length_min.setToolTipText(null);
      Length_seconds.setToolTipText(null);
      Text_Length_s.setToolTipText(null);
      Text_Bitrate.setToolTipText(null);
      calculate_Bitrate.setToolTipText(null);
      Bitrate_Figure.setToolTipText(null);
      Bitrate_Format_Size.setToolTipText(null);
      Bitrate_Format_Length.setToolTipText(null);
      Bitrate_K1024.setToolTipText(null);
      Bitrate_K1000.setToolTipText(null);
      Bitrate_includeAudio.setToolTipText(null);
      Bitrate_Audio_Figure.setToolTipText(null);
    }
  }

  public void Bitrate_includeAudio_ActionPerformed(ActionEvent evt) {
    Bitrate_Audio_Figure.setEnabled(Bitrate_includeAudio.isSelected());
    Text_Bitrate_Audio_Format.setEnabled(Bitrate_includeAudio.isSelected());
    calculate();
  }

  public void calculate_Filesize_ActionPerformed(ActionEvent evt) {
    Filesize_Figure.setEditable(false);
    Length_hours.setEditable(true);
    Length_minutes.setEditable(true);
    Length_seconds.setEditable(true);
    Bitrate_Figure.setEditable(true);
    calculate();
  }
  public void calculate_Length_ActionPerformed(ActionEvent evt) {
    Filesize_Figure.setEditable(true);
    Length_hours.setEditable(false);
    Length_minutes.setEditable(false);
    Length_seconds.setEditable(false);
    Bitrate_Figure.setEditable(true);
    calculate();
  }
  public void calculate_Bitrate_ActionPerformed(ActionEvent evt) {
    Filesize_Figure.setEditable(true);
    Length_hours.setEditable(true);
    Length_minutes.setEditable(true);
    Length_seconds.setEditable(true);
    Bitrate_Figure.setEditable(false);
    calculate();
  }
  

  
  public void Filesize_Figure_KeyReleased(KeyEvent evt) {
    if (!Filesize_Figure.getText().equals(Filesize_Figure.getText().replace(',', '.'))) {
      Filesize_Figure.setText(Filesize_Figure.getText().replace(',', '.'));
    }
    try {
      if (Filesize_Figure.getDouble() < 0.) {
        Filesize_Figure.setText(Filesize_Figure.getText().substring(Filesize_Figure.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Length_hours_KeyReleased(KeyEvent evt) {
    if (!Length_hours.getText().equals(Length_hours.getText().replace(',', '.'))) {
      Length_hours.setText(Length_hours.getText().replace(',', '.'));
    }
    try {
      if (Length_hours.getDouble() < 0.) {
        Length_hours.setText(Length_hours.getText().substring(Length_hours.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Length_minutes_KeyReleased(KeyEvent evt) {
    if (!Length_minutes.getText().equals(Length_minutes.getText().replace(',', '.'))) {
      Length_minutes.setText(Length_minutes.getText().replace(',', '.'));
    }
    try {
      if (Length_minutes.getDouble() < 0.) {
        Length_minutes.setText(Length_minutes.getText().substring(Length_minutes.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Length_seconds_KeyReleased(KeyEvent evt) {
    if (!Length_seconds.getText().equals(Length_seconds.getText().replace(',', '.'))) {
      Length_seconds.setText(Length_seconds.getText().replace(',', '.'));
    }
    try {
      if (Length_seconds.getDouble() < 0.) {
        Length_seconds.setText(Length_seconds.getText().substring(Length_seconds.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Bitrate_Figure_KeyReleased(KeyEvent evt) {
    if (!Bitrate_Figure.getText().equals(Bitrate_Figure.getText().replace(',', '.'))) {
      Bitrate_Figure.setText(Bitrate_Figure.getText().replace(',', '.'));
    }
    try {
      if (Bitrate_Figure.getDouble() < 0.) {
        Bitrate_Figure.setText(Bitrate_Figure.getText().substring(Bitrate_Figure.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }


  public void Filesize_K1024_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Filesize_K1000_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Bitrate_K1024_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Bitrate_K1000_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Filesize_Format_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Bitrate_Format_Size_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Bitrate_Format_Length_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  public void Bitrate_Audio_Figure_ActionPerformed(ActionEvent evt) {
    calculate();
  }


  public static void main(String[] args) {
    new BitrateGenerator("Bitrate Generator");
  }
}
