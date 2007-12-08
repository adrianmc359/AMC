package org.amc.swing.displayline;

import java.awt.Dimension;

/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class SmallerEntryLine extends EntryLineTemplate
{

	/**
	 * 
	 * Constructor for SmallerEntryLine.java
	 * @param name
	 */
	public SmallerEntryLine(Enum name)
	{
		super(name,new Dimension(100,40));
	}
	
	/**
	 * 
	 * Constructor for SmallerEntryLine.java
	 * @param name
	 */
	public SmallerEntryLine(String name)
	{
		super(name,new Dimension(100,40));
	}
	
	/**
	 * 
	 * Constructor for SmallerEntryLine.java
	 * @param name
	 * @param value
	 */
	public SmallerEntryLine(Enum name,String value)
	{
		super(name,value,new Dimension(100,40));
	}
	
	/**
	 * 
	 * Constructor for SmallerEntryLine.java
	 * @param name
	 * @param value
	 */
	public SmallerEntryLine(String name,String value)
	{
		super(name,value,new Dimension(100,40));
	}


}
