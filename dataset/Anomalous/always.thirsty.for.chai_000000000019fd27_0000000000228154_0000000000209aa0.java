import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int originalTestCases = testCases;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int caseNumber = originalTestCases - testCases;

            if (k % n == 0 && k / n <= n) {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                int initialValue = k / n;

                for (int i = 0; i < n; i++) {
                    int currentValue = (initialValue == 0) ? n : initialValue;
                    for (int j = 0; j < n; j++) {
                        System.out.print((currentValue > n ? 1 : currentValue) + " ");
                        currentValue++;
                    }
                    System.out.println();
                    initialValue = (initialValue == 0) ? n - 1 : initialValue - 1;
                }
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
        }
    }
}