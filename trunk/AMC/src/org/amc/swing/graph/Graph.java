package org.amc.swing.graph;
/**
 * <p>Project: Graph </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 30, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public interface Graph
{
	public String getTitle();
	public void setTitle(String title);
	/**
	 * @return Returns the x_axis.
	 */
	public String getX_axis();

	/**
	 * @param x_axis The x_axis to set.
	 */
	public void setX_axis(String x_axis);

	/**
	 * @return Returns the x_values.
	 */
	public Object[] getX_values();

	/**
	 * @param x_values The x_values to set.
	 */
	public void setX_values(Object[] x_values);

	/**
	 * @return Returns the y_axis.
	 */
	public String getY_axis();

	/**
	 * @param y_axis The y_axis to set.
	 */
	public void setY_axis(String y_axis);

	/**
	 * @return Returns the y_values.
	 */
	public double[] getY_values();

	/**
	 * @param y_values The y_values to set.
	 */
	public void setY_values(double[] y_values);
	public int noOfDataSets();
}
