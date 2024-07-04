import java.util.*;
import java.io.*;
public class Solution 
{
  public static void main(String[] args) 
  {
    int t,i,j,k,c,s,e,n;
    boolean f;
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    for (int ti = 1; ti <= t; ++ti) 
    {
      n = in.nextInt();
      c=j=0;
      f=false;
      Tuple tp[]=new Tuple[n];
      char ch[]=new char[n];
      for(i=0;i<n;i++)
      {
          s=in.nextInt();
          e=in.nextInt();
          tp[i]=new Tuple(s,e,i);
      }
      Arrays.sort(tp,new Tcomp());
      for(i=0;i<n;i++)
      {
          s=tp[i].s;
          e=tp[i].e;
          k=tp[i].i;
          if(c<=s)
          {
              ch[k]='C';
              c=e;
          }
          else if(j<=s)
          {
              ch[k]='J';
              j=e;
          }
          else
          {
              f=true;
          }
      }
      if(f)
      {
          System.out.println("Case #" + ti + ": " + "IMPOSSIBLE");
      }
      else
      {
          System.out.print("Case #" + ti + ": ");
          for(i=0;i<n;i++)
          {
              System.out.print(ch[i]);
          }
          System.out.println();
      }
    }
  }
}
class Tuple
{
    int s,e,i;
    Tuple(int s,int e,int i)
    {
        this.s=s;
        this.e=e;
        this.i=i;
    }
}
class Tcomp implements Comparator<Tuple>
{
    @Override
    public int compare(Tuple t1,Tuple t2)
    {
        if(t1.s>t2.s)
        {
            return 1;
        }
        else if(t1.s==t2.s)
        {
            if(t1.e>t2.e)
            {
                return 1;                
            }
            else
            {
                return -1;
            }
        }
        else
        {
            return -1;
        }
    }
}