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
        for(int case_=1;case_<=t;++case_) {
            p("Case #"+case_+":");
            int n = ni(), m = ni();
            int mat[][] = new int[n][m];
            for(int i=0;i<n;++i) {
                for(int j=0;j<m;++j) {
                    mat[i][j] = ni();
                }
            }

            long sum = 0;
            while (true) {
                //pa("mat", mat);
                for(int i=0;i<n;++i) {
                    for(int j=0;j<m;++j) {
                        sum+=mat[i][j];
                    }
                }

                boolean eli[][] = new boolean[n][m];
                int cnt = 0;
                for(int i=0;i<n;++i) {
                    for(int j=0;j<m;++j) {
                        if(mat[i][j] == 0) {
                            continue;
                        }
                        int left = 0, right = 0, top = 0, down = 0, neigh = 0;
                        for(int row=i-1;row>=0;--row) {
                            if(mat[row][j] != 0) {
                                top = mat[row][j];
                                neigh++;
                                break;
                            }
                        }

                        for(int row=i+1;row<n;++row) {
                            if(mat[row][j] != 0) {
                                down = mat[row][j];
                                neigh++;
                                break;
                            }
                        }

                        for(int col=j-1;col>=0;--col) {
                            if(mat[i][col] != 0) {
                                left = mat[i][col];
                                neigh++;
                                break;
                            }
                        }

                        for(int col=j+1;col<m;++col) {
                            if(mat[i][col] != 0) {
                                right = mat[i][col];
                                neigh++;
                                break;
                            }
                        }

                        //pl("i : "+i+" j : "+j+" left : "+left+" right : "+right+" top : "+top+" down : "+down);

                        if(neigh*mat[i][j] < left+right+top+down) {
                            eli[i][j] = true;
                            cnt++;
                        }
                    }
                }

                //pl("cnt : "+cnt);
                if(cnt==0) {
                    break;
                }
                else {
                    for(int i=0;i<n;++i) {
                        for(int j=0;j<m;++j) {
                            if(eli[i][j]) {
                                mat[i][j] = 0;
                            }
                        }
                    }
                }
            }
            pl(sum);
        }
        pw.flush();
        pw.close();
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