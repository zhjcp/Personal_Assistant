import java.io.Serializable;

public class PeriodicTask extends Task  implements Serializable
{
  private int ciShu;
  private int zhouqiYear;   //周期还有选择年月周的!!!!
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
任务：
属性：名称、详细描述、是否被完成状态
分类：
2.周期任务:
额外属性：执行日期、重复次数、重复周期 （周、月、年或者自定义天数）
   方法：
A.任务的修改
B.任务在清单间转移、复制
C.任务的查找
D.排序
*/