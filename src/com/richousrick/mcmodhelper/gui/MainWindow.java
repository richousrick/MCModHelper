package com.richousrick.mcmodhelper.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * TODO Annotate Class
 *
 * @author Richousrick
 *
 */
public class MainWindow extends JFrame {

    private static final long serialVersionUID = 4330219868141582179L;
    private JPanel contentPane;
    private ArrayList<Item> items;
    private ArrayList<Block> block;
    private ArrayList<Recipie> recipe;

    public class Recipie{
        String item;
        ArrayList<String> recipe;
        ArrayList<String[]> items;
        
    }
    
    public class Item{
    	String name;
    	int maxStackSize = 64;
    	File texture;
    	
    }
    
    public class Block{
    	String name;
    	int maxStackSize = 64;
    	File texture;
    	
    }
    
    /**
     * Launch the application.
     */
    public static void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
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
    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
    }

}
