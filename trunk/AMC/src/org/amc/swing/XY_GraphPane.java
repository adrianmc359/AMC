package org.amc.swing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.*;
import org.amc.swing.graph.*;
import org.amc.util.Utils;


/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jun 30, 2006</p>
 * A View of XY graph
 * @author adrian
 * @version $Revision$
 */

public class XY_GraphPane extends JPanel implements Graph
{
	private XY_Graph graph;
	private JLabel title;
	private JLabel x_axis_label;
	private JLabel y_axis_label;
	private MyCanvas canvas=new MyCanvas();
	private int x_range;
	private int y_range;
	private int x_interval;
	private int y_interval;
	/**
	 * 
	 * Constructor for XY_GraphPane.java
	 */
	public XY_GraphPane(int x_range,int y_range,int x_interval,int y_interval)
	{
		super();
		this.x_range=x_range;
		this.y_range=y_range;
		this.x_interval=x_interval;
		this.y_interval=y_interval;
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
		this.setLayout(new BorderLayout());
		
		title=new JLabel(graph.getTitle());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		x_axis_label=new JLabel(graph.getX_axis());
		x_axis_label.setHorizontalAlignment(SwingConstants.CENTER);
		y_axis_label=new JLabel(graph.getY_axis());
		y_axis_label.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(canvas,BorderLayout.CENTER);
		//this.add(title,BorderLayout.NORTH);
		//this.add(x_axis_label,BorderLayout.SOUTH);
		//this.add(y_axis_label,BorderLayout.WEST);
		
	}
	

	public String getTitle()
	{
		return graph.getTitle();
	}
	public void setTitle(String title)
	{
		graph.setTitle(title);
		this.title.setText(graph.getTitle());
		this.title.repaint();
		
	}
	public String getX_axis()
	{
		return graph.getX_axis();
	}
	public void setX_axis(String x_axis)
	{
		graph.setX_axis(x_axis);
		x_axis_label.setText(graph.getX_axis());
	}
	public Object[] getX_values()
	{
		return graph.getX_values();
	}
	public void setX_values(Object[] x_values)
	{
		graph.setX_values(x_values);
	}
	public String getY_axis()
	{
		return graph.getY_axis();
	}
	public void setY_axis(String y_axis)
	{
		graph.setY_axis(y_axis);
		y_axis_label.setText(graph.getY_axis());
	}
	public double[] getY_values()
	{
		return graph.getY_values();
	}
	public void setY_values(double[] y_values)
	{
		graph.setY_values(y_values);
	}
	public int noOfDataSets()
	{
		return graph.noOfDataSets();
	}

	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		JFrame frame =new JFrame("Testing XY_Graph");
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
		Double[] x={10.0,20.0,30.0,40.0,50.0};
		double[] y={10,30,50,10,40};
		XY_GraphPane xy=new XY_GraphPane(60,60,6,6);
		AxisDecorator axises=xy.new AxisDecorator(xy);
		xy.setTitle("My Graph");
		xy.setX_axis("X axis");
		xy.setY_axis("Y axis");
		xy.setX_values(x);
		xy.setY_values(y);
		//frame.add(axises,BorderLayout.CENTER);
		frame.add(axises,BorderLayout.CENTER);
		frame.setVisible(true);
	}
	class MyCanvas extends JPanel
	{
		Point2D.Float a;
		Point2D.Float b;
		Point2D.Float c;
		public MyCanvas()
		{
			super();
			this.setOpaque(true);
			this.setBackground(Color.WHITE);
			this.repaint();
		}

		/**
		 * 
		 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
		 */
		@Override
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			Graphics2D g2d=(Graphics2D)g;
			double height=this.getSize().getHeight();
			double width=this.getSize().getWidth();
			
			double x_ratio=width/x_range;
			double y_ratio=height/y_range;
			Double[] x_values=(Double[])graph.getX_values();
			double[] y_values=graph.getY_values();

			Point2D.Double temp=new Point2D.Double(0.0,height);
			for(int i=0;i<graph.noOfDataSets();i++)
			{
				Point2D.Double point=new Point2D.Double(x_values[i]*x_ratio,height-y_values[i]*y_ratio);
			//	System.out.println("Datapoint=("+point.getX()+","+point.getY()+")");
				Rectangle2D.Double rec=new Rectangle2D.Double(point.getX()-5,point.getY()-5,10,10);
				g2d.draw(rec);
				Point2D.Double endPoint=new Point2D.Double(point.getX(),point.getY());
				Line2D.Double line=new Line2D.Double(temp,endPoint);
				g2d.draw(line);
				temp=endPoint;
			}
			g2d.dispose();
		}
	}
	public class AxisDecorator extends JPanel
	{
		JPanel instance=null;
		private XAxis_Numbered x_axis;
		private YAxis_Numbered y_axis;
		public  AxisDecorator(JPanel panel)
		{
			this.instance=panel;
			JPanel south=new JPanel(new BorderLayout());
			this.setLayout(new BorderLayout());
			
			y_axis=new YAxis_Numbered(y_range,y_interval);
			
			y_axis.setPreferredSize(new Dimension(50,50));
			x_axis=new XAxis_Numbered(x_range,x_interval);
			x_axis.setPreferredSize(new Dimension(100,50));
			this.add(instance,BorderLayout.CENTER);
			this.add(y_axis,BorderLayout.WEST);
			JLabel filler =new JLabel();
			filler.setPreferredSize(new Dimension(50,50));
			south.add(x_axis,BorderLayout.CENTER);
			south.add(filler,BorderLayout.WEST);
			this.add(south,BorderLayout.SOUTH);
			
		}
		
	}
}

