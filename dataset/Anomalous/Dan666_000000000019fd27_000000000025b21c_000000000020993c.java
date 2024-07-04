import java.util.*;

public class Solution {

    public static void analyzeMatrix(int[][] matrix, int n, int caseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        String rowString = "", colString = "";
        LinkedList<Integer> rowList = new LinkedList<>();
        LinkedList<Integer> colList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            rowString = "";
            colString = "";

            for (int j = 0; j < n; j++) {
                rowString += matrix[i][j];
                colString += matrix[j][i];
            }

            trace += matrix[i][i];

            for (char c : rowString.toCharArray()) {
                rowList.add(Character.getNumericValue(c));
            }
            for (char c : colString.toCharArray()) {
                colList.add(Character.getNumericValue(c));
            }

            Collections.sort(rowList);
            Collections.sort(colList);

            if (hasDuplicates(rowList)) {
                rowDuplicates++;
            }
            if (hasDuplicates(colList)) {
                colDuplicates++;
            }

            rowList.clear();
            colList.clear();
        }

        System.out.format("Case #%d: %d %d %d\n", caseNumber, trace, rowDuplicates, colDuplicates);
    }

    private static boolean hasDuplicates(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int j = 0; j < n * n; j++) {
                int row = j / n;
                int col = j % n;
                matrix[row][col] = scanner.nextInt();
            }

            analyzeMatrix(matrix, n, i);
        }

        scanner.close();
    }
}