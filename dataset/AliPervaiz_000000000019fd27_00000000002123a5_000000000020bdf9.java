import java.util.*;
import java.io.*;
public class Solution
{
    public static class Pair implements Comparable<Pair>
    {
        int t;
        int i;
        int in;
        public Pair(int t, int i, int in)
        {
            this.t = t;
            this.i = i;
            this.in = in;
        }
        public int compareTo(Pair o)
        {
            if(t==o.t)
            {
                if(i==1) return -1;
                return 1;
            }
            return Integer.compare(t,o.t);
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(input.readLine());
        for(int tc = 1; tc <= t; tc++)
        {
            int n = Integer.parseInt(input.readLine());
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
            for(int i = 0; i < n; i ++)
            {
                StringTokenizer st = new StringTokenizer(input.readLine());
                pq.add(new Pair(Integer.parseInt(st.nextToken()),0,i));
                pq.add(new Pair(Integer.parseInt(st.nextToken()),1,i));
            }
            boolean works = true;
            int curr = 0;
            char[] ans = new char[n];
            boolean C = false;
            boolean J = false;
            while(!pq.isEmpty())
            {
                Pair pa = pq.poll();
                if(pa.i==0)
                {
                    curr++;
                    if(curr==3)
                    {
                        works = false;
                        break;
                    }
                    else
                    {
                        if(!C)
                        {
                            C = true;
                            ans[pa.in] = 'C';
                        }
                        else
                        {
                            J = true;
                            ans[pa.in] = 'J';
                        }
                    }
                }
                else
                {
                    curr--;
                    if(ans[pa.in]=='C') C = false;
                    else J = false;
                }
            }
            String wow = "";
            for(char ch : ans) wow += ch;
            out.print("Case #" + tc + ": ");
            if(!works) out.println("IMPOSSIBLE");
            else out.println(wow);
        }
        out.flush();
        out.close();
    }
}