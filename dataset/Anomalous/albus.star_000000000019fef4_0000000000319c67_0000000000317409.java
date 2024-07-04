import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        CustomScanner sc = new CustomScanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int t = 1; t <= testCaseCount; t++) {
            pw.print("Case #" + t + ": ");
            solve(pw, sc);
            pw.println();
        }
        pw.close();
    }

    public static void solve(PrintWriter pw, CustomScanner sc) throws IOException {
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        String directions = sc.next();
        int length = directions.length();
        Coordinate[] path = new Coordinate[length + 1];
        path[0] = new Coordinate(startX, startY);

        for (int i = 0; i < length; i++) {
            char direction = directions.charAt(i);
            int prevX = path[i].getX();
            int prevY = path[i].getY();
            switch (direction) {
                case 'W':
                    path[i + 1] = new Coordinate(prevX - 1, prevY);
                    break;
                case 'S':
                    path[i + 1] = new Coordinate(prevX, prevY - 1);
                    break;
                case 'N':
                    path[i + 1] = new Coordinate(prevX, prevY + 1);
                    break;
                case 'E':
                    path[i + 1] = new Coordinate(prevX + 1, prevY);
                    break;
            }
        }

        for (int i = 0; i <= length; i++) {
            int distance = Math.abs(path[i].getX()) + Math.abs(path[i].getY());
            if (distance <= i) {
                pw.print(i);
                return;
            }
        }
        pw.print("IMPOSSIBLE");
    }

    public static class CustomScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
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

    public static class Coordinate {
        private final int x;
        private final int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}