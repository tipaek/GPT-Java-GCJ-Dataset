import java.util.*;
class Main{
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int i,j,k;
        int r=0,c=0;
        for(k=1;k<=n;k++)
        {
          int size=s.nextInt();
          ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>(size);
          for(i=0;i<size;i++)
          {
           ArrayList<Integer> ltemp=new ArrayList<Integer>(size);   
           l.add(ltemp);
              for(j=0;j<size;j++)
              {
                  int in=s.nextInt();
              ltemp.add(in);
              }
          }
          int trace=0;
          for(i=0;i<size;i++)
          {
              trace+=l.get(i).get(i);
          }
          for(i=0;i<size;i++)
          {
              Set<Integer> set=new HashSet<Integer>();
              for(Integer b:l.get(i))
              {
                  if(set.add(b)==false)
                  {
                   r++;
                   break;
                  }
              }
              System.out.println();
          }
          c=0;
          for(i=0;i<size;i++)
          {
              Set<Integer> set=new HashSet<Integer>();
              for(j=0;j<size;j++)
              {
                  if(set.add(l.get(j).get(i))==false)
                  {
                   c++;
                   break;
                  }
              }
          }
          System.out.println("Case #"+k+": "+trace+" "+r+" "+c);        }
    }
}
