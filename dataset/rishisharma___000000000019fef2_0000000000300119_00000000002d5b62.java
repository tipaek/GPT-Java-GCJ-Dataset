import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		for(int i=0;i<t;i++)
		{
			long x=s.nextInt();
			long y=s.nextInt();
			
			ArrayList<String> list=new ArrayList<>();
			
			fun(x,y,0,"",0,0,list);
			
			int min=Integer.MAX_VALUE;
			String ans="IMPOSSIBLE";
			
			for(int j=0;j<list.size();j++)
			{
				if(!list.get(j).equals("-1"))
				{
					if(list.get(j).length()<min)
					{
						min=list.get(j).length();
						ans=list.get(j);
					}
				}
			}
			
			System.out.println("Case #"+(i+1)+": "+ans);
			
		}
		
	}
	
	public static void fun(long x,long y,int power,String temp,long cx,long cy,ArrayList<String> list)
	{
		if(power==10)
		{
			if(cx==x&&cy==y)
			{
				list.add(temp);
				return;
			}
			else
			{
				return;
			}
		}
		else if(cx==x&&cy==y)
		{
			list.add(temp);
			return;
		}
		
		long add=(long)Math.pow(2,power);
		
		fun(x,y,power+1,temp+"E",cx+add,cy,list);
		fun(x,y,power+1,temp+"W",cx-add,cy,list);
		fun(x,y,power+1,temp+"N",cx,cy+add,list);
		fun(x,y,power+1,temp+"S",cx,cy-add,list);
	}
	
}