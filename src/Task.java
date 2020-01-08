import java.io.Serializable;
import java.util.Calendar;

public class Task  implements Serializable{
 private String taskName;
 private String taskDescription=null;
 private boolean isCompleted=false;
 private Time timeTask=new Time();    //创建时间;
 private  int taskType;//1,2,3分别对应三种任务
 
 //构造函数
 public Task(String taskName1) 
 {
	this.setTaskName(taskName1);
}
 
 public Task(String taskName1,String taskDescription1) 
 {
	setTaskName(taskName1);
	setTaskDescription(taskDescription1);
}
 
//标准方法
 public void setTaskName(String taskName1)
 {
	this.taskName=taskName1;
}
 public String getTaskName() 
 {
	return this.taskName;
}
 public void setTaskDescription(String taskDescription1)
 {
	this.taskDescription=taskDescription1;
}
 public String getTaskDescription()
 {
	return this.taskDescription;
}
 public Time getTimeTask() 
 {
	return this.timeTask;
}
 public boolean getIsCompleted()
 {
   return this.isCompleted;	
}
 public void setTaskType(int typeIndex)
 {
	this.taskType=typeIndex;
}
 public int getTaskType() 
 {
	return this.taskType;
}
 
 //任务完成状态
 public void setIsCompletedTrue() 
 {
	this.isCompleted=true;
}
 
 //设置时间
 public void setTime1(int year,int month,int day)
 {
	this.timeTask.setYear(year);
	this.timeTask.setMonth(month);
	this.timeTask.setDay(day);
}
 
 public void addToDdl(int dyear,int dmonth,int dday) //add方法不起作用
 {
     System.out.println("调用了addToDdl"+dyear);
     System.out.println("前"+this.timeTask.getDdlYear());
	 this.timeTask.addToDdlYear(dyear);
	 System.out.println("前"+this.timeTask.getDdlYear());
     this.timeTask.addToDdlMonth(dmonth);
     this.timeTask.addToDdlDay(dday);
}
 
 
}

