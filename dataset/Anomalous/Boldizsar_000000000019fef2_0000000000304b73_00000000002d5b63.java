import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        Solver solver = new Solver();
        
        int testCount = Integer.parseInt(scanner.nextLine().trim().split(" ")[0]);
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, scanner, writer);
        }
        
        writer.close();
    }
}

class Solver {
    private static final int MAX_ATTEMPTS = 302;
    private static final int BOUND = 10;

    public void solve(int testNumber, Scanner scanner, PrintWriter writer) {
        for (int attempt = 0; attempt < MAX_ATTEMPTS; attempt++) {
            int a = (int) (Math.random() * 2 * BOUND) - BOUND;
            int b = (int) (Math.random() * 2 * BOUND) - BOUND;
            
            writer.printf("%d %d\n", a, b);
            writer.flush();
            
            String response = scanner.nextLine().trim();
            if ("CENTER".equals(response)) {
                return;
            } else if (!"HIT".equals(response) && !"MISS".equals(response)) {
                throw new IllegalArgumentException("Unexpected response: " + response + " for coordinates: " + a + " " + b);
            }
        }
        
        throw new IllegalArgumentException("Exceeded maximum attempts");
    }
}