import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.HashMap;

class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int tcNumber = in.nextInt();
      	for (int i = 1; i <= tcNumber; i++)
        {
          int matrixDim = in.nextInt();
          int trace = 0;
          int repeatedRow = 0;
          int repeatedColumn = 0;
          int[][] matrix = new int[matrixDim][matrixDim];
          // Save test case matrix and compute trace
          for (int row = 0; row < matrixDim; row++)
          {
            for (int col = 0; col < matrixDim; col++)
            {
              matrix[row][col] = in.nextInt();
              if (row == col)
              {
              	trace = trace + matrix[row][col];
              }
            }
          }
          // Compute number of rows with repeated number
          for (int r = 0; r < matrixDim; r++)
          {
            HashMap<Integer, Integer> repeatedNumber = new HashMap<Integer, Integer>();
            for (int c = 0; c < matrixDim; c++)
            {
              if (repeatedNumber.get(matrix[r][c]) == null)
              {
                repeatedNumber.put(matrix[r][c], 1);
              } else if (repeatedNumber.get(matrix[r][c]) == 1)
              {
                repeatedRow++;
                break;
              }
            }
          }
          for (int r = 0; r < matrixDim; r++)
          {
            HashMap<Integer, Integer> repeatedNumber = new HashMap<Integer, Integer>();
            for (int c = 0; c < matrixDim; c++)
            {
              if (repeatedNumber.get(matrix[c][r]) == null)
              {
                repeatedNumber.put(matrix[c][r], 1);
              } else if (repeatedNumber.get(matrix[c][r]) == 1)
              {
                repeatedColumn++;
                break;
              }
            }
          }
          System.out.println("Case #" + i + ": " + trace + " " + repeatedRow + " " + repeatedColumn);
        }
      	in.close();
    }
}