import java.util.*;

class Pair2
{
    int s;
    int e;
    Pair2(int x,int y)
    {
        s=x;
        e=y;
    }
}

class Pair
{
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



class timecomparator implements Comparator<Pair>
{
    public int compare(Pair p1,Pair p2)
    {
        if(p1.s<p2.s)
        {
            return -1;
        }
        
        else if(p1.s>p2.s)
        {
            return 1;
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
        
            Pair[] lera=new Pair[n];
            Pair2[] tisd=new Pair2[n];
            for(int j=0;j<n;j++)
            {
                int dsv=s.nextInt();
                int vss=s.nextInt();
                Pair p=new Pair(dsv,vss,j);
                Pair2 p2=new Pair2(dsv,vss);
                lera[j]=p;
                tisd[j]=p2;
            }
            Arrays.sort(lera,new timecomparator());
            int fdvsc=0;
            int dfzz=-1;
            String ans="C";
             String saca="IMPOSSIBLE";
             HashMap<Integer,Character> map=new HashMap<>();
             map.put(lera[0].index,'C');
            for(int j=1;j<n;j++)
            {
               if(lera[j].s < lera[fdvsc].e)
               {
                   if(dfzz==-1 || lera[j].s >= lera[dfzz].e)
                   {
                       dfzz=j;
                       ans+="J";
                       map.put(lera[j].index,'J');
                   }
                   else if(lera[j].s < lera[dfzz].e)
                   {
                       break;
                   }
               }
               
               else
               {
                   fdvsc=j;
                   ans+="C";
                   map.put(lera[j].index,'C');
               }
            }
            
            int dvzs=i+1;
            if(ans.length()<n)
            {
                System.out.println("Case #" + dvzs + ":" + " " +saca);
            }
            else
            {
                String sad="";
                for(int j=0;j<n;j++)
                {
                    sad+=map.get(j);
                }
                System.out.println("Case #" + dvzs + ":" + " " +sad);
            }
            }
        
    
    }
}