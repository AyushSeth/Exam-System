
import javax.swing.*;

//import Test.TimerListener;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBegin{
    	JFrame frame;
    JFrame f;
    Timer timer;
    JLabel count;
    JLabel message;
    int[] time;
    int MIN = 0;
    int SEC = 1;
   JButton previous;
   JButton next;
   JButton submit;
   JPanel panel;
   JPanel middle;
   JPanel nxt;
   JPanel end=new JPanel();
   JPanel submt;
   JTextArea question;
   JTextArea option1;
   JTextArea option2;
   JTextArea option3;
   JTextArea option4;
   int flag=0;
   static int counter=0;
   Connection myconn=null;
	Statement mystmt=null;
	ResultSet myrslt=null;
	
   
   public TestBegin(){
   	
   	
   	String windowsLAF=  "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
   	try  
   		{
   	    UIManager.setLookAndFeel(windowsLAF);
   		}
   	catch (Exception e)  
   		{
   	    e.printStackTrace();
   		}
   	
   	// Middle panel along with the questions 
   	
   	
   	
   	
   	
   	
   	
   	
   	
   	//    Lower Panel and also the counter
       frame = new JFrame();
		panel = new JPanel();
		nxt = new JPanel();
		submt = new JPanel();
		previous = new JButton("Previous");
		previous.setAlignmentX(1500);
		previous.setFont(new Font("Arial Black", Font.BOLD, 15));
		previous.setSize(120,120);
		end = new JPanel();
		end.add(previous,BorderLayout.EAST);
		//end.add(previous,BorderLayout.CENTER);
		count = new JLabel();
		count.setFont(new Font("Arial Black", Font.BOLD, 25));
       count.setHorizontalAlignment(SwingConstants.CENTER);
		
       //panel.add(count,BorderLayout.NORTH);
		
		//middle.setLocation(500,500);
		panel.add(count);
		//panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		
		frame.add(panel,BorderLayout.NORTH);
		
		next = new JButton("Next");
		next.setAlignmentX(1500);
		next.setFont(new Font("Arial Black", Font.BOLD, 15));
		next.setSize(120,120);
		end.add(next,BorderLayout.CENTER);
		//frame.add(nxt,BorderLayout.WEST);
		
		submit = new JButton("Submit");
		submit.setAlignmentX(1500);
		submit.setFont(new Font("Arial Black", Font.BOLD, 15));
		submit.setSize(120,120);
		end.add(submit,BorderLayout.CENTER);
		end.setSize(150,150);
		end.setLayout(new GridLayout(1,3,55,555));
		frame.add(end,BorderLayout.SOUTH);
		
		//frame.add(end,);
		//frame.add(end,BorderLayout.AFTER_LINE_ENDS);
		

		middle = new JPanel();

    	try {
    		String dburl="jdbc:mysql://localhost:3306/Question_list";	//	"jdbc:mysql://localhost:3306/StudentList";
    		String username="root";
    		String password="Ayush123456789";
    		myconn = DriverManager.getConnection(dburl,username,password);
			mystmt=myconn.createStatement();
			myrslt=mystmt.executeQuery("select * from Questions");
			
			String comment="\"There is no Previous Button\r\n that means you cannot attempt the Previous question\r\n Click next to begin the test";
				  JLabel label=new JLabel(comment);
				  label.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
				  middle.add(label);
				  frame.add(middle,BorderLayout.CENTER);
				  
				  //question.
				  
				  next.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						flag=1;
						//frame.getContentPane().removeAll();
						middle.removeAll();
						
						//question.setText("");option1.setText("");option2.setText("");option3.setText("");option4.setText("");
						try {
							myrslt.next();
							question=new JTextArea();
							option1 =new JTextArea();option2 =new JTextArea();option3 =new JTextArea();option4 =new JTextArea();
							  System.out.println(myrslt.getString("Ques")+", "+myrslt.getString("op1"));
							  String ques=myrslt.getString("Ques");System.out.println(ques);
							  String o1=myrslt.getString("op1");System.out.println(o1);
							  String o2=myrslt.getString("op2");System.out.println(o2);
							  String o3=myrslt.getString("op3");System.out.println(o3);
							  String o4=myrslt.getString("op4");System.out.println(o4);
							  int o5=myrslt.getInt("answer");int fa=1;
							  boolean bool1=false,bool2=false,bool3=false,bool4=false;
							  switch(o5)
							  {
							  	case 1:bool1=true;break;
							  	case 2:bool2=true;break;
							  	case 3:bool3=true;break;
							  	case 4:bool4=true;break;
							  }
							  int correct_answer=o5;
							  question.setText(ques);question.setEditable(false);
							  question.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  middle.add(question);
							  
							  JRadioButton OP1 = new JRadioButton(o1);
							  OP1.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  OP1.setSize(28,28);
							  OP1.setMnemonic(KeyEvent.VK_C);
							  //OP1.setActionCommand(o1);
							  if(OP1.isSelected()&&bool1==true&&bool2==false&&bool3==false&&bool4==false) {
								  if(o5==1) {
									  counter++;
								  }
							  }
							  
							 
							  JRadioButton OP2 = new JRadioButton(o2);
							  OP2.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  OP2.setMnemonic(KeyEvent.VK_C);
							  //OP2.setActionCommand(o1);
							  if(OP2.isSelected()&&bool2==true&&bool1==false&&bool3==false&&bool4==false) {
								  if(o5==2) {
									  counter++;
								  }
							  }
							  
							  
							  JRadioButton OP3 = new JRadioButton(o3);
							  OP3.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  OP3.setMnemonic(KeyEvent.VK_C);
							  //OP3.setActionCommand(o3);
							  if(OP3.isSelected()&&bool3==true&&bool2==false&&bool1==false&&bool4==false) {
								  if(o5==3) {
									  counter++;
								  }
							  }
							 
							  
							  JRadioButton OP4 = new JRadioButton(o4);
							  OP4.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  OP4.setMnemonic(KeyEvent.VK_C);
							  //OP4.setActionCommand(o4);
							  if(OP4.isSelected()&&bool3==false&&bool2==false&&bool1==false&&bool4==true) {
								  if(o5==4) {
									  counter++;
								  }
							  }
							 
							  
							  ButtonGroup group = new ButtonGroup();
							  group.add(OP1);
							  group.add(OP2);
							  group.add(OP3);
							  group.add(OP4);
							  System.out.println("counter ="+counter);
							  /*OP1.addActionListener(this);
							  OP2.addActionListener(this);
							  OP3.addActionListener(this);
							  OP4.addActionListener(this);*/
							  /*option1.setText(o1);option1.setEditable(false);
							  option1.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  middle.add(option1);
							  option2.setText(o2);option2.setEditable(false);
							  option2.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  middle.add(option2);
							  option3.setText(o3);option3.setEditable(false);
							  option3.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  middle.add(option3);
							  option4.setText(o4);option4.setEditable(false);
							  option4.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
							  */
							  //System.out.println(counter);
							  middle.add(OP1);middle.add(OP2);middle.add(OP3);middle.add(OP4);
							  middle.setLayout(new GridLayout(5,1,5,5));
							  //frame.add(middle);
							  frame.add(middle,BorderLayout.CENTER);
							  
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				 
				  previous.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							flag=1;
							//frame.getContentPane().removeAll();
							middle.removeAll();
							
							//question.setText("");option1.setText("");option2.setText("");option3.setText("");option4.setText("");
							try {
								myrslt.previous();
								question=new JTextArea();
								option1 =new JTextArea();option2 =new JTextArea();option3 =new JTextArea();option4 =new JTextArea();
								  System.out.println(myrslt.getString("Ques")+", "+myrslt.getString("op1"));
								  String ques=myrslt.getString("Ques");System.out.println(ques);
								  String o1=myrslt.getString("op1");System.out.println(o1);
								  String o2=myrslt.getString("op2");System.out.println(o2);
								  String o3=myrslt.getString("op3");System.out.println(o3);
								  String o4=myrslt.getString("op4");System.out.println(o4);
								  int o5=myrslt.getInt("answer");int fa=1;
								  boolean bool1=false,bool2=false,bool3=false,bool4=false;
								  switch(o5)
								  {
								  	case 1:bool1=true;break;
								  	case 2:bool2=true;break;
								  	case 3:bool3=true;break;
								  	case 4:bool4=true;break;
								  }
								  int correct_answer=o5;
								  question.setText(ques);question.setEditable(false);
								  question.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  middle.add(question);
								  
								  JRadioButton OP1 = new JRadioButton(o1);
								  OP1.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  OP1.setSize(28,28);
								  OP1.setMnemonic(KeyEvent.VK_C);
								  //OP1.setActionCommand(o1);
								  if(OP1.isSelected()&&bool1==true&&bool2==false&&bool3==false&&bool4==false) {
									  if(o5==1) {
										  counter++;
									  }
								  }
								  
								 
								  JRadioButton OP2 = new JRadioButton(o2);
								  OP2.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  OP2.setMnemonic(KeyEvent.VK_C);
								  //OP2.setActionCommand(o1);
								  if(OP2.isSelected()&&bool2==true&&bool1==false&&bool3==false&&bool4==false) {
									  if(o5==2) {
										  counter++;
									  }
								  }
								  
								  
								  JRadioButton OP3 = new JRadioButton(o3);
								  OP3.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  OP3.setMnemonic(KeyEvent.VK_C);
								  //OP3.setActionCommand(o3);
								  if(OP3.isSelected()&&bool3==true&&bool2==false&&bool1==false&&bool4==false) {
									  if(o5==3) {
										  counter++;
									  }
								  }
								 
								  
								  JRadioButton OP4 = new JRadioButton(o4);
								  OP4.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  OP4.setMnemonic(KeyEvent.VK_C);
								  //OP4.setActionCommand(o4);
								  if(OP4.isSelected()&&bool3==false&&bool2==false&&bool1==false&&bool4==true) {
									  if(o5==4) {
										  counter++;
									  }
								  }
								 
								  
								  ButtonGroup group = new ButtonGroup();
								  group.add(OP1);
								  group.add(OP2);
								  group.add(OP3);
								  group.add(OP4);
								  System.out.println("counter ="+counter);
								  /*OP1.addActionListener(this);
								  OP2.addActionListener(this);
								  OP3.addActionListener(this);
								  OP4.addActionListener(this);*/
								  /*option1.setText(o1);option1.setEditable(false);
								  option1.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  middle.add(option1);
								  option2.setText(o2);option2.setEditable(false);
								  option2.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  middle.add(option2);
								  option3.setText(o3);option3.setEditable(false);
								  option3.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  middle.add(option3);
								  option4.setText(o4);option4.setEditable(false);
								  option4.setFont(new Font(Font.DIALOG,Font.BOLD, 25));
								  */
								  //System.out.println(counter);
								  middle.add(OP1);middle.add(OP2);middle.add(OP3);middle.add(OP4);
								  middle.setLayout(new GridLayout(5,1,5,5));
								  //frame.add(middle);
								  frame.add(middle,BorderLayout.CENTER);
								  
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
						}
					});	  
				  
			}
    		  
		
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		//frame.setLayout(new GridLayout(1,1,1,1));
		frame.setUndecorated(true);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		//frame.setSize(600,600);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
       //frame.setLocation(650,150);
       frame.setVisible(true);
   }
   void counter(String time){
   	
		
		
		//middle.add(previous);
		
		 this.time = convertTimeToInt(time.split(":"));
	        count.setText(time);
	        timer = new Timer(1000,new TimerListener());
	        timer.setRepeats(true);
	        timer.start();
		
	}
	public int[] convertTimeToInt(String[] time){
      int[] converted = new int[time.length];
      for(int i = 0; i<time.length; i++){
          converted[i] = Integer.valueOf(time[i]);
      }
      return converted;
  }
	public void displayTime(int min, int sec){
      String minute = String.format("%02d",min);
      String second = (String.format("%02d",sec));
      count.setText(minute + ":" + second);
  }
	 private class TimerListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if(time[MIN] == 0 && (time[SEC] == 1 || time[SEC] == 0)){
	                count.setText("");
	            //    JOptionPane 
	                message.setText("END");
	                timer.stop();
	            }else if(time[SEC] > 0){
	                time[SEC] -= 1;
	                displayTime(time[MIN], time[SEC]);
	            }else if(time[SEC] == 0){
	                time[SEC] = 59;
	                time[MIN] -= 1;
	                displayTime(time[MIN], time[SEC]);
	            }

	            count.setForeground(time[MIN] == 0 && time[SEC] >= 6 ? Color.BLACK : Color.RED);
	        }
	    }
    
    
}
