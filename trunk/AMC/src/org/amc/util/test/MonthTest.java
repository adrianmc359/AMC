package org.amc.util.test;

import junit.framework.TestCase;
import org.amc.util.CalendarUtils.MONTH;
import org.amc.util.CalendarUtils.DAY;
import org.amc.util.*;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/util/test/MonthTest.java $<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision: 546 $
 */

public class MonthTest extends TestCase
{
	Month month;
	public static void main(String[] args)
	{
		junit.swingui.TestRunner.run(MonthTest.class);
	}

	

	/*
	 * Test method for 'org.amc.util.Month.getDay()'
	 */
	public void testGetDay()
	{
		int expected_day=23;
		month=new Month(expected_day,MONTH.FEBRUARY,2006);
		int actual_day=month.getDay();
		assertEquals(expected_day,actual_day);
		
	}
	/*
	 * Test method for 'org.amc.util.Month.setDay()'
	 */
	public void testSetDay()
	{
		boolean check=false;
		month=new Month(21,MONTH.FEBRUARY,2006);
		try
		{
			month.setDay(29);
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			check=true;
		}
		assertTrue(check);
	}
	/*
	 * Test method for 'org.amc.util.Month.getMonth()'
	 */
	public void testGetMonth()
	{
		MONTH expected_month=MONTH.AUGUST;
		month=new Month(23,expected_month,2006);
		MONTH actual_month=month.getMonth();
		assertEquals(expected_month,actual_month);

	}

	/*
	 * Test method for 'org.amc.util.Month.getYear()'
	 */
	public void testGetYear()
	{
		int expected_year=2003;
		month=new Month(23,MONTH.FEBRUARY,expected_year);
		int actual_year=month.getYear();
		assertEquals(expected_year,actual_year);
	}

	/*
	 * Test method for 'org.amc.util.Month.getFirst_Day_of_Month()'
	 */
	public void testGetFirst_Day_of_Month()
	{
		DAY day=DAY.WEDNESDAY;
		month=new Month(23,MONTH.FEBRUARY,2006);
		DAY actual=month.getFirst_Day_of_Month();
		assertTrue(day.equals(actual));
	}

	/*
	 * Test method for 'org.amc.util.Month.getNoOfDaysinMonth()'
	 */
	public void testGetNoOfDaysinMonth()
	{
		int expected=28;
		month=new Month(23,MONTH.FEBRUARY,2006);
		int actual=month.getNoOfDaysinMonth();
		assertEquals(expected,actual);
		month=new Month(23,MONTH.FEBRUARY,2004);
		expected=29;
		actual=month.getNoOfDaysinMonth();
		assertEquals(expected,actual);
	}

	/*
	 * Test method for 'org.amc.util.Month.next_Month()'
	 */
	public void testNext_Month()
	{
		//CASE #1: End of year
		month=new Month(23,MONTH.DECEMBER,2006);
		MONTH expected_month=MONTH.JANUARY;
		int expected_year=2007;
		month.next_Month();
		MONTH actual_month=month.getMonth();
		int actual_year=month.getYear();
		assertEquals(expected_year,actual_year);
		assertTrue(expected_month.equals(actual_month));
		
		//CASE #2: NOT end of year
		month=new Month(23,MONTH.NOVEMBER,2006);
		month.next_Month();
		expected_month=MONTH.DECEMBER;
		expected_year=2006;
		actual_month=month.getMonth();
		actual_year=month.getYear();
		assertEquals(expected_year,actual_year);
		assertTrue(expected_month.equals(actual_month));
	}
	/*
	 * Test method for 'org.amc.util.Month.previous_Month()'
	 */
	public void testPrevious_Month()
	{
		//CASE #1 beginning of year
		month=new Month(23,MONTH.JANUARY,2006);
		MONTH expected_month=MONTH.DECEMBER;
		int expected_year=2005;
		month.previous_Month();
		MONTH actual_month=month.getMonth();
		int actual_year=month.getYear();
		assertEquals(expected_year,actual_year);
		assertTrue(expected_month.equals(actual_month));
		
		//CASE #2: NOT beginning of year
		month=new Month(23,MONTH.APRIL,2006);
		month.previous_Month();
		expected_month=MONTH.MARCH;
		expected_year=2006;
		actual_month=month.getMonth();
		actual_year=month.getYear();
		assertEquals(expected_year,actual_year);
		assertTrue(expected_month.equals(actual_month));
		
	}
}
