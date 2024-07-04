import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();

            Integer[][] matrix = new Integer[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                }
            }
            Vestigium ves = vestigium(matrix);
            System.out.println("Case #"+i+": "+ves.diagonal+" "+ ves.row +" "+ves.column);
        }
    }

    public static Vestigium vestigium(Integer[][] matrix) {
        int diagonal = 0;
        int row = 0;
        int column = 0;

        for (int i = 0; i < matrix.length; i++) {
            diagonal += matrix[i][i];
        }

        for (Integer[] integers : matrix) {
            HashMap map = new HashMap<String, String>();
            for (int j = 0; j < matrix.length; j++) {
                if (map.containsKey(integers[j])) {
                    row++;
                    break;
                }
                map.put(integers[j], integers[j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            HashMap map = new HashMap<String, String>();
            for (int j = 0; j < matrix.length; j++) {
                if (map.containsKey(matrix[j][i])) {
                    column++;
                    break;
                }
                map.put(matrix[j][i], matrix[j][i]);
            }
        }

        return new Vestigium(diagonal, row, column);
    }

}

class Vestigium {
    int diagonal;
    int row;
    int column;

    Vestigium(int diagonal, int row, int column) {
        this.diagonal = diagonal;
        this.row = row;
        this.column = column;
    }
}
