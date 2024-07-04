import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            boolean possible = true;
            StringBuilder result = new StringBuilder();
            int[] arrC = new int[24 * 60 + 1];
            int[] arrJ = new int[24 * 60 + 1];

            for (int k = 0; k < n; k++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                boolean canAssignC = isAvailable(arrC, start, end);
                boolean canAssignJ = isAvailable(arrJ, start, end);

                if (canAssignC) {
                    assign(arrC, start, end);
                    result.append("C");
                } else if (canAssignJ) {
                    assign(arrJ, start, end);
                    result.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": " + result.toString());
            }
        }
    }

    private static boolean isAvailable(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void assign(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            arr[i] = 1;
        }
    }
}