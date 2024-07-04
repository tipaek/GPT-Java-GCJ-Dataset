import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[] path = in.next().toCharArray();

            int[] distances = new int[path.length + 1];
            distances[0] = Math.abs(x) + Math.abs(y);

            int currentX = x, currentY = y;
            int minSteps = Integer.MAX_VALUE;
            int result = -1;

            for (int i = 0; i < path.length; i++) {
                switch (path[i]) {
                    case 'N': currentY++; break;
                    case 'S': currentY--; break;
                    case 'E': currentX++; break;
                    case 'W': currentX--; break;
                }
                distances[i + 1] = Math.abs(currentX) + Math.abs(currentY);
            }

            for (int i = 0; i < distances.length; i++) {
                if (distances[i] <= i) {
                    minSteps = distances[i];
                    result = i;
                    break;
                }
            }

            if (result == -1) {
                out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                out.println("Case #" + t + ": " + result);
            }
        }

        out.close();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
            String line = "";
            try {
                line = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }
    }
}