import java.util.*;

public class Solution {

    public static void processMatrix(int matrix[][], int n, int caseNumber) {
        int trace = 0, rowDuplicates = 0, colDuplicates = 0;
        String rowStr = "", colStr = "";
        List<Integer> rowList = new LinkedList<>();
        List<Integer> colList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            rowStr = "";
            colStr = "";
            for (int j = 0; j < n; j++) {
                rowStr += matrix[i][j];
                colStr += matrix[j][i];
                if (i == j) {
                    trace += matrix[i][j];
                }
            }

            for (char c : rowStr.toCharArray()) {
                rowList.add(Character.getNumericValue(c));
            }
            for (char c : colStr.toCharArray()) {
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

    private static boolean hasDuplicates(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[row][col] = sc.nextInt();
                }
            }

            processMatrix(matrix, n, i);
        }
        sc.close();
    }
}