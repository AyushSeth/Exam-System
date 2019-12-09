import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class tEst_instruction extends JPanel{

	private JTextArea Name ;
	private JButton Begin;
	
	
	
	tEst_instruction(examSystem m) 
	{
		String windowsLAF=  "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try  
			{
		    UIManager.setLookAndFeel(windowsLAF);
			}
			catch (Exception e)  
			{
		    e.printStackTrace();
			}   
		 		
		Name = new JTextArea();
		String text="Click Begin button to start the test.";
		Name.setText(text);
		Name.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		add(Name);
		Begin=new JButton("Begin");
		//add(Begin);
		setLayout(new GridLayout(14,14,5,5));
		Begin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				m.test();				
			}
		});
		Begin.setSize(150,50);
		Begin.setLocation(450,250);
		add(Begin);
		//main.getContentPane().add(new JScrollPane(jtp));
		
		
		
	}
	
}