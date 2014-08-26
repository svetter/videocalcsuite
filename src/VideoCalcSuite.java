import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  * @version 1.0, 25.11.2011
  * @author Simon Vetter
  */

public class VideoCalcSuite extends JFrame {
  private JLabel Text_Title = new JLabel();
  private JButton Button_BitrateGenerator = new JButton();
  private JButton Button_FilesizeConverter = new JButton();
  private JButton Button_TimeCalculator = new JButton();
  private JButton Button_BitrateConverter = new JButton();
  private JLabel Text_Author = new JLabel();
  
  private int amountBG = 0, amountFC = 0, amountBC = 0, amountTC = 0;

  public VideoCalcSuite(String title) {
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 426; 
    int frameHeight = 306;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);

    Text_Title.setBounds(0, 5, 420, 50);
    Text_Title.setText("VideoCalc Suite");
    Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Title.setFont(new Font("Dialog", Font.BOLD, 40));
    Text_Title.setToolTipText("<html>&copy; Simon Vetter 2011<br>All rights reserved.</html>");
    cp.add(Text_Title);
    Button_BitrateGenerator.setBounds(10, 100, 400, 50);
    Button_BitrateGenerator.setText("Bitrate Generator");
    Button_BitrateGenerator.setMargin(new Insets(2, 2, 2, 2));
    Button_BitrateGenerator.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Button_BitrateGenerator_ActionPerformed(evt);
      }
    });
    Button_BitrateGenerator.setFont(new Font("Dialog", Font.BOLD, 18));
    Button_BitrateGenerator.setToolTipText("open a new Bitrate Generator");
    cp.add(Button_BitrateGenerator);
    Button_FilesizeConverter.setBounds(10, 160, 195, 50);
    Button_FilesizeConverter.setText("Filesize Converter");
    Button_FilesizeConverter.setMargin(new Insets(2, 2, 2, 2));
    Button_FilesizeConverter.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Button_FilesizeConverter_ActionPerformed(evt);
      }
    });
    Button_FilesizeConverter.setFont(new Font("Dialog", Font.BOLD, 18));
    Button_FilesizeConverter.setToolTipText("open a new Filesize Converter");
    cp.add(Button_FilesizeConverter);
    Button_TimeCalculator.setBounds(10, 220, 400, 50);
    Button_TimeCalculator.setText("Time Calculator");
    Button_TimeCalculator.setMargin(new Insets(2, 2, 2, 2));
    Button_TimeCalculator.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Button_TimeCalculator_ActionPerformed(evt);
      }
    });
    Button_TimeCalculator.setFont(new Font("Dialog", Font.BOLD, 18));
    Button_TimeCalculator.setToolTipText("open a new Time Calculator");
    cp.add(Button_TimeCalculator);
    Button_BitrateConverter.setBounds(215, 160, 195, 50);
    Button_BitrateConverter.setText("Bitrate Converter");
    Button_BitrateConverter.setMargin(new Insets(2, 2, 2, 2));
    Button_BitrateConverter.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        Button_BitrateConverter_ActionPerformed(evt);
      }
    });
    Button_BitrateConverter.setFont(new Font("Dialog", Font.BOLD, 18));
    Button_BitrateConverter.setToolTipText("open a new Bitrate Converter");
    cp.add(Button_BitrateConverter);
    Text_Author.setBounds(0, 55, 420, 30);
    Text_Author.setText("by Simon Vetter");
    Text_Author.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Author.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Author.setFont(new Font("Dialog", Font.BOLD, 20));
    Text_Author.setToolTipText("<html>Simon Vetter<br>Frankfurt/Main, Germany<br>@SimeTologist</html>");
    cp.add(Text_Author);

    setVisible(true);
  }

  public void Button_BitrateGenerator_ActionPerformed(ActionEvent evt) {
    amountBG++;
    String title = "Bitrate Generator";
    if (amountBG > 1) {
      title = title + " " + amountBG;
    }
    new BitrateGenerator(title);
  }

  public void Button_FilesizeConverter_ActionPerformed(ActionEvent evt) {
    amountFC++;
    String title = "Filesize Converter";
    if (amountFC > 1) {
      title = title + " " + amountFC;
    }
    new FilesizeConverter(title);
  }

  public void Button_BitrateConverter_ActionPerformed(ActionEvent evt) {
    amountBC++;
    String title = "Bitrate Converter";
    if (amountBC > 1) {
      title = title + " " + amountBC;
    }
    new BitrateConverter(title);
  }

  public void Button_TimeCalculator_ActionPerformed(ActionEvent evt) {
    amountTC++;
    String title = "Time Calculator";
    if (amountTC > 1) {
      title = title + " " + amountTC;
    }
    new TimeCalculator(title);
  }


  public static void main(String[] args) {
    new VideoCalcSuite("VideoCalc Suite");
  }
}
