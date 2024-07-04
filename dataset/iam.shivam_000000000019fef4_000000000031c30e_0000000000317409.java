import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int T = fastReader.nextInt();

        for (int i = 0; i < T; i++) {
            String in[] = fastReader.nextLine().split(" ");

            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            String input = in[2];

            System.out.println("Case #" + (i + 1) + ": " + output(input, x, y));
        }
    }

    private static String output(String input, int x, int y) {
        int time = 0;
        int px = 0;
        int py = 0;

        for (int i = 0; i < input.length(); i++) {
            char direction = input.charAt(i);
            if (direction == 'N') {
                py--;
            } else if (direction == 'S') {
                py++;
            } else if (direction == 'E') {
                px++;
            } else if (direction == 'W') {
                px--;
            }

            if (Math.abs(x - px) + Math.abs(y - py) <= i + 1) {
                return String.valueOf(i + 1);
            }
        }
        return "IMPOSSIBLE";
    }

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

        void close() throws IOException {
            br.close();
        }
    }
}

