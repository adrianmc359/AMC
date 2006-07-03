package org.amc.swing.graph;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jul 2, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class XAxis_Numbered extends JLabel
{
	private int intervals;
	private double range;
	public XAxis_Numbered(double range,int intervals)
	{
		super();
		this.intervals=intervals;
		this.range=range;
	}
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D)g;
		double height=this.getSize().getHeight();
		double width=this.getSize().getWidth();
		Point2D.Float a =new Point2D.Float(0,1);
		Point2D.Float b =new Point2D.Float((float)width,1);
		Line2D.Float y_line=new Line2D.Float(a,b);
		g2d.draw(y_line);
		float[] x_divisions=AbstractGraph.getlineDivisions(0,width,intervals);
		float increment=(float)range/intervals;
		float index=increment;
		for(int i=0;i<x_divisions.length;i++)
		{
			
			Line2D.Float line=new Line2D.Float(x_divisions[i],(float)a.getY(),x_divisions[i],(float)a.getY()+10);
			g2d.draw(line);
			g.drawString(String.valueOf(index),(int)x_divisions[i],20);
			index=index+increment;
		}
	}

}
