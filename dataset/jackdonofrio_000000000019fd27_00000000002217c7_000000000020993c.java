import java.util.Scanner;

public class Vestigium
{
  public static void main(String[] args)
  {
      Scanner s = new Scanner(System.in);
      int cases = s.nextInt();
      
      for (int q = 0; q < cases; q++) {
          int n = s.nextInt();
          int[][] matrix = new int[n][n];
          
          int rowRepeat = 0;
          int colRepeat = 0;
          int traceSum = 0;
          for (int row = 0; row < n; row++) {
              
              for (int column = 0; column < n; column++) {
                  
                  matrix[row][column] = s.nextInt();
            
                  if (row == column) {
                      traceSum += matrix[row][column];
                  }
                }
              boolean flag1 = true;
              for (int col = 0; col < n; col++) {
                  for (int c1 = col + 1; c1 < n && flag1; c1++) {
                      if (matrix[row][col] == matrix[row][c1]) {
                          rowRepeat++;
                          flag1 = false;
                      }
                  }
              }
        
              
            }
            // possibly reduce time complexity by combining these?
            for (int column = 0; column < n; column++) {
                boolean flag2 = true;
                for (int row = 0; row < n; row++) {
                    for (int r1 = row + 1; flag2 &&r1 < n; r1++) {
                        if (matrix[row][column] == matrix[r1][column]) {
                            colRepeat++;
                            flag2 = false;
                        }
                    }
                }
            }
          System.out.println("Case #" + (q + 1) + ": " + traceSum + " " + rowRepeat + " " + colRepeat);          
      }
  }
}