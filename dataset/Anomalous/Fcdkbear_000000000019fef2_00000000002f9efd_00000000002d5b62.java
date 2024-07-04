import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader in = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = in.nextInt();

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int x = in.nextInt();
            int y = in.nextInt();
            StringBuilder result = new StringBuilder();
            boolean isPossible = true;
            boolean reverseX = x < 0;
            boolean reverseY = y < 0;

            x = Math.abs(x);
            y = Math.abs(y);

            while (x != 0 || y != 0) {
                if (x % 2 == y % 2) {
                    isPossible = false;
                    break;
                }
                if (x == 0 && y == 1) {
                    result.append('N');
                    break;
                }
                if (x == 0 && y == -1) {
                    result.append('S');
                    break;
                }
                if (x == 1 && y == 0) {
                    result.append('E');
                    break;
                }
                if (x == -1 && y == 0) {
                    result.append('W');
                    break;
                }

                if (x % 2 == 1) {
                    int nextY = y / 2;
                    if (((x + 1) / 2) % 2 == nextY % 2) {
                        x = (x - 1) / 2;
                        result.append('E');
                    } else {
                        x = (x + 1) / 2;
                        result.append('W');
                    }
                    y = nextY;
                } else {
                    int nextX = x / 2;
                    if (((y + 1) / 2) % 2 == nextX % 2) {
                        y = (y - 1) / 2;
                        result.append('N');
                    } else {
                        y = (y + 1) / 2;
                        result.append('S');
                    }
                    x = nextX;
                }
            }

            out.printf("Case #%d: ", testCase);
            if (isPossible) {
                String path = result.toString();
                for (char direction : path.toCharArray()) {
                    if (direction == 'N' && reverseY) {
                        out.print('S');
                    } else if (direction == 'S' && reverseY) {
                        out.print('N');
                    } else if (direction == 'E' && reverseX) {
                        out.print('W');
                    } else if (direction == 'W' && reverseX) {
                        out.print('E');
                    } else {
                        out.print(direction);
                    }
                }
                out.println();
            } else {
                out.println("IMPOSSIBLE");
            }
            out.flush();
        }
        out.close();
    }

    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}