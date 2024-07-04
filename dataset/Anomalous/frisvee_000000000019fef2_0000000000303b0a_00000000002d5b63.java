import java.io.*;
import java.util.*;

public class Solution {

    private static final int MAX_ITERATIONS = 300;
    private static final int LIMIT = 1_000_000_000;

    private static void performLoop(Scanner scanner) {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            System.out.println("0 0");
            System.out.flush();
            scanner.nextLine();
        }
    }

    private static void solve(Scanner scanner, int A, int B) {
        int midpoint = (A + B) / 2;
        int threshold = LIMIT - midpoint;

        if (threshold > 5) {
            performLoop(scanner);
            return;
        }

        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y < 5; y++) {
                System.out.println(x + " " + y);
                System.out.flush();

                String response = scanner.nextLine();
                if ("CENTER".equals(response)) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            scanner.nextLine();

            for (int t = 1; t <= testCases; t++) {
                solve(scanner, A, B);
            }

            System.out.flush();
        }
    }
}