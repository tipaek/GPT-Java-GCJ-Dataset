import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuilder ans = new StringBuilder();
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            StringBuilder caseResult = new StringBuilder("Case #" + (caseNumber++) + ": ");
            int r = sc.nextInt();
            int s = sc.nextInt();
            List<Pair> moves = new ArrayList<>();
            int initialCard = r;
            int targetPosition = (r * s) - 1 - r;

            while (initialCard > 1) {
                for (int i = 0; i < s - 1; i++) {
                    moves.add(new Pair(initialCard, targetPosition--));
                }
                initialCard--;
            }

            caseResult.append(moves.size()).append("\n");
            for (Pair move : moves) {
                caseResult.append(move.a).append(" ").append(move.b).append("\n");
            }
            ans.append(caseResult);
        }
        System.out.print(ans);
    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}