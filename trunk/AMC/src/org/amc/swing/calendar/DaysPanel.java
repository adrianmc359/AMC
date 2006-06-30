package org.amc.swing.calendar;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import org.amc.util.*;
import org.amc.util.CalendarUtils.MONTH;
import org.amc.util.CalendarUtils.DAY;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/swing/calendar/DaysPanel.java $<p>
 * <p>Created on Jun 7, 2006</p>
 * @author adrian
 * @version $Revision: 573 $
 */

public class DaysPanel extends JPanel implements MyObserver
{

	Month month;
	
	int today;
	MONTH thisMonth;
	int year;
	private  NumberLabel[] NUMBER_POOL=null;
	/**
	 * 
	 * Constructor for DaysPanel.java
	 * @param month
	 * @param year
	 */
	public DaysPanel(Month month)
	{
		super();
		this.month=month;
		today=CalendarUtils.getCurrentDay();
		thisMonth=CalendarUtils.getCurrentMonth();
		year=CalendarUtils.getCurrentYear();
	
		month.attachObserver(this);
		try
		{
			initialiseNumberPool();
			jbInit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private  void initialiseNumberPool()
	{
		NUMBER_POOL=new NumberLabel[31];
			for(int i=0;i<NUMBER_POOL.length;i++)
			{
				NUMBER_POOL[i]=new NumberLabel(i+1);
				NUMBER_POOL[i].addMouseListener(new MouseAdapter()
						{

							/**
							 * @see java.awt.event.MouseAdapter#mouseClicked(java.awt.event.MouseEvent)
							 */
							@Override
							public void mouseClicked(MouseEvent e)
							{
								changeDay(e);
							}
					
						});
				
			}
		
	}
	private int getNoOfBlanks(DAY day)
	{
		return day.getCalendarValue()-1;
	}
	private void jbInit() throws Exception
	{
		this.setLayout(new BorderLayout());
		this.add(getPanel(),BorderLayout.CENTER);
	}
	private JPanel getPanel()
	{
		JPanel bg=new JPanel();
		bg.setBackground(Color.WHITE);
		bg.setLayout(new GridLayout(0,7));
		DAY day=month.getFirst_Day_of_Month();
		int blanks=getNoOfBlanks(day);
		for(int i=0;i<blanks;i++)
		{
			bg.add(new NumberLabel());
		}
		int noOfDays=month.getNoOfDaysinMonth();
		for(int i=0;i<noOfDays;i++)
		{
			bg.add(NUMBER_POOL[i]);
			
			if(month.getMonth().equals(thisMonth) && i==today-1 && month.getYear()==year)
			{	
				//NUMBER_POOL[i].setOpaque(true);
				NUMBER_POOL[i].setBackground(Color.RED);
			}
			else
			{
				NUMBER_POOL[i].setBackground(Color.WHITE);
			}
		}
		return bg;
	}
	public void update(Subject o, Object arg)
	{
		this.remove(0);
		this.add(getPanel(),BorderLayout.CENTER);
		this.validate();
		this.repaint();
		
	}
	private void changeDay(MouseEvent e)
	{
		JButton button=(JButton)e.getComponent();
		int day=Integer.parseInt(button.getText());
		try
		{
			this.month.setDay(day);
			System.out.println(this.month);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}


}