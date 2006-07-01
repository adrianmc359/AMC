package org.amc.swing;

import javax.swing.*;
import java.awt.*;
import org.amc.swing.graph.*;
/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 30, 2006</p>
 * A View of XY graph
 * @author adrian
 * @version $Revision$
 */

public class XY_GraphPane extends JPanel
{
	private XY_Graph graph;
	/**
	 * 
	 * Constructor for XY_GraphPane.java
	 */
	public XY_GraphPane()
	{
		super();
		try
		{
			jbInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	private void jbInit() throws Exception
	{
		graph=new XY_Graph();
	}

}
