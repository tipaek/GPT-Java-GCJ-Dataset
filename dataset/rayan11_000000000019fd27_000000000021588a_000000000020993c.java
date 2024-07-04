import java.util.Arrays;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main (String [] args) throws Exception{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int t = Integer.parseInt (br.readLine());
        for (int testCase = 1; testCase <= t; testCase ++) {
            int n = Integer.parseInt (br.readLine());
            int [][] grid = new int [n][n];
            for (int k = 0; k < n; k ++) {
                grid [k] = Arrays.stream (br.readLine().split (" ")).mapToInt (Integer:: parseInt).toArray();
            }
            int latinSum = calculateLatinSum (grid);
            int rowC = findDuplicatedRow (grid);
            int colC = findDuplicatedCol (grid);

            System.out.printf ("Case #%d: %d %d %d\n", testCase, latinSum, rowC, colC);

        }

    }

    public static int calculateLatinSum (int [][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i ++) {
            sum += grid[i][i];
        }
        return sum;
    }

    public static int findDuplicatedCol (int [][] grid) {
        int colC = 0;
        for (int i = 0; i < grid.length; i ++) {
            HashSet<Integer> repeatedCol = new HashSet<>();
            for (int j = 0; j < grid[i].length; j ++) {
                if (repeatedCol.contains (grid[j][i])) {
                    colC ++;
                    break;
                } else {
                    repeatedCol.add (grid[j][i]);
                }

            }
        }
        return colC;
    }

    public static int findDuplicatedRow (int [][] grid) {
        int rowC = 0;
        for (int i = 0; i < grid.length; i ++) {
            HashSet<Integer> repeatedRow = new HashSet<>();
            for (int j = 0; j < grid[i].length; j ++) {
                if (repeatedRow.contains (grid[i][j])) {
                    rowC ++;
                    break;
                } else {
                    repeatedRow.add (grid[i][j]);
                }
            }
        }

        return rowC;
    }
}

/* 3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3 */
