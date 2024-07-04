import java.util.*;
import java.io.*;
public class Solution
{
  public static void main(String[] args) 
  {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
     // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int k = 1; k <= t; ++k)
    {
      int N = in.nextInt();
      int s[]=new int[N];
      int e[]=new int[N];
      List<Integer> list=new ArrayList<>();
      List<Integer> list1=new ArrayList<>();
      List<Integer> list2=new ArrayList<>();
      List<Integer> list3=new ArrayList<>();
      String ans="J";
    //   int sj=0,ej=0,sc=0,ec=0;
      
      for(int i=0;i<N;i++)
      {
           s[i] = in.nextInt();
           e[i] = in.nextInt();
      }
      
      list.add(s[0]);
      list1.add(e[0]);
      
      for(int i=1;i<N;i++)
      {
          int a=0,b=0;
          for(int j=0;j<list.size();j++)
          {
              if( (s[i]>=list1.get(j)) || (e[i]<=list.get(j)))
              {
                  a++;
              }
          }
          for(int j=0;j<list2.size();j++)
          {
              if( (s[i]>=list3.get(j)) || (e[i]<=list2.get(j)))
              {
                  b++;
              }
          }
          
          if(a==list.size())
          {
          ans+="J";
          list.add(s[i]);
          list1.add(e[i]);
          }
          
          else if(b==list2.size())
          {
          ans+="C";
          list2.add(s[i]);
          list3.add(e[i]);
          }
          
          
          
      }
      
      if(ans.length()<N)
      ans="IMPOSSIBLE";
      
      System.out.println("Case #" + k + ": " + ans);
    }
  }
}