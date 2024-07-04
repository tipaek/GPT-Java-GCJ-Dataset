import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Solution {
    public static void main(String args[] ) throws Exception {
        
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
		int t = Integer.parseInt(reader.readLine());
		
		
		for(int test=1;test<=t;test++)
		{
			StringBuilder sb = new StringBuilder();
			String str = reader.readLine();
			
			if(str.length()>0)
			{
				
				int n = str.charAt(0) -'0';
				
				for(int i=0;i<n;i++)
				{
					sb.append("(");
				}
				sb.append(n);
				
				
				for(int i=1;i<str.length();i++)
				{
					int prev = str.charAt(i-1) -'0';
					int curr = str.charAt(i) -'0';
					
					if(curr>prev)
					{
						int diff = curr - prev;
						for(int j=0;j<diff;j++)
						{
							sb.append("(");
						}
					}
					else
					{
						int diff = prev - curr;
						for(int j=0;j<diff;j++)
						{
							sb.append(")");
						}
					}
					
					sb.append(curr);
				}
				
				
				n = str.charAt(str.length()-1) -'0';
				
				for(int i=0;i<n;i++)
				{
					sb.append(")");
				}
			
			}
			
			System.out.println("Case #"+test+": "+sb.toString());			
		}
		
		
		
		
    }
}
