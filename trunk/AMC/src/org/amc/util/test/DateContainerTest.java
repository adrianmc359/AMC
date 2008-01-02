package org.amc.util.test;

import java.util.Date;

import org.amc.util.DateContainer;

import junit.framework.TestCase;

/**
 * <p>Project: AMC </p>
 * <p>file: $URL$</p>
 * <p>Created on Jan 2, 2008</p>
 * @author Adrian McLaughlin
 * @version $Revision$
 */

public class DateContainerTest extends TestCase
{
	Date one=new Date();
	Date two=new Date();
	DateContainer container;
	/**
	 * Constructor for DateContainerTest.java
	 * @param name
	 */
	public DateContainerTest(String name)
	{
		super(name);
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception
	{
		super.setUp();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	/**
	 * Test method for {@link org.amc.util.DateContainer#getDate()}.
	 */
	public void testGetDate()
	{
		container=new DateContainer(one);
		assertEquals(container.getDate(), one);
		assertNotSame(container.getDate(), two);
	}

	/**
	 * Test method for {@link org.amc.util.DateContainer#toString()}.
	 */
	public void testToString()
	{
		
	}

	/**
	 * Test method for {@link org.amc.util.DateContainer#sameDate(java.util.Date)}.
	 */
	public void testSameDate()
	{
		container=new DateContainer(one);
		assertTrue(container.sameDate(two));
		
		Date three =new Date(100,11,12);
		assertFalse(container.sameDate(three));
	}

}
