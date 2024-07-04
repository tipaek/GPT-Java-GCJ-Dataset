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

    static void solve() throws IOException
    {
        //initIo(true, "");
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int t = ni();
        for (int case_=1;case_<=t;++case_) {
            p("Case #"+case_+":");
            long arr[] = new long[2];
            arr[0] = nl();
            arr[1] = nl();
            long diff = max(arr[0], arr[1]) - min(arr[0], arr[1]);
            long low = 0, high = 2_000_000_000, mid, ans = low;
            while (low<=high) {
                mid = (low+high)>>1;
                long midsum = (mid*(mid+1));
                midsum/=2;
                if(midsum<=diff) {
                    ans = mid;
                    low = ++mid;
                }
                else {
                    high = --mid;
                }
            }
            //pl("ans : "+ans);
            int which = arr[0] >= arr[1] ? 0 : 1;
            arr[which]-=((ans*(ans+1))/2);
            int next = arr[0] >= arr[1] ? 0 : 1;
            //pl("state : "+arr[0]+","+arr[1]);
            ans = bs(arr, ans+1, next);
            pl(ans+" "+arr[0]+" "+arr[1]);
        }
        pw.flush();
        pw.close();
    }

    static long bs(long arr[], long start, int which) {
        //pl("start : "+start+" which : "+which);
        if(arr[0]<start && arr[1]<start) {
            return start - 1;
        }
        long low = start, high = 2_000_000_000, ans = start, mid;
        long which_took = -1, other_took = -1;
        while(low<=high) {
            mid = (low+high)>>1;
            long total = (mid - start + 1)*(start + mid);
            total/=2;
            long which_takes_till = mid%2 == start%2 ? mid : mid - 1;
            long which_takes = (mid - start + 2)/2;
            which_takes*=(start + which_takes_till);
            which_takes/=2;

            long other_takes = total - which_takes;

            if(arr[which] >= which_takes && arr[1-which] >= other_takes) {
                ans = mid;
                which_took = which_takes;
                other_took = other_takes;
                low = ++mid;
            }
            else {
                high = --mid;
            }
        }
        //pl("ans : "+ans);
        arr[which]-=which_took;
        arr[1-which]-=other_took;
        return ans;
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