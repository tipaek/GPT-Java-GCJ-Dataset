import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scan.nextInt();
        StringBuilder ans = new StringBuilder();

        for (int k = 1; k <= t; k++) {
            int n = scan.nextInt();
            int[][] arr = new int[n][n];
            int sum = 0, countRow = 0, countCol = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                    if (i == j) {
                        sum += arr[i][j];
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (!isDistinct(arr[i])) {
                    countRow++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = arr[i][j];
                }
                if (!isDistinct(col)) {
                    countCol++;
                }
            }

            ans.append("Case#").append(k).append(": ").append(sum).append(" ").append(countRow).append(" ").append(countCol).append("\n");
        }

        System.out.print(ans.toString());
    }

    private static boolean isDistinct(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }
}