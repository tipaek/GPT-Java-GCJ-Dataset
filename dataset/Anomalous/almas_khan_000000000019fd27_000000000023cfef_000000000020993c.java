import java.util.Scanner;

class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, rowCount = 0, colCount = 0;

            // Reading the matrix and calculating the trace
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                    if (i == j) {
                        trace += arr[i][j];
                    }
                }
            }

            // Checking rows for duplicates
            for (int i = 0; i < n; i++) {
                if (hasDuplicates(arr[i])) {
                    rowCount++;
                }
            }

            // Checking columns for duplicates
            for (int j = 0; j < n; j++) {
                int[] column = new int[n];
                for (int i = 0; i < n; i++) {
                    column[i] = arr[i][j];
                }
                if (hasDuplicates(column)) {
                    colCount++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowCount + " " + colCount);
            caseNumber++;
        }
    }

    private static boolean hasDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int value : array) {
            if (!set.add(value)) {
                return true;
            }
        }
        return false;
    }
}