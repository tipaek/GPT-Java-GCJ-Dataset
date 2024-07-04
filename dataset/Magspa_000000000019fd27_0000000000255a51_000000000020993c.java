import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Current {

//  public static void main(String[] args) {
//    Scanner in = new Scanner(Current.class.getClassLoader().getResourceAsStream("currentIn"));
//    solve(in);
//  }

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    solve(in);
  }
  
  public static void solve(Scanner in) {
    int T = in.nextInt(); // numTests
    for(int ks = 1; ks <= T; ks++) {

      int matrixSize = in.nextInt();
      int trace = 0;
      int rows = 0;
      int cols = 0;
      int[][] matrix = new int[matrixSize][matrixSize];
      for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
          int val = in.nextInt();
          matrix[i][j] = val;
          if (i == j) trace += val;
        }
      }
      
      for (int i = 0; i < matrixSize; i++) { // rows
        Set<Integer> seen = new HashSet<>();
        for (int j = 0; j < matrixSize; j++) { // cols
          boolean dupe = !seen.add(matrix[i][j]);
          if (dupe) {
            rows++;
            break; // next row
          }
        }
      }

      for (int j = 0; j < matrixSize; j++) { // cols
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < matrixSize; i++) { // rows
          boolean dupe = !seen.add(matrix[i][j]);
          if (dupe) {
            cols++;
            break; // next col
          }
        }
      }
      
      System.out.println("Case #"+ks+": "+trace+" "+rows+" "+cols);
    }
  }
  
  
}
