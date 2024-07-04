import java.io.*;
import java.util.*;
import java.lang.*;

class Solution implements Runnable {

    static void mainTHread(FastReader sc, PrintWriter out, int testcase)
    {
        


        int strt[] = new int[1450];
        int stp[] = new int[1450];

        int n = sc.nextInt();

        Timings[] p = new Timings[n];

        for(int i=0;i<n;i++)
        {
            int s = sc.nextInt(), e =sc.nextInt();
            p[i] = new Timings(s,e,i);
        }

        char ans[] = new char[n];
        Arrays.sort(p,new Sortitout());

        for(int j=0;j<n;j++)
        {
            int s = p[j].strt;
            int e = p[j].stp;

            if(strt[s]!=1)
            {
                add(strt,s,e-1);
                ans[p[j].input]='C';
            }
            else if(stp[s]!=1)
            {
                add(stp,s,e-1);
                ans[p[j].input]='J';
            }
            else
            {
                out.println("Case #"+testcase+": IMPOSSIBLE");
                return;
            }
        }

        out.println("Case #"+testcase+": "+new String(ans));
    }

    public void run() {

        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        for(int i=1;i<=t;i++)
        {
            mainTHread(sc,out,i);
        }

        out.close();
    }

    static class Sortitout implements Comparator<Timings>
    {
        public int compare(Timings strt, Timings stp)
        {
            if(strt.strt != stp.strt)
                return strt.strt - stp.strt;
            return strt.stp - stp.stp;
        }
    }

    static void add(int strt[],int i,int n)
    {
        for(;i<=n;i++)strt[i]=1;
    }

    static class Timings
    {
        int strt,stp,input;
        Timings(int start, int stop,int test)
        {
            strt = start;
            stp = stop;
            input=test;
        }
        public String toString()
        {
            return "["+strt+" "+stp+"]";
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(),"Main",1<<27).start();
    }
}