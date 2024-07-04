import java.io.*;
import java.util.Scanner;
public class Solution
{
	public static void main(String args[])
	{
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		for(int i=0;i<t;i++)
		{
			int x=scan.nextInt();
			int y=scan.nextInt();
			String test=scan.nextLine();
			int res=calcEverything(x,y,test);
			int j=i+1;
			if(res==-1)
			{
				System.out.println("Case #"+j+": IMPOSSIBLE");
			}
			else
				System.out.println("Case #"+j+": "+res);
		}
	}
	static int calcEverything(int tx,int ty,String pos1)
	{
		int cx=0,cy=0;
		int i=0;
		String pos[]=pos1.split(" ");
		char ch=pos[1].charAt(0);
		for(i=0;i<pos[1].length();i++)
		{
		    if((tx==cx)&&(ty==cy))
				break;
		   // System.out.println("cx "+cx+"  cy "+cy+" tx "+tx+" ty "+ty);
			char c=pos[1].charAt(i);
		//	System.out.println(" C "+c);
			if(c=='N')
				ty=ty+1;
			else if(c=='S')
				ty=ty-1;
			else if(c=='E')
				tx=tx+1;
			else if(c=='W')
				tx=tx-1;
		}
		int rekt=0;
		int diffx=calcDist(tx,cx);
		int diffy=calcDist(ty,cy);
		if(diffx<0)
		    diffx=diffx*(-1);
		else if(diffy<0)
		    diffy=diffy*(-1);
		int diff=diffx+diffy;
	//	System.out.println("cx "+cx+"  cy "+cy+" tx "+tx+" ty "+ty);
	//	System.out.println(diff);
		int zz=1;
		if(diff>pos[1].length())
			return -1;
		else
		{
			for(i=pos[1].length()-1;i>=0;i--)
			{
				char c=pos[1].charAt(i);
		//	System.out.println(" C "+c);
			if(c=='N')
				ty=ty-1;
			else if(c=='S')
				ty=ty+1;
			else if(c=='E')
				tx=tx-1;
			else if(c=='W')
				tx=tx+1;
			diffx=calcDist(tx,cx);
		diffy=calcDist(ty,cy);
		if(diffx<0)
		    diffx=diffx*(-1);
		else if(diffy<0)
		    diffy=diffy*(-1);
		diff=diffx+diffy;
			if(diff<=pos[1].length()-zz)
				rekt=i;
			zz++;
			
			}
		}
		if(rekt==0)
			return pos[1].length();
		else
			return rekt;
	}
	static int calcDist(int a,int b)
	{
		if(a<0&&b<0)
		{
			if(a>b)
			{
				a=a*1;
				return a+b;
			}
			else
			{
				b=b*1;
				return a+b;
			}
		}
		else if(a<0)
		{
			a=a*1;
			return a+b;
		}
		else if(b<0)
		{
			b=b*1;
			return a+b;
		}
		else
		{
			if(a>b)
				return a-b;
			else 
				return b-a;
		}
	}
}
	