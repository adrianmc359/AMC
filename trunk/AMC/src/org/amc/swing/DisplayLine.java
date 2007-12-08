package org.amc.swing;

import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import org.amc.swing.*;
import org.amc.util.DefaultSubject;
import org.amc.util.MyObserver;
import org.amc.util.Subject;


/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on May 7, 2006</p>
 * @author adrian
 * @version $Revision$
 * <br>
 * <p>\image html design_DisplayLine.png</p>
 * <p>Four place holders for JComponents</p>
 * <p>@todo rename class to DisplayBlock and subclass from <name>Line <name>Block </p>
 */

public class DisplayLine extends JPanel implements Subject
{ 
	private DefaultSubject subject; 
	
	LayoutManager layout=new FlowLayout(FlowLayout.LEFT);
	
	private JComponent component2;
	private JLabel blank=new JLabel();
	private JLabel blank1=new JLabel();
	private JComponent lastComponent;
	private JComponent valueComponent;
	
	public DisplayLine()
	{
		subject=new DefaultSubject();
		this.setLayout(layout);
	}
	public DisplayLine(JComponent component1,JComponent component2)
	{
		this();
		jbInit(component1,component2);
	}
	protected void jbInit(JComponent component1,JComponent component2)
	{
		this.component2=component2;
		this.add(component1);
		this.add(blank1);
		this.add(component2);
		if((component2 instanceof JTextField) || (component2 instanceof JComboBox)  || (component2 instanceof JCalendarBox) )
		{
			this.valueComponent=component2;
		}
        this.add(blank);
        lastComponent=blank;
	}
	public JComponent getSecondComponent()
	{
		return this.component2;
	}
	public void setLastComponent(JComponent component)
	{
		this.remove(lastComponent);
		this.add(component);
		this.lastComponent=component;
	}
	/**
	 * The three types of input are covered TextComponent,Checkbox and Combobox
	 * Removes the need for objects calling this function the need to know the Component types
	 * @return the value from the input element
	 */
	public String getValue()
	{
		JComponent component=this.valueComponent;
		if(component instanceof JTextComponent)
		{
			return ((JTextComponent)component).getText();
		}
		else
		{
			if(component instanceof JCheckBox)
			{
				return String.valueOf(((JCheckBox)component).isSelected());
			}
			else
			{
				if(component instanceof JComboBox)
				{
					return String.valueOf(((JComboBox)component).getSelectedItem());
				}
				else
				{
					if(component instanceof JCalendarBox)
					{
						return String.valueOf(((JCalendarBox)component).getSelectedDate());
					}
				}
			
			
			}
			return null;
		}
		
		
	}
	public void setValue(Object value)
	{
		JComponent component=this.valueComponent;
		if(component instanceof JTextComponent)
		{
			((JTextComponent)component).setText(String.valueOf(value));
		}
		else
		{
			if(component instanceof JCheckBox)
			{
				JCheckBox box=(JCheckBox)component;
				if(Boolean.parseBoolean(String.valueOf(value))==true)
				{
					box.setSelected(true);
				}
				else
				{
					box.setSelected(false);
				}
			}
			else
			{
				if(component instanceof JComboBox)
				{
					JComboBox box=((JComboBox)component);
					box.setSelectedItem(value);
				}
				else
				{
					if(component instanceof JCalendarBox)
					{
						JCalendarBox box= (JCalendarBox)component;
						box.setSelectedItem(value);
					}
				}
			
			
			}
		}
			
		
	}
	/*
	 * Implementing Subject interface
	 */
	public JComponent getValueComponent()
	{
		return this.valueComponent;
	}
	public void registerTextComponent(JComponent component)
	{
		this.valueComponent=component;
	}
	/**
	 * @see org.amc.util.Subject#attachObserver(org.amc.util.MyObserver)
	 */
	public void attachObserver(MyObserver O)
	{
		subject.attachObserver(O);
	}
	/**
	 * @see org.amc.util.Subject#notifyObservers(java.lang.Object)
	 */
	public void notifyObservers(Object obj)
	{
		subject.notifyObservers(obj);
	}
	/**
	 * @see org.amc.util.Subject#removeObserver(org.amc.util.MyObserver)
	 */
	public void removeObserver(MyObserver O)
	{
		subject.removeObserver(O);
	}
}
