
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class examSystem  {
JFrame register=new JFrame("Registration ");
JFrame Main=new JFrame("Instructions ");
JFrame Beg=new JFrame("Instructions ");
JFrame test_start_now=new JFrame("Exam System");
//JFrame test_begin_now=new JFrame("Exam");
JPanel message_displayed=new JPanel();
JTextPane jtp=new JTextPane();

	examSystem()
	{
		Register reg=null;
		register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		register.getContentPane().add(reg = new Register(this));
		register.setLocation(650,150);
		register.setSize(700,700);
		register.setVisible(true);
		
	}
	void test_start()
	{	

	register.getContentPane().removeAll();
	register.setVisible(false);
	String windowsLAF=  "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	try  
		{
	    UIManager.setLookAndFeel(windowsLAF);
		}
	catch (Exception e)  
		{
	    e.printStackTrace();
		}

	jtp.setFont(new Font(Font.DIALOG,Font.BOLD, 15));
	jtp.setContentType("text/html");
	jtp.setText(
			"<html>"+
			"<b><h1>Instruction:</h1></b>\r\n" + 
			"\r\n" +
			"<ul>"+
			"<li>   Total number of questions : 20.</li>\r\n" + 
			"<li>   Time alloted : 20 minutes.</li>\r\n" + 
			"<li>   Each question carry 1 mark, no negative marks.</li>\r\n" + 
			"<li>   All the best :-).</li>"+
			"</ul></html>"
			);
	jtp.setBorder(BorderFactory.createMatteBorder(1,1,1,1,  Color.BLACK));
	jtp.setEditable(false);
	JButton start_test=new JButton("<html><h1><b>Start Test</b></h1></html>");	
	start_test.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//tEst_ins();
			test();
		} 
	});
	start_test.setSize(150,50);
	start_test.setLocation(450,250);
	message_displayed.add(jtp);	
	Main.add(message_displayed);
	Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Main.add(start_test);
	Main.getContentPane().add(new JScrollPane(jtp));
	Main.setLocation(650,150);
	Main.setSize(700,700);
	Main.setVisible(true);	
	}	
	
	
/*	void tEst_ins()
	{
		tEst_instruction ti=null;
		Main.getContentPane().removeAll();
		Main.setVisible(false);
		Beg.getContentPane().add(ti=new tEst_instruction(this));
		Beg.setLocation(650,150);
		Beg.setSize(700,700);
		Beg.setdsVisible(true);
	}*/
	void test()
	{
		Main.getContentPane().removeAll();
		Main.setVisible(false);
		//TestBegin tb=null;
		TestBegin tb=null;
		
		//test_begin_now.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tb = new TestBegin();
		tb = new TestBegin();
		
		tb.counter("02:00");
		//test_begin_now.getContentPane();
		//test_begin_now.getContentPane().add(tb = new TestBegin());
		//test_begin_now.setExtendedState(Frame.MAXIMIZED_BOTH);
		//test_begin_now.setLocation(650,150);
		//test_begin_now.setSize(700,700);
		//test_begin_now.setVisible(true);
		
	}
	public static void main(String[] args) 
	{
	examSystem exam_System=new examSystem();
	
	}
}