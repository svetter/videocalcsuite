package vcs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



/**
 * @version 1.1, 13.02.2021
 * @author Simon Vetter
 */
public class VideoCalcSuite extends JFrame {
	private static final long serialVersionUID = 2901088960839633310L;
	
	
	public static final int WIDTH			= 420;
	public static final int HEIGHT			= 280;
	
	
	private JLabel Text_Title = new JLabel();
	private JButton Button_BitrateGenerator = new JButton();
	private JButton Button_FilesizeConverter = new JButton();
	private JButton Button_TimeCalculator = new JButton();
	private JButton Button_BitrateConverter = new JButton();
	private JLabel Text_Author = new JLabel();
	
	
	
	public VideoCalcSuite() {
		super("VideoCalc Suite");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, null);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		
		Text_Title.setBounds(0, 5, 420, 50);
		Text_Title.setText("VideoCalc Suite");
		Text_Title.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Title.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Title.setFont(new Font("Dialog", Font.BOLD, 40));
		Text_Title.setToolTipText("v1.1 © Simon Vetter 2021");
		container.add(Text_Title);
		
		Button_BitrateGenerator.setBounds(10, 100, 400, 50);
		Button_BitrateGenerator.setText("Bitrate Generator");
		Button_BitrateGenerator.setMargin(new Insets(2, 2, 2, 2));
		Button_BitrateGenerator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startBitrateGenerator();
			}
		});
		Button_BitrateGenerator.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(Button_BitrateGenerator);
		
		Button_FilesizeConverter.setBounds(10, 160, 195, 50);
		Button_FilesizeConverter.setText("Filesize Converter");
		Button_FilesizeConverter.setMargin(new Insets(2, 2, 2, 2));
		Button_FilesizeConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startFilesizeConverter();
			}
		});
		Button_FilesizeConverter.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(Button_FilesizeConverter);
		
		Button_TimeCalculator.setBounds(10, 220, 400, 50);
		Button_TimeCalculator.setText("Time Calculator");
		Button_TimeCalculator.setMargin(new Insets(2, 2, 2, 2));
		Button_TimeCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startTimeCalculator();
			}
		});
		Button_TimeCalculator.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(Button_TimeCalculator);
		
		Button_BitrateConverter.setBounds(215, 160, 195, 50);
		Button_BitrateConverter.setText("Bitrate Converter");
		Button_BitrateConverter.setMargin(new Insets(2, 2, 2, 2));
		Button_BitrateConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startBitrateConverter();
			}
		});
		Button_BitrateConverter.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(Button_BitrateConverter);
		
		Text_Author.setBounds(0, 55, 420, 30);
		Text_Author.setText("by Simon Vetter");
		Text_Author.setHorizontalAlignment(SwingConstants.CENTER);
		Text_Author.setHorizontalTextPosition(SwingConstants.CENTER);
		Text_Author.setFont(new Font("Dialog", Font.BOLD, 20));
		Text_Author.setToolTipText("<html>Simon Vetter<br>Darmstadt, Germany</html>");
		container.add(Text_Author);
		
		
		setVisible(true);
	}
	
	

	public void startBitrateGenerator() {
		new BitrateGenerator(this);
	}
	public void startFilesizeConverter() {
		new FilesizeConverter(this);
	}
	public void startBitrateConverter() {
		new BitrateConverter(this);
	}
	public void startTimeCalculator() {
		new TimeCalculator(this);
	}
	
	
	
	public static void main(String[] args) {
		
		new VideoCalcSuite();
		
	}
}
