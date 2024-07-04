import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < len; i++) {
            int currInput = Integer.parseInt(sc.nextLine());
            int[][] inputArr = new int[currInput][currInput];

            for (int j = 0; j < currInput; j++) {
                String[] currRow = sc.nextLine().split(" ");
                for (int k = 0; k < currInput; k++) {
                    inputArr[j][k] = Integer.parseInt(currRow[k]);
                }
            }

            performCalculation(inputArr, currInput, i);
        }
    }

    private static void performCalculation(int[][] inputArr, int length, int testcase) {
        int diagSum = 0;
        int duplicateRow = 0;
        int duplicateCol = 0;

        for (int i = 0; i < length; i++) {
            diagSum += inputArr[i][i];

            Map<Integer, Integer> rowMap = new HashMap<>();
            Map<Integer, Integer> colMap = new HashMap<>();

            for (int j = 0; j < length; j++) {
                int rowVal = inputArr[i][j];
                rowMap.put(rowVal, rowMap.getOrDefault(rowVal, 0) + 1);

                if (rowMap.get(rowVal) > 1) {
                    duplicateRow = 1;
                }

                int colVal = inputArr[j][i];
                colMap.put(colVal, colMap.getOrDefault(colVal, 0) + 1);

                if (colMap.get(colVal) > 1) {
                    duplicateCol = 1;
                }
            }
        }

        System.out.println("Case #" + testcase + ": " + diagSum + " " + duplicateRow + " " + duplicateCol);
    }
}