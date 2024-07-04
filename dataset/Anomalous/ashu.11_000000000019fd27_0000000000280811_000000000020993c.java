import java.util.*;

public class Solution {

    public static class ResultSet {
        int trace;
        int noOfRows;
        int noOfCols;

        ResultSet(int trace, int noOfRows, int noOfCols) {
            this.trace = trace;
            this.noOfRows = noOfRows;
            this.noOfCols = noOfCols;
        }
    }

    public static ResultSet solve(List<List<Integer>> matrix) {
        int trace = 0;
        int duplicateRows = 0;
        int duplicateCols = 0;
        int n = matrix.size();

        for (int i = 0; i < n; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                rowSet.add(matrix.get(i).get(j));
                colSet.add(matrix.get(j).get(i));
                if (i == j) {
                    trace += matrix.get(i).get(j);
                }
            }
            if (rowSet.size() < n) duplicateRows++;
            if (colSet.size() < n) duplicateCols++;
        }

        return new ResultSet(trace, duplicateRows, duplicateCols);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = scanner.nextInt();
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(scanner.nextInt());
                }
                matrix.add(row);
            }

            ResultSet result = solve(matrix);
            System.out.println("Case #" + caseNumber + ": " + result.trace + " " + result.noOfRows + " " + result.noOfCols);
            caseNumber++;
        }

        scanner.close();
    }
}