import java.util.*;
public class Solution
{
  static class data implements Comparable<data>
  {
     int i;
     int s;
    int e;
    public data(int a,int b,int c)
    {
      i=a;
      s=b;
      e=c;
    }
    public int compareTo(data d)
    {
      if(s<d.s)
      return -1;
      else
      return 1;
    }
  }
  public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int t=in.nextInt();
    int f=1;
    while(t-->0)
    {
      int n=in.nextInt();
      data ar[]=new data[n];
      for(int i=0;i<n;i++)
      {
        ar[i]=new data(i,in.nextInt(),in.nextInt());
      }
      Arrays.sort(ar);
      int arr[]=new int[n];
      int p=ar[0].s;
      int q=ar[0].e;
      arr[ar[0].i]=1;
      for(int i=1;i<n;i++)
      {
        data d=ar[i];
        if(d.s>=q)
        {
          arr[d.i]=1;
          p=d.s;
          q=d.e;
        }
      }
      p=0;
      q=0;
      int c=0;
      for(int i=1;i<n;i++)
      {
        data d=ar[i];
        int a=d.i;
         if(arr[a]==1)
        continue;
        if(d.s>=q)
        {
          p=d.s;
          q=d.e;
        }
        else
        c++;
      }
      if(c>0)
      System.out.println("Case #"+f+": "+"IMPOSSIBLE");
      else
      {
        StringBuilder sb=new StringBuilder();
        for(int i:arr)
        {
          if(i==1)
          sb.append("C");
          else
          sb.append("J");
        }
        System.out.println("Case #"+f+": "+sb.toString());
      }
      f++;
    }
  }
}
