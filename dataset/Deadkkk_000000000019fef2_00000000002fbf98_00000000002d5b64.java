import java.util.*;
import java.io.*;


public class Solution
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		int r[] = new int[t];
		int s[] = new int[t];
		for (int i = 0; i < t; ++i) {
			r[i] = in.nextInt();
			s[i] = in.nextInt();
		}

		for (int i = 0; i < t; ++i) {
			System.out.print("Case #" + (i+1) + ": ");
			process(r[i], s[i]);
		}
	}

	private static void process(int r, int s) {
		int k = (r*s)-1- r + 1;
		System.out.println((r-1)*(s-1));
		for(int i=r-1; i>0;i--)
		{
			for(int j = s-1;j>0;j--)
			{
				System.out.println(k+" "+ i);
				k--;
			}
		}


	}

}


