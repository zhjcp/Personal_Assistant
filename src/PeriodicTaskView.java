import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class PeriodicTaskView extends JFrame implements ActionListener
{
	private int whichList;//当前正在添加任务所属清单在清单列表的索引
	private int whichTask;//当前任务在当前清单里的索引
	private PeriodicTask periodicTask;
	private TaskSystem taskSystem;
	
	private JPanel contentPane;
	private JTextField textName;
	private JTextField text1;
	private JTextField text4;
	private JTextField text2;
	private JTextField text3;
	JLabel ddlLabel;
    private JTextArea textArea;
	
	
	public PeriodicTaskView(TaskSystem taskSystem_x) 
	{		
		this.taskSystem=taskSystem_x;//指向同一个索引,指向当前任务

		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4EFB\u52A1\u540D\u79F0");
		lblNewLabel.setBounds(10, 22, 54, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6267\u884C\u5468\u671F");
		lblNewLabel_1.setBounds(10, 98, 54, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u91CD\u590D\u6B21\u6570");
		lblNewLabel_2.setBounds(10, 129, 54, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u622A\u6B62\u65E5\u671F");
		lblNewLabel_3.setBounds(10, 163, 54, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u4EFB\u52A1\u63CF\u8FF0");
		lblNewLabel_4.setBounds(10, 228, 54, 29);
		contentPane.add(lblNewLabel_4);
		
		textArea = new JTextArea();
		JScrollPane jScrollPane=new JScrollPane(textArea);
		jScrollPane.setBounds(74, 228, 288, 194);
		contentPane.add(jScrollPane);
		
		textName = new JTextField();
		textName.setBounds(74, 24, 288, 21);
		contentPane.add(textName);
		textName.setColumns(10);
		//周期：年
		text1 = new JTextField();
		text1.setBounds(74, 100, 66, 21);
		contentPane.add(text1);
		text1.setColumns(10);
		//重复次数
		text4 = new JTextField();
		text4.setBounds(74, 131, 66, 21);
		contentPane.add(text4);
		text4.setColumns(10);
		
		ddlLabel = new JLabel("\u5F85\u8F93\u51FA");
		ddlLabel.setForeground(Color.MAGENTA);
		ddlLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ddlLabel.setFont(new Font("黑体", Font.ITALIC, 12));
		ddlLabel.setBounds(74, 163, 288, 24);
		contentPane.add(ddlLabel);
		
		JButton saveBtn = new JButton("\u4FDD\u5B58");
		saveBtn.setBackground(Color.ORANGE);
		saveBtn.setBounds(340, 498, 102, 47);
		saveBtn.addActionListener(this);
		contentPane.add(saveBtn);
		
		JLabel lblNewLabel_5 = new JLabel("\u5E74");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(150, 97, 25, 21);
		contentPane.add(lblNewLabel_5);
		//周期：月
		text2 = new JTextField();
		text2.setBounds(185, 100, 66, 21);
		contentPane.add(text2);
		text2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u6708");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(261, 98, 25, 20);
		contentPane.add(lblNewLabel_6);
		//周期：日
		text3 = new JTextField();
		text3.setBounds(296, 100, 66, 21);
		contentPane.add(text3);
		text3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u65E5");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(372, 103, 25, 15);
		contentPane.add(lblNewLabel_7);
		
		setTitle("周期任务");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 456, 582);
	}
	
	   //事件处理
	   public void actionPerformed(ActionEvent e) 
	   {
		   String opString=(String) e.getActionCommand();
		   switch(opString)
		   {
		   case "保存":
		   {
			   
			   String taskName=this.textName.getText();
			   String taskDescribe=this.textArea.getText();
			   int dealtYear=0;
			   int dealtMonth=0;
			   int dealtDay=0;
			   int ciShu=0;
			   if(this.text4.getText().length()>0)
			   {	   
System.out.println("次数不为0啊"+Integer.valueOf(this.text4.getText()));
				   ciShu=Integer.valueOf(this.text4.getText());
			    if(this.text1.getText().length()>0)
			    {
			       dealtYear=Integer.valueOf(this.text1.getText())*ciShu;
			    }
			    if(this.text2.getText().length()>0)
			       dealtMonth=Integer.valueOf(this.text2.getText())*ciShu;
			    if(this.text3.getText().length()>0)
			       dealtDay=Integer.valueOf(this.text3.getText())*ciShu;
			    
			    this.periodicTask.addToDdl(dealtYear,dealtMonth,dealtDay);//向下转型后
			    			    
			    this.periodicTask.setZhouQi(Integer.valueOf(this.text1.getText()), Integer.valueOf(this.text2.getText()),Integer.valueOf(this.text3.getText()), ciShu);
			    //this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).addCalendar(dealtYear,dealtMonth,dealtDay);		
			   }
			   this.periodicTask.setTaskDescription(taskDescribe);
			   this.taskSystem.saveData();
			   initializePeriodicTaskView();//更新保存后的界面
			   break;
		   }
		   
		   default:
				throw new IllegalArgumentException("Unexpected value: " + opString);
		   }
	   }
	   
	   public void setWhichList(int index) 
	 		{
	 			this.whichList=index;
	 		}
	   public void setWhichTask(int index) 
	 	   {
	 		   this.whichTask=index;
	 	   }
	   public void setPeriodicTask() 
	   {
			this.periodicTask=(PeriodicTask)this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask);//向下转型
			initializePeriodicTaskView();
	   }
	   
	   public void initializePeriodicTaskView()//更新周期任务界面
	   {
		     this.textName.setText(this.periodicTask.getTaskName());
		     this.text1.setText(String.valueOf(this.periodicTask.getzhouqiYear()));
		     this.text2.setText(String.valueOf(this.periodicTask.getzhouqiMonth()));
		     this.text3.setText(String.valueOf(this.periodicTask.getzhouqiDay()));
		     this.text4.setText(String.valueOf(this.periodicTask.getCiShu()));
		     this.textArea.setText(this.periodicTask.getTaskDescription());
		   		   
		     String ddlTime=new String();
			 ddlTime+=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTimeTask().getDdlYear()+" 年 ";
		     ddlTime+=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTimeTask().getDdlMonth()+" 月 ";
		     ddlTime+=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTimeTask().getDdlDay()+" 日 ";
		     System.out.println("新的时间"+ddlTime);
			 this.ddlLabel.setText(ddlTime);
	}
	 	   
	 	   
}
