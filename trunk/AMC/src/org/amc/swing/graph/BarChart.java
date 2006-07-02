package org.amc.swing.graph;
/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jul 2, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class BarChart extends AbstractGraph
{

	/**
	 * Constructor for BarChart.java
	 */
	public BarChart()
	{
		super();
	}

	/**
	 * Constructor for BarChart.java
	 * @param x_values
	 * @param y_values
	 */
	public BarChart(String[] x_values, double[] y_values)
	{
		super(x_values, y_values);
	}

	/**
	 * Constructor for BarChart.java
	 * @param title
	 * @param x_axis
	 * @param y_axis
	 * @param x_values
	 * @param y_values
	 */
	public BarChart(String title, String x_axis, String y_axis,
			Object[] x_values, double[] y_values)
	{
		super(title, x_axis, y_axis, x_values, y_values);
	}

}
