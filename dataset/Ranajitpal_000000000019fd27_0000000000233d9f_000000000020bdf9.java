import java.util.Scanner;

public class Solution{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1;t<=T;t++)
		{
			int n = sc.nextInt();
			int s[] = new int[n];
			int e[] = new int[n];
			
			for(int i=0;i<n;i++)
			{
				s[i] = sc.nextInt();
				e[i] = sc.nextInt();
			}
			
			int j_start = 0;
			int j_end = 0;
			
			int c_start = 0;
			int c_end = 0;
			String r ="";
			for(int i=0;i<n;i++)
			{
				if(s[i]>=j_end || e[i]<=j_start)
				{
					j_end = e[i];
					j_start = s[i];
					
					r += "J";
				}
				else
				{
					if(s[i]>=c_end || e[i]<=c_start)
					{
						c_end = e[i];
						c_start = s[i];
						
						r += "C";
					}
					else
					{
						r = "IMPOSSIBLE";
						break;
					}
				}
				
			}
			
			
			System.out.println("Case #"+t+": "+r);
			
		}
	}
}
