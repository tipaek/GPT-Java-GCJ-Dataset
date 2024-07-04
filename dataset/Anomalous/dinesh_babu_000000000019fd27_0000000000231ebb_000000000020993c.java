import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int caseNumber = 1;

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            List<Set<Integer>> columnSets = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean rowHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    int value = sc.nextInt();
                    if (i == j) trace += value;
                    matrix[i][j] = value;

                    if (!rowSet.add(value)) rowHasDuplicate = true;

                    if (i == 0) {
                        Set<Integer> colSet = new HashSet<>();
                        colSet.add(value);
                        columnSets.add(colSet);
                    } else {
                        columnSets.get(j).add(value);
                    }
                }

                if (rowHasDuplicate) rowRepeats++;
            }

            for (Set<Integer> colSet : columnSets) {
                if (colSet.size() != n) colRepeats++;
            }

            System.out.println("Case #" + caseNumber + ": " + trace + " " + rowRepeats + " " + colRepeats);
            caseNumber++;
        }

        sc.close();
    }
}