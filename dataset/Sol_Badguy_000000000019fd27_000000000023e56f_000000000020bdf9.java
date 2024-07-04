import java.util.*;
class Pair implements Comparable<Pair>
{
    int start;int end;
    Pair()
    {
        start=-1;end=-1;
    }
    Pair(int a,int b)
    {
        start=a;end=b;
    }
    @Override
    public int compareTo(Pair ob) 
    {
    if(this.start != ob.start)   
           return this.start-ob.start;
        else
            return this.end-ob.end;
        
    }    
} 
class Solution
{
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int t=ob.nextInt();
        
        for(int tc=1;tc<=t;tc++)
        {
            String temp="Case #"+tc+": ";
            boolean flag=false;
            //System.out.println("hello "+tc);
            int n=ob.nextInt();
            Pair pair[]=new Pair[n];
            for(int i=0;i<n;i++)
            {
                pair[i]=new Pair();
                pair[i].start=ob.nextInt();
                pair[i].end=ob.nextInt();
            }
            Arrays.sort(pair);
            String ans="";
            int C=pair[0].end;int J=0;ans+="C";
            for(int i=1;i<n;i++)
            {
                if(C<=pair[i].start)
                {
                    C=pair[i].end;ans+="C";
                }
                else if(J<=pair[i].start)
                {
                    J=pair[i].end;ans+="J";
                }
                else
                {
                    flag=true;break;
                }
            }
            if(flag)
            System.out.println("IMPOSSIBLE");
            else
            System.out.println(temp+ans);
        }
    }
}