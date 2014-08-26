import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
  * @version 1.0, 2.11.2011
  * @author Simon Vetter
  */

public class BitrateConverter extends JFrame {
  private JLabel Text_Title = new JLabel();
  private JNumberField Rate_given = new JNumberField();
  private JComboBox Unit_Size_given = new JComboBox();
  private JRadioButton K_given_1024 = new JRadioButton();
  private JRadioButton K_given_1000 = new JRadioButton();
  private ButtonGroup K_given = new ButtonGroup();
  private JSeparator verticalLine = new JSeparator();
  private JNumberField Rate_wanted = new JNumberField();
  private JComboBox Unit_Size_wanted = new JComboBox();
  private JRadioButton K_wanted_1024 = new JRadioButton();
  private JRadioButton K_wanted_1000 = new JRadioButton();
  private ButtonGroup K_wanted = new ButtonGroup();
  private JComboBox Unit_Time_given = new JComboBox();
  private JComboBox Unit_Time_wanted = new JComboBox();
  private JLabel Text_Slash1 = new JLabel();
  private JLabel Text_Slash2 = new JLabel();
  private JButton About_Button = new JButton();
  private JToggleButton Help_Button = new JToggleButton();

  public BitrateConverter(String title) {
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 570; 
    int frameHeight = 230;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2 + 508;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);

