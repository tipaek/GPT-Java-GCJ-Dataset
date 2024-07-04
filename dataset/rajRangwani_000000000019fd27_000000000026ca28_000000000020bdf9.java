import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    PrintWriter out = new PrintWriter(System.out);
    int tc = sc.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int test = 1; test <= tc; ++test) {
      
      int n = sc.nextInt();
      Triplet t[] = new Triplet[n];
      char ans[] = new char[n];
      for(int i=0;i<n;i++)
      {
          int start = sc.nextInt();
          int end = sc.nextInt();
          t[i]=new Triplet(i,start,end);
      }
      Arrays.sort(t,new SortByEnd());
      int first=t[0].end;
      int second=0;
      ans[t[0].i]='C';
      boolean possible=true;
      for(int i=1;i<n;i++)
      {
          int diff1=t[i].start-first;
          int diff2=t[i].start-second;
          if(diff1<0 && diff2<0) {possible=false;break;}
          else if(diff2<0)
          {
              ans[t[i].i]='C';
              first=t[i].end;
          }
          else if(diff1<0)
          {
              ans[t[i].i]='J';
              second=t[i].end;
          }
          else
          {
              if(diff1<diff2)
              {
                  ans[t[i].i]='C';
                    first=t[i].end;
              }
              else
              {
                  ans[t[i].i]='J';
                    second=t[i].end;
              }
          }
      }
      String output = new String();
      if(!possible) output="IMPOSSIBLE";
      else output=new String(ans);
      out.println("Case #" + test + ": " + output);
    }
    out.close();
  }
}

class Triplet
{
    int i,start,end;
    Triplet(){}
    Triplet(int i,int start,int end)
    {
        this.i=i;
        this.start=start;
        this.end=end;
    }
}

class SortByEnd implements Comparator<Triplet>
{
    public int compare(Triplet t1,Triplet t2)
    {
        return t1.end-t2.end;
    }
}