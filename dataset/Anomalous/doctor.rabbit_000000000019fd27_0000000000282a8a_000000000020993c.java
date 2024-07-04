import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        while (scanner.hasNextInt()) {
            int numOfCases = scanner.nextInt();

            for (int caseIndex = 1; caseIndex <= numOfCases; caseIndex++) {
                int N = scanner.nextInt();
                int[][] matrix = new int[N][N];
                int[][] rotatedMatrix = new int[N][N];
                int sumOfDiagonal = 0;
                int duplicateRows = 0;
                int duplicateColumns = 0;

                for (int i = 0; i < N; i++) {
                    Set<Integer> rowSet = new HashSet<>();
                    boolean rowHasDuplicates = false;

                    for (int j = 0; j < N; j++) {
                        int value = scanner.nextInt();
                        matrix[i][j] = value;
                        rotatedMatrix[j][N - 1 - i] = value;

                        if (i == j) {
                            sumOfDiagonal += value;
                        }

                        if (!rowSet.add(value) && !rowHasDuplicates) {
                            duplicateRows++;
                            rowHasDuplicates = true;
                        }
                    }
                }

                for (int i = 0; i < N; i++) {
                    Set<Integer> colSet = new HashSet<>();
                    boolean colHasDuplicates = false;

                    for (int j = 0; j < N; j++) {
                        if (!colSet.add(rotatedMatrix[i][j]) && !colHasDuplicates) {
                            duplicateColumns++;
                            colHasDuplicates = true;
                        }
                    }
                }

                System.out.println("Case #" + caseIndex + ": " + sumOfDiagonal + " " + duplicateRows + " " + duplicateColumns);
            }
        }
    }
}