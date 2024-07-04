import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             PrintWriter out = new PrintWriter(System.out)) {
            Solver solver = new Solver();
            int testCount = Integer.parseInt(in.nextLine());
            for (int i = 1; i <= testCount; i++) {
                solver.solve(i, in, out);
            }
        }
    }

    private static class Solver {

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            String ab = in.nextLine();
            for (int k = 0; k < 3; k++) {
                for (int i = -10; i <= 10; i++) {
                    for (int j = -10; j <= 10; j++) {
                        out.printf("%d %d", i, j);
                        out.flush();
                        String response = in.nextLine();
                        if ("CENTER".equals(response)) {
                            return;
                        } else if (!"HIT".equals(response) && !"MISS".equals(response)) {
                            throw new IllegalArgumentException();
                        }
                    }
                }
            }
        }
    }
}