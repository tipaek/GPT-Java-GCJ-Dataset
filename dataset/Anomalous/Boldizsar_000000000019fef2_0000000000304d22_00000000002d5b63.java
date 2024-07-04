import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {

            Solver solver = new Solver();
            int testCount = Integer.parseInt(in.nextLine().trim());

            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
        }
    }

    private static class Solver {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            for (int i = 0; i < 302; ++i) {
                int a = (int) (-10 + (Math.random() * 20));
                int b = (int) (-10 + (Math.random() * 20));
                out.printf("%d %d%n", a, b);
                out.flush();

                String response = in.nextLine().trim();
                if ("CENTER".equals(response)) {
                    return;
                } else if (!"HIT".equals(response) && !"MISS".equals(response)) {
                    throw new IllegalArgumentException(a + " " + b);
                }
            }
            throw new IllegalArgumentException("Failed to find the center within 302 attempts.");
        }
    }
}