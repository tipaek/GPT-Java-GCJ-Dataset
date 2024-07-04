import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = Integer.parseInt(sc.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = Integer.parseInt(sc.nextLine());
            String[][] matrix = new String[size][size];

            // Read the matrix
            for (int i = 0; i < size; i++) {
                matrix[i] = sc.nextLine().split(" ");
            }

            int trace = 0, rowDuplicates = 0, colDuplicates = 0;

            // Calculate the trace
            for (int i = 0; i < size; i++) {
                trace += Integer.parseInt(matrix[i][i]);
            }

            // Check for row and column duplicates
            for (int i = 0; i < size; i++) {
                if (hasDuplicates(matrix[i])) {
                    rowDuplicates++;
                }

                String[] column = new String[size];
                for (int j = 0; j < size; j++) {
                    column[j] = matrix[j][i];
                }
                if (hasDuplicates(column)) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }
    }

    private static boolean hasDuplicates(String[] array) {
        Set<String> set = new HashSet<>();
        for (String element : array) {
            if (!set.add(element)) {
                return true;
            }
        }
        return false;
    }
}