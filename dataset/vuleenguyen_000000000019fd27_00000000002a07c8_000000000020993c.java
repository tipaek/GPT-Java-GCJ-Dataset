
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            int size = sc.nextInt();
            int[] re = helper(size, sc);
            System.out.println(String.format("Case #%s: %s %s %s", i, re[0],re[1],re[2]));
        }
    }

    private static int[] helper(int size, Scanner sc) {

        Set<Integer>[] rowSet = new Set[size];
        Set<Integer>[] colSet = new Set[size];
        for(int i = 0; i < size; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        int[][] m = new int[size][size];
        int sum = 0;
        boolean[] rowCal = new boolean[size], colCal = new boolean[size];
        int rowDup = 0, colDup = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                m[i][j] = sc.nextInt();
                if (i == j) sum += m[i][j];
                if (!rowSet[i].add(m[i][j]) && !rowCal[i]) {
                    rowCal[i] = true;
                    rowDup++;
                }

                if (!colSet[j].add(m[i][j]) && !colCal[j]) {
                    colCal[j] = true;
                    colDup++;
                }
            }
        }


        return new int[]{sum, rowDup, colDup};
    }
}
