import java.io.*;
import java.util.Scanner;
class Solution
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
		//	System.out.println(" C "+c);
			if(ch=='N')
				ty=ty+1;
			else if(ch=='S')
				ty=ty-1;
			else if(ch=='E')
				tx=tx+1;
			else if(ch=='W')
				tx=tx-1;
		for(i=0;i<pos[1].length()-1;i++)
		{
		    if((tx==cx)&&(ty==cy))
				break;
		   // System.out.println("cx "+cx+"  cy "+cy+" tx "+tx+" ty "+ty);
			char c=pos[1].charAt(i+1);
		//	System.out.println(" C "+c);
			if(c=='N')
				ty=ty+1;
			else if(c=='S')
				ty=ty-1;
			else if(c=='E')
				tx=tx+1;
			else if(c=='W')
				tx=tx-1;
			
			if((tx==cx)&&(ty==cy))
				break;
			
			int tempx=calcDist(tx,cx);
			int tempy=calcDist(ty,cy);
			if(tempx==0)
			{
			    if(ty>0)
				{
					cy=cy+1;
				}
				else
					cy=cy-1;
			}
			else if(tempy==0)
			{
			    if(tx>0)
					cx=cx+1;
				else
					cx=cx-1;
			}
			else if(tempx<tempy)
			{
				if(ty>0)
				{
					cy=cy+1;
				}
				else
					cy=cy-1;
			}
			else
			{
				if(tx>0)
					cx=cx+1;
				else
					cx=cx-1;
			}

			if((tx==cx)&&(ty==cy))
				break;
				
		}
		if(tx==cx&&ty==cy)
		{
		    if(i==pos[1].length()-1)
			    return i+1;
		    else
		        return i+2;
		}
	    	int tempx=calcDist(tx,cx);
			int tempy=calcDist(ty,cy);
			if(tempx==0)
			{
			    if(ty>0)
				{
					cy=cy+1;
				}
				else
					cy=cy-1;
			}
			else if(tempy==0)
			{
			    if(tx>0)
					cx=cx+1;
				else
					cx=cx-1;
			}
			else if(tempx<tempy)
			{
				if(ty>0)
				{
					cy=cy+1;
				}
				else
					cy=cy-1;
			}
			else
			{
				if(tx>0)
					cx=cx+1;
				else
					cx=cx-1;
			}

		if(tx!=cx||ty!=cy)
			return -1;
		else if(i==pos[1].length())
			return i;
		else
		    return i+1;
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
	