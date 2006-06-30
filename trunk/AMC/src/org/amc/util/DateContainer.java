package org.amc.util;
import java.util.*;
import java.text.*;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/util/DateContainer.java $<p>
 * <p>Created on Jun 4, 2006</p>
 * @author adrian
 * @version $Revision: 573 $
 */

public class DateContainer
{

	private Date date;
	/**
	 * 
	 * Constructor for DateContainer.java
	 * @param date
	 */
	public DateContainer(Date date)
	{
		this.date=date;
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
		this.date=df.parse(date);
	}
	public Date getDate()
	{
		return date;
	}
	/**
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		DateFormat df=getDateFormat();
		return df.format(this.date);
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

}
