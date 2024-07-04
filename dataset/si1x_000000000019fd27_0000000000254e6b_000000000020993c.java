import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int[][] rows;
        int[][] columns;
        int[] resRow;
        int[] resCol;
        int sum;
        int row;
        int column;
        int current;
        for (int j = 0; j < i; j++) {
            int N = scanner.nextInt();
            resCol = new int[N];
            resRow = new int[N];
            row = 0;
            sum = 0;
            column = 0;
            rows = new int[N][N + 1];
            columns = new int[N][N + 1];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    current = scanner.nextInt();
                    if(r == c) sum += current;

                    if (rows[r][current] != 0) {
                        if (resRow[r] == 0) {
                            resRow[r] = 1;
                            row++;
                        }
                    } else {
                        rows[r][current] = 1;
                    }
                    if (columns[c][current] != 0) {
                        if (resCol[c] == 0) {
                            resCol[c] = 1;
                            column++;
                        }
                    } else {
                        columns[c][current] = 1;
                    }
                }
            }
            System.out.println("\n" + "Case #" + (j+1) + ":" + ' ' + sum + ' ' + row + ' ' + column);
        }
    }

}