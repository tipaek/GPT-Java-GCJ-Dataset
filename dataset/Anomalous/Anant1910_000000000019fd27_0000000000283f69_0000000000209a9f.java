import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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
            StringBuilder result = new StringBuilder();
            int previousValue = 0;

            for (char c : s.toCharArray()) {
                int currentValue = Character.getNumericValue(c);

                while (previousValue < currentValue) {
                    result.append('(');
                    previousValue++;
                }
                while (previousValue > currentValue) {
                    result.append(')');
                    previousValue--;
                }
                result.append(c);
            }

            while (previousValue > 0) {
                result.append(')');
                previousValue--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}