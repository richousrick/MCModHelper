package com.richousrick.mcmodhelper.gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.richousrick.mcmodhelper.Core;
import com.richousrick.mcmodhelper.file.FileCreater;
import com.richousrick.mcmodhelper.file.FileCreation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * TODO Annotate Class
 *
 * @author Richousrick
 *
 */
public class InitializationWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5481151462205791174L;
	
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField IDField;
	private JTextField versionField;
	private JLabel noNameLabel;
	private JLabel noIDLabel;
	private JLabel noVersionLabel;
	private JLabel shortNameLabel;
	private JLabel shortIDLabel;
	private JLabel shortVersionLabel;
	private JTextArea locField;
	private JLabel noLocLabel;
	File dir = new File(System.getProperty("user.home"));

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitializationWindow frame = new InitializationWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InitializationWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Mod Helper");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(158, 11, 114, 37);
		contentPane.add(titleLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idLabel.setBounds(47, 125, 46, 14);
		contentPane.add(idLabel);
		
		nameField = new JTextField();
		nameField.setToolTipText("The Mods Name");
		nameField.setBounds(119, 77, 257, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(47, 78, 46, 14);
		contentPane.add(nameLabel);
		
		IDField = new JTextField();
		IDField.setToolTipText("The Mods ID");
		IDField.setColumns(10);
		IDField.setBounds(119, 124, 257, 20);
		contentPane.add(IDField);
		
		JLabel versionLabel = new JLabel("Version");
		versionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		versionLabel.setBounds(47, 173, 62, 14);
		contentPane.add(versionLabel);
		
		versionField = new JTextField();
		versionField.setToolTipText("The Mods Version");
		versionField.setColumns(10);
		versionField.setBounds(119, 172, 257, 20);
		contentPane.add(versionField);
		
		JButton nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		nextButton.setBounds(287, 272, 89, 23);
		contentPane.add(nextButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitButton.setBounds(47, 272, 89, 23);
		contentPane.add(exitButton);
		
		noNameLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">A name is required to continue.</font></html>");
		noNameLabel.setVisible(false);
		noNameLabel.setToolTipText("");
		noNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noNameLabel.setBounds(119, 59, 257, 14);
		contentPane.add(noNameLabel);
		
		noIDLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">A mod ID is required to continue.</font></html>");
		noIDLabel.setVisible(false);
		noIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noIDLabel.setBounds(119, 108, 257, 14);
		contentPane.add(noIDLabel);
		
		noVersionLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">A label is required to continue.</font></html>");
		noVersionLabel.setVisible(false);
		noVersionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noVersionLabel.setBounds(119, 155, 257, 14);
		contentPane.add(noVersionLabel);
		
		shortNameLabel = new JLabel("<html><font size=\"2\" face=\"tahoma\" color=\"red\">The name should be 4 and 12 characters long.</font></html>");
		shortNameLabel.setVisible(false);
		shortNameLabel.setBounds(119, 59, 257, 14);
		contentPane.add(shortNameLabel);
		
		shortIDLabel = new JLabel("<html><font size=\"2\" face=\"tahoma\" color=\"red\">The ID should be 4 and 12 characters long.</font></html>");
		shortIDLabel.setVisible(false);
		shortIDLabel.setBounds(119, 108, 257, 14);
		contentPane.add(shortIDLabel);
		
		shortVersionLabel = new JLabel("<html><font size=\"2\" face=\"tahoma\" color=\"red\">The Version should be 4 and 12 characters long.</font></html>");
		shortVersionLabel.setVisible(false);
		shortVersionLabel.setBounds(119, 155, 257, 14);
		contentPane.add(shortVersionLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(119, 221, 257, 37);
		contentPane.add(scrollPane);
		
		locField = new JTextArea();
		locField.setText(System.getProperty("user.home"));
		scrollPane.setViewportView(locField);
		locField.setEditable(false);
		locField.setToolTipText("Where the mod should be saved");
		locField.setColumns(10);
		
		noLocLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">The selected directory does not exist.</font></html>");
		noLocLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noLocLabel.setBounds(119, 203, 257, 20);
		noLocLabel.setVisible(false);
		contentPane.add(noLocLabel);
		
		JButton locButton = new JButton("Loc");
		locButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				
				if(dir!= null){
					fc.setCurrentDirectory(dir);
				}
				
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				int returnVal = fc.showDialog(InitializationWindow.this, "Select");
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
		            dir = fc.getSelectedFile();
		            locField.setText(dir.getPath());
		        }
			}
		});
		locButton.setBounds(47, 220, 62, 23);
		contentPane.add(locButton);
	}
	
	
	
	public void finish(){
		
		noNameLabel.setVisible(false);
		noIDLabel.setVisible(false);
		noVersionLabel.setVisible(false);
		shortNameLabel.setVisible(false);
		shortIDLabel.setVisible(false);
		shortVersionLabel.setVisible(false);
		noLocLabel.setVisible(false);
		
		if(nameField.getText().length() > 3 &&
			IDField.getText().length() > 1 &&
			versionField.getText().length() > 3){
			
			Core.name = nameField.getText();
			Core.id = IDField.getText().replace(" ", "").toUpperCase();
			Core.version = versionField.getText();
			Core.dir = dir;
			
			setVisible(false);
			FileCreater.fileCreaterMain();
			dispose();
		}else{
			if(nameField.getText().length()==0){
				noNameLabel.setVisible(true);
			}else if(nameField.getText().length() < 4){
				shortNameLabel.setVisible(true);
			}
			
			if(IDField.getText().length() == 0){
				noIDLabel.setVisible(true);
			}else if(IDField.getText().length() < 2){
				shortIDLabel.setVisible(true);
			}
			
			if(versionField.getText().length() == 0){
				noVersionLabel.setVisible(true);
			}else if(versionField.getText().length() < 4){
				shortVersionLabel.setVisible(true);
			}
			
			if(!dir.isDirectory()){
				noLocLabel.setVisible(true);
			}
		}
		
	}
}
