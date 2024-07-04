import java.util.*;
class Pairing{
    int s;
    int e;
    int index;
    Pairing(int x,int y,int i)
    {
        s=x;
        e=y;
        index=i;
    }
}


class AddIndex{
    int s;
    int e;
    AddIndex(int x,int y)
    {
        s=x;
        e=y;
    }
}

class timecomparator implements Comparator<Pairing>
{
    public int compare(Pairing p1,Pairing p2)
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
        
        Pairing[] time=new Pairing[n];
        AddIndex[] unsortTime=new AddIndex[n];
        for(int j=0;j<n;j++)
        {
            int startTime=s.nextInt();
            int endTime=s.nextInt();
            Pairing p=new Pairing(startTime,endTime,j);
            AddIndex p2=new AddIndex(startTime,endTime);
            time[j]=p;
            unsortTime[j]=p2;
        }
        Arrays.sort(time,new timecomparator());
        int Ci=0;
        int Ji=-1;
    String ans="C";
     String noans="IMPOSSIBLE";
     HashMap<Integer,Character> map=new HashMap<>();
     map.put(time[0].index,'C');
    for(int j=1;j<n;j++)
    {
       if(time[j].s < time[Ci].e)
       {
           if(Ji==-1 || time[j].s >= time[Ji].e)
           {
           Ji=j;
           ans+="J";
          map.put(time[j].index,'J');
           }
           else if(time[j].s < time[Ji].e)
           {
               break;
           }
       }
       else{
           Ci=j;
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
