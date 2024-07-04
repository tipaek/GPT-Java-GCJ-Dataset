import java.util.Scanner;

class CodeJam1 {

    static int trace(int[][] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i][i];
        }
        return count;
    }

    static int row(int[][] arr, int n) {
        int rowCount = 0;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                if (seen[arr[i][j]]) {
                    rowCount++;
                    break;
                }
                seen[arr[i][j]] = true;
            }
        }
        return rowCount;
    }

    static int column(int[][] arr, int n) {
        int columnCount = 0;
        for (int j = 0; j < n; j++) {
            boolean[] seen = new boolean[n + 1];
            for (int i = 0; i < n; i++) {
                if (seen[arr[i][j]]) {
                    columnCount++;
                    break;
                }
                seen[arr[i][j]] = true;
            }
        }
        return columnCount;
    }

    public static void main(String[] args) {
        Scanner ac = new Scanner(System.in);
        int tc = ac.nextInt();

        for (int k = 1; k <= tc; k++) {
            int n = ac.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = ac.nextInt();
                }
            }

            int trace = trace(arr, n);
            int rowCount = row(arr, n);
            int columnCount = column(arr, n);

            System.out.println("Case #" + k + ": " + trace + " " + rowCount + " " + columnCount);
        }
    }
}