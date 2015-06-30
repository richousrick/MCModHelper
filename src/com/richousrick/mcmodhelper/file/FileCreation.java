package com.richousrick.mcmodhelper.file;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.richousrick.mcmodhelper.gui.MainWindow;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

/**
 * TODO Annotate Class
 *
 * @author Richousrick
 *
 */
public class FileCreation extends JFrame {
	private JTextArea textArea;
	public Thread thread;
	
	public FileCreation() {
		setSize(new Dimension(436, 308));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Workspace Creation");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Workspace is Being Created");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 10, 414, 30);
		lblNewLabel_1.setVisible(true);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblPleaseWait = new JLabel("Please Wait.");
		lblPleaseWait.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWait.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseWait.setBounds(10, 46, 414, 30);
		lblPleaseWait.setVisible(true);
		getContentPane().add(lblPleaseWait);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 414, 141);
		scrollPane.setVisible(true);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblDetails = new JLabel("Details");
		lblDetails.setBounds(10, 87, 53, 22);
		lblDetails.setVisible(true);
		getContentPane().add(lblDetails);
		
//		Runnable runnable = new updateUi();
//		thread = new Thread(runnable);
//        thread.start();
	}


	/**
	 * Launch the application.
	 */
	public static void workspaceSetup() {
		FileCreation frame = new FileCreation();
		frame.setVisible(true);
		int i=1;
		while(i==1){
			
		}
		frame.setVisible(false);
		
		
		
		
		System.out.println("hi");
		MainWindow.init();
	}

	
	
}
