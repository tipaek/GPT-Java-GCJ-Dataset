import java.util.*;
class Pair{
    int s;
    int e;
    int index;
    Pair(int x,int y,int i)
    {
        s=x;
        e=y;
        index=i;
    }
}


class Pair2{
    int s;
    int e;
    Pair2(int x,int y)
    {
        s=x;
        e=y;
    }
}

class timecomparator implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        if(p1.s>p2.s)
        {
            return 1;
        }
        else if(p1.s<p2.s)
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
        Pair2[] unsortTime=new Pair2[n];
        for(int j=0;j<n;j++)
        {
            int startTime=s.nextInt();
            int endTime=s.nextInt();
            Pair p=new Pair(startTime,endTime,j);
            Pair2 p2=new Pair2(startTime,endTime);
            time[j]=p;
            unsortTime[j]=p2;
        }
        Arrays.sort(time,new timecomparator());
        int Cindex=0;
        int Jindex=-1;
    String ans="C";
     String noans="IMPOSSIBLE";
     HashMap<Integer,Character> map=new HashMap<>();
     map.put(time[0].index,'C');
    for(int j=1;j<n;j++)
    {
       if(time[j].s < time[Cindex].e)
       {
           if(Jindex==-1 || time[j].s >= time[Jindex].e)
           {
           Jindex=j;
           ans+="J";
          map.put(time[j].index,'J');
           }
           else if(time[j].s < time[Jindex].e)
           {
               break;
           }
       }
       else{
           Cindex=j;
           ans+="C";
         map.put(time[j].index,'C');
           }
    }
    int caseNum=i+1;
    if(ans.length()<n)
    {
        System.out.println("Case #" + caseNum + ":" + " " +noans);
    }
    else{
        String newAns="";
        for(int j=0;j<n;j++)
        {
            newAns+=map.get(j);
        }
        System.out.println("Case #" + caseNum + ":" + " " +newAns);
    }
        }
        
    
    }
}