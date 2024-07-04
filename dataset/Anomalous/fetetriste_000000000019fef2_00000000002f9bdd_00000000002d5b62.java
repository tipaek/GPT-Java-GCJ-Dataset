import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner scanner = new FastScanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        ExpogoSolver solver = new ExpogoSolver();
        solver.solve(scanner, writer);
        writer.close();
    }
}

class ExpogoSolver {
    public void solve(FastScanner scanner, PrintWriter writer) {
        int numTests = scanner.nextInt();
        for (int test = 1; test <= numTests; test++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            writer.printf("Case #%d: %s\n", test, findPath(x, y));
        }
    }

    private String findPath(int x, int y) {
        StringBuilder path = new StringBuilder();
        while (x != 0 || y != 0) {
            if (isEven(x) == isEven(y)) {
                return "IMPOSSIBLE";
            }
            if (x == 0) {
                path.append(y < 0 ? "S" : "N");
                y -= Math.signum(y);
            } else if (y == 0) {
                path.append(x < 0 ? "W" : "E");
                x -= Math.signum(x);
            } else if (isEven(x)) {
                if (isEven((y + 1) / 2) != isEven(x / 2)) {
                    y++;
                    path.append("S");
                } else {
                    y--;
                    path.append("N");
                }
            } else {
                if (isEven((x + 1) / 2) != isEven(y / 2)) {
                    x++;
                    path.append("W");
                } else {
                    x--;
                    path.append("E");
                }
            }
            x /= 2;
            y /= 2;
        }
        return path.toString();
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}

class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}