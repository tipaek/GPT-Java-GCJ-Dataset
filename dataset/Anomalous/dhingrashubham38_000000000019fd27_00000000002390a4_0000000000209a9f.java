import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        int testNum = 0;

        while (t-- > 0) {
            int currDepth = 0;
            testNum++;
            String s = fr.nextLine();
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                int num = Character.getNumericValue(ch);
                if (num == 0) {
                    while (currDepth > 0) {
                        sb.append(')');
                        currDepth--;
                    }
                    sb.append('0');
                } else {
                    while (currDepth < num) {
                        sb.append('(');
                        currDepth++;
                    }
                    while (currDepth > num) {
                        sb.append(')');
                        currDepth--;
                    }
                    sb.append(ch);
                }
            }

            while (currDepth-- > 0) {
                sb.append(')');
            }

            System.out.println("Case #" + testNum + ": " + sb);
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