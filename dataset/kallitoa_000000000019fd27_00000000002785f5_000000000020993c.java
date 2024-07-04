import java.util.*;

public class Solution {

    public static void main(String arg[]) {
        Scanner input = new Scanner(System.in);
        int t = Integer.valueOf(input.nextLine());
        int caseNumber = 1;
        List<String> results = new ArrayList<>();

        while (t > 0) {
            int n = Integer.valueOf(input.nextLine());
            Integer[][] matrix = new Integer[n][n];
            for (int i = 0; i < n; i++) {
               String[] s = input.nextLine().split(" ");
               for (int j = 0; j < n; j++) {
                   matrix[i][j] = Integer.valueOf(s[j]);
               }
            }
            results.add(getResult(caseNumber, matrix));
            caseNumber++;
            t--;
        }

        for (String r : results) {
            System.out.println(r);
        }

    }

    private static String getResult(int caseNumber, Integer[][] matrix) {
        int i = 0; int j = 0; int trace = 0;
        int n = matrix[0].length;
        while (i < n && j < n) {
            trace += matrix[i][j];
            i++;
            j++;
        }
        int row = getRowNumWithDuplicates(matrix);
        int col = getColNumWithDuplicates(matrix);
        return String.format("Case #%d: %d %d %d", caseNumber, trace, row, col);
    }

    private static int getColNumWithDuplicates(Integer[][] matrix) {
        int col = 0;
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (set.contains(matrix[j][i])) {
                    col++;
                    j = matrix[i].length + 1;
                } else {
                    set.add(matrix[j][i]);
                }
            }
        }

        return col;
    }

    private static int getRowNumWithDuplicates(Integer[][] matrix) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            Integer[] current = matrix[i];
            Set<Integer> set = new HashSet<>(Arrays.asList(current));
            if (set.size() != current.length) {
                row++;
            }
        }

        return row;
    }
}
