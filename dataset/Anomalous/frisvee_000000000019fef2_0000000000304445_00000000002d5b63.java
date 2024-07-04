import java.io.*;
import java.util.*;

public class Solution {

    private static final int M = 300;
    private static final int L = 1_000_000_000;

    private static void performLoop(Scanner scanner) {
        for (int i = 0; i < M; i++) {
            System.out.println("0 0");
            System.out.flush();
            scanner.nextLine();
        }
    }

    private static void solve(Scanner scanner, int a, int b) {
        int r = (a + b) / 2;
        int s = L - r;

        if (s > 5) {
            throw new RuntimeException();
        }

        for (int i = -5; i <= 5; i++) {
            for (int j = -5; j < 5; j++) {
                System.out.println(i + " " + j);
                System.out.flush();

                String response = scanner.nextLine();
                if (response.equals("CENTER")) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= t; testCase++) {
            solve(scanner, a, b);
        }

        System.out.flush();
        scanner.close();
    }
}