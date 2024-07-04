import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		sc.nextLine();
		for(int a=0;a<test;a++)
		{
			StringTokenizer st= new StringTokenizer(sc.nextLine());
			int c=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			String move=st.nextToken();
			boolean found=true;
			for(int x=0;x<move.length();x++)
			{
				String curr=move.substring(x,x+1);
				if(curr.contentEquals("N"))
				{
					d++;
				}
				if(curr.contentEquals("S"))
				{
					d--;
				}if(curr.contentEquals("E"))
				{
					c++;
				}if(curr.contentEquals("W"))
				{
					c--;
				}
				if(x+1>=(Math.abs(c)+Math.abs(d)))
				{
					System.out.println("Case #" + (a+1) + ": " + (x+1));
					found=false;
					break;
				}
			}
			if(found)
			{
				System.out.println("Case #" + (a+1) + ": IMPOSSIBLE");
			}
			
		}
	}

}
