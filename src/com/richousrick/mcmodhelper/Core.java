package com.richousrick.mcmodhelper;

import java.io.File;

import com.richousrick.mcmodhelper.gui.InitializationWindow;

/**
 * TODO Annotate Class
 *
 * @author Richousrick
 *
 */
public class Core {

	public static String name, id, version;
	public static File dir;
	
	public static void main(String[] args) {
		InitializationWindow.init();
	}
}
