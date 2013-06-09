package org.amc.util;


/**
 * <p>Project: AMC </p>
 * <p>file: $URL$<p>
 * <p>Created on Jul 3, 2006</p>
 * @author adrian
 * @version $Revision$
 */

public class ASortAlgorithm
{
	double[] array;
	int pointer;
	public ASortAlgorithm(double[] array)
	{
		this.array=array;
	}
	public void sort()
	{
		pointer=0;
		
		while(pointer!=array.length)
		{
			int saved=pointer;
			for(int i=pointer+1;i<array.length;i++)
			{
				if(array[i]<array[pointer])
				{
					if(array[i]<array[saved])
					{
						saved=i;
					}
				}
			}
			if(saved!=-1)
			{
				double temp=array[saved];
				array[saved]=array[pointer];
				//System.out.println("Swapped "+array[pointer]+" and "+temp);
				array[pointer]=temp;
				
			}
			//System.out.println(toString(array));
			pointer++;
		}
	}
	public double[] getArray()
	{
		return array;
	}
	public String toString(double[] list)
	{
		String output="";
		for(double value:list)
		{
			output=output+value+" ";
		}
		return output;
	}
	public static void main(String[] args)
	{
		double[] list={2,6,3,7,1,1,3,5,6,7,4,3,3,4,22,33,4,0};
		ASortAlgorithm alg=new ASortAlgorithm(list);
		alg.sort();

	}

}
