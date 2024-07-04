import java.util.*;
import java.io.*;

    public class Solution {
      public static void main(final String[] args) {
          final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          final int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
              int m1=0;
              int m2=0;
              int n1=0;
              int n2=0;
              int flag =0;
          for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            m1=m2=n1=n2=0;
            StringBuilder s = new StringBuilder(n);
            int t1[] = new int[n];
            int t2[]= new int[n];
            
            for(int m = 0; m < n;m++){
                t1[m] = in.nextInt();
                t2[m] = in.nextInt();
            }
            for(int ix = 0;ix < n;ix++){
                if((m1 <=t1[ix] && m2 <= t1[ix]) || (m1 >=t2[ix] && m2 >= t2[ix]))
                {m1=t1[ix];
                m2=t2[ix];
                
                s.append('C');}
                else if((n1 <=t1[ix] && n2 <= t1[ix] )|| (n1 >=t2[ix] && n2 >= t2[ix]))
                {n1=t1[ix];
                n2=t2[ix];
                s.append('J');}
                else{
                    s = new StringBuilder("IMPOSSIBLE");
                    break;
                }

            }
            
          System.out.println("Case #" + i + ": " + (s) );
        }
      }
    }