import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter writer = new PrintWriter(System.out);

        Solver solver = new Solver();
        int testCount = Integer.parseInt(scanner.nextLine().split(" ")[0]);

        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, scanner, writer);
        }

        writer.close();
    }

    private static class Solver {

        public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
            for (int i = 0; i < 302; i++) {
                int x = (int) (-10 + (Math.random() * 20));
                int y = (int) (-10 + (Math.random() * 20));
                writer.printf("%d %d\n", x, y);
                writer.flush();

                String response = scanner.nextLine();
                if ("CENTER".equals(response)) {
                    return;
                } else if (!"HIT".equals(response) && !"MISS".equals(response)) {
                    throw new IllegalArgumentException(x + " " + y);
                }
            }
            throw new IllegalArgumentException("Exceeded maximum attempts");
        }
    }
}