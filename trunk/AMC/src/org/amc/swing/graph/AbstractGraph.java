package org.amc.swing.graph;

import org.amc.util.DefaultSubject;

/**
 * <p>Project: Graph </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 30, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public abstract class AbstractGraph extends DefaultSubject implements Graph
{
	private String title="";
	private String x_axis="";
	private String y_axis="";
	private double[] y_values; /** length of y_values must equal x_values */ 
	private Object[] x_values; /** length of x_values must equal y_values */
	/**
	 * Constructor for AbstractGraph.java
	 */
	public AbstractGraph()
	{
		//Default an empty graph
		this("","","",new Object[0],new double[0]);
		
		
	}
	/**
	 * 
	 * Constructor for AbstractGraph.java
	 * @param title
	 * @param x_axis
	 * @param y_axis
	 * @param x_values
	 * @param y_values
	 */
	public AbstractGraph(Object[] x_values,double[] y_values)
	{
		this("","","",x_values,y_values);
	}
	public AbstractGraph(String title,String x_axis,String y_axis,Object[] x_values,double[] y_values)
	{
		this.title=title;
		this.x_axis=x_axis;
		this.y_axis=y_axis;
		this.x_values=x_values;
		this.y_values=y_values;
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getTitle()
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setTitle(java.lang.String)
	 */
	public void setTitle(String title)
	{
		this.title=title;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getX_axis()
	 */
	public String getX_axis()
	{
		return x_axis;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setX_axis(java.lang.String)
	 */
	public void setX_axis(String x_axis)
	{
		this.x_axis = x_axis;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getX_values()
	 */
	public Object[] getX_values()
	{
		return x_values;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setX_values(java.lang.Object[])
	 */
	public void setX_values(Object[] x_values)
	{
		this.x_values = x_values;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getY_axis()
	 */
	public String getY_axis()
	{
		return y_axis;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setY_axis(java.lang.String)
	 */
	public void setY_axis(String y_axis)
	{
		this.y_axis = y_axis;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getY_values()
	 */
	public double[] getY_values()
	{
		return y_values;
	}

	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setY_values(double[])
	 */
	public void setY_values(double[] y_values)
	{
		this.y_values = y_values;
	}

	/**
	 * @see org.amc.swing.graph.Graph#noOfDataSets()
	 */
	public int noOfDataSets()
	{
		if(y_values.length<x_values.length)
		{
			return y_values.length;
		}
		else
		{
			return x_values.length;
		}
	}
	public static float[] getlineDivisions(int start_position,double length,int intervals)
	{
		float[] positions=new float[intervals-1];
		double increment=length/intervals;
		for(int i=0;i<intervals-1;i++)
		{
			positions[i]=start_position+(float)(increment*(i+1));
		}
		return positions;
		
	}

}
