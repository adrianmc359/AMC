package org.amc.swing;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import org.amc.util.*;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/swing/JCalendarBox.java $<p>
 * <p>Created on Jun 7, 2006</p>
 * @author adrian
 * @version $Revision: 573 $
 */

public class JCalendarBox extends JPanel implements MyObserver
{
	JTextField txt;
	JButton button;
	JCalendar calendar;
	public JCalendarBox()
	{
		super();
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
		this.addPropertyChangeListener(new PropertyChangeListener()
				{

					public void propertyChange(PropertyChangeEvent evt)
					{
						if(evt.getPropertyName().equals("ancestor"))
						{
							 addWindowListener(evt);
						}
					}
			
		});
		button=new JButton("v");
		txt=new JTextField();
		txt.setEditable(false);
		calendar=new JCalendar();
		this.calendar.getMonth().attachObserver(this);
		this.setLayout(new BorderLayout());
		this.add(txt,BorderLayout.CENTER);
		this.add(button,BorderLayout.EAST);
		button.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						flipPopup(e);
					}
				});
	}
	private void flipPopup(MouseEvent e)
	{
		int x=(int)this.getLocationOnScreen().getX();
		int y=(int)(this.getLocationOnScreen().getY()+this.getSize().getHeight());
		boolean show=!calendar.isVisible();
		calendar.setPreferredSize(new Dimension(400,200));
		calendar.setLocation(x,y);
		calendar.setVisible(show);
	}
	public void update(Subject o, Object arg)
	{
		this.txt.setText(this.calendar.getMonth().toString());
	}
	private void addWindowListener(PropertyChangeEvent evt)
	{
		Component topWindow=(Component)this.getTopLevelAncestor();
		topWindow.addComponentListener(new ComponentListener(){

				public void componentResized(ComponentEvent e)
				{
					calendar.setVisible(false);
				}
				public void componentMoved(ComponentEvent e)
				{
				}
	
				public void componentShown(ComponentEvent e)
				{
					calendar.setVisible(false);
				}
	
				public void componentHidden(ComponentEvent e)
				{
					calendar.setVisible(false);
				}
			});
	}
	public String  getSelectedDate()
	{
		
		return this.calendar.getMonth().toString();
	}

	public void setSelectedItem(Object value)
	{
		try
		{
			DateContainer datecont=new DateContainer(String.valueOf(value));
			Date date=datecont.getDate();
			Calendar cal=Calendar.getInstance(Locale.UK);
			cal.setTime(date);
			this.calendar.setDate(cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH),cal.get(Calendar.YEAR));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
}
