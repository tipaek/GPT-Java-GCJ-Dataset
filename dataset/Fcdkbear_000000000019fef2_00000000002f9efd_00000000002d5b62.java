import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int tests = in.nextInt();
        for (int testNumber = 1; testNumber <= tests; ++testNumber) {
            int x = in.nextInt();
            int y = in.nextInt();
            StringBuilder res = new StringBuilder();
            boolean possible = true;
            boolean revX = (x < 0);
            boolean revY = (y < 0);
            x = Math.abs(x);
            y = Math.abs(y);
            while ((x != 0) || (y != 0)) {
                if ((x % 2) == (y % 2)) {
                    possible = false;
                    break;
                }
                if ((x == 0) && (y == 1)) {
                    res.append('N');
                    break;
                }
                if ((x == 0) && (y == -1)) {
                    res.append('S');
                    break;
                }
                if ((x == 1) && (y == 0)) {
                    res.append('E');
                    break;
                }
                if ((x == -1) && (y == 0)) {
                    res.append('W');
                    break;
                }
                if (x % 2 == 1) {
                    int nextY = y / 2;
                    if (((x + 1) / 2) % 2 == (nextY % 2)) {
                        x = (x - 1) / 2;
                        res.append('E');
                    } else {
                        x = (x + 1) / 2;
                        res.append('W');
                    }
                    y = nextY;
                } else {
                    int nextX = x / 2;
                    if (((y + 1) / 2) % 2 == (nextX % 2)) {
                        y = (y - 1) / 2;
                        res.append('N');
                    } else {
                        y = (y + 1) / 2;
                        res.append('S');
                    }
                    x = nextX;
                }
            }
            out.printf("Case #%d: ", testNumber);
            if (possible) {
                String s = res.toString();
                for (char c : s.toCharArray()) {
                    if ((c == 'N') && revY){
                        c = 'S';
                    } else if (c == 'S' && revY) {
                        c = 'N';
                    } else if (c == 'E' && revX) {
                        c = 'W';
                    } else if (c == 'W' && revX) {
                        c = 'E';
                    }
                    out.print(c);
                }
                out.println();
            } else {
                out.println("IMPOSSIBLE");
            }
            out.flush();
        }
        out.close();

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
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
