import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static int[] array;
    private static int b;
    private static FastReader sc;
    private static int sameIndex, diffIndex;

    public static void main(String[] args) throws Exception {
        sc = new FastReader();
        int testCases = sc.nextInt();
        b = sc.nextInt();
        array = new int[b];

        for (int t = 1; t <= testCases; t++) {
            sameIndex = -1;
            diffIndex = -1;
            int c = 0;

            for (; c < 5; c++) {
                findPair(c);
            }

            detectChange();

            while (c < b / 2) {
                int i = 0;
                for (; i < 4 && c < b / 2; i++) {
                    findPair(c);
                    c++;
                }
                if (i == 4) {
                    detectChange();
                }
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < b; i++) {
                result.append(array[i]);
            }
            System.out.println(result);
            System.out.flush();

            String response = sc.next();
            if (response.equals("N")) {
                System.exit(0);
            }
        }
        sc.close();
    }

    private static int query(int index) {
        System.out.println(index + 1);
        System.out.flush();
        return sc.nextInt();
    }

    private static void findPair(int index) {
        array[index] = query(index);
        array[b - index - 1] = query(b - index - 1);

        if (sameIndex == -1 && array[index] == array[b - index - 1]) {
            sameIndex = index;
        }
        if (diffIndex == -1 && array[index] != array[b - index - 1]) {
            diffIndex = index;
        }
    }

    private static void detectChange() {
        boolean complement = false;

        if (sameIndex != -1 && array[sameIndex] != query(sameIndex)) {
            complement = true;
        }

        boolean reverse = complement;
        if (diffIndex != -1 && array[diffIndex] != query(diffIndex)) {
            reverse = !complement;
        }

        if (complement) {
            for (int i = 0; i < b; i++) {
                array[i] = array[i] == 0 ? 1 : 0;
            }
        }

        if (reverse) {
            for (int i = 0; i < b / 2; i++) {
                int temp = array[i];
                array[i] = array[b - i - 1];
                array[b - i - 1] = temp;
            }
        }
    }

    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public void close() throws Exception {
            br.close();
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
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