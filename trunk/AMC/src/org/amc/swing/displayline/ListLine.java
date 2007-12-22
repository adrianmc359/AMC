package org.amc.swing.displayline;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.amc.swing.DisplayLine;

/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on May 7, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public 	class ListLine extends DisplayLine
{
	private JLabel label;
	private JComboBox txtbox;
	private String name;
	/**
	 * 
	 * Constructor for ListLine.java
	 * @param name
	 * @param list
	 */
	public ListLine(String name,Object[] list,boolean editable)
	{
		super();
		label=new JLabel("     "+name);
		this.name=String.valueOf(name);
		label.setPreferredSize(new Dimension(200,25));
		txtbox=new JComboBox(list);
		txtbox.setPreferredSize(new Dimension(300,25));
		txtbox.setEditable(editable);
		jbInit(label,txtbox);
		addListener();
	}
	public ListLine(Enum name,String[] list,boolean editable)
	{
		this(name.toString(),list,editable);
	}
	/**
	 * 
	 * Constructor for ListLine.java
	 * @param name
	 * @param list
	 */
	public ListLine(Enum name,Enum[] list,boolean editable)
	{
		this(name.toString(),list,editable);
	}
	/**
	 * 
	 * Constructor for ListLine.java
	 * @param name
	 * @param list
	 */
	public ListLine(Enum name,Object[] list,boolean editable)
	{
		this(name.toString(),list,editable);
	}
	
	private void addListener()
	{
		txtbox.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
						JComboBox cb = (JComboBox)e.getSource();
						//int holder = cb.getSelectedIndex();
						notifyObservers(cb.getSelectedItem());
					}
				});
	}

	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @param size of the label
	 */
	public void setLabelSize(Dimension size)
	{
		label.setPreferredSize(size);
		validate();
	}
	
	/**
	 * 
	 * @param size of the ComboBox
	 */
	public void setComboSize(Dimension size)
	{
		txtbox.setPreferredSize(size);
		validate();
	}
}
