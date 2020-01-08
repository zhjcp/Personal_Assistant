import java.io.Serializable;

public class TemporaryTask extends Task  implements Serializable
{
   private  int dealtTime=0;//ʱ����
   
   public TemporaryTask (String taskName1,String taskDescription1,int dealttime)
   {
	super(taskName1, taskDescription1);
	setDeadTime(dealttime);
	this.getTimeTask().addDayOfYear(dealttime);//����ʱ����
   }
   
   //�����ִ�����ʱ����
   public  TemporaryTask(String taskName1) 
   {
	  super(taskName1);
   }
   
   public void setDeadTime(int deadtime) 
   {
	this.dealtTime=deadtime;
   }
   public int getDeadTime() 
   {
	return this.dealtTime;
   }
   
}
/*
����
���ԣ����ơ���ϸ�������Ƿ����״̬
���ࣺ
 ��ʱ����:
  �������ԣ���ֹ���ڣ���������Ҫ����ҵ��
   ������
A.������޸�
B.�������嵥��ת�ơ�����
C.����Ĳ���
D.����
 */