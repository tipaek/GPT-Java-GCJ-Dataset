import java.util.Arrays;
import java.util.Scanner;

public class Vestigium {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int testcase = scanner.nextInt();

        //for saving results
        int traceInfo[] = new int[testcase];
        int duplicateRowsInfo[] = new int[testcase];
        int duplicateColumnInfo[] = new int[testcase];

        for (int caseNo = 0; caseNo < testcase; caseNo++) {

            int matrixSize = scanner.nextInt();

            int matrix[][] = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = 0;

            //for trace
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    if (i == j) {
                        trace = trace + matrix[i][j];
                    }
                }
            }

            traceInfo[caseNo] = trace;                            //result provided

            int duplicateRows = 0;
            int duplicateColumn = 0;
            //for rows and column

            int row[] = new int[matrixSize];
            int column[] = new int[matrixSize];
            for (int i = 0; i < matrixSize; i++) {
                for (int j = 0; j < matrixSize; j++) {
                    row[j] = matrix[i][j];
                    column[j] = matrix[j][i];
                }
                int rowCount = numUnique(row, matrixSize);
                int columnCount = numUnique(column, matrixSize);
                if (rowCount != matrixSize) {
                    duplicateRows++;
                }
                if (columnCount != matrixSize) {
                    duplicateColumn++;
                }

            }

            duplicateRowsInfo[caseNo] = duplicateRows;                            //result provided
            duplicateColumnInfo[caseNo] = duplicateColumn;                            //result provided

        }

        //print result here from the three result column

        for(int i = 0 ; i < testcase ; i++)
        {
            System.out.println("Case #"+(i+1)+": " + traceInfo[i]+" "+duplicateRowsInfo[i]+" "+duplicateColumnInfo[i]);
        }


    }


    public static int numUnique(int[] list, int matrixSize) {
        long count = Arrays.stream(list).distinct().count();
        return Integer.parseInt(String.valueOf(count));
    }


}
