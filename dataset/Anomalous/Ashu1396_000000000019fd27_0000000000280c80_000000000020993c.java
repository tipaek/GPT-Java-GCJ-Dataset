import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int diagonalSum = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    arr[row][col] = sc.nextInt();
                    if (row == col) {
                        diagonalSum += arr[row][col];
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;

            // Check for duplicate values in rows
            for (int row = 0; row < N; row++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < N; col++) {
                    if (!rowSet.add(arr[row][col])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            // Check for duplicate values in columns
            for (int col = 0; col < N; col++) {
                Set<Integer> colSet = new HashSet<>();
                for (int row = 0; row < N; row++) {
                    if (!colSet.add(arr[row][col])) {
                        duplicateCols++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + i + ": " + diagonalSum + " " + duplicateRows + " " + duplicateCols);
        }

        sc.close();
    }
}