package com.richousrick.mcmodhelper.gui;

import java.awt.EventQueue;

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

/**
 * TODO Annotate Class
 *
 * @author Richousrick
 *
 */
public class AddBlock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5481151462205791174L;
	
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField StackSizeField;
	private JTextField versionField;
	private JLabel noNameLabel;
	private JLabel noStackSizeLabel;
	private JLabel noVersionLabel;
	private JLabel shortNameLabel;
	private JLabel shortStackSizeLabel;
	private JLabel shortVersionLabel;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBlock frame = new AddBlock();
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
	public AddBlock() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titleLabel = new JLabel("Add Block");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		titleLabel.setBounds(169, 11, 114, 37);
		contentPane.add(titleLabel);
		
		JLabel stackSizeLabel = new JLabel("StackSize");
		stackSizeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stackSizeLabel.setBounds(47, 125, 46, 14);
		contentPane.add(stackSizeLabel);
		
		nameField = new JTextField();
		nameField.setToolTipText("The Mods Name");
		nameField.setBounds(119, 77, 257, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(47, 78, 46, 14);
		contentPane.add(nameLabel);
		
		StackSizeField = new JTextField();
		StackSizeField.setToolTipText("The Mods StackSize");
		StackSizeField.setColumns(10);
		StackSizeField.setBounds(119, 124, 257, 20);
		contentPane.add(StackSizeField);
		
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
		nextButton.setBounds(287, 220, 89, 23);
		contentPane.add(nextButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitButton.setBounds(47, 220, 89, 23);
		contentPane.add(exitButton);
		
		noNameLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">A name is required to continue.</font></html>");
		noNameLabel.setVisible(false);
		noNameLabel.setToolTipText("");
		noNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noNameLabel.setBounds(119, 59, 257, 14);
		contentPane.add(noNameLabel);
		
		noStackSizeLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">A mod StackSize is required to continue.</font></html>");
		noStackSizeLabel.setVisible(false);
		noStackSizeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noStackSizeLabel.setBounds(119, 108, 257, 14);
		contentPane.add(noStackSizeLabel);
		
		noVersionLabel = new JLabel("<html><font size=\"3\" face=\"tahoma\" color=\"red\">A label is required to continue.</font></html>");
		noVersionLabel.setVisible(false);
		noVersionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noVersionLabel.setBounds(119, 155, 257, 14);
		contentPane.add(noVersionLabel);
		
		shortNameLabel = new JLabel("<html><font size=\"2\" face=\"tahoma\" color=\"red\">The name should be 4 and 12 characters long.</font></html>");
		shortNameLabel.setVisible(false);
		shortNameLabel.setBounds(119, 59, 257, 14);
		contentPane.add(shortNameLabel);
		
		shortStackSizeLabel = new JLabel("<html><font size=\"2\" face=\"tahoma\" color=\"red\">The StackSize should be 4 and 12 characters long.</font></html>");
		shortStackSizeLabel.setVisible(false);
		shortStackSizeLabel.setBounds(119, 108, 257, 14);
		contentPane.add(shortStackSizeLabel);
		
		shortVersionLabel = new JLabel("<html><font size=\"2\" face=\"tahoma\" color=\"red\">The Version should be 4 and 12 characters long.</font></html>");
		shortVersionLabel.setVisible(false);
		shortVersionLabel.setBounds(119, 155, 257, 14);
		contentPane.add(shortVersionLabel);
	}
	
	
	
	public void finish(){
		noNameLabel.setVisible(false);
		noStackSizeLabel.setVisible(false);
		noVersionLabel.setVisible(false);
		shortNameLabel.setVisible(false);
		shortStackSizeLabel.setVisible(false);
		shortVersionLabel.setVisible(false);
		
		if(nameField.getText().length() > 3 &&
			StackSizeField.getText().length() > 1 &&
			versionField.getText().length() > 3){
			
			dispose();
		}else{
			if(nameField.getText().length()==0){
				noNameLabel.setVisible(true);
			}else if(nameField.getText().length() < 4){
				shortNameLabel.setVisible(true);
			}
			
			if(StackSizeField.getText().length() == 0){
				noStackSizeLabel.setVisible(true);
			}else if(StackSizeField.getText().length() < 2){
				shortStackSizeLabel.setVisible(true);
			}
			
			if(versionField.getText().length() == 0){
				noVersionLabel.setVisible(true);
			}else if(versionField.getText().length() < 4){
				shortVersionLabel.setVisible(true);
			}
		}
		
	}
	
}
