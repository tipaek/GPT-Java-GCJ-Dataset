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
            int n = scan.nextInt();
            ArrayList<String> starts = new ArrayList<>();
            ArrayList<String> ends = new ArrayList<>();
            ArrayList<String> mid = new ArrayList<>();
            for(int i=0;i<n;++i) {
                String s = ne();
                StringBuilder reduced = new StringBuilder();
                int len = s.length();
                for(int j=0;j<len;++j) {
                    reduced.append(s.charAt(j));
                    if(s.charAt(j) == '*') {
                        while (j+1<len && s.charAt(j+1) == '*') {
                            j++;
                        }
                    }
                }

                if(reduced.charAt(0)!='*') {
                    StringBuilder start_ = new StringBuilder();
                    int ptr = 0;
                    while (ptr<reduced.length() && reduced.charAt(ptr) != '*') {
                        start_.append(reduced.charAt(ptr));
                        ptr++;
                    }
                    starts.add(start_.toString());
                }
                int l = reduced.length();

                if(reduced.charAt(l-1)!='*') {
                    int ptr = l-1;
                    StringBuilder ends_ = new StringBuilder();
                    while (ptr>=0 && reduced.charAt(ptr) != '*') {
                        ends_.append(reduced.charAt(ptr));
                        ptr--;
                    }
                    ends.add(ends_.reverse().toString());
                }

                for(int j=0;j<l;++j) {
                    if(reduced.charAt(j)!='*') {
                        StringBuilder mid_ = new StringBuilder();
                        mid_.append(reduced.charAt(j));
                        while (j+1<l && reduced.charAt(j+1) != '*') {
                            j++;
                            mid_.append(reduced.charAt(j));
                        }
                        mid.add(mid_.toString());
                    }
                }
            }


//            pa("start", starts);
//            pa("ends", ends);
//            pa("mid", mid);
            String pref = null;
            String suff = null;
            if(starts.isEmpty()) {
                pref = "";
            }
            else {
                for(int i=0;i<starts.size();++i) {
                    boolean flag = true;
                    for(int j=0;j<starts.size();++j) {
                        if(!starts.get(i).startsWith(starts.get(j))) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        pref = starts.get(i);
                    }
                }
            }

            if(ends.isEmpty()) {
                suff = "";
            }
            else {
                for(int i=0;i<ends.size();++i) {
                    boolean flag = true;
                    for(int j=0;j<ends.size();++j) {
                        if(!ends.get(i).endsWith(ends.get(j))) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        suff = ends.get(i);
                    }
                }
            }

            if(suff==null || pref==null) {
                pl("*");
            }
            else {
                StringBuilder ans = new StringBuilder();
                ans.append(pref);
                for(String s : mid) {
                    ans.append(s);
                }
                ans.append(suff);
                pl(ans.toString());
            }

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