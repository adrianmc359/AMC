package org.amc.util;

import java.util.Observable;


/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL: file:///home/adrian/Documents/SVNRepository/Java/APL_Problem_Database/trunk/APL_Problem_Database/src/org/amc/util/MyObserver.java $<p>
 * <p>Created on May 7, 2006</p>
 * @author adrian
 * @version $Revision: 368 $
 */

public interface MyObserver
{
	/**
	 * method called by subject to notify observer
	 * @param o The Subject calling the update
	 * @param arg Object passed by Subject
	 */
	public void update(Subject o, Object arg);
}
