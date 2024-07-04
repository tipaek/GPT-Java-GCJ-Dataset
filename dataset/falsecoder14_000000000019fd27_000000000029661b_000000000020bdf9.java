import java.util.*;
class Pair
{
    int ss;
    int ee;
    int id;
    Pair(int x,int y,int i)
    {
        ss=x;
        ee=y;
        id=i;
    }
}


class Pair2
{
    int ss;
    int ee;
    Pair2(int x,int y)
    {
        ss=x;
        ee=y;
    }
}

class timecomparator implements Comparator<Pair>
{
    public int compare(Pair pr1,Pair pr2)
    {
        if(pr1.ss>pr2.ss)
        {
            return 1;
        }
        else if(pr1.ss<pr2.ss)
        {
            return -1;
        }
        return 0;
    }
}

class Solution{
    
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int i=0;i<tc;i++)
        {
            int n=sc.nextInt();
        
        Pair[] time=new Pair[n];
        Pair2[] unsortTime=new Pair2[n];
        for(int j=0;j<n;j++)
        {
            int startTime=sc.nextInt();
            int endTime=sc.nextInt();
            Pair p=new Pair(startTime,endTime,j);
            Pair2 p2=new Pair2(startTime,endTime);
            time[j]=p;
            unsortTime[j]=p2;
        }
        Arrays.sort(time,new timecomparator());
        int Cid=0;
        int Jid=-1;
         String anstr="C";
        HashMap<Integer,Character> mp=new HashMap<>();
        mp.put(time[0].id,'C');
        for(int j=1;j<n;j++)
        {
           if(time[j].ss < time[Cid].ee)
           {
               if(Jid==-1 || time[j].ss >= time[Jid].ee)
               {
                    Jid=j;
                    anstr+="J";
                    mp.put(time[j].id,'J');
               }
               else if(time[j].ss < time[Jid].ee)
               {
                   break;
               }
           }
           else
           {
               Cid=j;
               anstr+="C";
                mp.put(time[j].id,'C');
            }
        }
        int caseNum=i+1;
        if(anstr.length()<n)
        {
            System.out.println("Case #" + caseNum + ":" + " IMPOSSIBLE") ;
        }
        else
        {
            String finAns="";
            for(int j=0;j<n;j++)
            {
                finAns+=mp.get(j);
            }
            System.out.println("Case #" + caseNum + ":" + " " +finAns);
        }
        }
        
    
    }
}