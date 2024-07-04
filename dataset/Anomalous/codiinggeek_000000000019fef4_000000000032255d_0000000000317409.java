import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final long MOD = 1_000_000_000L;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int e = reader.nextInt();
            int n = reader.nextInt();
            String directions = reader.next();
            int length = directions.length();
            int result = -1;
            boolean found = false;

            for (int i = 0; i < length; i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'N':
                        n++;
                        break;
                    case 'S':
                        n--;
                        break;
                    case 'E':
                        e++;
                        break;
                    case 'W':
                        e--;
                        break;
                }
                result = i + 1;
                if (result >= Math.abs(e) + Math.abs(n)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
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