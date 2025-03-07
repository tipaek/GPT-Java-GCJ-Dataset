import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
        patternmatching.FastReader keyboard = new patternmatching.FastReader();
        int T = keyboard.nextInt();
        for (int i = 0; i < T; i++) {
            int N = keyboard.nextInt();
            System.out.println("Case #" + (i + 1) + ": ");
            if (N >= 1)
                System.out.println("1 1");
            if (N >= 2)
                System.out.println("2 1");
            if (N >= 3)
                System.out.println("2 2");
            for (int j = 4; j <= N; j++)
                System.out.println((j - 1) + " " + (j - 1));
        }
    }
}
