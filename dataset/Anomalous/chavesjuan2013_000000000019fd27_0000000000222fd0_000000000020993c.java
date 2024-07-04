import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int size = Integer.parseInt(reader.readLine());
            int[][] matrix = new int[size][size];
            HashSet<Integer> usedNumbers;

            for (int i = 0; i < size; i++) {
                String[] inputLine = reader.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = Integer.parseInt(inputLine[j]);
                }
            }

            int diagonalSum = 0;
            for (int i = 0; i < size; i++) {
                diagonalSum += matrix[i][i];
            }

            int duplicateRows = 0;
            int duplicateColumns = 0;

            for (int i = 0; i < size; i++) {
                usedNumbers = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    if (!usedNumbers.add(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                }
            }

            for (int j = 0; j < size; j++) {
                usedNumbers = new HashSet<>();
                for (int i = 0; i < size; i++) {
                    if (!usedNumbers.add(matrix[i][j])) {
                        duplicateColumns++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (caseIndex + 1) + ": " + diagonalSum + " " + duplicateRows + " " + duplicateColumns);
        }
    }
}