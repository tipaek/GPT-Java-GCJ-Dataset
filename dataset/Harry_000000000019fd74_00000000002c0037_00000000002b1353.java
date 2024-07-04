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
			for(int j=1;j<=n;j++)
			{
				System.out.println(j+" "+j);
			}
		}
	}
}