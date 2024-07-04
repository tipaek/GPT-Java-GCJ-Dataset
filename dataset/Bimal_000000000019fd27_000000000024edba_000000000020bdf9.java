
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
		int startj=start[1];
		int endj=end[1];
		
		
		int flag=0;
		for(int k=2;k<n;k++)
		{
			if((start[k]>= endj && end[k]>=endj) || (start[k]<=startj && end[k]<=startj))
			{
				ch.add('J');
				startj=Math.min(startj, start[k]);
				endj=Math.max(endj, end[k]);
			}
			else if((start[k]>= endc && end[k]>=endc) || (start[k]<=startc && end[k]<=startc))
			{
				ch.add('C');
				startc=Math.min(startc, start[k]);
				endc=Math.max(endc, end[k]);
			}
			else
			{
				flag=1;
				break;
			}
			
			
				
		}
		
		if(flag==1)
			System.out.println("IMPOSSIBLE");
		else
		{
			for(int i=0;i<ch.size();i++)
				System.out.print(ch.get(i));
			
			System.out.println();
		}
		
	}
}
}
