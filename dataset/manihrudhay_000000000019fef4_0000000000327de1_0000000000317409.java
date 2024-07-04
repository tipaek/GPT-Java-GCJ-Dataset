import java.util.*;
import java.lang.Math;
public class Solution 
{

			public static int peppurr(int x,int y,String str)
			{
				
				int min=1111;
				
				char[] ch=str.toCharArray();
				if(x==0&&y==0)
				{
					System.out.print("0");
				}
				else
				{
					int i=0;
					for(i=0;i<str.length();i++)
					{
						if((Math.abs(x)+Math.abs(y))<=i)
						{
							if(i<min)
							{
								min=i;
							}
						}
						if(ch[i]=='S')
						{
							y--;
						}
						else if(ch[i]=='N')
						{
							y++;
						}
						else if(ch[i]=='E')
						{
							x--;
						}
						else
						{
							x++;
						}
					}
					if((Math.abs(x)+Math.abs(y))<=i)
					{
						if(i<min)
						{
							min=i;
						}
					}
				
					if(min==1111)
					{
						return 0;
						
					}
					else
					{
						return min;
						
					}
					
			}
				return 0;
			}
		 public static void main(String args[])
			{
				Scanner sc=new Scanner(System.in);
				int test=sc.nextInt();
				int t=1;
				while(test!=0)
				{			
					
					int x=sc.nextInt();
					int y=sc.nextInt();
					String str=sc.next();
					int res=peppurr(x,y,str);
					if(res==0)
					{
						System.out.println("Case #"+t+": IMPOSSIBLE");
					}
					else
					{
						System.out.println("Case #"+t+": "+res);
					}
					t++;
					test--;
				}
				sc.close();
			}

		}