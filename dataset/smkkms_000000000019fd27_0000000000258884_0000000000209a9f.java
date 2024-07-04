import java.io.*;
import java.util.*;

class Solution
{
	static class InputReader
	{
		BufferedReader br;
		public InputReader() throws IOException
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		public int readInt() throws IOException
		{
			return Integer.parseInt(br.readLine());
		}
		public long readLong() throws IOException
		{
			return Long.parseLong(br.readLine());
		}
		public String readLine() throws IOException
		{
			return br.readLine();
		}
		public int[] readIntArray() throws IOException
		{
			return Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		}
		public long[] readLongArray() throws IOException
		{
			return Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();
		}
		public void close() throws IOException
		{
			br.close();
		}
	}
	public static void main(String[] args) throws IOException
	{
		InputReader br = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);

		int test = br.readInt();
		for(int t=1;t<=test;t++)
		{
			 char arr[] = br.readLine().toCharArray();
			 String ans = "";
			 int n = arr.length;
			 int curr_digit= arr[n-1]-'0', p = arr[n-1]-'0';


			 for(int i=1;i<=p;i++)
			 {
			 	ans = ans+")";
			 }
			 ans = arr[n-1]+ans;
			 //System.out.println(ans);

			 for(int i=n-2;i>=0;i--)
			 {
			 	curr_digit = arr[i]-'0';
			 	if(curr_digit<p)
			 	{
			 		for(int j=1;j<=p-curr_digit;j++)
			 		{
			 			ans = "("+ans;
			 		}
			 		p = p-(p-curr_digit);
			 		ans = arr[i]+ans;
			 	}
			 	else if(curr_digit>p)
			 	{
			 		for(int j=1;j<=curr_digit-p;j++)
			 		{
			 			ans = ")"+ans;
			 		}
			 		p = p+(curr_digit-p);
			 		ans = arr[i]+ans;
			 	}
			 	else
			 	{
			 		ans = arr[i]+ans;
			 	}
			 }

			 for(int i=1;i<=p;i++)
			 {
			 	ans = "("+ans;
			 }
			 pw.println("Case #"+t+": "+ans); 
		}
		pw.close();
		br.close();
	}
}