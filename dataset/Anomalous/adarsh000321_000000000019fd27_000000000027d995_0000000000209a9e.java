import java.io.*;
import java.util.*;

public class Solution {
    static int[] a;
    static int b;
    static FastReader sc;
    static int sameIndex, diffIndex;

    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        int testCases = sc.nextInt();
        b = sc.nextInt();
        a = new int[b];
        System.out.flush();

        for (int t = 1; t <= testCases; t++) {
            int count = 0;
            sameIndex = -1;
            diffIndex = -1;

            for (; count < 5; count++) {
                queryPair(count);
            }

            detectChange();

            while (count < b / 2) {
                int i = 0;
                for (; i < 4 && count < b / 2; i++) {
                    queryPair(count);
                    count++;
                }
                if (i == 4) {
                    detectChange();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(a[i]);
            }
            System.out.println(result);
            System.out.flush();

            String feedback = sc.next();
            System.out.flush();

            if (feedback.equals("N")) {
                return;
            }
        }
        sc.close();
    }

    static int query(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return sc.nextInt();
    }

    static void queryPair(int index) {
        a[index] = query(index);
        a[b - index - 1] = query(b - index - 1);

        if (sameIndex == -1 && a[index] == a[b - index - 1]) {
            sameIndex = index;
        }
        if (diffIndex == -1 && a[index] != a[b - index - 1]) {
            diffIndex = index;
        }
    }

    static void detectChange() {
        boolean complement = false;

        if (sameIndex != -1 && a[sameIndex] != query(sameIndex)) {
            complement = true;
        }

        boolean reverse = complement;

        if (diffIndex != -1 && a[diffIndex] != query(diffIndex)) {
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