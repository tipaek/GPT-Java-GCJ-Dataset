import java.util.HashSet;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String[][] matrix = new String[n][n];
            int trace = 0;
            int duplicateRows = 0;
            int duplicateCols = 0;

            for (int i = 0; i < n; i++) {
                String[] row = scanner.nextLine().split(" ");
                matrix[i] = row;
                trace += Integer.parseInt(row[i]);
                if (hasDuplicates(row)) {
                    duplicateRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                String[] column = new String[n];
                for (int i = 0; i < n; i++) {
                    column[i] = matrix[i][j];
                }
                if (hasDuplicates(column)) {
                    duplicateCols++;
                }
            }

            System.out.println("Case #" + t + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }

        scanner.close();
    }

    private static boolean hasDuplicates(String[] array) {
        HashSet<String> set = new HashSet<>();
        for (String element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}