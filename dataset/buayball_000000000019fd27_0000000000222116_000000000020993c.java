import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int case_t = 1; case_t <= t; case_t++) {
      
      int N = in.nextInt();
      int[][] matrix = new int[N][N];
      
      Set<Integer> value_set = new HashSet<Integer>();
      for (int i = 0; i < N; i++) {
        value_set.add(i+1);
      }

      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          matrix[i][j] = in.nextInt();
        }      
      }

      int trace = 0;
      int row_repeat = 0;
      int column_repeat = 0;

      for (int fix = 0; fix < N; fix++) {

        //Set<Integer> row_set = value_set;
        //Set<Integer> column_set = value_set;

        Set<Integer> row_set = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
          row_set.add(i+1);
        }

        Set<Integer> column_set = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
          column_set.add(i+1);
        }
        
        for (int j = 0; j < N; j++) {
          if(row_set.contains(matrix[fix][j]))
            row_set.remove(matrix[fix][j]);
          else{
            row_repeat++;
            break;
          }          
        }
        
        for (int j = 0; j < N; j++) {
          if(column_set.contains(matrix[j][fix]))
            column_set.remove(matrix[j][fix]);
          else{
            column_repeat++;
            break;
          }          
        }
        
        trace += matrix[fix][fix];
      }

      System.out.println("Case #" + case_t + ": " + trace + " " + row_repeat + " " + column_repeat);
    }
  }
}