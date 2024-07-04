import java.util.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        
        for (int i = 0; i < size; i++) {
            int n = scan.nextInt();
            int k = 0;
            int r = 0;
            int c = 0;
            int[][] board = new int[n][n];
            
            // Reading the matrix and computing the trace
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    board[x][y] = scan.nextInt();
                    if (x == y) {
                        k += board[x][y];
                    }
                }
            }
            
            // Checking for duplicate values in rows
            for (int x = 0; x < n; x++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (!rowSet.add(board[x][y])) {
                        r++;
                        break;
                    }
                }
            }
            
            // Checking for duplicate values in columns
            for (int y = 0; y < n; y++) {
                Set<Integer> colSet = new HashSet<>();
                for (int x = 0; x < n; x++) {
                    if (!colSet.add(board[x][y])) {
                        c++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + k + " " + r + " " + c);
        }
    }
}