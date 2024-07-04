import java.util.*;
class Pair{
    int start;
    int end;
    Pair(int x,int y)
    {
        start=x;
        end=y;
    }
}

class timecomparator implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        if(p1.start>p2.start)
        {
            return 1;
        }
        else if(p1.start<p2.start)
        {
            return -1;
        }
        return 0;
    }
}
class Solution{
    
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=s.nextInt();
        
        Pair[] time=new Pair[n];
        for(int j=0;j<n;j++)
        {
            int startTime=s.nextInt();
            int endTime=s.nextInt();
            Pair p=new Pair(startTime,endTime);
            time[j]=p;
        }
        Arrays.sort(time,new timecomparator());
        int Cindex=0;
        int Jindex=-1;
    String ans="C";
    String noans="IMPOSSIBLE";
    for(int j=1;j<n;j++)
    {
       if(time[j].start < time[Cindex].end)
       {
           if(Jindex==-1 || time[j].start >= time[Jindex].end)
           {
           Jindex=j;
           ans+="J";
           }
           else if(time[j].start < time[Jindex].end)
           {
               break;
           }
       }
       else{
           Cindex=j;
           ans+="C";
           }
    }
    if(ans.length()<n)
    {
        System.out.println("Case #" + " " + noans);
    }
    else{
        System.out.println("Case #" + " "+ ans);
    }
        }
        
    
    }
}