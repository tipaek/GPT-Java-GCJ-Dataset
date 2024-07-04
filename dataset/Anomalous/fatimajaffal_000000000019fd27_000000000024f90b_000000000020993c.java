import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = scanner.nextInt();
            int trace = 0, rowCount = 0, colCount = 0;

            ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
            boolean[] colDuplicate = new boolean[n];

            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                boolean hasRowDuplicate = false;

                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    int value = scanner.nextInt();

                    if (!hasRowDuplicate && !rowSet.add(value)) {
                        rowCount++;
                        hasRowDuplicate = true;
                    }

                    for (int k = 0; k < i; k++) {
                        if (matrix.get(k).get(j) == value && !colDuplicate[j]) {
                            colCount++;
                            colDuplicate[j] = true;
                        }
                    }

                    row.add(value);
                    if (i == j) {
                        trace += value;
                    }
                }
                matrix.add(row);
            }
            System.out.println("Case #" + caseNum + ": " + trace + " " + rowCount + " " + colCount);
        }

        scanner.close();
    }
}