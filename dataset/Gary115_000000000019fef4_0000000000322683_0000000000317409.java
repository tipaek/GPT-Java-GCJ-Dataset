import java.lang.*;
import java.util.*;
public class Solution {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			/*String str=s.nextLine();
			String arr[]=str.split(" ");
			int xp=Integer.parseInt(arr[0]);
			int yp=Integer.parseInt(arr[1]);
			String st=arr[2];*/
			int xp=s.nextInt();
			int yp=s.nextInt();
			String st=s.next();
			//System.out.println(xp+" "+yp+" "+st);
			int len=st.length();
			int x=0;
			int y=0;
			boolean stat=true;
			if(!st.contains("E") && !st.contains("W"))
			{
			for(int j=0;j<len;j++)
			{
				if(st.charAt(j)=='E')
				{
					xp++;
				}
				else if(st.charAt(j)=='W')
				{
					xp--;
				}
				else if(st.charAt(j)=='N')
				{
					yp++;
				}
				else
				{
					yp--;
				}
				if(xp!=x)
				{
					if(xp>0)
					{
					x++;
					}
					else
					{
						x--;
					}
				}
				else if( yp!=y)
				{
					if(yp>0)
					{
						y++;
					}
					else
					{
						y--;
					}
				}
				
				
				if(xp==x && yp==y)
				{
					stat=false;
					System.out.println("Case #"+i+": "+(j+1));
					break;
				}
			}
			if(stat==true)
			{
			System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
			}
			
			}
			else
			{
				int xf=xp;
				int yf=yp;
				for(int j=0;j<len;j++)
				{
					if(st.charAt(j)=='E')
					{
						xf++;
					}
					else if(st.charAt(j)=='W')
					{
						xf--;
					}
					else if(st.charAt(j)=='N')
					{
						yf++;
					}
					else
					{
						yf--;
					}
				}
				for(int j=0;j<len;j++)
				{
					if(st.charAt(j)=='E')
					{
						xp++;
					}
					else if(st.charAt(j)=='W')
					{
						xp--;
					}
					else if(st.charAt(j)=='N')
					{
						yp++;
					}
					else
					{
						yp--;
					}
					
					if(xf!=x)
					{ 
						if(xf>0)
							{x++;
							}
						
						else
							
						{
							x--;
						}
					}
					else if(yf!=y)
					{
						if(yf>0)
						{
							y++;
						}
						else
						{
							y--;
						}
					}
					
					if(xp==x && yp==y)
					{
						stat=false;
						System.out.println("Case #"+(i+1)+": "+(j+1));
						break;
					}
			}
				if(stat==true)
				{
				System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
				}
			
		}
			
	}
		
		
		
		
}
}
