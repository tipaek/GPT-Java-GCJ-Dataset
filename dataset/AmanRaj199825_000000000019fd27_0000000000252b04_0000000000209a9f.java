import java.io.*;
import java.util.*;
 class Solution {
public static void main(String[] args) {
	try
	{
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  Integer T=Integer.parseInt(br.readLine());
	  int x=0;
	  while(T-->0)
	  {
		  x+=1;
		 String str=br.readLine();
		 String res=util(str);
		 System.out.println("Case #"+x+": "+res);
	  }
	}
	catch(Exception e)
	{
		
	}
}
public static String util(String str)
{
	int depth=0;
	StringBuffer sb=new StringBuffer();
	for(char ch:str.toCharArray()) {
		int ndepth=ch-'0';
		while(ndepth>depth) {
			depth+=1;
			sb.append('(');
		}
		while(ndepth<depth)
		{
			depth-=1;
			sb.append(')');
			
		}
		sb.append(ch);
	}
	while(depth>0) {
		depth-=1;
		sb.append(')');
	}
	return sb.toString();
}
}
