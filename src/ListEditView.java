

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
			//���水ť
			JButton saveBtn=new JButton("<SAVE>");
			saveBtn.setBounds(0, 0, 10, 5);
			saveBtn.addActionListener(this);
			//����嵥�˵�
			JPanel panel1=new JPanel();
			panel1.setBounds(0, 6, 400, 5);
			JButton addListBtn=new JButton("����嵥");
			addListBtn.setSize(10,5);
		    textField1=new JTextField("���������嵥���� ");
			textField1.setSize(60,5);
			addListBtn.addActionListener(this);
			panel1.add(addListBtn);
			panel1.add(textField1);
			//�嵥�б�����˵�
			JPanel panel2=new JPanel(new FlowLayout());
			panel1.setBounds(0, 12, 400, 5);
			JButton paiXuBtn1=new JButton("�ֵ�����");
			JButton paiXuBtn2=new JButton("��������");
			JButton deleteListBtn=new JButton("ɾ���嵥");
			JButton deleteAllListBtn=new JButton("����嵥");
			JButton editListBtn=new JButton("�༭�嵥");
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
			//���������
			JPanel panel3=new JPanel(new GridLayout(1,2));	
		    listBox=new JComboBox();	//����������
			listBox.setSize(20, 5);
	//������������
			container1.add(saveBtn);
			container1.add(panel1);
			container1.add(panel2);
			container1.add(listBox);
		
			
	//��������
			this.initializeListView();
			setTitle("��������");
			setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	   }
	   
	 //�¼�����
	   public void actionPerformed(ActionEvent e) 
	   {
		   String opString=(String) e.getActionCommand();
		   switch(opString)
		   {
		      case "<SAVE>":
		          {
		    	     this.taskSystem.saveData();
		    	     System.out.println("�����б�Ĵ�С"+this.taskSystem.taskListLits.size());
		    	     break;
		          }		      
		      case "����嵥":
		       {
		    	   if(textField1.getText()!=null&&!textField1.getText().equals("���������嵥���� "))
		    	  {
			    	  this.taskSystem.addLIst(textField1.getText());
			    	  listBox.addItem(textField1.getText());
			    	  this.taskSystem.saveData();
			    	  //System.out.println("�б���"+this.taskSystem.getTaskListsList().size());//test ok
			      }
			      break;
		       }
	          case "�ֵ�����":
		       {
			      this.taskSystem.paiXuByName();			      
			      this.initializeLIstBox();
			      this.taskSystem.saveData();  //���浽����
			      break;
			      //
		       }
		       
		       case "��������":
		       {
			      this.taskSystem.paiXuByAmount();
			      this.initializeLIstBox();
			      this.taskSystem.saveData();   //���浽����
			      break;
			      //
		       }
		       case "ɾ���嵥":
		       {
		    	   if(!(this.listBox.getSelectedIndex()==0))
		    	   {
		    	     System.out.println("������ɾ����ѡ�嵥");//test
		    	     int selectedPlace=this.listBox.getSelectedIndex()-1;
		    	     this.taskSystem.taskListLits.remove(selectedPlace);
		    	     this.listBox.removeItem(this.listBox.getSelectedItem());
		    	     this.taskSystem.saveData();  //���浽����
		    	     break;
		    	   }
		       }
		       case "����嵥":
		       {
		    	   this.taskSystem.getTaskListsList().clear();;		    	   
		    	   listBox.removeAllItems();
		    	   //listBox.addItem(listName);
		    	   this.taskSystem.saveData();   //���浽����
		    	   break;
		    	   //
		       }
		       case  "�༭�嵥":
		       {
		    	   if(!(this.listBox.getSelectedItem()==null))
		    	   {
		    		   //System.out.println("test");
		    		  int listIndex=this.listBox.getSelectedIndex();//ѡ���嵥���嵥�б��е�����		    		  
		    	      this.taskEditView.setWhichList(listIndex);
		    	      this.taskEditView.setVisible(true);
		    	      this.taskEditView.initializeTaskView();
		    	   }
		    	   this.taskSystem.saveData();   //���浽����
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
			   //System.out.println("����"+this.taskSystem.getTaskListsList().get(i).getListName());
			   listBox.addItem(this.taskSystem.getTaskListsList().get(i).getListName());
		 }
	   }
	   
	   //�ñ��ص����ݳ�ʼ���嵥��������
	   public void initializeListView() 
	   {		   
		   //test
		   int size=this.taskSystem.taskListLits.size();
		   System.out.println("�б��С"+size);
		   for(int i=0;i<size;i++)
		   System.out.println("�б���"+this.taskSystem.taskListLits.get(i).getListName());
	       initializeLIstBox();
	   }
	   
	 
}
