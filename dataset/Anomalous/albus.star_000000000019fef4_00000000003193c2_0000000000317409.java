import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        CustomScanner sc = new CustomScanner(System.in);
        int testCases = sc.nextInt();
        for (int t = 1; t <= testCases; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, CustomScanner sc) throws IOException {
        int x = sc.nextInt();
        int y = sc.nextInt();
        String directions = sc.next();
        int length = directions.length();
        Coordinate[] coordinates = new Coordinate[length + 1];
        coordinates[0] = new Coordinate(x, y);

        for (int i = 0; i < length; i++) {
            char direction = directions.charAt(i);
            int prevX = coordinates[i].x;
            int prevY = coordinates[i].y;

            switch (direction) {
                case 'W':
                    coordinates[i + 1] = new Coordinate(prevX + 1, prevY);
                    break;
                case 'S':
                    coordinates[i + 1] = new Coordinate(prevX, prevY - 1);
                    break;
                case 'N':
                    coordinates[i + 1] = new Coordinate(prevX, prevY + 1);
                    break;
                case 'E':
                    coordinates[i + 1] = new Coordinate(prevX - 1, prevY);
                    break;
            }
        }

        for (int i = 0; i <= length; i++) {
            int distance = Math.abs(coordinates[i].x) + Math.abs(coordinates[i].y);
            if (distance <= i) {
                pw.print(i);
                return;
            }
        }

        pw.print("IMPOSSIBLE");
    }

    static class CustomScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        public String next() throws IOException {
            ensureTokenizer();
            return tokenizer.nextToken();
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        }
    }

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}