import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public void run() throws Exception {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            int number = reader.nextInt();
            System.out.println("Case #" + (caseIndex + 1) + ":");
            for (int i = 1; i <= number; i++) {
                System.out.println(i + " " + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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