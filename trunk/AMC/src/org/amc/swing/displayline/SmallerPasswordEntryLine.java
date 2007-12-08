package org.amc.swing.displayline;

import java.awt.Dimension;

/**
 * <p>Project: AMC </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/AMC/trunk/AMC/src/org/amc/swing/displayline/SmallerPasswordEntryLine.java $<p>
 * <p>Created on Jun 6, 2006</p>
 * @author adrian
 * @version $Revision: 33 $
 */

public class SmallerPasswordEntryLine extends PasswordEntryLineTemplate
{

	/**
	 * 
	 * Constructor for SmallerPasswordEntryLine.java
	 * @param name
	 */
	public SmallerPasswordEntryLine(Enum name)
	{
		super(name,new Dimension(100,40));
	}
	
	/**
	 * 
	 * Constructor for SmallerPasswordEntryLine.java
	 * @param name
	 */
	public SmallerPasswordEntryLine(String name)
	{
		super(name,new Dimension(100,40));
	}
	
	/**
	 * 
	 * Constructor for SmallerPasswordEntryLine.java
	 * @param name
	 * @param value
	 */
	public SmallerPasswordEntryLine(Enum name,String value)
	{
		super(name,value,new Dimension(100,40));
	}
	
	/**
	 * 
	 * Constructor for SmallerPasswordEntryLine.java
	 * @param name
	 * @param value
	 */
	public SmallerPasswordEntryLine(String name,String value)
	{
		super(name,value,new Dimension(100,40));
	}


}
