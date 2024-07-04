import java.util.Scanner;

public class Vestigium {
  
  public static void process(int[][] matrix, int matSize, int caseNum) {
    int trace = 0;
    int rowEmpty = 0;
    int colEmpty = 0;

    // Calculate trace and row duplicates
    for (int i = 0; i < matSize; i++) {
      boolean[] rowCheck = new boolean[matSize + 1];
      boolean rowHasDuplicate = false;
      
      for (int j = 0; j < matSize; j++) {
        if (i == j) {
          trace += matrix[i][j];
        }
        if (rowCheck[matrix[i][j]]) {
          rowHasDuplicate = true;
        }
        rowCheck[matrix[i][j]] = true;
      }
      
      if (rowHasDuplicate) {
        rowEmpty++;
      }
    }

    // Calculate column duplicates
    for (int i = 0; i < matSize; i++) {
      boolean[] colCheck = new boolean[matSize + 1];
      boolean colHasDuplicate = false;

      for (int j = 0; j < matSize; j++) {
        if (colCheck[matrix[j][i]]) {
          colHasDuplicate = true;
        }
        colCheck[matrix[j][i]] = true;
      }

      if (colHasDuplicate) {
        colEmpty++;
      }
    }

    System.out.println("Case #" + caseNum + ": " + trace + " " + rowEmpty + " " + colEmpty);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cases = sc.nextInt();

    for (int caseNum = 1; caseNum <= cases; caseNum++) {
      int matSize = sc.nextInt();
      int[][] matrix = new int[matSize][matSize];

      for (int i = 0; i < matSize; i++) {
        for (int j = 0; j < matSize; j++) {
          matrix[i][j] = sc.nextInt();
        }
      }

      process(matrix, matSize, caseNum);
    }

    sc.close();
  }
}