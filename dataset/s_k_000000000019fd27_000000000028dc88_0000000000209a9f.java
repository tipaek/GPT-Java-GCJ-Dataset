import java.io.*;
import java.util.*;

public class Solution {
	public static void main (String[] args) {
					
Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		for(int l=1;l<=t;l++)
		{
		String str=sc.next();
		
		StringBuilder s=new StringBuilder();
		    
		
		int cl=0;
		int op=str.charAt(0)-'0';
		for(int i=0;i<op;i++)
			s.append('(');
		s.append(str.charAt(0));
		for(int i=1;i<str.length();i++)
		{
			if((str.charAt(i))==(str.charAt(i-1)))
				{
					s.append(str.charAt(i));
					continue;
				}
			if((str.charAt(i)-'0')<(str.charAt(i-1)-'0'))
			 {
				cl=op-(str.charAt(i)-'0');
				for(int j=0;j<cl;j++)
				{
					s.append(')');
					op--;
				}
				s.append(str.charAt(i));
				
			 }
			
			else if((str.charAt(i) -'0')>(str.charAt(i-1)-'0'))
				{
					int x=op;
					op=((str.charAt(i)-'0')-x);
					for(int j=0;j<op;j++)
						{
						    s.append('(');
						    //op++;
						}
					s.append(str.charAt(i));
					op=str.charAt(i)-'0';
				}
			
			
		}
		for(int j=0;j<op;j++)			s.append(')');
		System.out.println("Case #"+l+": "+s);
		}	

	}
}