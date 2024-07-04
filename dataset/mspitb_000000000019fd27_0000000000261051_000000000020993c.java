import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      Map<Integer, char[][]> matrixMap = new HashMap<>();
      Map<Integer, Integer> caseTraceMap = new HashMap<>();
      Map<Integer, Integer> caseNumberOfRepeatedColumnsMap = new HashMap<>();
      Map<Integer, Integer> caseNumberOfRepeatedRowsMap = new HashMap<>();
      int numberOfTests = in.nextInt();

      for (int n = 1; n <= numberOfTests; ++n) {
         int matrixSize = in.nextInt();
         char[][] matrix = new char[matrixSize][matrixSize];
         for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
               matrix[i][j] = in.next().charAt(0);
            }
         }
         matrixMap.put(n, matrix);
      }

      matrixMap.forEach((key, value) -> {
         caseTraceMap.put(key, 0);
         caseNumberOfRepeatedColumnsMap.put(key, 0);
         caseNumberOfRepeatedRowsMap.put(key, 0);
         char[][] matrixToHandle = matrixMap.get(key);
         for (int i = 0; i < matrixToHandle.length; i++) {
            caseTraceMap.merge(key, matrixToHandle[i][i] - '0', Integer::sum);
            CharSequence row = CharBuffer.wrap(matrixToHandle[i]);
            if (row.length() != row.chars().distinct().count()) {
               caseNumberOfRepeatedRowsMap.merge(key, 1, Integer::sum);
            }
            StringBuilder column = new StringBuilder();
            for (char[] chars : matrixToHandle) {
               column.append(chars[i]);
            }
            if (column.toString().chars().distinct().count() != column.toString().length()) {
               caseNumberOfRepeatedColumnsMap.merge(key, 1, Integer::sum);
            }
         }
      });
      matrixMap.keySet().forEach(caseIndex -> {
         System.out.println("Case #:" + caseIndex + " "+ caseTraceMap.get(caseIndex) + " " + caseNumberOfRepeatedRowsMap.get(caseIndex) + " " + caseNumberOfRepeatedColumnsMap.get(caseIndex));
      });
   }
}
