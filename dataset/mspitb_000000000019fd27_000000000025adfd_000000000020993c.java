import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

   private static Map<Integer, Integer> caseTraceMap = new HashMap<>();
   private static Map<Integer, Integer> caseNumberOfRepeatedColumnsMap = new HashMap<>();
   private static Map<Integer, Integer> caseNumberOfRepeatedRowsMap = new HashMap<>();


   public static void main(String[] args) {
      Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
      Scanner in2 = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

      int numberOfTests = in.nextInt();
      for (int testIndex = 1; testIndex <= numberOfTests; ++testIndex) {
         int matrixSize = in.nextInt();
         char[][] array = new char[matrixSize][matrixSize];
         for (int i = 0; i < matrixSize; i++) {
            String matrixLine = in2.nextLine();
            array[i] = matrixLine.toCharArray();
            caseTraceMap.merge(testIndex, array[i][i] - '0', Integer::sum);
         }


         for (int i = 0; i < matrixSize; i++) {
            CharSequence charSequenceRow = CharBuffer.wrap(array[i]);
            if (charSequenceRow.length() != charSequenceRow.chars().distinct().count()){
               caseNumberOfRepeatedRowsMap.merge(testIndex, 1, Integer::sum);
            }

            StringBuilder a = new StringBuilder();
            for (int j = 0; j < matrixSize; j++){
               a.append(array[j][i]);
            }
            if ( a.toString().chars().distinct().count() != a.toString().length()){
               caseNumberOfRepeatedColumnsMap.merge(testIndex, 1, Integer::sum);
            }

         }

      }

      for (int i = 1; i <= numberOfTests; i++) {
         System.out.println("Case #:" + i + " "+ caseTraceMap.get(i) + " " + caseNumberOfRepeatedRowsMap.get(i) + " " + caseNumberOfRepeatedColumnsMap.get(i));
      }

   }
}

