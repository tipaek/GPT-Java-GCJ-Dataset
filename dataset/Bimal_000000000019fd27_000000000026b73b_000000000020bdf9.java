
import java.util.*;
public class Solution {
  public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int T=sc.nextInt();
	for(int t=1;t<=T;t++)
	{
		int n=sc.nextInt();
		ArrayList<Character> ch=new ArrayList<Character>();
		int start[]=new int[n];
		int end[]=new int[n];
		for(int i=0;i<n;i++)
		{
			start[i]=sc.nextInt();
			end[i]=sc.nextInt();
		}
		
		ch.add('C');
		ch.add('J');
		
		int startc=start[0];
		int endc=end[0];
		int gapsc=0;
		int gapec=0;
		
		int gapsj=0;
		int gapej=0;
		int startj=start[1];
		int endj=end[1];
		
		
		int flag=0;
		for(int k=2;k<n;k++)
		{

			if((start[k]>= endj && end[k]>=endj) ||(start[k]>=gapsj && end[k]<=gapej) )
			{
				ch.add('J');
				gapsj=endj;
				gapej=start[k];
				startj=Math.min(startj, start[k]);
				endj=Math.max(endj, end[k]);
			}
			else if((start[k]<=startj && end[k]<=startj)||(start[k]>=gapsj && end[k]<=gapej))
			{
				ch.add('J');
				gapsj=end[k];
				gapej=startj;
				startj=Math.min(startj, start[k]);
				endj=Math.max(endj, end[k]);	
			}
			else if((start[k]>= endc && end[k]>=endc) ||(start[k]>=gapsc && end[k]<=gapec))
			{
				ch.add('C');
				gapsc=endc;
				gapec=start[k];
				startc=Math.min(startc, start[k]);
				endc=Math.max(endc, end[k]);
			  
				
			}
			else if((start[k]<=startc && end[k]<=startc) ||(start[k]>=gapsc && end[k]<=gapec) )
			{
				ch.add('C');
				gapsc=end[k];
				gapec=startc;
				startc=Math.min(startc, start[k]);
				endc=Math.max(endc, end[k]);
			}
		
//				if(start[k]>=end[k-1])
//				{
//					ch.add(ch.get(k-1));
//					
//				}
//				else
//				{
//					int j=k-1;
//					flag=1;
//					while(j>=0)
//					{
//						if(start[k]>=end[j] || end[k]<=start[j])
//						{
//							ch.add(ch.get(j));
//							flag=0;
//							break;
//						}
//						j--;
//					}
//					
//				}	
			else
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
