import java.lang.*;
import java.util.*;

public class Solution {
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			String str=s.next();
			Stack<Character> st=new Stack<>();
			for(int j=0;j<str.length();j++)
			{
			 if(j==0 && str.charAt(j)=='1')
			 {
				st.push('(');
				st.push('1');
			 }
			 else if(str.charAt(j)=='1')
			 {
				 if(str.charAt(j-1)=='1')
				 {
					 st.push('1');
				 }
				 else
				 {
					 st.push('(');
					 st.push('1');
				 }
			 }
			 else if(str.charAt(j)=='0' && (j-1)>=0  && str.charAt(j-1)=='1' )
			 {
				 st.push(')'); 
				 st.push('0'); 
			 }
			 else if(str.charAt(j)=='0')
			 {
				 st.push('0'); 
			 }
			  if(str.charAt(j)=='1' && j==str.length()-1)
			  {
				  st.push(')');
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
			System.out.println("Case "+"#"+(i+1)+": "+rev);
			
		}
		
	}

}


