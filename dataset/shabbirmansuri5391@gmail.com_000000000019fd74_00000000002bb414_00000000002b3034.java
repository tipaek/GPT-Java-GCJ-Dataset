import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
class Solution {
    public static void main(String args[] ) throws Exception {
        
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
		int t = Integer.parseInt(read.readLine());
		
		for(int test=1;test<=t;test++)
		{
			int n = Integer.parseInt(read.readLine());	
			
			String [] str = new String[n];
			
			
			for(int i=0;i<n;i++)
			{
				str[i] = read.readLine();
			}
			
			Arrays.sort(str);
			
			int [] index = new int[n];
			for(int i=0;i<n;i++)
			{			
				//System.out.println(str[i]);
				index[i] = str[i].length()-1;
			}
			
			boolean flag=true;
			StringBuilder sb = new StringBuilder();
			
			
			while(index[0]>0)
			{
				for(int i=1;i<n;i++)
				{
					if(str[0].charAt(index[0]) == str[i].charAt(index[i]))
					{
						index[i]--;
					}
					else if(str[i].charAt(index[i]) =='*' && index[i]>0 && str[i].charAt(index[i-1]) == str[0].charAt(index[0]) )
					{
						index[i]--;
					}
					else if(str[i].charAt(index[i]) =='*' && index[i]== 0  )
					{
					}
					else if( index[i]< str[i].length()-1 && str[i].charAt(index[i]+1) =='*')
					{
						
					}
					else
					{
						flag=false;
					}
				}
				
				if(str[0].charAt(index[0]) != '0')
					sb.append(str[0].charAt(index[0]));
				index[0]--;
				
			}
			
			if(flag)
				System.out.println("Case #"+test+": "+sb.reverse().toString());			
			else
				System.out.println("Case #"+test+": *");			
		}
		
		
		
		
    }
}
