package vcs;

import javax.swing.*;
import java.awt.*;

import static vcs.Helper.AUTHOR_STRING;



/**
 * @version 1.2, 2023-09-30
 * @author Simon Vetter
 */
public class VideoCalcSuite extends JFrame {
	public static final int WIDTH	= 420;
	public static final int HEIGHT	= 280;
	
	
	private final JLabel	titleLabel				= new JLabel();
	private final JButton	bitrateGeneratorButton	= new JButton();
	private final JButton	filesizeConverterButton	= new JButton();
	private final JButton	timeCalculatorButton	= new JButton();
	private final JButton	bitrateConverterButton	= new JButton();
	private final JLabel	authorLabel				= new JLabel();
	
	
	
	public VideoCalcSuite() {
		super("VideoCalc Suite");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(WIDTH + Helper.WIDTH_CORR, HEIGHT + Helper.HEIGHT_CORR);
		Helper.setWindowLocation(this, null);
		setResizable(false);
		Container container = getContentPane();
		container.setLayout(null);
		
		
		titleLabel.setBounds(0, 5, 420, 50);
		titleLabel.setText("VideoCalc Suite");
		titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 40));
		titleLabel.setToolTipText(AUTHOR_STRING);
		container.add(titleLabel);
		
		bitrateGeneratorButton.setBounds(10, 100, 400, 50);
		bitrateGeneratorButton.setText("Bitrate Generator");
		bitrateGeneratorButton.setMargin(new Insets(2, 2, 2, 2));
		bitrateGeneratorButton.addActionListener(evt -> startBitrateGenerator());
		bitrateGeneratorButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(bitrateGeneratorButton);
		
		filesizeConverterButton.setBounds(10, 160, 195, 50);
		filesizeConverterButton.setText("Filesize Converter");
		filesizeConverterButton.setMargin(new Insets(2, 2, 2, 2));
		filesizeConverterButton.addActionListener(evt -> startFilesizeConverter());
		filesizeConverterButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(filesizeConverterButton);
		
		bitrateConverterButton.setBounds(215, 160, 195, 50);
		bitrateConverterButton.setText("Bitrate Converter");
		bitrateConverterButton.setMargin(new Insets(2, 2, 2, 2));
		bitrateConverterButton.addActionListener(evt -> startBitrateConverter());
		bitrateConverterButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(bitrateConverterButton);
		
		timeCalculatorButton.setBounds(10, 220, 400, 50);
		timeCalculatorButton.setText("Time Calculator");
		timeCalculatorButton.setMargin(new Insets(2, 2, 2, 2));
		timeCalculatorButton.addActionListener(evt -> startTimeCalculator());
		timeCalculatorButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(timeCalculatorButton);
		
		authorLabel.setBounds(0, 55, 420, 30);
		authorLabel.setText("by Simon Vetter");
		authorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		authorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		authorLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		authorLabel.setToolTipText("<html>Simon Vetter<br>Darmstadt, Germany</html>");
		container.add(authorLabel);
		
		
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
