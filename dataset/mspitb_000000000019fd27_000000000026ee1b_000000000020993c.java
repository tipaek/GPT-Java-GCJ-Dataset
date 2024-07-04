import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

   private static Map<Integer, int[][]> matrixMap = new HashMap<>();
   private static Map<Integer, Integer> caseTraceMap = new HashMap<>();
   private static Map<Integer, Integer> caseNumberOfRepeatedColumnsMap = new HashMap<>();
   private static Map<Integer, Integer> caseNumberOfRepeatedRowsMap = new HashMap<>();

   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

      int numberOfTests = in.nextInt();
      for (int n = 1; n <= numberOfTests; ++n) {
         int matrixSize = in.nextInt();
         int[][] matrix = new int[matrixSize][matrixSize];
         for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
               int number = in.nextInt();
               matrix[i][j] = number;
            }
         }
         matrixMap.put(n, matrix);
      }

      matrixMap.forEach((key, value) -> {
         caseTraceMap.put(key, 0);
         caseNumberOfRepeatedColumnsMap.put(key, 0);
         caseNumberOfRepeatedRowsMap.put(key, 0);
         int[][] matrixToHandle = matrixMap.get(key);
         for (int i = 0; i < matrixToHandle.length; i++) {
            int diagonalNum = matrixToHandle[i][i];
            int[] column = new int[0];
            for (int[] ints : matrixToHandle) {
               column = append(column, ints[i]);
            }
            boolean isDuplicatedRow = hasDuplicates(matrixToHandle[i]);
            boolean isDuplicatedColumn = hasDuplicates(column);
            caseTraceMap.merge(key, diagonalNum, Integer::sum);
            if (isDuplicatedRow) {
               caseNumberOfRepeatedRowsMap.merge(key, 1, Integer::sum);
            }
            if (isDuplicatedColumn){
               caseNumberOfRepeatedColumnsMap.merge(key, 1, Integer::sum);
            }
         }
      });
      matrixMap.keySet().forEach(caseIndex -> System.out.println(new StringBuilder()
              .append("Case #")
              .append(caseIndex)
              .append(":")
              .append(' ')
              .append(caseTraceMap.get(caseIndex))
              .append(' ')
              .append(caseNumberOfRepeatedRowsMap.get(caseIndex))
              .append(' ')
              .append(caseNumberOfRepeatedColumnsMap.get(caseIndex)).toString()));
   }

   private static int[] append(int[] array, int value) {
      int[] result = Arrays.copyOf(array, array.length + 1);
      result[result.length - 1] = value;
      return result;
   }

   private static boolean hasDuplicates(int[] array) {
      for (int i = 0; i < array.length; i++) {
         for (int j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
               return true;
            }
         }
      }
      return false;
   }

}
