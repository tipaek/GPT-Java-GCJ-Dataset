import java.util.*;
import java.io.*;
class CodeJamTest {
    int sum = 0;
    int rowSum = 0;
    int colSum = 0;

    public int[] question1(int[][] grid) {
        for (int i = 0, j = 0; i < grid[0].length && j < grid.length; i++, j++) {
            sum += grid[i][j];
        }

        for (int i = 0; i < grid[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < grid.length; j++) {
                set.add(grid[i][j]);
            }
            if(set.size() < grid[0].length){
                rowSum++;
            }
        }
        for (int i = 0; i < grid[0].length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < grid.length; j++) {
                set.add(grid[j][i]);
            }
            if(set.size() < grid[0].length){
                colSum++;
            }
        }

        return new int[]{sum, rowSum, colSum};
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = 0;
            int[][] grid = new int[n][n];
            for(int j=0;j<n;j++) {
                for (int k = 0; k < n; k++) {
                    m = in.nextInt();
                    grid[j][k] = m;
                }
            }
            CodeJamTest obj = new CodeJamTest();
            int[] res = new int[3];
            int index = 0;
            for(int r : obj.question1(grid)){
                res[index++] = r;
            }
            System.out.println("Case #" + i + ": " + res[0] + " " + res[1] + " " + res[2]);
        }
    }
}
