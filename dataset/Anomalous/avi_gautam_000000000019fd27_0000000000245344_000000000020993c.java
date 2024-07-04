import java.util.*;
import java.io.*;

public class Solution {
    private static Set<String> rowSet = null;
    private static Set<String> colSet = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            String[][] charArr = new String[N][N];
            in.nextLine(); // Consume the remaining newline

            for (int r = 0; r < N; r++) {
                String[] rowRead = in.nextLine().split(" ");
                System.arraycopy(rowRead, 0, charArr[r], 0, rowRead.length);
            }

            System.out.println("Case #" + i + ": " + checkDuplicatesAndSum(charArr, N));
        }
    }

    public static String checkDuplicatesAndSum(String[][] array, int size) {
        int rowDupCount = 0, colDupCount = 0, diagonalSum = 0;

        for (int i = 0; i < size; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();

            for (int row = 0; row < size; row++) {
                if (!colSet.add(array[row][i])) {
                    colDupCount++;
                    break;
                }
            }

            for (int col = 0; col < size; col++) {
                if (!rowSet.add(array[i][col])) {
                    rowDupCount++;
                    break;
                }
            }

            diagonalSum += Integer.parseInt(array[i][i]);
        }

        return diagonalSum + " " + rowDupCount + " " + colDupCount;
    }
}