import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String res="";int cend=0,jend=0;boolean flag=true;
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i1 = 1; i1 <= t; ++i1) {
          int n = in.nextInt();
          //int m = in.nextInt();
          int a[][]=new int[n][3];
          for(int i=0;i<n;i++)
          {
              a[i][0]=in.nextInt();
              a[i][1]=in.nextInt();
              a[i][2]=i;
          }
           java.util.Arrays.sort(a, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
});
    cend=0;jend=0;
    flag=true;
    res="";
        for(int i=0;i<n;i++)
          {
              if(a[i][0]==a[i][1])
              res+="C";
              else if(a[i][0]>=cend)
              {
                  cend=a[i][1];
                  res+="C";
              }
              else if(a[i][0]>=jend)
              {
                  jend=a[i][1];
                  res+="J";
              }
              else
              {
                  flag=false;
                  break;
              }
            // System.out.println(a[i][0]+" "+a[i][1]+" "+a[i][2]+" "+res);
          }
          
          if(flag==true)
          {
          char[] ans=new char[res.length()];
          for(int i=0;i<n;i++)
          {
             // System.out.println(i+" "+res.charAt(a[i][2]));
              ans[i]=res.charAt(a[i][2]);
             // System.out.println(i+" "+res.charAt(a[i][2]));
          }
          String fans=new String(ans);
          System.out.println("Case #" + i1 + ": " + fans);
          }
          else
          {
              System.out.println("Case #" + i1 + ": " + "IMPOSSIBLE");
          }
          //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
      }
    }