import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int test=sc.nextInt();
		for(int h=0;h<test;h++)
		{
			int n=sc.nextInt();
			ArrayList<String> ans= new ArrayList<String>();
			String longest="";
			sc.nextLine();
			for(int x=0;x<n;x++)
			{
				String curr=sc.nextLine();
				//System.out.println(curr);
				ans.add(curr.substring(1));
				if(ans.get(x).length()>longest.length())
				{
					longest=ans.get(x);
				}
			}
			boolean cont=true;
			for(int x=0;x<n;x++)
			{
				if(longest.indexOf(ans.get(x))==-1)
				{
					cont=false;
					break;
				}
			}
			if(cont)
			{
				System.out.println("Case #" + (h+1)+ ": "+ longest);
			}
			else
			{
				System.out.println("Case #" + (h+1)+ ": "+ "*");
			}
			
			
		}
	}

}
