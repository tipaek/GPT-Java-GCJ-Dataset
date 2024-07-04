import java.awt.*;
import java.io.*;
import java.util.*;

public class Drogon {
    static int[] array;
    static int b;
    static FastReader sc;
    static int sameIndex, diffIndex;

    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        int t = sc.nextInt();
        b = sc.nextInt();
        array = new int[b];

        for (int tst = 1; tst <= t; tst++) {
            sameIndex = -1;
            diffIndex = -1;
            int c = 0;

            for (int i = 0; i < 5; i++) {
                findIndices(i);
            }
            applyChanges();

            while (c < b / 2) {
                int i = 0;
                for (; i < 4 && c < b / 2; c++) {
                    i++;
                    findIndices(c);
                }
                if (i == 4) {
                    applyChanges();
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) {
                sb.append(array[i]);
            }
            System.out.println(sb);
            System.out.flush();
            sc.close();
        }
    }

    static int query(int i) {
        System.out.println(i + 1);
        System.out.flush();
        return sc.nextInt();
    }

    static void findIndices(int i) {
        array[i] = query(i);
        array[b - i - 1] = query(b - i - 1);

        if (sameIndex == -1 && array[i] == array[b - i - 1]) {
            sameIndex = i;
        }
        if (diffIndex == -1 && array[i] != array[b - i - 1]) {
            diffIndex = i;
        }
    }

    static void applyChanges() {
        int complement = 0;

        if (sameIndex != -1 && array[sameIndex] != query(sameIndex)) {
            complement = 1;
        }

        int reverse = complement;

        if (diffIndex != -1 && array[diffIndex] != query(diffIndex)) {
            reverse = complement == 0 ? 1 : 0;
        }

        if (complement == 1) {
            for (int i = 0; i < b; i++) {
                array[i] = 1 - array[i];
            }
        }

        if (reverse == 1) {
            for (int i = 0; i < b / 2; i++) {
                int temp = array[i];
                array[i] = array[b - i - 1];
                array[b - i - 1] = temp;
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