/*input
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
*/

 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int T = 1; T <= t; ++T) {
          System.out.print("Case #" + T + ": ");
          int n = in.nextInt();
          int a[]=new int[n];
          int b[]=new int[n];
          int d[]=new int[n];
          int j=0,c=0;
          boolean ans=true;
          String s="";
          for(int i=0;i<n;i++)
          {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            d[i]=10000*a[i]+b[i];
          }
          Arrays.sort(d);
          for(int i=0;i<n;i++)
          {
            a[i] = d[i]/10000;
            b[i] = d[i]-10000*a[i];
          }
          for(int i=0;i<n;i++)
          {
            if(j>c)
            {
              if(j<=a[i])
              {
                j=b[i];
                s=s+"j";
              }else if(c<=a[i])
              {
                c=b[i];
                s=s+"c";
              }else
              {
                ans=false;
              }
            }else
            {
              if(c<=a[i])
              {
                c=b[i];
                s=s+"c";
              }else if(j<=a[i])
              {
                j=b[i];
                s=s+"j";
              }else
              {
                ans=false;
              }
            }
          }
          if(!ans)
          {
            System.out.println("IMPOSSIBLE");
          }else
          {
            System.out.println(s);
          }
          
        }
      }
    }