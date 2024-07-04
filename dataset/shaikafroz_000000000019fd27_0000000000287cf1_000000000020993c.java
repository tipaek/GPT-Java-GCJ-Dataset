import java.lang.Math;
import java.util.Scanner;

class Main {
    public static int getRepeatedColumns(int[][] colMa, int siz) {
        int repeatedColumns = 0;
        for (int i = 0; i < siz; ++i) {
            boolean repeatedCol = false;
            for (int j = 0; j < siz; ++j) {
                if (colMa[j][i] == 0) {
                    repeatedCol = true;
                }
            }
            if (repeatedCol) {
                repeatedColumns += 1;
            }
        }
        return repeatedColumns;
    }

    public static int getRepeatedRows(int[][] rowMap, int siz) {
        int repeatedRows = 0;
        for (int i = 0; i < siz; ++i) {
            boolean repeatedRow = false;
            for (int j = 0; j < siz; ++j) {
                if (rowMap[i][j] == 0) {
                    repeatedRow = true;
                }
            }
            if (repeatedRow) {
                repeatedRows += 1;
            }
        }
        return repeatedRows;
    }

    public static int createMapsAndgetDiagonalSum(int[][] rowMap, int[][] colMa, int siz, Scanner in) {
        int diagonalSum = 0;
        for (int i = 0; i < siz; ++i) {
            for (int j = 0; j < siz; ++j) {
                int value = in.nextInt();
                rowMap[i][value - 1] = 1;
                colMa[value - 1][j] = 1;
                if (i == j) {
                    diagonalSum += value;
                }
            }
        }
        return diagonalSum;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int siz = in.nextInt();
            int rowMap[][] = new int[siz][siz];
            int colMa[][] = new int[siz][siz];
            int diagonalSum = createMapsAndgetDiagonalSum(rowMap, colMa, siz, in);
            System.out.println("Case #" + testCase + ": " + diagonalSum + " " + getRepeatedRows(rowMap, siz) + " "
                    + getRepeatedColumns(colMa, siz));
        }
        in.close();
    }
}