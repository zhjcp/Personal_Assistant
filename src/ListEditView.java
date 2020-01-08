

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;








public class ListEditView extends JFrame implements ActionListener
{
	   TaskSystem taskSystem=(new TaskSystem()).outData();
	   TaskEditView taskEditView=new TaskEditView(this.taskSystem);
       JTextField textField1;
       JComboBox listBox;
      Container container1;
	   public  ListEditView() 
	   {					    
		    this.setBounds(0,0,400,600);
		    container1=this.getContentPane();
			container1.setLayout(new GridLayout(4,1));
			//保存按钮
			JButton saveBtn=new JButton("<SAVE>");
			saveBtn.setBounds(0, 0, 10, 5);
			saveBtn.addActionListener(this);
			//添加清单菜单
			JPanel panel1=new JPanel();
			panel1.setBounds(0, 6, 400, 5);
			JButton addListBtn=new JButton("添加清单");
			addListBtn.setSize(10,5);
		    textField1=new JTextField("请先输入清单名称 ");
			textField1.setSize(60,5);
			addListBtn.addActionListener(this);
			panel1.add(addListBtn);
			panel1.add(textField1);
			//清单列表操作菜单
			JPanel panel2=new JPanel(new FlowLayout());
			panel1.setBounds(0, 12, 400, 5);
			JButton paiXuBtn1=new JButton("字典排序");
			JButton paiXuBtn2=new JButton("数量排序");
			JButton deleteListBtn=new JButton("删除清单");
			JButton deleteAllListBtn=new JButton("清空清单");
			JButton editListBtn=new JButton("编辑清单");
			paiXuBtn1.addActionListener(this);
			paiXuBtn2.addActionListener(this);
			deleteListBtn.addActionListener(this);
			deleteAllListBtn.addActionListener(this);
			editListBtn.addActionListener(this);
			panel2.add(paiXuBtn1);
			panel2.add(paiXuBtn2);
			panel2.add(deleteListBtn);
			panel2.add(deleteAllListBtn);
			panel2.add(editListBtn);
			//添加下拉框
			JPanel panel3=new JPanel(new GridLayout(1,2));	
		    listBox=new JComboBox();	//定义下拉框
			listBox.setSize(20, 5);
	//添加组件到容器
			container1.add(saveBtn);
			container1.add(panel1);
			container1.add(panel2);
			container1.add(listBox);
		
			
	//基本设置
			this.initializeListView();
			setTitle("个人助理");
			setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	   }
	   
	 //事件处理
	   public void actionPerformed(ActionEvent e) 
	   {
		   String opString=(String) e.getActionCommand();
		   switch(opString)
		   {
		      case "<SAVE>":
		          {
		    	     this.taskSystem.saveData();
		    	     System.out.println("存入列表的大小"+this.taskSystem.taskListLits.size());
		    	     break;
		          }		      
		      case "添加清单":
		       {
		    	   if(textField1.getText()!=null&&!textField1.getText().equals("请先输入清单名称 "))
		    	  {
			    	  this.taskSystem.addLIst(textField1.getText());
			    	  listBox.addItem(textField1.getText());
			    	  this.taskSystem.saveData();
			    	  //System.out.println("列表长度"+this.taskSystem.getTaskListsList().size());//test ok
			      }
			      break;
		       }
	          case "字典排序":
		       {
			      this.taskSystem.paiXuByName();			      
			      this.initializeLIstBox();
			      this.taskSystem.saveData();  //保存到本地
			      break;
			      //
		       }
		       
		       case "数量排序":
		       {
			      this.taskSystem.paiXuByAmount();
			      this.initializeLIstBox();
			      this.taskSystem.saveData();   //保存到本地
			      break;
			      //
		       }
		       case "删除清单":
		       {
		    	   if(!(this.listBox.getSelectedIndex()==0))
		    	   {
		    	     System.out.println("接下来删除所选清单");//test
		    	     int selectedPlace=this.listBox.getSelectedIndex()-1;
		    	     this.taskSystem.taskListLits.remove(selectedPlace);
		    	     this.listBox.removeItem(this.listBox.getSelectedItem());
		    	     this.taskSystem.saveData();  //保存到本地
		    	     break;
		    	   }
		       }
		       case "清空清单":
		       {
		    	   this.taskSystem.getTaskListsList().clear();;		    	   
		    	   listBox.removeAllItems();
		    	   //listBox.addItem(listName);
		    	   this.taskSystem.saveData();   //保存到本地
		    	   break;
		    	   //
		       }
		       case  "编辑清单":
		       {
		    	   if(!(this.listBox.getSelectedItem()==null))
		    	   {
		    		   //System.out.println("test");
		    		  int listIndex=this.listBox.getSelectedIndex();//选中清单在清单列表中的索引		    		  
		    	      this.taskEditView.setWhichList(listIndex);
		    	      this.taskEditView.setVisible(true);
		    	      this.taskEditView.initializeTaskView();
		    	   }
		    	   this.taskSystem.saveData();   //保存到本地
		    	   break;
		       }
		       default:
		    	   break;
		   }
		
	}
	   public void initializeLIstBox() 
	   {
		   if(this.listBox!=null)			   
		      this.listBox.removeAllItems();
		   for(int i=0;i<this.taskSystem.getTaskListsList().size();i++)
		 {
			   //System.out.println("名字"+this.taskSystem.getTaskListsList().get(i).getListName());
			   listBox.addItem(this.taskSystem.getTaskListsList().get(i).getListName());
		 }
	   }
	   
	   //用本地的数据初始化清单操作界面
	   public void initializeListView() 
	   {		   
		   //test
		   int size=this.taskSystem.taskListLits.size();
		   System.out.println("列表大小"+size);
		   for(int i=0;i<size;i++)
		   System.out.println("列表名"+this.taskSystem.taskListLits.get(i).getListName());
	       initializeLIstBox();
	   }
	   
	 
}
