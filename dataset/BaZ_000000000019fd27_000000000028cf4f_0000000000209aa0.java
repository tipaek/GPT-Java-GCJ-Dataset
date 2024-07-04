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
        int N[] = new int[44];
        int K[] = new int[44];
        int ptr_ = 0;
        for(int i=2;i<=5;++i) {
            for(int j=i;j<=i*i;++j) {
                N[ptr_] = i;
                K[ptr_++] = j;
            }
        }
        int t = ni();
        for(int case_=1;case_<=t;) {
            int n = ni(), k = ni();
//            pl("n: "+n+" k : "+k);
            int mat[][] = new int[n][n];
            for(int i=0;i<n;++i) {
                for(int j=0;j<n;++j) {
                    mat[i][j] = -1;
                }
            }
            int some = k%n;
            int rest = (n - some);
            if(some==0) {
                int arr[] = new int[n];
                int val = (k/n);
                for(int i=0;i<n;++i) {
                    arr[i] = val;
                    val++;
                    if(val>n) {
                        val = 1;
                    }
                }
                pl("Case #"+case_+++": POSSIBLE");
                for(int i=0;i<n;++i) {
                    for(int e : arr) {
                        p(e);
                    }
                    pl();
                    arr = shift(arr);
                }
            }
            else {
//                pl("Some " + some + " Rest : " + rest);
                for (int i = 0; i < n; ++i) {
                    if (i < rest) {
                        mat[i][i] = (k / n);
                        if ((k / n) + 1 <= n) {
                            if (i == rest - 1) {
                                mat[i][0] = (k / n) + 1;
                            } else {
                                mat[i][i + 1] = (k / n) + 1;
                            }
                        }
                    } else {
                        mat[i][i] = (k / n) + 1;
                        if (i == n - 1) {
                            mat[i][rest] = (k / n);
                        } else {
                            mat[i][i + 1] = (k / n);
                        }
                    }
                }
//                pa("mat", mat);
                int size = n - 1;
                if ((k / n) + 1 <= n) {
                    size--;
                }
                int arr[] = new int[size];
                int ptr = 0;
                for (int i = (k / n) + 1 <= n ? (k / n) + 1 : 1; i != (k / n); i = (i + 1 <= n ? i + 1 : 1)) {
                    if (i == (k / n) || i == (k / n) + 1) {
                        continue;
                    }
                    arr[ptr++] = i;
                }
//                pa("arr", arr);
                for (int i = 0; i < n; ++i) {
                    ptr = 0;
                    for (int j = 0; j < n; ++j) {
                        if (mat[i][j] == -1 && ptr < arr.length) {
                            mat[i][j] = arr[ptr++];
                        }
                    }
                    arr = rotate(arr);
                }
//                pa("mat", mat);
                if (check(mat, n)) {
                    pl("Case #" + case_++ + ": POSSIBLE");
                    for (int i = 0; i < n; ++i) {
                        for (int j = 0; j < n; ++j) {
                            p(mat[i][j]);
                        }
                        pl();
                    }
                } else {
                    pl("Case #" + case_++ + ": IMPOSSIBLE");
                }
            }
        }
        pw.flush();
        pw.close();
    }

    static int[] shift(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        for(int i=0;i<n;++i) {
            if(i==0) {
                res[i] = arr[n-1];
            }
            else {
                res[i] = arr[i - 1];
            }
        }
        return res;
    }

    static int[] rotate(int arr[]) {
        if(arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        int res[] = new int[n];
        for(int i=0;i<n-1;++i) {
            res[i] = arr[i+1];
        }
        res[n-1] = arr[0];
        return res;
    }

    static boolean check(int mat[][], int n) {
        for(int i=0;i<n;++i) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=0;j<n;++j) {
                if(mat[i][j] < 1 || mat[i][j] > n) {
                    return false;
                }
                else {
                    set.add(mat[i][j]);
                }
            }
            if(set.size() != n) {
                return false;
            }
        }

        for(int i=0;i<n;++i) {
            HashSet<Integer> set = new HashSet<>();
            for(int j=0;j<n;++j) {
                if(mat[j][i] < 1 || mat[j][i] > n) {
                    return false;
                }
                else {
                    set.add(mat[j][i]);
                }
            }
            if(set.size() != n) {
                return false;
            }
        }
        return true;
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