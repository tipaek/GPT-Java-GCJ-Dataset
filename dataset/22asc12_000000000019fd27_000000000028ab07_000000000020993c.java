import java.util.Scanner;

public class Solution{
  public static void process(int[][] matrix, int mat_size, int caso){
    int trace = 0;
    int rempty = 0;
    int cempty = 0;
    for (int i = 0; i < mat_size; i++) {
      int pivot = 0;
      for (int j = 0; j < mat_size; j++) {
        for (int k = j+1; k < mat_size; k++) {
          if(matrix[i][j] == matrix[i][k]){
            pivot = 1;
          }
        }
      }
      if (pivot != 0) {
        rempty++;
      }
    }
    for (int i = 0; i < mat_size; i++) {
      int pivot = 0;
      for (int j = 0; j < mat_size; j++) {
        for (int k = j+1; k < mat_size; k++) {
          if(matrix[j][i] == matrix[k][i]){
            pivot = 1;
          }
        }
      }
      if (pivot != 0) {
        cempty++;
      }
    }
    for(int i = 0; i < mat_size; i++){
      for (int j = 0; j < mat_size; j++) {
        if (i == j) {
          trace += matrix[i][j];
        }
      }
    }
    System.out.println("Case #" + caso + ": " + trace + " " + rempty + " " + cempty);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();
    for(int i = 0; i < cases; i++){
      int mat_size = sc.nextInt();
      int[][] matrix = new int [mat_size][mat_size];
      for (int j = 0; j < mat_size; j++) {
        for (int k = 0; k < mat_size; k++) {
          matrix[j][k] = sc.nextInt();
        }
      }
      process(matrix, mat_size, i);
    }
  }
}
