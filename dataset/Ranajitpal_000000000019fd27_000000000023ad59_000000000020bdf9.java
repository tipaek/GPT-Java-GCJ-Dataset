import java.util.Scanner;

public class Solution {
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
			
			
			String r ="";
			for(int i=0;i<n;i++)
			{
				if(can('C',s,e,r,s[i],e[i]) == true)
				{
					r += 'C';
				}
				else
				{
					if(can('J',s,e,r,s[i],e[i]) == true)
					{
						r += 'J';
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
	
	public static boolean can(char c,int[] s,int[] e,String r, int start,int end) {
		for(int i=0;i<r.length();i++)
		{
			if(r.charAt(i) == c)
			{
				if(start<e[i] && start>=s[i] || end>s[i] &&end<=e[i])
				{
					return false;
				}
			}
		}
		return true;
	}
}
