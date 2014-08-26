import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigDecimal;


/**
  * @version 1.0, 19.11.2011
  * @author Simon Vetter
  */

public class TimeCalculator extends JFrame {
  private JLabel Text_Title = new JLabel();
  private JNumberField Time_hours_given1 = new JNumberField();
  private JLabel Text_l1_h = new JLabel();
  private JNumberField Time_minutes_given1 = new JNumberField();
  private JLabel Text_l1_min = new JLabel();
  private JNumberField Time_seconds_given1 = new JNumberField();
  private JLabel Text_l1_s = new JLabel();
  private JButton switchMode_Button = new JButton();
  private JSeparator Seperator_h_top = new JSeparator();
  private JSeparator Seperator_v_left = new JSeparator();
  private JSeparator Seperator_v_right = new JSeparator();
  private JNumberField Time_hours_given2 = new JNumberField();
  private JLabel Text_l2_h = new JLabel();
  private JNumberField Time_minutes_given2 = new JNumberField();
  private JLabel Text_l2_min = new JLabel();
  private JNumberField Time_seconds_given2 = new JNumberField();
  private JLabel Text_l2_s = new JLabel();
  private JButton Button_equals_nf = new JButton();
  private JButton swapButton = new JButton();
  private JSeparator Seperator_swap_top = new JSeparator();
  private JSeparator Seperator_swap_bottom = new JSeparator();
  private JNumberField Time_hours_wanted = new JNumberField();
  private JLabel Text_l3_h = new JLabel();
  private JNumberField Time_minutes_wanted = new JNumberField();
  private JLabel Text_l3_min = new JLabel();
  private JNumberField Time_seconds_wanted = new JNumberField();
  private JLabel Text_l3_s = new JLabel();
  private JCheckBox activate_hours = new JCheckBox();
  private JCheckBox activate_minutes = new JCheckBox();
  private JCheckBox activate_seconds = new JCheckBox();
  private JSeparator Seperator_h_bottom = new JSeparator();
  private JButton moveWayUpButton = new JButton();
  private JButton moveUpButton = new JButton();
  private JButton About_Button = new JButton();
  private JToggleButton Help_Button = new JToggleButton();

  public TimeCalculator(String title) {
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 495; 
    int frameHeight = 395;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2 + 361;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);

