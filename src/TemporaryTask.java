import java.io.Serializable;

public class TemporaryTask extends Task  implements Serializable
{
   private  int dealtTime=0;//时间间隔
   
   public TemporaryTask (String taskName1,String taskDescription1,int dealttime)
   {
	super(taskName1, taskDescription1);
	setDeadTime(dealttime);
	this.getTimeTask().addDayOfYear(dealttime);//增加时间间隔
   }
   
   //用名字创建临时任务
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
任务：
属性：名称、详细描述、是否被完成状态
分类：
 临时任务:
  额外属性：截止日期（比如明天要交作业）
   方法：
A.任务的修改
B.任务在清单间转移、复制
C.任务的查找
D.排序
 */