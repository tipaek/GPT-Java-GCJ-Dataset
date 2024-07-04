import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			long x=s.nextLong();
			long y=s.nextLong();
			
			long fx=x;
			long fy=y;
			
			if(Math.abs(x)%2+Math.abs(y)%2==1)
			{
				int[] seq=new int[100];
				char[] print=new char[100];
				
				if(Math.abs(x)%2==0)
				{
					char dx='a';
					char dy='a';
					
					if(x>0)
					{
						dx='E';
					}
					else
					{
						dx='W';
					}
					
					x=Math.abs(x);
					
					while(x>0)
					{
						long power=(long)(Math.log(x)/Math.log(2));
						seq[(int)power]++;
						print[(int)power]=dx;
						
						power=(long)Math.pow(2,power);
						x=x-power;
					}
					
					long next=0;
					
					for(int j=1;j<100;j++)
					{
						if(seq[j]==0)
						{
							next=j;
							break;
						}
					}
					
					if(y>0)
						dy='N';
					else
						dy='S';
					
					y=Math.abs(y);
					
					if(y>=Math.pow(2,next))
					{
						if(dy=='N')
						{
							print[0]='N';
						}
						else
						{
							print[0]='S';
						}
					}
					else if(y<Math.pow(2,next))
					{
						if(dy=='N')
						{
							print[0]='S';
						}
						else
						{
							print[0]='N';
						}
					}
					else
					{
						System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
					}
					
					for(int j=(int)next;j<100;j++)
					{
						if(seq[j]==0)
						{
							print[j]=dy;
						}
					}
					
					//print
					
					System.out.print("Case #"+(i+1)+": ");
					print(seq,print,fx,fy,0,0);
					
				}
				else
				{
					char dx='a';
					char dy='a';
					
					if(y>0)
					{
						dy='N';
					}
					else
					{
						dy='S';
					}
					
					y=Math.abs(y);
					
					while(y>0)
					{
						long power=(long)(Math.log(y)/Math.log(2));
						seq[(int)power]++;
						print[(int)power]=dx;
						
						power=(long)Math.pow(2,power);
						y=y-power;
					}
					
					long next=0;
					
					for(int j=1;j<100;j++)
					{
						if(seq[j]==0)
						{
							next=j;
							break;
						}
					}
					
					
					
					if(x>=0)
						dx='E';
					else
						dx='W';
					
					x=Math.abs(x);
					
					if(x>=Math.pow(2,next))
					{
						if(dx=='E')
						{
							print[0]='E';
						}
						else
						{
							print[0]='W';
						}
					}
					else if(x<Math.pow(2,next))
					{
						if(dy=='E')
						{
							print[0]='W';
						}
						else
						{
							print[0]='E';
						}
					}
					else
					{
						System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
					}
					
					for(int j=(int)next;j<100;j++)
					{
						if(seq[j]==0)
						{
							print[j]=dx;
						}
					}
					
					System.out.print("Case #"+(i+1)+": ");
					print(seq,print,fx,fy,0,0);
				}
			}
			else
			{
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			}
			
		}
	}
	
	public static void print(int[] seq,char[] print,long x,long y,long cx,long cy)
	{
		for(int i=0;i<100;i++)
		{
			if(cx==x&&cy==y)
			{
				System.out.println();
				break;
			}
			else if(print[i]=='E')
			{
				long power=i;
				System.out.print('E');
				cx=cx+(long)Math.pow(2,power);
			}
			else if(print[i]=='W')
			{
				long power=i;
				System.out.print('W');
				cx=cx-(long)Math.pow(2,power);
			}
			else if(print[i]=='N')
			{
				long power=i;
				System.out.print('N');
				cy=cy+(long)Math.pow(2,power);
			}
			else if(print[i]=='S')
			{
				long power=i;
				System.out.print('S');
				cy=cy-(long)Math.pow(2,power);
			}
		}
	}
	
}