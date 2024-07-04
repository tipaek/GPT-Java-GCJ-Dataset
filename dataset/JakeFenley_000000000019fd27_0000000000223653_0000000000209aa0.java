import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    
    int t = scnr.nextInt();
    
    for (int cas = 0; cas < t; ++cas) {
      int n = scnr.nextInt();
      int trace = scnr.nextInt();
      boolean validConstant = false;
      boolean validSeq = false;
      boolean validEven = false;
      boolean validOdd = false;
      int seqInitial = -1;
      double sum = n*(2+(n-1))/2;
      int centerLine = -1;
      
      if (n > 3) {
        if (trace == sum) {
          validSeq = true;
        } else if (n%2 == 0) {
          if (trace == 3 * n || trace == 4 * n) {
            validEven = true;
          }
        }
      }
      
      if (validOdd == false && validEven == false) {
        for(int i = 1; i <= n; ++i) {
          if (trace == (i * n)) {
            validConstant = true;
            centerLine = i;
          }
        }
      }
      
//      if (validConstant == false) {
//        for (int i = 0; i < n; ++i) {
//          int sum1 = 0;
//          for (int j = 0; j < n; ++j) {
//            sum1 += ((i-1) + (2 * j))%6 + 1;
//          }
//          if (trace == sum1) {
//            validSeq = true;
//            seqInitial = i;
//            break;
//          }
//        }
//      }
      
      if (validConstant == false && validSeq == false && validEven == false) {
        System.out.println("Case #" + (cas + 1) + ": IMPOSSIBLE");
        continue;
      }
      
      
      
      int[][] matrix = new int[n][n];

      if (validConstant == true && centerLine != -1) {
        for (int i  = 0; i < n; ++i) {
          for (int j = 0; j < n; ++j) {
            if (i == j) {
              matrix[i][j] = centerLine;
            } else {
              if (j == 0) {
                matrix[i][j] = (matrix[i -1][n - 1]-1) % n + 1;
              } else {
                matrix[i][j] = (matrix[i][j-1]) % n + 1;
              }
            }
          }
        }
      }
      
      if (validSeq == true) {
        for (int i  = 0; i < n; ++i) {
          for (int j = 0; j < n; ++j) {
            matrix[i][j] = (i + j)%n + 1;
          }
        }
      }
      
      if (validEven == true) {
        for (int i  = 0; i < n; ++i) {
          for (int j = 0; j < n; ++j) {
            matrix[i][j] = (n -1 + i + j)%n + 1;
          }
        }
      }
      
      System.out.println("Case #" + (cas + 1) + ": POSSIBLE");
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          System.out.print(matrix[i][j] + " ");
        }
        System.out.println();
      }    
    }
  }
}
