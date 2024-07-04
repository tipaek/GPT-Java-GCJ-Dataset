import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            System.out.print("Case #" + i + ": ");
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            testCase(n, matrix);
        }
    }
    private static void testCase(int n, int[][] matrix) {
        int trace = 0;
        for(int i=0; i<n; i++) {
            trace += matrix[i][i];
        }
        int rows = 0;
        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(set.contains(matrix[i][j])) {
                    rows++;
                    break;
                }
                set.add(matrix[i][j]);
            }
        }
        int cols = 0;
        for(int i=0; i<n; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j=0; j<n; j++) {
                if(set.contains(matrix[j][i])) {
                    cols++;
                    break;
                }
                set.add(matrix[j][i]);
            }
        }
        System.out.print(trace);
        System.out.print(" ");
        System.out.print(rows);
        System.out.print(" ");
        System.out.print(cols);
        System.out.println();
    }
}