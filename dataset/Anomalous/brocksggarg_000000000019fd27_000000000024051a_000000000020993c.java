import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            processTestCase(reader, testCase);
        }
    }

    private static void processTestCase(BufferedReader reader, int testCaseNumber) throws NumberFormatException, IOException {
        int size = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            String[] inputLine = reader.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        int duplicateRows = 0, duplicateColumns = 0, trace = 0;
        Set<Integer> uniqueElements = new HashSet<>();
        
        // Check for duplicate elements in rows
        for (int i = 0; i < size; i++) {
            uniqueElements.clear();
            for (int j = 0; j < size; j++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateRows++;
                    break;
                }
            }
        }

        // Check for duplicate elements in columns
        for (int j = 0; j < size; j++) {
            uniqueElements.clear();
            for (int i = 0; i < size; i++) {
                if (!uniqueElements.add(matrix[i][j])) {
                    duplicateColumns++;
                    break;
                }
            }
        }

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }

        System.out.println("Case #" + testCaseNumber + ": " + trace + " " + duplicateRows + " " + duplicateColumns);
    }
}