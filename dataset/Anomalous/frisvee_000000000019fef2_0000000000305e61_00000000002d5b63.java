import java.io.*;
import java.util.*;

public class Solution {

    private static final int MAX_RANGE = 300;
    private static final int LIMIT = 1_000_000_000;

    private static void solve(Scanner scanner, int A, int B) {
        int midPoint = (A + B) / 2;
        int difference = LIMIT - midPoint;

        if (difference > 5) {
            throw new RuntimeException();
        }

        for (int x = -5; x <= 5; x++) {
            for (int y = -5; y < 5; y++) {
                System.out.println(x + " " + y);
                System.out.flush();

                String response = scanner.nextLine();
                if (response.startsWith("CENTER")) {
                    return;
                }
            }
        }

        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            solve(scanner, A, B);
        }

        System.out.flush();
        scanner.close();
    }
}