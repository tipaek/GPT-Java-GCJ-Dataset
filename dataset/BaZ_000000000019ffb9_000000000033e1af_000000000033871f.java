/**
 * BaZ :D
 */

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class Solution
{
    static MyScanner scan;
    static PrintWriter pw;
    static long MOD = 1_000_000_007;
    static long INF = 1_000_000_000_000_000_000L;
    static long inf = 2_000_000_000;
    public static void main(String[] args) {
        new Thread(null, null, "BaZ", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static int c[];
    static int parent[], parent_edge_idx[];
    static ArrayList<Pair> adj[];
    static int ans[];
    static void solve() throws IOException
    {
        //initIo(true, "");
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int t = ni();
        for (int case_=1;case_<=t;++case_) {
            p("Case #"+case_+":");
            int n = ni(), m = ni();
            c = new int[n+1];
            parent = new int[n+1];
            parent_edge_idx = new int[n+1];
            adj = new ArrayList[n+1];
            ans = new int[m+1];
            for(int i=1;i<=n;++i) {
                adj[i] = new ArrayList<>();
                if(i==1) {
                    continue;
                }
                c[i] = ni();
            }
            for(int i=1;i<=m;++i) {
                int u = ni(), v = ni();
                adj[u].add(new Pair(v,i));
                adj[v].add(new Pair(u,i));
            }

            int nodes_solved = 1;
            int time[] = new int[n+1];
            Arrays.fill(parent, -1);
            parent[1] = 0;
            time[1] = 0;
            int tim = 0;
            int iters = 0;
            while (nodes_solved<n && iters < n) {
                ArrayList<Integer> this_iter = new ArrayList<>();
                // Trying with neg values first

//                pa("parent", parent);
//                pl("Nodes solved : "+nodes_solved);
                for(int i=2;i<=n;++i) {
                    if(c[i]<0 && c[i]==-nodes_solved) {
                        this_iter.add(i);
                    }
                }

                if(!this_iter.isEmpty()) {
                    // empty, try with time now
                    int next_time = Integer.MAX_VALUE;
                    for(int i=2;i<=n;++i) {
                        if(c[i]<0 || parent[i]!=-1) {
                            continue;
                        }
                        next_time = min(next_time, c[i]);
                    }
                    if(next_time==Integer.MAX_VALUE) {
                        tim++;
                    }
                    else tim = next_time;

                    for(int i=2;i<=n;++i) {
                        if(c[i] == tim) {
                            this_iter.add(i);
                        }
                    }
                }
                else {
                    tim++;
                }
                //pa("This iter", this_iter);

                ArrayList<Pair> ans_par_idx = new ArrayList<>();
                for(int e : this_iter) {
                    int p = -1, idx = -1;
                    for(Pair f : adj[e]) {
                        if(parent[f.x] != -1) {
                            p = f.x;
                            idx = f.y;
                        }
                    }
                    ans_par_idx.add(new Pair(p, idx));
                }

                //pa("ans_par_idx", ans_par_idx);

                for(int i=0;i<this_iter.size();i++) {
                    int node = this_iter.get(i);
                    parent[node] = ans_par_idx.get(i).x;
                    time[node] = tim;
                    ans[ans_par_idx.get(i).y] = tim - time[ans_par_idx.get(i).x];
                }
                nodes_solved+=this_iter.size();
                iters++;
            }
//            pl("ANS : ");
            for(int i=1;i<=m;++i) {
                if(ans[i] == 0) {
                    ans[i] = 1_000_000;
                }
                p(ans[i]);
            }
            pl();
        }
        pw.flush();
        pw.close();
    }

    static class MyComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            return c[a] - c[b];
        }
    }

    static class Pair implements Comparable<Pair>
    {
        int x,y;
        Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
        public int compareTo(Pair other)
        {
            if(this.x!=other.x)
                return this.x-other.x;
            return this.y-other.y;
        }
        public String toString()
        {
            return "("+x+","+y+")";
        }
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if(isFileIO) {
            pw = new PrintWriter("/Users/amandeep/Desktop/output"+suffix+".txt");
        }
        else {
            pw = new PrintWriter(System.out, true);
        }
    }
    static int ni() throws IOException
    {
        return scan.nextInt();
    }
    static long nl() throws IOException
    {
        return scan.nextLong();
    }
    static double nd() throws IOException
    {
        return scan.nextDouble();
    }
    static String ne() throws IOException
    {
        return scan.next();
    }
    static String nel() throws IOException
    {
        return scan.nextLine();
    }
    static void pl()
    {
        pw.println();
    }
    static void p(Object o)
    {
        pw.print(o+" ");
    }
    static void pl(Object o)
    {
        pw.println(o);
    }
    static void psb(StringBuilder sb)
    {
        pw.print(sb);
    }
    static void pa(String arrayName, Object arr[])
    {
        pl(arrayName+" : ");
        for(Object o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, int arr[])
    {
        pl(arrayName+" : ");
        for(int o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, long arr[])
    {
        pl(arrayName+" : ");
        for(long o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, double arr[])
    {
        pl(arrayName+" : ");
        for(double o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, char arr[])
    {
        pl(arrayName+" : ");
        for(char o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, boolean arr[])
    {
        pl(arrayName+" : ");
        for(boolean o : arr)
            p(o);
        pl();
    }
    static void pa(String listName, List list)
    {
        pl(listName+" : ");
        for(Object o : list)
            p(o);
        pl();
    }
    static void pa(String arrayName, Object[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(Object o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, int[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(int o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, long[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(long o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, char[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(char o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, double[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(double o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, boolean[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(boolean o : arr[i])
                p(o);
            pl();
        }
    }
    static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        MyScanner(boolean readingFromFile, String suffix) throws IOException
        {
            if(readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/amandeep/Desktop/input"+suffix+".txt"));
            }
            else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }
        String nextLine()throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException
        {
            return Double.parseDouble(next());
        }
    }
}