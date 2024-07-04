import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
public class Solution
{
	public static void main(String[] args)
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    sc.nextLine();
	    for (int k=0;k<t;k++)
	    {
		String str = sc.nextLine();
		Queue<Character> q = new LinkedList<>();
		char[] s = str.toCharArray();
		int y=s[0]-'0';
		for (int i=0;i<y;i++)
		{
		    q.add('(');
		}
		q.add(s[0]);
		for (int i=1;i<s.length;i++)
		{
		    if((int)(s[i-1]-'0')<(int)(s[i]-'0'))
		    {
		        int x=(int)(s[i]-'0')-(int)(s[i-1]-'0');
		        while(x!=0)
		        {
		            q.add('(');
			    x--;
		        }
		    }
		    else if((int)(s[i-1]-'0')>(int)(s[i]-'0'))
		    {
		        int x=(int)(s[i-1]-'0')-(int)(s[i]-'0');
		        while(x!=0)
		        {
		            q.add(')');
			    x--;
		        }
		    }
		    q.add(s[i]);
		}
		for(int i=0;i<(int)(s[s.length-1]-'0');i++)
		{
		    q.add(')');
		}
		System.out.print("Case #"+(k+1)+": ");
		while(!q.isEmpty())
		{
			System.out.print(q.peek());
			q.remove();
		}
		System.out.println();
	    }
		
	}
}

