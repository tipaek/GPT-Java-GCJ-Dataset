import java.util.*;
import java.io.*;
public class Solution {


    public static int notUniqueRows(int[][] arr) {
        int notUnique = 0;
        for (int i = 0; i < arr.length; i++) {
            HashSet<Integer> seenInRow = new HashSet<>();
            for (int j = 0; j < arr[i].length; j++) {
                if (!seenInRow.contains(arr[i][j])) {
                    seenInRow.add(arr[i][j]);
                } else {
                    notUnique++;
                    break;
                }
            }
        }
        return notUnique;
    }

    public static int notUniqueColumns(int[][] arr) {
        int notUnique = 0;
        for (int col = 0; col < arr.length; col++) {
            HashSet<Integer> seenInCol = new HashSet<>();
            for (int[] row : arr) {
                if (!seenInCol.contains(row[col])) {
                    seenInCol.add(row[col]);
                } else {
                    notUnique++;
                    break;
                }
            }
        }
        return notUnique;
    }






    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int sizeOfArray = in.nextInt();
            int squared = sizeOfArray*sizeOfArray;
            while (squared > 0) {
                int total = 0;
                int[][] board = new int[sizeOfArray][sizeOfArray];
                for (int k = 0; k < board.length; k++) {
                    for (int j = 0; j < board[k].length; j++) {
                        board[k][j] = in.nextInt();
                        if (k == j) {
                            total += board[k][j];
                        }
                        squared--;
                    }
                }
                int rowVal = notUniqueRows(board);
                int colVal = notUniqueColumns(board);
                System.out.println("Case #" + i + ": " + total + " " + rowVal + " " + colVal);
            }
        }
    }
}