import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class CodeJ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            int n = scanner.nextInt();
            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

            // Initialize the matrix
            for (int i = 0; i < n; ++i) {
                matrix.add(new ArrayList<>());
                for (int j = 0; j < n; ++j) {
                    matrix.get(i).add(scanner.nextInt());
                }
            }

            int rowRepeats = 0, colRepeats = 0, trace = 0;

            // Calculate trace and row repeats
            for (int i = 0; i < n; ++i) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;
                for (int j = 0; j < n; ++j) {
                    int value = matrix.get(i).get(j);
                    if (!rowSet.add(value) && !rowHasDuplicate) {
                        rowRepeats++;
                        rowHasDuplicate = true;
                    }
                }
                trace += matrix.get(i).get(i);
            }

            // Calculate column repeats
            for (int j = 0; j < n; ++j) {
                HashSet<Integer> colSet = new HashSet<>();
                boolean colHasDuplicate = false;
                for (int i = 0; i < n; ++i) {
                    int value = matrix.get(i).get(j);
                    if (!colSet.add(value) && !colHasDuplicate) {
                        colRepeats++;
                        colHasDuplicate = true;
                    }
                }
            }

            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }
}