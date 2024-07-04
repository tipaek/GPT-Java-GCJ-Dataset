/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int x,y;
		x=5;
		y=6;
		// your code goes here
		Ideone obj=new Ideone();
		System.out.println("In main: before swapping x="+x+" y="+y);
		obj.swap(x,y);
		System.out.println("In main: after swapping x="+x+" y="+y);
	}
	void swap(int x, int y)
	{
		System.out.println("In swap: before swapping x="+x+" y="+y);
		int temp;
		temp=x;
		x=y;
		y=temp;
		System.out.println("In swap: after swapping x="+x+" y="+y);
	}
}