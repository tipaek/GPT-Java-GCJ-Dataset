import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          String ar[]=new String[n];
          for(int j=0;j<n;j++)
          {
          	ar[j]=in.next();
          	}
          	String next="" ;
          	for(int k=0;k<n;k++) 
          	{
          		String temp="" ;
          		for(int l=0;l<ar[k].length();l++)
          		{
          			String r="" ;
          			char ch=ar[k].charAt(l);
          			if(ch=='*')
          			r+=next;
          			else
          			r+=ch;
          			temp+=r;
          			}
          			next+=temp;
          		}
          System.out.println("Case #" + i + ":\t" +next );
        }
      }
    }
