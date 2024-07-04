import java.util.Scanner;

public class Solution {

    private static void indicium(int caseNumber, int n, int trace) {
        boolean possible = (trace % n == 0);
        System.out.printf("Case #%d: %s%n", caseNumber, possible ? "POSSIBLE" : "IMPOSSIBLE");

        if (possible) {
            int k = trace / n;
            int[] nums = new int[n];
            int index = 1;
            nums[0] = k;

            for (int i = 1; i <= n; i++) {
                if (i != k) {
                    nums[index++] = i;
                }
            }

            index = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        System.out.print(k + " ");
                    } else {
                        System.out.print(nums[index] + " ");
                    }
                    if (j < n) {
                        index = (index + 1) % n;
                    } else {
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();

            for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
                String[] input = scanner.nextLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int trace = Integer.parseInt(input[1]);
                indicium(caseIndex, n, trace);
            }
        }
    }
}