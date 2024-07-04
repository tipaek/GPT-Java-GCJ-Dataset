import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        ArrayList<String[]> matrices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = Integer.parseInt(input.nextLine());
            String[] matrix = new String[s];
            for (int j = 0; j < s; j++) {
                matrix[j] = input.nextLine();
            }
            matrices.add(matrix);
        }

        Solution sol = new Solution();
        for (int i = 0; i < n; i++) {
            System.out.println(sol.solve(matrices.get(i), i + 1));
        }
    }

    public String solve(String[] matrix, int caseNumber) {
        int trace = 0, rowDuplicates = 0, columnDuplicates = 0;
        ArrayList<HashSet<Integer>> columns = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            columns.add(new HashSet<>());
        }

        for (int i = 0; i < matrix.length; i++) {
            String[] row = matrix[i].split(" ");
            HashSet<Integer> rowValues = new HashSet<>();

            for (int j = 0; j < row.length; j++) {
                int value = Integer.parseInt(row[j]);
                if (i == j) {
                    trace += value;
                }

                if (rowValues != null && !rowValues.add(value)) {
                    rowValues = null;
                    rowDuplicates++;
                }

                if (columns.get(j) != null && !columns.get(j).add(value)) {
                    columns.set(j, null);
                    columnDuplicates++;
                }
            }
        }

        return String.format("Case #%d: %d %d %d", caseNumber, trace, rowDuplicates, columnDuplicates);
    }
}