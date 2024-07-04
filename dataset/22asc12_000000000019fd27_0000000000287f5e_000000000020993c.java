import java.util.Scanner;

public class Vestigium{
  public static void process(int[][] matrix, int mat_size, int caso){
    int trace = 0;
    int rempty = 0;
    int cempty = 0;
    for (int i = 0; i < mat_size; i++) {
      int pivot = 0;
      for (int j = 0; j < mat_size-1; j++) {
        if (matrix[i][j] == matrix[i][j+1]) {
          pivot ++;
        }
      }
      if (pivot == mat_size-1) {
        rempty ++;
      }
    }
    for (int i = 0; i < mat_size; i++) {
      int pivot = 0;
      for (int j = 0; j < mat_size-1; j++) {
        if (matrix[j][i] == matrix[j+1][i]) {
          pivot ++;
        }
      }
      if (pivot == mat_size-1) {
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
