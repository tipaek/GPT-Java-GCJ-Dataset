import java.io.*;
import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    private static final int L = 1000000000;

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        if (B == L - 5) {
            solve1(T);
        }
    }

    private static String hit(int x, int y) throws IOException {
        writer.println(x + " " + y);
        writer.flush();
        return scanner.next();
    }

    private static void solve1(int t) throws IOException {
        while (t > 0) {
            t--;
            boolean found = false;
            for (int i = -5; i <= 5; i++) {
                for (int j = -5; j <= 5; j++) {
                    writer.println(i + " " + j);
                    writer.flush();
                    String s = scanner.next();
                    if (s.equals("CENTER")) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        }
    }

    private static void solve2(int t) throws IOException {
        while (t > 0) {
            t--;

            for (int i = 0; i <= 50; i += 10) {
                for (int j = -24; j < 25; j += 3) {
                    String s = hit(j, L - i - 1);
                    if (s.equals("HIT")) break;
                }
                if (j < 25) break;
            }

            int st = (i != 0) ? i - 10 : 0;

            for (i = st;; i++) {
                for (int j = -24; j < 25; j += 3) {
                    String s = hit(j, L - i - 1);
                    if (s.equals("HIT")) break;
                }
                if (j < 25) break;
            }

            i = 25 - i;
            String s = hit(j, i);
            if (s.equals("CENTER")) continue;
            if (hit(j - 1, i).equals("CENTER")) continue;
            if (hit(j + 1, i).equals("CENTER")) continue;

            throw new IOException();
        }
    }
}