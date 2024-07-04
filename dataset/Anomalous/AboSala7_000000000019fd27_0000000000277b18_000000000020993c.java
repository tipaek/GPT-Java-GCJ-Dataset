import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testsNum = sc.nextInt();
        int testCase = 0;

        while (testsNum > 0) {
            int arraySize = sc.nextInt();
            int[][] matrix = new int[arraySize][arraySize];

            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < arraySize; i++) {
                trace += matrix[i][i];
            }

            int repRowsNum = 0;
            int repColsNum = 0;

            for (int i = 0; i < arraySize; i++) {
                HashMap<Integer, Integer> rowMap = new HashMap<>();
                for (int j = 0; j < arraySize; j++) {
                    if (rowMap.containsKey(matrix[i][j])) {
                        repRowsNum++;
                        break;
                    } else {
                        rowMap.put(matrix[i][j], 1);
                    }
                }
            }

            for (int i = 0; i < arraySize; i++) {
                HashMap<Integer, Integer> colMap = new HashMap<>();
                for (int j = 0; j < arraySize; j++) {
                    if (colMap.containsKey(matrix[j][i])) {
                        repColsNum++;
                        break;
                    } else {
                        colMap.put(matrix[j][i], 1);
                    }
                }
            }

            System.out.println("Case #" + (++testCase) + ": " + trace + " " + repRowsNum + " " + repColsNum);
            testsNum--;
        }
    }
}