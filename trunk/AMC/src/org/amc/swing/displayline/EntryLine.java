package org.amc.swing.displayline;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on May 7, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class EntryLine extends EntryLineTemplate
{
	/**
	 * 
	 * Constructor for EntryLine.java
	 * @param name
	 */
	public EntryLine(String name)
	{
		super(name,new Dimension(200,25));
	}
	/**
	 * 
	 * Constructor for EntryLine.java
	 * @param name
	 * @param value
	 */
	public EntryLine(String name,String value)
	{
		super(name,value,new Dimension(200,25));
	}
	
	
}
