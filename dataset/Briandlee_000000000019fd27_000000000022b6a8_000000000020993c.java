import java.util.*;
public class Solution {

  public static void main(String[] args){
    calculations();
  }

  public static void calculations(){
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int i = 0; i < T; i++){
      int N = scanner.nextInt();
      int[][] matrix = new int[N][N];
      for (int j = 0; j < N; j++){
        for (int k = 0; k < N; k++){
          matrix[j][k] = scanner.nextInt();
        }
      }

      int trace = 0;
      for (int j = 0; j < N; j++){
        trace += matrix[j][j];
      }

      // horizontal
      int totalRows = 0;
      for (int j = 0; j < N; j++){
        boolean containsRepeats = false;
        ArrayList<Integer> thisList = new ArrayList<Integer>();
        for (int k = 0; k < N; k++){
          if (thisList.contains(matrix[j][k])){
            containsRepeats = true;
          }
          thisList.add(matrix[j][k]);
        }
        if (containsRepeats){
          totalRows++;
        }

      }

      // vertical
      int totalColumns = 0;
      for (int j = 0; j < N; j++){
        boolean containsRepeats = false;
        ArrayList<Integer> thisList = new ArrayList<Integer>();
        for (int k = 0; k < N; k++){
          if (thisList.contains(matrix[k][j])){
            containsRepeats = true;
          }
          thisList.add(matrix[k][j]);
        }
        if (containsRepeats){
          totalColumns++;
        }

      }
      int caseNum = i + 1;
      System.out.println("Case #" + caseNum + ": " + trace + " " + totalRows + " " + totalColumns);
    }
  }

}
