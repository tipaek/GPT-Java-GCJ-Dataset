import java.util.*;
import java.io.*;

public class Solution
{
	 static void solve(Scanner sc, int testcase)
    {
		char s[] = sc.next().toCharArray();
		
		int cur = 0;
		
		String ans = "";
		
		for(char i:s)
		{
			if(i-'0'==cur)
			{
				ans+=i+"";
			}
			else if(cur<i-'0')
			{
				while(cur<i-'0')
				{
					cur++;
					ans+="(";
				}
				ans+=i+"";
			}
			else
			{
				while(cur>i-'0')
				{
					cur--;
					ans+=")";
				}
				ans+=i+"";
			}
		}
		
		while(cur>0)
		{
			cur--;
			ans+=")";
		}
		
		System.out.println("Case #"+testcase+": "+ans);
	}
    
  
    public static void main(String args[])
    {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        
        for(int j=1;j<=t;j++)
        {
			solve(sc,j);
        }
    }
}
