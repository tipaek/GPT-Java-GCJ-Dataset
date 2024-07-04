
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
			int n=s.nextInt(),sum=0,cr=0,cl=0;
			int arr[][]=new int[n][n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					arr[i][j]=s.nextInt();
					
				}
			}
			for(int i=0;i<n;i++)
			{
				sum+=arr[i][i];
			}
			HashMap<Integer, Integer>map=new HashMap<Integer, Integer>();
				for(int i=0;i<n;i++)
				{
					
					for(int j=0;j<n;j++)
					{
						if(map.containsKey(arr[i][j]))
						{	cr++;
						
							break;
						}
						else
							map.put(arr[i][j], 1);
					}
					map.clear();
				}
				for(int j=0;j<n;j++)
				{
					for(int i=0;i<n;i++)
					{
						if(map.containsKey(arr[i][j]))
						{
							cl++;
							break;
						}
						else
							map.put(arr[i][j],1);
					}
					map.clear();
				}
				System.out.println("Case #" + c + ": " + sum+" "+cr+" "+cl);
				c++;
		}
	}

	public static String factorial(int n) {
		BigInteger fact = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			fact = fact.multiply(new BigInteger(i + ""));
		}
		return fact.toString();
	}

	public static long gcd(long a, long n) {

		if (a == 0)
			return n;
		return gcd(n % a, a);
	}

}