    Text_Title.setBounds(90, 0, 315, 55);
    Text_Title.setText("Time Calculator");
    Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
    Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Title.setToolTipText("v1.0 © Simon Vetter 2011");
    cp.add(Text_Title);
    Time_hours_given1.setBounds(30, 75, 80, 35);
    Time_hours_given1.setText("");
    Time_hours_given1.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_hours_given1.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_hours_given1.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Time_hours_given1_KeyReleased(evt);
      }
    });
    cp.add(Time_hours_given1);
    Text_l1_h.setBounds(115, 75, 20, 35);
    Text_l1_h.setText("h");
    Text_l1_h.setFont(new Font("Dialog", Font.PLAIN, 18));
    Text_l1_h.setHorizontalAlignment(SwingConstants.LEFT);
    Text_l1_h.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(Text_l1_h);
    Time_minutes_given1.setBounds(140, 75, 80, 35);
    Time_minutes_given1.setText("");
    Time_minutes_given1.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_minutes_given1.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_minutes_given1.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Time_minutes_given1_KeyReleased(evt);
      }
    });
    cp.add(Time_minutes_given1);
    Text_l1_min.setBounds(225, 75, 35, 35);
    Text_l1_min.setText("min");
    Text_l1_min.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l1_min.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_l1_min);
    Time_seconds_given1.setBounds(265, 75, 80, 35);
    Time_seconds_given1.setText("");
    Time_seconds_given1.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_seconds_given1.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_seconds_given1.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Time_seconds_given1_KeyReleased(evt);
      }
    });
    cp.add(Time_seconds_given1);
    Text_l1_s.setBounds(350, 75, 20, 35);
    Text_l1_s.setText("s");
    Text_l1_s.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l1_s.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_l1_s);
    switchMode_Button.setBounds(30, 130, 335, 30);
    switchMode_Button.setText("=");
    switchMode_Button.setMargin(new Insets(2, 2, 2, 2));
    switchMode_Button.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        switchMode_Button_ActionPerformed(evt);
      }
    });
    switchMode_Button.setSelected(false);
    switchMode_Button.setFont(new Font("Dialog", Font.BOLD, 25));
    cp.add(switchMode_Button);
    Seperator_h_top.setBounds(20, 65, 355, 1);
    cp.add(Seperator_h_top);
    Seperator_v_left.setBounds(20, 65, 1, 285);
    Seperator_v_left.setOrientation(SwingConstants.VERTICAL);
    cp.add(Seperator_v_left);
    Seperator_v_right.setBounds(374, 67, 1, 283);
    Seperator_v_right.setOrientation(SwingConstants.VERTICAL);
    cp.add(Seperator_v_right);
    Time_hours_given2.setBounds(30, 180, 80, 35);
    Time_hours_given2.setText("");
    Time_hours_given2.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_hours_given2.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_hours_given2.setEnabled(false);
    Time_hours_given2.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Time_hours_given2_KeyReleased(evt);
      }
    });
    cp.add(Time_hours_given2);
    Text_l2_h.setBounds(115, 180, 20, 35);
    Text_l2_h.setText("h");
    Text_l2_h.setFont(new Font("Dialog", Font.PLAIN, 18));
    Text_l2_h.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l2_h.setEnabled(false);
    cp.add(Text_l2_h);
    Time_minutes_given2.setBounds(140, 180, 80, 35);
    Time_minutes_given2.setText("");
    Time_minutes_given2.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_minutes_given2.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_minutes_given2.setEnabled(false);
    Time_minutes_given2.setVisible(true);
    Time_minutes_given2.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Time_minutes_given2_KeyReleased(evt);
      }
    });
    cp.add(Time_minutes_given2);
    Text_l2_min.setBounds(225, 180, 35, 35);
    Text_l2_min.setText("min");
    Text_l2_min.setFont(new Font("Dialog", Font.PLAIN, 18));
    Text_l2_min.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l2_min.setEnabled(false);
    cp.add(Text_l2_min);
    Time_seconds_given2.setBounds(265, 180, 80, 35);
    Time_seconds_given2.setText("");
    Time_seconds_given2.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_seconds_given2.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_seconds_given2.setEnabled(false);
    Time_seconds_given2.addKeyListener(new KeyAdapter() { 
      public void keyReleased(KeyEvent evt) { 
        Time_seconds_given2_KeyReleased(evt);
      }
    });
    cp.add(Time_seconds_given2);
    Text_l2_s.setBounds(350, 180, 20, 35);
    Text_l2_s.setText("s");
    Text_l2_s.setFont(new Font("Dialog", Font.PLAIN, 18));
    Text_l2_s.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l2_s.setEnabled(false);
    cp.add(Text_l2_s);
    Button_equals_nf.setBounds(20, 235, 355, 30);
    Button_equals_nf.setText("=");
    Button_equals_nf.setMargin(new Insets(2, 2, 2, 2));
    Button_equals_nf.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Button_equals_nf_ActionPerformed(evt);
      }
    });
    Button_equals_nf.setFont(new Font("Dialog", Font.BOLD, 25));
    Button_equals_nf.setVerticalAlignment(SwingConstants.CENTER);
    cp.add(Button_equals_nf);
    swapButton.setBounds(410, 93, 55, 105);
    swapButton.setText("swap");
    swapButton.setMargin(new Insets(2, 2, 2, 2));
    swapButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        swapButton_ActionPerformed(evt);
      }
    });
    swapButton.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(swapButton);
    Seperator_swap_top.setBounds(390, 93, 20, 1);
    cp.add(Seperator_swap_top);
    Seperator_swap_bottom.setBounds(390, 197, 20, 1);
    cp.add(Seperator_swap_bottom);
    Time_hours_wanted.setBounds(30, 285, 80, 35);
    Time_hours_wanted.setText("0");
    Time_hours_wanted.setEditable(false);
    Time_hours_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_hours_wanted.setHorizontalAlignment(SwingConstants.RIGHT);
    cp.add(Time_hours_wanted);
    Text_l3_h.setBounds(115, 285, 20, 35);
    Text_l3_h.setText("h");
    Text_l3_h.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l3_h.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_l3_h);
    Time_minutes_wanted.setBounds(140, 285, 80, 35);
    Time_minutes_wanted.setText("0");
    Time_minutes_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_minutes_wanted.setEditable(false);
    Time_minutes_wanted.setHorizontalAlignment(SwingConstants.RIGHT);
    cp.add(Time_minutes_wanted);
    Text_l3_min.setBounds(225, 285, 35, 35);
    Text_l3_min.setText("min");
    Text_l3_min.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l3_min.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_l3_min);
    Time_seconds_wanted.setBounds(265, 285, 80, 35);
    Time_seconds_wanted.setText("0");
    Time_seconds_wanted.setHorizontalAlignment(SwingConstants.RIGHT);
    Time_seconds_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
    Time_seconds_wanted.setEditable(false);
    cp.add(Time_seconds_wanted);
    Text_l3_s.setBounds(350, 285, 20, 35);
    Text_l3_s.setText("s");
    Text_l3_s.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_l3_s.setFont(new Font("Dialog", Font.PLAIN, 18));
    cp.add(Text_l3_s);
    activate_hours.setBounds(35, 320, 70, 20);
    activate_hours.setText("activate");
    activate_hours.setSelected(true);
    activate_hours.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        activate_hours_ActionPerformed(evt);
      }
    });
    cp.add(activate_hours);
    activate_minutes.setBounds(145, 320, 70, 20);
    activate_minutes.setText("activate");
    activate_minutes.setSelected(true);
    activate_minutes.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        activate_minutes_ActionPerformed(evt);
      }
    });
    cp.add(activate_minutes);
    activate_seconds.setBounds(270, 320, 70, 20);
    activate_seconds.setText("activate");
    activate_seconds.setSelected(true);
    activate_seconds.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        activate_seconds_ActionPerformed(evt);
      }
    });
    cp.add(activate_seconds);
    Seperator_h_bottom.setBounds(22, 349, 353, 1);
    cp.add(Seperator_h_bottom);
    moveWayUpButton.setBounds(390, 282, 85, 20);
    moveWayUpButton.setText("move way up");
    moveWayUpButton.setMargin(new Insets(2, 2, 2, 2));
    moveWayUpButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        moveWayUpButton_ActionPerformed(evt);
      }
    });
    moveWayUpButton.setHorizontalTextPosition(SwingConstants.CENTER);
    moveWayUpButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(moveWayUpButton);
    moveUpButton.setBounds(390, 303, 85, 20);
    moveUpButton.setText("move up");
    moveUpButton.setMargin(new Insets(2, 2, 2, 2));
    moveUpButton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        moveUpButton_ActionPerformed(evt);
      }
    });
    moveUpButton.setHorizontalTextPosition(SwingConstants.CENTER);
    moveUpButton.setFont(new Font("Dialog", Font.PLAIN, 12));
    cp.add(moveUpButton);
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
    Help_Button.setBounds(405, 15, 70, 30);
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




  
  private void switchMode_Button_ActionPerformed(ActionEvent evt) {
    switchMode();
    calculate();
  }

  private void Button_equals_nf_ActionPerformed(ActionEvent evt) {
    // This button does not have any features, it's just part of the layout
    calculate();
  }

  private void swapButton_ActionPerformed(ActionEvent evt) {
    swapButton();
    calculate();
  }
  
  private void activate_hours_ActionPerformed(ActionEvent evt) {
    if (!activate_hours.isSelected() && (activate_minutes.isSelected() ^ activate_seconds.isSelected())) {
      activate_minutes.setEnabled(!activate_minutes.isSelected());
      activate_seconds.setEnabled(!activate_seconds.isSelected());
    }
    else {
      activate_minutes.setEnabled(true);
      activate_seconds.setEnabled(true);
    }
    Time_hours_wanted.setEnabled(activate_hours.isSelected());
    Text_l3_h.setEnabled(activate_hours.isSelected());
    calculate();
  }
  private void activate_minutes_ActionPerformed(ActionEvent evt) {
    if (!activate_minutes.isSelected() && (activate_hours.isSelected() ^ activate_seconds.isSelected())) {
      activate_hours.setEnabled(!activate_hours.isSelected());
      activate_seconds.setEnabled(!activate_seconds.isSelected());
    }
    else {
      activate_hours.setEnabled(true);
      activate_seconds.setEnabled(true);
    }
    Time_minutes_wanted.setEnabled(activate_minutes.isSelected());
    Text_l3_min.setEnabled(activate_minutes.isSelected());
    calculate();
  }
  private void activate_seconds_ActionPerformed(ActionEvent evt) {
    if (!activate_seconds.isSelected() && (activate_hours.isSelected() ^ activate_minutes.isSelected())) {
      activate_hours.setEnabled(!activate_hours.isSelected());
      activate_minutes.setEnabled(!activate_minutes.isSelected());
    }
    else {
      activate_hours.setEnabled(true);
      activate_minutes.setEnabled(true);
    }
    Time_seconds_wanted.setEnabled(activate_seconds.isSelected());
    Text_l3_s.setEnabled(activate_seconds.isSelected());
    calculate();
  }
  
  private void moveWayUpButton_ActionPerformed(ActionEvent evt) {
    moveWayUp();
    calculate();
  }
  private void moveUpButton_ActionPerformed(ActionEvent evt) {
    moveUp();
    calculate();
  }
  
  
  
  public void Time_hours_given1_KeyReleased(KeyEvent evt) {
    if (!Time_hours_given1.getText().equals(Time_hours_given1.getText().replace(',', '.'))) {
      Time_hours_given1.setText(Time_hours_given1.getText().replace(',', '.'));
    }
    try {
      if (Time_hours_given1.getDouble() < 0.) {
        Time_hours_given1.setText(Time_hours_given1.getText().substring(Time_hours_given1.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Time_minutes_given1_KeyReleased(KeyEvent evt) {
    if (!Time_minutes_given1.getText().equals(Time_minutes_given1.getText().replace(',', '.'))) {
      Time_minutes_given1.setText(Time_minutes_given1.getText().replace(',', '.'));
    }
    try {
      if (Time_minutes_given1.getDouble() < 0.) {
        Time_minutes_given1.setText(Time_minutes_given1.getText().substring(Time_minutes_given1.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Time_seconds_given1_KeyReleased(KeyEvent evt) {
    if (!Time_seconds_given1.getText().equals(Time_seconds_given1.getText().replace(',', '.'))) {
      Time_seconds_given1.setText(Time_seconds_given1.getText().replace(',', '.'));
    }
    try {
      if (Time_seconds_given1.getDouble() < 0.) {
        Time_seconds_given1.setText(Time_seconds_given1.getText().substring(Time_seconds_given1.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Time_hours_given2_KeyReleased(KeyEvent evt) {
    if (!Time_hours_given2.getText().equals(Time_hours_given2.getText().replace(',', '.'))) {
      Time_hours_given2.setText(Time_hours_given2.getText().replace(',', '.'));
    }
    try {
      if (Time_hours_given2.getDouble() < 0.) {
        Time_hours_given2.setText(Time_hours_given2.getText().substring(Time_hours_given2.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Time_minutes_given2_KeyReleased(KeyEvent evt) {
    if (!Time_minutes_given2.getText().equals(Time_minutes_given2.getText().replace(',', '.'))) {
      Time_minutes_given2.setText(Time_minutes_given2.getText().replace(',', '.'));
    }
    try {
      if (Time_minutes_given2.getDouble() < 0.) {
        Time_minutes_given2.setText(Time_minutes_given2.getText().substring(Time_minutes_given2.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  public void Time_seconds_given2_KeyReleased(KeyEvent evt) {
    if (!Time_seconds_given2.getText().equals(Time_seconds_given2.getText().replace(',', '.'))) {
      Time_seconds_given2.setText(Time_seconds_given2.getText().replace(',', '.'));
    }
    try {
      if (Time_seconds_given2.getDouble() < 0.) {
        Time_seconds_given2.setText(Time_seconds_given2.getText().substring(Time_seconds_given2.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  
  

  
  
  
  private void calculate() {
    double input_h1, input_min1, input_s1;
    try {
      input_h1 = Time_hours_given1.getDouble();
    } catch (java.lang.NumberFormatException e) {
      input_h1 = 0.;
    }
    try {
      input_min1 = Time_minutes_given1.getDouble();
    } catch (java.lang.NumberFormatException e) {
      input_min1 = 0.;
    }
    try {
      input_s1 = Time_seconds_given1.getDouble();
    } catch (java.lang.NumberFormatException e) {
      input_s1 = 0.;
    }
    BigDecimal hours1 = new BigDecimal(0), minutes1 = new BigDecimal(0), seconds1 = new BigDecimal(0);
    if (input_h1 > 0.) {
      hours1 = hours1.valueOf(input_h1);
    }
    if (input_min1 > 0.) {
      minutes1 = minutes1.valueOf(input_min1);
    }
    if (input_s1 > 0.) {
      seconds1 = seconds1.valueOf(input_s1);
    }
    
    if (switchMode_Button.getText().equals("=")) {
      convert(hours1, minutes1, seconds1);
      return;
    }
    
    double input_h2, input_min2, input_s2;
    try {
      input_h2 = Time_hours_given2.getDouble();
    } catch (java.lang.NumberFormatException e) {
      input_h2 = 0.;
    }
    try {
      input_min2 = Time_minutes_given2.getDouble();
    } catch (java.lang.NumberFormatException e) {
      input_min2 = 0.;
    }
    try {
      input_s2 = Time_seconds_given2.getDouble();
    } catch (java.lang.NumberFormatException e) {
      input_s2 = 0.;
    }
    BigDecimal hours2 = new BigDecimal(0), minutes2 = new BigDecimal(0), seconds2 = new BigDecimal(0);
    if (input_h2 > 0.) {
      hours2 = hours2.valueOf(input_h2);
    }
    if (input_min2 > 0.) {
      minutes2 = minutes2.valueOf(input_min2);
    }
    if (input_s2 > 0.) {
      seconds2 = seconds2.valueOf(input_s2);
    }

    if (switchMode_Button.getText().equals("+")) {
      addition(hours1, minutes1, seconds1, hours2, minutes2, seconds2);
      return;
    }

    if (switchMode_Button.getText().equals("–")) {
      subtraction(hours1, minutes1, seconds1, hours2, minutes2, seconds2);
      return;
    }

    convert(hours1, minutes1, seconds1);
  }
  private void addition(BigDecimal hours1, BigDecimal minutes1, BigDecimal seconds1, BigDecimal hours2, BigDecimal minutes2, BigDecimal seconds2) {
    print(seconds1.add(minutes1.multiply(new BigDecimal(60))).add(hours1.multiply(new BigDecimal(3600))).add(seconds2).add(minutes2.multiply(new BigDecimal(60))).add(hours2.multiply(new BigDecimal(3600))));
  }
  private void subtraction(BigDecimal hours1, BigDecimal minutes1, BigDecimal seconds1, BigDecimal hours2, BigDecimal minutes2, BigDecimal seconds2) {
    print(seconds1.add(minutes1.multiply(new BigDecimal(60))).add(hours1.multiply(new BigDecimal(3600))).subtract(seconds2).subtract(minutes2.multiply(new BigDecimal(60))).subtract(hours2.multiply(new BigDecimal(3600))));
  }
  private void convert(BigDecimal hours, BigDecimal minutes, BigDecimal seconds) {
    print(seconds.add(minutes.multiply(new BigDecimal(60))).add(hours.multiply(new BigDecimal(3600))));
  }
  private void print(BigDecimal seconds) {
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
      Time_minutes_wanted.setText(minutes.add(seconds.divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP)).toString());
      Time_seconds_wanted.setText("0");
      return;
    }
    while (minutes.doubleValue() >= 60) {
      minutes = minutes.subtract(new BigDecimal(60));
      hours = hours.add(new BigDecimal(1));
    }
    if (activate_hours.isSelected() && activate_minutes.isSelected() && !activate_seconds.isSelected()) {
      Time_hours_wanted.setText(hours.toString());
      Time_minutes_wanted.setText(minutes.add(seconds.divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP)).toString());
      Time_seconds_wanted.setText("0");
      return;
    }
    if (activate_hours.isSelected() && !activate_minutes.isSelected() && !activate_seconds.isSelected()) {
      Time_hours_wanted.setText(hours.add(minutes.add(seconds.divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP)).divide(new BigDecimal(60), 2, BigDecimal.ROUND_HALF_UP)).toString());
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
    Time_hours_wanted.setText(hours.toString());
    Time_minutes_wanted.setText(minutes.toString());
    Time_seconds_wanted.setText(seconds.toString());
  }
  
  private void switchMode() {
    if (switchMode_Button.getText().equals("=")) {
      switchMode_Button.setText("+");
      activateLine2(true);
      return;
    }
    if (switchMode_Button.getText().equals("+")) {
      switchMode_Button.setText("–");
      activateLine2(true);
      return;
    }
    else {
      switchMode_Button.setText("=");
      activateLine2(false);
    }
  }
  private void activateLine2(boolean active) {
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


  public void About_Button_ActionPerformed(ActionEvent evt) {
    new About(this, "About Time Calculator", true);
  }

  public void Help_Button_ActionPerformed(ActionEvent evt) {
    if (Help_Button.isSelected()) {
      Seperator_h_top.setToolTipText("found me!");
      Seperator_v_left.setToolTipText("found me!");
      Seperator_v_right.setToolTipText("found me!");
      Seperator_h_bottom.setToolTipText("found me!");
      Time_hours_given1.setToolTipText("enter the first time period you want to calculate with here");
      Text_l1_h.setToolTipText("hours");
      Time_minutes_given1.setToolTipText("enter the first time period you want to calculate with here");
      Text_l1_min.setToolTipText("minutes");
      Time_seconds_given1.setToolTipText("enter the first time period you want to calculate with here");
      Text_l1_s.setToolTipText("seconds");
      switchMode_Button.setToolTipText("switch between convert, addition and subtraction mode");
      Time_hours_given2.setToolTipText("enter the second time period you want to calculate with here");
      Text_l2_h.setToolTipText("hours");
      Time_minutes_given2.setToolTipText("enter the second time period you want to calculate with here");
      Text_l2_min.setToolTipText("minutes");
      Time_seconds_given2.setToolTipText("enter the second time period you want to calculate with here");
      Text_l2_s.setToolTipText("seconds");
      Button_equals_nf.setToolTipText("click me!");
      Time_hours_wanted.setToolTipText("that's your result!");
      Text_l3_h.setToolTipText("hours");
      Time_minutes_wanted.setToolTipText("that's your result!");
      Text_l3_min.setToolTipText("minutes");
      Time_seconds_wanted.setToolTipText("that's your result!");
      Text_l3_s.setToolTipText("seconds");
      activate_hours.setToolTipText("display the amount of full hours in your result");
      activate_minutes.setToolTipText("display the amount of full minutes in your result");
      activate_seconds.setToolTipText("display the amount of seconds in your result");
      swapButton.setToolTipText("swap the set time periods in line 1 and 2");
      Seperator_swap_top.setToolTipText("I point at the first line");
      Seperator_swap_bottom.setToolTipText("I point at the second line");
      moveWayUpButton.setToolTipText("move your result to the first line");
      moveUpButton.setToolTipText("move your result to the second line");
    }
    else {
      Seperator_h_top.setToolTipText(null);
      Seperator_v_left.setToolTipText(null);
      Seperator_v_right.setToolTipText(null);
      Seperator_h_bottom.setToolTipText(null);
      Time_hours_given1.setToolTipText(null);
      Text_l1_h.setToolTipText(null);
      Time_minutes_given1.setToolTipText(null);
      Text_l1_min.setToolTipText(null);
      Time_seconds_given1.setToolTipText(null);
      Text_l1_s.setToolTipText(null);
      switchMode_Button.setToolTipText(null);
      Time_hours_given2.setToolTipText(null);
      Text_l2_h.setToolTipText(null);
      Time_minutes_given2.setToolTipText(null);
      Text_l2_min.setToolTipText(null);
      Time_seconds_given2.setToolTipText(null);
      Text_l2_s.setToolTipText(null);
      Button_equals_nf.setToolTipText(null);
      Time_hours_wanted.setToolTipText(null);
      Text_l3_h.setToolTipText(null);
      Time_minutes_wanted.setToolTipText(null);
      Text_l3_min.setToolTipText(null);
      Time_seconds_wanted.setToolTipText(null);
      Text_l3_s.setToolTipText(null);
      activate_hours.setToolTipText(null);
      activate_minutes.setToolTipText(null);
      activate_seconds.setToolTipText(null);
      swapButton.setToolTipText(null);
      Seperator_swap_top.setToolTipText(null);
      Seperator_swap_bottom.setToolTipText(null);
      moveWayUpButton.setToolTipText(null);
      moveUpButton.setToolTipText(null);
    }
  }








  public static void main(String[] args) {
    new TimeCalculator("TimeCalculator");
  }
}