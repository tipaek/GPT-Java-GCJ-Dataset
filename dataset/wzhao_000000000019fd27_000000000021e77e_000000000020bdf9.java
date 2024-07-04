import java.util.*;
import java.io.*;
public class codejam3
{
    public static class Node implements Comparable<Node>
    {
        int t;
        int i;
        int in;
        public Node(int t, int i, int in)
        {
            this.t = t;
            this.i = i;
            this.in = in;
        }
        public int compareTo(Node o)
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
            PriorityQueue<Node> pq = new PriorityQueue<Node>();
            for(int i = 0; i < n; i ++)
            {
                StringTokenizer st = new StringTokenizer(input.readLine());
                pq.add(new Node(Integer.parseInt(st.nextToken()),0,i));
                pq.add(new Node(Integer.parseInt(st.nextToken()),1,i));
            }
            boolean works = true;
            int current = 0;
            char[] ans = new char[n];
            boolean C = false;
            boolean J = false;
            while(!pq.isEmpty())
            {
                Node N = pq.poll();
                if(N.i==0)
                {
                    current++;
                    if(current==3)
                    {
                        works = false;
                        break;
                    }
                    else
                    {
                        if(!C)
                        {
                            C = true;
                            ans[N.in] = 'C';
                        }
                        else
                        {
                            J = true;
                            ans[N.in] = 'J';
                        }
                    }
                }
                else
                {
                    current--;
                    if(ans[N.in]=='C') C = false;
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