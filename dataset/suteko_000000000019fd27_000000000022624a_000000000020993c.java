import java.util.*;
import java.io.*;
class Solution{
    public static void main(String args[])
	{
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		    in.nextLine(); //skipping the first line with number of cases.
		    int[][] validateC;
		    int[] validateR;
		      int rows = 0;
              int cols = 0;
              int trace = 0;
              int val = 0;
              boolean r = false;
              boolean[] c;
              int N = 0;
		    for (int i = 1; i <= t; ++i) {
		      N = in.nextInt();
		      in.nextLine();
		      validateC = new int[N+1][101];
              rows = 0;
              cols = 0;
              trace = 0;
              val = 0;
              c = new boolean[N+1];
		      for(int j=0; j<N; j++)
		      {
		          r = false;
		          validateR = new int[101];
		          for(int k=0; k<N; k++)
		          {
    		          val = in.nextInt();
    		          if(j==k)
    		            trace += val;
    		          if(validateR[val] > 0 && !r)
    		          {
    		            rows++;
    		            r = true;
    		          }
    		          if(validateC[k][val] > 0 && !c[k])
		              {
    		            cols++;
    		            c[k] = true;
		              }
    		          validateR[val]++;
    		          validateC[k][val]++;
		          }
		          try{
		          in.nextLine();
		          }catch(Exception e){// To ignore if ther eis no new line at the end
		          }
		      }
		      System.out.println("Case #" + i + ": "+ trace +" "+rows+" "+cols);
		    }
		    in.close();
	}
}