import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] array = new int[3 * n];

            for (int i = 0; i < n; i++) {
                array[i] = i + 1;
                array[n + i] = i + 1;
                array[2 * n + i] = i + 1;
            }

            if (k % n != 0) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": POSSIBLE");
                int startIndex = k / n + n - 1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(array[startIndex + j] + " ");
                    }
                    System.out.println();
                    startIndex--;
                }
            }
        }
        scanner.close();
    }
}