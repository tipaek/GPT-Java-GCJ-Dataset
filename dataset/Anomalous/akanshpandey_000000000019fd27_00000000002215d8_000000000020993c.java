import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size + 1][size + 1];

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;
            for (int row = 1; row <= size; row++) {
                for (int col = 1; col <= size; col++) {
                    int value = scanner.nextInt();
                    matrix[row][col] = value;
                    if (row == col) {
                        trace += value;
                    }
                }
            }

            for (int index = 1; index <= size; index++) {
                HashSet<Integer> rowSet = new HashSet<>();
                HashSet<Integer> colSet = new HashSet<>();
                for (int innerIndex = 1; innerIndex <= size; innerIndex++) {
                    rowSet.add(matrix[index][innerIndex]);
                    colSet.add(matrix[innerIndex][index]);
                }
                if (rowSet.size() != size) rowRepeats++;
                if (colSet.size() != size) colRepeats++;
            }

            System.out.println("Case #" + testCase + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
        scanner.close();
    }
}