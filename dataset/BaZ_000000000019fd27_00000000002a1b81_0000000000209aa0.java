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

    static int per[][] , ptr;
    static void solve() throws IOException
    {
        //initIo(true, "");
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int N[] = new int[44];
        int K[] = new int[44];
        int pt = 0;
        for(int i=2;i<=5;++i) {
            for(int j=i;j<=i*i;j++) {
                N[pt] = i;
                K[pt++] = j;
            }
        }
        int fact[] = new int[10];
        fact[0]++;
        for(int i=1;i<10;++i) {
            fact[i] = fact[i-1]*i;
        }
        int t = ni();
        for(int case_=1;case_<=t;++case_) {
            int n = ni(), k = ni();
//            pl("n : "+n+" k : "+k);
            int mat[][] = new int[n][n];
            for(int i=0;i<n;++i) {
                for(int j=0;j<n;++j) {
                    mat[i][j] = (i+1+j);
                    if(mat[i][j]>n) {
                        mat[i][j]-=n;
                    }
                }
            }
            ptr = 0;
            per = new int[fact[n]][n];
            f(mat[0], 0);
//            for(int i=0;i<fact[n];++i) {
//                pa("factorials", per[i]);
//            }
//            pa("mat", mat);
            boolean found = false;
            int new_mat[][] = new int[n][n];
            for(int i=0;i<fact[n];i++) {
                int p[] = per[i];
//                pa("trying against", p);
                for(int COL=0;COL<n;++COL) {
                    int new_pos = p[COL]-1;
                    for(int ROW=0;ROW<n;++ROW) {
                        new_mat[ROW][new_pos] = mat[ROW][COL];
                    }
                }
                int sum = 0;
                for(int j=0;j<n;++j) {
                    sum+=new_mat[j][j];
                }
                if(sum==k) {
                    found = true;
                    pl("Case #"+case_+": POSSIBLE");
                    for(int ROW=0;ROW<n;++ROW) {
                        for(int COL=0;COL<n;++COL) {
                            p(new_mat[ROW][COL]);
                        }
                        pl();
                    }
                    break;
                }
            }
            if(!found) {
                pl("Case #"+case_+": IMPOSSIBLE");
            }
        }
        pw.flush();
        pw.close();
    }

    static void f(int arr[], int idx) {
        if(idx==arr.length) {
            for(int i=0;i<arr.length;++i) {
                per[ptr][i] = arr[i];
            }
            ptr++;
            return;
        }
        for(int i=idx;i<arr.length;++i) {
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            f(arr, idx+1);
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
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