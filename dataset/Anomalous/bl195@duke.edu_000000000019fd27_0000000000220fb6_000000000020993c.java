import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        
        for (int i = 0; i < size; i++) {
            int n = scan.nextInt();
            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            int[][] board = new int[n][n];

            // Read the board and calculate the trace
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
                HashSet<Integer> rowSet = new HashSet<>();
                for (int y = 0; y < n; y++) {
                    if (!rowSet.add(board[x][y])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            // Check for column duplicates
            for (int y = 0; y < n; y++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int x = 0; x < n; x++) {
                    if (!colSet.add(board[x][y])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}