import java.util.*;
import java.lang.*;
import java.io.*;
     
public class Solution
{
	
   	public static void main (String[] args) throws java.lang.Exception
   	{
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for(int test = 0;test<t;test++)
		{
			
			String s = in.next();
			
			char[] temp  = s.toCharArray();
			
			ArrayList<Character> c = new ArrayList<Character>();
			
			for(int i=0;i<temp.length;i++)
				c.add(temp[i]);
			
			int openedSF = 0;
			
			for(int i=0;i<c.size();i++)
			{
				
				int cc = c.get(i)-'0';
				
				while(cc > openedSF)
				{
					c.add(i,'(');
					openedSF++;
					i++;
				}
				
				while(cc < openedSF)
				{
					c.add(i,')');
					openedSF--;
					i++;
				}
			}
			
			while(openedSF>0)
			{
				c.add(')');
				openedSF--;
			}
			
			System.out.print("Case #" + (test+1) + ": ");
			for(Character x : c)
			{
				System.out.print(x);
			}
			System.out.println();
			
		}
		
    }
}