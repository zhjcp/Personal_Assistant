import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class TaskEditView extends JFrame implements ActionListener{

	private JTextField text1;
	private JTextField text2;
	
	private int whichList;//任务所属清单的索引
    private TempTaskView tempTaskView;
    private PeriodicTaskView periodicTaskView;
    private LongtermTaskView longtermTaskView;
	private TaskSystem taskSystem2=new TaskSystem();
	private JPanel contentPane;
	private JTextField textField;
	JLabel label1;
	JComboBox comboBox;
	JComboBox comboBox_1;
	JComboBox comboBox_2;
	private String[] taskSort= {"临时任务","周期任务","长期任务"};

	public TaskEditView(TaskSystem taskSystem) {
		
		taskSystem2=taskSystem;//同一个TaskSystem
        tempTaskView=new TempTaskView(taskSystem);//同一个TaskSystem
        periodicTaskView=new PeriodicTaskView(taskSystem);//同一个TaskSystem
        longtermTaskView=new LongtermTaskView(taskSystem);//同一个TaskSystem
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//保存
		JButton saveBtn = new JButton("保存列表");
		saveBtn.setBackground(Color.MAGENTA);
		saveBtn.setForeground(Color.ORANGE);
		saveBtn.setBounds(10, 10, 93, 23);
		saveBtn.addActionListener(this);
		contentPane.add(saveBtn);		
		//删除任务
		JButton deleteBtn = new JButton("删除任务");
		deleteBtn.setBackground(Color.MAGENTA);
		deleteBtn.setForeground(Color.ORANGE);
		deleteBtn.setBounds(114, 10, 93, 23);
		deleteBtn.addActionListener(this);
		contentPane.add(deleteBtn);		
		//清空任务
		JButton deleteAllBtn = new JButton("清空任务");
		deleteAllBtn.setBackground(Color.MAGENTA);
		deleteAllBtn.setForeground(Color.ORANGE);
		deleteAllBtn.setBounds(217, 10, 93, 23);
		deleteAllBtn.addActionListener(this);
		contentPane.add(deleteAllBtn);
		//添加任务
		JButton addTaskBtn = new JButton("添加任务");
		addTaskBtn.setBackground(Color.MAGENTA);
		addTaskBtn.setForeground(Color.RED);
		addTaskBtn.setFont(new Font("宋体", Font.BOLD, 12));
		addTaskBtn.setBounds(10, 70, 93, 23);
		contentPane.add(addTaskBtn);
		addTaskBtn.addActionListener(this);
		//编辑任务
		JButton editTaskBtn = new JButton("编辑任务");
		editTaskBtn.setBackground(Color.MAGENTA);
		editTaskBtn.setForeground(Color.RED);
		editTaskBtn.setFont(new Font("宋体", Font.BOLD, 12));
		editTaskBtn.setBounds(113, 70, 93, 23);
		contentPane.add(editTaskBtn);
		editTaskBtn.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("\u4EFB\u52A1\u7C7B\u578B");
		lblNewLabel.setBounds(10, 101, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u4EFB\u52A1\u540D\u79F0");
		lblNewLabel_1.setBounds(10, 146, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		text1 = new JTextField();
		text1.setBounds(103, 143, 320, 21);
		contentPane.add(text1);
		text1.setColumns(10);
		//任务类型下拉框
		comboBox = new JComboBox(taskSort);
		comboBox.setBounds(103, 97, 170, 23);
		contentPane.add(comboBox);
		//任务列表下拉框
	    comboBox_1 = new JComboBox();
		comboBox_1.setBounds(103, 205, 320, 23);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4EFB\u52A1\u5217\u8868");
		lblNewLabel_2.setBounds(10, 209, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		text2 = new JTextField();
		text2.setBounds(103, 287, 320, 21);
		contentPane.add(text2);
		text2.setColumns(10);
		//查找任务
		JButton findBtn = new JButton("查询任务");
		findBtn.setForeground(Color.ORANGE);
		findBtn.setBackground(Color.MAGENTA);
		findBtn.addActionListener(this);
		findBtn.setBounds(10, 286, 93, 23);
		contentPane.add(findBtn);
		
		//功能按钮
		JButton paixuBtn1=new JButton("字典排序");
		paixuBtn1.setForeground(Color.ORANGE);
		paixuBtn1.setBackground(Color.MAGENTA);
		paixuBtn1.addActionListener(this);
		paixuBtn1.setBounds(10, 350, 93, 23);
		contentPane.add(paixuBtn1);
		
		JButton paixuBtn2=new JButton("进度排序");
		paixuBtn2.setForeground(Color.ORANGE);
		paixuBtn2.setBackground(Color.MAGENTA);
		paixuBtn2.addActionListener(this);
		paixuBtn2.setBounds(120, 350, 93, 23);
		contentPane.add(paixuBtn2);
		
		JButton paixuBtn3=new JButton("时间排序");
		paixuBtn3.setForeground(Color.ORANGE);
		paixuBtn3.setBackground(Color.MAGENTA);
		paixuBtn3.addActionListener(this);
		paixuBtn3.setBounds(230, 350, 93, 23);
		contentPane.add(paixuBtn3);
		
		JButton addTaskToList=new JButton("更新清单列表");
		addTaskToList.setForeground(Color.ORANGE);
		addTaskToList.setBackground(Color.MAGENTA);
		addTaskToList.addActionListener(this);
		addTaskToList.setBounds(10, 400, 120, 30);
		contentPane.add(addTaskToList);
		
		JButton updataList=new JButton("添加任务到列表");
		updataList.setForeground(Color.ORANGE);
		updataList.setBackground(Color.MAGENTA);
		updataList.addActionListener(this);
		updataList.setBounds(140, 400, 120, 30);
		contentPane.add(updataList);
		
		JButton copyTaskBtn=new JButton("复制任务到列表");
		copyTaskBtn.setForeground(Color.ORANGE);
		copyTaskBtn.setBackground(Color.MAGENTA);
		copyTaskBtn.addActionListener(this);
		copyTaskBtn.setBounds(270, 400, 120, 30);
		contentPane.add(copyTaskBtn);
		
		comboBox_2=new JComboBox();
		comboBox_2.setBounds(103, 430,320, 20);
		contentPane.add(comboBox_2);
		
		JLabel jlabel=new JLabel("清单列表");
		jlabel.setBounds(30, 425, 93, 30);
		contentPane.add(jlabel);
		
		//基础设置
		setBounds(100, 100, 450, 584);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	//事件处理
	   public void actionPerformed(ActionEvent e) 
	   {
		   String opString=(String)e.getActionCommand();
		   
		   switch (opString) {
		   
		   case "保存列表":
		   {
			   this.taskSystem2.saveData();
			   break;
		   }
		   
		   case "删除任务":
		   {
			   String taskName=(String) this.comboBox_1.getSelectedItem();	
			   int taskListSize=this.taskSystem2.taskListLits.get(whichList).taskList.size();//任务列表大小
			   //System.out.println("1bbbbbbb"+taskListSize);
			   for(int i=0;i<taskListSize;i++)
			   {	
				   if(this.taskSystem2.taskListLits.get(whichList).taskList.get(i).getTaskName().equals(taskName))
					   {
					       this.taskSystem2.taskListLits.get(whichList).taskList.remove(i);//在对象删除任务
						   this.comboBox_1.removeItem(this.comboBox_1.getSelectedItem());//在下拉框删除所选任务
						   this.taskSystem2.saveData();	
						   break;
					   }
			   }
			   break;
	
		   }
		   
		   case "清空任务":
		   {
			   this.taskSystem2.taskListLits.get(whichList).taskList.clear();//在对象清空任务
			   this.comboBox_1.removeAllItems();
			   this.taskSystem2.saveData();
			   break;
		   }
		   
		case "添加任务":
		{
			if(this.comboBox.getSelectedItem().equals("临时任务"))
			{
				if(this.text1.getText().length()>0)  //在任务名称不为空的情况下创建任务
				{
				    TemporaryTask newTemporaryTask=new TemporaryTask(this.text1.getText());	
				    newTemporaryTask.setTaskType(1);//记录任务类型
					this.taskSystem2.getTaskListsList().get(whichList).addTask(newTemporaryTask);
					updataTaskBox();
					//test
					//System.out.println("正在操作的清单索引"+whichList);
					//System.out.println("新建的任务名称"+newTemporaryTask.getTaskName());
				    //System.out.println("列表长度"+this.taskSystem2.getTaskListsList().size());
				    //System.out.println("列表任务长度"+this.taskSystem2.getTaskListsList().get(whichList).getTaskList().size());
				    
					this.taskSystem2.saveData();					
					
				}			
			}
			else if(this.comboBox.getSelectedItem().equals("周期任务"))
			{
				if(this.text1.getText().length()>0)  //在任务名称不为空的情况下创建任务
				{
					
					PeriodicTask newPeriodicTask=new PeriodicTask(this.text1.getText());
					newPeriodicTask.setTaskType(2);
					this.taskSystem2.getTaskListsList().get(whichList).addTask(newPeriodicTask);
					updataTaskBox();
					this.taskSystem2.saveData();
				}				
			}
			else if (this.comboBox.getSelectedItem().equals("长期任务"))
			{
				if(this.text1.getText().length()>0)  //在任务名称不为空的情况下创建任务
				{
					LongTermTask newLongTermTask=new LongTermTask(this.text1.getText());
					newLongTermTask.setTaskType(3);
					this.taskSystem2.getTaskListsList().get(whichList).addTask(newLongTermTask);
					updataTaskBox();
					this.taskSystem2.saveData();
				}
			}
			
			break ;
		}
		
		case "编辑任务":
		  {
			  int placeIndex=this.comboBox_1.getSelectedIndex();
			  editTask(placeIndex);
			  break;
		  }
			
		case "更新清单列表":
		    {			     
		    	updataListBox(); 
		    	break;
		    }
		    
		case "字典排序":
		   {
			   this.taskSystem2.taskListLits.get(whichList).paiXuByName();
			   updataTaskBox();
			   break;
		    }
		   
		case "进度排序":
		   {
			   this.taskSystem2.taskListLits.get(whichList).paiXuByCompleted();
			   updataTaskBox();
			   break;
		   }
		   
		case "时间排序":
		   {
			   this.taskSystem2.taskListLits.get(whichList).paiXuByTime();
			   updataTaskBox();
			   break;
		   }
		   
		case "查询任务":
		{			
			if(this.text2.getText().length()>0)
			{
				int size=this.taskSystem2.taskListLits.get(whichList).taskList.size();
				for(int i=0;i<size;i++)
				{
					if(this.comboBox_1.getItemAt(i).equals(this.text2.getText()))//在任务下拉框检测同名任务
					   {
						  editTask(i);
					   }
				}
			}
			break;
		}
		 
		case "添加任务到列表":
		{
			addTaskToList();
			break;
		}
		
		case "复制任务到列表":
		{
			copyTaskToList();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + opString);
		}
	   }
	   
	 //列表索引
	   public void setWhichList(int index) 
	   {
		   this.whichList=index;
	   }
	   
	   public int getWhichList() 
	   {
		  return this.whichList;
	   }
	   
	   //更新任务列表下拉框
	   public void updataTaskBox()
	   {
		   if(this.comboBox_1!=null)
		      this.comboBox_1.removeAllItems();		   
		   for(int i=0;i<this.taskSystem2.getTaskListsList().get(whichList).taskList.size();i++)
		  {
		       this.comboBox_1.addItem(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(i).getTaskName());
		  }
	   }
	   
	   //更新清单列表下拉框
	   public void updataListBox() 
	   {
		   if(this.comboBox_2!=null)
		      this.comboBox_2.removeAllItems(); 
		   for(int i=0;i<this.taskSystem2.getTaskListsList().size();i++)
		   {			   
			   this.comboBox_2.addItem(this.taskSystem2.getTaskListsList().get(i).getListName());
		   }
	   }
	   
	   //用当前清单的数据初始化任务操作界面
	   public void initializeTaskView() 
	   {
             updataTaskBox();
             updataListBox();
	   }
	   
	   
	   //编辑任务
	   public void editTask(int placeIndex)
	   {
		   
			  //if(this.comboBox.getSelectedIndex()==0)//临时任务  error 应该用任务列表选中的任务类型判断
			  if(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(placeIndex).getTaskType()==1)
			  {
				    //this.tempTaskView.setWhichList(this.whichList);//同步清单索引
				  this.tempTaskView.setWhichTask(this.comboBox_1.getSelectedIndex());//同步任务索引				  
			      this.tempTaskView.setWhichList(this.whichList);//任务操作菜单和任务创建页面对应同一个索引
			      this.tempTaskView.setVisible(true);
			      this.tempTaskView.initializeTaskEditView();
			  }
			  //if(this.comboBox.getSelectedIndex()==1)//周期任务  error 应该用任务列表选中的任务类型判断
			  if(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(placeIndex).getTaskType()==2)
			  {
				    //this.periodicTaskView.setWhichList(this.whichList);//同步清单索引
				  this.periodicTaskView.setWhichTask(this.comboBox_1.getSelectedIndex());//同步任务索引				  
			      this.periodicTaskView.setWhichList(this.whichList);//任务操作菜单和任务创建页面对应同一个索引
			      this.periodicTaskView.setPeriodicTask();
			      this.periodicTaskView.setVisible(true);
			       //this.tempTaskView.initializeTaskEditView();
			  }
			  if(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(placeIndex).getTaskType()==3)
			  {
				  this.longtermTaskView.setWhichTask(this.comboBox_1.getSelectedIndex());//同步任务索引
				  this.longtermTaskView.setWhichList(this.whichList);//任务操作菜单和任务创建页面对应同一个索引
				  this.longtermTaskView.setLongTermTask();
				  this.longtermTaskView.setVisible(true);
			  }
	}
	   
	 public void addTaskToList() //将任务查询框的当前任务转移到所选列表
	 {
		int placeInList=this.comboBox_1.getSelectedIndex();
		int indexList=this.comboBox_2.getSelectedIndex();
		Task itemTask=this.taskSystem2.taskListLits.get(whichList).taskList.get(placeInList);
		this.taskSystem2.taskListLits.get(indexList).addTask(itemTask);//加入新列表
		this.taskSystem2.taskListLits.get(whichList).taskList.remove(placeInList);//在列表中删除
		this.comboBox_1.removeItemAt(placeInList); 
	}  
	 
	 public void copyTaskToList() //将任务查询框的当前任务复制到所选列表
	 {
		int placeInList=this.comboBox_1.getSelectedIndex();
		int indexList=this.comboBox_2.getSelectedIndex();
		Task itemTask=this.taskSystem2.taskListLits.get(whichList).taskList.get(placeInList);
		this.taskSystem2.taskListLits.get(indexList).addTask(itemTask);//加入新列表
	}
}
