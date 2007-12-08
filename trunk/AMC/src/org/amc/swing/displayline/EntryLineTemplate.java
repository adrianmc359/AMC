package org.amc.swing.displayline;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.amc.swing.DisplayLine;
/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class EntryLineTemplate extends DisplayLine
{
	private JLabel label;
	private JTextField txtbox;
	/**
	 * 
	 * Constructor for EntryLineTemplate.java
	 * @param name Enum
	 * @param label_size
	 */
	public EntryLineTemplate(Enum name,Dimension label_size)
	{
		this(String.valueOf(name),label_size);
	}
	/**
	 * 
	 * Constructor for EntryLineTemplate.java
	 * @param name Enum
	 * @param value
	 * @param label_size
	 */
	public EntryLineTemplate(Enum name,String value,Dimension label_size)
	{
		this(String.valueOf(name),value,label_size);
	}
	/**
	 * 
	 * Constructor for EntryLineTemplate.java
	 * @param name String
	 * @param label_size
	 */
	public EntryLineTemplate(String name,Dimension label_size)
	{
		label=new JLabel("     "+name);
		label.setPreferredSize(label_size);
		txtbox=new JTextField();
		txtbox.setPreferredSize(new Dimension(200,25));
		jbInit(label,txtbox);
	}
	/**
	 * 
	 * Constructor for EntryLineTemplate.java
	 * @param name String
	 * @param value
	 * @param label_size
	 */
	public EntryLineTemplate(String name,String value,Dimension label_size)
	{
		label=new JLabel("     "+name);
		label.setPreferredSize(label_size);
		txtbox=new JTextField();
		txtbox.setPreferredSize(new Dimension(200,25));
		txtbox.setText(value);
		jbInit(label,txtbox);
	}
}