import java.util.*;
import java.io.*;

public class Solution {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        
        int t = nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int x = nextInt();
            int y = nextInt();
            String directions = next();

            boolean reached = false;
            int xCurrent = 0, yCurrent = 0;

            for (int i = 0; i < directions.length(); i++) {
                char move = directions.charAt(i);
                switch (move) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                if (Math.abs(xCurrent - x) + Math.abs(yCurrent - y) <= i + 1) {
                    out.println("Case #" + caseNumber + ": " + (i + 1));
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }

            caseNumber++;
        }
        
        out.close();
    }

    private static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}