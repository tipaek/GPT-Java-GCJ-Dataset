import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        
        int testCases = reader.nextInt();
        for (int t = 0; t < testCases; t++) {

            int number = reader.nextInt();
            System.out.println("Case #" + (t + 1) + ":");

            if (number == 501) {
                System.out.println("1 1");
                System.out.println("2 2");
                System.out.println("3 2");
                for (int i = 3; i <= 497; i++) {
                    System.out.println(i + " " + i);
                }
            } else {
                for (int i = 1; i <= number; i++) {
                    System.out.println(i + " " + i);
                }
            }        
        }
    }

    public static class FastReader {
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreTokens()) {
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
}