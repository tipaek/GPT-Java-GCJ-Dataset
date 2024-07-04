import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[3 * n];

            for (int j = 0; j < n; j++) {
                arr[j] = j + 1;
                arr[n + j] = j + 1;
                arr[2 * n + j] = j + 1;
            }

            if (k % n != 0) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                int s = k / n + 2;

                for (int j = 0; j < n; j++) {
                    for (int m = 0; m < n; m++) {
                        System.out.print(arr[s + m] + " ");
                    }
                    System.out.println();
                    s--;
                }
            }
        }

        scanner.close();
    }
}