import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuilder result = new StringBuilder();
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            StringBuilder caseResult = new StringBuilder("Case #" + (caseNumber++) + ": ");
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<Pair> pairs = new ArrayList<>();
            int val1 = r;
            int val2 = (r * s) - 1 - r;

            while (val1 > 1) {
                for (int i = 0; i < s - 1; i++) {
                    pairs.add(new Pair(val1, val2--));
                }
                val1--;
            }

            caseResult.append(pairs.size()).append("\n");
            for (Pair pair : pairs) {
                caseResult.append(pair.a).append(" ").append(pair.b).append("\n");
            }
            result.append(caseResult);
        }
        System.out.print(result);
    }
}

class Pair {
    int a, b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}