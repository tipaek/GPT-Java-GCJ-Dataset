import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            int[] array = new int[n];

            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }

            Arrays.sort(array);
            int duplicateCount = 0;
            int result = 0;

            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (array[j] == array[k]) {
                        duplicateCount++;
                    }
                }
            }

            if (duplicateCount == d) {
                result = 0;
            } else if (array.length == 1) {
                result = Math.abs(d - array[0]);
            } else {
                for (int j = 0; j < n; j++) {
                    while (array[j] % 2 == 0) {
                        result++;
                        array[j] /= 2;
                    }
                    while (array[j] % 3 == 0) {
                        result++;
                        array[j] /= 3;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + result);
        }
        scanner.close();
    }
}