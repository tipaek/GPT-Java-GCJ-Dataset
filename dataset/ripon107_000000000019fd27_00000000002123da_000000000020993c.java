import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for(int caseno = 1; caseno<=testcase;caseno++) {
            int matrixSize = sc.nextInt();

            int trace = 0, rows = 0, columns = 0;
            int[][] matrix = new int[matrixSize][matrixSize];
            for (int i=0;i<matrixSize;i++) {
                for (int j=0;j<matrixSize;j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            Set<Integer> currentRow = new HashSet<>();
            Set<Integer> currentColumn = new HashSet<>();
            for (int i=0;i<matrixSize;i++) {
                currentRow.clear();
                currentColumn.clear();
                for (int j=0;j<matrixSize;j++) {
                    if (i == j) trace+= matrix[i][j];
                    currentRow.add(matrix[i][j]);
                    currentColumn.add(matrix[j][i]);
                }
                if (currentRow.size() != matrixSize) rows++;
                if (currentColumn.size() != matrixSize) columns++;
            }

            System.out.println("Case #" + caseno +": " + trace + " " + rows + " " + columns);
        }
    }
}
