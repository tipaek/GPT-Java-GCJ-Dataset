
import java.util.*;
import java.io.*;
public class Solution {
	
	public static String open_pare(int no)
	 {
	     String s="" ;
	     for(int i=0;i<no;i++)
	         s=s+'(';
	    return s ;
	 }
	public static String close_pare(int no)
	 {
	    String s="";    
	      for(int i=0;i<no;i++)
	         s=s+')';
	    return s ;
	 }
	public static char getMin(String s)
	{
		char m=s.charAt(0) ;
		for(int i=1;i<s.length();i++)
			if(s.charAt(i)<m)
				m=s.charAt(i);
		return m ;
	}
	public static void main(String[] args)    {
		Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		 t = input.nextInt() ;
		input.nextLine();
		for(int c=0;c<t;c++)
		{
			char  m='0' ;
			boolean end = true ;
			String s = input.nextLine();
			System.out.printf("Case #%d: ",c+1);
			
			for(int i=0;i<s.length();i++)
			{
				if(s.indexOf(i)=='0')
					System.out.print('0');
				else
				{
					if(s.substring(i+1).indexOf('0')>=0)
					{
						 char n = s.charAt(i);
							String no =""+n;
							 	for(int j=i+1;j<s.length() &&s.charAt(j)==n;j++,i++)
			                    {
							 		no= no+n;    
			                    }
							 	if(i+1<s.length() && s.charAt(i)>s.charAt(i+1)&&s.charAt(i+1)!='m')
							 	{
							 	 System.out.print(open_pare(s.charAt(i+1)-m)+ open_pare(n-s.charAt(i+1)-(m-'0'))+no+close_pare(n-s.charAt(i+1)-(m-'0'))+close_pare(s.charAt(i+1)-m)+s.charAt(i+1));
							 	 i++;
							 	 char k = s.charAt(i);
								 	for(int u=i+1;u<s.length() &&s.charAt(u)==k;u++,i++)
								 		 System.out.print(k);
							 	}
							 	else
							 	{
							 		 System.out.print(open_pare(n-'0'-1)+no+close_pare(n-'0'-1)); 
							 	}
					}
					else
					{
						if(end)
					   {
							  m = getMin(s.substring(i));
							  System.out.print(open_pare(m-'0'));
							  end = false ;
					   }	   
					 
					   if(s.charAt(i)==m)
					   {
						   System.out.print(m);
						   continue;
					   }
					   char n = s.charAt(i);
						String no =""+n;
						 	for(int j=i+1;j<s.length() &&s.charAt(j)==n;j++,i++)
		                    {
						 		no= no+n;    
		                    }
						 	if(i+1<s.length() && s.charAt(i)>s.charAt(i+1)&&s.charAt(i+1)!='m')
						 	{
						 	 System.out.print(open_pare(s.charAt(i+1)-m)+ open_pare(n-s.charAt(i+1)-(m-'0'))+no+close_pare(n-s.charAt(i+1)-(m-'0'))+close_pare(s.charAt(i+1)-m)+s.charAt(i+1));
						 	 i++;
						 	 char k = s.charAt(i);
							 	for(int u=i+1;u<s.length() &&s.charAt(u)==k;u++,i++)
							 		 System.out.print(k);
						 	}
						 	else
						 	{
						 		 System.out.print(open_pare(n-m)+no+close_pare(n-m)); 
						 	}
					}
				}
			}
			System.out.println(close_pare(m-'0'));
		}
		input.close();
	}
	
}	
	
