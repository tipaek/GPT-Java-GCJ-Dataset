import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        for(int test = 1; test <= t; test++){
            int startT[] = new int[1450];
            int stopT[] = new int[1450];
            int act = fr.nextInt();
            TimeManager[] p = new TimeManager[act];
            for(int i=0;i<act;i++)
            {
                int s = fr.nextInt(), e =fr.nextInt();
                p[i] = new TimeManager(s,e,i);
            }

            char ans[] = new char[act];
            Arrays.sort(p,new SortClass());
            int count = 0;
            for(int j=0;j<act;j++)
            {
                int s = p[j].startT;
                int e = p[j].stopT;

                if(startT[s]!=1)
                {
                    gather(startT,s,e-1);
                    ans[p[j].assign]='C';
                    count++;
                }
                else if(stopT[s]!=1)
                {
                    gather(stopT,s,e-1);
                    ans[p[j].assign]='J';
                    count++;
                }
                else
                {
                    System.out.println("Case #"+test+": IMPOSSIBLE");
                    //count = 1;
                    break;
                }
            }
            if(count == act){
                System.out.println("Case #"+test+": "+String.valueOf(ans));
            }
        }
        
    }
    private static void gather(int startT[], int i, int n)
    {
        while(i<=n){
            startT[i]=1;
            i++;
        }
    }

    static class TimeManager
    {
        int startT,stopT,assign;
        TimeManager(int start, int stop,int assign)
        {
            this.assign=assign;
            this.startT = start;
            this.stopT = stop;
        }
        
    }
    static class SortClass implements Comparator<TimeManager>
    {
        public int compare(TimeManager startT, TimeManager stopT)
        {
            if(startT.startT != stopT.startT)
                return startT.startT - stopT.startT;
            return startT.stopT - stopT.stopT;
        }
    }

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
}
