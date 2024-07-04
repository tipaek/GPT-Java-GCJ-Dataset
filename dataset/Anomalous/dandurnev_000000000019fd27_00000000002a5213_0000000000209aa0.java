import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int testCaseNumber = 1;

    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        SCANNER.nextLine(); // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int n = SCANNER.nextInt();
        int k = SCANNER.nextInt();

        boolean isPossible = true;

        if (k % n == 1 || k % n == (n - 1) || n > k) {
            isPossible = false;
        }

        System.out.println("Case #" + (testCaseNumber++) + ": " + (isPossible ? "POSSIBLE" : "IMPOSSIBLE"));
    }
}