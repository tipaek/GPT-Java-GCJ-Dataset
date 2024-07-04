package codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int dim = in.nextInt();
            int[][] matrix = new int[dim][dim];
            int rows = 0;
            int columns = 0;
            int trace = 0;

            for (int m = 0; m < dim; m++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int n = 0; n < dim; n++) {
                    int element = in.nextInt();
                    matrix[m][n] = element;
                    rowSet.add(element);
                    if (m == n) {
                        trace += element;
                    }
                }
                if (rowSet.size() != dim) {
                    rows++;
                }
            }

            for (int n = 0; n < dim; n++) {
                Set<Integer> colSet = new HashSet<>();
                for (int m = 0; m < dim; m++) {
                    colSet.add(matrix[m][n]);
                }
                if (colSet.size() != dim) {
                    columns++;
                }
            }

            System.out.println("Case #" + i + ": " + trace + " " + rows + " " + columns);
        }
    }
}