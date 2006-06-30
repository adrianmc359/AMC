package org.amc.util;
import org.apache.commons.lang.StringUtils;
import javax.swing.*;
import java.awt.*;
/**
 * <p>Project: APL_Problem_Database </p>
 * <p>file: $URL$<p>
 * <p>Created on May 21, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class Utils
{
	public static String concat(String[] list,int start,int end)
	{
		if((start < end) && (end< list.length) && (start > -1))
		{
			String[] temp=new String[end-start];
			int t=0;
			for(int i=start;i<end;i++)
			{
				temp[t++]=list[i];
			}
			
			return StringUtils.join(temp,' '); 
		}
		return null;
	}
	public static int findComponent(JComponent parent,JComponent child)
	{
		Component[] comps=parent.getComponents();
		for(int i=0;i<comps.length;i++)
		{
			if(comps[i]==child)
			{
				return i;
			}
		}
		return -1;
	}
	
}
