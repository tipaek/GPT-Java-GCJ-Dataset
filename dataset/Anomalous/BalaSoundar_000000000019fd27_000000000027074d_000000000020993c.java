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
        
        sc.close();
    }

    private static void performCalculation(int[][] inputArr, int length, int testcase) {
        int diagSum = 0;
        int duplicateRow = 1;
        int duplicateCol = 1;
        
        for (int i = 0; i < length; i++) {
            diagSum += inputArr[i][i];
            
            Map<Integer, Integer> rowMap = new HashMap<>();
            Map<Integer, Integer> colMap = new HashMap<>();
            
            for (int j = 0; j < length; j++) {
                int rowValue = inputArr[i][j];
                rowMap.put(rowValue, rowMap.getOrDefault(rowValue, 0) + 1);
                duplicateRow = Math.max(duplicateRow, rowMap.get(rowValue));
                
                int colValue = inputArr[j][i];
                colMap.put(colValue, colMap.getOrDefault(colValue, 0) + 1);
                duplicateCol = Math.max(duplicateCol, colMap.get(colValue));
            }
        }
        
        duplicateRow = duplicateRow == 1 ? 0 : duplicateRow;
        duplicateCol = duplicateCol == 1 ? 0 : duplicateCol;
        
        System.out.printf("Case #%d: %d %d %d%n", testcase + 1, diagSum, duplicateRow, duplicateCol);
    }
}