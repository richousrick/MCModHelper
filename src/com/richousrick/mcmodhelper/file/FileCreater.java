package com.richousrick.mcmodhelper.file;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.richousrick.mcmodhelper.Core;

import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * TODO Annotate Class
 *
 * @author Richousrick
 *
 */
public class FileCreater extends JFrame {
	
	Thread thread;
	private JPanel contentPane;
	private JTextArea textArea;
	private JLabel lblWorkspaceIsBeing;
	private JLabel lblPleaseWait;
	private String root;
	private String importBase;
	/**
	 * Launch the application.
	 */
	public static void fileCreaterMain() {
		FileCreater frame = new FileCreater();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public FileCreater() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 134, 414, 117);
		contentPane.add(textArea);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setBounds(10, 103, 41, 25);
		contentPane.add(lblDetails);
		
		lblWorkspaceIsBeing = new JLabel("Workspace is Being Created");
		lblWorkspaceIsBeing.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkspaceIsBeing.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkspaceIsBeing.setBounds(10, 10, 414, 25);
		contentPane.add(lblWorkspaceIsBeing);
		
		lblPleaseWait = new JLabel("Please Wait.");
		lblPleaseWait.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseWait.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPleaseWait.setBounds(10, 40, 414, 25);
		contentPane.add(lblPleaseWait);
		
