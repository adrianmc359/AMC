package org.amc.util;
import java.util.*;
import java.text.*;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 4, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class DateContainer
{
	Calendar calendar=Calendar.getInstance();
	
	/**
	 * 
	 * Constructor for DateContainer.java
	 * @param date
	 */
	public DateContainer(Date date)
	{
		calendar.setTime(date);
	}
	/**
	 * 
	 * Constructor for DateContainer.java
	 * @param date
	 * @throws ParseException
	 */
	public DateContainer(String date) throws ParseException
	{
		DateFormat df=getDateFormat();
		calendar.setTime(df.parse(date));
	}
	public Date getDate()
	{
		return calendar.getTime();
	}
	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		DateFormat df=getDateFormat();
		return df.format(calendar.getTime());
	}
	/**
	 * 
	 * @return java.text.DateFormat object;
	 */
	private DateFormat getDateFormat()
	{
		DateFormat df=DateFormat.getDateInstance(DateFormat.SHORT,Locale.UK);
		return df;
	}

	/**
	 * Compares day, month, year but not seconds 
	 * @param date
	 * @return boolean
	 */
	public boolean sameDate(Date date)
	{
		return sameDate(this.calendar.getTime(),date);
		
	}
	
	/**
	 * Compares day, month, year but not seconds 
	 * @param date
	 * @return boolean
	 */
	public static boolean sameDate(Date one,Date two)
	{
		
		Calendar calOne=Calendar.getInstance();
		Calendar calTwo=Calendar.getInstance();
		calOne.setTime(one);
		calTwo.setTime(two);
		
		if(
				calOne.get(Calendar.YEAR)==calTwo.get(Calendar.YEAR) &&
				calOne.get(Calendar.MONTH)==calTwo.get(Calendar.MONTH) &&
				calOne.get(Calendar.DATE)==calTwo.get(Calendar.DATE)
				)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
