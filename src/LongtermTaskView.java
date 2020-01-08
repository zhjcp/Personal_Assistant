import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class LongtermTaskView extends JFrame implements ActionListener
{
	
	private int whichList;//当前正在添加任务所属清单在清单列表的索引
	private int whichTask;//当前任务在当前清单里的索引
	private int indexInParent;//当前任务在父任务中的索引
	private boolean isSonView=false;//是不是子任务窗口
	LongTermTask longTermTask;
	private TaskSystem taskSystem;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	JTextArea textArea;
	JComboBox son_Combox;
	private JTextField sonNameText;
	
	
	public  LongtermTaskView(TaskSystem taskSystem_x) 
   {
		this.taskSystem=taskSystem_x;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("\u4EFB\u52A1\u540D\u79F0\uFF1A");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(10, 33, 66, 15);
		contentPane.add(label_1);
		//长期任务名称
		textName = new JTextField();
		textName.setBounds(74, 30, 303, 21);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel label_2 = new JLabel("\u622A\u6B62\u65F6\u95F4\uFF1A");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(10, 89, 66, 15);
		contentPane.add(label_2);
		//年
		text1 = new JTextField();
		text1.setBounds(74, 86, 66, 21);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel label_year = new JLabel("\u5E74");
		label_year.setHorizontalAlignment(SwingConstants.CENTER);
		label_year.setBounds(139, 86, 26, 21);
		contentPane.add(label_year);
		//月
		text2 = new JTextField();
		text2.setBounds(170, 86, 66, 21);
		contentPane.add(text2);
		text2.setColumns(10);
		
		JLabel label_month = new JLabel("\u6708");
		label_month.setHorizontalAlignment(SwingConstants.CENTER);
		label_month.setBounds(235, 87, 26, 18);
		contentPane.add(label_month);
		//日
		text3 = new JTextField();
		text3.setBounds(258, 86, 66, 21);
		contentPane.add(text3);
		text3.setColumns(10);
		
		JLabel label_day = new JLabel("\u65E5");
		label_day.setHorizontalAlignment(SwingConstants.CENTER);
		label_day.setBounds(334, 87, 26, 18);
		contentPane.add(label_day);
		
		JLabel label_4 = new JLabel("\u5B50\u4EFB\u52A1\u5217\u8868\uFF1A");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setBounds(10, 450, 93, 21);
		contentPane.add(label_4);
		//子任务下拉框
        son_Combox = new JComboBox();
		son_Combox.setBounds(94, 449, 283, 23);
		contentPane.add(son_Combox);
		//添加子任务
		JButton addSonTaskBtn = new JButton("\u6DFB\u52A0\u5B50\u4EFB\u52A1");
		addSonTaskBtn.addActionListener(this);
		addSonTaskBtn.setBackground(Color.YELLOW);
		addSonTaskBtn.setForeground(Color.BLACK);
		addSonTaskBtn.setBounds(10, 342, 130, 36);
		contentPane.add(addSonTaskBtn);
		
		JLabel label_5 = new JLabel("\u4EFB\u52A1\u63CF\u8FF0\uFF1A");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(21, 139, 82, 23);
		contentPane.add(label_5);
		JScrollPane jScrollPane=new JScrollPane();
		jScrollPane.setBounds(95, 139, 274, 193);
		contentPane.add(jScrollPane);
		//长期任务描述
		textArea = new JTextArea();
		jScrollPane.setViewportView(textArea);
		//保存
		JButton saveBtn = new JButton("保存");
		saveBtn.addActionListener(this);
		saveBtn.setBackground(Color.ORANGE);
		saveBtn.setBounds(284, 501, 103, 47);
		contentPane.add(saveBtn);
		//编辑选中的子任务
		JButton editSonTaskBtn = new JButton("编辑选中的子任务");
		editSonTaskBtn.addActionListener(this);
		editSonTaskBtn.setBackground(Color.YELLOW);
		editSonTaskBtn.setBounds(152, 343, 142, 35);
		contentPane.add(editSonTaskBtn);
		
		sonNameText = new JTextField();
		sonNameText.setBounds(94, 402, 283, 21);
		contentPane.add(sonNameText);
		sonNameText.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B50\u4EFB\u52A1\u540D\u79F0\uFF1A");
		label_3.setBounds(10, 405, 93, 15);
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(133, 342, 54, 36);
		contentPane.add(lblNewLabel);
		
		setTitle("长期任务");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 595);
}
   
 //事件处理
   public void actionPerformed(ActionEvent e) 
   {
	   String opString=(String) e.getActionCommand();
	   switch(opString)
	   {
	   case "添加子任务":
	   {
		   if(this.sonNameText.getText().length()>0)//在子任务字符串不为空的情况下添加
		   {
			   LongTermTask newlLongTermTask=new LongTermTask(this.sonNameText.getText());
			   newlLongTermTask.setTaskType(3);
			   this.longTermTask.addTask(newlLongTermTask);//子任务加入父任务
			   updataSon_Combox();
		   }
		   break;
	   }
	   case "编辑选中的子任务":
	   {
		   int taskPlace=this.son_Combox.getSelectedIndex();
		   //setIndexInParent(taskPlace);//记录子任务在父任务中的位置
		   creatSonEditView(this.longTermTask.taskList.get(taskPlace));
		   break;
	   }
	   case "保存":
	   {
		   int year=Integer.parseInt(this.text1.getText());
		   int month=Integer.parseInt(this.text2.getText());
		   int day=Integer.parseInt(this.text3.getText());
		   String taskDescribe=this.textArea.getText();
		   this.longTermTask.setTime1(year, month, day);
		   this.longTermTask.setTaskDescription(taskDescribe);
		   this.taskSystem.saveData();
		   break;
	   }
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
  public  void setIndexInParent(int index) 
  {
	   this.indexInParent=index;
  }
  public void setLongTermTask() 
  {
	       this.longTermTask=(LongTermTask)this.taskSystem.taskListLits.get(whichList).taskList.get(whichTask);//向下转型
	       initializeLongtermTaskView();
  }
  public void setLongTermTask_BySon(LongTermTask longTermTask3) //编辑儿子专用
  {
	      this.longTermTask=longTermTask3;
	      initializeLongtermTaskView();
  }
  public void setIsSonView()
  {
	this.isSonView=true;
}
  public boolean getIsSonview() 
  {
	return this.isSonView;
}
  
  
//初始化长期任务界面
  public void initializeLongtermTaskView() 
  {
	   this.textName.setText(this.longTermTask.getTaskName());
	   this.text1.setText(String.valueOf(this.longTermTask.getTimeTask().getDdlYear()));
	   this.text2.setText(String.valueOf(this.longTermTask.getTimeTask().getDdlMonth()));
	   this.text3.setText(String.valueOf(this.longTermTask.getTimeTask().getDdlDay()));
	   this.textArea.setText(this.longTermTask.getTaskDescription());
	   
	   if(this.longTermTask.taskList.size()>0)//在有子任务的情况下更新子任务下拉框
	      updataSon_Combox();
  }
 
  
//更新下拉框
  public void updataSon_Combox() 
  {
	  if(this.son_Combox!=null)
	      this.son_Combox.removeAllItems();
	   for(int i=0;i<this.longTermTask.taskList.size();i++)
	   {
		   this.son_Combox.addItem(this.longTermTask.taskList.get(i).getTaskName());
	   } 
  }
  
  //创建子任务编辑窗口
  public void creatSonEditView(LongTermTask longTermTask2) 
  {
	  LongtermTaskView newLongtermTaskView=new LongtermTaskView(taskSystem);//子任务编辑窗口
	  newLongtermTaskView.setTitle("子任务");
	  //newLongtermTaskView.setIndexInParent(indexInParent2);//子任务、父任务关联
	  newLongtermTaskView.setLongTermTask_BySon(longTermTask2);
	  newLongtermTaskView.setWhichList(this.whichList);//同一个清单
	  newLongtermTaskView.setWhichTask(this.whichTask);//同一个父任务
	  newLongtermTaskView.setVisible(true);
  }
}
