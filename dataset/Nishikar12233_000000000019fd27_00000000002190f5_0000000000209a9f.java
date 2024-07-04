import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test= Integer.parseInt(sc.nextLine());
		for(int g=0;g<test;g++)
		{
			String ans="";
			String in=sc.nextLine();
			boolean prev1=false;
			String curr="";
			for(int x=0;x<in.length();x++)
			{
				curr=in.substring(x,x+1);
				if(curr.equals("0"))
				{
					if(prev1==false)
					{
						ans+="0";
						prev1=false;
					}
					else
					{
						ans+=")0";
						prev1=false;
					}
				}
				if(curr.contentEquals("1"))
				{
					if(prev1==false)
					{
						ans+="(1";
						prev1=true;
					}
					else
					{
						ans+="1";
						prev1=true;
					}
				}
			}
			if(curr.contentEquals("1"))
			{
				ans+=")";
			}
			System.out.println("Case #" + (g+1) + ": " +ans);			
		}
	}

}
