import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Solution {

    public static boolean isSafe(int[][] board,
            int row, int col,
            int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }
        for (int r = 0; r < board.length; r++) {

            if (board[r][col] == num) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean solveSudoku(int[][] board, int n)  
{ 
    int row = -1; 
    int col = -1; 
    boolean isEmpty = true; 
    for (int i = 0; i < n; i++) 
    { 
        for (int j = 0; j < n; j++)  
        { 
            if (board[i][j] == 0)  
            { 
                row = i; 
                col = j; 
                isEmpty = false;  
                break; 
            } 
        } 
        if (!isEmpty) 
        { 
            break; 
        } 
    } 
    if (isEmpty)  
    { 
        return true; 
    } 
    for (int num = 1; num <= n; num++) 
    { 
        if (isSafe(board, row, col, num)) 
        { 
            board[row][col] = num; 
            if (solveSudoku(board, n))  
            { 
                return true; 
            }  
            else
            { 
                board[row][col] = 0;
            } 
        } 
    } 
    return false; 
} 

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            String y = "";
            int n = scan.nextInt();
            int k = scan.nextInt();
            int[][] m = new int[n][n];
            int total = 0;
            for (int j = n; j > 0; j--) {
                total += j;
            }
            if (k % n == 0 && k / n <= n) {
                y += "POSSIBLE\n";
                m[0][0] = k / n;
                for (int j = 1; j < n; j++) {
                    boolean b = true;
                    int val = 1;
                    while (b) {
                        int count = 0;
                        for (int x : m[0]) {
                            if (val == x) {
                                count++;
                            }
                        }
                        if (count == 0) {
                            b = false;
                        } else {
                            val++;
                        }
                    }
                    m[0][j] = val;

                }
                for (int row = 0; row < n - 1; row++) {
                    m[row + 1][0] = m[row][n - 1];
                    for (int col = 1; col < n; col++) {
                        m[row + 1][col] = m[row][col - 1];
                    }
                }
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < n; x++) {
                        if (x == n - 1) {
                            y += m[j][x];
                        } else {
                            y += m[j][x] + " ";
                        }
                    }
                    if (j != n - 1) {
                        y += "\n";
                    }
                }
            } else if (total == k && n > 2) {
                y += "POSSIBLE\n";
                int u = n;
                for (int j = 0; j < n; j++) {
                    m[j][j] = u;
                    u--;
                }
                if (solveSudoku(m, n)) {
                    for (int j = 0; j < n; j++) {
                        for (int x = 0; x < n; x++) {
                            if (x == n - 1) {
                                y += m[j][x];
                            } else {
                                y += m[j][x] + " ";
                            }
                        }
                        if (j != n - 1) {
                            y += "\n";
                        }
                    }
                }

            } else {
                y += "IMPOSSIBLE";
            }

            System.out.println("Case #" + i + ": " + y);
        }
    }

}