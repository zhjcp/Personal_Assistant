import java.awt.Color;
import java.awt.Frame;
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

public class TempTaskView extends JFrame implements ActionListener
{
	private int whichList;//当前正在添加任务所属清单在清单列表的索引
	private int whichTask;//当前任务在当前清单里的索引
	private TaskSystem taskSystem;
	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField nameText;
	JTextArea textArea;
	
	public  TempTaskView(TaskSystem taskSystem_x) 
	{
		this.taskSystem=taskSystem_x;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u4EFB\u52A1\u540D\u79F0\uFF1A");
		lblNewLabel.setBounds(10, 20, 77, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u622A\u6B62\u65E5\u671F");
		lblNewLabel_2.setBounds(10, 89, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(144, 86, 32, 21);
		contentPane.add(lblNewLabel_3);
		//年
		text1 = new JTextField();
		text1.setBounds(80, 86, 66, 21);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u8BE6\u7EC6\u63CF\u8FF0");
		lblNewLabel_6.setBounds(10, 181, 54, 15);
		contentPane.add(lblNewLabel_6);
		
		textArea = new JTextArea();
		JScrollPane jScrollPane=new JScrollPane(textArea);
		jScrollPane.setBounds(79, 214, 297, 254);
		contentPane.add(jScrollPane);
		//月
		text2 = new JTextField();
		text2.setBounds(186, 86, 66, 21);
		contentPane.add(text2);
		text2.setColumns(10);
		
		JLabel label = new JLabel("\u6708");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(250, 86, 25, 21);
		contentPane.add(label);
		//日
		text3 = new JTextField();
		text3.setBounds(295, 86, 66, 21);
		contentPane.add(text3);
		text3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u65E5");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(360, 86, 25, 21);
		contentPane.add(lblNewLabel_7);
		//保存数据
		JButton saveBtn = new JButton("\u4FDD\u5B58");
		saveBtn.setForeground(Color.RED);
		saveBtn.setBackground(Color.LIGHT_GRAY);
		saveBtn.setBounds(343, 491, 93, 45);
		saveBtn.addActionListener(this);
		contentPane.add(saveBtn);
		//任务名称
		nameText = new JTextField();
		nameText.setBounds(78, 17, 298, 21);
		contentPane.add(nameText);
		nameText.setColumns(10);
		//
		setTitle("临时任务");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 583);
	}
	
	//事件处理
	   public void actionPerformed(ActionEvent e) 
	   {
		   String opString=(String)e.getActionCommand();
		   switch (opString)
		 {
		    case "保存":
		    {
		    	if(nameText.getText().length()>0&&text1.getText()!=null&text2!=null&&text3!=null)
		    	{
		    		int year=Integer.parseInt(text1.getText());
		    		int month=Integer.parseInt(text2.getText());
		    		int day=Integer.parseInt(text3.getText());
		    		String taskDescibe=this.textArea.getText();
		    		this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).setTime1(year, month, day);
		    		this.taskSystem.taskListLits.get(whichList).taskList.get(whichList).setTaskDescription(taskDescibe);
		    		System.out.println("任务真的创建了,名字也改变了");
		    	}
		    	if(nameText.getText().length()==0&&text1.getText()!=null&text2!=null&&text3!=null)
		    	{
		    		int year=Integer.parseInt(text1.getText());
		    		int month=Integer.parseInt(text2.getText());
		    		int day=Integer.parseInt(text3.getText());
		    		String taskDescibe=this.textArea.getText();
		    		this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).setTime1(year, month, day);
		    		this.taskSystem.taskListLits.get(whichList).taskList.get(whichList).setTaskDescription(taskDescibe);
		    		System.out.println("任务真的创建了，名字没改变");		    				    	
		    	}
		    	
		    	this.taskSystem.saveData();
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
	   
	   public void initializeTaskEditView()
	   {
		   String taskName=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTaskName();
		   String taskDescribe=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTaskDescription();
		   int year=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTimeTask().getYear();
		   int month=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTimeTask().getMonth();
		   int day=this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask).getTimeTask().getDay();
		   this.nameText.setText(taskName);
		   this.text1.setText(String.valueOf(year));
		   this.text2.setText(String.valueOf(month));
		   this.text3.setText(String.valueOf(day));
		   this.textArea.setText(taskDescribe);		   
	   }
	
}
