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
          int e[]=new int[n];
          int f[]=new int[n];
          char s2[]=new char[n];
          int j=0,c=0;
          boolean ans=true;
          String s="";
          for(int i=0;i<n;i++)
          {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            d[i]=10000*a[i]+i;
          }
          Arrays.sort(d);
          for(int i=0;i<n;i++)
          {
            a[i] = d[i]/10000;
            e[i] = d[i]-10000*a[i];
            f[i]=b[e[i]];
          }
          for(int i=0;i<n;i++)
          {
            if(j>=c)
            {
              if(j<=a[i])
              {
                j=f[i];
                s=s+"J";
              }else if(c<=a[i])
              {
                c=f[i];
                s=s+"C";
              }else
              {
                ans=false;
              }
            }else
            {
              if(c<=a[i])
              {
                c=f[i];
                s=s+"C";
              }else if(j<=a[i])
              {
                j=f[i];
                s=s+"J";
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
            for(int i=0;i<n;i++)
            {
              s2[e[i]]=s.charAt(i);
            }
            for(int i=0;i<n;i++)
            {
              System.out.print(s2[i]);
            }
            System.out.print('\n');

          }
          
        }
      }
    }