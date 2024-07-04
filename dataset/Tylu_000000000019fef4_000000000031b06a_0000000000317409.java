import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {


    public static void main(String[] args) throws IOException {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(System.out);
        int numberOfCases = sc.nextInt();

        for (int caze = 1; caze <= numberOfCases; caze++) {
            int X = sc.nextInt();
            int Y = sc.nextInt();
            String path = sc.next();

            int print = print(numberOfCases, X, Y, path);
            if (print >= 0) {
                System.out.println("Case #" + caze + ": " + print);
            } else {
                System.out.println("Case #" + caze + ": IMPOSSIBLE");
            }
        }
    }

    private static int print(int numberOfCases, int x, int y, String path) {
        if (x == 0 && y == 0) {
            return 0;
        }

        String[] split = path.split("");
        int t = 0;
        for (int i = 0; i < split.length; i++) {
            int bdist = Math.abs(x) + Math.abs(y);
            if (bdist == t + 1) {
                if (y > 0 && split[i ].equals("S")) {
                    return t + 1;
                }
                if (y < 0 && split[i].equals("N")) {
                    return t + 1;
                }
                if (x > 0 && split[i].equals("W")) {
                    return t + 1;
                }
                if (x < 0 && split[i].equals("E")) {
                    return t + 1;
                }
            }


            switch (split[i]) {
                case "S":
                    y--;
                    break;
                case "N":
                    y++;
                    break;
                case "E":
                    x++;
                    break;
                case "W":
                    x--;
                    break;
            }
            t++;

//            System.out.println(x + " " + y + " " + t);
            int dist = Math.abs(x) + Math.abs(y);
            if (dist == t) {
                return t;
            }
        }
        return -1;
    }

    static class MyScanner {
        private BufferedReader br;
        private StringTokenizer tokenizer;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(br.readLine());
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
