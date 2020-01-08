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
	
	private int whichList;//���������嵥������
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
	private String[] taskSort= {"��ʱ����","��������","��������"};

	public TaskEditView(TaskSystem taskSystem) {
		
		taskSystem2=taskSystem;//ͬһ��TaskSystem
        tempTaskView=new TempTaskView(taskSystem);//ͬһ��TaskSystem
        periodicTaskView=new PeriodicTaskView(taskSystem);//ͬһ��TaskSystem
        longtermTaskView=new LongtermTaskView(taskSystem);//ͬһ��TaskSystem
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//����
		JButton saveBtn = new JButton("�����б�");
		saveBtn.setBackground(Color.MAGENTA);
		saveBtn.setForeground(Color.ORANGE);
		saveBtn.setBounds(10, 10, 93, 23);
		saveBtn.addActionListener(this);
		contentPane.add(saveBtn);		
		//ɾ������
		JButton deleteBtn = new JButton("ɾ������");
		deleteBtn.setBackground(Color.MAGENTA);
		deleteBtn.setForeground(Color.ORANGE);
		deleteBtn.setBounds(114, 10, 93, 23);
		deleteBtn.addActionListener(this);
		contentPane.add(deleteBtn);		
		//�������
		JButton deleteAllBtn = new JButton("�������");
		deleteAllBtn.setBackground(Color.MAGENTA);
		deleteAllBtn.setForeground(Color.ORANGE);
		deleteAllBtn.setBounds(217, 10, 93, 23);
		deleteAllBtn.addActionListener(this);
		contentPane.add(deleteAllBtn);
		//�������
		JButton addTaskBtn = new JButton("�������");
		addTaskBtn.setBackground(Color.MAGENTA);
		addTaskBtn.setForeground(Color.RED);
		addTaskBtn.setFont(new Font("����", Font.BOLD, 12));
		addTaskBtn.setBounds(10, 70, 93, 23);
		contentPane.add(addTaskBtn);
		addTaskBtn.addActionListener(this);
		//�༭����
		JButton editTaskBtn = new JButton("�༭����");
		editTaskBtn.setBackground(Color.MAGENTA);
		editTaskBtn.setForeground(Color.RED);
		editTaskBtn.setFont(new Font("����", Font.BOLD, 12));
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
		//��������������
		comboBox = new JComboBox(taskSort);
		comboBox.setBounds(103, 97, 170, 23);
		contentPane.add(comboBox);
		//�����б�������
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
		//��������
		JButton findBtn = new JButton("��ѯ����");
		findBtn.setForeground(Color.ORANGE);
		findBtn.setBackground(Color.MAGENTA);
		findBtn.addActionListener(this);
		findBtn.setBounds(10, 286, 93, 23);
		contentPane.add(findBtn);
		
		//���ܰ�ť
		JButton paixuBtn1=new JButton("�ֵ�����");
		paixuBtn1.setForeground(Color.ORANGE);
		paixuBtn1.setBackground(Color.MAGENTA);
		paixuBtn1.addActionListener(this);
		paixuBtn1.setBounds(10, 350, 93, 23);
		contentPane.add(paixuBtn1);
		
		JButton paixuBtn2=new JButton("��������");
		paixuBtn2.setForeground(Color.ORANGE);
		paixuBtn2.setBackground(Color.MAGENTA);
		paixuBtn2.addActionListener(this);
		paixuBtn2.setBounds(120, 350, 93, 23);
		contentPane.add(paixuBtn2);
		
		JButton paixuBtn3=new JButton("ʱ������");
		paixuBtn3.setForeground(Color.ORANGE);
		paixuBtn3.setBackground(Color.MAGENTA);
		paixuBtn3.addActionListener(this);
		paixuBtn3.setBounds(230, 350, 93, 23);
		contentPane.add(paixuBtn3);
		
		JButton addTaskToList=new JButton("�����嵥�б�");
		addTaskToList.setForeground(Color.ORANGE);
		addTaskToList.setBackground(Color.MAGENTA);
		addTaskToList.addActionListener(this);
		addTaskToList.setBounds(10, 400, 120, 30);
		contentPane.add(addTaskToList);
		
		JButton updataList=new JButton("��������б�");
		updataList.setForeground(Color.ORANGE);
		updataList.setBackground(Color.MAGENTA);
		updataList.addActionListener(this);
		updataList.setBounds(140, 400, 120, 30);
		contentPane.add(updataList);
		
		JButton copyTaskBtn=new JButton("���������б�");
		copyTaskBtn.setForeground(Color.ORANGE);
		copyTaskBtn.setBackground(Color.MAGENTA);
		copyTaskBtn.addActionListener(this);
		copyTaskBtn.setBounds(270, 400, 120, 30);
		contentPane.add(copyTaskBtn);
		
		comboBox_2=new JComboBox();
		comboBox_2.setBounds(103, 430,320, 20);
		contentPane.add(comboBox_2);
		
		JLabel jlabel=new JLabel("�嵥�б�");
		jlabel.setBounds(30, 425, 93, 30);
		contentPane.add(jlabel);
		
		//��������
		setBounds(100, 100, 450, 584);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	//�¼�����
	   public void actionPerformed(ActionEvent e) 
	   {
		   String opString=(String)e.getActionCommand();
		   
		   switch (opString) {
		   
		   case "�����б�":
		   {
			   this.taskSystem2.saveData();
			   break;
		   }
		   
		   case "ɾ������":
		   {
			   String taskName=(String) this.comboBox_1.getSelectedItem();	
			   int taskListSize=this.taskSystem2.taskListLits.get(whichList).taskList.size();//�����б��С
			   //System.out.println("1bbbbbbb"+taskListSize);
			   for(int i=0;i<taskListSize;i++)
			   {	
				   if(this.taskSystem2.taskListLits.get(whichList).taskList.get(i).getTaskName().equals(taskName))
					   {
					       this.taskSystem2.taskListLits.get(whichList).taskList.remove(i);//�ڶ���ɾ������
						   this.comboBox_1.removeItem(this.comboBox_1.getSelectedItem());//��������ɾ����ѡ����
						   this.taskSystem2.saveData();	
						   break;
					   }
			   }
			   break;
	
		   }
		   
		   case "�������":
		   {
			   this.taskSystem2.taskListLits.get(whichList).taskList.clear();//�ڶ����������
			   this.comboBox_1.removeAllItems();
			   this.taskSystem2.saveData();
			   break;
		   }
		   
		case "�������":
		{
			if(this.comboBox.getSelectedItem().equals("��ʱ����"))
			{
				if(this.text1.getText().length()>0)  //���������Ʋ�Ϊ�յ�����´�������
				{
				    TemporaryTask newTemporaryTask=new TemporaryTask(this.text1.getText());	
				    newTemporaryTask.setTaskType(1);//��¼��������
					this.taskSystem2.getTaskListsList().get(whichList).addTask(newTemporaryTask);
					updataTaskBox();
					//test
					//System.out.println("���ڲ������嵥����"+whichList);
					//System.out.println("�½�����������"+newTemporaryTask.getTaskName());
				    //System.out.println("�б���"+this.taskSystem2.getTaskListsList().size());
				    //System.out.println("�б����񳤶�"+this.taskSystem2.getTaskListsList().get(whichList).getTaskList().size());
				    
					this.taskSystem2.saveData();					
					
				}			
			}
			else if(this.comboBox.getSelectedItem().equals("��������"))
			{
				if(this.text1.getText().length()>0)  //���������Ʋ�Ϊ�յ�����´�������
				{
					
					PeriodicTask newPeriodicTask=new PeriodicTask(this.text1.getText());
					newPeriodicTask.setTaskType(2);
					this.taskSystem2.getTaskListsList().get(whichList).addTask(newPeriodicTask);
					updataTaskBox();
					this.taskSystem2.saveData();
				}				
			}
			else if (this.comboBox.getSelectedItem().equals("��������"))
			{
				if(this.text1.getText().length()>0)  //���������Ʋ�Ϊ�յ�����´�������
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
		
		case "�༭����":
		  {
			  int placeIndex=this.comboBox_1.getSelectedIndex();
			  editTask(placeIndex);
			  break;
		  }
			
		case "�����嵥�б�":
		    {			     
		    	updataListBox(); 
		    	break;
		    }
		    
		case "�ֵ�����":
		   {
			   this.taskSystem2.taskListLits.get(whichList).paiXuByName();
			   updataTaskBox();
			   break;
		    }
		   
		case "��������":
		   {
			   this.taskSystem2.taskListLits.get(whichList).paiXuByCompleted();
			   updataTaskBox();
			   break;
		   }
		   
		case "ʱ������":
		   {
			   this.taskSystem2.taskListLits.get(whichList).paiXuByTime();
			   updataTaskBox();
			   break;
		   }
		   
		case "��ѯ����":
		{			
			if(this.text2.getText().length()>0)
			{
				int size=this.taskSystem2.taskListLits.get(whichList).taskList.size();
				for(int i=0;i<size;i++)
				{
					if(this.comboBox_1.getItemAt(i).equals(this.text2.getText()))//��������������ͬ������
					   {
						  editTask(i);
					   }
				}
			}
			break;
		}
		 
		case "��������б�":
		{
			addTaskToList();
			break;
		}
		
		case "���������б�":
		{
			copyTaskToList();
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + opString);
		}
	   }
	   
	 //�б�����
	   public void setWhichList(int index) 
	   {
		   this.whichList=index;
	   }
	   
	   public int getWhichList() 
	   {
		  return this.whichList;
	   }
	   
	   //���������б�������
	   public void updataTaskBox()
	   {
		   if(this.comboBox_1!=null)
		      this.comboBox_1.removeAllItems();		   
		   for(int i=0;i<this.taskSystem2.getTaskListsList().get(whichList).taskList.size();i++)
		  {
		       this.comboBox_1.addItem(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(i).getTaskName());
		  }
	   }
	   
	   //�����嵥�б�������
	   public void updataListBox() 
	   {
		   if(this.comboBox_2!=null)
		      this.comboBox_2.removeAllItems(); 
		   for(int i=0;i<this.taskSystem2.getTaskListsList().size();i++)
		   {			   
			   this.comboBox_2.addItem(this.taskSystem2.getTaskListsList().get(i).getListName());
		   }
	   }
	   
	   //�õ�ǰ�嵥�����ݳ�ʼ�������������
	   public void initializeTaskView() 
	   {
             updataTaskBox();
             updataListBox();
	   }
	   
	   
	   //�༭����
	   public void editTask(int placeIndex)
	   {
		   
			  //if(this.comboBox.getSelectedIndex()==0)//��ʱ����  error Ӧ���������б�ѡ�е����������ж�
			  if(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(placeIndex).getTaskType()==1)
			  {
				    //this.tempTaskView.setWhichList(this.whichList);//ͬ���嵥����
				  this.tempTaskView.setWhichTask(this.comboBox_1.getSelectedIndex());//ͬ����������				  
			      this.tempTaskView.setWhichList(this.whichList);//��������˵������񴴽�ҳ���Ӧͬһ������
			      this.tempTaskView.setVisible(true);
			      this.tempTaskView.initializeTaskEditView();
			  }
			  //if(this.comboBox.getSelectedIndex()==1)//��������  error Ӧ���������б�ѡ�е����������ж�
			  if(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(placeIndex).getTaskType()==2)
			  {
				    //this.periodicTaskView.setWhichList(this.whichList);//ͬ���嵥����
				  this.periodicTaskView.setWhichTask(this.comboBox_1.getSelectedIndex());//ͬ����������				  
			      this.periodicTaskView.setWhichList(this.whichList);//��������˵������񴴽�ҳ���Ӧͬһ������
			      this.periodicTaskView.setPeriodicTask();
			      this.periodicTaskView.setVisible(true);
			       //this.tempTaskView.initializeTaskEditView();
			  }
			  if(this.taskSystem2.getTaskListsList().get(whichList).taskList.get(placeIndex).getTaskType()==3)
			  {
				  this.longtermTaskView.setWhichTask(this.comboBox_1.getSelectedIndex());//ͬ����������
				  this.longtermTaskView.setWhichList(this.whichList);//��������˵������񴴽�ҳ���Ӧͬһ������
				  this.longtermTaskView.setLongTermTask();
				  this.longtermTaskView.setVisible(true);
			  }
	}
	   
	 public void addTaskToList() //�������ѯ��ĵ�ǰ����ת�Ƶ���ѡ�б�
	 {
		int placeInList=this.comboBox_1.getSelectedIndex();
		int indexList=this.comboBox_2.getSelectedIndex();
		Task itemTask=this.taskSystem2.taskListLits.get(whichList).taskList.get(placeInList);
		this.taskSystem2.taskListLits.get(indexList).addTask(itemTask);//�������б�
		this.taskSystem2.taskListLits.get(whichList).taskList.remove(placeInList);//���б���ɾ��
		this.comboBox_1.removeItemAt(placeInList); 
	}  
	 
	 public void copyTaskToList() //�������ѯ��ĵ�ǰ�����Ƶ���ѡ�б�
	 {
		int placeInList=this.comboBox_1.getSelectedIndex();
		int indexList=this.comboBox_2.getSelectedIndex();
		Task itemTask=this.taskSystem2.taskListLits.get(whichList).taskList.get(placeInList);
		this.taskSystem2.taskListLits.get(indexList).addTask(itemTask);//�������б�
	}
}
