/*
 * Copyright 2011, 2021, 2023 Simon Vetter
 *
 * This file is part of VideoCalcSuite.
 *
 * VideoCalcSuite is free software: you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * VideoCalcSuite is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with VideoCalcSuite.
 * If not, see <https://www.gnu.org/licenses/>.
 */

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
	public static final int HEIGHT	= 240;
	
	
	private final JLabel	titleLabel				= new JLabel();
	private final JButton	bitrateGeneratorButton	= new JButton();
	private final JButton	filesizeConverterButton	= new JButton();
	private final JButton	timeCalculatorButton	= new JButton();
	private final JButton	bitrateConverterButton	= new JButton();
	
	
	
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
		
		bitrateGeneratorButton.setBounds(10, 60, 400, 50);
		bitrateGeneratorButton.setText("Bitrate Generator");
		bitrateGeneratorButton.setMargin(new Insets(2, 2, 2, 2));
		bitrateGeneratorButton.addActionListener(evt -> startBitrateGenerator());
		bitrateGeneratorButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(bitrateGeneratorButton);
		
		filesizeConverterButton.setBounds(10, 120, 195, 50);
		filesizeConverterButton.setText("Filesize Converter");
		filesizeConverterButton.setMargin(new Insets(2, 2, 2, 2));
		filesizeConverterButton.addActionListener(evt -> startFilesizeConverter());
		filesizeConverterButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(filesizeConverterButton);
		
		bitrateConverterButton.setBounds(215, 120, 195, 50);
		bitrateConverterButton.setText("Bitrate Converter");
		bitrateConverterButton.setMargin(new Insets(2, 2, 2, 2));
		bitrateConverterButton.addActionListener(evt -> startBitrateConverter());
		bitrateConverterButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(bitrateConverterButton);
		
		timeCalculatorButton.setBounds(10, 180, 400, 50);
		timeCalculatorButton.setText("Time Calculator");
		timeCalculatorButton.setMargin(new Insets(2, 2, 2, 2));
		timeCalculatorButton.addActionListener(evt -> startTimeCalculator());
		timeCalculatorButton.setFont(new Font("Dialog", Font.BOLD, 18));
		container.add(timeCalculatorButton);
		
		
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
