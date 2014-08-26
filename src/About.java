import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  * @version 1.0, 19.11.2011
  * @author Simon Vetter
  */

public class About extends JDialog {
  private JLabel Text_Title = new JLabel();
  private JLabel Text_Author_Title = new JLabel();
  private JLabel Text_DS_Title = new JLabel();
  private JSeparator Table_vert = new JSeparator();
  private JSeparator Table_hori = new JSeparator();
  private JLabel Text_Author = new JLabel();
  private JLabel Text_DS = new JLabel();
  private JLabel Text_Copyright = new JLabel();
  
  private String givenTitle;

  public About(JFrame owner, String title, boolean modal) {
    super(owner, title, modal);
    givenTitle = title;
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 325; 
    int frameHeight = 220;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);

    Text_Title.setBounds(10, 5, 300, 30);
    Text_Title.setText(givenTitle);
    Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Title.setFont(new Font("Dialog", Font.BOLD, 20));
    cp.add(Text_Title);
    Text_Author_Title.setBounds(10, 45, 150, 30);
    Text_Author_Title.setText("Author");
    Text_Author_Title.setFont(new Font("Dialog", Font.BOLD, 18));
    Text_Author_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Author_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    cp.add(Text_Author_Title);
    Text_DS_Title.setBounds(160, 45, 150, 30);
    Text_DS_Title.setText("Diction Supervisor");
    Text_DS_Title.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_DS_Title.setHorizontalAlignment(SwingConstants.CENTER);
    Text_DS_Title.setFont(new Font("Dialog", Font.BOLD, 15));
    cp.add(Text_DS_Title);
    Table_vert.setBounds(160, 45, 1, 100);
    Table_vert.setOrientation(SwingConstants.VERTICAL);
    cp.add(Table_vert);
    Table_hori.setBounds(10, 75, 300, 1);
    cp.add(Table_hori);
    Text_Author.setBounds(10, 80, 140, 60);
    Text_Author.setText("<html><div align=right>Simon Vetter<br>Frankfurt, Germany</div></html>");
    Text_Author.setHorizontalAlignment(SwingConstants.RIGHT);
    Text_Author.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(Text_Author);
    Text_DS.setBounds(170, 80, 449, 60);
    Text_DS.setText("<html><div align=left>Ben<br>Cardiff, Wales<br>&nbsp;</div></html>");
    Text_DS.setHorizontalTextPosition(SwingConstants.LEFT);
    Text_DS.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(Text_DS);
    Text_Copyright.setBounds(10, 160, 300, 25);
    Text_Copyright.setText("© Simon Vetter 2011 - All rights reserved");
    Text_Copyright.setHorizontalAlignment(SwingConstants.CENTER);
    Text_Copyright.setHorizontalTextPosition(SwingConstants.CENTER);
    Text_Copyright.setFont(new Font("Dialog", Font.BOLD, 13));
    cp.add(Text_Copyright);

    setResizable(false);
    setVisible(true);
  }

}
