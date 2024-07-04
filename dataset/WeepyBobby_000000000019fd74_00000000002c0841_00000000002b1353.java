import java.util.*;
import java.math.*;
import java.io.*;
class Solution
{
   public static void main(String args[]) throws IOException
   {
      BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
      int cases = Integer.parseInt(st.readLine());
      int curc = 0;
      nextcase:
      while(curc++ < cases)
      {
         //StringTokenizer s = new StringTokenizer(st.readLine());
        int n = Integer.parseInt(st.readLine());
       	System.out.println("Case #"+curc+":");
       	if(n <= 3)
       	{
       		for(int i = 1; i <= n; i++)
       		{
       			System.out.println(i+" 1");
       		}
       	}
       	else
       	{
       		System.out.println("1 1");
       		System.out.println("2 1");
       		long sum = 2;
       		int at = 2;
       		while(true)
       		{
       			if(sum+at > n) break;
       			sum += at;
       			System.out.println((at+1)+" 2");
       			at++;
       		}
       		if(sum != n)
       		{
       			for(int i = 0; i < n-sum; i++)
       			{
       				System.out.println((at+i)+" 1");
       			}
       		}
       	}
      }
   }
   public static void print(String str)
   {
      System.out.println(str);
      System.out.flush();
      return;
   }
   public static void print(int str)
   {
      System.out.println(str);
      System.out.flush();
      return;
   }
}
