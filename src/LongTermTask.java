import java.io.Serializable;
import java.util.ArrayList;

public class LongTermTask extends Task  implements Serializable
{
    ArrayList<LongTermTask> taskList= new ArrayList<LongTermTask>();
    
    
	public  LongTermTask(String taskName1) 
    {
		super(taskName1);
	}
	
	public void addTask(LongTermTask longTermTask) 
	{
		taskList.add(longTermTask);
	}
}


/*
����
���ԣ����ơ���ϸ�������Ƿ����״̬
���ࣺ
3.��������:
�������ԣ���ֹ���ڡ��������б�����Ƕ��������
   ������
A.������޸�
B.�������嵥��ת�ơ�����
C.����Ĳ���
D.����
*/