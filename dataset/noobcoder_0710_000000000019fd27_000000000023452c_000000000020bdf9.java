import java.util.*;
import java.io.*;
public class Solution
{
    static class Pair
    {
        int s1,e1;String givento;
        Pair(int si,int ei)
        {
            s1=si;
            e1=ei;
        }
    }
    static class comparator implements Comparator<Pair>
    {
        public int compare(Pair p1,Pair p2)
        {
            return p1.s1-p2.s1;
        }
    }
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            int n=Integer.parseInt(br.readLine());
            Pair p[]=new Pair[n]; 
            Map<Integer,Pair> map=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                String str[]=br.readLine().split(" ");
                int s1=Integer.parseInt(str[0]);
                int e1=Integer.parseInt(str[1]);
                p[i]=new Pair(s1,e1);
                map.put(i,p[i]);
            }
            Arrays.sort(p,new comparator());
            int endofc=0,endofj=0;
            endofc=p[0].e1;
            for(Map.Entry<Integer,Pair> me:map.entrySet())
            {
                Pair pp=me.getValue();
                if(pp.s1==p[0].s1&&pp.e1==p[0].e1)
                {
                    p[0].givento="C";
                    break;
                }
            }
            boolean b=false;
            for(int i=1;i<n;i++)
            {
                if(p[i].s1>=endofc)
                {
                    for(Map.Entry<Integer,Pair> me:map.entrySet())
                    {
                        Pair pp=me.getValue();
                        if(pp.s1==p[i].s1&&pp.e1==p[i].e1)
                        {
                            p[i].givento="C";
                            endofc=p[i].e1;
                            break;
                        }
                    }
                }
                else if(p[i].s1>=endofj)
                {
                    for(Map.Entry<Integer,Pair> me:map.entrySet())
                    {
                        Pair pp=me.getValue();
                        if(pp.s1==p[i].s1&&pp.e1==p[i].e1)
                        {
                            p[i].givento="J";
                            endofj=p[i].e1;
                            break;
                        }
                    }
                }
                else
                {
                    b=true;
                    break;
                }
            }
            if(b)
            pw.println("Case #"+(x+1)+": IMPOSSIBLE");
            else
            {
                String str="";
                Map<Integer,Pair> mp=new TreeMap<>(map);
                for(Map.Entry<Integer,Pair> me:mp.entrySet())
                {
                    str=str+me.getValue().givento;
                }
                pw.println("Case #"+(x+1)+": "+str);
            }
        }
        pw.flush();
        pw.close();
    }
}