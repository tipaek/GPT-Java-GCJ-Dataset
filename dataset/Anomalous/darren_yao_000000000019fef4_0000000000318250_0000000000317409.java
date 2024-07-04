import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
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
    }

    static FastReader reader = new FastReader(System.in);
    static PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = reader.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            String directions = reader.next();
            int length = directions.length();
            boolean found = false;
            int step = 0;

            for (step = 0; step < length; step++) {
                char direction = directions.charAt(step);
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= step + 1) {
                    found = true;
                    break;
                }
            }

            if (found) {
                writer.println("Case #" + caseNum + ": " + (step + 1));
            } else {
                writer.println("Case #" + caseNum + ": IMPOSSIBLE");
            }
        }

        writer.close();
    }
}