import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class TaskSystem implements Serializable
{    
	File file=new File("Task.txt");
	ArrayList<TaskList> taskListLits= new ArrayList<TaskList>();   
    
    public  TaskSystem() 
    {
    	try {
			if(!file.exists())
				file.createNewFile();		 		     
		} catch (Exception e) {
			System.out.println("File Error");
		}
	}
    
    public void addLIst(String listname) 
    {
    	taskListLits.add(new TaskList(listname));
    }
    
  //序列化对象到文件中
  	public void saveData() 
  {
      try 
      {   	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            //先清空文件再重新写文件
            if(file.exists())
            {
            	file.delete();
            	file.createNewFile();
            }
  	        oos.writeObject(this);
  	        oos.close();
  	} 
  	catch (IOException e2) {
  			System.out.println("io ERRROR!");
  			e2.printStackTrace();
  		}
  	}
   
      //反序列化
  public TaskSystem outData( )
  {
     TaskSystem taskSystem=new TaskSystem();
  	try {
  		  ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
  		  taskSystem=(TaskSystem)ois.readObject();
            if(taskSystem!=null)
          	  return taskSystem;
        } catch (Exception e) 
        {
  	    System.out.println("out error!");
        }
  	finally {
  		return taskSystem;
  	}
  }
    //任务清单排序1--按清单的中的任务数量
    public void paiXuByAmount() 
    {
		TaskList itemList=null;
    	for(int i=0;i<taskListLits.size()-1;i++)
		for(int j=taskListLits.size()-1;j>i;j--)
		{
			if(taskListLits.get(j).taskList.size()<taskListLits.get(j-1).taskList.size())
			{
				itemList=this.taskListLits.get(j);
				this.taskListLits.set(j,this.taskListLits.get(j-1));
				this.taskListLits.set(j-1,itemList);
			}
		}
	}
    //任务清单排序2--按清单的名字
    public void paiXuByName() 
    {
    	TaskList itemList=null;
    	for(int i=0;i<taskListLits.size()-1;i++)
		for(int j=taskListLits.size()-1;j>i;j--)
		{
			if(taskListLits.get(j).getListName().compareTo(taskListLits.get(j-1).getListName())<0)
			{				
				itemList=this.taskListLits.get(j);
				this.taskListLits.set(j,this.taskListLits.get(j-1));
				this.taskListLits.set(j-1,itemList);
			}
		}
	}
    
    public  ArrayList<TaskList> getTaskListsList()
    {
		return this.taskListLits;
	}
    
    //删除某个列表
    public void deleteOneList(int index) 
    {
		this.getTaskListsList().remove(index);
	}
}
