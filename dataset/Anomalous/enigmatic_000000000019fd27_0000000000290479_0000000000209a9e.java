import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Thread(null, Solution::solve, "1", 1 << 26).start();
    }

    static void solve() {
        FastReader fr = new FastReader();
        PrintWriter op = new PrintWriter(System.out);

        int t = fr.nextInt();
        while (t-- > 0) {
            int b = fr.nextInt();
            int[] ar = new int[b + 1];

            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                ar[i] = fr.nextInt();
                System.out.flush();

                System.out.println(b - i + 1);
                ar[b - i + 1] = fr.nextInt();
                System.out.flush();
            }

            for (int i = 1; i <= b; i++) {
                System.out.print(ar[i]);
            }
            System.out.println();
            System.out.flush();

            String s = fr.next();
        }
        op.close();
    }

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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}