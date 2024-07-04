import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTC = sc.nextInt();
        
        for(int tc=1; tc<=numTC; tc++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            
            int[][] matrix = new int[n][n];
            
            boolean possible = true;
            
            if(!buildSuccessful(matrix, n, k))
                possible = false;
            
            if (!possible)
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            else {
                System.out.println("Case #" + tc + ": POSSIBLE");
                printMatrix(matrix, n);
            }
        }
    }
    
    public static boolean buildSuccessful(int[][] matrix, int n, int k) {
      for (int row = 0; row < n; row++) {
          for (int column = 0; column < n; column++) {
              if (matrix[row][column] == 0) {
                  for (int t = 1; t <= n; t++) {
                      matrix[row][column] = t;
                      if (isValid(matrix, row, column) && buildSuccessful(matrix, n, k) && trace(matrix) == k) {
                          return true;
                      }
                      matrix[row][column] = 0;
                  }
                  return false;
              }
          }
      }
      return true;
    }

    private static boolean isValid(int[][] board, int row, int column) {
        return (rowConstraint(board, row)
          && columnConstraint(board, column));
    }

    private static boolean rowConstraint(int[][] board, int row) {
    boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
          .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private static boolean columnConstraint(int[][] board, int column) {
        boolean[] constraint = new boolean[board.length];
        return IntStream.range(0, board.length)
          .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private static boolean subsectionConstraint(int[][] board, int row, int column) {
        boolean[] constraint = new boolean[board.length];
        int subsectionRowStart = (row / 2) * 2;
        int subsectionRowEnd = subsectionRowStart + 2;
    
        int subsectionColumnStart = (column / 2) * 2;
        int subsectionColumnEnd = subsectionColumnStart + 2;
    
        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    static boolean checkConstraint(
        int[][] board, 
        int row, 
        boolean[] constraint, 
        int column) {
        if (board[row][column] != 0) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static int trace(int[][] matrix) {
      int trace = 0;

      for(int i=0; i<matrix.length; i++) {
        for(int j=0; j<matrix.length; j++) {
          if (i == j) trace += matrix[i][j];
        }
      }

      return trace;
    }
    
    public static Integer[] shiftLeft(Integer[] array, int index) {
        Integer[] newArray = new Integer[array.length];
        
        for (int i=0; i<array.length; i++)
            newArray[i] = array[(i + 2*index) % (array.length)];
            
        return newArray;
    }
    
    public static Integer[] shiftRight(Integer[] array, int index) {
        Integer[] newArray = new Integer[array.length];
        
        for (int i=0; i<array.length; i++)
            newArray[i] = array[(array.length + i - index) % (array.length)];
            
        return newArray;
    }
    
    public static List<Integer[]> constructList (int n) {
        Integer[] base = new Integer[n];
        
        for (int i=0; i<n; i++)
            base[i] = i+1;
        
        return permute(base);
    }
    
    public static List<Integer[]> permute(Integer[] nums) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        helper(0, nums, result);
        return result;
    }
 
    private static void helper(int start, Integer[] nums, List<Integer[]> result){
        if(start==nums.length-1){
            Integer[] list = nums.clone();
            result.add(list);
            return;
        }
     
        for(int i=start; i<nums.length; i++){
            swap(nums, i, start);
            helper(start+1, nums, result);
            swap(nums, i, start);
        }
    }
     
    public static void swap(Integer[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void printMatrix(int[][] matrix, int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<n-1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(matrix[i][n-1]);
        }
    }
}