    Text_Title.setBounds(90, 0, 380, 55);
    Text_Title.setText("Bitrate Converter");
    Text_Title.setToolTipText("v1.0 © Simon Vetter 2011");
    Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
    Text_Title.setEnabled(true);
    cp.add(Text_Title);
    Rate_given.setBounds(20, 65, 300, 35);
    Rate_given.setText("");
    Rate_given.setFont(new Font("Dialog", Font.PLAIN, 18));
    Rate_given.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Rate_given_KeyReleased(evt);
      }
    });
    cp.add(Rate_given);
    Unit_Size_given.setBounds(330, 65, 60, 35);
    Unit_Size_given.setModel(new DefaultComboBoxModel(new String[] {"b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB"}));
    Unit_Size_given.setSelectedIndex(1);
    Unit_Size_given.setMaximumRowCount(8);
    Unit_Size_given.setFont(new Font("Dialog", Font.PLAIN, 16));
    Unit_Size_given.setEditable(false);
    Unit_Size_given.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Unit_Size_given_ActionPerformed(evt);
      }
    });
    cp.add(Unit_Size_given);
    K_given_1024.setBounds(470, 62, 80, 20);
    K_given_1024.setText("K = 1024");
    K_given_1024.setSelected(true);
    K_given_1024.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_given_1024_ActionPerformed(evt);
      }
    });
    cp.add(K_given_1024);
    K_given_1000.setBounds(470, 83, 80, 20);
    K_given_1000.setText("K = 1000");
    K_given_1000.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_given_1000_ActionPerformed(evt);
      }
    });
    cp.add(K_given_1000);
    K_given.add(K_given_1024);
    K_given.add(K_given_1000);
    verticalLine.setBounds(20, 125, 520, 1);
    cp.add(verticalLine);
    Rate_wanted.setBounds(20, 150, 300, 35);
    Rate_wanted.setText("0");
    Rate_wanted.setEditable(false);
    Rate_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
    Rate_wanted.setSelectionEnd(0);
    Rate_wanted.setSelectionStart(0);
    cp.add(Rate_wanted);
    Unit_Size_wanted.setBounds(330, 150, 60, 35);
    Unit_Size_wanted.setEditable(false);
    Unit_Size_wanted.setFont(new Font("Dialog", Font.PLAIN, 16));
    Unit_Size_wanted.setMaximumRowCount(8);
    Unit_Size_wanted.setModel(new DefaultComboBoxModel(new String[] {"b", "Kb", "Mb", "Gb", "B", "KB", "MB", "GB"}));
    Unit_Size_wanted.setSelectedIndex(1);
    Unit_Size_wanted.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Unit_Size_wanted_ActionPerformed(evt);
      }
    });
    cp.add(Unit_Size_wanted);
    K_wanted_1024.setBounds(470, 147, 80, 20);
    K_wanted_1024.setText("K = 1024");
    K_wanted_1024.setSelected(true);
    K_wanted_1024.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_wanted_1024_ActionPerformed(evt);
      }
    });
    cp.add(K_wanted_1024);
    K_wanted_1000.setBounds(470, 168, 80, 20);
    K_wanted_1000.setText("K = 1000");
    K_wanted_1000.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_wanted_1000_ActionPerformed(evt);
      }
    });
    cp.add(K_wanted_1000);
    K_wanted.add(K_wanted_1024);
    K_wanted.add(K_wanted_1000);
    Unit_Time_given.setBounds(410, 65, 50, 35);
    Unit_Time_given.setModel(new DefaultComboBoxModel(new String[] {"s", "min", "h", "d"}));
    Unit_Time_given.setSelectedIndex(0);
    Unit_Time_given.setEditable(false);
    Unit_Time_given.setFont(new Font("Dialog", Font.PLAIN, 16));
    Unit_Time_given.setMaximumRowCount(4);
    Unit_Time_given.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Unit_Time_given_ActionPerformed(evt);
      }
    });
    cp.add(Unit_Time_given);
    Unit_Time_wanted.setBounds(410, 150, 50, 35);
    Unit_Time_wanted.setModel(new DefaultComboBoxModel(new String[] {"s", "min", "h", "d"}));
    Unit_Time_wanted.setEditable(false);
    Unit_Time_wanted.setFont(new Font("Dialog", Font.PLAIN, 16));
    Unit_Time_wanted.setMaximumRowCount(4);
    Unit_Time_wanted.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Unit_Time_wanted_ActionPerformed(evt);
      }
    });
    cp.add(Unit_Time_wanted);
    Text_Slash1.setBounds(390, 58, 20, 50);
    Text_Slash1.setText("/");
    Text_Slash1.setFont(new Font("Dialog", Font.PLAIN, 40));
    Text_Slash1.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Slash1.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(Text_Slash1);
    Text_Slash2.setBounds(390, 143, 20, 50);
    Text_Slash2.setText("/");
    Text_Slash2.setFont(new Font("Dialog", Font.PLAIN, 40));
    Text_Slash2.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Slash2.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(Text_Slash2);
    About_Button.setBounds(20, 15, 70, 30);
    About_Button.setText("About");
    About_Button.setMargin(new Insets(2, 2, 2, 2));
    About_Button.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        About_Button_ActionPerformed(evt);
      }
    });
    About_Button.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(About_Button);
    Help_Button.setBounds(470, 15, 70, 30);
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

  private String getSelectedRadioButton(ButtonGroup bg) {
    for (java.util.Enumeration<AbstractButton> e = bg.getElements(); e.hasMoreElements();) {
      AbstractButton b = e.nextElement();
      if (b.isSelected()) return b.getText();
    }
    return null;
  }

  public void Rate_given_KeyReleased(KeyEvent evt) {
    if (!Rate_given.getText().equals(Rate_given.getText().replace(',', '.'))) {
      Rate_given.setText(Rate_given.getText().replace(',', '.'));
    }
    try {
      if (Rate_given.getDouble() < 0.) {
        Rate_given.setText(Rate_given.getText().substring(Rate_given.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  private void Unit_Size_given_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void Unit_Time_given_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void Unit_Size_wanted_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void Unit_Time_wanted_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void K_given_1024_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void K_given_1000_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void K_wanted_1024_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void K_wanted_1000_ActionPerformed(ActionEvent evt) {
    calculate();
  }

  
  private void calculate() {
    double check;
    try {
      check = Rate_given.getDouble();
    } catch (java.lang.NumberFormatException e) {
      Rate_wanted.setText("0");
      return;
    }
    if (!(check > 0.)) {
      Rate_wanted.setText("0");
      return;
    }

    BigDecimal value = new BigDecimal(0);
    value = value.valueOf(Rate_given.getDouble());

    long[] SizeToBits = new long[10], SizeToUnit = new long[10];
    if (getSelectedRadioButton(K_given).equals("K = 1000")) {
      long[] temp = {1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L};
      SizeToBits = temp;
    }
    else {
      long[] temp = {1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L};
      SizeToBits = temp;
    }
    if (getSelectedRadioButton(K_wanted).equals("K = 1000")) {
      long[] temp = {1L, 1000L, 1000000L, 1000000000L, 8L, 8000L, 8000000L, 8000000000L};
      SizeToUnit = temp;
    }
    else {
      long[] temp = {1L, 1024L, 1048576L, 1073741824L, 8L, 8192L, 8388608L, 8589934592L};
      SizeToUnit = temp;
    }
    int[] TimeConversion = {1, 60, 3600, 86400};
    
    value = value.multiply(BigDecimal.valueOf(SizeToBits[Unit_Size_given.getSelectedIndex()] * (long) TimeConversion[Unit_Time_wanted.getSelectedIndex()]));
    value = value.divide(BigDecimal.valueOf(SizeToUnit[Unit_Size_wanted.getSelectedIndex()] * (long) TimeConversion[Unit_Time_given.getSelectedIndex()]), 4, BigDecimal.ROUND_HALF_UP);
    
    Rate_wanted.setText(value.toString());
  }

  public void About_Button_ActionPerformed(ActionEvent evt) {
    new About(this, "About Bitrate Converter", true);
  }

  public void Help_Button_ActionPerformed(ActionEvent evt) {
    if (Help_Button.isSelected()) {
    Rate_given.setToolTipText("enter the bitrate you want to convert here");
    Unit_Size_given.setToolTipText("select the unit for the given bitrate");
    Unit_Time_given.setToolTipText("select the unit for the given bitrate");
      K_given_1024.setToolTipText("1 MB = 1024 B");
      K_given_1000.setToolTipText("1 MB = 1000 B");
      verticalLine.setToolTipText("found me!");
      Rate_wanted.setToolTipText("that's your result!");
      Unit_Size_wanted.setToolTipText("select the unit for your result");
      Unit_Time_wanted.setToolTipText("select the unit for your result");
      K_wanted_1024.setToolTipText("1 MB = 1024 B");
      K_wanted_1000.setToolTipText("1 MB = 1000 B");
    }
    else {
      Rate_given.setToolTipText(null);
      Unit_Size_given.setToolTipText(null);
      Unit_Time_given.setToolTipText(null);
      K_given_1024.setToolTipText(null);
      K_given_1000.setToolTipText(null);
      verticalLine.setToolTipText(null);
      Rate_wanted.setToolTipText(null);
      Unit_Size_wanted.setToolTipText(null);
      Unit_Time_wanted.setToolTipText(null);
      K_wanted_1024.setToolTipText(null);
      K_wanted_1000.setToolTipText(null);
    }

    
  }


  public static void main(String[] args) {
    new BitrateConverter("Bitrate Converter");
  }
}