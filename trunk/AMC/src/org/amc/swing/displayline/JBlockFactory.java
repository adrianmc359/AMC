package org.amc.swing.displayline;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.amc.swing.DisplayLine;
import org.amc.swing.JCalendarBox;

/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Oct 22, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class JBlockFactory
{
	
	
	public static DisplayLine getDescriptionBlock(Enum name)
	{
		DisplayLine line=null;
		JLabel label=new JLabel("     "+name);
		label.setPreferredSize(new Dimension(200,25));
		//txtbox=new JTextArea("test",5,10);
		JPanel txtbox=new JPanel();
		JScrollPane scroll=new JScrollPane();
		txtbox.add(scroll);
		JTextArea area=new JTextArea(8,20);
		scroll.getViewport().add(area);
		//txtbox.setPreferredSize(new Dimension(200,25));
		line=new DisplayLine(label,txtbox);
		line.registerTextComponent(area);
		return line;
	}
	public static DisplayLine getDateBlock(String name,String value)
	{
		DisplayLine line=null;
		JLabel label=new JLabel("     "+name);
		JCalendarBox datebox=new JCalendarBox();
		label.setPreferredSize(new Dimension(200,25));
		datebox.setPreferredSize(new Dimension(200,25));
		line=new DisplayLine(label,datebox);
		return  line;

	}
	public static DisplayLine getPassBlock(String name,Dimension size)
	{
		DisplayLine line;
		JCheckBox chkbox=new JCheckBox();
		JLabel label=new JLabel("     "+name);
		label.setPreferredSize(size);
		chkbox.setPreferredSize(size);
		line=new DisplayLine(label,chkbox);
		line.registerTextComponent(chkbox);
		return line;
	}
	public static DisplayLine getPassBlock(String name)
	{
		return getPassBlock(name, DisplayLine.DEFAULT_SIZE);
	}
	public static DisplayLine getSmallPassBlock(String name)
	{
		return getPassBlock(name, DisplayLine.SMALL_SIZE);
	}
	public static DisplayLine getPassBlock(Enum name)
	{
		return getPassBlock(name.toString(), DisplayLine.DEFAULT_SIZE);
	}
	
	public static DisplayLine getLabelBlock(String name,Dimension size)
	{
		DisplayLine line;
		JLabel chkbox=new JLabel();
		JLabel label=new JLabel("     "+name);
		label.setPreferredSize(size);
		chkbox.setPreferredSize(size);
		line=new DisplayLine(label,chkbox);
		line.registerTextComponent(chkbox);
		return line;
	}
	
	public static DisplayLine getLabelBlock(String name)
	{
		return getLabelBlock(name,DisplayLine.SMALL_SIZE);
	}
}
