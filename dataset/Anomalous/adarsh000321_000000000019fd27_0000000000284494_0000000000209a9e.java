import java.io.*;
import java.util.*;

public class Solution {
    static int[] a;
    static int b;
    static FastReader sc;
    static int same, diff;

    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        int t = sc.nextInt();
        b = sc.nextInt();
        a = new int[b];

        for (int tst = 1; tst <= t; tst++) {
            int c = 0;
            same = -1;
            diff = -1;

            for (; c < 5; c++) {
                findPair(c);
            }

            findChange();

            while (c < b / 2) {
                int i = 0;
                for (; i < 4 && c < b / 2; i++) {
                    findPair(c);
                    c++;
                }
                findChange();
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) {
                sb.append(a[i]);
            }
            System.out.println(sb);
            System.out.flush();

            String response = sc.next();
            if (response.equals("N")) {
                System.exit(0);
            }
        }
    }

    static int query(int i) {
        System.out.println(i + 1);
        System.out.flush();
        return sc.nextInt();
    }

    static void findPair(int i) {
        a[i] = query(i);
        a[b - i - 1] = query(b - i - 1);

        if (same == -1 && a[i] == a[b - i - 1]) {
            same = i;
        }
        if (diff == -1 && a[i] != a[b - i - 1]) {
            diff = i;
        }
    }

    static void findChange() {
        boolean complement = false;
        if (same != -1 && a[same] != query(same)) {
            complement = true;
        }

        boolean reverse = complement;
        if (diff != -1 && a[diff] != query(diff)) {
            reverse = !complement;
        }

        if (complement) {
            for (int i = 0; i < b; i++) {
                a[i] = a[i] == 0 ? 1 : 0;
            }
        }

        if (reverse) {
            for (int i = 0; i < b / 2; i++) {
                int temp = a[i];
                a[i] = a[b - i - 1];
                a[b - i - 1] = temp;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() throws Exception {
            br.close();
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