import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Set<Integer> rowData = new HashSet<Integer>();
        Set<Integer> columnData = new HashSet<Integer>();
        int times = s.nextInt();
        for (int i = 1; i < times + 1; i++) {
            int trace = 0;
            int index = 0;
            int numRows = 0;
            int numColumns = 0;
            int rowLength = s.nextInt();
            int[][] matrix = new int[rowLength][rowLength];

            for (int j = 0; j < rowLength; j++) {
                for (int k = 0; k < rowLength; k++) {
                    matrix[j][k] = s.nextInt();
                    if (j == k) {
                        trace += matrix[j][k];
                    }
                }
            }

            for (int l = 0; l < rowLength; l++) {
                for (int m = 0; m < rowLength; m++) {
                    int curr = matrix[l][m];
                    if (rowData.contains(curr)) {
                        numRows++;
                        break;
                    } 
                    rowData.add(curr);
                }
            }

            rowData.clear();
            
            for (int l = 0; l < rowLength; l++) {
                for (int m = 0; m < rowLength; m++) {
                    int curr = matrix[m][l];
                    if (columnData.contains(curr)) {
                        numColumns++;
                        break;
                    } 
                    columnData.add(curr);
                }
            }

            columnData.clear();
            System.out.printf("Case #%d: %d %d %d \n", i, trace, numRows, numColumns);
            numRows = 0;
            numColumns = 0;
        }

    }
}