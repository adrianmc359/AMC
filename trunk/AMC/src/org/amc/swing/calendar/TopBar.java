package org.amc.swing.calendar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import org.amc.util.*;
import org.amc.util.CalendarUtils.MONTH;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 7, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class TopBar extends JPanel implements MyObserver
{


	private JLabel monthLabel;
	private JLabel yearLabel;
	private JButton left=new JButton("<-");;
	private JButton right=new JButton("->");
	private Month month;;
	private Color l_blue;
	public TopBar(Month month)
	{
		super();
		l_blue=new Color(144,159,219);
		this.month=month;
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
		//box=Box.createHorizontalBox();
		
		this.monthLabel=new JLabel(month.getMonth().toString());
		this.yearLabel=new JLabel(String.valueOf(month.getYear()));
		this.setLayout(new FlowLayout());
		setBackground(this.l_blue);
		setOpaque(true);
		setPreferredSize(new Dimension(100,30));
		//this.add(box);
		this.add(this.left);
		//box.add(Box.createHorizontalStrut(20));
		//box.add(Box.createHorizontalGlue());
		this.add(monthLabel);
		//box.add(Box.createHorizontalStrut(10));
		this.add(yearLabel);
		//box.add(Box.createHorizontalGlue());
		//box.add(Box.createHorizontalStrut(20));
		this.add(this.right);
		
		right.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						month.next_Month();
					}
				});
		left.addMouseListener(new MouseAdapter()
				{
					public void mouseClicked(MouseEvent e)
					{
						month.previous_Month();
					}
				});
	}
	/**
	 * 
	 * @see org.amc.util.MyObserver#update(org.amc.util.Subject, java.lang.Object)
	 */
	public void update(Subject o, Object arg)
	{
		int index=Utils.findComponent(this,monthLabel);
		this.remove(index);
		this.monthLabel=new JLabel(month.getMonth().toString());
		this.add(monthLabel,index);
		
		index=Utils.findComponent(this,yearLabel);
		this.remove(index);
		this.yearLabel=new JLabel(String.valueOf(month.getYear()));
		this.add(yearLabel,index);
		
		this.validate();
		this.repaint();
		System.out.println(month.getMonth()+" "+month.getYear());
	}
	

}
