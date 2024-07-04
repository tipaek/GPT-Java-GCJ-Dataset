import com.sun.source.tree.ArrayAccessTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution  {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {

        FastReader sc=new FastReader();
        StringBuilder ans=new StringBuilder();
        int t=sc.nextInt();
        int count=1;
        while(t-->0)
        {
            StringBuilder mid=new StringBuilder("Case #"+(count++)+": ");
            int r=sc.nextInt();
            int s=sc.nextInt();
            List<Pair> list=new ArrayList<>();
            int val1=r;
            int val2=(r*s)-1-r;
            while(val1>1)
            {
                for(int i=0;i<s-1;i++)
                {
                    list.add(new Pair(val1,val2--));
                }
                val1--;
            }
            mid.append(list.size()).append("\n");
            for(Pair p:list)
            {
                mid.append(p.a).append(" ").append(p.b).append("\n");
            }
            ans.append(mid.toString());
        }
        System.out.print(ans);
    }
}
class Pair
{
    int a,b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}


