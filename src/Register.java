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

public class Register extends JPanel{

	private JTextArea Name ;
	private JTextField name_entered;
	private JTextArea College_Name;
	private JTextField college_name;
	private JTextArea College_roll_no;
	private JTextField college_roll_no;
	private JTextArea Year_of_passout;
	private JTextField year_of_passout;
	private JTextArea DOB ;
	private JTextField dob;
	private JButton Submit;
	private JLabel format;
	private JTextArea Gmail;
	private JTextField gmail;
	
	Connection myconn=null;
	Statement mystmt=null;
	ResultSet myrslt=null;
	
	String dburl="jdbc:mysql://localhost:3306/Student_list";	//	"jdbc:mysql://localhost:3306/StudentList";
	String username="root";
	String password="Ayush123456789";
	
	Register(examSystem m) 
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
		 try {
			myconn = DriverManager.getConnection(dburl,username,password);
			mystmt=myconn.createStatement();
			/*int row_affected1=mystmt.executeUpdate(
					"insert into Student"
					+ "(Name,College_Name,Roll_No,Year_Of_Passout,E_Mail,Marks)"
					+ "values"
					+ "('Ayush','HCST','16064','2020','amanayy@gmail.com',10)");
			myrslt=mystmt.executeQuery("select * from Student");*/
			/*int row_affected2=mystmt.executeUpdate(
					"insert into Student"
					+ "(Name,College_Name,Roll_No,Year_Of_Passout,E-Mail,Marks)"
					+ "values"
					+ "('Ayush','HCST',16064,2020,'amanayy@gmail.com',10)");
			
			*/
			myrslt=mystmt.executeQuery("select * from  Student");
			
			while(myrslt.next())
			{
				  System.out.println(myrslt.getString("Name")+", "+myrslt.getString("College_Name"));
			}
			
			System.out.println("Connected");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			System.out.println("Not Connected");
			e1.printStackTrace();
		}
		Name = new JTextArea("  Name : ");
		Name.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		Name.setBackground(Color.white);
		Name.setEditable(false);
		add(Name);
		name_entered=new JTextField(50);
		name_entered.setLocation(300,300);
		name_entered.setBorder(BorderFactory.createMatteBorder(2,2,2,2,  Color.BLACK));
		name_entered.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		add(name_entered);
		
		
		College_Name=new JTextArea("  College Name : ");
		College_Name.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		College_Name.setBackground(Color.white);
		College_Name.setEditable(false);
		add(College_Name);
		college_name=new JTextField();
		college_name.setBorder(BorderFactory.createMatteBorder(2,2,2,2,  Color.BLACK));
		college_name.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		add(college_name);
		
		
		College_roll_no=new JTextArea("  College Roll Number : ");
		College_roll_no.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		College_roll_no.setBackground(Color.white);
		College_roll_no.setEditable(false);
		add(College_roll_no);
		college_roll_no=new JTextField();
		college_roll_no.setBorder(BorderFactory.createMatteBorder(2,2,2,2,  Color.BLACK));
		college_roll_no.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		add(college_roll_no);
		
		
		Year_of_passout =new JTextArea("  Year Of Passout : ");
		Year_of_passout.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		Year_of_passout.setBackground(Color.white);
		Year_of_passout.setEditable(false);
		add(Year_of_passout);
		year_of_passout=new JTextField();
		year_of_passout.setBorder(BorderFactory.createMatteBorder(2,2,2,2,  Color.BLACK));
		year_of_passout.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		add(year_of_passout);
		
		
/*		DOB =new JTextArea("  Date Of Birth : ");
		DOB.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		DOB.setBackground(Color.white);
		DOB.setEditable(false);
		message_displayed.add(DOB);
		dob=new JTextField();
		dob.setBorder(BorderFactory.createMatteBorder(2,2,2,2,  Color.BLACK));
		dob.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		message_displayed.add(dob);
		
		format=new JLabel("<html><b>Date of birth should be in format dd-mm-yy</b></html>");
		message_displayed.add(format);
*/
		
		Gmail=new JTextArea("  Email ID : ");
		Gmail.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
		Gmail.setBackground(Color.white);
		Gmail.setEditable(false);
		add(Gmail);
		gmail=new JTextField();
		gmail.setBorder(BorderFactory.createMatteBorder(2,2,2,2,  Color.BLACK));
		gmail.setFont(new Font(Font.DIALOG,Font.PLAIN, 28));
		add(gmail);
		
		
		Submit=new JButton("Submit and Start");
		Submit.setSize(150,50);
		Submit.setLocation(450,250);
		
		Submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					System.out.println("Inside the ");
					PreparedStatement ps=myconn.prepareStatement("insert into Student values(?,?,?,?,?)");
					String name=name_entered.getText();
					String college=college_name.getText();
					String roll=college_roll_no.getText();
					String yop=year_of_passout.getText();
					String mail=gmail.getText();
					int ROLL= Integer.parseInt(roll);
					
					//mystmt=myconn.prepareStatement("select * from Student where Name=?, College_Name=?, Roll_No=?,Year_Of_Passout=?,E_Mail=? and Marks=?");
					/*((PreparedStatement) mystmt).setString(1,name);
					((PreparedStatement) mystmt).setString(2,college);
					((PreparedStatement) mystmt).setString(3,roll);
					((PreparedStatement) mystmt).setString(4,yop);
					((PreparedStatement) mystmt).setString(5,mail);*/
					
					
					ps.setInt(1,ROLL);
					ps.setString(2,name);
					ps.setString(3,college);
					ps.setString(4,yop);
					ps.setString(5,mail);
					
					
					int i = ps.executeUpdate();
					//System.out.println(i+" rows affected");
					myrslt=mystmt.executeQuery("select * from Student");
					/*while(myrslt.next())
					{
						  System.out.println(myrslt.getString("Name")+", "+myrslt.getString("College_Name"));
					}*/
				/*	int row_affected=mystmt.executeUpdate(
							"insert into Student"
							+ "(Name,College_Name,Roll_No,Year_Of_Passout,E_Mail,Marks)"
							+ "values"
							+ "('mail','HCST','11',2019,'love@gmail.com',12)");*/
					
					myconn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//main.getContentPane().removeAll();
				//main.setVisible(false);
				m.test_start();
				
			}
		});
		add(Submit);
		
		
		
		setLayout(new GridLayout(14,14,5,5));
		
		
		//main.getContentPane().add(new JScrollPane(jtp));
		
		
		
	}
	
}