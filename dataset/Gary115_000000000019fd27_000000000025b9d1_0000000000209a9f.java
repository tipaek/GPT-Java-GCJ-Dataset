import java.lang.*;
import java.util.*;

public class Solution {
	public static void main(String[] arg)
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			String str=s.next();
			Stack<Character> st=new Stack<Character>();
			int count=0;
			for(int j=0;j<str.length();j++)
			{
				int n=Integer.parseInt(str.substring(j,j+1));
			    if(j==0)
			    {
			    	for(int k=0;k<n;k++)
			    	{
			    		st.push('(');
			    		count++;
			    	}
			    	st.push(str.charAt(j));
			    }
			    
			    else
			    {
			    	 
			    	
			    	if(count>n)
			    	{
			    		int diff=count-n;
			    		for(int k=0;k<diff;k++)
			    		{
			    			st.push(')');
			    			count--;
			    		}
			    		st.push(str.charAt(j));
			    	}
			    	else
			    	{
			    		int ext=n-count;
			    		for(int k=0;k<ext;k++)
				    	{
				    		st.push('(');
				    		count++;
				    	}
			    		st.push(str.charAt(j));
			    		
			    	}
			    }
			    if(j==str.length()-1)
			    {
			    	while(count!=0)
			    	{
			    		st.push(')');
			    		count--;
			    		
			    	}
			    }
			     
			    	
			     
			    	
			    
			}
			String strng="";
			while(!st.isEmpty()) {
				strng+=st.pop();
			}
			//System.out.println(strng);
			int len=strng.length();
			String rev="";
			for(int k=len-1;k>=0;k--)
			{
				rev+=strng.charAt(k);
			}
			System.out.println("Case #"+(i+1)+": "+rev);
			
		}
	}

}
