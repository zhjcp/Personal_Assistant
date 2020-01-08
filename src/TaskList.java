import java.io.Serializable;
import java.util.ArrayList;

public class TaskList implements Serializable
{
	private String listName;
	ArrayList<Task> taskList=new ArrayList<Task>();
	
	public TaskList(String listname) 
	{
		setListName(listname);
	}
	
	public void setListName(String listname) 
	{
		this.listName=listname;
	}
	public String getListName()
	{
		return this.listName;
	}
	
	public void addTask(Task task) //添加任务列表
	 {
			taskList.add(task);
	}
	
	public ArrayList<Task> getTaskList() //添加任务列表
	{
		return this.taskList;
	}
	
	public String printThisList() 
    {
		String nameString="";
		for(Task a:taskList)
		{
			nameString+=a.getTaskName()+"/n";
		}
		return nameString;
	}
	
	//任务排序1--按字典顺序
	public void paiXuByName() 
	{
		Task itemTask=null;
		for(int i=0;i<this.taskList.size();i++)
		for(int j=this.taskList.size()-1;j>i;j--)
		{
			if(this.taskList.get(j).getTaskName().compareTo(this.taskList.get(j-1).getTaskName())<0)
			{
				itemTask=this.taskList.get(j);
				this.taskList.set(j,this.taskList.get(j-1));
				this.taskList.set(j-1,itemTask);
			}
		}
	}
	
	//任务排序2--按完成度顺序(未完成的在前)
	public void paiXuByCompleted()
	{
	    Task itemTask=null;
		for(int i=0;i<this.taskList.size();i++)
		for(int j=this.taskList.size()-1;j>i;j--)
		{
			if(!this.taskList.get(j).getIsCompleted())
			{
				if(this.taskList.get(j-1).getIsCompleted())
			   {
				 itemTask=this.taskList.get(j);
				 this.taskList.set(j,this.taskList.get(j-1));
				 this.taskList.set(j-1,itemTask);
				}
			}
		}
	}
	
	//任务排序3--按创建时间顺序
	public void paiXuByTime()
	{
	    Task itemTask=null;
		for(int i=0;i<this.taskList.size();i++)
		for(int j=this.taskList.size()-1;j>i;j--)
		{
		  if(this.taskList.get(j).getTimeTask().getCalendar().compareTo(this.taskList.get(j-1).getTimeTask().getCalendar())<0)
			{
				itemTask=this.taskList.get(j);
				this.taskList.set(j,this.taskList.get(j-1));
				this.taskList.set(j-1,itemTask);
			}
		}
	}
	
}
