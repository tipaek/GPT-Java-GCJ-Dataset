import java.util.*;
public class Solution {

  private static int n=0;
  private static int k=0;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    int cases = 1;

    while(testcases>0){
      n = sc.nextInt();
      k = sc.nextInt();
      int[][] board = new int[n][n];

      if(solve(board) && isVDiagonal(board)){
        System.out.println("Case #"+cases+": POSSIBLE");
        for(int i=0;i<n;i++){
          for(int j=0;j<n;j++)
            System.out.print(board[i][j]+" ");
          System.out.println();
        }
      }else{
        System.out.println("Case #"+cases+": IMPOSSIBLE");
      }
      cases++;
      testcases--;
    }
  }


  public static boolean solve(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        if(board[i][j] == 0){
          for(int c = 1; c <= board.length; c++){//trial. Try 1 through 9
            if(isValid(board, i, j, c)){
              board[i][j] = c; //Put c for this cell

              if(solve(board))
                return true; //If it's the solution return true
              else
                board[i][j] = 0; //Otherwise go back
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  private static void printArray(int[][] board){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++)
        System.out.print(board[i][j]);
      System.out.println();
    }
  }
  private static boolean isVDiagonal(int[][] board){
    int sum = 0;
    for(int i=0;i<n;i++)
    sum+=board[i][i];
    return sum==k;
  }
  private static boolean isValid(int[][] board, int row, int col, int c){
    boolean emptyCell =  false;
    int sum = 0;
    // printArray(board);
    for(int i = 0; i < n; i++) {
      if(board[i][col] != 0 && board[i][col] == c) return false; //check row
      if(board[row][i] != 0 && board[row][i] == c) return false; //check column
      if(board[i][i]==0){
        emptyCell = true;
      }
      sum+=board[i][i];
    }
    if(!emptyCell && sum!=k){
      return false;
    }
    return true;
  }
}