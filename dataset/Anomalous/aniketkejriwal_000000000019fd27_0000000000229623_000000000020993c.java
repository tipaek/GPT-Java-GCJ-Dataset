import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            int matrixSize = scanner.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();

            for (int row = 0; row < matrixSize; row++) {
                List<Integer> currentRow = new ArrayList<>();
                for (int col = 0; col < matrixSize; col++) {
                    currentRow.add(scanner.nextInt());
                }
                matrix.add(currentRow);
            }

            int trace = 0, rowRepeats = 0, colRepeats = 0;

            for (int i = 0; i < matrixSize; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < matrixSize; j++) {
                    if (!rowHasDuplicate && !rowSet.add(matrix.get(i).get(j))) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    }
                    if (!colHasDuplicate && !colSet.add(matrix.get(j).get(i))) {
                        colRepeats++;
                        colHasDuplicate = true;
                    }
                }

                trace += matrix.get(i).get(i);
            }

            System.out.println("Case #" + caseIndex + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }
}