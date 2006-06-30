package org.amc.swing.calendar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import org.amc.util.*;
import org.amc.util.CalendarUtils.MONTH;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/swing/calendar/NumberLabel.java $<p>
 * <p>Created on Jun 7, 2006</p>
 * @author adrian
 * @version $Revision: 573 $
 */

public class NumberLabel extends JButton
{
	public NumberLabel()
	{
		Font font=new Font("Serif",Font.PLAIN,8);
		this.setFont(font);
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(20,10));
		this.setEnabled(false);
		this.setText(" ");
	}
	public NumberLabel(int day)
	{
		this();
		this.setEnabled(true);
		this.setText(String.valueOf(day));
		
	}
}
