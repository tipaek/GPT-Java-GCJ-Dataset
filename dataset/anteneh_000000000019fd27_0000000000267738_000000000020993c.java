import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        int testCasesCount = numberOfTestCases;

        String result = "";

        while (numberOfTestCases > 0) {
            int matrixSize = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] matrix = new int[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                String[] sRowItems = scanner.nextLine().split(" ");
                for (int j = 0; j < sRowItems.length; j++) {
                    int sItem = Integer.parseInt(sRowItems[j]);
                    matrix[i][j] = sItem;
                }
            }
            result = result + "Case #" + (testCasesCount - numberOfTestCases + 1) + ":" + getResult(matrix) + "\n";
            numberOfTestCases--;
        }

        System.out.println(result);
    }

    public static String getResult(int[][] matrix) {

        int trace = 0;

        //  CHECKING TRACE AND ROW DUPLICATED
        int rowDuplicates = 0;
        int colDuplicates = 0;
        for (int i = 0; i < matrix.length; i++) {

            HashSet<Integer> rowVals = new HashSet<>();
            boolean traced = false;
            boolean duplicateFound = false;

            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                if (i == j) {
                    trace += value;
                    traced = true;
                }
                if (!rowVals.contains(value)) {
                    rowVals.add(value);
                } else {
                    if (!duplicateFound) {
                        duplicateFound = true;
                        rowDuplicates++;
                    }
                    if (traced) {
                        break;
                    }
                }
            }
        }


        for (int i = 0; i < matrix.length; i++) {

            HashSet<Integer> colVals = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[j][i];
                if (colVals.contains(value)) {
                    colDuplicates++;
                    break;
                }
                colVals.add(value);
            }
        }

        return " " + trace + " " + rowDuplicates + " " + colDuplicates;
    }

}

















