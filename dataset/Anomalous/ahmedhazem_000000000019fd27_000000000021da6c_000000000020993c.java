import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

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
                if (!hasAllDistinctElements(arr[i])) {
                    countRow++;
                }
            }

            for (int j = 0; j < n; j++) {
                int[] col = new int[n];
                for (int i = 0; i < n; i++) {
                    col[i] = arr[i][j];
                }
                if (!hasAllDistinctElements(col)) {
                    countCol++;
                }
            }

            System.out.println("Case #" + k + ": " + sum + " " + countRow + " " + countCol);
        }
    }

    private static boolean hasAllDistinctElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            if (!set.add(value)) {
                return false;
            }
        }
        return true;
    }
}