import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for(int t=1; t<=tests; t++) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            int rows = 0;
            int columns = 0;

            for(int i=0; i<n; i++) {
                trace += matrix[i][i];
            }

            for(int i=0; i<n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for(int j=0; j<n; j++) {
                    set.add(matrix[i][j]);
                }
                if(set.size() != n)
                    rows++;
            }

            for(int i=0; i<n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for(int j=0; j<n; j++) {
                    set.add(matrix[j][i]);
                }
                if(set.size() != n)
                    columns++;
            }

            System.out.printf("Case #%d: %d %d %d %n", t, trace, rows, columns);
        }
    }
}
