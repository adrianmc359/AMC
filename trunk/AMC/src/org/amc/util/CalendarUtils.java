package org.amc.util;
import java.util.*;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/util/CalendarUtils.java $<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision: 573 $
 */

public class CalendarUtils
{
	public enum MONTH
	{
		JANUARY(Calendar.JANUARY,"January"),
		FEBRUARY(Calendar.FEBRUARY,"February"),
		MARCH(Calendar.MARCH,"March"),
		APRIL(Calendar.APRIL,"April"),
		MAY(Calendar.MAY,"May"),
		JUNE(Calendar.JUNE,"June"),
		JULY(Calendar.JULY,"July"),
		AUGUST(Calendar.AUGUST,"August"),
		SEPTEMBER(Calendar.SEPTEMBER,"September"),
		OCTOBER(Calendar.OCTOBER,"October"),
		NOVEMBER(Calendar.NOVEMBER,"November"),
		DECEMBER(Calendar.DECEMBER,"December");
		int value;
		String string;
		MONTH(int calender_rep,String string)
		{
			this.value=calender_rep;
			this.string=string;
		}
		public int getCalendarValue()
		{
			return this.value;
		}
		public MONTH nextMonth()
		{
			boolean check=false;
			for(MONTH m:MONTH.values())
			{
				if(check==true)
				{
					return m;
				}
				if(m.equals(this))
				{
					check=true;
				}
			}
			return null;
		}
		public MONTH previousMonth()
		{
			MONTH old_month=MONTH.DECEMBER;
			for(MONTH m:MONTH.values())
			{
				if(m.equals(this))
				{
					return old_month;
				}
				old_month=m;
				
			}
			return null;
		}
		public String toString()
		{
			return string;
		}
	}
	public enum DAY
	{
		SUNDAY(Calendar.SUNDAY,"Sunday"),
		MONDAY(Calendar.MONDAY,"Monday"),
		TUESDAY(Calendar.TUESDAY,"Tuesday"),
		WEDNESDAY(Calendar.WEDNESDAY,"Wednesday"),
		THURSDAY(Calendar.THURSDAY,"Thursday"),
		FRIDAY(Calendar.FRIDAY,"Friday"),
		SATURDAY(Calendar.SATURDAY,"Saturday");
		int day;
		String string;
		DAY(int day,String string)
		{
			this.day=day;
			this.string=string;
		}
		public int getCalendarValue()
		{
			return this.day;
		}
		public String toString()
		{
			return string;
		}
		public char getInitial()
		{
			return string.charAt(0);
		}
	}
	//private GregorianCalendar calendar;
	
	private static GregorianCalendar initialise()
	{
		return (GregorianCalendar)GregorianCalendar.getInstance(Locale.UK);
	}
	/**
	 * Returns the number of days in the given month of  year <****>.
	 * @param month
	 * @param year
	 * @return Integer
	 */
	public static int getNumberOfDays(MONTH month,int year)
	{
		GregorianCalendar calendar=initialise();
		calendar.set(year,month.getCalendarValue(),1);
		//System.out.println("Min:"+ calendar.get(Calendar.DAY_OF_WEEK));
		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 
	 * @param month
	 * @return
	 */
	public static DAY getFirstDayOfMonth(MONTH month,int year)
	{
		GregorianCalendar calendar=initialise();
		calendar.set(year,month.getCalendarValue(),1);
		int day=calendar.get(Calendar.DAY_OF_WEEK);
		return getDay(day);
	}
	/**
	 * converts int from Calendar to ENUM
	 * @param field
	 * @return MONTH Enum
	 */
	public static MONTH getMONTH(int field)
	{
		switch(field)
		{
			case(Calendar.JANUARY):
				return MONTH.JANUARY;
			case(Calendar.FEBRUARY):
				return MONTH.FEBRUARY;
			case(Calendar.MARCH):
				return MONTH.MARCH;
			case(Calendar.APRIL):
				return MONTH.APRIL;
			case(Calendar.MAY):
				return MONTH.MAY;
			case(Calendar.JUNE):
				return MONTH.JUNE;
			case(Calendar.JULY):
				return MONTH.JULY;
			case(Calendar.AUGUST):
				return MONTH.AUGUST;
			case(Calendar.SEPTEMBER):
				return MONTH.SEPTEMBER;
			case(Calendar.OCTOBER):
				return MONTH.OCTOBER;
			case(Calendar.NOVEMBER):
				return MONTH.NOVEMBER;
			case(Calendar.DECEMBER):
				return MONTH.DECEMBER;
			
		}
		return null;
	}
	/**
	 * gets current month
	 * @return Enum MONTH
	 */
	public static MONTH getCurrentMonth()
	{
		GregorianCalendar calendar=initialise();
		int month=calendar.get(Calendar.MONTH);
		return getMONTH(month);
	}
	/**
	 * 
	 * @return Int day of the month
	 */
	public static int getCurrentDay()
	{
		GregorianCalendar calendar=initialise();
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	/**
	 * 
	 * @return current year
	 */
	public static int getCurrentYear()
	{
		GregorianCalendar calendar=initialise();
		int year=calendar.get(Calendar.YEAR);
		return year;
	}
	/**
	 * 
	 * @param field Calendar.Day_of_Week
	 * @return Enum Day
	 */
	public static DAY getDay(int field)
	{
		switch(field)
		{
			case(Calendar.SUNDAY):
				return DAY.SUNDAY;
			case(Calendar.MONDAY):
				return DAY.MONDAY;
			case(Calendar.TUESDAY):
				return DAY.TUESDAY;
			case(Calendar.WEDNESDAY):
				return DAY.WEDNESDAY;
			case(Calendar.THURSDAY):
				return DAY.THURSDAY;
			case(Calendar.FRIDAY):
				return DAY.FRIDAY;
			case(Calendar.SATURDAY):
				return DAY.SATURDAY;	
		}
		return null;
	}
	public static void main(String[] args)
	{
		System.out.println(CalendarUtils.getNumberOfDays(MONTH.FEBRUARY,2006));
		System.out.println(CalendarUtils.getNumberOfDays(MONTH.SEPTEMBER,2005));
		System.out.println(CalendarUtils.getFirstDayOfMonth(MONTH.FEBRUARY,2006));
		System.out.println("curr Month="+CalendarUtils.getCurrentMonth());
	}
}
