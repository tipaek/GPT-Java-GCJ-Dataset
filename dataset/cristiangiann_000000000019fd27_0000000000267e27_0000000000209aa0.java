
import java.util.*;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int nTests = Integer.parseInt(in.nextLine());

        for (int counter = 0; counter < nTests; counter++) {
            String input = in.nextLine();
            int n =  Integer.parseInt(input.split(" ")[0]);
            int k =  Integer.parseInt(input.split(" ")[1]);
            System.out.print("Case #" + (counter + 1) + ": ");
            findTrace(n, k);
        }
    }

    private static void findTrace(int n, int k){
        int[] trace = new int[n];
        Arrays.fill(trace, 0);
        if(!calculateNextValues(trace, 0, k, 0, 0)) System.out.println("IMPOSSIBLE");
    }

    private static boolean calculateNextValues(int[] trace, int index, int k, int sum, int usedValues){
        if(usedValues >= trace.length || sum >= k || index >= trace.length){
            if(sum == k && trace.length == usedValues) {
                return calculateSudoku(trace.clone());
            }
            else return false;
        }
        trace[index] = 0;
        int remainingValues = trace.length - usedValues;
        for(int i = 0; i <= remainingValues; i++){
            int currentValue = i * (index + 1) + sum;
            if(currentValue + (remainingValues - i) * (index+1) <= k && currentValue + (remainingValues - i) * (trace.length) >= k){
                trace[index] = i;
                if(calculateNextValues(trace, index + 1, k, currentValue, usedValues + i)) return true;
            }
        }
        trace[index] = 0;
        return false;
    }

    private static boolean calculateSudoku(int[] trace){
        int n = trace.length;
        int[][] matrix = new int[n][n];
        int traceIndex = 0;
        for(int i = 0; i < n; i++){
            boolean found = false;
            while(!found){
                if(trace[traceIndex] == 0) traceIndex++;
                else found = true;
            }
            matrix[i][i] = traceIndex + 1;
            trace[traceIndex]--;
        }
        boolean feasible = solveSudoku(matrix, matrix.length);
        if (feasible){
            System.out.println("POSSIBLE");
            printMatrix(matrix);
        }
        return feasible;
    }

    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) break;
        }
        if (isEmpty) return true;

        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) return true;
                else board[row][col] = 0;
            }
        }
        return false;
    }

    public static boolean isSafe(int[][] board,int row, int col, int num) {
        for (int d = 0; d < board.length; d++) if (board[row][d] == num) return false;
        for (int r = 0; r < board.length; r++) if (board[r][col] == num) return false;
        return true;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
