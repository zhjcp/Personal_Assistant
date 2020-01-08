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
任务：
属性：名称、详细描述、是否被完成状态
分类：
3.长期任务:
额外属性：截止日期、子任务列表（可以嵌套子任务）
   方法：
A.任务的修改
B.任务在清单间转移、复制
C.任务的查找
D.排序
*/