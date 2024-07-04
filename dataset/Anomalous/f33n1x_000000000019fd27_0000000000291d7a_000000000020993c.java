import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCaseCount = in.nextInt();
        in.nextLine();
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            int n = in.nextInt();
            in.nextLine();
            List<List<Integer>> matrix = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                List<Integer> row = new ArrayList<>();
                String[] elements = in.nextLine().split(" ");
                for (String element : elements) {
                    row.add(Integer.parseInt(element));
                }
                matrix.add(row);
            }

            String result = calculateLatinSquareSet(matrix);
            output.append("Case #").append(i).append(": ").append(result);
            if (i < testCaseCount) {
                output.append("\n");
            }
        }

        System.out.print(output);
    }

    static String calculateLatinSquareSet(List<List<Integer>> matrix) {
        int size = matrix.size();
        int trace = 0;
        int rowViolations = 0;
        int colViolations = 0;

        // Calculate trace
        for (int i = 0; i < size; i++) {
            trace += matrix.get(i).get(i);
        }

        // Check rows for duplicates
        for (List<Integer> row : matrix) {
            Set<Integer> rowSet = new HashSet<>(row);
            if (rowSet.size() < size) {
                rowViolations++;
            }
        }

        // Check columns for duplicates
        for (int col = 0; col < size; col++) {
            Set<Integer> colSet = new HashSet<>();
            for (int row = 0; row < size; row++) {
                colSet.add(matrix.get(row).get(col));
            }
            if (colSet.size() < size) {
                colViolations++;
            }
        }

        return trace + " " + rowViolations + " " + colViolations;
    }
}