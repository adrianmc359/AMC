package org.amc.swing;
import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import org.amc.swing.XY_GraphPane.AxisDecorator;
import org.amc.swing.graph.*;
import org.amc.util.Utils;
/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jul 2, 2006</p>
 * <BIG>A Bar Chart</BIG>
 * @author adrian
 * @version $Revision$
 */

public class BarChart_Pane  extends JPanel implements Graph
{

	private BarChart graph;
	private MyCanvas mycanvas; /** This is where the chart goes. */
	private X_Axis x_axis;
	private Y_Axis y_axis;
	private int y_intervals; /** The number of divisions in the Y axis */
	private double range;	/** The data range */ 
	/**
	 * 
	 * Constructor for BarChart_Pane.java
	 * @param labels for the bars
	 * @param y_values the values for each bar.
	 * @param range The data range
	 * @param y_intervals The height for the bars 
	 */
	public BarChart_Pane(String[] labels,double[] y_values,double range,int y_intervals)
	{
		super();
		graph=new BarChart(labels,y_values);
		this.y_intervals=y_intervals;
		this.range=range;
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
		JPanel south=new JPanel(new BorderLayout()); // X Axis goes here. 
		
		mycanvas=new MyCanvas(graph,range); 
		this.setLayout(new BorderLayout());
		add(mycanvas,BorderLayout.CENTER);
		
		//setting up axis.
		x_axis=new X_Axis(0,this.graph.getX_values().length);
		y_axis=new Y_Axis(0,range,y_intervals);
		y_axis.setPreferredSize(new Dimension(50,50));
		add(y_axis,BorderLayout.WEST);
		x_axis.setPreferredSize(new Dimension(500,50));
		
		south.add(x_axis,BorderLayout.CENTER);
		//A filler is required to line up the X-axis wth the graph.
		JLabel filler=new JLabel();
		filler.setPreferredSize(new Dimension(50,50));
		south.add(filler,BorderLayout.WEST);
		add(south,BorderLayout.SOUTH);
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getTitle()
	 */
	public String getTitle()
	{
		return graph.getTitle();
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setTitle(java.lang.String)
	 */
	public void setTitle(String title)
	{
		graph.setTitle(title);

		
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getX_axis()
	 */
	public String getX_axis()
	{
		return graph.getX_axis();
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setX_axis(java.lang.String)
	 */
	public void setX_axis(String x_axis)
	{
		graph.setX_axis(x_axis);

	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getX_values()
	 */
	public Object[] getX_values()
	{
		return graph.getX_values();
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setX_values(java.lang.Object[])
	 */
	public void setX_values(Object[] x_values)
	{
		graph.setX_values(x_values);
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getY_axis()
	 */
	public String getY_axis()
	{
		return graph.getY_axis();
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setY_axis(java.lang.String)
	 */
	public void setY_axis(String y_axis)
	{
		graph.setY_axis(y_axis);
	
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#getY_values()
	 */
	public double[] getY_values()
	{
		return graph.getY_values();
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#setY_values(double[])
	 */
	public void setY_values(double[] y_values)
	{
		graph.setY_values(y_values);
	}
	/**
	 * 
	 * @see org.amc.swing.graph.Graph#noOfDataSets()
	 */
	public int noOfDataSets()
	{
		return graph.noOfDataSets();
	}
	class MyCanvas extends Canvas
	{
		/**
		 * \enum colours for the bars
		 */
		private  Color[] colours={
						new Color(255,66,66),
						new Color(255,143,203),
						Color.BLUE,
						Color.GREEN,
						new Color(61,240,121),
						new Color(162,162,248),
						new Color(120,75,219),
						new Color(255,73,252)
						};
		private  Graph graph;
		private double range; 
		public MyCanvas(Graph graph,double range)
		{
			super();
			this.range=range;
			this.graph=graph;
		}
		@Override
		public void paint(Graphics g)
		{
			super.paint(g);
			Graphics2D g2d=(Graphics2D)g;
			double height=this.getSize().getHeight();
			double width=this.getSize().getWidth();
			//conversion value
			double y_ratio=height/range;
			//Dividing up the X axis into segments
			float[] x_divisions=AbstractGraph.getlineDivisions(0,width,graph.getX_values().length);
			
			//determing the Bar width if values are given
			double bar_width=0;
			if(x_divisions.length>0)
			{
				bar_width=x_divisions[1]-x_divisions[0];
			}
			double position=0;// the bottom left corner of the Rectangle
			int colour=0;
			for(int i=0;i<graph.noOfDataSets();i++)
			{
				double y_value=graph.getY_values()[i]*y_ratio;
				// Filled Rectangle
				Rectangle2D.Double rec=new Rectangle2D.Double(position,height-y_value,bar_width,height);
				// Outline Rectangle
				Rectangle2D.Double rec_outline=new Rectangle2D.Double(position,height-y_value,bar_width,height);
				g2d.setColor(colours[colour]);
				//use the colours 
				if(colour<colours.length-1)
				{
					colour++;
				}
				else
				{
					colour=0;
				}
				g2d.fill(rec);
				g2d.draw(rec);
				g2d.setColor(Color.BLACK);
				g2d.draw(rec_outline);
				position=position+bar_width;
			}
			g2d.dispose();
			
			
		}
		
		
	}
	public static void main(String[] args)
	{
		
		JFrame frame =new JFrame("Testing BarChart");
		frame.setSize(500,500);
		frame.setLayout(new BorderLayout());
		frame.addWindowListener(new WindowAdapter()
		{

			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosed(e);
				System.exit(0);
			}
			
		});
		String[] x={"Burn Marks","Shorts","Weldlines","flash","scratches","Burn Marks","Shorts","Weldlines","flash","scratches"};
		double[] y={10,30,50,10,40,10,30,50,10,40};
		BarChart_Pane bar_chart=new BarChart_Pane(x,y,200,20);
		
		bar_chart.setTitle("My Graph");
		bar_chart.setX_axis("X axis");
		bar_chart.setY_axis("Y axis");
		bar_chart.setX_values(x);
		bar_chart.setY_values(y);
		frame.add(bar_chart,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	class X_Axis extends JLabel
	{
		private int start_position;

		private int intervals;
		public X_Axis(int start_position,int intervals)
		{
			super();
			this.start_position=start_position;
			this.intervals=intervals;
		}
	
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D)g;
			double height=this.getSize().getHeight();
			double width=this.getSize().getWidth();
			
			Point2D.Float b =new Point2D.Float(start_position,(float)height/2);
			Point2D.Float c =new Point2D.Float((float)width,(float)height/2);
			Line2D.Float x_line=new Line2D.Float(0,0,(int)width,0);
			
			g2d.draw(x_line);
			
			
			float[] x_divisions=AbstractGraph.getlineDivisions((int)b.getX(),width,intervals);
			for(int i=0;i<x_divisions.length;i++)
			{
				Line2D.Float line=new Line2D.Float(x_divisions[i],(float)b.getY()-10,x_divisions[i],(float)b.getY()+10);
				g2d.draw(line);
				
			}
			float bar_width=0;
			if(x_divisions.length>0)
			{
				bar_width=x_divisions[1]-x_divisions[0];
			}
			float position=0;
			for(int i=0;i<graph.noOfDataSets();i++)
			{
				g2d.drawString((String)graph.getX_values()[i],position+5,(float)height/2);
				position=position+bar_width;
			}
		}
		
	}
	class Y_Axis extends JLabel
	{
		private int start_position;
		private int intervals;
		private double range;
		public Y_Axis(int start_position,double range,int intervals)
		{
			super();
			this.start_position=start_position;
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
			Point2D.Float a =new Point2D.Float((float)width-1,00);
			Point2D.Float b =new Point2D.Float((float)width-1,(float)height);
			Line2D.Float y_line=new Line2D.Float(a,b);
			g2d.draw(y_line);
			float[] y_divisions=AbstractGraph.getlineDivisions(0,height,intervals);
			float increment=(float)range/intervals;
			float index=(float)range-increment;
			for(int i=0;i<y_divisions.length;i++)
			{
				
				Line2D.Float line=new Line2D.Float((float)a.getX()-10,y_divisions[i],(float)a.getX(),y_divisions[i]);
				g2d.draw(line);
				g.drawString(String.valueOf(index),0,(int)y_divisions[i]);
				index=index-increment;
			}
		}
		
	}
}
