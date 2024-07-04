import java.util.*;
class Pair implements Comparable<Pair>
{
    int start;int end;int pos=-1;char c=' ';
    Pair()
    {
        start=-1;end=-1;
    }
    Pair(int a,int b,int p)
    {
        start=a;end=b;pos=p;
    }
    @Override
    public int compareTo(Pair ob) 
    {
    if(this.start != ob.start)   
           return this.start-ob.start;
        else if(this.end != ob.end)
            return this.end-ob.end;
            else
            return this.pos-ob.pos;
        
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
            HashMap<Pair,Integer> map=new HashMap<>();
            HashMap<Integer,Character> pam=new HashMap<>();
            Pair pair[]=new Pair[n];
            for(int i=0;i<n;i++)
            {
                pair[i]=new Pair();
                pair[i].start=ob.nextInt();
                pair[i].end=ob.nextInt();
                pair[i].pos=i;
                map.put(pair[i],i);
            }
            Arrays.sort(pair);
            
            int C=pair[0].end;int J=0;
            pam.put(map.get(pair[0]),'C');
            pair[0].c='C';
            for(int i=1;i<n;i++)
            {
                if(C<=pair[i].start)
                {
                    C=pair[i].end;
                    pair[i].c='C';
                    pam.put(map.get(pair[i]),'C');
                }
                else if(J<=pair[i].start)
                {
                    J=pair[i].end;
                    pair[i].c='J';
                    pam.put(map.get(pair[i]),'J');
                }
                else
                {
                        flag=true;break;
                }
            }
            if(flag)
            System.out.println(temp+"IMPOSSIBLE");
            else
            {
                char []ans3=new char[n];String fns="=";
                for(int i=0;i<n;i++)
                ans3[pair[i].pos]=pair[i].c;
               // System.out.println(ans3);
                String ans2="";
                for(int i=0;i<n;i++)
                ans2+=ans3[i];
                System.out.println(temp+ans2);
                //System.out.println(temp+ans);
            }
        }
    }
}
