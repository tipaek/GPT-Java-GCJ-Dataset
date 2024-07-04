import java.util.*;
import java.io.*;

public class Solution 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int TC = Integer.parseInt(input.readLine());
        for(int t = 1; t <= TC; t++)
        {
            out.print("Case #" + t + ": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(input.readLine());
            HashMap<Long,Integer> freq = new HashMap<Long,Integer>();
            for(int i = 0; i < N; i++)
            {
                long a = Long.parseLong(st.nextToken());
                if(!freq.containsKey(a)) freq.put(a,1);
                else freq.put(a,1+freq.get(a));
            }
            int best = D-1;
            out: for(long key : freq.keySet())
            {
                int count = freq.get(key);
                int cuts = 0;
                if(count>=D)
                {
                    best = Math.min(best,cuts);
                    continue out;
                }
                TreeSet<Long> firsts = new TreeSet<Long>();
                TreeSet<Long> seconds = new TreeSet<Long>();
                for(long key2 : freq.keySet())
                {
                    if(key2>key&&key2%key==0) firsts.add(key2);
                    else if(key2>key) seconds.add(key2);
                }
                for(long key2 : firsts)
                {
                    long j = key2;
                    while(j>key)
                    {
                        if(j==key*2) count += 2;
                        else count++;
                        cuts++;
                        j-=key;
                        if(count>=D)
                        {
                            best = Math.min(best,cuts);
                            continue out;
                        }
                    }
                }
                for(long key2 : seconds)
                {
                    long j = key2;
                    while(j>key)
                    {
                        count++;
                        cuts++;
                        j-=key;
                        if(count>=D)
                        {
                            best = Math.min(best,cuts);
                            continue out;
                        }
                    }
                }
            }
            out.println(best);
        }
        out.flush();
        out.close();
    }
}