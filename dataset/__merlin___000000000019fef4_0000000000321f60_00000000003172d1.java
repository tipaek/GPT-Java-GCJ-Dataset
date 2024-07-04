import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine()),v;
        StringBuilder sb=new StringBuilder();
        for(v=1;v<=t;v++)
        {
            String s[]=bu.readLine().split(" ");
            int n=Integer.parseInt(s[0]),d=Integer.parseInt(s[1]),i;
            long a[]=new long[n];
            HashMap<Long,Integer> hm=new HashMap<>();
            ArrayList<Long> k=new ArrayList<>();
            s=bu.readLine().split(" ");
            if(n==1)
            {
                sb.append("Case #"+v+": "+(d-1)+"\n");
                continue;
            }
            for(i=0;i<n;i++)
            {
                a[i]=Long.parseLong(s[i]);
                if(hm.get(a[i])==null) {hm.put(a[i],1); k.add(a[i]);}
                else hm.put(a[i],hm.get(a[i])+1);
            }
            int max=0;
            for(long x:hm.keySet())
                if(hm.get(x)>max) max=hm.get(x);
            if(max>=d) {sb.append("Case #"+v+": 0\n"); continue;}
            else if(d==2) {sb.append("Case #"+v+": 1\n"); continue;}
            else if(d==3)
            {
                int c=2;
                for(i=0;i<k.size();i++)
                {
                    long temp=2l*k.get(i);
                    if(hm.containsKey(temp)) {c=1; break;}
                }
                sb.append("Case #"+v+": "+c+"\n");
                continue;
            }
            sb.append("Case #"+v+": "+(d-1)+"\n");
        }
        System.out.print(sb);
    }
}
