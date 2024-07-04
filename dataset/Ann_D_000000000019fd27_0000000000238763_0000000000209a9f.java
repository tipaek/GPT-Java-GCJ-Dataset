import java.util.*;
public class Solution {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i=0;i<t;i++)
		{
			String s = sc.next();
			char[] st = s.toCharArray();
			int open[] = new int[st.length];
			int close[] = new int[st.length];
			
			open[0] = st[0]-48;
			close[0]=st[0]-48;
			//System.out.println(open[0]+" "+close[0]);
			for(int j=1;j<st.length;j++)
			{
				if(st[j]-48<=st[j-1]-48)
				{
					close[j-1]=close[j-1]-(st[j]-48);
					close[j] = st[j]-48;
				}
				else
				{
					close[j]=close[j-1]+(st[j]-st[j-1]);
					open[j]=(st[j]-st[j-1]); 
					close[j-1]=0;
					
				}
				//System.out.println(open[0]+" "+close[0]);
				                                     
				
			}
			
			System.out.print("Case #"+(i+1)+": ");
		
			for(int j=0;j<st.length;j++)
			{
				for(int k=0;k<open[j];k++)
				{
					System.out.print("(");
				}
				
				System.out.print(st[j]);
				
				for(int k=0;k<close[j];k++)
				{	
					
					System.out.print(")");
				}
			}
			System.out.println();
		}
	}

}
