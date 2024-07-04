    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int[][] matrix = initMatrix(in);
          CaseAnswer caseAnswer = solveTestCase(matrix);
          
          System.out.println("Case #" + i + ": " + caseAnswer.trace + " " + caseAnswer.rDuplicate + " " + caseAnswer.cDuplicate);
        }
      }
      
      public static int[][] initMatrix(Scanner in){
        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        for (int r = 0; r < size; r++)
            for (int c = 0; c < size; c++)
                matrix[r][c] = in.nextInt();
        return matrix;
      }
      
      public static CaseAnswer solveTestCase(int[][] matrix){
        int size = matrix.length;
        CaseAnswer answer = new CaseAnswer();
        Set<Integer> set = new HashSet<>(size, 1);
        
        for (int i = 0; i < size; i++){
            set.clear();
            for (int j = 0; j < size; j++)
                set.put(matrix[i][j]);
            if (set.size() != size)
                answer.rDuplicate++;
        }
        
        for (int i = 0; i < size; i++){
            set.clear();
            for (int j = 0; j < size; j++)
                set.put(matrix[j][i]);
            if (set.size() != size)
                answer.cDuplicate++;
        }
        
        for (int i = 0; i < size; i++)
            answer.trace += matrix[i][i];
            
        return answer;
      }
      
      public static class CaseAnswer {
          int trace;
          int rDuplicate;
          int cDuplicate;
      }
      
    }