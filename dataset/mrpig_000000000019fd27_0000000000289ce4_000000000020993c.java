import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        int[] result = new int[3 * testCases];

        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int trace = 0;
            boolean[] rowsWithRepetition = new boolean[n];
            boolean[][] rows = new boolean[n][n + 1];
            boolean[] columnsWithRepetition = new boolean[n];
            boolean[][] columns = new boolean[n][n + 1];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int num = scanner.nextInt();
                    //sum trace
                    if (j == k) {
                        trace += num;
                    }
                    //check rows
                    if (rows[j][num]) {
                        rowsWithRepetition[j] = true;
                    }
                        //check columns
                    if (columns[k][num]) {
                            columnsWithRepetition[k] = true;
                    }
                    rows[j][num] = true;
                    columns[k][num] = true;
                }
            }            
            int totalRowsWithRepetition = 0;
            int totalColumnsWithRepetition = 0;
            for (int l = 0; l < n; l++) {
                if (columnsWithRepetition[l]) {
                    totalColumnsWithRepetition++;
                }
                if (rowsWithRepetition[l]) {
                    totalRowsWithRepetition++;
                }
            }
            
            result[3 * i] = trace;
            result[3 * i + 1] = totalRowsWithRepetition;
            result[3 * i + 2] = totalColumnsWithRepetition;

        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + result[3 * i] + " " + result[3 * i + 1] + " " + result[3 * i + 2]);
        }

    }
}