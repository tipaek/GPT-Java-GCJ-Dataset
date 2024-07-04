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

    static int arr[];
    static void solve() throws IOException
    {
        //initIo(true, "");
        initIo(false, "");
        StringBuilder sb = new StringBuilder();
        int t = ni(), b = ni();
        while (t-->0) {
            int ptr = 1;
//            init(b);
            ArrayList<Integer> diff_zero = new ArrayList<>();
            ArrayList<Integer> one = new ArrayList<>();
            ArrayList<Integer> zero = new ArrayList<>();
            for(int i=1;i<=150;) {
                if(i%10==1) {
                    if(!diff_zero.isEmpty()) {
                        char new_val = query(diff_zero.get(0), i++);
                        if(new_val == '1') {
                            complement(diff_zero, b);
                        }
                    }
                    if(!one.isEmpty()) {
                        char new_val = query(one.get(0), i++);
                        if(new_val == '0') {
                            ArrayList<Integer> temp = one;
                            one = zero;
                            zero = temp;
                        }
                    }
                    else if(!zero.isEmpty()) {
                        char new_val = query(zero.get(0), i++);
                        if(new_val == '1') {
                            ArrayList<Integer> temp = one;
                            one = zero;
                            zero = temp;
                        }
                    }
                }

                if(ptr <= (b+1)/2) {
                    if(i%10 != 0) {
                        char c1 = query(ptr, i++);
                        char c2 = query(b - (ptr-1), i++);
//                        pl("c1 : "+c1+" c2 : "+c2);
                        if(c1==c2) {
                            if(c1=='0') {
//                                pl("Added "+ptr+" to zero");
                                zero.add(ptr);
                            }
                            else {
//                                pl("Added "+ptr+" to one");
                                one.add(ptr);
                            }
                        }
                        else {
                            if(c1=='0') {
//                                pl("Added "+ptr+" to diff_zero");
                                diff_zero.add(ptr);
                            }
                            else {
//                                pl("Added "+(b - (ptr-1))+" to diff_zero");
                                diff_zero.add((b - (ptr-1)));
                            }
                        }
                        ptr++;
                    }
                    else {
                        //wasting this
                        query(1,i++);
                    }
                }
                else {
                    break;
                }

            }
//            pl("ptr finally : "+ptr);
            char ans[] = new char[b+1];
            for(int e : diff_zero) {
                ans[e] = '0';
                ans[b - (e-1)] = '1';
            }
            for(int e : zero) {
                ans[e] = ans[b - (e-1)] = '0';
            }
            for(int e : one) {
                ans[e] = ans[b - (e-1)] = '1';
            }
            sb = new StringBuilder();
            for(int i=1;i<=b;++i) {
                sb.append(ans[i]);
            }
            pw.println(sb);
            pw.flush();
//            for(int i=0;i<arr.length;++i) {
//                if(arr[i]!=ans[i+1] - '0') {
//                    pl("Answers differ: ");
//                    pa("Your : ", ans);
//                    pa("Actual : ", arr);
//                    System.exit(1);
//                }
//            }
            char c = ne().charAt(0);
            if(c=='N') {
                System.exit(1);
            }
        }
        pw.flush();
        pw.close();
    }
    static void complement(ArrayList<Integer> list, int B) {
        for(int i=0;i<list.size();i++) {
            list.set(i, B - (list.get(i) - 1));
        }
    }

    static char query(int idx, int query_no) throws IOException {
        pl(idx);
        pw.flush();
        char c = ne().charAt(0);
        if(c=='N') {
            System.exit(1);
        }
        return c;
    }

    static void init(int len) {
        arr = new int[len];
        for(int i=0;i<len;++i) {
            arr[i] = (int)(random()*2);
        }
//        pa("Initial Array : ", arr);
    }

    static char ask(int query_no, int idx) {
        if(query_no%10==1) {
            int random_integer_4 = 1 + (int)(random()*4);
            if(random_integer_4 < 1 || random_integer_4 > 4) {
                System.exit(1);
            }
            if(random_integer_4==1) {
                //do nothing
            }
            else if(random_integer_4 == 2) {
                flip();
//                pl("Flipped!");
            }
            else if(random_integer_4 == 3) {
                flip();
                reverse();
//                pl("Flipped and Reversed");
            }
            else {
                reverse();
//                pl("Reversed");
            }
        }
        return (char)('0'+arr[idx-1]);
    }

    static void flip() {
        for(int i=0;i<arr.length;++i) {
            arr[i] = 1 - arr[i];
        }
    }

    static void reverse() {
        for(int i=0;i<arr.length/2;++i) {
            int ulta = arr.length - 1 - i;
            int temp = arr[i];
            arr[i] = arr[ulta];
            arr[ulta] = temp;
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