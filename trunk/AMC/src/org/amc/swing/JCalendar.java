package org.amc.swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import org.amc.util.*;
import org.amc.util.CalendarUtils.MONTH;
import org.amc.swing.calendar.*;
import javax.swing.ListCellRenderer;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 7, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class JCalendar extends JDialog implements MyObserver
{
	/**
	 * Constructor for JCalendar.java
	 */
	private Month month;
	private DaysPanel dayHolder;
	private TopBar topBar;
	public JCalendar()
	{
		super();
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setFocusableWindowState(false);
		month=new Month();
		month.attachObserver(this);
		try
		{
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void jbInit() throws Exception
	{
		//this.setBackground(Color.WHITE);
		//super.setSize(500,100);
		this.setLayout(new BorderLayout());
		//TOPbar
		this.topBar=new TopBar(month);
		
		
		this.add(topBar,BorderLayout.NORTH);
		
		//Day Panel
		this.dayHolder=new DaysPanel(month);
		
		this.add(dayHolder,BorderLayout.CENTER);
		
		
		
	}
	public void update(Subject o, Object arg)
	{
		if(arg instanceof Month.CHANGE)
		{
			Month.CHANGE change=(Month.CHANGE)arg;
			if(change.equals(Month.CHANGE.DAY))
			{
				this.setVisible(false);
			}
		}
	}
	public static void main(String[] args)
	{
		JFrame display=new JFrame();
		display.setLayout(new BorderLayout());
		display.setSize(350,200);
		
		
		
		JCalendarBox box=new JCalendarBox();
		//String[] values={"a","c","d","r"};
		//JComboBox box=new JComboBox(values);
		display.add(box,BorderLayout.CENTER);
		
		display.setVisible(true);
		
	}
	/**
	 * @return Returns the month.
	 */
	public Month getMonth()
	{
		return month;
	}
	public void setDate(int day,int month,int year)
	{
		try
		{
			this.month.setDay(day);
			this.month.setMonth(CalendarUtils.getMONTH(month));
			this.month.setYear(year);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	

}
