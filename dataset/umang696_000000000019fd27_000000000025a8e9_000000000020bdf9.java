import java.io.*;
import java.util.*;
class Pair
{
    int s,e,i;
    Pair(int s,int e,int i)
    {
        this.s = s;
        this.e = e;
        this.i = i;
    }
}
class Pair1
{
    char c;
    int i;
    Pair1(char c,int i)
    {
        this.c = c;
        this.i = i;
    }
}
public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int t0 = 1; t0<=t; t0++)
        {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Compare());  
            PriorityQueue<Pair1> pq1 = new PriorityQueue<Pair1>(new Compare1());  
            for(int i = 0;i<n;i++)
            {
                String s[] = br.readLine().trim().split(" ");
                int s1 = Integer.parseInt(s[0]);
                int e1 = Integer.parseInt(s[1]);
                pq.add( new Pair(s1,e1,i));
            }
            String ans = "";
            boolean flag = true;
            int x = 0,y =0;
            while(!pq.isEmpty())
            {
                Pair obj = pq.remove();
                int s = obj.s;
                int e = obj.e;
                if(s<x && s<y)
                {
                    flag = false;
                    break;
                }
                if(s>=x)
                {
                    pq1.add(new Pair1('C',obj.i));
                    x = e;
                }
                else
                {
                    pq1.add(new Pair1('J',obj.i));
                    y = e;
                }
            }
            if(!flag)
                ans = "IMPOSSIBLE";
            else
                while(!pq1.isEmpty())
                    ans = ans+pq1.remove().c;
            bw.write("Case #"+t0+": "+ans+"\n");
        }
        bw.flush();
    }
}
class Compare implements Comparator<Pair>
{
    public int compare(Pair a,Pair b)
    {
        if(a.s>b.s)
            return 1;
        if(a.s<b.s)
            return -1;
        if(a.e>b.e)
            return 1;
        if(a.e<b.e)
            return -1;
        return -1;
    }
}
class Compare1 implements Comparator<Pair1>
{
    public int compare(Pair1 a,Pair1 b)
    {
        return a.i-b.i;
    }
}