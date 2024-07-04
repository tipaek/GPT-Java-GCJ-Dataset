import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhxu
 */

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int testCases = in.nextInt();

        for (int i = 0; i < testCases; ++i) {
            int N = in.nextInt();
            int target = in.nextInt();

            Set<Integer>[] rowRemain = new Set[N];
            Set<Integer>[] colRemain = new Set[N];

            for(int row = 0; row < N; row++) {
                rowRemain[row] = new HashSet<>();
                for(int n = 1; n <= N; n++) {
                    rowRemain[row].add(n);
                }
            }

            for(int col = 0; col < N; col++) {
                colRemain[col] = new HashSet<>();
                for(int n = 1; n <= N; n++) {
                    colRemain[col].add(n);
                }
            }

            int[][] matrix = new int[N][N];

            boolean res = dfs(matrix, 0, 0, rowRemain, colRemain, target);

            if(res) {
                System.out.println(String.format("Case #%d: POSSIBLE", i + 1));
                System.out.println(Arrays.stream(matrix)
                        .map(Arrays::stream)
                        .map(s -> s.boxed()
                                .map(String::valueOf)
                                .collect(Collectors.joining(" "))
                        ).collect(Collectors.joining("\n")));
            }
            else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", i + 1));
            }
        }
    }

    static boolean dfs(int[][] matrix, int row, int col, Set<Integer>[] rowRemain, Set<Integer>[] colRemain, int target) {
        if(row == matrix.length) {
            int trace = 0;
            for(int i = 0; i < matrix.length; i++)
                trace += matrix[i][i];
            return trace == target;
        }

        int nCol = (col + 1) % matrix[0].length;
        int nRow = nCol == 0 ? row + 1 : row;

        for(int i : new ArrayList<>(rowRemain[row])) {
            if(colRemain[col].contains(i)) {
                matrix[row][col] = i;
                rowRemain[row].remove(i);
                colRemain[col].remove(i);
                if (dfs(matrix, nRow, nCol, rowRemain, colRemain, target))
                    return true;
                rowRemain[row].add(i);
                colRemain[col].add(i);
            }
        }

        return false;
    }
}
