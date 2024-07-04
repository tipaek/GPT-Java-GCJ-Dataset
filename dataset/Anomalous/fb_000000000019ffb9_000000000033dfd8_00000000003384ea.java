import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            processTestCase(i + 1, scanner);
        }
    }

    private static void processTestCase(int caseId, Scanner scanner) {
        long left = scanner.nextLong();
        long right = scanner.nextLong();
        long turn = 0;

        while (true) {
            long currentCost = turn + 1;
            if (left >= right) {
                if (currentCost > left) {
                    break;
                }
                left -= currentCost;
            } else {
                if (currentCost > right) {
                    break;
                }
                right -= currentCost;
            }
            turn++;
        }

        System.out.println("Case #" + caseId + ": " + turn + " " + left + " " + right);
    }
}