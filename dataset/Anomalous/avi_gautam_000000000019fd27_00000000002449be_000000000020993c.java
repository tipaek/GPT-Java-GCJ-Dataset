import java.util.*;
import java.io.*;

public class Solution {
    private static HashSet<String> rowChecker = null;
    private static HashSet<String> colChecker = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            int N = scanner.nextInt();
            String[][] charArray = new String[N][N];

            scanner.nextLine(); // Consume the remaining newline
            for (int r = 0; r < N; r++) {
                String[] rowRead = scanner.nextLine().split(" ");
                for (int c = 0; c < rowRead.length; c++) {
                    charArray[r][c] = rowRead[c];
                }
            }

            System.out.println("Case #" + i + ": " + checkDuplicatesAndSum(charArray, N));
        }
    }

    public static String checkDuplicatesAndSum(String[][] array, int N) {
        int rowDuplicateCount = 0, colDuplicateCount = 0, diagonalSum = 0;

        for (int i = 0; i < N; i++) {
            rowChecker = new HashSet<>();
            colChecker = new HashSet<>();

            for (int row = 0; row < N; row++) {
                if (!colChecker.add(array[row][i])) {
                    colDuplicateCount++;
                    break;
                }
            }

            for (int col = 0; col < N; col++) {
                if (!rowChecker.add(array[i][col])) {
                    rowDuplicateCount++;
                    break;
                }
            }

            diagonalSum += Integer.parseInt(array[i][i]);
        }

        String result = diagonalSum + " " + rowDuplicateCount + " " + colDuplicateCount;
        System.out.println("Output: " + result);
        return result;
    }
}