import java.util.*;
import java.io.*;

class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int size = scan.nextInt();
        
        for (int i = 0; i < size; i++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] board = new int[n][n];
            
            // Read the matrix and calculate the trace
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    board[x][y] = scan.nextInt();
                    if (x == y) {
                        trace += board[x][y];
                    }
                }
            }
            
            // Check for row duplicates
            for (int x = 0; x < n; x++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (!rowSet.add(board[x][y])) {
                        rowRepeats++;
                        break;
                    }
                }
            }
            
            // Check for column duplicates
            for (int x = 0; x < n; x++) {
                Set<Integer> colSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (!colSet.add(board[y][x])) {
                        colRepeats++;
                        break;
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        
        scan.close();
    }
}