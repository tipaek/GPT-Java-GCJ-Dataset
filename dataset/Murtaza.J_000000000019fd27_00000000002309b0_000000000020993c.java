import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];

            int rowCount = 0;
            int colCount = 0;
            int trace = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = scanner.nextInt();
                }
            }

            for (int j = 0; j < n; j++) {
                boolean added = false;
                for (int k = 0; k < n; k++) {
                    if (!added) {
                        for (int l = 0; l < n; l++) {
                            if (l != k && arr[j][l] == arr[j][k]) {
                                rowCount++;
                                added = true;
                                break;
                            }
                        }
                    } else
                        break;
                }
            }

            for (int j = 0; j < n; j++) {
                boolean added = false;
                for (int k = 0; k < n; k++) {
                    if (!added) {
                        for (int l = 0; l < n; l++) {
                            if (l != k && arr[l][j] == arr[k][j]) {
                                colCount++;
                                added = true;
                                break;
                            }
                        }
                    } else
                        break;
                }
            }

            for (int j = 0; j < n; j++) {
                trace += arr[j][j];

            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}