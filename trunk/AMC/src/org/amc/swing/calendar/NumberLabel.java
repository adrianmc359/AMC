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
