import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i=0; i<num; i++) {
                int n = sc.nextInt();
                int[][] grid = new int[n][n];
                int line = 0;
                int row = 0;
                for (int j=0; j<n; j++) {
                    Set<Integer> set = new HashSet();
                    for (int k=0; k<n; k++) {
                        grid[j][k] = sc.nextInt();
                        set.add(grid[j][k]);
                        line += set.size() == n ? 0 : 1;
                    }
                }
                for (int j=0; j<n; j++) {
                    Set<Integer> set = new HashSet();
                    for (int k=0; k<n; k++) {
                        set.add(grid[k][j]);
                        row += set.size() == n ? 0 : 1;
                    }
                }
                
                String ans = "Case #" + (i+1) + ": ";
                int trace = 0;
                for (int j=0; j<n; j++) {
                    trace += grid[j][j];
                }
                System.out.println(ans + trace + " " + line + " " + row + "\n");
                
            }
        }
    }
}
