import java.util.Scanner;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            Arrays.sort(arr);
            int duplicateCount = 0;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j] == arr[k]) {
                        duplicateCount++;
                    }
                }
            }

            int result;
            if (duplicateCount == d) {
                result = 0;
            } else if (arr.length == 1) {
                result = d - arr[0];
            } else {
                result = Math.abs(arr[0] - d);
            }

            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}