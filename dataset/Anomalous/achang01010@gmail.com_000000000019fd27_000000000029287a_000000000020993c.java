import java.util.Scanner;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();

        for (int caseIndex = 0; caseIndex < numCases; caseIndex++) {
            int size = sc.nextInt();
            int[][] matrix = new int[size][size];

            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < size; i++) {
                trace += matrix[i][i];
            }

            int rowRepeats = 0;
            int colRepeats = 0;

            for (int row = 0; row < size; row++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int col = 0; col < size; col++) {
                    if (!rowSet.add(matrix[row][col])) {
                        rowRepeats++;
                        break;
                    }
                }
            }

            for (int col = 0; col < size; col++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int row = 0; row < size; row++) {
                    if (!colSet.add(matrix[row][col])) {
                        colRepeats++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}