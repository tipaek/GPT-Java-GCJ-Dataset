import java.util.*;
import java.io.*;

public class Solution
{
	public static void main(String [] args)
	{
		Scanner y=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t=y.nextInt();
		for(int i=0;i<t;i++)
		{
			int n=y.nextInt();
			System.out.println("Case #"+(i+1)+":");
			if(n==1)
			{
				System.out.println("1 1");
			}
			else if(n==2)
			{
				System.out.println("1 1");
				System.out.println("2 2");
			}
			else
			{
				System.out.println("1 1");
				System.out.println("3 2");
				for(int j=3;j<n;j++)
				{
					System.out.println(j+" "+j);
				}
			}
		}
	}
}