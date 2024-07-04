import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        long trace=0,rows=0,cols=0,flag=0;
        for (int i1 = 1; i1 <= t; ++i1) {
          int n = in.nextInt();
          trace=0;
          long a[][]=new long[n][n];
          rows=0;cols=0;
         // HashSet<Long>[] cset=new HashSet<>[n];
         HashMap<Integer,HashSet<Long>> cset = new HashMap<Integer,HashSet<Long>>();
          int temp[]=new int[n];
          for(int i=0;i<n;i++)
          {
              flag=0;
              HashSet<Long> rset=new HashSet<>();
              for(int j=0;j<n;j++)
              {
                  if(in.hasNext())
                  a[i][j]=in.nextLong();
                 // System.out.print(a[i][j]+" ");
                  if(i==j)
                  trace+=a[i][j];
                  if(rset.contains(a[i][j])==true)
                  {
                      if(flag==0)
                     { rows++;flag=1;}
                  }
                  else
                  rset.add(a[i][j]);
                  
                 if(i==0)
                  {
                      HashSet<Long> set=new HashSet<>();
                      set.add(a[i][j]);
                      cset.put(j,set);
                  }
                  else
                  {
                  if(cset.get(j).contains(a[i][j])==true)
                  {
                      if(temp[j]==0)
                      {
                          cols++;
                          temp[j]=1;
                      }
                  }
                  else{
                      HashSet<Long> abcd=cset.get(j);
                      abcd.add(a[i][j]);
                      cset.put(j,abcd);
                  }
                  
                  }
              }
            //  System.out.println();
          }
         // int m = in.nextInt();
          System.out.println("Case #" + i1 + ": " + trace + " " + rows+" "+cols);
        }
      }
    }