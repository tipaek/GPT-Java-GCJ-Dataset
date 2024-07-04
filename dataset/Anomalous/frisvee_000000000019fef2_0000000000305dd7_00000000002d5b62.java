import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    private static final int M = 300;
    private static final int L = 1_000_000_000;

    private static void solve(Scanner scanner, int A, int B) {
        String response;
        int R = (A + B) / 2;
        int S = L - R;

        if (S > 5) {
            throw new RuntimeException("S is greater than 5");
        }

        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j < 5; j++) {
                System.out.println(i + " " + j);
                System.out.flush();

                response = scanner.nextLine();
                if (response.startsWith("CENTER")) {
                    return;
                }
            }
        }

        throw new RuntimeException("CENTER not found");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int T = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int t = 1; t <= T; t++) {
                solve(scanner, A, B);
            }
        }
    }
}