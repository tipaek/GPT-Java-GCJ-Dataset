import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = Integer.parseInt(sc.nextLine());

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int matrixSize = Integer.parseInt(sc.nextLine());
            String[][] matrix = new String[matrixSize][matrixSize];

            for (int i = 0; i < matrixSize; i++) {
                matrix[i] = sc.nextLine().split(" ");
            }

            int trace = 0;
            int rowRepeats = 0;
            int colRepeats = 0;

            for (int i = 0; i < matrixSize; i++) {
                Set<String> rowSet = new HashSet<>();
                Set<String> colSet = new HashSet<>();
                boolean rowHasDuplicates = false;
                boolean colHasDuplicates = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowSet.add(matrix[i][j])) {
                        rowHasDuplicates = true;
                    }
                    if (!colSet.add(matrix[j][i])) {
                        colHasDuplicates = true;
                    }
                }

                if (rowHasDuplicates) {
                    rowRepeats++;
                }
                if (colHasDuplicates) {
                    colRepeats++;
                }

                trace += Integer.parseInt(matrix[i][i]);
            }

            System.out.println("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}