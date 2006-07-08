package org.amc.util;
import java.util.*;
/**
 * <p>Project: AMC</p>
 * <p>file: $URL$<p>
 * @author Adrian McLaughlin
 * @version $Revision$
 */

public class GraphNode
{

	private String label;
	private Vector<GraphNode> edges;
	private Vector<String> entry;

	/**
	 * 
	 * Constructor for GraphNode.java
	 * @param label
	 */
	public GraphNode(String label)
	{
		this.label = label;
		edges = new Vector<GraphNode>();
		entry = new Vector<String>();

	}
	/**
	 * add GraphNode as a child
	 * @param n
	 * @param value
	 */
	public void addEdge(GraphNode n, String value)
	{
		edges.addElement(n);
		entry.addElement(value);
	}
	/**
	 * 
	 * @return children
	 */
	public Enumeration edges()
	{
		return edges.elements();
	}
	/**
	 * 
	 * @return children's labels
	 */
	public Enumeration entries()
	{
		return entry.elements();
	}

	/**
	 * 
	 * @return list in depth First search order
	 */
	public Enumeration depthFirstSearch()
	{
		Vector<GraphNode> visited = new Vector<GraphNode>();
		depthFirstSearch(visited);
		return visited.elements();
	}
	
	private void depthFirstSearch(Vector<GraphNode> visited)
	{

		visited.addElement(this);
		for (Enumeration e = this.edges(); e.hasMoreElements();)
		{

			GraphNode g = (GraphNode) e.nextElement();
			if (visited.indexOf(g) == -1)
			{
				g.depthFirstSearch(visited);

			}

		}

	}

	/**
	 * 
	 * @return list in breath First search order
	 */
	public Enumeration breadthFirstSearch()
	{
		Vector<GraphNode> queue = new Vector<GraphNode>();
		Vector<GraphNode> visited = new Vector<GraphNode>();
		enqueue(queue, this);
		visited.addElement(this);
		while (!queue.isEmpty())
		{
			GraphNode n = (GraphNode) dequeue(queue);
			for (Enumeration e = n.edges(); e.hasMoreElements();)
			{
				GraphNode n2 = ((GraphNode) e.nextElement());
				if (visited.indexOf(n2) == -1)
				{
					visited.addElement(n2);
					enqueue(queue, n2);

				}
			}
		}

		return visited.elements();

	}
	/**
	 *	BFS needs a queue. These functions might come in handy;
	 *	they can be used to treat a Vector as a queue.
	 *	Use them like so:
	 *	Vector queue = new Vector();
	 *	enqueue(queue, "hello");
	 *	String hello = (String) dequeue(hello);
	 *	boolean empty = queue.isEmpty(); // will return "true"
	 *	etc
	 *	Feel free to modify these functions if you want!
	 */
	private void enqueue(Vector<GraphNode> queue, GraphNode item)
	{
		queue.addElement(item);

	}
	/**
	 * 
	 * @param queue
	 * @return GraphNode that has just been dequeued.
	 */
	private GraphNode dequeue(Vector<GraphNode> queue)
	{
		GraphNode o = queue.firstElement();
		queue.removeElementAt(0);
		return o;
	}
	/**
	 * 
	 * @return Label 
	 */
	public String getLabel()
	{
		return label;
	}

}
