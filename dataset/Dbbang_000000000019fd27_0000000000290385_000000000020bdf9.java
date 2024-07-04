import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.TreeMap;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Solution {
	// Integer.bitCount(i); count no of 1 bit in a given number
	static Scanner scn = new Scanner(System.in);
	static long cunt = 0;

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	static FastReader s = new FastReader();

	public static void main(String[] args) {
		/* TODO Auto-generated method stub */
		// System.out.format("%.10f", ans);char c = sc.next().charAt(0);
		int t=s.nextInt(),c=1;
		while(t-->0)
		{
			int n=s.nextInt(),a=0,b=0;
			int arr[]=new int[n];
			int brr[]=new int[n];
			pair pr[]=new pair[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=s.nextInt();
				brr[i]=s.nextInt();
				pr[i]=new pair(arr[i],brr[i],i);
			}
			Arrays.parallelSort(pr, new sorting());
			char ans[]=new char[n];
			boolean bl=true;
			for(int i=0;i<n;i++)
			{
				if(a<=pr[i].x)
				{
					ans[pr[i].z]='C';
					a=pr[i].y;
				}
				else if(b<=pr[i].x)
				{
					ans[pr[i].z]='J';
					b=pr[i].y;
				}
				else
				{
					bl=false;
					break;
				}
			}
			if(bl)
			{
				System.out.print("Case #" + c+ ": ");
				for(int i=0;i<n;i++)
				{
					System.out.print(ans[i]);
				}
				System.out.println();
			}
			else
				System.out.println("Case #" + c+ ": " +"IMPOSSIBLE");
			c++;
		}
	}
}
	class pair
	{
		int x;
		int y;
		int z;
		pair(int a,int b,int c)
		{
			this.x=a;
			this.y=b;
			this.z=c;
		}
	}
	class sorting implements Comparator<pair>
	{

		@Override
		public int compare(pair o1, pair o2) {
			// TODO Auto-generated method stub
			return o1.x-o2.x;
		}
		
	}


