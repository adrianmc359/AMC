package org.amc.util;
import java.util.Vector;
import java.util.Enumeration;

/**
 * <p>
 * Project: APL_Problem_Database
 * </p>
 * <p>
 * file: $URL$
 * <p>
 * <p>
 * Created on May 7, 2006
 * </p>
 * 
 * @author adrian
 * @version $Revision$
 */

public class DefaultSubject implements Subject
{
	private Vector<MyObserver> observers;
	/**
	 * 
	 * Constructor for DefaultSubject.java
	 */
	public DefaultSubject()
	{
		super();
		observers=new Vector<MyObserver>();
			
	}
	/**
	 * @see org.amc.util.Subject#attachObserver(org.amc.util.MyObserver)
	 */
	public void attachObserver(MyObserver O)
	{
		observers.addElement(O);
	}
	/**
	 * @see org.amc.util.Subject#notifyObservers(java.lang.Object)
	 */
	public void notifyObservers(Object obj)
	{
		for(Enumeration e=observers.elements();e.hasMoreElements();)
		{
			MyObserver O =(MyObserver)e.nextElement();
			O.update(this,obj);
		}
		
	}
	public void removeObserver(MyObserver O)
	{
		observers.remove(O);
	}
}
