import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        for (int m = 0; m < t; m++) {
            String k = scanner.nextLine();
            System.out.println("Case #" + (m + 1) + ": " + solve(k, "", ""));
        }

        t = Integer.parseInt(scanner.nextLine());
        for (int m = 1; m <= t; m++) {
            int t1 = Integer.parseInt(scanner.nextLine());
            int[][] matrix = new int[t1][t1];

            for (int j = 0; j < t1; j++) {
                String[] line = scanner.nextLine().split(" ");
                for (int i = 0; i < t1; i++) {
                    matrix[j][i] = Integer.parseInt(line[i]);
                }
            }

            int trace = 0;
            int rowDuplicates = 0;
            int colDuplicates = 0;

            for (int i = 0; i < t1; i++) {
                trace += matrix[i][i];
            }

            for (int i = 0; i < t1; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < t1; j++) {
                    rowSet.add(matrix[i][j]);
                }
                if (rowSet.size() != t1) {
                    rowDuplicates++;
                }
            }

            for (int j = 0; j < t1; j++) {
                Set<Integer> colSet = new HashSet<>();
                for (int i = 0; i < t1; i++) {
                    colSet.add(matrix[i][j]);
                }
                if (colSet.size() != t1) {
                    colDuplicates++;
                }
            }

            System.out.println("Case #" + m + ": " + trace + " " + rowDuplicates + " " + colDuplicates);
        }

        scanner.close();
    }

    private static String solve(String t, String result, String prev) {
        if (!prev.isEmpty() && !prev.equals(" and t!=")) {
            if (Integer.parseInt(prev) > Integer.parseInt(t.substring(0, 1))) {
                for (int i = 0; i < Integer.parseInt(prev) - Integer.parseInt(t.substring(0, 1)); i++) {
                    result += ")";
                }
            }
        }

        if (t.isEmpty()) {
            for (int i = 0; i < Integer.parseInt(prev); i++) {
                result += ")";
            }
            return result;
        }

        if (Integer.parseInt(t.substring(0, 1)) == 0) {
            return solve(t.substring(1), result + t.substring(0, 1), t.substring(0, 1));
        }

        if (Integer.parseInt(t.substring(0, 1)) == 1) {
            if (!prev.isEmpty()) {
                if (Integer.parseInt(prev) == 0) {
                    result += "(" + t.substring(0, 1);
                } else {
                    result += t.substring(0, 1);
                }
            } else {
                result += "(" + t.substring(0, 1);
            }
            return solve(t.substring(1), result, t.substring(0, 1));
        }

        if (Integer.parseInt(t.substring(0, 1)) > 1) {
            if (!prev.isEmpty()) {
                for (int i = 0; i < Integer.parseInt(t.substring(0, 1)) - Integer.parseInt(prev); i++) {
                    result += "(";
                }
                result += t.substring(0, 1);
            } else {
                for (int i = 0; i < Integer.parseInt(t.substring(0, 1)); i++) {
                    result += "(";
                }
                result += t.substring(0, 1);
            }
            return solve(t.substring(1), result, t.substring(0, 1));
        }

        return result;
    }
}