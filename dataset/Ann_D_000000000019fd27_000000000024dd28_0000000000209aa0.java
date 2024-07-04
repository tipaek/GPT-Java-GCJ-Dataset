
import java.util.*;
public class Solution {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		
		for(int i=0;i<t;i++)
		{
			
			int size=0,trace=0;
			int n=0;
			
			size=sc.nextInt();
		    trace=sc.nextInt();
			n=size;
			
			if(trace%size==0&& trace%size<=size)
			{
				System.out.println("Case #"+(i+1)+": POSSIBLE");
				int p=trace/size;
				
				int c=n+1;
				for(int j=1;j<=n;j++)
				{
					int temp=c;
					
					while(temp<=n)
					{
						System.out.print((temp+p-2)%(size)+1+" ");
						temp++;
					}
					
					for(int r=1;r<c;r++)
					{
						System.out.print((r+p-2)%size+1+" ");
					}
					c--;
					System.out.println();
				}
				
			}
			else
			{
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");

			}
			
		}
	}

}
