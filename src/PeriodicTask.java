import java.io.Serializable;

public class PeriodicTask extends Task  implements Serializable
{
  private int ciShu;
  private int zhouqiYear;   //���ڻ���ѡ�������ܵ�!!!!
  private int zhouqiMonth;
  private int zhouqiDay;
  
  public  PeriodicTask(String taskName)
  {
	  super(taskName);
  }
  public void setCiShu(int cishu) 
  {
	this.ciShu=cishu;
  }
  public int getCiShu() 
  {
	return this.ciShu;
}
  public int getzhouqiYear() 
  {
	return this.zhouqiYear;
}
  public int getzhouqiMonth() 
  {
	return this.zhouqiMonth;
}
  public int getzhouqiDay() 
  {
	return this.zhouqiDay;
}
  public void setZhouQi(int year,int month,int day,int cishu) 
  {
	this.zhouqiYear=year;
	this.zhouqiMonth=month;
	this.zhouqiDay=day;
	this.ciShu=cishu;
  }
  
}
/*
����
���ԣ����ơ���ϸ�������Ƿ����״̬
���ࣺ
2.��������:
�������ԣ�ִ�����ڡ��ظ��������ظ����� ���ܡ��¡�������Զ���������
   ������
A.������޸�
B.�������嵥��ת�ơ�����
C.����Ĳ���
D.����
*/