import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            for (int j = 0; j < size; ++j) {
                for (int k = 0; k < size; ++k) {
                    matrix[j][k] = in.nextInt();
                }
            }

            int k = 0;
            for (int j = 0; j < size; ++j) {
                k += matrix[j][j];
            }
            int r = 0;
            Set<Integer> elements = new LinkedHashSet<>();

            for (int row = 0; row < size; ++row) {
                for (int column = 0; column < size; column++) {
                    elements.add(matrix[row][column]);
                }
                if (elements.size() < size) {
                    r++;
                }
                elements.clear();
            }
            int c = 0;
            elements.clear();

            for (int column = 0; column < size; ++column) {
                for (int row = 0; row < size; row++) {
                    elements.add(matrix[row][column]);
                }
                if (elements.size() < size) {
                    c++;
                }
                elements.clear();
            }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);
        }
    }
}