		Runnable runnable = new updateUi();
        thread = new Thread(runnable);
        thread.start();
	}
	
	public void createWorkspace() throws IOException{
		addText("Starting");
		addText("Setting up Folders");
		importBase = "com\\"+System.getProperty("user.name")+"\\"+Core.name.replace(" ", "");
		importBase = importBase.toLowerCase();
		root = Core.dir.getAbsolutePath()+"\\src\\main";
		String codeSrc = root+("\\java\\"+importBase);
		String resourceSrc = root+("\\resources\\assets\\"+Core.name.replace(" ", "")).toLowerCase();
		new File(root).mkdirs();
			new File(codeSrc).mkdirs();
				new File(codeSrc+"\\blocks").mkdirs();
				new File(codeSrc+"\\creativetab").mkdirs();
				new File(codeSrc+"\\items").mkdirs();
				new File(codeSrc+"\\proxy").mkdirs();
				new File(codeSrc+"\\recipies").mkdirs();
				new File(codeSrc+"\\reference").mkdirs();
				new File(codeSrc+"\\blocks").mkdirs();
				new File(codeSrc+"\\blocks").mkdirs();
				
			new File(resourceSrc).mkdirs();
				new File(resourceSrc+"\\lang").mkdirs();
				new File(resourceSrc+"\\models").mkdirs();
				new File(resourceSrc+"\\sounds").mkdirs();
				new File(resourceSrc+"\\textures\\blocks").mkdirs();
				new File(resourceSrc+"\\textures\\items").mkdirs();
				new File(resourceSrc+"\\textures\\gui").mkdirs();
		addText("Folders Created");
		addText("Creating Classes");
		importBase = importBase.replace("\\", ".")+".";
		//Blocks Base Class
		createBlockBase(codeSrc+"\\blocks\\Block"+Core.id+".java");
		createReference(codeSrc+"\\reference\\Reference.java");
		createClientProxy(codeSrc+"\\proxy\\ClientProxy.java");
		createCommonProxy(codeSrc+"\\proxy\\CommonProxy.java");
		createItemBase(codeSrc+"\\items\\Item"+Core.id+".java");
		addText("Done");
		System.exit(0);
		thread = null;
	}
	
	public void createBlockBase(String dir) throws IOException{
		BufferedWriter bw;
		String name = "Block"+Core.id;
		bw = new BufferedWriter(new FileWriter(new File(dir)));
		bw.write("package "+importBase+"blocks");
		bw.newLine();
		bw.newLine();
		bw.write("import "+importBase+"creativetab.CreativeTab"+Core.id+";");
		bw.newLine();
		bw.write("import "+importBase+"reference.Reference;");
		bw.newLine();
		bw.newLine();
		bw.write("import cpw.mods.fml.relauncher.Side;");
		bw.newLine();
		bw.write("import cpw.mods.fml.relauncher.SideOnly;");
		bw.newLine();
		bw.write("import net.minecraft.block.Block;");
		bw.newLine();
		bw.write("import net.minecraft.block.material.Material;");
		bw.newLine();
		bw.write("import net.minecraft.client.renderer.texture.IIconRegister;");
		bw.newLine();
		bw.write("import net.minecraft.item.ItemStack;");
		bw.newLine();
		bw.newLine();
		bw.write("public class"+name+" extends Block{");
		bw.newLine();
		bw.newLine();
		bw.write("	public "+name+"(Material material){");
		bw.newLine();
		bw.write("		super(material);");
		bw.newLine();
		bw.write("		this.setCreativeTab(CreativeTab"+Core.id+"."+Core.id+"_Tab);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	public "+name+"(){");
		bw.newLine();
		bw.write("		this(Material.rock);");
		bw.newLine();
		bw.newLine();
		bw.write("	@Override");
		bw.newLine();
		bw.write("	public String getUnlocalizedName(){");
		bw.newLine();
		bw.write("		return String.format(\"tile.%s%s\", Reference.MOD_ID.toLowerCase() + \":\", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {");
		bw.newLine();
		bw.write("		return unlocalizedName.substring(unlocalizedName.indexOf(\".\")+1);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	@Override");
		bw.newLine();
		bw.write("	@SideOnly(Side.CLIENT)");
		bw.newLine();
		bw.write("	public void registerBlockIcons(IIconRegister iconRegister){");
		bw.newLine();
		bw.write("		blockIcon = iconRegister.registerIcon(String.format(\"%s\", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		
		bw.close();
	}
	
	public void createItemBase(String dir) throws IOException{
		BufferedWriter bw;
		String name = "Item"+Core.id;
		bw = new BufferedWriter(new FileWriter(new File(dir)));
		bw.write("package "+importBase+"items");
		bw.newLine();
		bw.newLine();
		bw.write("import "+importBase+"creativetab.CreativeTab"+Core.id+";");
		bw.newLine();
		bw.write("import "+importBase+"reference.Reference;");
		bw.newLine();
		bw.newLine();
		bw.write("import cpw.mods.fml.relauncher.Side;");
		bw.newLine();
		bw.write("import cpw.mods.fml.relauncher.SideOnly;");
		bw.newLine();
		bw.write("import net.minecraft.item.Item;");
		bw.newLine();
		bw.write("import net.minecraft.client.renderer.texture.IIconRegister;");
		bw.newLine();
		bw.write("import net.minecraft.item.ItemStack;");
		bw.newLine();
		bw.newLine();
		bw.write("public class"+name+" extends Item{");
		bw.newLine();
		bw.newLine();
		bw.write("	public "+name+"(){");
		bw.newLine();
		bw.write("		super();");
		bw.newLine();
		bw.write("		this.setCreativeTab(CreativeTab"+Core.id+"."+Core.id+"_Tab);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	@Override");
		bw.newLine();
		bw.write("	public String getUnlocalizedName(){");
		bw.newLine();
		bw.write("		return String.format(\"item.%s%s\", Reference.MOD_ID.toLowerCase() + \":\", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	@Override");
		bw.newLine();
		bw.write("	public String getUnlocalizedName(ItemStack itemStack){");
		bw.newLine();
		bw.write("		return String.format(\"item.%s%s\", Reference.MOD_ID.toLowerCase() + \":\", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {");
		bw.newLine();
		bw.write("		return unlocalizedName.substring(unlocalizedName.indexOf(\".\")+1);");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("	@Override");
		bw.newLine();
		bw.write("	@SideOnly(Side.CLIENT)");
		bw.newLine();
		bw.write("	public void registerItemIcons(IIconRegister iconRegister){");
		bw.newLine();
		bw.write("		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(\".\") + 1));");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.write("}");
		bw.newLine();
		
		bw.close();
	}
	
	public void createReference(String dir) throws IOException{
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(new File(dir)));
		bw.write("package "+importBase+"reference;");
		bw.newLine();
		bw.newLine();
		bw.write("public class Reference {");
		bw.newLine();
		bw.newLine();
		bw.write("	public static final String MOD_ID =\""+Core.name.replace(" ", "")+"\"; ");
		bw.newLine();
		bw.newLine();
		bw.write("	public static final String MOD_NAME =\""+Core.name+"\"; ");
		bw.newLine();
		bw.newLine();
		bw.write("	public static final String VERSION =\""+Core.version+"\"; ");
		bw.newLine();
		bw.newLine();
		bw.write("	public static final String CLIENT_PROXY = \""+importBase+"proxy.ClientProxy\";");
		bw.newLine();
		bw.newLine();
		bw.write("	public static final String COMMON_PROXY = \""+importBase+"proxy.CommonProxy\";");
		bw.newLine();
		bw.newLine();
		bw.close();
	}
	
	public void createClientProxy(String dir) throws IOException{
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(new File(dir)));
		bw.write("package "+importBase+"proxy;");
		bw.newLine();
		bw.newLine();
		bw.write("public class ClientProxy extends CommonProxy{");
		bw.newLine();
		bw.newLine();
		bw.write("}");
		bw.close();
	}
	
	public void createCommonProxy(String dir) throws IOException{
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(new File(dir)));
		bw.write("package "+importBase+"proxy;");
		bw.newLine();
		bw.newLine();
		bw.write("import cpw.mods.fml.common.registry.GameRegistry;");
		bw.newLine();
		bw.newLine();
		bw.write("public abstract class CommonProxy{");
		bw.newLine();
		bw.newLine();
		bw.write("	public void registerTileEntitys(){");
		bw.newLine();
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.write("}");
		bw.close();
	}
	
	public void addText(String s){
		textArea.append(s+"\n");
		textArea.setCaretPosition(textArea.getText().length() - 1);
	}
	
	class updateUi implements Runnable {
        public void run() {
              try {
				createWorkspace();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

}
