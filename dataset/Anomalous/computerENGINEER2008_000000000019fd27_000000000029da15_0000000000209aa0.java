import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfCases; testCase++) {
            int n = scanner.nextInt();
            int trace = scanner.nextInt();

            boolean isPossible = trace % n == 0;
            System.out.printf("Case #%d: %s%n", testCase, isPossible ? "POSSIBLE" : "IMPOSSIBLE");

            if (isPossible) {
                int diagonalValue = trace / n;
                int currentValue = diagonalValue;

                for (int i = 0; i < n; i++) {
                    int value = currentValue--;
                    if (currentValue <= 0) {
                        currentValue = n;
                    }

                    for (int j = 0; j < n; j++) {
                        System.out.print(value);
                        if (j != n - 1) {
                            System.out.print(" ");
                        }

                        value++;
                        if (value > n) {
                            value = 1;
                        }
                    }
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}