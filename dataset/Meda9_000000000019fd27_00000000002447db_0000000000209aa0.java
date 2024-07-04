import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static HashSet<List<Integer>> generated = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int[][][] res = new int[t][][];

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int k = in.nextInt();
            generated.clear();
            res[i - 1] = helper(n, k);
        }
        for (int i = 1; i <= res.length; i++) {
            if (res[i - 1] == null) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + i + ": POSSIBLE");
                for (int j = 0; j < res[i - 1].length; j++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int k : res[i - 1][j]) {
                        stringBuilder.append(k);
                        stringBuilder.append(' ');
                    }
                    System.out.println(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
                }
            }
        }
    }

    private static int[][] helper(int n, int k) {
        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = i + 1;
        }

        generateSum(values, 0, k, values.length, new ArrayList<>());
        
        for (List<Integer> entry : generated) {
            int[][] matrix = generateLatinMatrix(entry);
            if (matrix != null) {
                return matrix;
            }
        }

        return null;
    }

    private static int[][] generateLatinMatrix(List<Integer> entry) {
        int[][] matrix = new int[entry.size()][entry.size()];
        int[][] rows = new int[entry.size()][entry.size() + 1];
        int[][] cols = new int[entry.size()][entry.size() + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = entry.get(i);
            rows[i][entry.get(i)] = 1;
            cols[i][entry.get(i)] = 1;
        }

        return fillMatrix(matrix, rows, cols) ? matrix : null;
    }

    private static boolean fillMatrix(int[][] matrix, int[][] rows, int[][] cols) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int num = matrix[i][j];
                if (num == 0) {
                    int available = getNextAvailable(rows[i], cols[j]);
                    if (available == 0) {
                        return false;
                    }
                    rows[i][available]++;
                    cols[j][available]++;
                    matrix[i][j] = available;
                }
            }
        }

        return true;
    }

    private static int getNextAvailable(int[] row, int[] col) {
        for (int i = 1; i < row.length; i++) {
            if (row[i] == 0 && col[i] == 0) {
                return i;
            }
        }

        return 0;
    }


    static void generateSum(int[] values, int idx, int target, int rem, List<Integer> intermediate) {
        if (intermediate.size() > values.length) {
            return;
        }
        if (rem == 0) {
            if (target == 0) {
                Collections.sort(intermediate);
                generated.add(intermediate);
            }
            return;
        }
        if (rem <= 0 || target <= 0) {
            return;
        }

        for (int i = idx; i < values.length; i++) {
            for (int j = 0; j <= rem; j++) {
                List<Integer> list = new ArrayList<>(intermediate);
                for (int k = 0; k <= j; k++) {
                    list.add(values[i]);
                }
                generateSum(values, idx + 1, target - (j + 1) * values[i], rem - j - 1, list);
            }
        }
    }
}
