import java.io.Serializable;
import java.util.*;

public class Time implements Serializable
{
   Calendar calendar;
   private int year;
   private int month;
   private int day;
   private int ddlYear;
   private int ddlMonth;
   private int ddlDay;
   
   
   public Time()
   {
	   calendar=Calendar.getInstance();
	   this.year=calendar.get(Calendar.YEAR);
	   this.month=calendar.get(Calendar.MONTH);
	   this.day=calendar.get(Calendar.DAY_OF_MONTH);
	   
	   this.ddlYear=calendar.get(Calendar.YEAR);
	   this.ddlMonth=calendar.get(Calendar.MONTH)+1;
	   this.ddlDay=calendar.get(Calendar.DAY_OF_MONTH);	   
   }
   
   
   public int getYear() 
   {
	return this.year;
   }
   public void setYear(int year1)
   {
	 this.year=year1;
   }
   public int getMonth() 
   {
	return this.month;
   }
   public void setMonth(int month1)
   {
	 this.month=month1;
   }
   public int getDay() 
   {
	return this.day;
   }
   public void setDay(int day1)
   {
	 this.day=day1;
   }
   
   public void addToDdlYear(int dyear) 
   {
	  this.ddlYear+=dyear;
   }
   public int getDdlYear() 
   {
	return this.ddlYear;
  }
   public void addToDdlMonth(int dmonth) 
   {
	  this.ddlMonth+=dmonth;
	  if(this.ddlMonth>12)
	  {
		  ddlMonth-=12;
		  ddlYear+=1;
	  }
   }
   public int getDdlMonth() 
   {
	  return this.ddlMonth;
}
   public void addToDdlDay(int dday) 
   {
	  this.ddlDay+=dday;
	  if(dday>31)
	  {
		  dday-=31;
		  ddlMonth+=1;
	  }
}
   public int  getDdlDay() 
   {
	  return this.ddlDay;
}
   public Calendar getCalendar()
   {
	 return this.calendar;
   }
   public void addDayOfYear(int days) //增加天数
   {
	this.calendar.add(Calendar.DAY_OF_YEAR, days);
	this.year=calendar.get(Calendar.YEAR);
	this.month=calendar.get(Calendar.MONTH);
	this.day=calendar.get(Calendar.DAY_OF_MONTH);
   }
   
	
}
