import java.io.Serializable;
import java.util.Calendar;

public class Task  implements Serializable{
 private String taskName;
 private String taskDescription=null;
 private boolean isCompleted=false;
 private Time timeTask=new Time();    //����ʱ��;
 private  int taskType;//1,2,3�ֱ��Ӧ��������
 
 //���캯��
 public Task(String taskName1) 
 {
	this.setTaskName(taskName1);
}
 
 public Task(String taskName1,String taskDescription1) 
 {
	setTaskName(taskName1);
	setTaskDescription(taskDescription1);
}
 
//��׼����
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
 
 //�������״̬
 public void setIsCompletedTrue() 
 {
	this.isCompleted=true;
}
 
 //����ʱ��
 public void setTime1(int year,int month,int day)
 {
	this.timeTask.setYear(year);
	this.timeTask.setMonth(month);
	this.timeTask.setDay(day);
}
 
 public void addToDdl(int dyear,int dmonth,int dday) //add������������
 {
     System.out.println("������addToDdl"+dyear);
     System.out.println("ǰ"+this.timeTask.getDdlYear());
	 this.timeTask.addToDdlYear(dyear);
	 System.out.println("ǰ"+this.timeTask.getDdlYear());
     this.timeTask.addToDdlMonth(dmonth);
     this.timeTask.addToDdlDay(dday);
}
 
 
}

