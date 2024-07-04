import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = Integer.parseInt(sc.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = Integer.parseInt(sc.nextLine());
            String[][] matrix = new String[size][size];

            for (int i = 0; i < size; i++) {
                matrix[i] = sc.nextLine().split(" ");
            }

            int trace = 0, duplicateRows = 0, duplicateCols = 0;

            for (int i = 0; i < size; i++) {
                Set<String> rowSet = new HashSet<>();
                Set<String> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < size; j++) {
                    // Calculate trace
                    if (i == j) {
                        trace += Integer.parseInt(matrix[i][j]);
                    }

                    // Check for duplicate in row
                    if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                        duplicateRows++;
                        rowHasDuplicate = true;
                    }

                    // Check for duplicate in column
                    if (!colSet.add(matrix[j][i]) && !colHasDuplicate) {
                        duplicateCols++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}