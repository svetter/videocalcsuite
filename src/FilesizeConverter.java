import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.math.BigDecimal;

/**
  * @version 1.0, 2.11.2011
  * @author Simon Vetter
  */

public class FilesizeConverter extends JFrame {
  private JLabel Text_Title = new JLabel();
  private JNumberField Size_given = new JNumberField();
  private JComboBox Unit_given = new JComboBox();
  private JRadioButton K_given_1024 = new JRadioButton();
  private JRadioButton K_given_1000 = new JRadioButton();
  private ButtonGroup K_given = new ButtonGroup();
  private JSeparator verticalLine = new JSeparator();
  private JNumberField Size_wanted = new JNumberField();
  private JComboBox Unit_wanted = new JComboBox();
  private JRadioButton K_wanted_1024 = new JRadioButton();
  private JRadioButton K_wanted_1000 = new JRadioButton();
  private ButtonGroup K_wanted = new ButtonGroup();
  private JButton About_Button = new JButton();
  private JToggleButton Help_Button = new JToggleButton();

  public FilesizeConverter(String title) {
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 500; 
    int frameHeight = 230;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2 - 473;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);

    Text_Title.setBounds(90, 0, 310, 55);
    Text_Title.setText("Filesize Converter");
    Text_Title.setToolTipText("v1.0 © Simon Vetter 2011");
    Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Title.setFont(new Font("Dialog", Font.BOLD, 30));
    Text_Title.setEnabled(true);
    cp.add(Text_Title);
    Size_given.setBounds(20, 65, 300, 35);
    Size_given.setText("");
    Size_given.setFont(new Font("Dialog", Font.PLAIN, 18));
    Size_given.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent evt) {
        Size_given_KeyReleased(evt);
      }
    });
    cp.add(Size_given);
    Unit_given.setBounds(330, 65, 60, 35);
    Unit_given.setModel(new DefaultComboBoxModel(new String[] {"B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb"}));
    Unit_given.setSelectedIndex(2);
    Unit_given.setMaximumRowCount(10);
    Unit_given.setFont(new Font("Dialog", Font.PLAIN, 16));
    Unit_given.setEditable(false);
    Unit_given.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Unit_given_ActionPerformed(evt);
      }
    });
    cp.add(Unit_given);
    K_given_1024.setBounds(400, 62, 80, 20);
    K_given_1024.setText("K = 1024");
    K_given_1024.setSelected(true);
    K_given_1024.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_given_1024_ActionPerformed(evt);
      }
    });
    cp.add(K_given_1024);
    K_given_1000.setBounds(400, 83, 80, 20);
    K_given_1000.setText("K = 1000");
    K_given_1000.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_given_1000_ActionPerformed(evt);
      }
    });
    cp.add(K_given_1000);
    K_given.add(K_given_1024);
    K_given.add(K_given_1000);
    verticalLine.setBounds(20, 125, 450, 1);
    cp.add(verticalLine);
    Size_wanted.setBounds(20, 150, 300, 35);
    Size_wanted.setText("0");
    Size_wanted.setEditable(false);
    Size_wanted.setFont(new Font("Dialog", Font.PLAIN, 18));
    Size_wanted.setSelectionEnd(0);
    Size_wanted.setSelectionStart(0);
    cp.add(Size_wanted);
    Unit_wanted.setBounds(330, 150, 60, 35);
    Unit_wanted.setEditable(false);
    Unit_wanted.setFont(new Font("Dialog", Font.PLAIN, 16));
    Unit_wanted.setMaximumRowCount(10);
    Unit_wanted.setModel(new DefaultComboBoxModel(new String[] {"B", "KB", "MB", "GB", "TB", "PB", "b", "Kb", "Mb", "Gb"}));
    Unit_wanted.setSelectedIndex(2);
    Unit_wanted.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Unit_wanted_ActionPerformed(evt);
      }
    });
    cp.add(Unit_wanted);
    K_wanted_1024.setBounds(400, 147, 80, 20);
    K_wanted_1024.setText("K = 1024");
    K_wanted_1024.setSelected(true);
    K_wanted_1024.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_wanted_1024_ActionPerformed(evt);
      }
    });
    cp.add(K_wanted_1024);
    K_wanted_1000.setBounds(400, 168, 80, 20);
    K_wanted_1000.setText("K = 1000");
    K_wanted_1000.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        K_wanted_1000_ActionPerformed(evt);
      }
    });
    cp.add(K_wanted_1000);
    K_wanted.add(K_wanted_1024);
    K_wanted.add(K_wanted_1000);
    About_Button.setBounds(20, 13, 70, 30);
    About_Button.setText("About");
    About_Button.setMargin(new Insets(2, 2, 2, 2));
    About_Button.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        About_Button_ActionPerformed(evt);
      }
    });
    About_Button.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(About_Button);
    Help_Button.setBounds(400, 15, 70, 30);
    Help_Button.setText("Help");
    Help_Button.setMargin(new Insets(2, 2, 2, 2));
    Help_Button.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Help_Button_ActionPerformed(evt);
      }
    });
    Help_Button.setHorizontalTextPosition(SwingConstants.CENTER);
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

  private void Size_given_KeyReleased(KeyEvent evt) {
    if (!Size_given.getText().equals(Size_given.getText().replace(',', '.'))) {
      Size_given.setText(Size_given.getText().replace(',', '.'));
    }
    try {
      if (Size_given.getDouble() < 0.) {
        Size_given.setText(Size_given.getText().substring(Size_given.getText().indexOf('-') + 1));
      }
    } catch (NumberFormatException e) { }
    calculate();
  }
  private void Unit_given_ActionPerformed(ActionEvent evt) {
    calculate();
  }
  private void Unit_wanted_ActionPerformed(ActionEvent evt) {
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
      check = Size_given.getDouble();
    } catch (java.lang.NumberFormatException e) {
      Size_wanted.setText("0");
      return;
    }
    if (!(check > 0.)) {
      Size_wanted.setText("0");
      return;
    }

    BigDecimal value = new BigDecimal(8);
    value = value.valueOf(Size_given.getDouble());

    long[] toBits = new long[10], toUnit = new long[10];
    if (getSelectedRadioButton(K_given).equals("K = 1000")) {
      long[] temp = {8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L};
      toBits = temp;
    }
    else {
      long[] temp = {8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L};
      toBits = temp;
    }
    if (getSelectedRadioButton(K_wanted).equals("K = 1000")) {
      long[] temp = {8L, 8000L, 8000000L, 8000000000L, 8000000000000L, 8000000000000000L, 1L, 1000L, 1000000L, 1000000000L};
      toUnit = temp;
    }
    else {
      long[] temp = {8L, 8192L, 8388608L, 8589934592L, 8796093022208L, 9007199254740992L, 1L, 1024L, 1048576L, 1073741824L};
      toUnit = temp;
    }

    value = value.multiply(BigDecimal.valueOf(toBits[Unit_given.getSelectedIndex()]));
    value = value.divide(BigDecimal.valueOf(toUnit[Unit_wanted.getSelectedIndex()]), 4, BigDecimal.ROUND_HALF_UP);

    Size_wanted.setText(value.toString());
  }

  private void About_Button_ActionPerformed(ActionEvent evt) {
    new About(this, "About Filesize Converter", true);
  }

  private void Help_Button_ActionPerformed(ActionEvent evt) {
    if (Help_Button.isSelected()) {
    Size_given.setToolTipText("enter the filesize you want to convert here");
    Unit_given.setToolTipText("select the unit for the given filesize");
      K_given_1024.setToolTipText("1 MB = 1024 B");
      K_given_1000.setToolTipText("1 MB = 1000 B");
      verticalLine.setToolTipText("found me!");
      Size_wanted.setToolTipText("that's your result!");
      Unit_wanted.setToolTipText("select the unit for your result");
      K_wanted_1024.setToolTipText("1 MB = 1024 B");
      K_wanted_1000.setToolTipText("1 MB = 1000 B");
      About_Button.setToolTipText("click me!");
    }
    else {
      Size_given.setToolTipText(null);
      Unit_given.setToolTipText(null);
      K_given_1024.setToolTipText(null);
      K_given_1000.setToolTipText(null);
      verticalLine.setToolTipText(null);
      Size_wanted.setToolTipText(null);
      Unit_wanted.setToolTipText(null);
      K_wanted_1024.setToolTipText(null);
      K_wanted_1000.setToolTipText(null);
      About_Button.setToolTipText(null);
    }
  }


  public static void main(String[] args) {
    new FilesizeConverter("Filesize Converter");
  }
}