

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			int n=sc.nextInt();
			ArrayList<Character> ch=new ArrayList<Character>();
			ArrayList<Integer> startc=new ArrayList<Integer>();
			ArrayList<Integer> endc=new ArrayList<Integer>();
			ArrayList<Integer> startj=new ArrayList<Integer>();
			ArrayList<Integer> endj=new ArrayList<Integer>();
			
			int start[]=new int[n];
			int end[]=new int[n];
			for(int i=0;i<n;i++)
			{
				start[i]=sc.nextInt();
				end[i]=sc.nextInt();
			}
			ch.add('C');
			ch.add('J');
			startc.add(start[0]);
			endc.add(end[0]);
			startj.add(start[1]);
			endj.add(end[1]);
			int flag=0;
			for(int i=2;i<n;i++)
			{
				int c=0,jad=0;
				for(int j=0;j<startc.size();j++)
				{
					if((start[i]>=startc.get(j) && end[i]<=endc.get(j)) ||(start[i]<startc.get(j) && end[i]>startc.get(j))||(start[i]<endc.get(j) && end[i]>endc.get(j)) )
					{
						c=1;
					}
				}
				
				if(c==0)
				{
					ch.add('C');
					startc.add(start[i]);
					endc.add(end[i]);
				}
				else
				{
					for(int j=0;j<startj.size();j++)
					{
						if((start[i]>=startj.get(j) && end[i]<=endj.get(j)) ||(start[i]<startj.get(j) && end[i]>startj.get(j))||(start[i]<endj.get(j) && end[i]>endj.get(j)) )
						{
							jad=1;
						}
					}
				}
				
				if(jad==0 && c==1)
				{
					ch.add('J');
					startj.add(start[i]);
					endj.add(end[i]);
				}
				else if(jad==1 && c==1)
				{
				  flag=1;
				  break;
				}
				
			}
			if(flag==1)
			{
				System.out.println("Case "+"#"+t+":"+" "+"IMPOSSIBLE");
				
			}
			else
			{
				System.out.print("Case "+"#"+t+":"+" ");
				for(int i=0;i<ch.size();i++)
					System.out.print(ch.get(i)+"");
				
				System.out.println();
			}
			
			
		}

}
}
