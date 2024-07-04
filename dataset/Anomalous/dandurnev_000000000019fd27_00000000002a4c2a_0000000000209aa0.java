import java.util.Scanner;

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            processTestCase();
        }
    }

    private static void processTestCase() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        boolean possible = true;

        for (int i = 0; i < n; i++) {
            if (k % n == 1 || k % n == n - 1) {
                possible = false;
                break;
            }
        }

        System.out.println("Case #" + (caseNumber++) + ": " + (possible ? "POSSIBLE" : "IMPOSSIBLE"));
    }
}