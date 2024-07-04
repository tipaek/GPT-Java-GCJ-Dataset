import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ii = 1; ii <= t; ++ii) 
        {
          int N = in.nextInt();
          //int m = in.nextInt();
          int a[][]=new int[N][N];
			long sum=0,r=0,c=0;
			HashSet<Integer> set=new HashSet<Integer>();
          for (int i = 0; i <N; i++) 
			{
				set.clear();
				for (int j = 0; j <N; j++) 
				{
					a[i][j]=in.nextInt();
					if(i==j)
						sum=sum+a[i][j];
					set.add(a[i][j]);
				}
				if(set.size()!=N)
					r++;
			}
			for (int i = 0; i <N; i++) 
			{
				set.clear();
				for (int j = 0; j <N; j++) 
				{
					set.add(a[j][i]);
				}
				if(set.size()!=N)
					c++;
			}
		//	System.out.println("Case #"+ii+": "+sum+" "+r+" "+c);
          System.out.println("Case #" + ii + ": " + (sum) + " " + (r)+" "+c);
        }//test
      }
    }