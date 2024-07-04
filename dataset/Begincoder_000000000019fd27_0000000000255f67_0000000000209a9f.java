

import java.util.*;
import java.lang.*;
import java.io.*;


class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		int n,ld,x,p,i,counter=0,a,q; String lt="",rt="",s="";
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		String s1[]=new String[t];
		if(t>=1 && t<=100)
		{
		while(ch!=t)
		{
		n=sc.nextInt();
		
	x=digits(n);
	p=n;
	while(n!=0)
	{
		ld=n%10;
		if(ld!=0)
		{
		for(i=2;i<x;i++)
		{
			q=n%((int)Math.pow(10,i));
			if(q==ld)
			counter++;
			else
			break;
		}
		if(counter>0)
		{
			a=n%((int)Math.pow(10,counter+1));
			for(i=0;i<ld;i++)
			{
				lt=")"+lt;
				rt=rt+"(";
			}
			s=lt+a+rt+s;
			n=n/((int)Math.pow(10,counter+1));
			counter=0;
		}
		else
		{
		s="("+ld+")"+s;	
		n=n/10;
    	}
	    counter=0;
		}
		else
		{
		    s=ld+s;
		    n/=10;
		    counter=0;
		}
	}
	s1[ch]=s;
	s="";
	lt="";
	rt="";
	ch++;
		}
		for(i=0;i<ch;i++)
	System.out.println("Case #"+(i+1)+":"+s1[i]);
	}
}
static int digits(int n)
{
	int c=0;
	while(n!=0)
	{
		c++;
		n/=10;
	}
	return c;
	
}
}
