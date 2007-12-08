package org.amc.swing.displayline;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.amc.swing.DisplayLine;
/**
 * <p>Project: AMC </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/AMC/trunk/AMC/src/org/amc/swing/displayline/PasswordEntryLineTemplate.java $<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision: 32 $
 */

public class PasswordEntryLineTemplate extends DisplayLine
{
	private JLabel label;
	private JPasswordField txtbox;
	/**
	 * 
	 * Constructor for PasswordEntryLineTemplate.java
	 * @param name Enum
	 * @param label_size
	 */
	public PasswordEntryLineTemplate(Enum name,Dimension label_size)
	{
		this(String.valueOf(name),label_size);
	}
	/**
	 * 
	 * Constructor for PasswordEntryLineTemplate.java
	 * @param name Enum
	 * @param value
	 * @param label_size
	 */
	public PasswordEntryLineTemplate(Enum name,String value,Dimension label_size)
	{
		this(String.valueOf(name),value,label_size);
	}
	/**
	 * 
	 * Constructor for PasswordEntryLineTemplate.java
	 * @param name String
	 * @param label_size
	 */
	public PasswordEntryLineTemplate(String name,Dimension label_size)
	{
		label=new JLabel("     "+name);
		label.setPreferredSize(label_size);
		txtbox=new JPasswordField();
		txtbox.setPreferredSize(new Dimension(200,25));
		jbInit(label,txtbox);
	}
	/**
	 * 
	 * Constructor for PasswordEntryLineTemplate.java
	 * @param name String
	 * @param value
	 * @param label_size
	 */
	public PasswordEntryLineTemplate(String name,String value,Dimension label_size)
	{
		label=new JLabel("     "+name);
		label.setPreferredSize(label_size);
		txtbox=new JPasswordField();
		txtbox.setPreferredSize(new Dimension(200,25));
		txtbox.setText(value);
		jbInit(label,txtbox);
	}
}