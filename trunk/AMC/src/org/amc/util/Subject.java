package org.amc.util;



/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/util/Subject.java $<p>
 * <p>Created on May 22, 2006</p>
 * @author adrian
 * @version $Revision: 472 $
 */

public interface Subject
{
	/**
	 * Method to register Observers
	 * @param O The Object observing
	 */
	public abstract void attachObserver(MyObserver O);
	/**
	 * notify Observers
	 * @param obj = Object passed to observers
	 */
	public abstract void notifyObservers(Object obj);
	/**
	 * 
	 * @param O Observer to be removed
	 */
	public void  removeObserver(MyObserver O);

}