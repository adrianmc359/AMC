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
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/swing/JCalendar.java $<p>
 * <p>Created on Jun 7, 2006</p>
 * @author adrian
 * @version $Revision: 573 $
 */

public class JCalendar extends JPopupMenu implements MyObserver
{
	/**
	 * Constructor for JCalendar.java
	 */
	Month month;
	DaysPanel dayHolder;
	TopBar topBar;
	Box box;
	JLabel days;
	public JCalendar()
	{
		super();
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
		box=Box.createVerticalBox();
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
