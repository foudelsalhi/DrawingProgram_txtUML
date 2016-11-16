package drawingProgram.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import drawingProgram.x.model.PictureDisabled;
import drawingProgram.x.model.PictureDisplayed;
import drawingProgram.x.model.ProjectClose;
import drawingProgram.x.model.ProjectOpen;
import drawingProgram.x.model.XProject;
import hu.elte.txtuml.api.model.Action;
import hu.elte.txtuml.api.model.execution.ModelExecutor;

public class GUI implements GUIInterface {
	static XProject project;
	static JFrame frame;
	static JPanel mainPanel;
	static JPanel projectPanel;
	static JPanel imagePanel;
	static JPanel buttonPanel;
	static JButton openButton;
	static JButton closeButton;
	static JButton displayButton;
	static JButton disableButton;
	// static JButton testButton;
	static BufferedImage imageClosed;
	static BufferedImage imageOpened;
	static JLabel imageClosedLabel;
	static JLabel imageOpenedLabel;
	static BufferedImage projectClosed;
	static BufferedImage projectOpened;
	static JLabel projectClosedLabel;
	static JLabel projectOpenedLabel;

	static void init() {
		project = Action.create(XProject.class);
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		projectPanel = new JPanel();
		imagePanel = new JPanel();
		buttonPanel = new JPanel();

		try {
			imageClosed = ImageIO.read(new File("src//drawingProgram//images//ProjectOpened.png"));
			imageOpened = ImageIO.read(new File("src//drawingProgram//images//ImageOpened.png"));
			projectClosed = ImageIO.read(new File("src//drawingProgram//images//ProjectClosed.png"));
			projectOpened = ImageIO.read(new File("src//drawingProgram//images//ProjectOpened.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
		projectClosedLabel = new JLabel(new ImageIcon(projectClosed));
		projectOpenedLabel = new JLabel(new ImageIcon(projectOpened));
		imageClosedLabel = new JLabel(new ImageIcon(imageClosed));
		imageOpenedLabel = new JLabel(new ImageIcon(imageOpened));

		projectPanel.setBackground(new Color(255, 255, 255));
		projectPanel.add(projectClosedLabel);
		projectPanel.add(projectOpenedLabel);
		projectOpenedLabel.setVisible(false);
		imagePanel.setBackground(new Color(255, 255, 255));
		imagePanel.add(imageClosedLabel);
		imagePanel.add(imageOpenedLabel);
		imageOpenedLabel.setVisible(false);

		openButton = new JButton("Open");
		closeButton = new JButton("Close");
		displayButton = new JButton("Display");
		disableButton = new JButton("Disable");
		closeButton.setVisible(false);
		projectClosedLabel.setVisible(false);
		projectOpenedLabel.setVisible(false);
		imageOpenedLabel.setVisible(false);
		imageClosedLabel.setVisible(false);
		openButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				projectClosedLabel.setVisible(false);
				projectOpenedLabel.setVisible(true);
				openButton.setVisible(false);
				closeButton.setVisible(true);
				Action.send(new ProjectOpen(), project);
			}
		});
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				projectOpenedLabel.setVisible(false);
				projectClosedLabel.setVisible(true);
				closeButton.setVisible(false);
				openButton.setVisible(true);
				Action.send(new ProjectClose(), project);
			}
		});
		displayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Action.send(new PictureDisplayed(), project);
			}
		});
		disableButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Action.send(new PictureDisabled(), project);
			}
		});

		buttonPanel.add(openButton);
		buttonPanel.add(closeButton);
		buttonPanel.add(displayButton);
		buttonPanel.add(disableButton);
		mainPanel.add(projectPanel);
		mainPanel.add(imagePanel);
		mainPanel.add(buttonPanel);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainPanel);
		frame.pack();
		frame.setVisible(true);
		Action.start(project);
	}

	/*
	 * @Override public void ProjectOpened() { // TODO Auto-generated method
	 * stub projectOpenedLabel.setVisible(true);
	 * projectClosedLabel.setVisible(false); imageOpenedLabel.setVisible(false);
	 * imageClosedLabel.setVisible(false); }
	 * 
	 * @Override public void ProjectClosed() { // TODO Auto-generated method
	 * stub projectOpenedLabel.setVisible(false);
	 * projectClosedLabel.setVisible(true); imageOpenedLabel.setVisible(false);
	 * imageClosedLabel.setVisible(false); }
	 */
	@Override
	public void PictureDisplayed() {
		// TODO Auto-generated method stub
		projectOpenedLabel.setVisible(false);
		projectClosedLabel.setVisible(false);
		imageOpenedLabel.setVisible(true);
		imageClosedLabel.setVisible(false);

	}

	@Override
	public void PictureDisabled() {
		// TODO Auto-generated method stub
		imageOpenedLabel.setVisible(false);
		imageClosedLabel.setVisible(true);

	}

	public static void main(String[] args) {
		ModelExecutor.create().setTraceLogging(true).launch(GUI::init);
	}

}
