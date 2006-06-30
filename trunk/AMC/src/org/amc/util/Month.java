package org.amc.util;
import org.amc.util.CalendarUtils.MONTH;
import org.amc.util.CalendarUtils.DAY;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class Month extends DefaultSubject
{
	public enum CHANGE
	{
		DAY,
		MONTH,
		YEAR;
	}
	private int year;
	private int day;
	private MONTH month;
	public Month(int day,MONTH month,int year)
	{
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public Month()
	{
		this(
				CalendarUtils.getCurrentDay(),
				CalendarUtils.getCurrentMonth(),
				CalendarUtils.getCurrentYear()
				);
	}
	/**
	 * @return Returns the day.
	 */
	public int getDay()
	{
		return day;
	}
	/**
	 * @param day The day to set.
	 */
	public void setDay(int day) throws Exception
	{
		int max_days=this.getNoOfDaysinMonth();
		if(day>max_days || day < 1)
		{
			throw new Exception(this.month+" has only "+max_days+" days.");
		}
		else
		{
			this.day = day;
			notifyObservers(CHANGE.DAY);
		}
	}
	/**
	 * @return Returns the month.
	 */
	public MONTH getMonth()
	{
		return month;
	}
	/**
	 * @param month The month to set.
	 */
	public void setMonth(MONTH month)
	{
		this.month = month;
		notifyObservers(null);
	}
	/**
	 * @return Returns the year.
	 */
	public int getYear()
	{
		return year;
	}
	/**
	 * @param year The year to set.
	 */
	public void setYear(int year)
	{
		this.year = year;
		notifyObservers(null);
	}
	public DAY getFirst_Day_of_Month()
	{
		return CalendarUtils.getFirstDayOfMonth(this.getMonth(),this.getYear());
	}
	public int getNoOfDaysinMonth()
	{
		return CalendarUtils.getNumberOfDays(this.getMonth(),this.getYear());
	}
	public void next_Month()
	{
		if(this.month.equals(MONTH.DECEMBER))
		{
			month=MONTH.JANUARY;
			year++;
		}
		else
		{
			month=month.nextMonth();
		}
		notifyObservers(null);
	}
	public void previous_Month()
	{
		if(this.month.equals(MONTH.JANUARY))
		{
			month=MONTH.DECEMBER;
			year--;
		}
		else
		{
			month=month.previousMonth();
		}
		notifyObservers(null);
	}
	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		String value=String.valueOf(this.day)+"/";
		value=value+(this.month.getCalendarValue()+1)+"/";
		value=value+String.valueOf(this.year);
		return value;
	}
}
