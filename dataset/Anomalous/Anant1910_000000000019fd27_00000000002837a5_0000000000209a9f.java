import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
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
        FastReader input = new FastReader();
        int T = input.nextInt();

        for (int t = 1; t <= T; t++) {
            String s = input.nextLine();
            StringBuilder output = new StringBuilder();
            int n = s.length();
            int balance = 0;

            for (int i = 0; i < n; i++) {
                int digit = s.charAt(i) - '0';
                while (balance < digit) {
                    output.append('(');
                    balance++;
                }
                while (balance > digit) {
                    output.append(')');
                    balance--;
                }
                output.append(digit);
            }
            while (balance > 0) {
                output.append(')');
                balance--;
            }
            System.out.println("Case #" + t + ": " + output);
        }
    }
}