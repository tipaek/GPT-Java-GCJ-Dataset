import java.util.*;
import java.io.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test= Integer.parseInt(sc.nextLine());
		for(int g=0;g<test;g++)
		{
			String in=sc.nextLine();
			String ans="";
			int tally=0;
			int a=0;
			for(int x=0;x<in.length();x++)
			{
				a =Integer.parseInt(in.substring(x,x+1));
				if(x==0)
				{
					tally=a;
					for(int m=0;m<a;m++)
					{
						ans+=("(");
					}
					ans+=a;
					continue;
				}
				if(a<tally)
				{
					for(int m=0;m<tally-a;m++)
					{
						ans+=")";
					}
					ans+=a;
					tally=a;
				}
				else if(a==tally)
				{
					ans+=a;
				}
				else
				{
					for(int m=0;m<a-tally;m++)
					{
						ans+="(";
					}
					tally=a;
					ans+=a;
				}		
			}
			for(int x=0;x<a;x++)
			{
				ans+=")";
			}
			System.out.println("Case #" + (g+1) + ": " +ans);			
		}
	}

}
