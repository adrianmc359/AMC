package org.amc.text;


/* A 1.4 class used by TextComponentDemo.java. */

import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;


public class DocumentSizeFilter extends DocumentFilter
{
	int maxCharacters;

	boolean DEBUG = true;

	public DocumentSizeFilter(int maxChars)
	{
		maxCharacters = maxChars;
	}

	public void insertString(FilterBypass fb, int offs, String str,
			AttributeSet a) throws BadLocationException
	{
		if (DEBUG)
		{
			System.out.println("str:"+str);
		}
		// This rejects the entire insertion if it would make
		// the contents too long. Another option would be
		// to truncate the inserted string so the contents
		// would be exactly maxCharacters in length.
	
		if (((fb.getDocument().getLength() + str.length()) <= maxCharacters)&& !str.equals("\n"))
		{
			super.insertString(fb, offs, str, a);
		}
		else
		{
			Toolkit.getDefaultToolkit().beep();
		}
	}

	public void replace(FilterBypass fb, int offs, int length, String str,
			AttributeSet a) throws BadLocationException
	{
		if (DEBUG)
		{
			System.out.println("str:"+fb.getDocument().getLength());
		}
		// This rejects the entire replacement if it would make
		// the contents too long. Another option would be
		// to truncate the replacement string so the contents
		// would be exactly maxCharacters in length.
		if (((fb.getDocument().getLength() + str.length()) <= maxCharacters)&& !str.equals("\n"))
		{
			super.replace(fb, offs, length, str, a);
		}
		else
		{
			Toolkit.getDefaultToolkit().beep();
		}
	}

}
