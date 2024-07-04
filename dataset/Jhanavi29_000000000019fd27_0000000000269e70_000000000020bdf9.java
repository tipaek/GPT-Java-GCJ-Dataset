import java.util.*;
class Solution
{
public static void main(String[] args)
{
 Scanner sc=new Scanner(System.in);
 int t=sc.nextInt();
 for(int l=1;l<=t;l++)
 {
     int n=sc.nextInt();
     Interval a[]=new Interval[n];
     int min=Integer.MAX_VALUE;
     int max=Integer.MIN_VALUE;
     for(int i=0;i<n;i++)
     {a[i]=new Interval(sc.nextInt(),sc.nextInt());
     if(a[i].s<min)
     min=a[i].s;
     if(a[i].e>max)
     max=a[i].e;
     }
     int ind[]=new int[max+2];
     boolean flag=false;
     String ans="";
         Arrays.sort(a,new Comparator<Interval>(){
        public int compare(Interval a,Interval b)
        {
            return a.s-b.s;
        }
    });
    for(int i=0;i<n;i++)
    {
        int s=a[i].s;
        int e=a[i].e;
        for(int j=s;j<=e;j++)
        {
            ind[j]++;
            if(ind[j]>2&&ind[j-1]>2)
            {flag=true;break;}
        }
        if(flag)break;
    }
    if(!flag)
    {
       for(int i=1;i<n;i++)
       {
           int s=a[i].s;
           int e=a[i].e;
               if(ind[s]==2&&ind[e]==2)
               a[i].who=complement(a[i].who);
               if(ind[s]==2&&ind[s+1]==1)
               {
                   for(int j=0;j<i;j++)
                   {
                       if(a[i].s==a[j].e)
                       {a[i].who=complement(a[j].who);
                       a[j].who=a[i].who;break;}
                   }
               }
               if(ind[s]==2&&ind[e]==1)
               a[i].who=complement(a[i].who);
       }
       for(int i=0;i<n;i++)
       ans+=a[i].who;
    }
     print(l,ans,flag);
 }
}
static String complement(String s)
{
    if(s=="J")
    return "C";
    return "J";
}
static void print(int i,String s,boolean flag)
{
    if(flag)
    System.out.println("Case #"+i+": "+"IMPOSSIBLE");
    else
    System.out.println("Case #"+i+": "+s);
}
}
class Interval
{
    int s,e;
    String who="J";
    Interval(int s,int e)
    {
        this.s=s;
        this.e=e;
    }
}