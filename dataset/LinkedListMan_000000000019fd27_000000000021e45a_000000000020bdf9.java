import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            int n = scan.nextInt();
            Item[] a = new Item[n];
            for(int i = 0; i < n; i++) a[i] = new Item(scan.nextInt(), scan.nextInt(), i);
            Arrays.sort(a, new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    int ret = Integer.compare(o1.a, o2.a);
                    if(ret == 0) ret = Integer.compare(o1.b, o2.b);
                    return ret;
                }
            });
            boolean[] res = new boolean[n];
            char[] ans = new char[n];
            int prevEnd = -1;
            for(int i = 0; i < n; i++) {
                if(a[i].a >= prevEnd) {
                    res[i] = true;
                    prevEnd = a[i].b;
                }
            }
            prevEnd = -1;
            for(int i = 0; i < n; i++) {
                if(!res[i]) {
                    if(a[i].a < prevEnd) {
                        out.println("IMPOSSIBLE");
                        return;
                    }
                    prevEnd = a[i].b;
                }
                ans[a[i].index] = res[i] ? 'C' : 'J';
            }
            out.println(new String(ans));
        }

        static class Item {
            int a, b;
            int index;
            public Item(int aa, int bb, int x) {
                a = aa;
                b = bb;
                index = x;
            }
        }

    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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

}