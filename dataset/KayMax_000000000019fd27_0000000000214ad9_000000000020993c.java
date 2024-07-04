import java.util.*;
import java.io.*;

public class Solution {

    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {

        int cases = in.nextInt();

        for(int i = 1; i <= cases; i++) {
            solve(i);
        }
    }

    public static void solve(int num) {

        int size = in.nextInt();
        int[][] matrix = new int[size][size];
        int trace = 0;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrix[i][j] = in.nextInt();
                if(i == j)
                    trace += matrix[i][j];
            }
        }

        int repRows = 0;

        for(int[] row : matrix) {
            Set<Integer> seen = new HashSet<Integer>();
            for(int i : row) {
                seen.add(i);
            }
            if(seen.size() != size)
                repRows++;
        }

        int repCols = 0;

        for(int j = 0; j < size; j++) {
            Set<Integer> seen = new HashSet<Integer>();
            for(int i = 0; i < size; i++) {
                seen.add(matrix[i][j]);
            }
            if(seen.size() != size)
                repCols++;
        }

        System.out.printf("Case #%d: %d %d %d%n", num, trace, repRows, repCols);
    }
}
