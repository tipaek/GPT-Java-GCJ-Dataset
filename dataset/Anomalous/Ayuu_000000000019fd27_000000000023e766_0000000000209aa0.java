import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt(); // Note: The variable 'd' is read but never used in the original code.

            if (n % 2 == 0) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                int k = n + 1;

                for (int i = 1; i <= n; i++) {
                    int temp = k;

                    while (temp <= n) {
                        System.out.print(temp + " ");
                        temp++;
                    }

                    for (int j = 1; j < k; j++) {
                        System.out.print(j + " ");
                    }

                    k--;
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}