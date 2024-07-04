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
        FastReader keyboard = new FastReader();
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
            if (N >= 4)
                System.out.println("3 3");
            if (N >= 5)
                System.out.println("3 2");
            if (N >= 6)
                System.out.println("3 1");
            for (int j = 7; j <= N; j++)
                System.out.println((j - 3) + " " + 1);
        }
    }
}
