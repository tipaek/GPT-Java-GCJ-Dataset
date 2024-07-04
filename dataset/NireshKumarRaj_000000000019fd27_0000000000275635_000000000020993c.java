import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int eachTestCase = 0; eachTestCase < t; eachTestCase++) {
            int n = scan.nextInt();
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scan.nextInt();
                }
            }
            System.out.println(findResult(eachTestCase + 1, n, arr));
        }
        scan.close();
    }

    private static String findResult(int t, int n, int[][] arr) {
        int trace = 0, numOfDuplicateRows = 0, numOfDuplicateColumns = 0;

        for (int i = 0; i < n; i++) {
            trace += arr[i][i];
        }

        for (int i = 0; i < n; i++) {
            HashSet<Integer> rowCount = new HashSet<>();
            HashSet<Integer> columnCount = new HashSet<>();
            boolean colFlag = false, rowFlag = false;
            for (int j = 0; j < n; j++) {
                int row = arr[i][j];
                int col = arr[j][i];
                if (rowCount.contains(row)) {
                    rowFlag = true;
                } else {
                    rowCount.add(row);
                }
                if (columnCount.contains(col)) {
                    colFlag = true;
                } else {
                    columnCount.add(col);
                }
            }
            numOfDuplicateColumns += (colFlag ? 1 : 0);
            numOfDuplicateRows += (rowFlag ? 1 : 0);
        }

        return String.format("Case #%d: %d %d %d", t, trace, numOfDuplicateRows, numOfDuplicateColumns);
    }

}
