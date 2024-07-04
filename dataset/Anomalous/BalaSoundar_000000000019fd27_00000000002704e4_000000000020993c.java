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
        int diagSum = 0, duplicateRow = 1, duplicateCol = 1;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            diagSum += inputArr[i][i];
            rowMap.clear();
            colMap.clear();

            for (int j = 0; j < length; j++) {
                int tempRowVal = inputArr[i][j];
                rowMap.put(tempRowVal, rowMap.getOrDefault(tempRowVal, 0) + 1);
                if (rowMap.get(tempRowVal) > duplicateRow) {
                    duplicateRow = rowMap.get(tempRowVal);
                }
            }

            for (int j = 0; j < length; j++) {
                int tempColVal = inputArr[j][i];
                colMap.put(tempColVal, colMap.getOrDefault(tempColVal, 0) + 1);
                if (colMap.get(tempColVal) > duplicateCol) {
                    duplicateCol = colMap.get(tempColVal);
                }
            }
        }

        if (duplicateCol == 1) duplicateCol = 0;
        if (duplicateRow == 1) duplicateRow = 0;

        System.out.println("Case #" + testcase + ": " + diagSum + " " + duplicateRow + " " + duplicateCol);
        System.out.flush();
    }
}